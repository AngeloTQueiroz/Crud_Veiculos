package crud_veiculos.crudVeiculos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private double saldo;

    // atributos privados pq eu li que funciona melhor assim com encapsulamento


    // eu idealizei criar esse construtor solicitando todos os atributos da classe como parametro para que nada ficasse vazio, mas descobri que o JPA precisa dele vazio para 'cria-lo automaticamente', pelo menos foi isso que eu entendi.
    public Cliente(){}

    // metodos get
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }

    public double getSaldo(){
        return saldo;
    }

    // metodos setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

