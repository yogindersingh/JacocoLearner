import com.bpex.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Calculator Test Suite")
class CalculatorTest {

    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Nested
    @DisplayName("Addition Tests")
    class AdditionTests {
        @Test
        @DisplayName("Adding two positive numbers")
        void testAddPositiveNumbers() {
            assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
        }
        
        @Test
        @DisplayName("Adding a positive and negative number")
        void testAddWithNegative() {
            assertEquals(-1, calculator.add(2, -3), "2 + (-3) should equal -1");
        }
        
        @ParameterizedTest(name = "{0} + {1} = {2}")
        @CsvSource({
            "0, 1, 1",
            "1, 2, 3",
            "-1, -2, -3",
            "5.5, 2.5, 8.0"
        })
        @DisplayName("Parameterized addition tests")
        void testAddParameterized(double a, double b, double expected) {
            assertEquals(expected, calculator.add(a, b),
                () -> a + " + " + b + " should equal " + expected);
        }
    }
    
    @Nested
    @DisplayName("Subtraction Tests")
    class SubtractionTests {
        @Test
        @DisplayName("Subtracting two positive numbers")
        void testSubtractPositiveNumbers() {
            assertEquals(2, calculator.subtract(5, 3), "5 - 3 should equal 2");
        }
        
        @Test
        @DisplayName("Subtracting with negative result")
        void testSubtractToNegative() {
            assertEquals(-1, calculator.subtract(2, 3), "2 - 3 should equal -1");
        }
    }
    
    @Nested
    @DisplayName("Multiplication Tests")
    class MultiplicationTests {
        @Test
        @DisplayName("Multiplying two positive numbers")
        void testMultiplyPositiveNumbers() {
            assertEquals(15, calculator.multiply(3, 5), "3 * 5 should equal 15");
        }
        
        @Test
        @DisplayName("Multiplying by zero")
        void testMultiplyByZero() {
            assertEquals(0, calculator.multiply(5, 0), "5 * 0 should equal 0");
        }
        
        @Test
        @DisplayName("Multiplying negative numbers")
        void testMultiplyNegativeNumbers() {
            assertEquals(15, calculator.multiply(-3, -5), "-3 * -5 should equal 15");
        }
    }
    
    @Nested
    @DisplayName("Division Tests")
    class DivisionTests {
        @Test
        @DisplayName("Dividing two positive numbers")
        void testDividePositiveNumbers() {
            assertEquals(2, calculator.divide(6, 3), "6 / 3 should equal 2");
        }
        
        @Test
        @DisplayName("Division by zero throws exception")
        void testDivideByZero() {
            Exception exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(1, 0),
                "Division by zero should throw IllegalArgumentException");
            assertEquals("Cannot divide by zero", exception.getMessage());
        }
        
        @ParameterizedTest(name = "{0} / {1} = {2}")
        @CsvSource({
            "6, 2, 3",
            "10, 2, 5",
            "-12, 3, -4",
            "15.5, 5, 3.1"
        })
        @DisplayName("Parameterized division tests")
        void testDivideParameterized(double a, double b, double expected) {
            assertEquals(expected, calculator.divide(a, b),
                () -> a + " / " + b + " should equal " + expected);
        }
    }
    
    @Nested
    @DisplayName("Percentage Tests")
    class PercentageTests {
        @Test
        @DisplayName("Calculate valid percentage")
        void testValidPercentage() {
            assertEquals(20, calculator.calculatePercentage(100, 20),
                "20% of 100 should be 20");
        }
        
        @ParameterizedTest
        @ValueSource(doubles = {-1, 101, 150})
        @DisplayName("Invalid percentage values")
        void testInvalidPercentage(double invalidPercentage) {
            assertThrows(IllegalArgumentException.class,
                () -> calculator.calculatePercentage(100, invalidPercentage),
                "Percentage must be between 0 and 100");
        }
    }
}