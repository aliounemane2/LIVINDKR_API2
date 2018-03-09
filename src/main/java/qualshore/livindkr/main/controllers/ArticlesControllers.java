package qualshore.livindkr.main.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import qualshore.livindkr.main.entities.Article;
import qualshore.livindkr.main.entities.CustomUserDetails;
import qualshore.livindkr.main.entities.Institution;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.repository.ArticlesRepository;

@RequestMapping("/articles")
@RestController
public class ArticlesControllers {
	
	@Autowired
	private ArticlesRepository articlesrepository;
	
	@Autowired
	Environment env;
	
	
	@RequestMapping(value="/list_articles", method=RequestMethod.GET)
	public HashMap<String, Object> getAllArticles(){
		
		HashMap<String, Object> h= new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");

		
		List<Article> article = articlesrepository.findAll();
		
		if (article.size() == 0) {
			
			h.put("message", "Il n'y a pas d'articles.");
			h.put("status", -1);
			return h;
			
		}else {
			
			h.put("message", "La liste des articles sont :");
			h.put("article", article);
			h.put("status", 0);
			h.put("location", location);
			return h;
			
		}
		
		
	}
	
	
	@RequestMapping(value="/increments_articles/{id_articles}", method=RequestMethod.PUT)
	public HashMap<String, Object> incrementsArticles(@PathVariable Integer id_articles){
		
		HashMap<String, Object> h= new HashMap<String, Object>();
		
		Article article = articlesrepository.findByIdArticle(id_articles);
		
		if (article == null) {
			
			h.put("message", "Il n'y a pas d'articles.");
			h.put("status", -1);
			return h;
			
		}else {
			
			
			article.setNbLecteur(article.getNbLecteur()+1);
			articlesrepository.saveAndFlush(article);
			
			h.put("message", "L'incrementation des articles est effectives :");
			h.put("article", article);
			h.put("status", 0);
			return h;
			
		}
	}
	
	
	
	@RequestMapping(value="/create_articles", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public HashMap<String, Object> createarticles(@RequestBody Article article){
		
		HashMap<String, Object> h= new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");

		User idUser;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        idUser = customUserDetails;
        

		if(article == null){
			
			h.put("message", "paramètres vides.");
			h.put("status", -1);
			return h;
			
		}else {
			//article.setIdUser(idUser.getIdUser());
			article.setIdCategory(article.getIdCategory());
			article.setIdUser(idUser);


			article = articlesrepository.save(article);
			
			h.put("message", "L'enregistrement des articles est effective:");
			h.put("article", article);
			h.put("urls", "http://"+location);
			h.put("status", 0);
			return h;
			
		}
		
		
		//List<Article> article = articlesrepository.findAll();
		
		/*if (article.size() == 0) {
			
			h.put("message", "Il n'y a pas d'articles.");
			h.put("status", -1);
			return h;
			
		}else {
			
			h.put("message", "La liste des articles sont :");
			h.put("article", article);
			h.put("status", 0);
			return h;
			
		}
		
		*/

	}
	
	
	
	@RequestMapping(value="/list_articles_by_user", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public HashMap<String, Object> listarticles(){
		
		HashMap<String, Object> h= new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");

		User idUser;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        idUser = customUserDetails;
        
        List<Article> article = articlesrepository.findArticleByUser(idUser);
		if(article == null){
			
			h.put("message", "Pas d'articles disponibles.");
			h.put("status", -1);
			return h;
			
		}else {
			
			h.put("message", "L'ensemble des articles sont:");
			h.put("article", article);
			h.put("urls", "http://"+location);
			h.put("status", 0);
			return h;
			
		}
	}
	
	
	
	@RequestMapping(value="/getArticle/{idArticle}", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public HashMap<String, Object> GetOnearticles(@PathVariable Integer idArticle){
		
		HashMap<String, Object> h= new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");

		User idUser;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        idUser = customUserDetails;
        
        Article article = articlesrepository.findByIdArticle(idArticle);
		if(article == null){
			
			h.put("message", "Pas d'articles disponibles.");
			h.put("status", -1);
			return h;
			
		}else {
			
			h.put("message", "L'ensemble des articles sont:");
			h.put("article", article);
			h.put("urls", "http://"+location);
			h.put("status", 0);
			return h;
			
		}
	}
	
	
	
	@RequestMapping(value="/update_articles/{idArticle}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public HashMap<String, Object> updatearticles(@PathVariable Integer idArticle, @RequestBody Article article){
		
		HashMap<String, Object> h= new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");
        
        Article articles = articlesrepository.findByIdArticle(idArticle);
        
        articles.setTitreArticle(article.getTitreArticle());
        articles.setIdTagDecouverte(article.getIdTagDecouverte());
        articles.setImage(article.getImage());
        articles.setContenuArticle(article.getContenuArticle());
        articlesrepository.saveAndFlush(articles);
        
        h.put("message", "L'article est bien mise a jour :");
		h.put("article", article);
		h.put("urls", "http://"+location);
		h.put("status", 0);
        return h;

	}
	
	
	@CrossOrigin
	@RequestMapping(value="/delete_article/{idArticle}", method = RequestMethod.DELETE)
	public Map<String,Object> delete_institution(@PathVariable Integer idArticle) {
		HashMap<String, Object> h = new HashMap<String, Object>();

			Article article = articlesrepository.findByIdArticle(idArticle);
			
			if (article==null) {
				h.put("message", "Cette article n'existe pas.");
				h.put("status", 0);
				
			}else {
				
				articlesrepository.delete(article);
				h.put("message", "La Suppression de l'article est effective.");
				h.put("status", 0);
			}
			
			return h;
	}

	
	

}
