package br.com.sulaquarkus.controller;


import br.com.sulaquarkus.dto.request.UsuarioRequestDTO;
import br.com.sulaquarkus.dto.response.UsuarioResponseDTO;
import br.com.sulaquarkus.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;
import java.util.List;


@Path(value = "api/v1/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Usuários", description = "API responsável pela gestão de usuários")
public class UsuarioController {

    @Inject
    private UsuarioService usuarioService;

    @GET
    @Path("/{id}")
    @Operation(summary = "Busca usuário por ID", description = "Retorna os dados completos de um usuário e seus endereços")
    public Response buscaUsuarioPorId(@PathParam ("id") Long id) {
        UsuarioResponseDTO dto = usuarioService.buscaUsuario(id);
        return Response.ok(dto).build();
    }

    @GET
    @Operation(summary = "Busca a lista de usuários", description = "Retorna a lista com dados completos dos usuários e seus endereços")
    public Response buscaUsuarios() {
        List<UsuarioResponseDTO> usuarioResponseDTOs = usuarioService.buscaUsuarios();
        return Response.ok(usuarioResponseDTOs).build();
    }

    @POST
    @Operation(summary = "Cadastra usuário", description = "Efetua o cadastro de usuários")
    public Response cadastraUsuario(@Valid UsuarioRequestDTO usuarioRequestDTO, @Context UriInfo uriInfo) {
        UsuarioResponseDTO usuarioResponseDTO = usuarioService.cadastraUsuario(usuarioRequestDTO);
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(usuarioResponseDTO.id())).build();
        return Response.created(uri).entity(usuarioResponseDTO).build();
    }
}
