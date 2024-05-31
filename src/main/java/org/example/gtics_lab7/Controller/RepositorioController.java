package org.example.gtics_lab7.Controller;


import org.example.gtics_lab7.Entity.Repositorio;
import org.example.gtics_lab7.Entity.Usuario;
import org.example.gtics_lab7.Repository.RepositorioRepository;
import org.example.gtics_lab7.Repository.UsuarioRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/Repositorio")
public class RepositorioController {

final RepositorioRepository repositorioRepository;
final UsuarioRepository usuarioRepository;

    public RepositorioController(RepositorioRepository repositorioRepository, UsuarioRepository usuarioRepository) {
        this.repositorioRepository = repositorioRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/listarrepositorios")
    public List<Repositorio> listar(){return repositorioRepository.findAll();}

    @GetMapping("/Autorizados")
    public Optional<Usuario> listar(Repositorio repositorio){
        return usuarioRepository.findById(repositorio.getId());
    }
}
