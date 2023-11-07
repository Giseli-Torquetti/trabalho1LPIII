/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.unijui.dataBase.Models;

import java.sql.Date;

/**
 *
 * @author gisel
 */
public class Reserva {
    
    private int id;
    private int quarto;   
    private int cliente;    
    private Date checkin;    
    private Date checkout;
    private Quarto quarto_rel;
    private Cliente cliente_rel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public Quarto getQuarto_rel() {
        return quarto_rel;
    }

    public void setQuarto_rel(Quarto quarto_rel) {
        this.quarto_rel = quarto_rel;
    }

    public Cliente getCliente_rel() {
        return cliente_rel;
    }

    public void setCliente_rel(Cliente cliente_rel) {
        this.cliente_rel = cliente_rel;
    }
    
    

    
    
}
