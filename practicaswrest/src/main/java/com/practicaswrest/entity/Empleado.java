package com.practicaswrest.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;


    private String nombres;

    private String apellidos;

    private String tipo_documento;

   private String documento;

   private String fecha_nacimiento;

    private String fecha_vinculacion;

    private String cargo;

   private String salario;

   @Transient
   private String edad;

    @Transient
    private String tiempo_Servicio;

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTiempo_Servicio() {
        return tiempo_Servicio;
    }

    public void setTiempo_Servicio(String tiempo_Servicio) {
        this.tiempo_Servicio = tiempo_Servicio;
    }

    public String getEdad() {
        return edad;
    }



    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getFecha_vinculacion() {
        return fecha_vinculacion;
    }

    public void setFecha_vinculacion(String fecha_vinculacion) {
        this.fecha_vinculacion = fecha_vinculacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }
}
