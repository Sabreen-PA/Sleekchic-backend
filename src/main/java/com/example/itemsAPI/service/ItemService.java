package com.example.itemsAPI.service;

import com.example.itemsAPI.repository.entity.Items;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    public Items save(Items item );

    public boolean delete( int itemId );

   public List<Items> all();

   public Items findById(int itemId );
}
