package com.example.tech.support.model.enums;

public enum RequestStatus {
    ACCEPTED("Заявка принята"),
    PLANNING("Определение периметра работ"),
    IN_PROGRESS("Выполнение ремонта"),
    FINISHED("Работа завершена");

    private final String description;

    RequestStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
