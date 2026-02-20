package br.com.sulaquarkus.mapper;


import br.com.sulaquarkus.dto.request.UsuarioRequestDTO;
import br.com.sulaquarkus.dto.request.UsuarioUpdateRequestDTO;
import br.com.sulaquarkus.dto.response.UsuarioResponseDTO;
import br.com.sulaquarkus.model.Usuario;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "jakarta",uses = {EnderecoMapper.class})
public interface UsuarioMapper {

    UsuarioResponseDTO toResponse (Usuario usuario);

    Usuario toEntity (UsuarioRequestDTO usuarioRequestDTO);

    @Mapping(target = "enderecos", ignore = true)
    void updateEntityFromDTO (UsuarioUpdateRequestDTO usuarioUpdateRequestDTO, @MappingTarget Usuario usuario);

    @AfterMapping
    default void linkEnderecos(@MappingTarget Usuario usuario) {
        if (usuario.getEnderecos() != null) {
            usuario.getEnderecos().forEach(e -> e.setUsuario(usuario));
        }
    }
}
