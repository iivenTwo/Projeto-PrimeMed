package examples.model;

import java.time.LocalDate;

public class Usuario {
    private int id;  // Gerado automaticamente pelo banco
    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private String sexo;
    private String estadoCivil;
    private String rg;
    private String cep;
    private String endereco;
    private String telefone;
    private String crm;
    private String tipoUsuario;
    private String especialidade;

    public Usuario() {
    }

    // Construtor com todos os campos (exceto o id que o banco gera automaticamente)
    public Usuario(String nomeColaborador, String cpfColaborador, LocalDate dataNascColaborador, String generoColaborador,
                   String estadoCivilColaborador, String rgColaborador, String cepColaborador, String enderecoColaborador,
                   String telefoneColaborador, String crmColaborador, String tipoUsuario, String especialidadeColaborador) {
        this.nome = nomeColaborador;
        this.cpf = cpfColaborador;
        this.nascimento = dataNascColaborador;
        this.sexo = generoColaborador;
        this.estadoCivil = estadoCivilColaborador;
        this.rg = rgColaborador;
        this.cep = cepColaborador;
        this.endereco = enderecoColaborador;
        this.telefone = telefoneColaborador;
        this.crm = crmColaborador;
        this.tipoUsuario = tipoUsuario;
        this.especialidade = especialidadeColaborador;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", cpf='" + cpf + '\'' +
               ", nascimento=" + nascimento +
               ", sexo='" + sexo + '\'' +
               ", estadoCivil='" + estadoCivil + '\'' +
               ", rg='" + rg + '\'' +
               ", cep='" + cep + '\'' +
               ", endereco='" + endereco + '\'' +
               ", telefone='" + telefone + '\'' +
               ", crm='" + crm + '\'' +
               ", tipoUsuario='" + tipoUsuario + '\'' +
               ", especialidade='" + especialidade + '\'' +
               '}';
    }
}
