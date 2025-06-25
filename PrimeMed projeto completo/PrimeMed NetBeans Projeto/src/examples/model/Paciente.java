package examples.model;

import java.time.LocalDate;

public class Paciente {
    private int id;  // Gerado automaticamente pelo banco
    private String nome;
    private LocalDate nascimento;
    private String sexo;
    private String cpf;
    private String rg;
    private String cep;
    private String endereco;
    private String estadoCivil;
    private String numeroConvenio;
    private String telefone;
    private String email;
    private String convenio;  // 'Sim' ou 'Não' conforme Enum do banco

    public Paciente() {
    }

    // Construtor completo (sem id porque o banco gera automaticamente)
    public Paciente(String nome, LocalDate nascimento, String sexo, String cpf, String rg, String cep, String endereco,
                    String estadoCivil, String numeroConvenio, String telefone, String email, String convenio) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.cpf = cpf;
        this.rg = rg;
        this.cep = cep;
        this.endereco = endereco;
        this.estadoCivil = estadoCivil;
        this.numeroConvenio = numeroConvenio;
        this.telefone = telefone;
        this.email = email;
        this.convenio = convenio;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(String numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", sexo='" + sexo + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", cep='" + cep + '\'' +
                ", endereco='" + endereco + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", numeroConvenio='" + numeroConvenio + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", convenio='" + convenio + '\'' +
                '}';
    }
}
