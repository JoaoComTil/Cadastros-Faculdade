package exceptions;

// Exceção aplicada quando o cadastro de algum termo(matricula, código) ja for utilizado

public class JaCadastradoException extends Exception {
    public JaCadastradoException(String mensagem) {
        super(mensagem);
    }
}
