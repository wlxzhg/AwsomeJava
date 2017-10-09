package cn.xiaozhigang.learn.gramer;

import java.util.Arrays;
class Employee implements Comparable<Employee>{
    private double salary;
    private String name;

    public Employee(double salary,String name) {
        this.salary = salary;
        this.name = name;
    }

    public boolean equals(Object otherObject) {
        if(this == otherObject) return true;

        if(otherObject == null) return false;

        if(getClass() != otherObject.getClass()) return false;

        Employee other = (Employee)otherObject;

        return salary == other.getSalary() && name.equals(((Employee) otherObject).getName());
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Employee other) {
        return Double.compare(salary,other.salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }
}

public class ArraysSortDemo {
    public static void main(String[] args) {
        int [] intArr = {4,9,0,1,-2};
        System.out.println(Arrays.toString(intArr));
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));
        Arrays.sort(intArr);

        Employee[] employees = new Employee[3];
        employees[0] = new Employee(5000,"tom");
        employees[1] = new Employee(16000,"xiao");
        employees[2] = new Employee(14000,"chen");
        System.out.println(Arrays.toString(employees));
        Arrays.sort(employees);
        System.out.println(Arrays.toString(employees));
    }
}
