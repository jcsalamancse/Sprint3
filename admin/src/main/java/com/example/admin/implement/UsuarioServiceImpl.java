/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.admin.implement;

import com.example.admin.dao.UsuarioDao;
import com.example.admin.modelo.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.admin.service.Usuarioservice;


@Service
public class UsuarioServiceImpl implements Usuarioservice{
   @Autowired
   
   private UsuarioDao usuarioDao;
   
   @Override
    @Transactional (readOnly = false) //la etiqueta transaccional indica si afecta o no la integruidad de los datos asignado la etiqueda redonly false afecta
    public Usuario save(Usuario usuario) {
     return usuarioDao.save(usuario);
    }
    
    @Override
    @Transactional (readOnly = true)    
    public void delete(Integer idUsuario) {
        usuarioDao.deleteById(idUsuario);
    }

    @Override
    @Transactional (readOnly = true)
    public Usuario findById(Integer idUsuario) {
    return usuarioDao.findById(idUsuario).orElse(null);
    }

    @Override
    @Transactional (readOnly = false)
    public List<Usuario> findAll() {
    return (List<Usuario>) usuarioDao.findAll();
    }
}
