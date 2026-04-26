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

    @Test 
    public void testReadString(){
        String expected = "Hello";
        provideInput(expected + "\n");
        String result = Input.readString();
        assertEquals(expected, result);
    }

    @Test 
    public void testReadStringWithMultipleWoards(){
        String input = "Hello World";
        provideInput(input + "\n");

        String result = Input.readString();
        assertEquals("Hello", result);
    }
}
