package org.example;


abstract  class Transport{
    abstract void vehicle();

    public  void  newVehicles(){
        System.out.println("Purchased new Car ");
    }

    public  void  newTest(){
        System.out.println("Don't print");
    }

}


public class AbsClass extends Transport {

    @Override
    void vehicle() {
        System.out.println("Currently using bike ");
    }

    public static void main(String[] args) {
        AbsClass ac = new AbsClass();
        ac.vehicle();
        ac.newVehicles();
    }
}
