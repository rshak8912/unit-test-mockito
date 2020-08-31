package com.example.testing.repositories;

import com.example.testing.model.Item;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
@RunWith(SpringRunner.class)
public class ItemRepositoryTest {

    @Autowired ItemRepository itemRepository;

    @Test
    public void testFindAll() throws Exception {
        List<Item> items = itemRepository.findAll();
        assertThat(items.size()).isEqualTo(3);
    }
}