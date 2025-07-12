# 🛡️ JNPA Vigilance Report Forms

A secure web application for **form submission, verification, and approval** workflow built for **JNPA Vigilance**.  
Developed using **Spring Boot**, **MySQL**, **Thymeleaf**, and **Spring Security** with **BCrypt password encryption**.

---

## 🚀 Features

- 🔐 **Secure Login System**
  - User roles: `User`, `HOD`, and `Admin`
  - Encrypted passwords using BCrypt
- 📝 **Form Submission**
  - Multiple form modules related to vigilance operations
  - User fills forms dynamically
- ✅ **Verification Workflow**
  - HOD can view and verify submitted forms
  - Verified forms are forwarded to Admin
- 📄 **Admin Panel**
  - Admin views and manages all forwarded reports

---

## 🧰 Tech Stack

| Layer        | Technology                |
|--------------|---------------------------|
| Backend      | Spring Boot               |
| Frontend     | HTML, CSS, Thymeleaf      |
| Database     | MySQL                     |
| Security     | Spring Security + BCrypt  |
| Template     | Thymeleaf                 |

---

## 🔐 User Roles & Access

| Role  | Access Level |
|-------|--------------|
| User  | Fill & submit forms |
| HOD   | Verify user-submitted forms |
| Admin | View & approve verified forms |

---

## 📂 Folder Structure (Brief)

src/
├── main/
│ ├── java/
│ │ └── com.jnpa.vigilance/
│ │ ├── controller/
│ │ ├── model/
│ │ ├── repository/
│ │ ├── service/
│ │ └── config/
│ └── resources/
│ ├── templates/
│ ├── static/
│ └── application.properties



---

## 🛠️ Setup & Run Locally

1. **Clone the repository**
   ```bash
   git clone https://github.com/VOID/JNPA_Vigilance_report_Forms.git
   cd JNPA_Vigilance_report_Forms


Configure Database

Create a MySQL database (e.g., formsdb)

Update your application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/formsdb
spring.datasource.username=root
spring.datasource.password=yourpassword


Run the App

Open the project in IntelliJ, Eclipse, or VS Code

Run the Spring Boot application

🔒 Security Highlights
Passwords are stored using BCrypt hashing

Role-based access via Spring Security

Prevents unauthorized access to pages based on role

📸 Screenshots
Add screenshots in a screenshots/ folder and embed them here like:

![Login Page](screenshots/login.png)
![User Form](screenshots/form.png)
![HOD Panel](screenshots/hod.png)
![Admin Dashboard](screenshots/admin.png)


📌 Future Improvements
📊 Dashboard with data visualization

📥 Export forms as PDF

📧 Email notifications

🌐 Add multilingual support

👨‍💻 Author
Pranit Mhatre
📧 pranitmhatre1454@gmail.com
🔗 [GitHub](https://github.com/VOID1454)

📝 License
This project is licensed under the MIT License.

