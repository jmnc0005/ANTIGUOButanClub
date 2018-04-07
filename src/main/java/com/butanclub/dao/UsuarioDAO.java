/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.butanclub.dao;

import com.butanclub.model.Usuario;

/**
 *
 * @author Pedro Luis
 */
public interface UsuarioDAO extends GenericDAO<Usuario,String> {
    
    
    public boolean comprobarUsuario(String _usu);
    
    public Usuario buscaUsuario(String _usu);
}
