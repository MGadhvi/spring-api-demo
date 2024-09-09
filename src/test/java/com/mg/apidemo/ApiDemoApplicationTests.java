package com.mg.apidemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class ApiDemoApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup(){
        restTemplate = new RestTemplate();
    }

    @Test
    public void testGetEndpoint() {
       restTemplate.execute();
    }
}
