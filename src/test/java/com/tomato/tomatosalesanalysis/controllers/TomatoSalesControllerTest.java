package com.tomato.tomatosalesanalysis.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TomatoSalesControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @Test
    public void TestRESTResponseWithoutParameter() throws Exception {
        URL requestURL = new URL("http://localhost:" + port + "/sales/data");

        ResponseEntity<String> response = template.getForEntity(requestURL.toString(), String.class);

        Object[] responseEntity = template.getForObject(requestURL.toString(), Object[].class);

        List<Object> objects = Arrays.asList(responseEntity);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(3, equalTo(objects.size()));
    }

    @Test
    public void TestRESTResponseWithParameter() throws Exception {
        int size = 6;
        URL requestURL = new URL("http://localhost:" + port + "/sales/data?size=" + size);

        ResponseEntity<String> response = template.getForEntity(requestURL.toString(), String.class);

        Object[] responseEntity = template.getForObject(requestURL.toString(), Object[].class);

        List<Object> objects = Arrays.asList(responseEntity);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(size, equalTo(objects.size()));
    }
}