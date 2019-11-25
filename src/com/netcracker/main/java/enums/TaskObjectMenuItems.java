package enums;

public enum TaskObjectMenuItems {
    SHOW("Показать список тикетов"),
    DELETE("Удалить тикет"),
    SAVE("Сохранить список"),
    EXIT("Завершить работу");

    private String description;

    TaskObjectMenuItems(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
