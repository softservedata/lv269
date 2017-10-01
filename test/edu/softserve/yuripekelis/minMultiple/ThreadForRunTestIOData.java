package edu.softserve.yuripekelis.minMultiple;

public class ThreadForRunTestIOData extends Thread {

    InputOutputData loopedInput;

    ThreadForRunTestIOData (InputOutputData loopedInputOutputData) {
        super ();
        loopedInput = loopedInputOutputData;
        loopedInput.getNumberFromSource("looped test");
    }



}
