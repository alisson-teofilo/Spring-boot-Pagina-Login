package com.project.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPF {

    private String cpf;
    private String id;
    private String nome;
    private String senha;
    private String email;
    private String token;
    private String cargoAtual;

}
