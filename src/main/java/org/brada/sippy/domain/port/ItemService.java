package org.brada.sippy.domain.port;

import org.brada.sippy.domain.models.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemService {

    public Item getItem(String id) {
        return new Item("name", null, null, null);
    }

    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("name", null, null, null));
        return items;
    }
}
