package controllers;

import enums.InnerMenuItems;
import models.ActionModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActionController implements ActionControllerInterface, Serializable {

    private final static Scanner SCANNER = new Scanner(System.in);
    private static final long serialVersionUID = -106307866978085760L;

    @Override
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


    @Override
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

    @Override
    public void show(ActionModel actionModel) {
        if (!actionModel.getActionMap().isEmpty()){
            System.out.println(InnerMenuItems.LIST.getDescription());
            actionModel.getActionMap().forEach((k, v) -> System.out.println(k+". " + v));
            System.out.println();
        } else {
            System.out.println(InnerMenuItems.LIST_IS_EMPTY.getDescription());
        }
    }

    @Override
    public void save(ActionModel actionModel){
        ActionModel.writeToXML(actionModel.getActionMap());
        System.out.println(InnerMenuItems.SAVED_SUCCESSFUL.getDescription());
    }

    @Override
    public void exit(ActionModel actionModel){
        System.out.println(InnerMenuItems.CHOOSE_SAVING_ACTION.getDescription());
        String answer = SCANNER.nextLine().toUpperCase();
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

    private String getTaskNumber(){
        System.out.println(InnerMenuItems.ENTER_NUMBER.getDescription());
        return SCANNER.nextLine();
    }

    public boolean isAbsDigit(String id){
        try {
            return Integer.parseInt(id) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
