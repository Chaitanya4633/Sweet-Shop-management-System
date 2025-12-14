📦 Sweet Shop Management System 🍬

AI Kata – Full Stack Assignment

A full-stack Sweet Shop Management System built using Spring Boot and React, implementing JWT-based authentication, secure REST APIs, search functionality, and inventory purchase flow, following modern development practices.

🚀 Project Objective

The goal of this project is to design, build, and test a full-stack Sweet Shop Management System that demonstrates:

Backend API design

Authentication & authorization using JWT

Database integration

Frontend UI with API integration

Clean code practices

Git workflow

Responsible AI usage

This project was implemented as part of the AI Kata – Sweet Shop Management System assignment.

🧩 Tech Stack
Backend

Java 17

Spring Boot

Spring Security

JWT (JSON Web Tokens)

Spring Data JPA

H2 Database (runtime)

Maven

Frontend

React

JavaScript (ES6+)

Fetch API

CSS

🔐 Authentication & Security

Users can register and log in

JWT token is generated on successful login

Token is required to access protected APIs

Stateless authentication (no server sessions)

Passwords are stored securely using BCrypt hashing

📡 Backend API Endpoints
🔓 Auth APIs
Method	Endpoint	Description
POST	/api/auth/register	Register a new user
POST	/api/auth/login	Login and receive JWT
🔒 Sweets APIs (Protected)
Method	Endpoint	Description
GET	/api/sweets	Get all sweets
GET	/api/sweets/search?q=	Search sweets by name
POST	/api/sweets	Add a new sweet
DELETE	/api/sweets/{id}	Delete a sweet
POST	/api/sweets/{id}/buy	Purchase a sweet (decrease quantity)

Each sweet has:

id

name

category

price

quantity

🖥️ Frontend Features

User Login screen

JWT stored securely in browser

View all sweets

Search sweets by name

Buy sweets (quantity decreases)

Logout functionality

Protected routes (cannot access without login)

🧪 Testing

Backend service logic tested using JUnit

Service-level tests follow Red → Green → Refactor approach

Manual API verification using Postman

Application behavior validated end-to-end

🗂️ Project Structure
Sweet Shop Management System
│
├── Backend/
│   └── sweetshop/
│       ├── controller/
│       ├── service/
│       ├── repository/
│       ├── model/
│       ├── config/
│       └── test/
│
└── Frontend/
    └── myapp/
        ├── src/
        │   ├── pages/
        │   ├── api/
        │   ├── Sweets.js
        │   └── App.js

▶️ How to Run Locally
Backend
cd Backend/sweetshop
mvn spring-boot:run


Backend runs on:

http://localhost:8080

Frontend
cd Frontend/myapp
npm install
npm start


Frontend runs on:

http://localhost:3000

📸 Screenshots

✔ Login successful
✔ Sweets list displayed
✔ Search functionality
✔ Buy button updates quantity
✔ Logout working

(Screenshots can be added if required)

🤖 My AI Usage (MANDATORY SECTION)
AI Tools Used

ChatGPT

How AI Was Used

Generated initial boilerplate for controllers and services

Helped debug Spring Security & JWT issues

Assisted in structuring React components

Helped reason through authentication and API integration errors

Reflection

AI significantly accelerated debugging and learning.
However, all logic decisions, integration fixes, and final implementations were understood, validated, and corrected manually.

AI was used as a pair-programming assistant, not as a copy-paste solution.

🧠 Key Learnings

Implementing JWT authentication end-to-end

Debugging Spring Security filters

Handling protected routes in React

Managing state across frontend and backend

Importance of clean Git history and incremental commits

📌 Deliverables Checklist (Client PDF)

✅ Backend REST API
✅ JWT Authentication
✅ Database integration
✅ Frontend SPA
✅ Search functionality
✅ Purchase flow
✅ Git repository
✅ README documentation
✅ AI usage disclosure

🏁 Final Note

This project reflects real-world debugging, integration challenges, and problem-solving, not a tutorial copy.
