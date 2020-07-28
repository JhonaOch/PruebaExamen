/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author enriq
 */


@Entity
public class Libro implements Serializable{
     private static final long serialVersionUID = 1;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String nombre;
    private String ISBN;
    private int numeroPaginas;
    
    
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonbTransient
    private List< Capitulos> capitulos;

    public Libro() {
        this.capitulos=new ArrayList<>();
    }

    public Libro(String nombre, String ISBN, int numeroPaginas, List<Capitulos> capitulos) {
        this.nombre = nombre;
        this.ISBN = ISBN;
        this.numeroPaginas = numeroPaginas;
        this.capitulos = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public List<Capitulos> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulos> capitulos) {
        this.capitulos = capitulos;
    }

    public void addCapitulo(Capitulos capitulo){
        if (!capitulos.contains(capitulo)) {
            capitulos.add(capitulo);
            
        }
    }
    
    
    
    @Override
    public String toString() {
        return "Libro{" + "codigo=" + codigo + ", nombre=" + nombre + ", ISBN=" + ISBN + ", numeroPaginas=" + numeroPaginas + '}';
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

   
    
    
    
    
    
}
