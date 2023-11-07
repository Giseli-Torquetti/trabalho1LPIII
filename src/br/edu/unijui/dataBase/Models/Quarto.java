package br.edu.unijui.dataBase.Models;

public class Quarto {
    private int id;
    private String numero;
    private double preco;
    private int tipo;
     private TipoQuarto tipo_rel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }    

    public TipoQuarto getTipo_rel() {
        return tipo_rel;
    }

    public void setTipo_rel(TipoQuarto tipo_rel) {
        this.tipo_rel = tipo_rel;
    }
    
    @Override
    public String toString(){
        return this.getNumero();
    }
    
}
