/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.controladores;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.AbstractInterface;

/**
 *
 * @author juancarlos
 */
public abstract class ManagedGenericBean<T> implements Serializable {

    List<T> listaDatos;
    
    @Inject
    ManagedBeanLanguages lenguages;
    
    /**
     * Este metodo sirve para crear un nuevo un registro
     */
    public void crear() {
       if (getFacadeLocal() != null) {
            try {
                System.out.println("Llego aqui");
                getFacadeLocal().create(getEntity());
                llenarLista();
                reiniciar();
                showMessage(lenguages.getMensaje("save.succes"));
            } catch (Exception ex) {
                showMessage(lenguages.getMensaje("save.error"));
                System.out.println("Error: " + ex);
            }
        }
    }

    /**
     * Este metodo sirve para editar un registro
     */
    public void editar() {
        if (getFacadeLocal() != null) {
            try {
                System.out.println("Llego aqui");
                getFacadeLocal().edit(getEntity());
                llenarLista();
                reiniciar();
                showMessage(lenguages.getMensaje("edit.succes"));
            } catch (Exception ex) {
                showMessage(lenguages.getMensaje("edit.error"));
                System.out.println("Error: " + ex);
            }
        }
    }

    /**
     * Este metodo sirve para eliminar un registro
     */
    public void eliminar() {
        if (getFacadeLocal() != null) {
            try {
                System.out.println("Llego aqui");
                getFacadeLocal().remove(getEntity());
                llenarLista();
                reiniciar();
                showMessage(lenguages.getMensaje("delete.succes"));
            } catch (Exception ex) {
                showMessage(lenguages.getMensaje("prop.msmNoEliminado"));
                System.out.println("Error: " + ex);
            }
        }
    }

    /**
     * Este metodo sirve para llenar una lista de datos obtenidos de la base de
     * datos
     */
    public void llenarLista() {
        if (getFacadeLocal().findAll() != null) {
            this.listaDatos = getFacadeLocal().findAll();
        } else {
            this.listaDatos = Collections.EMPTY_LIST;
        }
    }
    
    
    /**
     * metodo para imprimir un msm en la interfaz 
     * @param Mensaje variable donde se guarda el mensaje a imprimir en jsf
     */
    public void showMessage(String Mensaje) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(Mensaje));
    }

    /**
     * 
     * @return se espera que retorne el una interfaz de algun tipo para trabajar con ell
     */
    protected abstract AbstractInterface<T> getFacadeLocal();

    /**
     *
     * @return se espera que retorne una entitdad para trabajar con ella
     */
    public abstract T getEntity();
    
    public abstract void nuevo();
    
    public abstract void cancelar();
    
    public abstract void reiniciar();
    

}
