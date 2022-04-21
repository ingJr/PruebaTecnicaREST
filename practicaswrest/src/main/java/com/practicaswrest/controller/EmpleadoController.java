package com.practicaswrest.controller;


import com.practicaswrest.entity.Empleado;
import com.practicaswrest.exception.CustomException;
import com.practicaswrest.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<?> listar(){
        List<Empleado> emp= empleadoService.listar();
        return ResponseEntity.ok(emp);
    }

   @GetMapping("/{codigo}")
   public Optional<Empleado> lista(@PathVariable("codigo") Integer codigo){
      return empleadoService.listaUno(codigo);
  }


    @PostMapping
    public Empleado insertar(@RequestBody @Validated Empleado emp) throws CustomException {
        return empleadoService.insertar(emp);
    }

    @PutMapping
    public Empleado actualizar(@RequestBody @Validated Empleado emp){

        return empleadoService.actualizar(emp);
    }

    @DeleteMapping
    public void eliminar(@RequestBody Empleado emp ){
        empleadoService.eliminar(emp);
    }


}
