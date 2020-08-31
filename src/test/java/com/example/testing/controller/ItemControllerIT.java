package com.example.testing.controller;

import com.example.testing.repositories.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class ItemControllerIT {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ItemRepository repository;

    @Test
    public void test() throws Exception {
        String response = this.testRestTemplate.getForObject("/all-items-from-database",String.class);
        JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003}]", response,false);
    }
}