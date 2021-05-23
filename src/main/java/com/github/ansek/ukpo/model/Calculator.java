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
public class Calculator {
    
    private String exp; // Строка выражания для разбора
    private int i;      // Индекс разбираемого символа
    
    /**
     * Запускает процесс разбора и вычисления выражения
     * @param exp Выражение
     * @return Результат вычисления
     * @throws java.lang.Exception
     */
    public String calculate(String exp) throws Exception {
        this.exp = exp;
        return String.format("%.3f", S());
    }
    
    // Осуществляет переход к следующему символу и осуществляет проверку
    private void lex() throws Exception {
        i++; 
        if (i < exp.length())
        {
            char c = exp.charAt(i);
            if (!Character.isDigit(c) && c != '(' && c != ')' &&
                 c != '+' && c != '-' && c != '*' && c != '/')
            {
                throw new Exception("Найден неопознанный символ!");
            }
        }
    }
    
    // Методы реализующие принцип алгоритма рекурсивного спуска
    // S ::= E
    // E ::= TA | -F 
    // A ::= +TA | -TA | Λ
    // T ::= FB
    // B ::= *FB | FB | Λ
    // F ::= 0 | 1 | ... | 9 | (E)
    
    private double S() throws Exception {
        i = 0;
        double Ss = E();
        // Если слово прочитано не полностью
        if (i != exp.length())
            throw new Exception("Выражение не прочитано полностью");
        return Ss;                
    }
    
    private double E() throws Exception {
        if (i < exp.length() && exp.charAt(i) == '-')
        {
            lex();
            return -F();
        }
        else
        {
            double Ts = T();
            return A(Ts);
        }
    }

    private double T() throws Exception {
        double Fs = F();
        return B(Fs);
    }

    private double A(double Ai) throws Exception {
        if (i < exp.length() && exp.charAt(i) == '+')
        {
            lex();
            double Ts = T();
            return A(Ai + Ts);
        }
        else if (i < exp.length() && exp.charAt(i) == '-')
        {
            lex();
            double Ts = T();
            return A(Ai - Ts);
        }
        else
            return Ai;        
    }

    private double B(double Bi) throws Exception {
        if (i < exp.length() && exp.charAt(i) == '*')
        {
            lex();
            double Fs = F();
            return B(Bi * Fs);
        }
        else if (i < exp.length() &&  exp.charAt(i) == '/')
        {
            lex();
            double Fs = F();
            if (Fs == 0)
                throw new Exception("Деление на ноль!");
            return B(Bi / Fs);
        }
        else
            return Bi;
    }

    private double F() throws Exception {
        double Fs;
        char c = exp.charAt(i);
        if (Character.isDigit(c))
        {
            Fs = Character.getNumericValue(c);
        }
        else if (c == '(')
        {
            lex();
            Fs = E();
            c = exp.charAt(i);
            if (c != ')')
            {
                throw new Exception("Не найдена закрывающая скобка!");
            }
        }
        else
            throw new Exception("Cинтаксическая ошибка!");
        lex();
        return Fs;        
    }    
    
}
