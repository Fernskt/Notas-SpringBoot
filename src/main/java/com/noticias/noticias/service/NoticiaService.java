/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noticias.noticias.service;

import com.noticias.noticias.entity.Noticia;
import com.noticias.noticias.exception.MyException;
import com.noticias.noticias.repository.NoticiaRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pc
 */
@Service
public class NoticiaService {
    
    @Autowired
    NoticiaRepository noticiaRepository;
    
    @Transactional
    public void crearNoticia(String titulo, String cuerpo) throws MyException{
        
        validar(titulo, cuerpo);
        
        Noticia noticia = new Noticia();
        
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        
        noticiaRepository.save(noticia);
        
    }
    
    public List<Noticia> listarNoticias(){
        
        List<Noticia> noticias = new ArrayList();
        
        noticias = noticiaRepository.findAll();
        
        return noticias;
    }
    
    @Transactional
    public void modificarNoticia(Integer idNoticia, String titulo, String cuerpo){
        
        Optional<Noticia> respuesta = noticiaRepository.findById(idNoticia);
        
        if(respuesta.isPresent()){
            
            Noticia noticia = respuesta.get();
            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);
            
            noticiaRepository.save(noticia);
        }
        
    }
    
    public void eliminarNoticia(Integer idNoticia){
        
        Optional<Noticia> respuesta = noticiaRepository.findById(idNoticia);
        
        if(respuesta.isPresent()){
            
            Noticia noticia = respuesta.get();
            noticiaRepository.delete(noticia);
            
        }
        
    }
    
    public void validar(String titulo, String cuerpo) throws MyException{

if(titulo == null || titulo.isEmpty()){
    throw new MyException("El titulo no puede ser nulo o estar vacio");
}
if(cuerpo == null || cuerpo.isEmpty()){
    throw new MyException("El cuerpo no puede ser nulo o estar vacio");
}
if (cuerpo.length() > 255) {
    throw new MyException("La nota excede la longitud máxima permitida.");
}
}
    
}

