package com.kocfinans.api;

import com.kocfinans.api.service.CreditApplicationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CreditApplicationTest {

    @InjectMocks
    private CreditApplicationServiceImpl creditApplicationService;

    private MockMvc mvc;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(creditApplicationService).build();
    }

    @Test
    public void test() throws Exception {
        String requestBodyJson = "{\"name\":\"Serkan\",\"lastName\":\"TAŞ\",\"citizenNumber\":\"11111111111\",\"monthlyIncome\":5000,\"phone\":\"05394639321\"}";

        MvcResult result = mvc
                .perform(post("http://localhost:8080/query/credit/limit").content(requestBodyJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        MockHttpServletResponse response = result.getResponse();
        String responseMessage = response.getContentAsString();
        assertThat(responseMessage).contains("başvurusu alınmıştır");
    }

}
