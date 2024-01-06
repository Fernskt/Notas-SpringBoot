/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noticias.noticias.controller;

import com.noticias.noticias.entity.Noticia;
import com.noticias.noticias.exception.MyException;
import com.noticias.noticias.service.NoticiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Pc
 */
@Controller
@RequestMapping("/")
public class NoticiaControlador {
    
    @Autowired
    NoticiaService noticiaServicio;
    
    @GetMapping("/")
    public String listaNoticias(ModelMap modelo){
        
        List<Noticia> noticias = noticiaServicio.listarNoticias();
        modelo.addAttribute("noticias",noticias);
        
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregarNoticia(){
        return "agregar_noticia.html";
    }
    
    
    
    @PostMapping("/registro")
    public String guardarNoticia(@RequestParam String titulo, @RequestParam String cuerpo, ModelMap modelo){
        
        try {
            noticiaServicio.crearNoticia(titulo, cuerpo);
            modelo.addAttribute("Exito", "La noticia se creo correctamente");
        } catch (MyException ex) {
            modelo.addAttribute("error", ex.getMessage());
            return "agregar_noticia";
        }
        
        return "redirect:/";
        
    }
    
    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer noticiaId){
        
        noticiaServicio.eliminarNoticia(noticiaId);
        
        return "redirect:/";
    }
    
    
}
