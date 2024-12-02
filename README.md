MaidFinder
This project is a Maid Management System designed to help owners find and hire maids based on location (pincode) and available time slots. It provides features for maid registration and login, as well as owner registration and login. The system ensures that only owners can search for and view available maids in their area.

Features:
Maid Registration & Login:

Maids can register by providing details like username, password, name, house number, mobile number, pincode, and available time slots.
Maids can log in using their credentials (username and password).
Owner Registration & Login:

Owners can register by providing their details (username, password, name, house number, mobile number, and pincode).
Owners can log in to access the system.
Find Maids by Pincode:

Only owners can search for available maids in a specific area (pincode).
The system will return a list of maids with details like name, house number, mobile number, pincode, and available time slots.
Login System:

Both maids and owners have separate login systems to authenticate and access their specific features.
Responsive API:

The project provides a simple RESTful API built with Spring Boot that handles maid and owner registration, login, and maid search by pincode for owners.
Technologies Used:
Backend: Java, Spring Boot
Database: H2 (or any relational database like MySQL or PostgreSQL)
JPA: Java Persistence API (JPA) for database interaction
Spring Security: Optional (if adding more advanced security features in the future)
Postman: For API testing
How to Run:
Clone this repository.
Open the project in your IDE (e.g., IntelliJ IDEA or Eclipse).
Run the Application class (it has the @SpringBootApplication annotation).
The application will start on http://localhost:8083 by default.
Use Postman or any API testing tool to test the login and maid search endpoints.
Example Endpoints:
POST /maid/register: Register a new maid.
POST /maid/login: Maid login.
POST /owner/register: Register a new owner.
POST /owner/login: Owner login.
GET /find-maids-by-pincode: Only owners can search for maids by pincode. Example:
bash
Copy code
http://localhost:8083/find-maids-by-pincode?pincode=560034&userName=anil_patel
