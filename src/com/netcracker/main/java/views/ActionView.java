package views;

import controllers.AbstractController;
import controllers.ActionController;
import enums.InnerMenuItems;
import enums.MenuItems;
import models.ActionModel;

import java.util.Scanner;

public class ActionView {

    private final static Scanner SCANNER = new Scanner(System.in);

    private static MenuItems printMenuAndGetSelectedItem(ActionController actionController) {
        MenuItems result = null;
        do {
            System.out.println(InnerMenuItems.ENTER_NUMBER.getDescription());
            for(MenuItems item: MenuItems.values()) {
                System.out.println((item.ordinal() + 1) + ". " + item.getDescription());
            }
            String selectedItemNumber = SCANNER.nextLine();
            if (AbstractController.isAbsDigit(selectedItemNumber)){
                if (Integer.parseInt(selectedItemNumber) <= MenuItems.values().length) {
                    result = MenuItems.values()[Integer.parseInt(selectedItemNumber) - 1];
                }
            }
        } while (result == null);
        return result;
    }

    public static void actionView(){
        ActionModel actionModel = new ActionModel();
        ActionController actionController = new ActionController();

        System.out.println(InnerMenuItems.WELCOME.getDescription());
        MenuItems action;
        observerLoop:
        while (true){
            action = printMenuAndGetSelectedItem(actionController);
            switch (action){
                case ADD:
                    actionController.create(actionModel);
                    break;
                case REVIEW:
                    actionController.show(actionModel);
                    break;
                case SAVE:
                    actionController.save(actionModel);
                    break;
                case DELETE:
                    actionController.delete(actionModel);
                    break;
                case EXIT:
                    actionController.exit(actionModel);
                    break observerLoop;
                default:
                    System.out.println(InnerMenuItems.ERROR.getDescription());
                    break;
            }
        }
    }

}
