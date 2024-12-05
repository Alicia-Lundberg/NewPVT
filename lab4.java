//implement a program for searching strings in a file
//The minimal requirement is that, given an input command in syntax of “search <pattern> <file>”, the program will print the lines where <pattern> is matched in <file>. 
//For example, “search cat demo.txt”, it should print all lines in demo.txt where the word cat can be found.

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class lab4 {

    public static void main(String[] args) {
        // Check if the input follows the "search <pattern> <file>" syntax
        if (args.length != 3 || !"search".equalsIgnoreCase(args[0])) {
            System.out.println("Usage: search <pattern> <file>");
            return;
        }
        String pattern = args[1];
        String filePath = args[2];

        try {
            searchPatternInFile(pattern, filePath);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Searches for lines containing the specified pattern in the given file.
     * @param pattern  the string pattern to search for
     * @param filePath the path to the file
     * @throws IOException if an error occurs while reading the file
     */
    private static void searchPatternInFile(String pattern, String filePath) throws IOException {
        Path path = Paths.get(filePath);
        // Is the if statement going to work if the filePath is null?
        if (!Files.exists(path)) {
            throw new FileNotFoundException("File not found: " + filePath);
        }
        // Is a try block really necessary here?
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.contains(pattern)) {
                    //System.out.println("Line " + lineNumber + ": " + line);
                    System.out.println("Line " + lineNumber);
                }
            }
        }
    }
}
