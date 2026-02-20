package br.com.sulaquarkus.service;

import br.com.sulaquarkus.dto.request.UsuarioRequestDTO;
import br.com.sulaquarkus.dto.request.UsuarioUpdateRequestDTO;
import br.com.sulaquarkus.dto.response.UsuarioResponseDTO;
import br.com.sulaquarkus.mapper.EnderecoMapper;
import br.com.sulaquarkus.mapper.UsuarioMapper;
import br.com.sulaquarkus.model.Usuario;
import br.com.sulaquarkus.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    @Inject
    private UsuarioMapper usuarioMapper;

    @Inject
    private EnderecoMapper enderecoMapper;

    public UsuarioResponseDTO buscaUsuario(Long id) {
        Usuario usuario = usuarioRepository.findByIdOptional(id).orElseThrow(() -> new RuntimeException("Usuario não localizado com o id: " + id  +" ."));
        return usuarioMapper.toResponse(usuario);
    }

    public List<UsuarioResponseDTO> buscaUsuarios() {
       return  usuarioRepository.listAll().stream().map(usuarioMapper::toResponse).toList();
    }

    @Transactional
    public UsuarioResponseDTO cadastraUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioRequestDTO);
        usuario.setDataDaUltimaAlteracao(LocalDateTime.now());
        usuarioRepository.persist(usuario);
        return usuarioMapper.toResponse(usuario);
    }

    @Transactional
    public void atualizaUsuario(UsuarioUpdateRequestDTO usuarioUpdateRequestDTO, Long id) {
        Usuario usuario = usuarioRepository.findByIdOptional(id).orElseThrow(() -> new RuntimeException("Usuario não localizado com o id: " + id + " ."));
        usuario.setDataDaUltimaAlteracao(LocalDateTime.now());
        usuarioMapper.updateEntityFromDTO(usuarioUpdateRequestDTO, usuario);
    }

    @Transactional
    public void deletaUsuario(Long id) {
        usuarioRepository.findByIdOptional(id).orElseThrow(() -> new RuntimeException("Usuario não localizado com o id: " + id  + " ."));
        usuarioRepository.deleteById(id);
    }

}
