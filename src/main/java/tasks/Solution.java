package tasks;

import tasks.dataInputOutput.InputOutputDataFromConsole;
import tasks.logic.Task108;
import tasks.logic.Task331;
import tasks.logic.Task554;

import java.io.IOException;

/**
 * Solution class.
 */
public class Solution {

    public static void main(String[] args) throws IOException {

        InputOutputDataFromConsole data = new InputOutputDataFromConsole();
        int n = data.inputFromConsole();

        Task108 task108 = new Task108();
        data.outputToConsole(task108.getClass().getSimpleName());
        data.outputToConsole(String.valueOf(task108.calc(n)));

        Task331 task331 = new Task331();
        data.outputToConsole(task331.getClass().getSimpleName());
        data.outputToConsole(task331.calc(n));

        Task554 task554 = new Task554();
        data.outputToConsole(task554.getClass().getSimpleName());
        data.outputToConsole(task554.calc(n));

    }
}
