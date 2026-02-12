package br.com.sulaquarkus.service;

import br.com.sulaquarkus.model.Usuario;
import br.com.sulaquarkus.repository.UsuarioRepository;

import java.util.Optional;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Usuario buscaUsuario(Long id) {
        Usuario usuario = usuarioRepository.findByIdOptional(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return usuario;
    }
}
