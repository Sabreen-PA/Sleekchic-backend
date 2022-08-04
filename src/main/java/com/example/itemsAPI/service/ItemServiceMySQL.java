package com.example.itemsAPI.service;

import com.example.itemsAPI.repository.ItemRepository;
import com.example.itemsAPI.repository.entity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceMySQL implements ItemService
{
    private final ItemRepository itemRepository;

    public ItemServiceMySQL(@Autowired ItemRepository itemRepository )
    {

        this.itemRepository = itemRepository;
    }

    @Override
    public Items save( Items item )
    {
        //TODO implement this method
        itemRepository.save(item);
        return item;
    }

    @Override
    public boolean delete( int itemId )
    {
        //TODO implement this method
        itemRepository.deleteById(itemId);
        return true;
    }

    @Override
    public List<Items> all()
    {
        //TODO implement this method
        List<Items> result = new ArrayList<>();
        itemRepository.findAll().forEach( result::add );
        return result;
    }

    @Override
    public Items findById(int itemId )
    {
        //TODO implement this method

    return itemRepository.findById(itemId).get();

    }
}
