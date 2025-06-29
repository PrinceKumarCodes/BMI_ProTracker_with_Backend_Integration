import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.sql.*;

public class SQLDatabaseConnection {

   // Database connection details
    static final String connectionUrl = "jdbc:mysql://localhost:3306/bmi_records_db";
    static final String user = "root";
    static final String spassword = "12345678";

     // User details
    private static String Name;
    private static String Prn;
    private static String Course;
    private static String Gmailid;
    private static String Phone;
    private static int Age;

      // User login credentials
    private static String userid;
    private static String password;

    // Variables for BMI calculation
    private static int weight;
    private static double height;
    private static double BMI;
    private static double BMI_Prime;

    // Variables for new user registration
    private static String newUserId;
    private static String newPassword;

    // Map to store user ID and password
    private static Map<String, String> users = new HashMap<>();
    private static String loggedInUser = null;

    // Constructor to initialize height and weight for BMI calculation
    public SQLDatabaseConnection(double height, int weight) {
        this.height = height;
        this.weight = weight;
    }

     // Method to calculate BMI
    public double calculateBMI() { // Formula for BMI: weight(kg) / (height(m)^2)
        return weight / (height * height);
    }

     // Method to calculate BMI Prime
    public double calculateBMIPrime(double BMI) { 
        return BMI / 25; // BMI Prime is calculated by dividing BMI by 25
    }

