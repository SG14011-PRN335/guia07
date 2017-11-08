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
    boolean btnVisible=false;
    
    boolean btnadd = false;
    boolean botones = false;
    boolean botones2 = false;
    

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public CategoriaFacadeLocal getFacade() {
        return facade;
    }

    public boolean isBtnVisible() {
        return btnVisible;
    }

    public void setBtnVisible(boolean btnVisible) {
        this.btnVisible = btnVisible;
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
    
    public boolean isBtnadd() {
        return btnadd;
    }

    public void setBtnadd(boolean btnadd) {
        this.btnadd = btnadd;
    }

    public boolean isBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }
    
    public boolean isBotones2() {
        return botones2;
    }

    public void setBotones2(boolean botones2) {
        this.botones2 = botones2;
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
    this.botones = true;
    this.btnadd = true;
    this.botones2=false;
    }

    @Override
    public void cancelar() {
        categoriaEntity = new Categoria();
        this.botones=false;
        this.btnadd=false;
        this.botones2=false;    
    }
    
    @Override
    public void reiniciar() {
        categoriaEntity.setActivo(false);
        categoriaEntity.setDescripcion(null);
        categoriaEntity.setIdCategoria(null);
        categoriaEntity.setNombre(null);
    }
    // </editor-fold>
    
    @PostConstruct
    public void init(){
        llenarLista();
    }

    public void cambiarSeleccion() {
        this.botones = false;
        this.btnadd = true;
        this.botones2=true;

    }

}
