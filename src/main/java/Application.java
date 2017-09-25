import Models.Task224;
import Models.Task325;
import Models.Task561;
import Models.TaskModel;
import Services.Input;
import Services.Out;
import Services.Scanner;

import java.io.IOException;


public class Application {
    TaskModel taskModel = null;
    String selected ="";
    Out out = new Out();

    public void work() throws IOException {
        boolean flag = true;

        while (flag) {
            System.out.println("***************************");
            System.out.println("press 1 - Tast 224");
            System.out.println("press 2 - Task 325");
            System.out.println("press 3 - Task 561");
            System.out.println("press 0 - Exit");

            selected = Scanner.scanner.readLine();

            switch (selected) {

                case "1":
                    taskModel = new Task224();
                    out.soutArraylist(taskModel.numberOperation(Input.input()));
                    break;
                case "2":
                    taskModel = new Task325();
                    out.soutArraylist(taskModel.numberOperation(Input.input()));
                    break;
                case "3":
                    taskModel = new Task561();
                    out.soutArraylist(taskModel.numberOperation(Input.input()));
                    break;
                case "0":

                    flag = false;
                    break;


                default:
                    break;

            }
        }

    }


}
