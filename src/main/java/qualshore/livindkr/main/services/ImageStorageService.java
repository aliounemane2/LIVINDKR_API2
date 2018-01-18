package qualshore.livindkr.main.services;

import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import qualshore.livindkr.main.entities.User;




@Service
public class ImageStorageService {
	
	
	@Autowired
	Environment env;
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private final Path rootLocation = Paths.get("upload-dir");



	    
	  
	    
	    public Resource loadImage(String imageName) {
			try {
				// Path file = rootLocation.resolve(filename);
				// Resource resource = new UrlResource(file.toUri());
				
	            String location = env.getProperty("root.location.load");
	            // Path file = rootLocation.resolve(imageName);

				Resource resource = new UrlResource(location+"/"+imageName);
				if (resource.exists() || resource.isReadable()) {
					return resource;
				} else {
					throw new RuntimeException("FAIL!");
				}
			} catch (MalformedURLException e) {
				throw new RuntimeException("FAIL!");
			}
		}

   
    
	     /*   
    public String loadFile(Documents document, String location, String fileName) throws Exception {
       try {
           Path rootLocation = getRootDocument(document, location);
           Path file = new File(location+ "/"+ document.getRepertoire()+ "/" + fileName).toPath() ;
           rootLocation.resolve(location+ "/"+ document.getRepertoire()+ "/" + fileName);
           Resource resource = new UrlResource(file.toUri());
           if(resource.exists() || resource.isReadable()) {
               return document.getRepertoire()+ "/" + fileName;
           }else{
               throw new RuntimeException("FAIL 2");
           }
       } catch (MalformedURLException e) {
           throw new RuntimeException("FAIL 3");
       }
   }
   
   public void delete(Documents document, String location) throws Exception {
       try {
           Path rootLocation = getRootDocument(document, location);
           FileSystemUtils.deleteRecursively(rootLocation.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
   }
   
   public void deleteFile(Documents document, String fileName) throws Exception {
       try {
           Path rootLocation = getRootDeleteDocument(document, fileName);
           rootLocation.toFile().delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
   }
    
    public Path getRootDocument(User user, String location) throws Exception {
        return Paths.get(location+ "/"+ user.getRepertoire());
    }
    
    public Path getRootDeleteDocument(Documents document, String location) throws Exception {
        return Paths.get(location+ "/"+ document.getUrlDocument());
    }
    
    */
    
    
    
    public void createLocation(String rep, Environment env) throws IOException {
    	
        String[] listDir = rep.split("/");
        try {
            String location = env.getProperty("root.location.store");
            for(int i = 0; i < listDir.length; i++)
            {
                location += "/"+ listDir[i];
                if(Files.notExists(Paths.get(location)))
                    Files.createDirectory(Paths.get(location));
            }
       } catch (IOException e) {
           throw new RuntimeException("Une erreur est survenue lors du stockage!");
       }
    }
    
    
    public HashMap<String, Object> store(MultipartHttpServletRequest request) throws IOException {
    		HashMap<String, Object> h = new HashMap<String, Object>();
    		String message;
    		
    			// JSONObject item = new JSONObject();
            // item.put("message", name);
            // message = item.toString();
    		
        try
        {
            String location = env.getProperty("root.location.store");
            
            Iterator<String> iterator = request.getFileNames();
            String name ="";
            
            MultipartFile file = request.getFile(iterator.next());
           
            String fileName = file.getOriginalFilename();
            
            File directory = new File(location);
            
            
            if (directory.isDirectory()) {
                File serverFile = new File(directory, fileName);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(file.getBytes());
                stream.close();
                name = serverFile.getName();
                
                
                

                message = name;
                h.put("message", message);

                return h;
            }
            else{
            	
                h.put("message", "Ne passe pas");
                message = "Ne passe pas ";
                return h;
                
            }

        } catch (Exception e) {
        	
             message = "FAIL to uploaddd";
             h.put("mess", message);
            try {
            	
            	return h;
            }
           catch (Exception ex) {
               java.util.logging.Logger.getLogger(ImageStorageService.class.getName()).log(Level.SEVERE, null, ex);
           }
            
            message = "pas bon ";
            h.put("sss",message);
            return h;
        }

        
        
        
        
           

            
            

            // Path rootLocation = getRootDocument(document, location);
            // String [] originalName = file.getOriginalFilename().split("\\.pdf");
            
        /*    
       String  originalName = file.getOriginalFilename();
       String nomFic = originalName;
       SimpleDateFormat formater = new SimpleDateFormat("ddMMyyyy");
       String date2=formater.format(new Date());
       // Files.copy(file.getInputStream(), rootLocation.resolve(nomFic+"_"+ date2+ ".pdf"));
       
       Files.copy(file.getInputStream(), null);

       } catch (Exception e) {
           throw new RuntimeException("Ce fichier existe déjà");
       } 
       
       */
    }
    
    
    
    
    
    
    
    
    
    
    
   

}
