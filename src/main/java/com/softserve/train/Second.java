package com.softserve.train;

public class Second {

    private First first;
    
    public Second() {
        first = new First(){};
        System.out.println("Second()");
    }
    
    public void work() {
        System.out.println("Second.work()");
        first.method();
    }   
}
