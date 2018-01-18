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
import org.json.JSONObject;
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
import com.qualshore.livindakar.dao.EventRepository;
import com.qualshore.livindakar.mapping.Event;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

//@Controller
//@RequestMapping("/categoriesList")

@RestController
@RequestMapping("/event")
public class EventController {
    
    public static final Logger logger = LoggerFactory.getLogger(EventController.class);
    @Autowired
    private EventRepository eventRepository;
        
    @RequestMapping(value = "/add_event/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createEvent(Event event, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Event : {}", event);
        //Categorie cat = new Categorie();
        
        
        eventRepository.save(event);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/categorie/{id}").buildAndExpand(event.getIdEvent()).toUri());
        return new ResponseEntity<Event>(event, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<String> UploadFile(MultipartHttpServletRequest request) throws IOException {
        
        String message = "";
        try {
            Iterator<String> itr = request.getFileNames();
            String name ="";
            MultipartFile file = request.getFile(itr.next());
            String fileName = file.getOriginalFilename();
            File dir = new File("/Users/Niass/Documents/");
            if (dir.isDirectory()) {
                File serverFile = new File(dir, fileName);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(file.getBytes());
                stream.close();
                name= serverFile.getAbsolutePath();
            }
                message = "You successfully uploaded " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.OK).body(name);
        } catch (Exception e) {
                message = "FAIL to upload " ;
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        } 
    }
    
    @PostMapping("/post")
    public ResponseEntity<String> handleFileUpload(MultipartHttpServletRequest request) {
        String message = "";
        try {
            Iterator<String> itr = request.getFileNames();
            String name;
            String nomFichier ="";
            MultipartFile file = request.getFile(itr.next());
            String fileName = file.getOriginalFilename();
            File dir = new File("/Users/Niass/Documents/");
            if (dir.isDirectory()) {
                File serverFile = new File(dir, fileName);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(file.getBytes());
                stream.close();
                name= serverFile.getAbsolutePath();
            }
            else{
                name= "Ce repertoire n'existe pas";
                
            }

                message = "You successfully uploaded " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
                message = "FAIL to upload " ;
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    
}
