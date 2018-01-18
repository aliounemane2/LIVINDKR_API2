/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualshore.livindakar.dao;

import com.qualshore.livindakar.mapping.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author NIASS
 */
public interface EventRepository extends JpaRepository<Event, Integer> {
    
}
