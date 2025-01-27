package com.springdata.entities.pruebas;

import com.springdata.entities.entity1.Direccion;
import com.springdata.entities.entity1.Estudiante;
import com.springdata.repository.repository1.DireccionRepository;
import com.springdata.repository.repository1.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class prueba01 implements CommandLineRunner {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public void run(String... args) throws Exception {
        Direccion direccion = new Direccion();
        direccion.setCalle("485857 Calle Principal");
        direccion.setCiudad("Ciudad Ejemplo 3");
        direccion.setCodigoPostal("098384");

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Adriano");
        estudiante.setDireccion(direccion);

        estudianteRepository.save(estudiante);

        estudiante.setNombre("Adriano Actualizado");
        estudianteRepository.save(estudiante);

        Iterable<Estudiante> estudiantes = estudianteRepository.findAll();
        for(Estudiante e: estudiantes){
            System.out.printf("Estudiante : " + e.getNombre() + ", Direccion : " + e.getDireccion().getCalle());
        }

        estudianteRepository.delete(estudiante);
    }
}
