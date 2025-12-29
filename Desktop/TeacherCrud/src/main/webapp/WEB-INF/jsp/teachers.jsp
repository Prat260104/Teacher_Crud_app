<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Teacher Management</title>
            <!-- Google Fonts -->
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600&display=swap"
                rel="stylesheet">
            <style>
                body {
                    font-family: 'Inter', sans-serif;
                    background-color: #f3f4f6;
                    margin: 0;
                    padding: 40px;
                    color: #1f2937;
                }

                .container {
                    max-width: 900px;
                    margin: 0 auto;
                    background-color: #ffffff;
                    border-radius: 12px;
                    box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06);
                    padding: 30px;
                }

                h1 {
                    color: #111827;
                    font-weight: 600;
                    margin-bottom: 25px;
                    text-align: center;
                    border-bottom: 2px solid #e5e7eb;
                    padding-bottom: 15px;
                }

                h2 {
                    color: #374151;
                    font-size: 1.25rem;
                    margin-top: 30px;
                    margin-bottom: 15px;
                }

                /* Table Styles */
                table {
                    width: 100%;
                    border-collapse: separate;
                    border-spacing: 0;
                    margin-bottom: 30px;
                    width: 100%;
                }

                th {
                    background-color: #f9fafb;
                    color: #6b7280;
                    font-weight: 500;
                    text-transform: uppercase;
                    font-size: 0.75rem;
                    letter-spacing: 0.05em;
                    padding: 12px 24px;
                    border-bottom: 1px solid #e5e7eb;
                    text-align: left;
                }

                td {
                    padding: 16px 24px;
                    border-bottom: 1px solid #e5e7eb;
                    color: #4b5563;
                }

                tr:last-child td {
                    border-bottom: none;
                }

                tr:hover td {
                    background-color: #f9fafb;
                }

                /* Buttons */
                .btn {
                    display: inline-flex;
                    align-items: center;
                    padding: 6px 12px;
                    border-radius: 6px;
                    font-size: 0.875rem;
                    font-weight: 500;
                    text-decoration: none;
                    transition: background-color 0.2s;
                    margin-right: 8px;
                }

                .btn-edit {
                    background-color: #ecfdf5;
                    color: #059669;
                }

                .btn-edit:hover {
                    background-color: #d1fae5;
                }

                .btn-delete {
                    background-color: #fef2f2;
                    color: #dc2626;
                }

                .btn-delete:hover {
                    background-color: #fee2e2;
                }

                /* Form Styles */
                form {
                    background-color: #f8fafc;
                    padding: 24px;
                    border-radius: 8px;
                    border: 1px solid #e2e8f0;
                }

                label {
                    display: block;
                    margin-bottom: 8px;
                    color: #4b5563;
                    font-weight: 500;
                }

                input[type="text"] {
                    width: 100%;
                    padding: 10px;
                    border: 1px solid #d1d5db;
                    border-radius: 6px;
                    margin-bottom: 20px;
                    font-family: inherit;
                    box-sizing: border-box;
                }

                input[type="text"]:focus {
                    outline: none;
                    border-color: #3b82f6;
                    box-shadow: 0 0 0 2px #93c5fd;
                }

                input[type="submit"] {
                    background-color: #2563eb;
                    color: white;
                    border: none;
                    padding: 12px 20px;
                    border-radius: 6px;
                    font-weight: 600;
                    cursor: pointer;
                    width: 100%;
                    transition: background-color 0.2s;
                }

                input[type="submit"]:hover {
                    background-color: #1d4ed8;
                }
            </style>
        </head>

        <body>

            <div class="container">
                <h1>Teacher Management System</h1>

                <table>
                    <thead>
                        <tr>
                            <th style="width: 10%;">ID</th>
                            <th style="width: 30%;">Teacher Name</th>
                            <th style="width: 40%;">Subject</th>
                            <th style="width: 20%;">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="teacher" items="${teachers}">
                            <tr>
                                <td>#${teacher.id}</td>
                                <td style="font-weight: 500; color: #111827;">${teacher.name}</td>
                                <td>${teacher.subject}</td>
                                <td>
                                    <a href="/teachers/edit/${teacher.id}" class="btn btn-edit">Edit</a>
                                    <a href="/teachers/delete/${teacher.id}" class="btn btn-delete">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty teachers}">
                            <tr>
                                <td colspan="4" style="text-align: center; color: #9ca3af; padding: 30px;">No teachers
                                    found. Add one below!</td>
                            </tr>
                        </c:if>
                    </tbody>
                </table>

                <h2>Add New Teacher</h2>
                <form action="/teachers" method="post">
                    <label for="name">Teacher Name</label>
                    <input type="text" id="name" name="name" placeholder="e.g., Mr. Anderson" required>

                    <label for="subject">Subject</label>
                    <input type="text" id="subject" name="subject" placeholder="e.g., Mathematics" required>

                    <input type="submit" value="Add Teacher">
                </form>
            </div>

        </body>

        </html>