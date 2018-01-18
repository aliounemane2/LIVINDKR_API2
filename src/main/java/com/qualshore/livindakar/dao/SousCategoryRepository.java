/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualshore.livindakar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qualshore.livindakar.mapping.SousCategory;
import com.qualshore.livindakar.mapping.Category;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author NIASS
 */
public interface SousCategoryRepository extends JpaRepository<SousCategory, Long>{
    @Query("SELECT sc FROM SousCategory sc join sc.idCategory c WHERE c.idCategory =:idCategory")
    public List<SousCategory> findSousCategorieNameById(@Param("idCategory") Integer idCategory);
    
}
