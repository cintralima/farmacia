package com.farmacia.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


    @Entity
    @Table(name = "tb_produto")
    public class Produto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @NotNull
        private String descricao;

        @NotNull
        private double valor;
        @NotNull
        private int estoque;

        @ManyToOne
        @JsonIgnoreProperties("produto")
        private com.farmacia.models.Categoria categoria;





        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public int getEstoque() {
            return estoque;
        }

        public void setEstoque(int estoque) {
            this.estoque = estoque;
        }

        public com.farmacia.models.Categoria getCategoria() {
            return categoria;
        }

        public void setCategoria(com.farmacia.models.Categoria categoria) {
            this.categoria = categoria;
        }
    }