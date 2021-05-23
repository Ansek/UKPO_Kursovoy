/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ansek.ukpo.rest;

import com.github.ansek.ukpo.service.CalculatorService;
import javax.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Александр
 */
@RestController
@RequestMapping("public/rest/calculator")
public class CalculatorRestService {

    // Сервис для вычисления и хранения истории выражений
    private final CalculatorService calculatorService;
    
    public CalculatorRestService() {
        calculatorService = new CalculatorService();
    }
    
    // Запрос на вычисление выражения и сохранения его в истории
    @RequestMapping(value = "/{expression}", method = RequestMethod.GET)
    public ResponseEntity<Object> calculate(@PathVariable("expression") String expression) {
        return ResponseEntity.ok(calculatorService.calculate(expression));
    }
           
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> calculate2(@PathParam("expression") String expression) {
        return ResponseEntity.ok(calculatorService.calculate(expression));
    }
    
    // Запрос на извлечение последнего выражения из истории
    @RequestMapping(value = "/getLast", method = RequestMethod.GET)
    public ResponseEntity<Object> browseCategory() {
        return ResponseEntity.ok(calculatorService.getLastExp());
    }
}
