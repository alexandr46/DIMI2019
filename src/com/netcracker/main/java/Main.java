import views.ActionView;
import views.TaskObjectView;

import java.util.Scanner;

public class Main {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Выберите, с чем вы хотите работать:\n 1 - Список задач по дому\n 2 - Список тикетов\n 3 - Выйти");
        String id = SCANNER.nextLine();

            switch (id) {
                case "1":
                    ActionView.actionView();
                    break;
                case "2":
                    TaskObjectView.taskObjectView();
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Нет такого номера");
                    break;
                   }
    }

}
