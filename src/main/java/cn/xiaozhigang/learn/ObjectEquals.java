package cn.xiaozhigang.learn;

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

class Manager extends Employee {
    private double bouns;

    public double getBouns() {
        return bouns;
    }

    public double getSalary() {
        return super.getSalary() + bouns;
    }

    public Manager(double salary, String name,double bouns) {
        super(salary,name);
        this.bouns = bouns;
    }
}
public class ObjectEquals {
    public static void main(String[] args) {
        Employee [] employees = new Employee[2];
        employees[0] = new Employee(1000,"Tom");
        employees[1] = new Manager(1200,"John",300);

    }
}
