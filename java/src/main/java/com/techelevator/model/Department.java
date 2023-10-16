package com.techelevator.model;

public class Department {

    private int id;
    private String dept;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", dept='" + dept + '\'' +
                '}';
    }
}
