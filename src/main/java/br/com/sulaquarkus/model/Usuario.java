package br.com.sulaquarkus.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString (exclude = "enderecos")
@EqualsAndHashCode (of = "id")

@Entity
@Table (name = "TB_USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, length = 60)
    private String email;

    @Column(nullable = false, length = 20)
    private String login;

    @Column(nullable = false, length = 10)
    private String senha;

    @Column(nullable = false,name = "dat_ult_alteracao")
    private LocalDateTime dataDaUltimaAlteracao;

    @Column(nullable = false)
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Endereco> enderecos = new ArrayList<>();

}
