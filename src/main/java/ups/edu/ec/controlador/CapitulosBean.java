/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.annotation.FacesConfig;

/**
 *
 * @author enriq
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named(value = "capitulosBean")
@SessionScoped
public class CapitulosBean implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Creates a new instance of CapitulosBean
     */
    public CapitulosBean() {
    }
    
}
