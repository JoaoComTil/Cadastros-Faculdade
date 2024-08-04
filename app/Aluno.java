package app;

public class Aluno extends PessoaFisica {

    private String matricula, curso;

    public String getCurso() {
        return curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String toString() {

        return "Nome: " + getNome() + ", CPF: " + getCpf() + ", Email: " + getEmail() + ", Matricula: " + matricula
                + ", Curso: " + curso + "\n";
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }

}
