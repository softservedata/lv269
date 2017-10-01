package edu.softserve.yuripekelis.minMultiple;

public class ThreadTestingLooped extends Thread{

    Thread loopedThread;

    ThreadTestingLooped (Thread threadToTest) {
        loopedThread = threadToTest;
    }

    public boolean isLoopedThreadAlive () throws InterruptedException {
        loopedThread.start();
        this.wait(500);
        boolean isLoopedThreadAlive = loopedThread.isAlive();
        loopedThread.interrupt();
        return isLoopedThreadAlive;
    }
}
