package com.practicaswrest.validaciones;


import com.practicaswrest.entity.Empleado;
import com.practicaswrest.exception.CustomException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Validar {
    public Validar() {
    }

    public static Period getEdad(String fecha_nacimiento){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fecha_nacimiento, formatter);
        return Period.between(fechaNacimiento, LocalDate.now());
    }

    public static void isMayor(String fecha_nacimiento) throws CustomException {
        boolean isMayor = (getEdad(fecha_nacimiento).getYears()>=18);
        if(!isMayor){
            throw new CustomException("El empleado es menor de edad");
        }
    }
    public static void nonEmptyFields(Empleado emp) throws CustomException{
        boolean nonEmpty = !emp.getNombres().isEmpty() && !emp.getApellidos().isEmpty() && !emp.getTipo_documento().isEmpty() && !emp.getDocumento().isEmpty() && !emp.getFecha_nacimiento().isEmpty() && !emp.getFecha_vinculacion().isEmpty() && !emp.getCargo().isEmpty() && !emp.getSalario().isEmpty();
        if(!nonEmpty) throw new CustomException("Error en la validacion de campos");
    }

    public static void validateDateFormat(String date)throws CustomException{
        DateFormat fecha = new SimpleDateFormat( "dd/MM/yyyy");
        fecha.setLenient(false);
        try{
            fecha.parse(date);
        }catch (ParseException e) {
            throw new CustomException("la fecha "+ date +"es invalida");
        }
    }

    public static String getFormatoEdad(String fecha_nacimiento){
        Period period= getEdad(fecha_nacimiento);
        return new StringBuilder().append(period.getYears()>0 ? period.getYears() + " años, " : "").append(period.getMonths()>0? period.getMonths() + " meses y " : "").append(period.getDays()).append(" dias").toString();
    }

    public static String getTiempoTranscurrido(String dt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha_calculo= LocalDate.parse(dt, formatter);
        Period period= Period.between(fecha_calculo,LocalDate.now());
        return new StringBuilder().append(period.getYears()>0 ? period.getYears() + " años, " : "").append(period.getMonths()>0? period.getMonths() + " meses y " : "").append(period.getDays()).append(" dias").toString();
    }
}
