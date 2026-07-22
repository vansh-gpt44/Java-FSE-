import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup completed");
    }

    @Test
    public void testAddition() {

        // Arrange
        int firstNumber = 10;
        int secondNumber = 20;

        // Act
        int result = calculator.add(firstNumber, secondNumber);

        // Assert
        assertEquals(30, result);
    }

    @Test
    public void testMultiplication() {

        // Arrange
        int firstNumber = 5;
        int secondNumber = 4;

        // Act
        int result = calculator.multiply(firstNumber, secondNumber);

        // Assert
        assertEquals(20, result);
    }

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Cleanup completed");
    }
}
