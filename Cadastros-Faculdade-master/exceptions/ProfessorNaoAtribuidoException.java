package exceptions;

//Exceção aplicada quando o professor associado à alguma disciplina for nulo

public class ProfessorNaoAtribuidoException extends Exception {
    public ProfessorNaoAtribuidoException(String mensagem) {
        super(mensagem);
    }
}