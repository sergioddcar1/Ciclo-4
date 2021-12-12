package co.edu.unab.api_rest_articulo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.api_rest_articulo.models.ArticuloModel;
import co.edu.unab.api_rest_articulo.services.ArticuloService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/articulo")

public class ArticuloController {
    @Autowired
    ArticuloService articuloService;

    @GetMapping()
    public ArrayList <ArticuloModel> obtenerArticulos(){
        return articuloService.obtenerArticulos();
    }

    @PostMapping()
    public ArticuloModel guardarArticulo(@RequestBody ArticuloModel articulo){
        return articuloService.guardarArticulo(articulo);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarArticuloPorId(@PathVariable("id") String id){
        if(articuloService.eliminarArticulo(id)){
            return "Se eliminó correctamente el artículo con Id: " + id;
        }else{
            return "No existe un artículo con Id: " + id;
        }
    }

    @GetMapping("/{id}")
    public Optional<ArticuloModel> obtenerArticuloPorId(@PathVariable("id") String id){
        return articuloService.obtenerPorId(id);
    }

    @GetMapping("/categoria/{categoria}")
    public ArrayList<ArticuloModel> obtenerArticuloPorCategoria(@PathVariable("categoria") String categoria){
        return articuloService.obtenerPorCategoria(categoria);
    }

    @GetMapping("/nombre/{nombre}")
    public ArrayList<ArticuloModel> obtenerArticuloPorNombre(@PathVariable("nombre") String nombre){
        return articuloService.obtenerPorNombre(nombre);
    }

    @GetMapping("/precio/{precio}")
    public ArrayList<ArticuloModel> obtenerArticuloPorPrecioMayorIgual(@PathVariable("precio") Long precio){
        return articuloService.obtenerPorPrecioMayorIgual(precio);
    }

    @GetMapping("/cantidad/{cantidad}")
    public ArrayList<ArticuloModel> obtenerArticuloPorCantidadMenorIgual(@PathVariable("cantidad") int cantidad){
        return articuloService.obtenerPorCantidadMenorIgual(cantidad);
    }
    
}
