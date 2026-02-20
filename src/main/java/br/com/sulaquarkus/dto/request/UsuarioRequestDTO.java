package br.com.sulaquarkus.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

public record UsuarioRequestDTO(

        @Schema (description = "Nome completo do usuário", example = "Dom Pedro de Bragança")
        @JsonProperty("nome_completo")
        @NotBlank (message = "O nome do usuário não pode estar em branco.")
        @Size(min = 4, max = 255)
        String nome,

         @Schema(description = "Email do usuário", example = "pedros@gmail.com")
         @NotBlank (message = "O email é obrigatório")
         @Email (message = "Formato de email inválido")
         @Size(max = 60)
         String email,

         @Schema(description = "Login do usuário contendo no mínimo 8 caracteres", example = "esx0177@@!!T")
         @NotBlank (message = "O login é obritório.")
         @Size (min = 8, message = "O login deve conter no mínimo 8 catacteres")
         String login,

         @Schema(description = "Senho de usáio contendo até 10 caracteres", example = "@03772205")
         @NotBlank (message = "O campo senha não pode estar vazio")
         @Size (message = "Campo senha superior a dez dígitos")
         String senha,

         @Schema (description = "Lista de endeços do usuário")
         @NotNull(message = "A lista de endereços não pode ser nula")
         @Size(min = 1, message = " É necessário ao menos um endereço" )
         @Valid
         List<EnderecoRequestDTO> enderecos

         ) {
}
