package com.amrut.prabhu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ComponentTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testApiResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/account")
                        .content("""
                                {
                                    "name" : "Amrut Prabhu",
                                    "accountType": "Savings",
                                    "residencyStatus": "Resident"
                                }""")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(
                        MockMvcResultMatchers.status().is2xxSuccessful()
                );
    }

}
