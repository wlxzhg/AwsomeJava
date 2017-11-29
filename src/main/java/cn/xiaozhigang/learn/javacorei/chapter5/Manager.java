package cn.xiaozhigang.learn.javacorei.chapter5;

public class Manager extends Employee {
    private double bouns;

    public Manager() {

    }

    public Manager(double salary, String name,double bouns) {
        super(salary, name);
        this.bouns = bouns;
    }

    public double getBouns() {
        return bouns;
    }

    @Override
    public double getSalary() {
        return  bouns + super.getSalary();
    }
}
