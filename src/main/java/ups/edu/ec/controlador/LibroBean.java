/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.annotation.FacesConfig;
import ups.edu.ec.ejb.AutorFacade;
import ups.edu.ec.ejb.CapitulosFacade;
import ups.edu.ec.ejb.LibroFacade;
import ups.edu.ec.modelo.Autor;
import ups.edu.ec.modelo.Capitulos;
import ups.edu.ec.modelo.Libro;

/**
 *
 * @author enriq
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named(value = "libroBean")
@SessionScoped
public class LibroBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private LibroFacade libroFacade;
    
    @EJB
    private AutorFacade autorFacade;
    
    @EJB
    private CapitulosFacade capituloFacde;
    
    
    
    private String nombre;
    private String ISBN;
    private int numeroPaginas;
    
    private int numero;
    private String titulo;
    
    private Libro libro;
    
    private Autor autor;
    
    private Capitulos capitulo;
    
    private String nombreAutor;
    
    
    private List<Capitulos>capitulos;
    private List<Autor>autores;
    private List<Libro>libros;
    
    

    /**
     * Creates a new instance of LibroBean
     */
    public LibroBean() {
    }
    
     @PostConstruct
    public void init() {
        try {
            this.libros= libroFacade.findAll();
            this.autores=autorFacade.findAll();
            this.capitulos=new ArrayList<>();
            
            
        } catch (Exception e) {
            System.out.println("Error---" + e);
        }
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

   

    public Capitulos getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(Capitulos capitulo) {
        this.capitulo = capitulo;
    }
    

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    public LibroFacade getLibroFacade() {
        return libroFacade;
    }

    public void setLibroFacade(LibroFacade libroFacade) {
        this.libroFacade = libroFacade;
    }

    public AutorFacade getAutorFacade() {
        return autorFacade;
    }

    public void setAutorFacade(AutorFacade autorFacade) {
        this.autorFacade = autorFacade;
    }

    public CapitulosFacade getCapituloFacde() {
        return capituloFacde;
    }

    public void setCapituloFacde(CapitulosFacade capituloFacde) {
        this.capituloFacde = capituloFacde;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

   

    public List<Capitulos> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulos> capitulos) {
        this.capitulos = capitulos;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
    
    public void guardarDatos(){
         this.libro=new Libro();
        
        libro.setNombre(this.nombre);
        libro.setISBN(this.ISBN);
        libro.setNumeroPaginas(this.numeroPaginas);
        
        System.out.println("numero paginas Libros"+libro.getNumeroPaginas());
        
  
        
        libroFacade.create(libro);
        
        this.libros=libroFacade.findAll();
        
        
    }
    
    public void guardarCapitulos(){
        
        Capitulos capitulo = new Capitulos();
        capitulo.setNumero(numero);
        capitulo.setTitulo(titulo);
        
        capitulo.setLibro(this.libro);
        capitulo.setAutor(this.autor);
        
        libro.addCapitulo(capitulo);
        
        System.out.println("Capitulo adsjfjhksd");
          
        capituloFacde.create(capitulo);
        

       this.capitulos.add(capitulo);
       
       
       
       limpiar();
       
    
        
    }
    
    
    public void datosTotales(){
        this.libro.setCapitulos(capitulos);
        libroFacade.edit(libro);
    }

    
    public void limpiar(){
        this.numero=0;
        this.titulo="";
    }
    
    
    public void buscarPorNombre() {
        
        System.out.println("AUTOR........."+nombreAutor);
       if (this.nombreAutor !=null) {
           
            this.autores=autorFacade.findByName(this.nombreAutor);
            
            System.out.println("lista ========"+autores);
            
            
        }else{
            this.autores=this.autorFacade.findAll();
        }
      System.out.println("lista ========"+autores);
        nombreAutor= null;
    }
    
}
