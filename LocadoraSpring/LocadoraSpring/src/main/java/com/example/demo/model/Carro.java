    package com.example.demo.model;

    import jakarta.persistence.*;

    @Entity
    @Inheritance(strategy = InheritanceType.JOINED)
    public class Carro extends Veiculo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idCarro;
        private String modelo;
        private String marca;
        private int lugares;
        @OneToOne
        @JoinColumn(name = "pessoa_id")
        private Pessoa pessoa;

        public Carro(String renavam, double diaria, Long idCarro, String modelo, String marca, int lugares, Pessoa pessoa) {
            super(renavam, diaria);
            this.idCarro = idCarro;
            this.modelo = modelo;
            this.marca = marca;
            this.lugares = lugares;
            this.pessoa = pessoa;
        }

        public Carro() {
        }

        public Long getIdCarro() {
            return idCarro;
        }

        public void setIdCarro(Long idCarro) {
            this.idCarro = idCarro;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public int getLugares() {
            return lugares;
        }

        public void setLugares(int lugares) {
            this.lugares = lugares;
        }

        public Pessoa getPessoa() {
            return pessoa;
        }

        public void setPessoa(Pessoa pessoa) {
            this.pessoa = pessoa;
        }
    }
