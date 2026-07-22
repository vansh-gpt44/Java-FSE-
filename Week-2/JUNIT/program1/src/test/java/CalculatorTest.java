import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(30, calculator.add(10, 20));
    }

    @Test
    public void testSubtraction() {
        assertEquals(10, calculator.subtract(20, 10));
    }

    @Test
    public void testMultiplication() {
        assertEquals(20, calculator.multiply(5, 4));
    }

    @Test
    public void testDivision() {
        assertEquals(4, calculator.divide(20, 5));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(10, 0);
    }
}
