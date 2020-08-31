package com.example.testing.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
public class ItemTest {
    @Test
    public void allArgsConstructor_staticName_of() throws Exception {
        Item item = Item.of(1, "item1", 100, 10, 0);

        Assertions.assertThat(item.getId()).isEqualTo(1);
    }

}