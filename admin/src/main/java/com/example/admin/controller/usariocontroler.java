/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.admin.controller;

import com.example.admin.modelo.Usuario;
import com.example.admin.service.Usuarioservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")

public class usariocontroler {

    @Autowired

    private Usuarioservice usuarioService;

    @PostMapping(value = "/")
    public ResponseEntity<Usuario> agregar(@RequestBody Usuario usuario) {
        Usuario obj = usuarioService.save(usuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    
     @DeleteMapping(value = "/{idUsuario}")
    public ResponseEntity<Usuario> eliminar(@PathVariable Integer idUsuario) {
        Usuario obj = usuarioService.findById(idUsuario);
        if (obj != null) {
            usuarioService.delete(idUsuario);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value = "/")
    public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario) {
        Usuario obj = usuarioService.findById(usuario.getidUsuario());
        if (obj != null) {
            obj.setNombres(usuario.getNombres());
            obj.setApellidos(usuario.getApellidos());
            obj.setTelefono(usuario.getTelefono());
            obj.setDireccion(usuario.getDireccion());
            obj.setEmail(usuario.getEmail());
            
            usuarioService.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
 
 
 @GetMapping("/list")
 public List<Usuario> consultarTodo(){
   return usuarioService.findAll();
 }
 @GetMapping("/list/{IdUsuario}")
 public Usuario consultarPorId(@PathVariable Integer IdUsuario){
     return usuarioService.findById(IdUsuario);
 }

}
