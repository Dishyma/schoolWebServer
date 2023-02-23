package com.modelo;

import com.interfaces.InterfaceCrudEstudiante;
import java.util.List;

public class EstudianteDAO implements InterfaceCrudEstudiante{
    @Override
    public List listarEstudiante() {
        return null;
    }

    @Override
    public Estudiante selectEstudiante(int id) {
        return null;
    }

    @Override
    public boolean insertEstudiante(int id) {
        return false;
    }

    @Override
    public boolean updateEstudiante(Estudiante estudiante) {
        return false;
    }

    @Override
    public boolean deleteEstudiante(int id) {
        return false;
    }
}
