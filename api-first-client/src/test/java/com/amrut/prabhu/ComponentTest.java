package com.amrut.prabhu;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ComponentTest {

    private static final WireMockServer WIRE_MOCK_SERVER;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApiClient apiClient;

    static {
        WIRE_MOCK_SERVER = new WireMockServer(
                WireMockConfiguration.options()
                        .dynamicPort()
        );
    }

    @BeforeAll
    public static void beforeAll() {
        WIRE_MOCK_SERVER.start();
        WIRE_MOCK_SERVER.stubFor(WireMock.post(urlPathMatching("/account"))
                .willReturn(aResponse()
                        .withBody("""
                                {  
                                    "name" : "amrut",
                                    "accountId" : "a5cc3e71-5601-4d24-9d6e-8a5733118a7a",
                                    "accountType" : "Savings"
                                }
                                """)
                        .withHeader("content-type", "application/json")));
    }

    @BeforeEach
    public void before() {
        apiClient.setBasePath(WIRE_MOCK_SERVER.baseUrl());
    }

    @Test
    void makeRequest() throws Exception {
        mockMvc.perform(get("/call"))
                .andExpect(status().is2xxSuccessful());
    }
}
