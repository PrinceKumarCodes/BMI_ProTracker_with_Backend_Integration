import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.sql.*;

public class SQLDatabaseConnection {

    // Connect to your database.

    static final String connectionUrl = "jdbc:mysql://localhost:3306/bmi_records_db";
    static final String user = "root";
    static final String spassword = "12345678";

    private static String Name;
    private static String Prn;
    private static String Course;
    private static String Gmailid;
    private static String Phone;
    private static int Age;

    private static String userid;
    private static String password;

    private static int weight;
    private static double height;

    private static double BMI;
    private static double BMI_Prime;

    private static String newUserId;
    private static String newPassword;

    // User ID and Password map
    private static Map<String, String> users = new HashMap<>();
    private static String loggedInUser = null;

    public SQLDatabaseConnection(double height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public double calculateBMI() {
        return weight / (height * height);
    }

    public double calculateBMIPrime(double BMI) {
        return BMI / 25;
    }

    public void displayResults(double BMI, double BMI_Prime) {

        System.out.println("-------------User Details---------------------");
        System.out.println("User Name  :" + Name);
        System.err.println("Prn Number :" + Prn);
        System.out.println("Course Name:" + Course);
        System.out.println("Email ID   :" + Gmailid);
        System.out.println("Phone No   :" + Phone);
        System.out.println("Age        :" + Age);
        System.out.println();
        System.err.println("-----------BMI Calculation Results------------");
        System.out.println("Healthy BMI range: [18.5 kg/m2 - 25 kg/m2]\n");
        System.out.println("Your Body Mass Index is  : " + BMI);

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

        System.out.println("Your BMI prime  : " + BMI_Prime);
        System.out.println("Please Wait...");

        try {
            Thread.sleep(9000); // Sleep for 9 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(connectionUrl, user, spassword);

        Scanner input = new Scanner(System.in);
        SQLDatabaseConnection calculator = null;

        while (true) {

            clearScreen();
            if (loggedInUser == null) {
                System.out.println("------------Welcome to BMI Calculator!------------");
                System.out.println("1. New User Registration");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int option = input.nextInt();

                switch (option) {

                    case 1:
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

                        // Generate user ID
                        newUserId = "user" + ((users.size() + 1));

                        // Generate random password
                        newPassword = generateRandomPassword();
                        users.put(newUserId, newPassword);

                        clearScreen();

                        System.out.println("User registration successful!");
                        System.out.println("Please Wait...");

                        try {
                            Thread.sleep(3000); // Sleep for 3 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        clearScreen();

                        System.out.println("Please Collect Your UserId and Password!... ");

                        try {
                            Thread.sleep(3000); // Sleep for 3 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        clearScreen();
                        System.out.println("User ID: " + newUserId);
                        System.out.println("Password: " + newPassword);
                        System.out.println("Please Wait...");
                        userid = newUserId;
                        password = newPassword;

                        try {
                            Thread.sleep(4000); // Sleep for 3 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 2:
                        clearScreen();
                        System.out.println("User ID: " + userid);
                        System.out.println("Password: " + password);
                        System.out.println("--------------User Login------------------");
                        System.out.print("Enter User ID: ");
                        String userId = input.next();
                        System.out.print("Enter Password: ");
                        String password = input.next();
                        clearScreen();
                        if (users.containsKey(userId) && users.get(userId).equals(password)) {
                            System.out.println("Login successfully!");
                            System.out.println("Please Wait...");
                            loggedInUser = userId;
                            try {
                                Thread.sleep(3000); // Sleep for 3 seconds
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            clearScreen();
                            System.out.println("Invalid User ID or Password!");
                            System.out.println("Please Wait...");

                            try {
                                Thread.sleep(3000); // Sleep for 3 seconds
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 3:
                        clearScreen();
                        System.out.println("Exiting BMI Calculator...");
                        input.close();

                        try {
                            Thread.sleep(3000); // Sleep for 3 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        clearScreen();
                        System.out.println("Thanks a lot For Using My Program...");

                        try {
                            Thread.sleep(3000); // Sleep for 3 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        clearScreen();

                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Option... ");

                }
            } else {
                clearScreen();

                System.out.println("Welcome back, " + loggedInUser + "!");
                System.out.println("1. Calculate BMI");
                System.out.println("2. Logout");
                System.out.print("Enter your choice: ");
                int option = input.nextInt();

                switch (option) {
                    case 1:
                        clearScreen();
                        System.out.print("Please Enter Weight in Kg : ");
                        weight = input.nextInt();

                        System.out.print("Please Enter Height in Meters: ");
                        height = input.nextDouble();

                        clearScreen();

                        calculator = new SQLDatabaseConnection(height, weight);
                        BMI = calculator.calculateBMI();

                        BMI_Prime = calculator.calculateBMIPrime(BMI);

                        calculator.displayResults(BMI, BMI_Prime);

                        PreparedStatement sp = con
                                .prepareStatement(
                                        "insert into CalculategitBmiData values('" + newUserId + "','" + newPassword
                                                + "','" + Name
                                                + "','" + Prn + "','" + Course + "','" + Gmailid + "','" + Phone + "','"
                                                + Age + "','" + weight + "','" + height + "','" + BMI
                                                + "','" + BMI_Prime + "')");

                        sp.executeUpdate();

                        try {
                            Thread.sleep(5000); // Sleep for 2 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;

                    case 2:
                        clearScreen();
                        System.out.println("Logging out...");
                        try {
                            Thread.sleep(3000); // Sleep for 3 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        loggedInUser = null;
                        break;

                    default:
                        System.out.println("Invalid option... ");
                }
            }
            clearScreen();

        }

    }

}
