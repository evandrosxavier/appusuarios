package br.com.sulaquarkus.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

public record UsuarioResponseDTO(
        @Schema(description = "ID único do usuário gerado pelo sistema.", example = "1")
        Long id,

        @Schema(description = "Nome completo do usuário.", example = "Dom Pedro de Bragança")
        @JsonProperty("nome_completo")
        String nome,

        @Schema(description = "Endereço de e-mail do usuário.", example = "pedros@gmail.com")
        String email,

        @Schema(description = "Lista de endereços associados ao usuário.")
        List<EnderecoResponseDTO> enderecos
) {
}
