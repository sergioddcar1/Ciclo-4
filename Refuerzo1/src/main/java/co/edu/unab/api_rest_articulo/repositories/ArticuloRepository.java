package co.edu.unab.api_rest_articulo.repositories;


import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.unab.api_rest_articulo.models.ArticuloModel;



public interface ArticuloRepository extends MongoRepository<ArticuloModel, String>{
    ArrayList<ArticuloModel> findByCategoria(String categoria);
    ArrayList<ArticuloModel> findByNombre(String nombre);
    ArrayList<ArticuloModel> findByPrecioGreaterThanEqual(Long precio);
    ArrayList<ArticuloModel> findByCantidadLessThanEqual(int cantidad);
}
