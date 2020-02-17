package com.uber.www;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HierarchyTest {
    public static void main(String[] args) {
        System.out.println("Hello, World");

    }

    public List<Employee> getChain(List<Employee> employees, Employee target) {
        final Employee ceo = findRoot(employees); // Node 1
        final List<Employee> chain = new ArrayList<Employee>();
        final boolean found = isSame(ceo, target, chain); // ln n O(n)
        return chain;
    }

    public boolean isSame(Employee src, Employee target, List<Employee> list) {
        if (src.equals(target)) {
            return true;
        }
        list.add(src); // list 1 +3
        if (src.reports != null) {
            for (final Employee ee : src.reports) {
                if (isSame(ee, target, list)) {
                    return true;
                }
            }
        }
        list.remove(list.size() - 1); // list 1 + 3
        return false;
    }

    public Employee findRoot(List<Employee> employees) { // O(n)
        final List<Employee> employeesCopy = new ArrayList<Employee>();
        employeesCopy.addAll(employees);
        final Set<Employee> set = new HashSet<Employee>();
        for (final Employee emp : employeesCopy) {
            if (emp.reports != null) {
                set.addAll(emp.reports);
            } else {
                set.add(emp);
            }
        }
        for (final Employee emp : set) {
            employeesCopy.remove(emp);
        }
        return employeesCopy.get(0);
    }
}


class Employee {
    String         name;
    List<Employee> reports;
}

