package co.edu.unab.api.controllers;

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

import co.edu.unab.api.models.ClienteModel;
import co.edu.unab.api.services.ClienteService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ArrayList<ClienteModel> obtenerClientes(){
        return  clienteService.obtenerClientes();
    }

    @PostMapping()
    public ClienteModel guardarCliente(@RequestBody ClienteModel cliente){
        
        return clienteService.guardarCliente(cliente);
    }
    
    @DeleteMapping(path = "/{id}")
    public String eliminarClientePorId(@PathVariable("id") String id){
        boolean resultadoEliminar=this.clienteService.eliminarCliente(id);
        if (resultadoEliminar){
            return "Se eliminĂ³ el usuario con id: "+id;
        }else{
            return "No se pudo eliminar el usuario con el id: "+id;
        }
    }
    
    @GetMapping(path = "/{id}")
    public Optional<ClienteModel> obtenerClientePorId(@PathVariable("id") String id){
        return this.clienteService.obtenerClientePorId(id);
    }

    @GetMapping("/nombre/{nombre}")
    public ArrayList<ClienteModel> obtenerArticuloPorNombre(@PathVariable("nombre") String nombre){
        return clienteService.obtenerPorNombre(nombre);
    }

    @GetMapping(path="/nombre/{nombre}/apellido/{apellido}")
    public ArrayList<ClienteModel> obtenerClientePorNombreApellido(@PathVariable("nombre") String nombre, @PathVariable("apellido") String apellido){
        return clienteService.obtenerPorNombreApellido(nombre, apellido);
    }

    @GetMapping("/puntos/{puntos}")
    public ArrayList<ClienteModel> obtenerArticuloPorPuntosMayorIgual(@PathVariable("puntos") Long puntos){
        return clienteService.obtenerPorPuntosMayorIgual(puntos);
    }

    @GetMapping("/puntos/{puntos}")
    public ArrayList<ClienteModel> obtenerArticuloPorPuntosMenorIgual(@PathVariable("puntos") Long puntos){
        return clienteService.obtenerPorPuntosMenorIgual(puntos);
    }

    @GetMapping(path="/address/{ciudad}")
    public ArrayList<ClienteModel> obtenerClientePorCiudad(@PathVariable("ciudad") String ciudad){
        return clienteService.obtenerPorCiudad(ciudad);
    }
}