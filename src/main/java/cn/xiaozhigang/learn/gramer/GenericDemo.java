package cn.xiaozhigang.learn.gramer;

public class GenericDemo<T> {
    private T first;
    private T second;

    public GenericDemo() {first=null;second=null;}
    public GenericDemo(T first,T second) {
        this.first = first;
        this.second = second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "first:" + first.toString() + "\nsecond:"+second.toString();
    }

    public static void main(String[] args) {
        GenericDemo<String> stringGenericDemo = new GenericDemo<String>("hello","world");
        System.out.println(stringGenericDemo.toString());
    }
}
