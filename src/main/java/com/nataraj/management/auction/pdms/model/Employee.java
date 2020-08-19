package com.nataraj.management.auction.pdms.model;

public class Employee {
    private int empId;
    private String name;

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Employee e = (Employee) obj;
        if(e.getEmpId() == this.getEmpId() && this.getName().equalsIgnoreCase(e.getName()))
            return true;
        else
            return false;

    }
}
