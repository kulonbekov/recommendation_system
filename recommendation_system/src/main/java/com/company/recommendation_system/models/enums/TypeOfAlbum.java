package com.company.recommendation_system.models.enums;

public enum TypeOfAlbum {

    Work("Работа"),
    Street("Улица"),
    Car("Автомобили");

    String value;

    TypeOfAlbum(String value) {
        this.value = value;
    }
}
