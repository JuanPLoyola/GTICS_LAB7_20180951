package org.example.gtics_lab7.Controller;


import org.apache.coyote.Response;
import org.example.gtics_lab7.Entity.Repositorio;
import org.example.gtics_lab7.Entity.Usuario;
import org.example.gtics_lab7.Repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;


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

    @DeleteMapping(value = "/Usuario/Eliminar/{id}")
    public ResponseEntity<HashMap<String, Objects>> borrarUsuario(@PathVariable("id") String idstr){
        HashMap<String, Objects> responseMap = new HashMap<>();

        try {
            int id=Integer.parseInt(idstr);
            if(usuarioRepository.existsById(id)){
                usuarioRepository.deleteById(id);
                responseMap.put("estado", "Eliminado");
                return ResponseEntity.ok(responseMap);
            }else {
                responseMap.put("estado", "error");
                return ResponseEntity.badRequest().body(responseMap);
            }
        } catch (NumberFormatException ex){
            responseMap.put("estado","error");
            return ResponseEntity.badRequest().body(responseMap);
        }
    }
}
