# BMI Calculator with MySQL Database Integration

# Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Usage](#usage)
- [Database Setup](#database-setup)
- [How the Program Works](#how-the-program-works)
- [Program Workflow](#program-workflow)
- [Contributing](#contributing)
 

---

# Introduction

This **BMI Calculator** is a Java-based application that calculates the **Body Mass Index (BMI)** and **BMI Prime** for a user based on their weight and height. The program also integrates with a **MySQL database** to store user details, including registration information, login credentials, and BMI results. The application includes functionalities such as **user registration**, **user login**, **BMI calculation**, and **data storage** for future reference.

# Features

- **User Registration**:-
   Allows users to register with personal information like name, PRN, email, course, phone number, and age. The system generates a **unique user 
   ID** and a **random password** for each user.
  
- **Login System**:-
   Registered users can log in using their assigned user ID and password.
  
- **BMI Calculation**:-
   Users can calculate their BMI by entering weight and height. The system also calculates the **BMI Prime** based on the BMI result.
  
- **Health Classification**:-
   After calculating BMI, users are informed of their weight status (e.g., Underweight, Healthy, Overweight, Obese Class I-III).
  
- **Data Persistence**:-
   All user details and BMI results are stored in a **MySQL database** for easy retrieval in future sessions.
  
- **Console-based Interface**:-
   Simple text-based interface for ease of use, with console clearing for a cleaner experience.
  
- **Secure Random Password Generation**:-
   Automatically generates an 8-character password upon registration.
  
- **Session Handling**:-
   The application tracks whether a user is logged in and allows users to log out.

# Technologies Used

- **Java**:-  Programming language for application logic.
  
- **JDBC (Java Database Connectivity)**:-  Used for connecting Java to the MySQL database.
  
- **MySQL**:-  Database to store user information and BMI data.
  
- **SQL**:-  For database interaction.
  
- **Scanner**:-  For taking user input through the console.
  
- **MySQL Connector/J**:-  JDBC driver for MySQL connections.



