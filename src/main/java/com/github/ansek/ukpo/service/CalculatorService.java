/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ansek.ukpo.service;

import com.github.ansek.ukpo.model.Calculator;
import com.github.ansek.ukpo.model.Responce;
import java.util.Stack;

/**
 *
 * @author Александр
 */
public class CalculatorService {
    // Стек для хранения истории выражений
    private final Stack<String> history;

    public CalculatorService() {
        history = new Stack<>();
    }
    
    /**
     * Формирует ответ для отображения вычисления
     * @param expression Выражение для вычисления
     * @return Ответ с расчитанным значением выражения
     */
    public Responce calculate(String expression) {
        String result;
        Calculator calc = new Calculator();
        
        try {
            // Расчет выражения 
            result = expression + " = " + calc.calculate(expression);
            history.push(expression);   // Добавление выражения в историю
        } catch (Exception ex) {
            result = ex.getMessage();
        }
        
        // Возврат ответа с указанием наличия истории
        return new Responce(result, history.empty());
    }
    
    /**
     * Извлекает последнее выражение из истории
     * @return Ответ с последним посчитанным выражением
     */
    public Responce getLastExp() {
        Responce responce = null;
        
        // Получение значения из истории
        if (!history.empty()) {
            responce = new Responce(history.pop(), history.empty());
        }
        
        return responce;
    }   
}
