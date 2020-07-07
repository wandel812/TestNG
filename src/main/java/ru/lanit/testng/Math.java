package ru.lanit.testng;

public class Math {

    public Object sumTest(Object two, Object tree) {
        System.out.println("Складываем "+ two + " и " + tree);
        int i = (Integer)two + (Integer)tree;
        return i;
    }
}
