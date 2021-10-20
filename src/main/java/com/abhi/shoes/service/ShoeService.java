package com.abhi.shoes.service;

import com.abhi.shoes.dao.ShoeRepository;
import com.abhi.shoes.model.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoeService {

    @Autowired
    private ShoeRepository shorRepo;

    public Shoe addShoe(Shoe shoe){
        return shorRepo.save(shoe);
    }
}
