/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noticias.noticias.repository;

import com.noticias.noticias.entity.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Pc
 */
public interface NoticiaRepository extends JpaRepository<Noticia, Integer> {
    
    
    
}
