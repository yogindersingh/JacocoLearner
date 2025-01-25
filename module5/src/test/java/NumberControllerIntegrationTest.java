import com.bper.MathApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(
    classes = MathApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
public class NumberControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetNumbers_ShouldReturnNumbersOneToTen() throws Exception {
        mockMvc.perform(get("/api/numbers"))
               .andExpect(status().isOk())
               .andExpect(content().contentType("application/json"))
               .andExpect(jsonPath("$", hasSize(10)))
               .andExpect(jsonPath("$[0]").value(1))
               .andExpect(jsonPath("$[1]").value(2))
               .andExpect(jsonPath("$[2]").value(3))
               .andExpect(jsonPath("$[3]").value(4))
               .andExpect(jsonPath("$[4]").value(5))
               .andExpect(jsonPath("$[5]").value(6))
               .andExpect(jsonPath("$[6]").value(7))
               .andExpect(jsonPath("$[7]").value(8))
               .andExpect(jsonPath("$[8]").value(9))
               .andExpect(jsonPath("$[9]").value(10));
    }

    @Test
    public void testGetNumbers_ShouldBeInOrder() throws Exception {
        mockMvc.perform(get("/api/numbers"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$", contains(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    @Test
    public void testGetNumbers_CheckFirstAndLastElements() throws Exception {
        mockMvc.perform(get("/api/numbers"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0]").value(1))
               .andExpect(jsonPath("$[9]").value(10));
    }

    @Test
    public void testGetNumbers_ValidateArrayStructure() throws Exception {
        mockMvc.perform(get("/api/numbers"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray())
               .andExpect(jsonPath("$").isNotEmpty())
               .andExpect(jsonPath("$[*]", everyItem(both(greaterThanOrEqualTo(1))
                                                    .and(lessThanOrEqualTo(10)))));
    }
}