package com.softserve.edu.Task561;



import  com.softserve.edu.Task561.Models.*;
import  com.softserve.edu.Task561.Models.TaskModel;
import com.softserve.edu.Task561.Services.*;

import java.io.IOException;
import java.util.List;


public class Application {

    TaskModel taskModel = null;

    public void work() throws IOException {
        InputOutput consoleWorker = new ConsoleWorker();

        taskModel = new Task561();
        List<Integer> integers;
        integers = taskModel.numberOperation(consoleWorker.readFromConsole());

        consoleWorker.printToConsole(integers);


    }


}
