/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualshore.livindakar.controller;

import com.qualshore.livindakar.dao.PlaceRepository;
import com.qualshore.livindakar.mapping.Place;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author NIASS
 */
@RestController
@RequestMapping("/place")
public class PlaceController {
    
    public static final Logger logger = LoggerFactory.getLogger(PlaceController.class);
	@Autowired
	private PlaceRepository placeRepository;
	
	@GetMapping("/list_place")
	public ResponseEntity <List<Place>> listAllCategories() {
            List<Place> places = placeRepository.findAll();
            if (places.isEmpty()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<List<Place>>(places, HttpStatus.OK);
	}
    
}
