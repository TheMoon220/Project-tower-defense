package bloons.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.Scanner;

public class InputTest {
    private final InputStream origianlSystemIn = System.in;
    private ByteArrayInputStream testInput;

    @AfterEach 
    public void tearDown(){
        System.setIn(origianlSystemIn);
    }

    private void provideInput(String data){
        testInput = new ByteArrayInputStream(data.getBytes());
        System.setIn(testInput);
    }
}
