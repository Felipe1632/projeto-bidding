/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bidding.system.bidding.model;

import java.sql.Timestamp;

/**
 *
 * @author Aluno
 */
public class LanceDTO {
    private Long id;
    private Float valor;
    private Timestamp data_lance;
    private Long id_edital;
    private Long id_usuario;

    public LanceDTO() {
    }

    public LanceDTO(Long id, Float valor, Timestamp data_lance, Long id_edital, Long id_usuario) {
        this.id = id;
        this.valor = valor;
        this.data_lance = data_lance;
        this.id_edital = id_edital;
        this.id_usuario = id_usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Timestamp getData_lance() {
        return data_lance;
    }

    public void setData_lance(Timestamp data_lance) {
        this.data_lance = data_lance;
    }

    public Long getId_edital() {
        return id_edital;
    }

    public void setId_edital(Long id_edital) {
        this.id_edital = id_edital;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}
