import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.*;
 
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.qualshore.livindakar.mapping.Category;
import com.qualshore.livindakar.dao.CategoryRepository;

//@Service("CategoryRepository")

public class CategorieServiceImpl{

    @Autowired
    private CategoryRepository categorieRepository;
    Category categorie = new Category();
    
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("categorie");
    EntityManager em = factory.createEntityManager();
	/*private static final AtomicLong counter = new AtomicLong();

     
    private static List<Categorie> categories;
     
    static{
        categories= populateDummyUsers();
    }
 
    public List<Categorie> findAllCategories() {
        return categories;
    }
     
    public Categorie findById(long id) {
        for(Categorie categorie : categories){
            if(categorie.getIdCategorie() == id){
                return categorie;
            }
        }
        return null;
    }

    
	
	public void saveCategorie(Categorie ategorie) {
        categorie.setIdCategorie(counter.incrementAndGet());
        categories.add(categorie);
    }*/

    /*public Categorie findByName(String name) {
        Categorie categorie = new Categorie();
        categorie = em.find(Categorie.class, categorie.getIdCategorie());
        if(categorie != null){
            return categorie;
        }
        return null;
    }


    public Categorie findByName( String name)
    {
        Query query = em.createNamedQuery("SELECT c FROM Categorie c WHERE c.nomCategorie = :name");
        query.setParameter("name", name);
        List<Categorie> lc=  query.getResultList();
        if(lc.size()>0) return lc.get(0);
        return null;     
    }

    public boolean isCategorieExist(Categorie categorie) {
        return findByName(categorie.getNomCategorie())!=null;
    }*/
}