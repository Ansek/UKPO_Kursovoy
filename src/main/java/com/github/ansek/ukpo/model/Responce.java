/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ansek.ukpo.model;

/**
 *
 * @author Александр
 */
public class Responce {
    
    private final String result;    // Результат запроса
    private final boolean empty;    // Является ли история вычисления пустой
    
    public Responce(String result, boolean empty) {
        this.result = result;
        this.empty = empty;
    }
    
    public String getResult() {
        return result;
    }
    
    public boolean getEmpty() {
        return empty;
    }
}
