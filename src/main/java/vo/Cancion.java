/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.ArrayList;

/**
 *
 * @author Carlos Alberto
 */
public class Cancion {
    
    private String id;
    private String nombre;
    private ArrayList<Interprete> interprete;
    private int ventas;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Interprete> getInterprete() {
        return interprete;
    }

    public void setInterprete(ArrayList<Interprete> interprete) {
        this.interprete = interprete;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
    
    
}
