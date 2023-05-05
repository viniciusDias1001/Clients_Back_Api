package io.github.vinicus1001.Zero20.Controller;

import io.github.vinicus1001.Zero20.error.ApiErros;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicatonControllerAdvice {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handlevalidationErros(MethodArgumentNotValidException exception){
        BindingResult bindingResult = exception.getBindingResult();
      List<String> messagens =  bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
        return new ApiErros(messagens);

    }


    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErros handlevalidationErros(ResponseStatusException exception){
        String menssagem = exception.getMessage();
        return new ApiErros(menssagem);

    }
}
