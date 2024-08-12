package exceptions;

// Exceção mais geral aplicada pra várias classes que não tem um temo cadastrado

public class NaoCadastradoException extends Exception {
    public NaoCadastradoException(String mensagem) {

        super(mensagem);
    }

}
