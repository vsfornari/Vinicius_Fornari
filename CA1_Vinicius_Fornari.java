/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1_vinicius_fornari;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author admin
 */
public class CA1_Vinicius_Fornari {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //To read the file provided with students data
            BufferedWriter writer;
            try (BufferedReader reader = new BufferedReader(new FileReader("student.txt"))) {
                writer = new BufferedWriter(new FileWriter("status.txt"));
            //To display the conditions to valid or not to valid the data read from the file
                String line;
                while ((line = reader.readLine()) != null) {
                    if (isValid(line)) {
                        String[] parts = line.split(" ");
                        String studentNumber = parts[0];
                        String lastName = parts[1];
                        int numberOfClasses = Integer.parseInt(parts[2]);
                        String workload = determineWorkload(numberOfClasses);
                        
                        writer.write(studentNumber + " - " + lastName);
                        writer.newLine();
                        writer.write(workload);
                        writer.newLine();
                    } else {
                        System.out.println("Invalid data: " + line);
                    }
                }
            }
            //To catch any exceptions to the valid or not valid format
            writer.close();
        } catch (IOException | NumberFormatException e) {
        }
    }
            //To validate the data from student file
    public static boolean isValid(String data) {
        String[] parts = data.split(" ");
        if (parts.length != 3)
            return false;

        String studentNumber = parts[0];
        String lastName = parts[1];
        String numberOfClassesStr = parts[2];
            //To apply conditions on reading students name and last name
        if (!studentNumber.matches("\\d{2}[a-zA-Z]{1,2}\\d+"))
            return false;

        if (!lastName.matches("[a-zA-Z]+"))
            return false;

        try {
            int numberOfClasses = Integer.parseInt(numberOfClassesStr);
            return numberOfClasses >= 1 && numberOfClasses <= 8;
        } catch (NumberFormatException e) {
            return false;
        }
    }
            //To read students workload and output to status file
    public static String determineWorkload(int numberOfClasses) {
        if (numberOfClasses == 1)
            return "Very Light";
        else if (numberOfClasses >= 2 && numberOfClasses <= 5)
            return "Light";
        else if (numberOfClasses >= 6)
            return "Full Time";
        else
            return "Unknown";
    }
}

        
    
    

