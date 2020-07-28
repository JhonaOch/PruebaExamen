/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.servicios;

import java.util.List;
import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ups.edu.ec.ejb.AutorFacade;
import ups.edu.ec.ejb.CapitulosFacade;
import ups.edu.ec.ejb.LibroFacade;
import ups.edu.ec.modelo.Libro;

/**
 *
 * @author enriq
 */

@Path("/libros")
public class LibroRest {
    
    @EJB 
    private LibroFacade libroFacade;
    
    @EJB 
    private AutorFacade autorFacade;
    
    @EJB
    private CapitulosFacade capituloFacade;
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        System.out.println("Get libros");
        Jsonb jsonb = JsonbBuilder.create();
        List<Libro> libro = libroFacade.findAll();
        return Response.ok(jsonb.toJson(libro)).header("Access-Control-Allow-Origin", "*").build();
    }
    
    

}
