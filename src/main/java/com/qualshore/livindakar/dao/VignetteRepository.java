/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualshore.livindakar.dao;

import com.qualshore.livindakar.mapping.Vignette;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author NIASS
 */
public interface VignetteRepository extends JpaRepository<Vignette, Integer>{
    @Query("SELECT vign FROM Vignette vign  join vign.idInstitution ins WHERE ins.idInstitution =:idInstitution")
    public List<Vignette> findVignetteByInstitution(@Param("idInstitution") Integer idInstitution);
    
}
