package co.edu.unab.api_rest_articulo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.api_rest_articulo.models.ArticuloModel;
import co.edu.unab.api_rest_articulo.repositories.ArticuloRepository;

@Service
public class ArticuloService {
    
    @Autowired
    ArticuloRepository articuloRepository;

    public ArrayList<ArticuloModel> obtenerArticulos(){
        return (ArrayList<ArticuloModel>) articuloRepository.findAll();
    }

    public ArticuloModel guardarArticulo(ArticuloModel articulo){
        return articuloRepository.save(articulo);
    }

    public boolean eliminarArticulo(String id){
        if(articuloRepository.existsById(id)){
            articuloRepository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }

    public Optional<ArticuloModel> obtenerPorId(String id){
        return articuloRepository.findById(id);
    }

    public ArrayList<ArticuloModel> obtenerPorCategoria(String categoria){
        return articuloRepository.findByCategoria(categoria);
    }

    public ArrayList<ArticuloModel> obtenerPorNombre(String nombre){
        return articuloRepository.findByNombre(nombre);
    }

    public ArrayList<ArticuloModel> obtenerPorPrecioMayorIgual(Long precio){
        return articuloRepository.findByPrecioGreaterThanEqual(precio);
    }

    public ArrayList<ArticuloModel> obtenerPorCantidadMenorIgual(int cantidad){
        return articuloRepository.findByCantidadLessThanEqual(cantidad);
    }

    
}
