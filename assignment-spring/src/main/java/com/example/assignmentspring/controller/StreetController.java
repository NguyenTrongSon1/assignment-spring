package com.example.assignmentspring.controller;

import com.example.assignmentspring.entity.Street;
import com.example.assignmentspring.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/streets")
public class StreetController {
    @Autowired
    StreetService streetService;

    //create
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Street> create(@RequestBody Street street){
        streetService.save(street);
        return new ResponseEntity<>(street, HttpStatus.CREATED);
    }

    //get list
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Street>> getList(){

        return ResponseEntity.ok(streetService.findAll());
    }

    //get detail
    @RequestMapping(method = RequestMethod.GET,path = "{id}")
    public ResponseEntity<Object> getDetail(@PathVariable int id){
        Optional<Street> optionalStreet = streetService.findById(id);
        if(optionalStreet.isPresent()){
            return new ResponseEntity<>(optionalStreet.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //updadte
    @RequestMapping(method = RequestMethod.PUT,path = "{id}")
    public ResponseEntity<Object> update(@PathVariable int id,@RequestBody Street street){
       Optional<Street> optionalStreet = streetService.findById(id);
       if (!optionalStreet.isPresent()){
           ResponseEntity.badRequest().build();
       }
       Street existAccount = optionalStreet.get();
       existAccount.setName(street.getName());
       existAccount.setDescription(street.getDescription());
       existAccount.setStatus(street.getStatus());
       streetService.save(existAccount);
       return new ResponseEntity<>(existAccount,HttpStatus.OK);
    }


}
