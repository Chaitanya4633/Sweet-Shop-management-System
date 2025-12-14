# 🍬 Sweet Shop Management System  
**TDD Kata – Full-Stack Application**

---

## 📌 Project Overview

The **Sweet Shop Management System** is a full-stack web application developed as part of the **AI Kata – Sweet Shop Management System** assignment.

The goal of this project is to **design, build, test, and document** a production-style application that demonstrates:

- RESTful API design
- JWT-based authentication & authorization
- Database integration
- Modern frontend development
- Role-based access control (Admin / User)
- Test-Driven Development (TDD)
- Clean coding practices
- Responsible and transparent AI usage

This project was implemented using **Java (Spring Boot)** for the backend and **React** for the frontend.

---

## 🎯 Project Objective

The objective of this project is to design and implement a **secure, scalable, and testable** Sweet Shop Management System that allows:

- Users to browse and purchase sweets
- Admins to manage sweets and inventory
- Secure access to protected resources using JWT
- Clear separation of concerns between backend and frontend

---

## 🧱 Tech Stack

### 🔧 Backend
- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- Spring Data JPA
- Hibernate
- H2 Database (runtime)
- Maven
- JUnit 5

### 🎨 Frontend
- React
- JavaScript (ES6+)
- Fetch API
- CSS (Responsive UI)

---

## 🔐 Authentication & Authorization

### Implemented Features
- User registration (`/api/auth/register`)
- User login (`/api/auth/login`)
- JWT token generation on successful login
- Stateless authentication using JWT
- Role-based access:
  - **USER**: Can view, search, and purchase sweets
  - **ADMIN**: Can add, update, delete, and restock sweets

JWT is stored on the frontend and attached to API requests using the `Authorization: Bearer <token>` header.

---

## 📡 Backend API Endpoints

### 🔑 Auth APIs
| Method | Endpoint | Description |
|------|---------|-------------|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | Login and receive JWT token |

---

### 🍭 Sweets APIs (Protected)

| Method | Endpoint | Access | Description |
|------|---------|--------|-------------|
| GET | `/api/sweets` | User/Admin | Get all sweets |
| GET | `/api/sweets/search` | User/Admin | Search sweets by name |
| POST | `/api/sweets` | Admin | Add new sweet |
| PUT | `/api/sweets/{id}` | Admin | Update sweet |
| DELETE | `/api/sweets/{id}` | Admin | Delete sweet |
| POST | `/api/sweets/{id}/purchase` | User | Purchase sweet |
| POST | `/api/sweets/{id}/restock` | Admin | Restock sweet |

Each sweet contains:
- `id`
- `name`
- `category`
- `price`
- `quantity`

---

## 🧪 Test-Driven Development (TDD)

This project follows **Test-Driven Development principles**, especially for backend business logic.

### Implemented Tests
- SweetService unit tests
- Purchase logic validation
- Inventory update tests
- Repository interaction tests

### TDD Flow Followed
1. **Red** – Write failing test
2. **Green** – Implement minimal logic to pass
3. **Refactor** – Improve code quality

---

## 🖥️ Frontend Application

### Features Implemented

#### 👤 User View
- Login & Logout
- View all sweets
- Search sweets
- Purchase sweets
- Buy button disabled when quantity = 0

#### 🛠️ Admin View
- Add new sweets
- Delete sweets
- Restock sweets
- Admin UI visible only for ADMIN role

Role detection is done by decoding the JWT token on the frontend.

---

## 📷 Screenshots (Proof of Implementation)

> 📌 **These screenshots demonstrate actual working features**

### 🔐 Login & JWT Generation (Postman)
![JWT Token Generation](screenshots/login-token.png)

### 🍭 Fetching Sweets (Protected API)
![Get Sweets](screenshots/get-sweets.png)

### 🔍 Searching Sweets
![Search Sweets](screenshots/search.png)

### 🛠️ Admin Adding Sweet
![Add Sweet](screenshots/add-sweet.png)

### 🗄️ Database (H2 Console)
![H2 Database](screenshots/h2-database.png)

### 🎨 Frontend UI
![Frontend Dashboard](screenshots/frontend-dashboard.png)

---

## ⚙️ How to Run Locally

### Backend
```bash
cd Backend/sweetshop
mvn spring-boot:run
