package tasks;

import java.io.IOException;

/**
 * Solution class.
 */
public class Solution {

    public static void main(String[] args) throws IOException {

        OutputData outputData = new OutputData();
        int n = new InputData().inputFromConsole();

        Task108 task108 = new Task108();
        outputData.outputToConsole(task108.getClass().getSimpleName());
        outputData.outputToConsole(String.valueOf(task108.calc(n)));

        Task331 task331 = new Task331();
        outputData.outputToConsole(task331.getClass().getSimpleName());
        outputData.outputToConsole(task331.calc(n));

        Task554 task554 = new Task554();
        outputData.outputToConsole(task554.getClass().getSimpleName());
        outputData.outputToConsole(task554.calc(n));

    }
}
