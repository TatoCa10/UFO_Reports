/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Carlos Alberto
 */
public class Reporte {
    
    private Cancion cancion;
    private Album album;
    private ArrayList<Interprete> interprete;
    private int ventas;
    private int puestoReporteAnterior;
    private Date fecha;

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
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

    public int getPuestoReporteAnterior() {
        return puestoReporteAnterior;
    }

    public void setPuestoReporteAnterior(int puestoReporteAnterior) {
        this.puestoReporteAnterior = puestoReporteAnterior;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
}
