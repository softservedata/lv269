package com.softserve.edu.Task224;

import com.softserve.edu.Task224.Models.Task224;
import com.softserve.edu.Task224.Models.TaskModel;
import com.softserve.edu.Task224.Services.ConsoleWorker;
import com.softserve.edu.Task224.Services.InputOutput;

import java.io.IOException;
import java.util.List;


public class Application {
    TaskModel taskModel = null;
    InputOutput consoleWorker = new ConsoleWorker();

    public void work() throws IOException {
        taskModel = new Task224();
        List<Integer> integers;
        integers = taskModel.numberOperation(consoleWorker.readFromConsole());
        consoleWorker.printToConsole(integers);


    }
}


