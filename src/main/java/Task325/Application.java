package Task325;

import Task325.Models.Task325;
import Task325.Models.TaskModel;
import Task325.Services.ConsoleWorker;
import Task325.Services.InputOutput;

import java.io.IOException;
import java.util.List;


public class Application {
    TaskModel taskModel = null;

    public void work() throws IOException {
        InputOutput consoleWorker = new ConsoleWorker();

        taskModel = new Task325();
        List<Integer> integers;
        integers = taskModel.numberOperation(consoleWorker.readFromConsole());

        consoleWorker.printToConsole(integers);


    }

}




