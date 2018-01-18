package com.qualshore.livindakar.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.qualshore.livindakar.mapping.Category;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository  extends JpaRepository<Category, Integer> {

    Category findByNom(@Param("nom")String nom);
}