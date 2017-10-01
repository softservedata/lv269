package edu.softserve.yuripekelis.minMultiple;

public interface IInputFromSource {
    public boolean isNextNumber();
    public int nextIntFromScanner();
    public String nextStringFromScanner();
    public void closeSource();
}
