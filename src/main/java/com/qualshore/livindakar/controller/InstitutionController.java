/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualshore.livindakar.controller;

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
import static com.qualshore.livindakar.controller.SousCategoryController.logger;
import com.qualshore.livindakar.dao.ArticleRepostory;
import com.qualshore.livindakar.dao.InstitutionRepository;
import com.qualshore.livindakar.dao.VignetteRepository;
import com.qualshore.livindakar.mapping.Institution;
import com.qualshore.livindakar.mapping.SousCategory;
import com.qualshore.livindakar.mapping.Vignette;
import com.qualshore.livindakar.mapping.Event;
import java.util.logging.Level;
import com.qualshore.livindakar.dao.CategoryRepository;
import com.qualshore.livindakar.dao.UserInterestRepository;
import com.qualshore.livindakar.mapping.UsersInterests;
import com.qualshore.livindakar.mapping.Article;
import com.qualshore.livindakar.mapping.InterestsEvents;
import com.qualshore.livindakar.dao.InterestsEventsRepository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 *
 * @author NIASS
 */
@RestController
@RequestMapping("/institution")
public class InstitutionController {
    public static final Logger logger = LoggerFactory.getLogger(InstitutionController.class);
    @Autowired
    private InstitutionRepository institutionRepository;
    
    @Autowired
    private VignetteRepository vignetteRepository;
    
    @Autowired
    private UserInterestRepository UserInterestRepository;
    
    @Autowired
    private InterestsEventsRepository EvenementRepository;
    
    @Autowired
    private ArticleRepostory articleRepostory;
    
    @RequestMapping(value = "/list_institution_user/{idUser}", method = RequestMethod.GET)
    public ResponseEntity <List<Institution>> lisInstitutionByUser(@PathVariable("idUser") Integer idUser) {
        logger.info("Fetching Institution with id {}", idUser);
        List<Institution> institution = institutionRepository.findInstitutionByUser(idUser);
        if (institution.isEmpty()) {
            return new ResponseEntity<List<Institution>>(institution,HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Institution>>(institution, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/list_institution/{idCategory}", method = RequestMethod.GET)
    public ResponseEntity <List<Institution>> lisInstitutionByCategorie(@PathVariable("idCategory") Integer idCategory) {
        logger.info("Fetching Categorie with id {}", idCategory);
        List<Institution> institution = institutionRepository.findInstitutionByCategorie(idCategory);
        if (institution.isEmpty()) {
            return new ResponseEntity<List<Institution>>(institution,HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Institution>>(institution, HttpStatus.OK);
    }
        
    @RequestMapping(value = "/list_institutionn/{idSousCategory}", method = RequestMethod.GET)
    public ResponseEntity <List<Institution>> lisInstitutionBySousCategorie(@PathVariable("idSousCategory") Integer idSousCategory) {
        logger.info("Fetching Categorie with id {}", idSousCategory);
        List<Institution> institution = institutionRepository.findInstitutionBySousCategorie(idSousCategory);
        if (institution.isEmpty()) {
            return new ResponseEntity<List<Institution>>(institution,HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Institution>>(institution, HttpStatus.OK);
    }
        
    @RequestMapping(value = "/vignette/{idInstitution}", method = RequestMethod.GET)
    public ResponseEntity <List<Vignette>> listVignetteByInstitution(@PathVariable("idInstitution") Integer idInstitution) {
        logger.info("Fetching Vignette with id {}", idInstitution);
        List<Vignette> vignette = vignetteRepository.findVignetteByInstitution(idInstitution);
        if (vignette.isEmpty()) {
            return new ResponseEntity<List<Vignette>>(vignette,HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Vignette>>(vignette, HttpStatus.OK);
    }
        
    @RequestMapping(value = "/interest/{IdUser}", method = RequestMethod.GET)
    public ResponseEntity <List<UsersInterests>> listInterstByUser(@PathVariable Integer IdUser) {
        logger.info("Fetching Vignette with id {}", IdUser);
        List<UsersInterests> vignette = UserInterestRepository.findInterestByUser(IdUser);
        if (vignette.isEmpty()) {
            return new ResponseEntity<List<UsersInterests>>(vignette,HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<UsersInterests>>(vignette, HttpStatus.OK);
    }
    
    @GetMapping("/list_events")
    public ResponseEntity <List<InterestsEvents>> listAllEvents() {
        List<InterestsEvents> events = EvenementRepository.findEvent();
        if (events.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<InterestsEvents>>(events, HttpStatus.OK);
    }
    
    @GetMapping("/article")
    public ResponseEntity <List<Article>> listArticle() {
        List<Article> article = articleRepostory.findAll();
        if (article.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Article>>(article, HttpStatus.OK);
    }
    
    @GetMapping("/division")
    public  int division() {
        double a = 41333;
        double b = 5;
        double quotient = a/b; // divisé par zéro et c'est faux! attention!
        Double d = new Double(quotient);
        int resultatEuclide = d.intValue();
        //int resultatEuclide = Integer.parseInt(quotient); 
        
        //Double d1 = new Double(quotient);
        //int resultatEuclide = d.intValue();
        //int reste = Integer.parseInt(resultatEuclide*quotient - a);
        return resultatEuclide;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
      public void UploadFile(MultipartHttpServletRequest request) throws IOException {

        Iterator<String> itr = request.getFileNames();
        MultipartFile file = request.getFile(itr.next());
        String fileName = file.getOriginalFilename();
        File dir = new File("/Users/Niass/Documents/");
        if (dir.isDirectory()) {
          File serverFile = new File(dir, fileName);
          BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
          stream.write(file.getBytes());
          stream.close();
        }
      }
 
}
