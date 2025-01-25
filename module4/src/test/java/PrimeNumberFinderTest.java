import com.contrifun.PrimeNumberFinder;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@DisplayName("Prime Number Finder Tests")
class PrimeNumberFinderTest {
    
    private PrimeNumberFinder primeFinder;
    
    @BeforeEach
    void setUp() {
        primeFinder = new PrimeNumberFinder();
    }
    
    @Test
    @DisplayName("Test finding all primes from 1 to 10")
    void testFindAllPrimes() {
        List<Integer> primes = primeFinder.findAllPrimes();
        assertEquals(List.of(2, 3, 5, 7), primes,
            "Prime numbers between 1 and 10 should be 2, 3, 5, and 7");
    }
    
    @Test
    @DisplayName("Test custom range from 3 to 7")
    void testCustomRange() {
        List<Integer> primes = primeFinder.findPrimesInRange(3, 7);
        assertEquals(List.of(3, 5, 7), primes,
            "Prime numbers between 3 and 7 should be 3, 5, and 7");
    }
    
    @Test
    @DisplayName("Test range containing no prime numbers")
    void testRangeWithNoPrimes() {
        List<Integer> primes = primeFinder.findPrimesInRange(8, 9);
        assertTrue(primes.isEmpty(),
            "There should be no prime numbers between 8 and 9");
    }
    
    @Test
    @DisplayName("Test single number range with prime")
    void testSingleNumberRangePrime() {
        List<Integer> primes = primeFinder.findPrimesInRange(7, 7);
        assertEquals(List.of(7), primes,
            "Range containing only 7 should return [7]");
    }
    
    @Test
    @DisplayName("Test single number range with non-prime")
    void testSingleNumberRangeNonPrime() {
        List<Integer> primes = primeFinder.findPrimesInRange(4, 4);
        assertTrue(primes.isEmpty(),
            "Range containing only 4 should return empty list");
    }
    
    @ParameterizedTest
    @CsvSource({
        "-1, 5",
        "0, 5",
        "5, 11",
        "11, 15",
        "6, 3"  // start > end
    })
    @DisplayName("Test invalid ranges throw exception")
    void testInvalidRanges(int start, int end) {
        assertThrows(IllegalArgumentException.class,
            () -> primeFinder.findPrimesInRange(start, end),
            "Should throw IllegalArgumentException for invalid range: " + start + " to " + end);
    }
    
    @Test
    @DisplayName("Test first prime number")
    void testFirstPrime() {
        List<Integer> primes = primeFinder.findPrimesInRange(1, 2);
        assertEquals(List.of(2), primes,
            "First prime number should be 2");
    }
    
    @Test
    @DisplayName("Test boundary values")
    void testBoundaryValues() {
        List<Integer> primes = primeFinder.findPrimesInRange(1, 10);
        assertTrue(primes.contains(2), "Should contain first prime");
        assertTrue(primes.contains(7), "Should contain largest prime in range");
        assertFalse(primes.contains(1), "1 is not a prime number");
        assertFalse(primes.contains(10), "10 is not a prime number");
    }
}