package com.modelo;

import com.configuracion.Conexion;
import com.interfaces.InterfaceCrudEstudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EstudianteDAO implements InterfaceCrudEstudiante{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<Estudiante> listarEstudiante() {
        List<Estudiante> estudiantesList = new ArrayList<>();

        try {
            con = cn.getConexion();
            String selectAllEstudiantes = "SELECT * FROM estudiantes";
            ps = con.prepareStatement(selectAllEstudiantes);
            rs = ps.executeQuery();

            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombres(rs.getString("nombres"));
                estudiante.setApellidos(rs.getString("apellidos"));
                estudiante.setFechaCreacion(rs.getString("fechaRegistro"));
                estudiante.setCelular(rs.getString("celular"));
                estudiante.setDocumento(rs.getString("documento"));
                estudiantesList.add(estudiante);
            }

        } catch (SQLException e) {
            System.err.println("Fallo la conexion " + e);

            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return estudiantesList;
    }

    @Override
    public List listarEstudiantes() {
        return null;
    }

    @Override
    public Estudiante selectEstudiante(int id) {
        Estudiante estudiante = new Estudiante();
        try {
            con = cn.getConexion();
            String consultaEstudiantePorIdSql = "SELECT * FROM estudiantes WERE id=?";
            ps = con.prepareStatement(consultaEstudiantePorIdSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombres(rs.getString("nombres"));
                estudiante.setApellidos(rs.getString("apellidos"));
                estudiante.setCelular(rs.getString("celular"));
                estudiante.setDocumento(rs.getString("documento"));
                estudiante.setFechaCreacion(rs.getString("fechaRegistro"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estudiante;

    }

    @Override
    public boolean insertEstudiante(int id) {
        return false;
    }

    @Override
    public boolean insertEstudiante(Estudiante estudiante) {
        try {
            con = cn.getConexion();
            String consultaGuardarEstudianteSql = "INSERT INTO  estudiantes(nombres,apellidos,celular,documento, fechaCreacion) VALUES (?,?,?,?, now());";
            ps = con.prepareStatement(consultaGuardarEstudianteSql);
            ps.setString(1, estudiante.getNombres());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getCelular());
            ps.setString(4, estudiante.getDocumento());
            return ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }

    }

    @Override
    public boolean updateEstudiante(Estudiante estudiante) {
        try {
            con = cn.getConexion();
            String consultaActualizarEstudianteSql = "UPDATE estudiantes SET nombres=?,apellidos=?,celular=?,documento=? WHERE id=?";
            ps = con.prepareStatement(consultaActualizarEstudianteSql);
            ps.setString(1, estudiante.getNombres());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getCelular());
            ps.setString(4, estudiante.getDocumento());
            ps.setInt(5, estudiante.getId());
            ps.executeUpdate();
            return Boolean.TRUE;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }

    }

    @Override
    public boolean deleteEstudiante(int id) {

        try {
            con = cn.getConexion();
            String consultaEliminarEstudianteSql = "DELETE FROM estudiantes WHERE id=?";
            ps.setInt(1, id);
            ps = con.prepareStatement(consultaEliminarEstudianteSql);
            ps.executeUpdate();
            return Boolean.TRUE;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return Boolean.FALSE;
        }

    }
}
