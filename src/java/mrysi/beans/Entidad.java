/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mrysi.beans;



public class Entidad implements java.io.Serializable{
    private int idEntidad;
    private String nombreEntidad;
    
    public Entidad(){}
    
    public Entidad(int idEntidad, String nombreEntidad){
        this.idEntidad = idEntidad;
        this.nombreEntidad = nombreEntidad;
    }
    
    public int getIdEntidad(){
        return idEntidad;
    }
    
    public String getNombreEntidad(){
        return nombreEntidad;
    }
    
    public void setIdEntidad(int idEntidad){
        this.idEntidad = idEntidad;
    }
    
    public void setNombreEntidad(String nombreEntidad){
        this.nombreEntidad = nombreEntidad;
    }
}
