package cn.xiaozhigang.learn.javacorei.chapter5;

public class ManagerTest {
    public static void main(String[] args) {
        Manager manager = new Manager(10000, "Tom", 5000);
        System.out.println(manager.getName() + "' salary is " + manager.getSalary());
    }
}
