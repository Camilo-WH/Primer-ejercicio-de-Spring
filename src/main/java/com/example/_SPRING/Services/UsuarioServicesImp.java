package com.example._SPRING.Services;


import com.example._SPRING.Entity.Usuario;
import com.example._SPRING.Repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicesImp implements UsuarioServices{

    private final UsuarioRepository usuarioRepository;


    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> obtenerUsiarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void eliminarUsuario(Long id) {
        if (! usuarioRepository.existsById(id)){
            throw new RuntimeException("Usuario no existe");
        }
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        if (! usuarioRepository.existsById(id)) {
            throw new RuntimeException("EL USUARIO NO EXISTE");
        }
        Usuario usuarioActual = usuarioRepository.findById(id).get();

        if (usuario.getNombre() != null){
            usuarioActual.setNombre(usuario.getNombre());
        }
        if (usuario.getCorreo() != null){
            usuarioActual.setCorreo(usuario.getCorreo());
        }
        if (usuario.getEdad() != null){
            usuarioActual.setEdad(usuario.getEdad());
        }

        return usuarioRepository.save(usuarioActual);
    }
}

