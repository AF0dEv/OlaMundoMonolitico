/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.heranca;

import java.util.Objects;

/**
 *
 * @author afons
 */
public class VeiculoCombustao extends Veiculo {

    private int cilindrada;

    public VeiculoCombustao(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public VeiculoCombustao(int cilindrada, String matricula, String marca, String modelo, Integer nChassi, Integer nLugares, Integer nPortas) {
        super(matricula, marca, modelo, nChassi, nLugares, nPortas);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.cilindrada);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VeiculoCombustao other = (VeiculoCombustao) obj;
        if (this.getMarca() != other.getMarca()) {
            return false;
        }
        if (this.getModelo() != other.getModelo()) {
            return false;
        }
        if (this.getnChassi() != other.getnChassi()) {
            return false;
        }
        if (this.getnLugares() != other.getnLugares()) {
            return false;
        }
        if (this.getnPortas() != other.getnPortas()) {
            return false;
        }
        if (this.cilindrada != other.cilindrada) {
            return false;
        }
        return Objects.equals(this.getMatricula(), other.getMatricula());
    }

    @Override
    public String toString() {
        return "Veiculo Combustao: "
                + "\nmatricula=" + getMatricula()
                + ",\nmarca=" + getMarca()
                + ",\nmodelo=" + getModelo()
                + ",\nnChassi=" + getnChassi()
                + ",\nnLugares=" + getnLugares()
                + ",\nnPortas=" + getnPortas()
                + ",\ncilindrada=" + cilindrada;
    }

}
