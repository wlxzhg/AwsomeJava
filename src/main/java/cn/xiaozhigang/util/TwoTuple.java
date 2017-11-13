package cn.xiaozhigang.util;

/**
 * 泛型的一个使用例子，用在想让函数返回两个值的时候
 * */
public class TwoTuple <A,B> {
    public final A first;
    public final B second;

    public TwoTuple(A first,B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ')';
    }
}
