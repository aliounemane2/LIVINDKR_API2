/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualshore.livindakar.dao;

import com.qualshore.livindakar.mapping.Institution;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author NIASS
 */
public interface InstitutionRepository extends JpaRepository<Institution, Integer>{
    //SELECT ins FROM Institution ins  join ins.idCategory c WHERE c.idCategorie =:idCategorie
    //@Query("SELECT vign FROM Institution vign  join vign.idInstitution ins join ins.idCategory c WHERE c.idCategorie =:idCategorie")
    @Query("SELECT ins FROM Institution ins  join ins.idCategory c WHERE c.idCategory =:idCategory")
    public List<Institution> findInstitutionByCategorie(@Param("idCategory") Integer idCategory);
    
    @Query("SELECT ins FROM Institution ins  join ins.idSousCategory sc WHERE sc.idSousCategory =:idSousCategory")
    public List<Institution> findInstitutionBySousCategorie(@Param("idSousCategory") Integer idSousCategory);
    
    @Query("SELECT ins FROM Institution ins  join ins.idUser u WHERE u.idUser =:idUser")
    public List<Institution> findInstitutionByUser(@Param("idUser") Integer idUser);
    
}
