/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.controladores;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.AbstractInterface;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.CategoriaFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.Categoria;

/**
 *
 * @author juancarlos
 */
@Named(value = "frmCategoria")
@ViewScoped
public class frmCategoria extends ManagedGenericBean<Categoria> implements Serializable{

    public frmCategoria() {
    }

    @EJB
    CategoriaFacadeLocal facade;
    Categoria categoriaEntity;
    
    boolean mostrar = false, crudBtns=true;

    
    
    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public CategoriaFacadeLocal getFacade() {
        return facade;
    }

    public void setFacade(CategoriaFacadeLocal facade) {
        this.facade = facade;
    }

    public Categoria getCategoriaEntity() {
        return categoriaEntity;
    }

    public void setCategoriaEntity(Categoria categoriaEntity) {
        this.categoriaEntity = categoriaEntity;
    }

    public List<Categoria> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(List<Categoria> listaDatos) {
        this.listaDatos = listaDatos;
    }
    
    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public boolean isCrudBtns() {
        return crudBtns;
    }

    public void setCrudBtns(boolean crudBtns) {
        this.crudBtns = crudBtns;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Overrrides">
    @Override
    public Categoria getEntity() {
        return categoriaEntity;
    }

    @Override
    protected AbstractInterface<Categoria> getFacadeLocal() {
        return facade;
    }

    @Override
    public void nuevo(){
        categoriaEntity = new Categoria();
        setMostrar(true);
        setCrudBtns(true);
    
    }

    @Override
    public void cancelar() {
        categoriaEntity = new Categoria();
        setMostrar(false);
        setCrudBtns(true);
            
    }
    
    @Override
    public void reiniciar() {
        categoriaEntity.setActivo(false);
        categoriaEntity.setDescripcion(null);
        categoriaEntity.setIdCategoria(null);
        categoriaEntity.setNombre(null);
        setMostrar(false);
        setCrudBtns(true);
    }
    // </editor-fold>
    
    @PostConstruct
    public void init(){
        llenarLista();
    }

    public void cambiarSeleccion() {
        setCrudBtns(false);
        setMostrar(true);

    }

}
