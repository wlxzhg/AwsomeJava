package cn.xiaozhigang.learn.javacorei.chapter5;

public class Employee {
    private double salary;
    private String name;

    public Employee() {

    }

    public Employee(double salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}
