package views;

import controllers.TaskObjectController;
import enums.InnerMenuItems;
import enums.MenuItems;
import enums.TaskObjectMenuItems;
import models.ListTaskObjectModel;

import java.util.Scanner;

import static controllers.ActionController.isAbsDigit;

public class TaskObjectView {
    private static final String PATH = ".//src//com//netcracker//main//resources//file.xml";

    private final static Scanner SCANNER = new Scanner(System.in);

    private static TaskObjectMenuItems printMenuAndGetSelectedItem(TaskObjectController controller) {
        TaskObjectMenuItems result = null;
        do {
            System.out.println(InnerMenuItems.ENTER_NUMBER.getDescription());
            for(TaskObjectMenuItems item: TaskObjectMenuItems.values()) {
                System.out.println((item.ordinal() + 1) + ". " + item.getDescription());
            }
            String selectedItemNumber = SCANNER.nextLine();
            if (isAbsDigit(selectedItemNumber)){
                if (Integer.parseInt(selectedItemNumber) <= MenuItems.values().length) {
                    result = TaskObjectMenuItems.values()[Integer.parseInt(selectedItemNumber) - 1];
                }
            }
        } while (result == null);
        return result;
    }

    public static void taskObjectView(){
        ListTaskObjectModel model = ListTaskObjectModel.fromXmlToObject(PATH);
        TaskObjectController taskController = new TaskObjectController();

        System.out.println(InnerMenuItems.WELCOME.getDescription());
        TaskObjectMenuItems action;
        observerLoop:
        while (true){
            action = printMenuAndGetSelectedItem(taskController);
            switch (action){
                case SHOW:
                    taskController.show(model);
                    break;
                case SAVE:
                    taskController.save(model);
                    break;
                case DELETE:
                    taskController.delete(model);
                    break;
                case EXIT:
                    taskController.exit(model);
                    break observerLoop;
                default:
                    System.out.println(InnerMenuItems.ERROR.getDescription());
                    break;
            }
        }
    }

}
