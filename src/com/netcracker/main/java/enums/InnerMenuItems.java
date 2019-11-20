package enums;

public enum InnerMenuItems {
    ENTER_NUMBER("Введите номер задачи"),
    ENTER_DESCRIPTION("Введите описание задачи"),
    LIST_IS_EMPTY("Лист задач пуст"),
    LIST("Лист задач на сегодняшний день:"),
    REPEAT("Пожалуйста, повторите попытку"),
    SAVED_SUCCESSFUL("Успешно сохранено!"),
    CHANGES_UNSAVED("Изменения не сохранены"),
    CHOOSE_SAVING_ACTION("Сохранить составленный список? Д/Н"),
    SESSION_CLOSED("Сеанс работы завершен."),
    PERMITTED_NUMBERS("Доступные номера задач: "),
    ERROR("Непредвиденная ошибка"),
    FILE_DOES_NOT_EXIST("Файл не существует"),
    FILE_HAS_CREATED("Файл создан"),
    WELCOME("Добро пожаловать!");

    private  String description;

    public String getDescription() {
        return description;
    }

    InnerMenuItems(String description) {
        this.description = description;
    }
}
