package com.example.itemsAPI.controller;

import com.example.itemsAPI.controller.dto.ItemDto;
import com.example.itemsAPI.repository.ItemRepository;
import com.example.itemsAPI.repository.entity.Items;
import com.example.itemsAPI.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/item")
public class ItemController{

    final ItemRepository itemRepository;

final ItemService itemService;
    public ItemController(@Autowired ItemRepository itemRepository, @Autowired ItemService itemService)
    {

        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }

    @GetMapping("all")
    public Iterable<Items> getItems(){

        return itemService.all();
    }
    @CrossOrigin
    @PostMapping
    public Items save( @RequestBody ItemDto itemDto )
    {
        return itemService.save( new Items( itemDto ) );
    }

    @GetMapping("/{id}")
    public Items findItemById( @PathVariable Integer id ) throws Exception{
        Items result = itemService.findById( id);
        if(result!=null)
        {
            return result;
        }
        throw new Exception("Item Not Found");
    }

    @PutMapping( "/{id}" )
    public Items update( @RequestBody ItemDto itemDto, @PathVariable Integer id )
    {
        Items item = itemService.findById( id );
        item.setName( itemDto.getName() );
        item.setDescription( itemDto.getDescription() );
        item.setImageUrl( itemDto.getImageUrl() );
        return itemService.save( item );
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }

}