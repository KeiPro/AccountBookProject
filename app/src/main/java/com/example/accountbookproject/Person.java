package com.example.accountbookproject;

import java.io.Serializable;

public class Person implements Serializable
{
    private String name;
    private String gender;
    private String organization;

    public Person(String name, String gender, String organization)
    {
        this.name = name;
        this.gender = gender;
        this.organization = organization;
    }

    @Override
    public String toString() {
        return String.format("이름 : %s\n" +
                "성별 : %s\n"+
                "소속 : %s\n", name, gender, organization);
    }
}
