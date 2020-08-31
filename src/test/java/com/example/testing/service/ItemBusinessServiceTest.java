package com.example.testing.service;

import com.example.testing.model.Item;
import com.example.testing.repositories.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ItemBusinessServiceTest {
    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void calculateSumUsingDataService_basic() throws Exception {
        when(itemRepository.findAll()).thenReturn(Arrays.asList(
                new Item(2, "Item2", 10, 10),
                new Item(3, "Item3", 20, 20)
        ));
        List<Item> items = itemBusinessService.retrieveAllItems();
        assertThat(items.get(0).getValue()).isEqualTo(100);
        assertThat(items.get(1).getValue()).isEqualTo(400);

    }
}