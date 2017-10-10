package cn.xiaozhigang.leetcode.easy;

import java.util.List;

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Employee employee = null;
        for (Employee e : employees) {
            if (e.id == id) {
                employee = e;
                break;
            }
        }
        if(employee.subordinates.size() == 0)
            return employee.importance;
        int sum = employee.importance;
        for (int i : employee.subordinates) {
            sum += getImportance(employees,i);
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
