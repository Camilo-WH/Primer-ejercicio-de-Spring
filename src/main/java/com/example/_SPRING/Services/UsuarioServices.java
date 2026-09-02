package com.example._SPRING.Services;


import com.example._SPRING.Entity.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioServices {

    Usuario crearUsuario(Usuario usuario);
    List<Usuario> obtenerUsiarios();
    Optional<Usuario> obtenerPorId(Long id);
    void eliminarUsuario(Long id);
    Usuario actualizarUsuario(Long id, Usuario usuario);


}
