package mrysi.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntidadDAOImp implements EntidadDAO {
    private String TABLE_NAME;
    private ConexionMySQL conMySQL;
    private Connection conn;

    public EntidadDAOImp() {
        TABLE_NAME = "Entidades";
        conMySQL = new ConexionMySQL();
    }

    @Override
    public void insert(Entidad entidad) throws SQLException {
    conn = conMySQL.getConnection();
    String insertQuery = "INSERT INTO " + TABLE_NAME + " (nombreEntidad) VALUES(?)";
    try (PreparedStatement ps = conn.prepareStatement(insertQuery)) {
        ps.setString(1, entidad.getNombreEntidad());
        ps.executeUpdate();
    }
    conn.close();
}


    @Override
    public void update(Entidad entidad) throws SQLException {
        conn = conMySQL.getConnection();
        String updateQuery = "UPDATE " + TABLE_NAME + " SET nombreEntidad = ? WHERE idEntidad = ?";
        try (PreparedStatement ps = conn.prepareStatement(updateQuery)) {
            ps.setString(1, entidad.getNombreEntidad());
            ps.setInt(2, entidad.getIdEntidad());
            ps.executeUpdate();
        }
        conn.close();
    }

    @Override
    public void delete(Integer id) throws SQLException {
        conn = conMySQL.getConnection();
        String deleteQuery = "DELETE FROM " + TABLE_NAME + " WHERE idEntidad = ?";
        try (PreparedStatement ps = conn.prepareStatement(deleteQuery)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        conn.close();
    }

    @Override
    public Entidad read(Integer id) throws SQLException {
        Entidad entidad = null;
        conn = conMySQL.getConnection();
        String query = "SELECT idEntidad, nombreEntidad FROM " + TABLE_NAME + " WHERE idEntidad = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    entidad = new Entidad(id, rs.getString("nombreEntidad"));
                }
            }
        }
        conn.close();
        return entidad;
    }

    @Override
    public List<Entidad> readAll() throws SQLException {
        List<Entidad> entidades = new ArrayList<>();
        conn = conMySQL.getConnection();
        String query = "SELECT idEntidad, nombreEntidad FROM " + TABLE_NAME;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Entidad entidad = new Entidad(rs.getInt("idEntidad"), rs.getString("nombreEntidad"));
                    entidades.add(entidad);
                }
            }
        }
        conn.close();
        return entidades;
    }
}