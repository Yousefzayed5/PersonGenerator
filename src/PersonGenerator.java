import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<String> personData = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String fileName;

        //Prompt user for input
        System.out.println("Enter the data for each person, one line at a time:");
        String input = sc.nextLine();
        while (!input.equals("")) {
            personData.add(input);
            input = sc.nextLine();
        }

        //Prompt user for file name
        System.out.println("Enter a file name to save the data:");
        fileName = sc.nextLine();

        //Write data to file
        try {
            FileWriter fw = new FileWriter(new File(fileName));
            for (String line : personData) {
                fw.write(line + "\n");
            }
            fw.close();
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file " + fileName);
        }
    }

    JFileChooser fileChooser = new JFileChooser();


    {
        File file = fileChooser.getSelectedFile();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                System.out.format("ID: %s, First name: %s, Last name: %s, Title: %s, Year of birth: %s\n", data[0], data[1], data[2], data[3], data[4]);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file " + file.getName());
        }

    }
}