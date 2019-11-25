package controllers;

import enums.InnerMenuItems;
import java.util.Scanner;

public class AbstractController {

    private final static Scanner SCANNER = new Scanner(System.in);

    static String getTaskNumber(){
        System.out.println(InnerMenuItems.ENTER_NUMBER.getDescription());
        return SCANNER.nextLine();
    }

    public static boolean isAbsDigit(String id){
        try {
            return Integer.parseInt(id) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static String chooseSavingAction(){
        System.out.println(InnerMenuItems.CHOOSE_SAVING_ACTION.getDescription());
        return SCANNER.nextLine().toUpperCase();
    }
}
