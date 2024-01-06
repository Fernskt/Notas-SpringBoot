/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noticias.noticias.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author Pc
 */
@Entity
@Getter @Setter
public class Noticia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noticiaId;
    private String titulo;
    private String cuerpo;

    public Noticia(Integer noticiaId, String titulo, String cuerpo) {
        this.noticiaId = noticiaId;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public Noticia() {
    }
    
    
}
