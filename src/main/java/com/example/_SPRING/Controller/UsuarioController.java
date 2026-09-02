package com.example._SPRING.Controller;

import com.example._SPRING.Entity.Usuario;
import com.example._SPRING.Services.UsuarioServicesImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioServicesImp usuarioServicesImp;


    //CREAR USUARIO
    @PostMapping("/crear")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioServicesImp.crearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }
    //LISTAR USUARIO
    @GetMapping("/obtener")
    public ResponseEntity <List<Usuario>>obtenerUsiarios() {
        List<Usuario> usuarios = usuarioServicesImp.obtenerUsiarios();
        return ResponseEntity.ok(usuarios);
    }

    //LISTAR
    @GetMapping("/listar/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioServicesImp.obtenerPorId(id);

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //ELIMINAR USUARIO
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioServicesImp.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    //ACTUALIZAR USUARIO
    @PatchMapping("/actualizar/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioActualizado = usuarioServicesImp.actualizarUsuario(id, usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }



}
