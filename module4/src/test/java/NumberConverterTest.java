import com.cocomm.NumberConverter;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Number Converter Tests")
class NumberConverterTest {
    
    private NumberConverter converter;
    
    @BeforeEach
    void setUp() {
        converter = new NumberConverter();
    }
    
    @ParameterizedTest(name = "Converting {0} should return {1}")
    @CsvSource({
        "1, one",
        "2, two",
        "3, three",
        "4, four",
        "5, five",
        "6, six",
        "7, seven",
        "8, eight",
        "9, nine",
        "10, ten"
    })
    @DisplayName("Test all valid number conversions")
    void testValidNumbers(int input, String expected) {
        assertEquals(expected, converter.convert(input),
            () -> input + " should convert to " + expected);
    }
    
    @Test
    @DisplayName("Test converting each number individually")
    void testIndividualNumbers() {
        assertEquals("one", converter.convert(1));
        assertEquals("two", converter.convert(2));
        assertEquals("three", converter.convert(3));
        assertEquals("four", converter.convert(4));
        assertEquals("five", converter.convert(5));
        assertEquals("six", converter.convert(6));
        assertEquals("seven", converter.convert(7));
        assertEquals("eight", converter.convert(8));
        assertEquals("nine", converter.convert(9));
        assertEquals("ten", converter.convert(10));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 11, 100})
    @DisplayName("Test invalid numbers throw exception")
    void testInvalidNumbers(int invalidNumber) {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> converter.convert(invalidNumber),
            "Should throw IllegalArgumentException for invalid number: " + invalidNumber);
        
        assertEquals("Number must be between 1 and 10", exception.getMessage());
    }
    
    @Test
    @DisplayName("Test lower boundary (1)")
    void testLowerBoundary() {
        assertEquals("one", converter.convert(1));
    }
    
    @Test
    @DisplayName("Test upper boundary (10)")
    void testUpperBoundary() {
        assertEquals("ten", converter.convert(10));
    }
    
    @Test
    @DisplayName("Test case sensitivity")
    void testCaseSensitivity() {
        assertNotEquals("One", converter.convert(1));
        assertNotEquals("TWO", converter.convert(2));
        assertNotEquals("ThReE", converter.convert(3));
    }
}