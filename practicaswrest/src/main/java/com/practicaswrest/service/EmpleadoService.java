package com.practicaswrest.service;

import com.practicaswrest.entity.Empleado;
import com.practicaswrest.exception.CustomException;
import com.practicaswrest.repo.EmpleadoRepo;
import com.practicaswrest.validaciones.Validar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepo empleadoRepo;

    public Empleado insertar(Empleado emp) throws CustomException {
        Validar.nonEmptyFields(emp);
        Validar.validateDateFormat(emp.getFecha_nacimiento());
        Validar.validateDateFormat(emp.getFecha_vinculacion());
        Validar.isMayor(emp.getFecha_nacimiento());
        emp.setEdad(Validar.getFormatoEdad(emp.getFecha_nacimiento()));
        emp.setTiempo_Servicio(Validar.getTiempoTranscurrido(emp.getFecha_vinculacion()));
        return empleadoRepo.save(emp);
    }

    public  Empleado actualizar(Empleado emp){

        return empleadoRepo.save(emp);
    }

    public List<Empleado> listar(){

        return empleadoRepo.findAll();
    }
   public Optional<Empleado> listaUno(Integer codigo){
        return empleadoRepo.findById(codigo);
      }

    public void eliminar(Empleado emp){

        empleadoRepo.delete(emp);
    }
}
