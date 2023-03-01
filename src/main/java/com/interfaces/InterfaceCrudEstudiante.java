package com.interfaces;

import com.modelo.Estudiante;
import java.util.List;

public interface InterfaceCrudEstudiante {

    List listarEstudiante();

    List listarEstudiantes();

    Estudiante selectEstudiante(int id);
    boolean insertEstudiante(int id);

    boolean insertEstudiante(Estudiante estudiante);

    boolean updateEstudiante(Estudiante estudiante);
    boolean deleteEstudiante(int id);
}
