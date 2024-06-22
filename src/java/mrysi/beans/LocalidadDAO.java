package mrysi.beans;

import java.sql.SQLException;
import java.util.List;

public interface LocalidadDAO {
    public void insert(Localidad localidad) throws SQLException;
    public void update(Localidad localidad) throws SQLException;
    public void delete(Integer id) throws SQLException;
    public Localidad read(Integer id) throws SQLException;
    public List<Localidad> readAll() throws SQLException;
}