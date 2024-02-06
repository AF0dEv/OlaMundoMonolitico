package business.heranca;

import java.util.Objects;

/**
 *
 * @author efapro01.23
 */
public class Veiculo {

    // ================= ESTADO ===================
    // VARIÁVEIS DA INSTÂNCIA
    private String matricula;
    private String marca;
    private String modelo;
    private Integer nChassi;
    private Integer nLugares;
    private Integer nPortas;

    // Construtor DEFAULT
    /**
     *
     */
    public Veiculo() {

    }
    // Construtor

    /**
     *
     * @param matricula
     * @param marca
     * @param modelo
     * @param nChassi
     * @param nLugares
     * @param nPortas
     */
    public Veiculo(String matricula, String marca, String modelo, Integer nChassi, Integer nLugares, Integer nPortas) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.nChassi = nChassi;
        this.nLugares = nLugares;
        this.nPortas = nPortas;
    }

    /**
     *
     * @return
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     *
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     *
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     *
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     *
     * @return
     */
    public Integer getnChassi() {
        return nChassi;
    }

    /**
     *
     * @param nChassi
     */
    public void setnChassi(Integer nChassi) {
        this.nChassi = nChassi;
    }

    /**
     *
     * @return
     */
    public Integer getnLugares() {
        return nLugares;
    }

    /**
     *
     * @param nLugares
     */
    public void setnLugares(Integer nLugares) {
        this.nLugares = nLugares;
    }

    /**
     *
     * @return
     */
    public Integer getnPortas() {
        return nPortas;
    }

    /**
     *
     * @param nPortas
     */
    public void setnPortas(Integer nPortas) {
        this.nPortas = nPortas;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.matricula);
        hash = 97 * hash + Objects.hashCode(this.marca);
        hash = 97 * hash + Objects.hashCode(this.modelo);
        hash = 97 * hash + Objects.hashCode(this.nChassi);
        hash = 97 * hash + Objects.hashCode(this.nLugares);
        hash = 97 * hash + Objects.hashCode(this.nPortas);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
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
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.nChassi, other.nChassi)) {
            return false;
        }
        if (!Objects.equals(this.nLugares, other.nLugares)) {
            return false;
        }
        return Objects.equals(this.nPortas, other.nPortas);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Veiculo: "
                + "\nmatricula=" + matricula
                + ",\nmarca=" + marca
                + ",\nmodelo=" + modelo
                + ",\nnChassi=" + nChassi
                + ",\nnLugares=" + nLugares
                + ",\nnPortas=" + nPortas;
    }

}
