/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.heranca;

import business.heranca.Veiculo;
import java.util.Objects;

/**
 *
 * @author afons
 */
public class VeiculoEletrico extends Veiculo {

    // CONSTRUTOR
    public VeiculoEletrico() {
        super();
    }

    public VeiculoEletrico(String matricula, String marca, String modelo, Integer nChassi, Integer nLugares, Integer nPortas) {
        super(matricula, marca, modelo, nChassi, nLugares, nPortas);
    }

    @Override
    public String toString() {
        return "Veiculo Eletrico: "
                + ",\nmatricula=" + getMatricula()
                + ",\nmarca=" + getMarca()
                + ",\nmodelo=" + getModelo()
                + ",\nnChassi=" + getnChassi()
                + ",\nnLugares=" + getnLugares()
                + ",\nnPortas=" + getnPortas();
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
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.getMatricula(), other.getMatricula())) {
            return false;
        }
        if (!Objects.equals(this.getMarca(), other.getMarca())) {
            return false;
        }
        if (!Objects.equals(this.getModelo(), other.getModelo())) {
            return false;
        }
        if (!Objects.equals(this.getnChassi(), other.getnChassi())) {
            return false;
        }
        if (!Objects.equals(this.getnLugares(), other.getnLugares())) {
            return false;
        }
        return Objects.equals(this.getnPortas(), other.getnPortas());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.getMatricula());
        hash = 97 * hash + Objects.hashCode(this.getMarca());
        hash = 97 * hash + Objects.hashCode(this.getModelo());
        hash = 97 * hash + Objects.hashCode(this.getnChassi());
        hash = 97 * hash + Objects.hashCode(this.getnLugares());
        hash = 97 * hash + Objects.hashCode(this.getnPortas());
        return hash;
    }

}
