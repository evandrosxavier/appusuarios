package br.com.sulaquarkus.mapper;

import br.com.sulaquarkus.dto.request.EnderecoRequestDTO;
import br.com.sulaquarkus.dto.response.EnderecoResponseDTO;
import br.com.sulaquarkus.model.Endereco;
import org.mapstruct.Mapper;

@Mapper (componentModel = "jakarta")
public interface EnderecoMapper {

    Endereco toEntity(EnderecoRequestDTO enderecoRequestDTO);
    EnderecoResponseDTO toResponse(Endereco endereco);
}