package com.qualshore.livindakar.controller;

import net.minidev.json.JSONObject;
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
import com.qualshore.livindakar.mapping.Category;
import com.qualshore.livindakar.Util.CustomErrorType;
import java.util.logging.Level;
import org.json.*;
import com.qualshore.livindakar.dao.CategoryRepository;

//@Controller
//@RequestMapping("/categoriesList")

@RestController
@RequestMapping("/category")

public class CategoryController{
	public static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	private CategoryRepository categorieRepository;
	
	@GetMapping("/list_category")
	public ResponseEntity <List<Category>> listAllCategories() {
		//return noteRepository.findAll();
            List<Category> categories = categorieRepository.findAll();
            if (categories.isEmpty()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
            }
            return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
		//return categories;
	}
	
	@RequestMapping(value = "/categorie/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCategorie(@PathVariable("id") Integer id) {
        logger.info("Fetching Categorie with id {}", id);
        Category categorie = categorieRepository.findOne(id);
        if (categorie == null) {
            logger.error("Categorie with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Categorie with id " + id 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(categorie, HttpStatus.OK);
    }
	
	// -------------------Create a categorie-------------------------------------------

    /*@PostMapping("/categories/")
    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }*/

   @RequestMapping(value = "/categories/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCategorie(Category categorie,Category cat, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Categorie : {}", categorie);
        //Categorie cat = new Categorie();
        cat = categorieRepository.findByNom(categorie.getNom());
        if(cat != null){
            String message;
            JSONObject item = new JSONObject();
            try {
                item.put("message", "Categorie "+cat.getNom()+" existe deja");
            } catch (JSONException ex) {
                java.util.logging.Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
            }

            message = item.toString();
            //logger.error("Unable to create. A Categorie with name {} already exist", categorie.getNomCategorie());
            //return new ResponseEntity(new CustomErrorType("Unable to create. A Categorie with name " + 
            //categorie.getNomCategorie() + " already exist."),HttpStatus.CONFLICT);
            
            
            return new ResponseEntity<String>(message, HttpStatus.CONFLICT);
        }
        
        categorieRepository.save(categorie);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/categorie/{id}").buildAndExpand(categorie.getIdCategory()).toUri());
        return new ResponseEntity<Category>(categorie, HttpStatus.CREATED);
    }
 
 
    /*@RequestMapping("/categorie/")
    public ResponseEntity<?> createCategorie(@Valid @RequestBody Categorie categorie, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Categorie : {}", categorie);
 
        if (categorieRepository.isCategorieExist(categorie)) {
            logger.error("Unable to create. A Categorie with name {} already exist", categorie.getNomCategorie());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Categorie with name " + 
            categorie.getNomCategorie() + " already exist."),HttpStatus.CONFLICT);
        
        categorieRepository.save(categorie);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/categorie/{id}").buildAndExpand(categorie.getIdCategorie()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }*/
}