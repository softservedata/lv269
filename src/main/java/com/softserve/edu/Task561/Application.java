package Task561;

import Task561.Models.Task561;
import Task561.Models.TaskModel;
import Task561.Services.ConsoleWorker;
import Task561.Services.InputOutput;

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
