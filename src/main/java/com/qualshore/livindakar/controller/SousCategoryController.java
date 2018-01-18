/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualshore.livindakar.controller;

/**
 *
 * @author NIASS
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.core.MediaType.*;
//import javax.ws.rs.core.MediaType;
import org.springframework.http.MediaType;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
//import org.json.JSONArray;
//import org.json.JSONObject;
import com.qualshore.livindakar.mapping.SousCategory;
import com.qualshore.livindakar.Util.CustomErrorType;
import java.util.logging.Level;
import org.json.JSONException;
import com.qualshore.livindakar.dao.SousCategoryRepository;

//@Controller
//@RequestMapping("/categoriesList")

@RestController
@RequestMapping("/sous_category")
public class SousCategoryController {
    
    public static final Logger logger = LoggerFactory.getLogger(SousCategoryController.class);
	@Autowired
	private SousCategoryRepository sousCategorieRepository;
        
        @GetMapping("/souscategorie")
	public ResponseEntity <List<SousCategory>> listAllSousCategories() {
            //return noteRepository.findAll();
            List<SousCategory> sousCategories = sousCategorieRepository.findAll();
            if (sousCategories.isEmpty()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
                // You many decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<List<SousCategory>>(sousCategories, HttpStatus.OK);
		//return categories;
	}
        
        //@GetMapping("/souscategorie/{id}")
        @RequestMapping(value = "/list_sous_category/{idCategory}", method = RequestMethod.GET)
	public ResponseEntity <List<SousCategory>> listSousCategoriesById(@PathVariable("idCategory") Integer idCategory) {
            logger.info("Fetching Categorie with id {}", idCategory);
            List<SousCategory> sousCategories = sousCategorieRepository.findSousCategorieNameById(idCategory);
            if (sousCategories.isEmpty()) {
                return new ResponseEntity<List<SousCategory>>(sousCategories,HttpStatus.NO_CONTENT);
                // You many decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<List<SousCategory>>(sousCategories, HttpStatus.OK);
		//return categories;
	}
    
}
