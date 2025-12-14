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
<img width="1236" height="957" alt="Screenshot 2025-12-14 102045" src="https://github.com/user-attachments/assets/1f179498-eba4-4200-a6a2-127cdc8768c1" />
<img width="1226" height="960" alt="Screenshot 2025-12-14 102223" src="https://github.com/user-attachments/assets/2d0084f4-4f94-4075-8452-a0e8f5aa1893" />



### 🍭 Fetching Sweets (Protected API)
<img width="1920" height="1080" alt="Screenshot 2025-12-14 121117" src="https://github.com/user-attachments/assets/326b1f04-2543-403e-a0ff-dfaca9152710" />
<img width="1920" height="1080" alt="Screenshot 2025-12-14 133953" src="https://github.com/user-attachments/assets/4cead414-6d17-4503-9ee4-7179ac8731a0" />


### 🔍 Searching Sweets
![Search Sweets](screenshots/search.png)
<img width="1920" height="1080" alt="Screenshot 2025-12-14 101009" src="https://github.com/user-attachments/assets/fb7ab79f-5f20-4590-b676-2b48bba5cf7d" />


### 🛠️ Admin Adding Sweet
<img width="1012" height="899" alt="Screenshot 2025-12-14 164124" src="https://github.com/user-attachments/assets/fd4d0f46-6da7-484d-877e-08376ab1d7a4" />


### 🗄️ Database (H2 Console)
<img width="1920" height="1080" alt="Screenshot 2025-12-14 133953" src="https://github.com/user-attachments/assets/4708f43e-18cb-43dd-8601-c219d5d2be5f" />
<img width="1920" height="1080" alt="Screenshot 2025-12-14 134050" src="https://github.com/user-attachments/assets/49667ab7-68cf-44ec-b0bd-388987516f8a" />



### 🎨 Frontend UI
<img width="1920" height="1080" alt="Screenshot 2025-12-14 180748" src="https://github.com/user-attachments/assets/a5d26ed0-6bf7-4b1b-930e-79f21bb0cad3" />
<img width="1532" height="618" alt="Screenshot 2025-12-14 154114" src="https://github.com/user-attachments/assets/3a9475c8-1ce8-46cd-a490-50f371405241" />



---

## ⚙️ How to Run Locally

### Backend
```bash
cd Backend/sweetshop
mvn spring-boot:run
