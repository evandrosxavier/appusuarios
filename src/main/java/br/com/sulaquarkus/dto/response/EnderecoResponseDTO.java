package br.com.sulaquarkus.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public record EnderecoResponseDTO(

        @Schema(description = "ID único do endereço gerado pelo sistema.", example = "001")
        Long id,

        @Schema(description = "Logradouro do endereço (Rua, Avenida, etc).", example = "Avenida Paulista")
        String logradouro,

        @Schema(description = "Número do endereço.", example = "1000")
        String numero,

        @Schema(description = "Complemento do endereço (apartamento, bloco, etc).", example = "Bloco 1, Apto 101")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        String complemento,

        @Schema(description = "Bairro do endereço).", example = "Bela Vista")
        String bairro,

        @Schema(description = "CEP do endereço, somente números.", example = "01310100")
        String cep,

        @Schema(description = "Cidade do endereço.", example = "São Paulo")
        String cidade,

        @Schema(description = "Sigla do estado do endereço.", example = "SP")
        String estado
) {




}
