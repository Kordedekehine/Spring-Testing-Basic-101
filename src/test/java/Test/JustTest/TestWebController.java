package Test.JustTest;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import Test.JustTest.controller.TestController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class TestWebController extends JustTestControllerApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testAdmin() throws Exception {
        mockMvc.perform(get("/admin")).andExpect(status().isOk())
              //  .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect((ResultMatcher) content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name").value("Korede")).andExpect(jsonPath("$.role").value("Soldier"))
                .andExpect(jsonPath("$.id").value("1L")).andExpect(jsonPath("$.salary").value(737873));


    }
}
