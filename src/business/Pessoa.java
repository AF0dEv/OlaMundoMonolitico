package business;

import business.heranca.Veiculo;
import business.heranca.VeiculoCombustao;
import business.heranca.VeiculoEletrico;
import exceptions.MaximoVeiculosException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author efapro01.23
 */
public class Pessoa {

    // =================== ESTADO ======================
    // Var¡aveis de INSTÃNCIA
    private Integer cc;
    private String nome;
    private Integer idade;
    // <> -> Generics
    private ArrayList<Veiculo> veiculos = new ArrayList<>();
    private ArrayList<String> contactos = new ArrayList<>();

    /**
     *
     * @param nome
     * @param idade
     */
    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    /**
     *
     */
    public Pessoa() {
    }

    /**
     *
     * @return
     */
    public Integer getCc() {
        return cc;
    }

    /**
     *
     * @param cc
     */
    public void setCc(Integer cc) {
        this.cc = cc;
    }

    /**
     * Get the value of string
     *
     * @return the value of string
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set the value of string
     *
     * @param nome new value of string
     * @throws exceptions.NomeInvalidoException
     */
    public void setNome(String nome) { //throws NomeInvalidoException
//        if (nome.length() == 0) {
//            throw new NomeInvalidoException("O nome nao pode ser vazio");
//        }
//
//        if (nome.length() < 6) {
//            throw new NomeInvalidoException("O nome tem de Possuir mais de 6 carateres");
//        }

        this.nome = nome;
    }

    /**
     * Metodo que permite devolver a idade registrada no objeto.
     *
     * @return valor da variavel contendo a idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Set valor da idade
     *
     * @param idade novo valor da idade
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }
//
//    public String dameAsTuasVariaveis() {
//        String str = "";
//        str += "Classe Pessoa {";
//        str += "nome: " + getNome();
//        str += " idade: " + getIdade();
//        str += "}";
//
//        return str;
//    }

    /**
     *
     * @param contacto
     * @return
     */
    public boolean setContacto(String contacto) {
        return contactos.add(contacto);
    }

    /**
     *
     * @param contacto
     * @return
     */
    public boolean removerContacto(String contacto) {
        return contactos.remove(contacto);
    }

    /**
     *
     * @param vc
     * @param ve
     * @throws exceptions.MaximoVeiculosException
     */
    public void setVeiculo(VeiculoCombustao vc, VeiculoEletrico ve) throws MaximoVeiculosException {

        if (veiculos.size() > 2) {
            throw new MaximoVeiculosException("Uma pessoa Não pode ter mais de 3 Veiculos!");
        } else {
            if (vc != null) {
                veiculos.add(vc);
            } else if (ve != null) {
                veiculos.add(ve);
            }

        }

    }

    /**
     *
     * @return
     */
    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getContactos() {
        return contactos;
    }

    /**
     *
     * @param veiculo
     * @return
     */
    public boolean removerVeiculo(Veiculo veiculo) {
        return veiculos.remove(veiculo);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + this.idade;
        hash = 89 * hash + Objects.hashCode(this.contactos);
        hash = 89 * hash + Objects.hashCode(this.veiculos);
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
        final Pessoa other = (Pessoa) obj;
        if (this.idade != other.idade) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.contactos, other.contactos)) {
            return false;
        }
        return Objects.equals(this.veiculos, other.veiculos);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", idade=" + idade + ", contactos=" + contactos + ", veiculos=" + veiculos + '}';
    }

}
