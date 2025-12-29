<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Delete Teacher</title>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600&display=swap" rel="stylesheet">
        <style>
            body {
                font-family: 'Inter', sans-serif;
                background-color: #f3f4f6;
                margin: 0;
                padding: 40px;
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 80vh;
            }

            .container {
                background-color: #ffffff;
                border-radius: 12px;
                box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
                padding: 40px;
                width: 100%;
                max-width: 400px;
                text-align: center;
            }

            h1 {
                color: #dc2626;
                margin-top: 0;
                font-size: 1.5rem;
            }

            p {
                color: #4b5563;
                margin-bottom: 30px;
                line-height: 1.5;
            }

            .btn-group {
                display: flex;
                justify-content: center;
                gap: 15px;
            }

            .btn {
                padding: 10px 20px;
                border-radius: 6px;
                font-weight: 600;
                text-decoration: none;
                transition: background-color 0.2s;
                border: none;
                cursor: pointer;
                font-size: 1rem;
            }

            .btn-confirm {
                background-color: #dc2626;
                color: white;
            }

            .btn-confirm:hover {
                background-color: #b91c1c;
            }

            .btn-cancel {
                background-color: #e5e7eb;
                color: #374151;
            }

            .btn-cancel:hover {
                background-color: #d1d5db;
            }
        </style>
    </head>

    <body>

        <div class="container">
            <h1>Delete Teacher?</h1>
            <p>Are you sure you want to delete the teacher <strong>"${teacher.name}"</strong>? This action cannot be
                undone.
            </p>

            <div class="btn-group">
                <a href="/teachers/perform-delete/${teacher.id}" class="btn btn-confirm">Yes, Delete</a>
                <a href="/teachers" class="btn btn-cancel">Cancel</a>
            </div>
        </div>

    </body>

    </html>