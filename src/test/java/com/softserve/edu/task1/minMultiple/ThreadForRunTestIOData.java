package com.softserve.edu.task1.minMultiple;

public class ThreadForRunTestIOData extends Thread {

    InputOutputData loopedInput;

    ThreadForRunTestIOData (InputOutputData loopedInputOutputData) {
        super ();
        loopedInput = loopedInputOutputData;
        loopedInput.getNumberFromSource("looped test");
    }



}
