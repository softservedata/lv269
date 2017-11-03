package Task561.Services;

import java.io.IOException;
import java.util.List;

public interface InputOutput {

    void printToConsole(List<Integer> arrayList);

    Integer readFromConsole() throws IOException;

}
