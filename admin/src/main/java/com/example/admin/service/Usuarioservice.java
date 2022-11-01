/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.admin.service;

import com.example.admin.modelo.Usuario;
import java.util.List;


public interface Usuarioservice {
 
    public Usuario save(Usuario usuario);
    public void delete(Integer idUsuario);
    public Usuario findById (Integer idUsuario);
    public List<Usuario> findAll();
}
