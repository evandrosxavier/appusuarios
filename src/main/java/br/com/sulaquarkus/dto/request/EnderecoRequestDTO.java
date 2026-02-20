package br.com.sulaquarkus.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public record EnderecoRequestDTO(

        @Schema(description = "Logradouro do endereço (Rua, Avenida, etc).", example = "Avenida Paulista")
        @NotBlank(message = "O logradouro não pode estar em branco.")
        @Size(max = 255)
        String logradouro,

        @Schema(description = "Número do endereço.", example = "1000")
        @NotBlank(message = "O número não pode estar em branco.")
        String numero,

        @Schema(description = "Complemento do endereço (apartamento, bloco, etc).", example = "Bloco 1, Apto 101")
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @Size (max = 255)
        String complemento,

        @Schema(description = "Bairro do endereço).", example = "Bela Vista")
        @NotBlank (message = "O bairro é obrigatório.")
        @Size (max = 100)
        String bairro,

        @Schema(description = "CEP do endereço, somente números.", example = "01310100")
        @NotBlank(message = "O CEP não pode estar em branco.")
        @Pattern(regexp = "\\d{8}", message = "O CEP deve conter 8 dígitos numéricos.")
        String cep,

        @Schema(description = "Cidade do endereço.", example = "São Paulo")
        @NotBlank(message = "A cidade não pode estar em branco.")
        @Size (max = 100)
        String cidade,

        @Schema(description = "Sigla do estado do endereço.", example = "SP")
        @NotBlank(message = "O estado não pode estar em branco.")
        @Size(min = 2, max = 2, message = "A sigla do estado deve conter 2 letras.")
        String estado
) {
}
