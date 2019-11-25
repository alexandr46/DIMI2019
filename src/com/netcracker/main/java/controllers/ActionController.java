package controllers;

import enums.InnerMenuItems;
import models.ActionModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActionController extends AbstractController {

    private final static Scanner SCANNER = new Scanner(System.in);

    public void create(ActionModel actionModel) {
        String id = getTaskNumber();

        while (actionModel.getActionMap().containsKey(id) || !isAbsDigit(id) ) {
            System.out.println(InnerMenuItems.REPEAT.getDescription());
            id = SCANNER.nextLine();
        }
        System.out.println(InnerMenuItems.ENTER_DESCRIPTION.getDescription());
        String description = SCANNER.nextLine();
        actionModel.getActionMap().put(id,description);
        System.out.printf("Задача №%s - %s добавлена\n\n",id,description);
    }

    public void delete(ActionModel actionModel) {
        if (actionModel.getActionMap().isEmpty()){
            System.out.println(InnerMenuItems.LIST_IS_EMPTY.getDescription());
            return;
        }

        List<String> numbers = new ArrayList<>(actionModel.getActionMap().keySet());
        System.out.print(InnerMenuItems.PERMITTED_NUMBERS.getDescription());
        numbers.forEach(k -> System.out.print(k+" "));
        System.out.println();

        String id = getTaskNumber();

        while (!actionModel.getActionMap().containsKey(id)||!isAbsDigit(id)){
            System.out.println(InnerMenuItems.REPEAT.getDescription());
            id = SCANNER.nextLine();
        }

        actionModel.getActionMap().remove(id);
        System.out.printf("Задачи с номером %s больше не существует\n",id);

        if (actionModel.getActionMap().isEmpty()){
            System.out.println(InnerMenuItems.LIST_IS_EMPTY.getDescription());
        }
    }

    public void show(ActionModel actionModel) {
        if (!actionModel.getActionMap().isEmpty()){
            System.out.println(InnerMenuItems.LIST.getDescription());
            actionModel.getActionMap().forEach((k, v) -> System.out.println(k+". " + v));
            System.out.println();
        } else {
            System.out.println(InnerMenuItems.LIST_IS_EMPTY.getDescription());
        }
    }

    public void save(ActionModel actionModel){
        ActionModel.writeToXML(actionModel.getActionMap());
        System.out.println(InnerMenuItems.SAVED_SUCCESSFUL.getDescription());
    }

    public void exit(ActionModel actionModel){
        String answer = chooseSavingAction();

        switch (answer){
            case "Д":
                this.save(actionModel);
                break;
            case "Н":
                System.out.println(InnerMenuItems.CHANGES_UNSAVED.getDescription());
                break;
            default:
                System.out.println(InnerMenuItems.ERROR.getDescription());
                break;
        }
        System.out.println(InnerMenuItems.SESSION_CLOSED.getDescription());
    }

}
