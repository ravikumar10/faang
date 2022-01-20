package src.java.problems.companies;

public class Sample {
    public static void main(String[] args) {
        B b = new B();
        C c = new C();
    }
}

class A {
    public void p(){
        System.out
                .println("A");
    }
}

class B extends A {
    public void p(){
        System.out
                .println("B");
    }
}
class C extends A {
    public void p(){
        System.out
                .println("C");
    }
}
