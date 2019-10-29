package com.example.practise.Practise;

import com.example.practise.Practise.entity.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PractiseApplicationTests {
    @LocalServerPort
    int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private HttpHeaders httpHeaders;

    @Test
    public void show() {
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrl("/show")
                , HttpMethod.GET, httpEntity, String.class);
        Assert.assertNotNull(responseEntity.getBody());
    }

    @Test
    public void add() {
        Employee employee = new Employee();
        employee.setEmployeeid(10);
        employee.setName("A");
        HttpEntity<Employee> httpEntity = new HttpEntity<Employee>(employee, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrl("/add"), HttpMethod.POST, httpEntity, String.class);
        Assert.assertEquals("ADDED SUCCESSFULLY", responseEntity.getBody());
    }

    @Test
    public void find() {
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrl("/find/1"), HttpMethod.GET, httpEntity, String.class);
        Assert.assertEquals("{\"employeeid\":1,\"name\":\"Yaman\"}", responseEntity.getBody());

    }

    @Test
    public void name() {
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrl("/name/1"), HttpMethod.GET, httpEntity, String.class);
        Assert.assertEquals("Yaman", responseEntity.getBody());
    }

    @Test
    public void delete() {
        HttpEntity<String> httpEntity = new HttpEntity<String>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrl("/delete/10"), HttpMethod.POST, httpEntity, String.class);
        Assert.assertEquals("DELETED SUCCESSFULLY", responseEntity.getBody());

    }

    public String createUrl(String url) {
        return "http://localhost:" + port + url;
    }


}