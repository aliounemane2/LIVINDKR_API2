/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualshore.livindakar.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.qualshore.livindakar.mapping.Event;
import com.qualshore.livindakar.mapping.InterestsEvents;
import java.util.List;
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author NIASS
 */
public interface InterestsEventsRepository extends JpaRepository<InterestsEvents, Long>{
    @Query("SELECT ie  FROM  InterestsEvents ie join ie.idEvent e join ie.idInterest int")
    public List<InterestsEvents> findEvent();
    
}
