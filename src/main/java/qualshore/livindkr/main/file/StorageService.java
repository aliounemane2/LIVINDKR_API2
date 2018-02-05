package qualshore.livindkr.main.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import qualshore.livindkr.main.configSecurity.SecurityConstant;
import qualshore.livindkr.main.entities.User;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import static qualshore.livindkr.main.configSecurity.SecurityConstant.*;

/**
 * Created by User on 16/01/2018.
 */

@Service
public class StorageService {
    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private final Path rootLocation = Paths.get("C:\\xampp\\htdocs\\LIV'INDKR\\PhotosProfil");

    public String store(MultipartFile file, User user)
    {
        HashMap<Integer, String> map = new HashMap<>();
        String nomphoto = "";
        try {
            String type = file.getContentType().toLowerCase();
            if(!(type.equals(IMG_JPEG) || type.equals(IMG_JPG) || type.equals(IMG_PNG))){
                return "0";
            }

            int taille = Integer.parseInt(String.valueOf(file.getOriginalFilename().length()));
            String extension = file.getOriginalFilename().substring(taille-4,taille);

            byte[] bytes = file.getBytes();
            nomphoto = user.getPseudo().concat(extension.toString());
            File file1 = new File("C:\\xampp\\htdocs\\LIV'INDKR\\PhotosProfil".concat("\\").concat(nomphoto));

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file1));
            stream.write(bytes);
            stream.close();

            return nomphoto;
        } catch (Exception e) {
            return nomphoto;
        }
    }

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }else{
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }
}
