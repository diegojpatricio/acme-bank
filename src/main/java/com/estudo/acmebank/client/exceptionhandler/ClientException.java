
package com.estudo.acmebank.client.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

/**
 * A anotação @ControllerAdvice é um componente do Spring
 * para tratar as exeções da classe controladora.
 * *****
 * A classe ResponseEntityExceptionHandler já disponibiliza
 * vários tratamentos de exeções
 * */
@ControllerAdvice
public class ClientException extends ResponseEntityExceptionHandler {

    /**
     * Este método retorna um ResponseEntity para escrever na resposta com a message converter,
     * em contraste com o DefaultHandlerExceptionResolverqual retorna a ModelAndView.
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        //instanciando a classe Problem
        var problem = new Problem();
        problem.setStatus(status.value());
        problem.setTitulo("Campo(s) Incorreto(s)! Verifique e tente novamente!");
        problem.setDataHora(LocalDateTime.now());


        return super.handleExceptionInternal(ex, problem, headers, status, request);
    }
}
