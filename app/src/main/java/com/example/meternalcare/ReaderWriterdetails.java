package com.example.meternalcare;

public class ReaderWriterdetails {
    public String doB,gender,mobile;

    public ReaderWriterdetails(){};


    public void ReadWriterUserDetails(String textDoB, String textGender, String textMobile){
        this.doB=textDoB;
        this.gender=textGender;
        this.mobile=textMobile;
    }
}
