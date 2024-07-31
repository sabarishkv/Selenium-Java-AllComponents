package org.example;


interface Quality{
    public  void  testing();
    int test = 10;

   // public  void newTest();
}
public class InterClass implements  Quality {


    public  void testing(){
        int test1 = InterClass.test;
        System.out.println("Testing interfaces");


    }

    public static void main(String[] args) {
        InterClass ic = new InterClass();
        ic.testing();
    }
}
