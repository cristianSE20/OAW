/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mrysi.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mrysi.servlets.ServletEntidades;

/**
 *
 * @author crist
 */
public abstract class LocalidadesDAOImp implements LocalidadDAO{
    private String TABLE_NAME;
    private ConexionMySQL conMySQL;
    private Connection conn;
    
    public LocalidadesDAOImp(){
        TABLE_NAME = "Localidades";
        conMySQL = new ServletEntidades();
    }
    
    public void insert(Localidad localidad) throws SQLException{
        conn = conMySQL.getConnection();
        String  insertQuery = "INSERT INTO " +TABLE_NAME+" (nombreLocalidad, idEntidad)"
            +"VALUES(?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insertQuery)){
            ps.setString(1, localidad.getNombreLocalidad());
            ps.setInt(2, localidad, getEntidad());
            ps.executeUpdate();
        }
        conn.close();
    }
    
    public void update(Localidad localidad) throws SQLException {
        conn = conMySQL.getConnection();
        String updateQuery = "UPDATE"+TABLE_NAME
                +" SET nombreLocalidad = ?"
                +" , idEntidad = ?"
                +" WHERE idLocalidad = ?";
        try (PreparedStatement ps = conn.prepareStatement(updateQuery)){
            ps.setString(1, localidad.getNombreLocalidad()));
            ps.setInt(2, localidad.getIdEntidad());
            ps.setInt(3, localidad.getIdLocalidad());
            ps.executeUpdate();
        }
        conn.close();
    }
    
    @Override
    public void delete(Integer id) throws SQLException {
        conn = conMySQL.getConnection();
        String deleteQuery = "DELETE FROM "+TABLE_NAME
                +" WHERE idLocalidad = ?";
        try (PreparedStatement ps = conn.prepareStatement(deleteQuery)){
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        conn.close();
    }
    

    @Override
    public abstract Localidad read(Integer id) throws SQLException {
        Localidad  localidad = null;
        EntidadDAOImp edi = new EntidadDAOImp() {};
        conn = conMySQL.getConnection();
        String Query = "SELECT idLocalidad, "
                + "nombreLocalidad, idEntidad FROM "+TABLE_NAME
                + " WHERE idLocalidad = ?";
        try(PreparedStatement ps = conn.prepareStatement(Query)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                   localidad = new Localidad(id,
                        rs.getString("nombreLocalidad"),
                        rs.getInt("idEntidad"));
                   localidad.setEntidad(edi.read(rs.getInt("idEntidad")));
                }
            }
        }
        return localidad;
    }
    
    @Override
    public List<Localidad> readAll() throws SQLException{
        List<Localidad> localidades = new ArrayList();
        conn = conMySQL.getConnection();
        String Query = "SELECT idLocalidad, "
                + "l.nombreLocalidad, l.idEntidad, e.nombreEntidad"
                +" FROM Localidades l JOIN entidades e"
                +" ON l.idEntidad = e.idEntidad";
        try (PreparedStatement ps = conn.prepareStatement(Query)){
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                     Localidad localidad = new Localidad(
                        rs.getInt("idLocalidad"),
                        rs.getString("nombreLocalidad"),
                        rs.getInt("idEntidad"));
                    localidad.setEntidad(new Entidad(
                        rs.getInt("idEntidad"),
                        rs.getString("nombreEntidad")));
                    localidades.add(localidad);
                }
            }
        }
        return localidades;
    }
}
