package org.example.resumeanalyzer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBconnect {
    private static final String URL = "jdbc:mysql://localhost:3306/jobs_database";
    private static final String USER = "root";
    private static final String PASSWORD = "Parayillaaa@1";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static String[] getJobTitles() {
        String query = "SELECT Title FROM jobs";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            return resultSetToArray(resultSet);
        } catch (SQLException e) {
            ErrorHandler.handleSQLException(e);
            return null;
        }
    }

    public static String[] getJobRequirements(String jobTitle) {
        String query = "SELECT Skill1, Skill2, Skill3, Skill4, Skill5 " +
                "FROM jobrequirements WHERE JobID = (SELECT JobID FROM jobs WHERE Title = ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, jobTitle);
            try (ResultSet resultSet = statement.executeQuery()) {
                // Get the number of columns in the ResultSet
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();

                // Create an ArrayList to store the string values
                List<String> values = new ArrayList<>();

                // Iterate through the ResultSet and add each value to the list
                while (resultSet.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        values.add(resultSet.getString(i));
                    }
                }

                // Convert the ArrayList to an array of strings

                return values.toArray(new String[0]);
            }
        } catch (SQLException e) {
            ErrorHandler.handleSQLException(e);
            return null;
        }
    }

    private static String[] resultSetToArray(ResultSet resultSet) throws SQLException {
        List<String> resultList = new ArrayList<>();
        while (resultSet.next()) {
            resultList.add(resultSet.getString(1)); // Assuming there's only one column in the result set
        }
        return resultList.toArray(new String[0]);
    }
}


//class Mainm {
//    public static void main(String[] args) {
//        // Get job titles
//        String[] jobTitles = DBConnect.getJobTitles();
//
//        // Display job titles
//        if (jobTitles != null && jobTitles.length > 0) {
//            System.out.println("Job Titles:");
//            for (String title : jobTitles) {
//                System.out.println(title);
//            }
//        } else {
//            System.out.println("No job titles found.");
//        }
//
//        // Get job requirements for a specific job title
//        String jobTitle = "Software Engineer";
//        String[] jobRequirements = DBConnect.getJobRequirements(jobTitle);
//
//        // Display job requirements
//        if (jobRequirements != null && jobRequirements.length > 0) {
//            System.out.println("\nJob Requirements for " + jobTitle + ":");
//            for (String requirement : jobRequirements) {
//                System.out.println(requirement);
//            }
//        } else {
//            System.out.println("\nNo job requirements found for " + jobTitle);
//        }
//    }
//}

