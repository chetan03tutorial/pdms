package com.nataraj.management.auction.pdms.model;

import java.util.HashMap;

public class Map {

    public static void main(String[] args) {
        Employee e1 = new Employee(1, "A");
        Employee e2 = new Employee(2, "A");

        Department d1 = new Department(123, "D1");
        Department d2 = new Department(456, "D2");

        java.util.Map<Employee,Department> map = new HashMap<>();
        map.put(e1, d1);
        map.put(e2, d2);
        System.out.println("Size of Map is " + map.size());

        e1.setEmpId(2);

        Employee e3 = new Employee(1, "A"); // null
        Employee e4 = new Employee(2, "A"); // Details of D2
        Employee e5 = new Employee(2, "B"); // null

        System.out.println(map.get(e3)); // Details of D2
        System.out.println(map.get(e4)); // null
        System.out.println(map.get(e5)); // null

        System.out.println(map.size()); // 2

    }
}
