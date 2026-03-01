/**
 * Author Jiah Folvarko
 * Score trakker, organizes and processes scores for students
 */

import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ScoreTrakker {
	
	//Variables
	private ArrayList<Student> students;
	
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt"};
	
	/**
	 * Constructor initializes students makes new student list
	 */
	public ScoreTrakker() {
		students = new ArrayList<Student>();
	}

	
	/**
	 * Reads student data from file and stores it into Arraylist
	 * 
	 * File format: 
	 * two lines per student line 1 is "First Last",
	 * line 2 is the score.
	 * @param fileNamename of file to read
	 * @throws FileNotFoundException if files doesnt exist
	 */
	public void loadDataFile(String fileName) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        try {
            String name = "";
            String line = "";

            while ((name = reader.readLine()) != null) {
                name = name.trim();

                // Read the score line
                line = reader.readLine();

                if (line != null) {
                    line = line.trim();
                    try {
                        int score = Integer.parseInt(line);
                        students.add(new Student(name, score));
                    } catch (NumberFormatException e) {
                        // Report the bad score but continue processing the rest of the file
                        System.out.println("Error: Invalid score for " + name
                                           + " -- \"" + line + "\" is not a number. Skipping.");
                    }
                }
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            e.printStackTrace();
        }
    }

    /**
     * Sorts the ArrayList using Collections.sort(),
     * then prints each student using an for each loop.
     */
    public void printInOrder() {
        Collections.sort(students);

        for (Student s : students) {
            System.out.println(s);
        }
    }

    /**
     * Loops through all files in the files array.
     * Uses a try/catch inside the loop to handle FileNotFoundException.
     * Clears the student list before each file
     */
    public void processFiles() {
        for (String fileName : files) {
            System.out.println("\nProcessing: " + fileName);
            students.clear();   // reset list for each file

            try {
                loadDataFile(fileName);
                printInOrder();
            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found -- \"" + fileName + "\"");
            }
        }
    }

    /**
     * Main method: creates a ScoreTrakker and calls processFiles().
     */
    public static void main(String[] args) {
        ScoreTrakker tracker = new ScoreTrakker();
        tracker.processFiles();
    }
}
