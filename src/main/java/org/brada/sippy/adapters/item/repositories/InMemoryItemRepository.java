package org.brada.sippy.adapters.item.repositories;

import org.brada.sippy.domain.models.Item;
import org.brada.sippy.domain.ports.ItemRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
class InMemoryItemRepository implements ItemRepository {

    private final Map<String, Item> repository= new HashMap<>();

    @Override
    public Item getItem(String id) {
        return repository.get(id);
    }

    @Override
    public List<Item> getAllItems() {
        return repository.values().stream().toList();
    }

    @Override
    public Item saveItem(Item item) {
        return repository.put(item.id(), item);
    }
}
