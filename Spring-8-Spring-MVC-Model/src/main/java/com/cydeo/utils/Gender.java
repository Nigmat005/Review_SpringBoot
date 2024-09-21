package com.cydeo.utils;
public enum Gender {
    MALE("Male"),FEMALE("Female");

    public final String genderType;
     private Gender(String genderType){
         this.genderType=genderType;
    }

    public String getGenderType(){
         return this.genderType;
    }
}
