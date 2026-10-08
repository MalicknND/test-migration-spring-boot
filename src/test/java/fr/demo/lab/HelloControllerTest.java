package fr.demo.lab;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    HelloService service;

    @Test
    void hello() throws Exception {
        when(service.greet("Malick")).thenReturn("Bonjour Malick");

        mockMvc.perform(get("/api/hello").param("name", "Malick"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.text").value("Bonjour Malick"));
    }
}
