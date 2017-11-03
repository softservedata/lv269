package com.edu.softserve.task1.minMultiple;

public interface IInputFromSource {
    public boolean isNextNumber();
    public int nextIntFromScanner();
    public String nextStringFromScanner();
    public void closeSource();
}
