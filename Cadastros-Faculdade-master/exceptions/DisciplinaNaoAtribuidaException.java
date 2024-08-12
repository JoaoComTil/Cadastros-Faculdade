package exceptions;

// Exceção aplicada quando não o codigo da disciplina for nulo

public class DisciplinaNaoAtribuidaException extends Exception {
    public DisciplinaNaoAtribuidaException(String mensagem) {
        super(mensagem);
    }

}
