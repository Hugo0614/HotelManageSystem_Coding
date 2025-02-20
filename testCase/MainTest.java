package testCase;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import project.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testMain() {
        // Set the file path you want to test(change path depending on where you put the file)
        String filePath = "/Users/leonwu/Downloads/KCK test cases/MainTest.txt";


        String input = filePath + "\nY\n"; 


        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        


        assertDoesNotThrow(() -> Main.main(new String[0]));



        System.setIn(System.in);
    }
}