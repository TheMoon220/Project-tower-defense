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

    @Test 
    public void testReadStringWithNumber(){
        String input = "123abc";
        provideInput(input + "\n");
        String result = Input.readString();
        assertEquals("123abc", result);
    }

    @Test 
    public void testReadInt() throws IOException{
        int expected = 42;
        provideInput(expected + "\n");
        int result = Input.readInt();
        assertEquals(expected, result);
    }

    @Test 
    public void testReadIntNegative() throws IOException{
        int expected = -100;
        provideInput(expected + "\n");
        int result = Input.readInt();
        assertEquals(expected, result);
    }

    @Test 
    public void testReadIntZero() throws IOException {
        int expected = 0;
        provideInput(expected + "\n");
        int result = Input.readInt();
        assertEquals(expected, result);
    }

    @Test 
    public void testReadIntLargeNumber() throws IOException {
        int expected = 999999;
        provideInput(expected + "\n");
        int result = Input.readInt();
        assertEquals(expected, result);
    }

    @Test 
    public void testReadIntInvalidInput(){
        provideInput("abc\n");
        assertThrows(IOException.class, () -> { Input.readInt();});
    }

    @Test 
    public void testReadIntWithDecimal(){
        provideInput("3.14\n");
        assertThrows(IOException.class, () -> { Input.readInt();});
    }
}
