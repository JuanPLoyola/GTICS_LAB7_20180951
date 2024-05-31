package org.example.gtics_lab7.Controller;


import org.example.gtics_lab7.Entity.Repositorio;
import org.example.gtics_lab7.Entity.Usuario;
import org.example.gtics_lab7.Repository.UsuarioRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/Usuario")
public class UsuarioController {

final UsuarioRepository usuarioRepository;


    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("")
    public List<Usuario> listar(){return usuarioRepository.findAll();}

    @GetMapping("/Contabilidad")
    public String pagContabilidad(Usuario usuario){
        if (usuario.getIdautorizacion() == 1){
            return "/Contabilidad";
        }
        else
            return "redirect:/Usuario";
    }

    @GetMapping("/Cliente")
    public String pagCliente(Usuario usuario){
        if (usuario.getIdautorizacion() == 2){
            return "/Cliente";
        }
        else
            return "redirect:/Usuario";
    }

    @GetMapping("/Promociones")
    public String pagPromociones(Usuario usuario){
        if (usuario.getIdautorizacion() == 3){
            return "/Promociones";
        }
        else
            return "redirect:/Usuario";
    }

    @GetMapping("/Impresoras")
    public String PagImpresoras(Usuario usuario){
        if (usuario.getIdautorizacion() == 4){
            return "/Impresoras";
        }
        else
            return "redirect:/Usuario";
    }
}
