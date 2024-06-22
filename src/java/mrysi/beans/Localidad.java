/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mrysi.beans;

/**
 *
 * @author crist
 */
public class Localidad implements java.io.Serializable{
    private int idLocalidad;
    private String nombreLocalidad;
    private int idEntidad;
    private Entidad entidad;
    
    public Localidad(){}
    
    public Localidad(int idLocalidad, String nombreLocalidad,
        int idEntidad, Entidad Entidad){
        this.idLocalidad = idLocalidad;
        this.nombreLocalidad = nombreLocalidad;
        this.idEntidad = idEntidad;
        this.entidad = Entidad;
    }

    public Localidad(int i, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Localidad(int i, String name, int idEntidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
   