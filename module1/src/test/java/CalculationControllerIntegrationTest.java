import com.bper.MathApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
    classes = MathApplication.class,  // Specify the main application class
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
public class CalculationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddition() throws Exception {
        mockMvc.perform(get("/api/calculate/add/5/3"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.result").value(8.0));
    }

    @Test
    public void testSubtraction() throws Exception {
        mockMvc.perform(get("/api/calculate/subtract/10/4"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.result").value(6.0));
    }

    @Test
    public void testMultiplication() throws Exception {
        mockMvc.perform(get("/api/calculate/multiply/6/7"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.result").value(42.0));
    }

    @Test
    public void testDivision() throws Exception {
        mockMvc.perform(get("/api/calculate/divide/20/5"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.result").value(4.0));
    }

    @Test
    public void testDivisionByZero() throws Exception {
        mockMvc.perform(get("/api/calculate/divide/10/0"))
               .andExpect(status().isBadRequest())
               .andExpect(jsonPath("$").value("Cannot divide by zero"));
    }

    @Test
    public void testDecimalCalculation() throws Exception {
        mockMvc.perform(get("/api/calculate/add/3.14/2.86"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.result").value(closeTo(6.0, 0.001)));
    }
}