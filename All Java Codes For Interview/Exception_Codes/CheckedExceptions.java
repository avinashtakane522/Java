import java.io.*;
import java.sql.SQLException;
import java.text.*;

class CheckedExceptionsExample {
    // IOException example
    public void handleIOException() {
        try {
            FileReader fileReader = new FileReader("file.txt");
            // Code that reads from file
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
            // Handle the exception or log it
        }
    }

    // SQLException example
    // public void handleSQLException() throws SQLException {
    // // Assuming SQLConnection is some class that throws SQLException
    // SQLConnection connection = new SQLConnection();
    // try {
    // connection.connect(); // Example method that throws SQLException
    // } catch (SQLException e) {
    // System.out.println("SQLException occurred: " + e.getMessage());
    // // Handle the exception or throw it to the caller
    // throw e;
    // } finally {
    // connection.close(); // Close resources in finally block
    // }
    // }
    // ClassNotFoundException example
    public void handleClassNotFoundException() {
        try {
            Class.forName("com.example.NonExistentClass");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException occurred: " + e.getMessage());
            // Handle the exception or log it
        }
    }

    // InterruptedException example
    public void handleInterruptedException() {
        try {
            Thread.sleep(1000); // Example of a method that throws InterruptedException
        } catch (InterruptedException e) {
            System.out.println("InterruptedException occurred: " + e.getMessage());
            // Handle the exception or re-interrupt the thread
            Thread.currentThread().interrupt();
        }
    }

    // ParseException example (for SimpleDateFormat)
    public void handleParseException() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.parse("2023-06-15");
        } catch (ParseException e) {
            System.out.println("ParseException occurred: " + e.getMessage());
            // Handle the exception or log it
        }
    }

    public static void main(String[] args) throws SQLException {
        CheckedExceptionsExample example = new CheckedExceptionsExample();
        example.handleIOException();
        // try {
        // example.handleSQLException();
        // } catch (SQLException e) {
        // // Handle SQLException from handleSQLException method
        // e.printStackTrace();
        // }
        example.handleClassNotFoundException();
        example.handleInterruptedException();
        example.handleParseException();
    }
}
