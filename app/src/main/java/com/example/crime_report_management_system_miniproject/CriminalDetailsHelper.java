package com.example.crime_report_management_system_miniproject;
public class CriminalDetailsHelper {

    public String name, age,identificatinMark,id, type, rating, arrestedDate,imprisionedYears,prisonCellId;

    public CriminalDetailsHelper(){

    }

    public CriminalDetailsHelper(String name, String age, String identificatinMark,String id, String type, String rating, String arrestedDate, String imprisionedYears,String prisonCellId) {
        this.name = name;
        this.age= age;
        this.identificatinMark= identificatinMark;
        this.id= id;
        this.type= type;
        this.rating=rating;
        this.arrestedDate=arrestedDate;
        this.imprisionedYears=imprisionedYears;
        this.prisonCellId=prisonCellId;
    }
}