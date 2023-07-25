package org.brada.sippy.adapters.item.web;

import org.brada.sippy.domain.models.Item;
import org.brada.sippy.domain.ports.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{id}")
    ResponseEntity<Item> storeItem(@PathVariable String id, @RequestBody Item item){
        if(id.equals(item.id())){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(domainService.store(item));
    }
}
