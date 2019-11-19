package enums;

public enum MenuItems  {
    ADD("Добавить"),
    REVIEW("Отобразить"),
    SAVE("Сохранить"),
    DELETE("Удалить"),
    EXIT("Выход");

    private  String description;

    public String getDescription() {
        return description;
    }

    MenuItems(String description) {
        this.description = description;
    }
}
