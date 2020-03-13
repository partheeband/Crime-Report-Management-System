package com.example.crime_report_management_system_miniproject.Java_Classes;

public class MissingReportHelper {

    String image, name, description, address, dresscolor, city, age, gender,uid;

    public MissingReportHelper(){

    }

    public MissingReportHelper(String image, String name, String age, String gender, String city, String dresscolor, String description, String address,String uid) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.age=age;
        this.address=address;
        this.city=city;
        this.dresscolor=dresscolor;
        this.gender=gender;
        this.uid=uid;
    }

    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid=uid;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getDresscolor() {
        return dresscolor;
    }

    public void setDresscolor(String dresscolor) {
        this.dresscolor = dresscolor;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }




    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
