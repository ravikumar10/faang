package src.java.problems;

public class Igauge {
    public static void main(String[] args) {
        A a = new B();
        a.m();
    }
}

class A {

    public void m(){
        System.out.println("A");

    }
}


class B extends A{
    public void m(){
        System.out.println("B");
    }
}