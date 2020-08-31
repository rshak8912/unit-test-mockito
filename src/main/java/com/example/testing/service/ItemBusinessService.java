package com.example.testing.service;

import com.example.testing.model.Item;
import com.example.testing.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemBusinessService {
    private final ItemRepository itemRepository;

    public Item retreiveHardCodedItem() {
        return new Item(1, "Ball", 10, 100);
    }
    public List<Item> retrieveAllItems() {
        List<Item> items = itemRepository.findAll();

        for (Item item : items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return itemRepository.findAll();
    }
}
