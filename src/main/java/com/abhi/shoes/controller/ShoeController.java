package com.abhi.shoes.controller;

import com.abhi.shoes.model.Shoe;
import com.abhi.shoes.service.ShoeService;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4300")
public class ShoeController {

    @Autowired
    ShoeService shoeService;

    @PostMapping(path = "/shoes")
    public ResponseEntity<Shoe> addShoe(@RequestBody Shoe shoe) throws Exception {
        try {
            Shoe res = shoeService.addShoe(shoe);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception ex) {
            log.error("Exception wile adding the Shoe : " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/shoes/all")
    public ResponseEntity<List<Shoe>> getAllshoes(){
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }
}
