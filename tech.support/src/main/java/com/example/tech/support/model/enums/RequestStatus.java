package com.example.tech.support.model.enums;

public enum RequestStatus {
    ACCEPTED(1, "Заявка принята"),
    PLANNING(2, "Определение периметра работ"),
    IN_PROGRESS(3, "Выполнение ремонта"),
    FINISHED(4, "Работа завершена");

    private final int id;
    private final String description;

    RequestStatus(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static RequestStatus fromId(int id) {
        for (RequestStatus status : values()) {
            if (status.id == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("Неизвестный статус: statusId = " + id);
    }
}
