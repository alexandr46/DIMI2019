package controllers;

import enums.InnerMenuItems;
import models.ListTaskObjectModel;
import models.TackObjectModel;
import java.util.Scanner;

public class TaskObjectController extends AbstractController{

    private static final String PATH = ".//src//com//netcracker//main//resources//file1.xml";

    private final static Scanner SCANNER = new Scanner(System.in);

    public void show(ListTaskObjectModel list){
        System.out.println(InnerMenuItems.LIST.getDescription());
        for (TackObjectModel model: list.getModelList()){
            System.out.println(model);
        }
    }

    public void delete(ListTaskObjectModel list){
        if (list.getModelList().isEmpty()){
            System.out.println(InnerMenuItems.LIST_IS_EMPTY.getDescription());
            return;
        }

        System.out.printf("Длина листа = %d", list.getModelList().size());
        System.out.println();

        String id = getTaskNumber();

        while (!isAbsDigit(id)||list.getModelList().size()<Integer.parseInt(id)){
            System.out.println(InnerMenuItems.REPEAT.getDescription());
            id = SCANNER.nextLine();
        }

        list.getModelList().remove(Integer.parseInt(id));
        System.out.printf("Задачи с номером %s больше не существует\n",id);

        if (list.getModelList().isEmpty()){
            System.out.println(InnerMenuItems.LIST_IS_EMPTY.getDescription());
        }
    }

    public void save(ListTaskObjectModel listTaskObjectModel){
        ListTaskObjectModel.convertObjectToXml(listTaskObjectModel,PATH);
        System.out.println(InnerMenuItems.SAVED_SUCCESSFUL.getDescription());
    }

    public void exit(ListTaskObjectModel list){
        String answer = chooseSavingAction();

        switch (answer){
            case "Д":
                this.save(list);
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
