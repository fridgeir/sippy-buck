package org.brada.sippy.adapter;

import org.brada.sippy.domain.models.Item;
import org.brada.sippy.domain.port.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
class ItemController {

    private final ItemService domainService;

    public ItemController(ItemService domainService) {
        this.domainService = domainService;
    }

    @GetMapping("/")
    List<Item> getAllItems(){
        return domainService.getAllItems();
    }

    @GetMapping("/{id}")
    Item getItem(@PathVariable String id){
        return domainService.getItem(id);
    }
}
