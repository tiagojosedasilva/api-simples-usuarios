package com.api7.apisimplesusuarios.controller;

import com.api7.apisimplesusuarios.model.Usuarios;
import com.api7.apisimplesusuarios.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class ControllerUsuarios {

    @Autowired
    public RepositorioUsuario repositorio;

    @GetMapping
    public List<Usuarios> getAll(){
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuarios> getById(@PathVariable Long id){
        return repositorio.findById(id);
    }

    @PostMapping
    public String post(@RequestBody Usuarios usuarios){
        repositorio.save(usuarios);
        return "Usuário cadastrado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        if (repositorio.findById(id).isPresent()){
            repositorio.deleteById(id);
            return "Excluído com sucesso!";
        }
        return "Usuário não encotrado.";
    }

    @PutMapping("/{id}")
    public String put(@PathVariable Long id, @RequestBody Usuarios usuariosAtualizado){
        Optional<Usuarios> optionalUsuarios = repositorio.findById(id);
        if (optionalUsuarios.isPresent()){
            Usuarios usuarios = optionalUsuarios.get();
            usuarios.setNome(usuariosAtualizado.getNome());
            usuarios.setEmail(usuariosAtualizado.getEmail());
            usuarios.setNumero(usuariosAtualizado.getNumero());
            repositorio.save(usuarios);
            return "Usuário atualizado com sucesso!";
        }
        return "Usuário não encontrado.";
    }
}
