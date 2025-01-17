package com.project.demo.controller;


import com.project.demo.dto.requestDTO.UsuarioPfRequest;
import com.project.demo.dto.responseDTO.UsuarioPfResponseDTO;
import com.project.demo.service.UsuarioPfService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("link-vagas/usuario")
@Slf4j
public class UsuarioPfController {

    UsuarioPfService service;

    @Autowired
    public UsuarioPfController(UsuarioPfService service) {
        this.service = service;
    }

    @PostMapping("/cadastrarUsuario")
    public ResponseEntity<?> createUser(@RequestBody UsuarioPfRequest usuarioPfRequest) {
        log.info("CADASTRANDO USUARIO - /cadastrarUsuario");

            service.cadastrarUsuario(usuarioPfRequest);

        return ResponseEntity.status(HttpStatus.OK).body("Usuário cadastrado com sucesso");
    }

    @GetMapping("/listarUsuarios")
    public ResponseEntity<List<?>> listaUsuariosController() {
        log.info("LISTANDO USUARIOS - /listarUsuarios");

        List<UsuarioPfResponseDTO> retornoLista = service.listarUsuario();
            return ResponseEntity.ok(retornoLista);

    }

    @PutMapping("/atualizarCadastro")
    public ResponseEntity<?> updateUsuario(@RequestBody UsuarioPfRequest usuarioPfRequest) {
        log.info("ATUALZIANDO USUARIO - /atualizarCadastro");

            service.atualizaUsuario(usuarioPfRequest);

        return ResponseEntity.status(HttpStatus.OK).body("Usuario atualizado com sucesso");
    }

    @PostMapping("/excluirUsiaro")
    public ResponseEntity<?> excluirUsuario(@RequestBody UsuarioPfRequest reqeust){
        log.info("EXCLUINDO USUÁRIO - /excluirUsiaro");

        service.excluirUsuario(reqeust);

        return ResponseEntity.status(HttpStatus.OK).body("Usuario excluido com sucesso");
    }

    @GetMapping("/buscarUsuario/{id}")
    public ResponseEntity<?> buscarUsuario(@PathVariable String id){
        log.info("BUSCANDO USUÁRO - /buscarUsuario");

        UsuarioPfResponseDTO usuario = service.buscarUsuario(id);

        return ResponseEntity.ok(usuario);
    }

}

