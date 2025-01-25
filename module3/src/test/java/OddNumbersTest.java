import com.cocomm.OddNumbers;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class OddNumbersTest {

    @Test
    public void testGetOddNumbersInRange_ValidRange() {
        List<Integer> result = OddNumbers.getOddNumbersInRange(1, 10);
        List<Integer> expected = Arrays.asList(1, 3, 5, 7, 9);
        assertEquals(expected, result);
    }

    @Test
    public void testGetOddNumbersInRange_SingleOddNumber() {
        List<Integer> result = OddNumbers.getOddNumbersInRange(3, 3);
        List<Integer> expected = Collections.singletonList(3);
        assertEquals(expected, result);
    }

    @Test
    public void testGetOddNumbersInRange_NoOddNumbers() {
        List<Integer> result = OddNumbers.getOddNumbersInRange(2, 2);
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, result);
    }

    @Test
    public void testGetOddNumbersInRange_EntireRange() {
        List<Integer> result = OddNumbers.getOddNumbersInRange(1, 20);
        List<Integer> expected = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19);
        assertEquals(expected, result);
    }

    @Test
    public void testGetOddNumbersInRange_InvalidRange() {
        assertThrows(IllegalArgumentException.class, () -> OddNumbers.getOddNumbersInRange(0, 10));
        assertThrows(IllegalArgumentException.class, () -> OddNumbers.getOddNumbersInRange(1, 21));
        assertThrows(IllegalArgumentException.class, () -> OddNumbers.getOddNumbersInRange(10, 1));
    }
}