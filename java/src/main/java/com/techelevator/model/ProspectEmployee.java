package com.techelevator.model;

public class ProspectEmployee {

    private int id;
    private String firstName;
    private String lastName;
    private int prospect_dept;


    public ProspectEmployee(){}

    public ProspectEmployee(int id, String firstName, String lastName, int prospect_dept){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.prospect_dept = prospect_dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getProspect_dept() {
        return prospect_dept;
    }

    public void setProspect_dept(int prospect_dept) {
        this.prospect_dept = prospect_dept;
    }

    @Override
    public String toString() {
        return "ProspectEmployee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dept='" + prospect_dept + '\'' +
                '}';
    }
}
