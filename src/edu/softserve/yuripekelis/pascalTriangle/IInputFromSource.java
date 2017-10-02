package edu.softserve.yuripekelis.pascalTriangle;

public interface IInputFromSource {
    public boolean isNextNumber();
    public int nextIntFromScanner();
    public String nextStringFromScanner();
    public void closeSource();
}
