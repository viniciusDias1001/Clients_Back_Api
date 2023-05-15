package io.github.vinicus1001.Zero20.exception;

public class UsuarioCadastradoException extends RuntimeException{

    public UsuarioCadastradoException() {
        super("Usuario já cadastrado");
    }
}
