# =============================================
# SQL + LLM Querying System (LangChain + OpenAI/HuggingFace)
# =============================================

from dotenv import load_dotenv
from langchain_core.prompts import ChatPromptTemplate
from langchain_core.output_parsers import StrOutputParser
from langchain_core.runnables import RunnablePassthrough
from langchain_community.utilities import SQLDatabase
from langchain_openai import ChatOpenAI
from langchain_huggingface import ChatHuggingFace, HuggingFaceEndpoint

# =============================================
# 1️⃣ Load Environment Variables
# =============================================
load_dotenv()

# =============================================
# 2️⃣ Database Initialization
# =============================================
DB_PATH = "sqlite:///Chinook.db"
db = SQLDatabase.from_uri(DB_PATH, sample_rows_in_table_info=0)

def get_schema(_=None):
    """Fetch and return database schema."""
    return db.get_table_info()

def run_query(query: str):
    """Execute a SQL query and return results."""
    print(f"\n🔍 Running Query:\n{query}\n")
    return db.run(query)

# Uncomment for debugging
# print(get_schema())

# =============================================
# 3️⃣ LLM Selection (OpenAI / HuggingFace)
# =============================================
def get_llm(use_huggingface=False):
    """Return either an OpenAI GPT model or HuggingFace model."""
    if use_huggingface:
        hf_model = HuggingFaceEndpoint(
            repo_id="Qwen/Qwen2.5-VL-7B-Instruct",
            task="text-generation",
            provider="hyperbolic",
        )
        return ChatHuggingFace(llm=hf_model)

    # Default: GPT-4 (set temperature=0 for deterministic output)
    return ChatOpenAI(model="gpt-4", temperature=0.0)

# =============================================
# 4️⃣ Query Generation from User Question
# =============================================
def write_sql_query(llm):
    """Convert a natural language question into a SQL query."""
    template = """Based on the table schema below, write a SQL query that would answer the user's question:
    {schema}

    Question: {question}
    SQL Query:"""

    prompt = ChatPromptTemplate.from_messages([
        (
            "system",
            "Given an input question, convert it to a SQL query. "
            "Return only the SQL query — no preamble, quotes, or SQL keyword prefix."
        ),
        ("human", template),
    ])

    return (
        RunnablePassthrough.assign(schema=get_schema)
        | prompt
        | llm
        | StrOutputParser()
    )

# =============================================
# 5️⃣ Generate Natural Language Answer
# =============================================
def answer_user_query(question: str, llm):
    """Generate a natural language answer for user's question."""
    response_template = """Based on the table schema, question, SQL query, and SQL response, write a natural language response:
    {schema}

    Question: {question}
    SQL Query: {query}
    SQL Response: {response}"""

    prompt_response = ChatPromptTemplate.from_messages([
        ("system", "Given a question and SQL response, produce a concise natural language answer."),
        ("human", response_template),
    ])

    full_chain = (
        RunnablePassthrough.assign(query=write_sql_query(llm))
        | RunnablePassthrough.assign(
            schema=get_schema,
            response=lambda x: run_query(x["query"]),
        )
        | prompt_response
        | llm
    )

    return full_chain.invoke({"question": question})

# =============================================
# 6️⃣ Main Execution
# =============================================
if __name__ == "__main__":
    llm = get_llm(use_huggingface=False)
    
    # Natural language question to SQL + answer
    user_query = "Give some Tracks by the Artist name Audioslave"
    response = answer_user_query(user_query, llm)
    print("\n💬 AI Response:\n", response.content)

    # Example of direct SQL execution
    manual_query = """
    SELECT Track.Name 
    FROM Track 
    JOIN Album ON Track.AlbumId = Album.AlbumId 
    JOIN Artist ON Album.ArtistId = Artist.ArtistId 
    WHERE Artist.Name = 'Audioslave';
    """
    direct_response = run_query(manual_query)
    print("\n🎵 SQL Query Result:\n", direct_response)
