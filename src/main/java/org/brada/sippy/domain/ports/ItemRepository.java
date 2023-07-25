package org.brada.sippy.domain.ports;

import org.brada.sippy.domain.models.Item;

import java.util.List;

public interface ItemRepository {

    Item getItem(String id);

    List<Item> getAllItems();

    Item saveItem(Item item);

}
