# BMI Calculator with MySQL Database Integration

# Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [How the Program Works](#how-the-program-works)
- [Program Workflow](#program-workflow)
 

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


# How the Program Works


**Registration:-**

- Users enter their name, PRN, course name, email, phone number, and age.
  
- The program generates a unique user ID and a random password, which are displayed and stored in the database.
  

**Login:-**

- Users can log in by entering their user ID and password.

- If the credentials are valid, the user is granted access to calculate their BMI.


**BMI Calculation:-**


- Users input their weight and height.
  
- The program calculates their BMI using the formula: BMI = weight / (height * height).
  
- The BMI Prime is calculated as BMI / 25.


**Health Classification:-**


- The program classifies the user’s BMI into categories such as Underweight, Healthy, Overweight, or Obese Class I-III.
  
- BMI Prime is also displayed.


**Data Storage:-**

- User details and BMI results are stored in a MySQL database for future reference.


**Logout:-**

- The user can log out, ending their session.



# Program Workflow


**New User Registration:-**

- The user inputs their details (name, PRN, etc.).
  
- The system generates a user ID and password, which are displayed on the console.

**User Login:-**

- Users log in using their user ID and password.
  
- Upon successful login, they can calculate their BMI.

**BMI Calculation:-**

- The user inputs their weight and height.
  
- The program calculates and displays the BMI, BMI Prime, and health category.

**Logout:-**

- The user can log out, ending the session.

  
