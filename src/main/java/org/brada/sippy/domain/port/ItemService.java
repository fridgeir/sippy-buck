package org.brada.sippy.domain.port;

import org.brada.sippy.domain.models.Item;

public class ItemService {

    public Item getItem(String id) {
        return new Item("name", null, null, null);
    }
}
