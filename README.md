# 🎓 Smart Placement Preparation Portal

A cloud-based full-stack web application that provides students with a centralized platform for placement preparation. The portal combines aptitude practice, coding resources, core computer science subjects, resume building, mock interviews, and placement updates into one easy-to-use platform.

---

## 📖 Overview

Students often rely on multiple websites for placement preparation, making the learning process unorganized and time-consuming.

The **Smart Placement Preparation Portal** solves this problem by bringing everything together in one platform. It offers structured learning resources, mock tests, interview preparation, resume building, and placement updates while being deployed on AWS Cloud for secure and scalable access.

---

## ✨ Features

- 📚 Aptitude & Reasoning Practice
- 💻 Coding & Data Structures Resources
- 📖 Core Computer Science Subjects
- 🤖 AI & Emerging Technologies
- 📄 Resume Builder
- 📝 Mock Tests
- 🎤 Interview Preparation
- 👥 Community Discussion
- 📢 Placement Updates
- ☁️ AWS Cloud Deployment

---

## 🏗️ System Architecture

```
                 User
                   │
                   ▼
        React.js Frontend (Vite)
                   │
             REST API Calls
                   │
                   ▼
        Spring Boot Backend
                   │
        Spring Data JPA
                   │
                   ▼
        PostgreSQL Database

Deployment:
EC2 (Ubuntu)
│
├── Nginx Reverse Proxy
├── Elastic IP
├── VPC
└── Security Groups
```

---

## 🛠️ Tech Stack

### Frontend
- React.js
- Vite
- HTML5
- CSS3
- JavaScript

### Backend
- Spring Boot
- Java
- REST APIs

### Database
- PostgreSQL

### Cloud & DevOps
- AWS EC2
- Ubuntu Linux
- Nginx
- Elastic IP
- VPC
- Security Groups

### Version Control
- Git
- GitHub

---

## ☁️ AWS Services Used

| Service | Purpose |
|----------|----------|
| Amazon EC2 | Hosts the application |
| Ubuntu | Operating System |
| Elastic IP | Static Public IP |
| VPC | Secure Network |
| Security Groups | Firewall |
| Nginx | Reverse Proxy |
| SSH | Remote Server Access |

---

## 📂 Project Structure

```
Smart-Placement-Portal
│
├── frontend/
│   ├── src/
│   ├── public/
│   └── package.json
│
├── backend/
│   ├── src/main/java
│   ├── src/main/resources
│   ├── pom.xml
│   └── application.properties
│
├── database/
│
├── screenshots/
│
└── README.md
```

---

## 🚀 Installation

### Clone Repository

```bash
git clone https://github.com/your-username/Smart-Placement-Portal.git
```

---

### Frontend

```bash
cd frontend

npm install

npm run dev
```

---

### Backend

```bash
cd backend

mvn clean install

mvn spring-boot:run
```

---

### Database

Create a PostgreSQL database.

Update

```
application.properties
```

with

```
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```

---

## Deployment

Deploy the backend on an AWS EC2 Ubuntu instance.

Steps:

- Launch EC2 Instance
- Connect using SSH
- Install Java
- Install Maven
- Install Nginx
- Clone Repository
- Build Spring Boot Project
- Run JAR File
- Configure Nginx
- Associate Elastic IP

---

## Screenshots

### Home Page

(Add Screenshot)

### Login

(Add Screenshot)

### Resume Builder

(Add Screenshot)

### Mock Test

(Add Screenshot)

### Placement Updates

(Add Screenshot)

---

## Future Enhancements

- AI Career Guidance
- AI Resume Analysis
- ATS Resume Score
- Online Coding Compiler
- Company-specific Preparation
- Mobile Application
- Notification System
- Analytics Dashboard
- Admin Panel
- Chatbot Assistant

---

## Learning Outcomes

This project helped us gain practical experience in

- Full Stack Development
- REST API Development
- React.js
- Spring Boot
- PostgreSQL
- AWS Cloud Deployment
- Linux Administration
- Git & GitHub
- DevOps Fundamentals

---

## Team Members

- Tirumanadham Murali Krishna
- Kapileswarapu Prasad
- Uddisapu Ramcharan
- Sunkara Ambika Naga Srivalli
- Kurasala Sri Naga Lakshmi Parvathi
- Devaguptapu Pavani
- Chavvakula Purnima Sai Lakshmi

---

## Acknowledgement

This project was developed as part of the **Summer Internship Program on AWS** under the guidance of **APSSDC**.

---

## License

This project is developed for educational purposes.

---

## ⭐ If you like this project

Please consider giving it a ⭐ on GitHub.