    // Display user details and BMI results 
    public void displayResults(double BMI, double BMI_Prime) {

        // Display user details
        System.out.println("-------------User Details---------------------");
        System.out.println("User Name  :" + Name);
        System.err.println("Prn Number :" + Prn);
        System.out.println("Course Name:" + Course);
        System.out.println("Email ID   :" + Gmailid);
        System.out.println("Phone No   :" + Phone);
        System.out.println("Age        :" + Age);
        System.out.println();

        // Display BMI calculation results
        System.err.println("-----------BMI Calculation Results------------");
        System.out.println("Healthy BMI range: [18.5 kg/m2 - 25 kg/m2]\n");
        System.out.println("Your Body Mass Index is  : " + BMI);

        // Categorize BMI into different ranges
        if (BMI < 18.5) {
            System.out.println("You are Underweight ");
        } else if (BMI < 25) {
            System.out.println("You are within a healthy weight range");
        } else if (BMI < 30) {
            System.out.println("You are Overweight");
        } else if (BMI < 35) {
            System.out.println("You are Obese Class I ");
        } else if (BMI < 40) {
            System.out.println("You are Obese Class II ");
        } else {
            System.out.println("You are Obese Class III ");
        }

        // Display BMI Prime
        System.out.println("Your BMI prime  : " + BMI_Prime);
        System.out.println("Please Wait...");

        // Pause the program for 9 seconds
        try {
            Thread.sleep(9000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
   // Generate a random password for new users
    public static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();

    }
// Clear console screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // // Main method - entry point of the program
    public static void main(String[] args) throws Exception {

        // Load MySQL JDBC driver and establish connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(connectionUrl, user, spassword);

        Scanner input = new Scanner(System.in);  // Scanner for user input
        SQLDatabaseConnection calculator = null; // Calculator object for BMI calculation

        // Main loop - keeps running until user decides to exit
        while (true) {

            clearScreen();
            if (loggedInUser == null) {
                // If no user is logged in, display login/registration options
                System.out.println("------------Welcome to BMI Calculator!------------");
                System.out.println("1. New User Registration");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int option = input.nextInt(); // Get user choice

                switch (option) {

                    case 1:
                        // New user registration process
                        clearScreen();
                        System.out.println("New User Registration");

                        System.out.print("Enter Name: ");
                        Name = input.next();
                        System.out.print("Enter Prn:");
                        Prn = input.next();
                        System.out.print("Enter Course Name:");
                        Course = input.next();
                        System.out.print("Enter Email ID: ");
                        Gmailid = input.next();
                        System.out.print("Enter Phone Number: ");
                        Phone = input.next();
                        System.out.print("Enter Age: ");
                        Age = input.nextInt();

                        // Generate user ID and random password
                        newUserId = "user" + ((users.size() + 1)); // Create a new unique user ID
                        newPassword = generateRandomPassword(); // Generate random password
                        users.put(newUserId, newPassword); // Store new user ID and password in users map

                        clearScreen();

                        System.out.println("User registration successful!");
                        System.out.println("Please Wait...");

                          // Pause for 3 seconds
                        try {
                            Thread.sleep(3000); 
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        clearScreen();

                        System.out.println("Please Collect Your UserId and Password!... ");

                        // Pause for 3 seconds before displaying credentials
                        try {
                            Thread.sleep(3000); 
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        clearScreen();
                        System.out.println("User ID: " + newUserId);
                        System.out.println("Password: " + newPassword);
                        System.out.println("Please Wait...");
                        userid = newUserId;
                        password = newPassword;

                        // Pause for 4 seconds before proceeding
                        try {
                            Thread.sleep(4000); 
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 2:
                         // Login process
                        clearScreen();
                        System.out.println("User ID: " + userid);
                        System.out.println("Password: " + password);
                        System.out.println("--------------User Login------------------");
                        System.out.print("Enter User ID: ");
                        String userId = input.next(); // Get user ID input
                        System.out.print("Enter Password: ");
                        String password = input.next(); // Get password input

                        clearScreen();
                        if (users.containsKey(userId) && users.get(userId).equals(password)) {// Check if the entered user ID and password match
                            System.out.println("Login successfully!");
                            System.out.println("Please Wait...");
                            loggedInUser = userId; // Set logged in user
                            try {
                                Thread.sleep(3000); // Pause for 3 seconds
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            // Invalid login credentials
                            clearScreen();
                            System.out.println("Invalid User ID or Password!");
                            System.out.println("Please Wait...");

                            try {
                                Thread.sleep(3000); // Pause for 3 seconds
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 3:
                         // Exit the program
                        clearScreen();
                        System.out.println("Exiting BMI Calculator...");
                        input.close(); //Close scanner 

                        try {
                            Thread.sleep(3000); // Pause  for 3 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        clearScreen();
                        System.out.println("Thanks a lot For Using My Program...");

                        try {
                            Thread.sleep(3000); // Pause for 3 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        clearScreen();

                        System.exit(0); //Exit the program 
                        break;
                    default:
                        //Invalid option entered
                        System.out.println("Invalid Option... ");

                }
            } else {
                clearScreen();

                 // If user is logged in, display options to calculate BMI or log out
                System.out.println("Welcome back, " + loggedInUser + "!");
                System.out.println("1. Calculate BMI");
                System.out.println("2. Logout");
                System.out.print("Enter your choice: ");
                int option = input.nextInt();  // Get user choice


                switch (option) {
                    case 1:
                         // BMI calculation process
                        clearScreen();
                        System.out.print("Please Enter Weight in Kg : ");
                        weight = input.nextInt(); // Get user's weight


                        System.out.print("Please Enter Height in Meters: ");
                        height = input.nextDouble(); // Get user's height

                        clearScreen();

                         // Create a new SQLDatabaseConnection object to calculate BMI
                        calculator = new SQLDatabaseConnection(height, weight);
                        BMI = calculator.calculateBMI(); // Calculate BMI

                        BMI_Prime = calculator.calculateBMIPrime(BMI); // Calculate BMI Prime


                        calculator.displayResults(BMI, BMI_Prime);// Display BMI results

                        // Store user information in the database
                        PreparedStatement sp = con
                                .prepareStatement(
                                        "insert into CalculategitBmiData values('" + newUserId + "','" + newPassword
                                                + "','" + Name
                                                + "','" + Prn + "','" + Course + "','" + Gmailid + "','" + Phone + "','"
                                                + Age + "','" + weight + "','" + height + "','" + BMI
                                                + "','" + BMI_Prime + "')");

                        sp.executeUpdate();  // Execute SQL query to insert data

                        try {
                            Thread.sleep(5000); // Pause for 2 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 2:
                        // Log out the user
                        clearScreen();
                        System.out.println("Logging out...");
                        try {
                            Thread.sleep(3000); // Sleep for 3 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        loggedInUser = null; // Reset logged in user

                        break;

                    default:
                         // Invalid option entered
                        System.out.println("Invalid option... ");
                }
            }
            clearScreen(); // Clear the screen after each iteration
           
        }

    }

}
