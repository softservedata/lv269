package edu.softserve.yuripekelis.pascalTriangle;

import java.io.InputStream;
import java.util.Scanner;

/**
 * This class is for input data from Source
 */
public class InputFromSource implements IInputFromSource {

    /**
     * Variable for Scanner object.
     */
    private Scanner scanner;

    public InputFromSource(InputStream stream) {
        scanner = new Scanner(stream);
    }

    public boolean isNextNumber() {
        return scanner.hasNextInt();
    }

    public int nextIntFromScanner() {
        return scanner.nextInt();
    }

    public String nextStringFromScanner () {
        return scanner.next();
    }

    /**
     * This method is used for closing Scanner.
     */
    public void closeSource() {
        scanner.close();
    }
}
