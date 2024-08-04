package app;

public class Professor extends PessoaFisica {

    public String areaFormacao, matriculaFUB;

    public String getAreaFormacao() {
        return areaFormacao;
    }

    public String getMatriculaFUB() {
        return matriculaFUB;
    }

    public void setAreaFormacao(String areaFormacao) {
        this.areaFormacao = areaFormacao;
    }

    public void setMatriculaFUB(String matriculaFUB) {
        this.matriculaFUB = matriculaFUB;
    }

    public String toString() {

        return "Nome: " + getNome() + ", CPF: " + getCpf() + ", Email: " + getEmail() + "MatriculaFUB: "
                + getMatriculaFUB()
                + ", Area de Formação: " + areaFormacao + "\n";
    }
}
