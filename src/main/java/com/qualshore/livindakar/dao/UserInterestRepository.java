/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualshore.livindakar.dao;

import com.qualshore.livindakar.mapping.UsersInterests;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author NIASS
 */
public interface UserInterestRepository extends JpaRepository<UsersInterests, Integer>{
    @Query("SELECT ui.idInterest FROM  UsersInterests ui join ui.idUser u join ui.idInterest int WHERE u.idUser =:idUser")
    public List<UsersInterests> findInterestByUser(@Param("idUser") Integer idUser);
    
}
