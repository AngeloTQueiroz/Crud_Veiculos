package crud_veiculos.crudVeiculos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private double valor;
    private boolean tipo; // false = Moto, true = Carro


    public Veiculo() {
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getValor() {
        return valor;
    }

    public boolean isTipo() { return tipo; } // a IDE acusou e orientou a colocar 'IS' por se tratar de um boleano
    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo; }

}