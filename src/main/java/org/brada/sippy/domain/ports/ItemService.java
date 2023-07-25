package org.brada.sippy.domain.ports;

import org.brada.sippy.domain.models.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Item getItem(String id) {
        return repository.getItem(id);
    }

    public List<Item> getAllItems() {
        return repository.getAllItems();
    }

    public Item store(Item item) {
        return repository.saveItem(item);
    }
}
