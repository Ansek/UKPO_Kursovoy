/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import org.junit.Before;
import com.github.ansek.ukpo.model.Calculator;
import static org.junit.Assert.*;
        
/**
 *
 * @author Александр
 */
public class ApplicationTest {
    Calculator calc;
    
    @Before
    public void setUp() throws Exception {
         calc = new Calculator();
    }
    
    @Test
    public void addTwoNum() throws Exception {
        String result = calc.calculate("5+4");
        assertEquals(result, "9,000");
    }
    
    @Test
    public void subTwoNum() throws Exception {
        String result = calc.calculate("5-4");
        assertEquals(result, "1,000");
    }
    
    @Test
    public void mulTwoNum() throws Exception {
        String result = calc.calculate("5*4");
        assertEquals(result, "20,000");
    }
    
    @Test
    public void divTwoNum() throws Exception {
        String result = calc.calculate("5/4");
        assertEquals(result, "1,250");
    }
    
    @Test
    public void addTwoNegativeNum() throws Exception {
        String result = calc.calculate("(-5)+(-4)");
        assertEquals(result, "-9,000");
    }
    
    @Test
    public void subTwoNegativeNum() throws Exception {
        String result = calc.calculate("(-5)-(-4)");
        assertEquals(result, "-1,000");
    }
    
    @Test
    public void mulTwoNegativeNum() throws Exception {
        String result = calc.calculate("(-5)*(-4)");
        assertEquals(result, "20,000");
    }
    
    @Test
    public void divTwoNegativeNum() throws Exception {
        String result = calc.calculate("(-5)/(-4)");
        assertEquals(result, "1,250");
    }
    
    @Test
    public void addAndAddNum() throws Exception {
        String result = calc.calculate("(5+4)+2");
        assertEquals(result, "11,000");
    }
    
    @Test
    public void addInBracketAndAddNum() throws Exception {
        String result = calc.calculate("(5+4)+2");
        assertEquals(result, "11,000");
    }
    
    @Test
    public void addAndSubNum() throws Exception {
        String result = calc.calculate("5+4-2");
        assertEquals(result, "7,000");
    }
    
    @Test
    public void addInBracketAndSubNum() throws Exception {
        String result = calc.calculate("(5+4)-2");
        assertEquals(result, "7,000");
    }
    
    @Test
    public void addAndMulNum() throws Exception {
        String result = calc.calculate("5+4*2");
        assertEquals(result, "13,000");
    }
    
    @Test
    public void addInBracketAndMulNum() throws Exception {
        String result = calc.calculate("(5+4)*2");
        assertEquals(result, "18,000");
    }
    
    @Test
    public void addAndDivNum() throws Exception {
        String result = calc.calculate("5+4/2");
        assertEquals(result, "7,000");
    }
    
    @Test
    public void addInBracketAndDivNum() throws Exception {
        String result = calc.calculate("(5+4)/2");
        assertEquals(result, "4,500");
    }
    
    @Test
    public void subAndAddNum() throws Exception {
        String result = calc.calculate("5-4+2");
        assertEquals(result, "3,000");
    }
    
    @Test
    public void subInBracketAndAddNum() throws Exception {
        String result = calc.calculate("(5-4)+2");
        assertEquals(result, "3,000");
    }
    
    @Test
    public void subAndSubNum() throws Exception {
        String result = calc.calculate("5-4-2");
        assertEquals(result, "-1,000");
    }
    
    @Test
    public void subInBracketAndSubNum() throws Exception {
        String result = calc.calculate("(5-4)-2");
        assertEquals(result, "-1,000");
    }
    
    @Test
    public void subAndMulNum() throws Exception {
        String result = calc.calculate("5-4*2");
        assertEquals(result, "-3,000");
    }
    
    @Test
    public void subInBracketAndMulNum() throws Exception {
        String result = calc.calculate("(5-4)*2");
        assertEquals(result, "2,000");
    }
    
    @Test
    public void subAndDivNum() throws Exception {
        String result = calc.calculate("5-4/2");
        assertEquals(result, "3,000");
    }
    
    @Test
    public void subInBracketAndDivNum() throws Exception {
        String result = calc.calculate("(5-4)/2");
        assertEquals(result, "0,500");
    }
    
    @Test
    public void mulAndAddNum() throws Exception {
        String result = calc.calculate("5*4+2");
        assertEquals(result, "22,000");
    }
    
    @Test
    public void mulInBracketAndAddNum() throws Exception {
        String result = calc.calculate("(5*4)+2");
        assertEquals(result, "22,000");
    }
    
    @Test
    public void mulAndSubNum() throws Exception {
        String result = calc.calculate("5*4-2");
        assertEquals(result, "18,000");
    }
    
    @Test
    public void mulInBracketAndSubNum() throws Exception {
        String result = calc.calculate("(5*4)-2");
        assertEquals(result, "18,000");
    }
    
    @Test
    public void mulAndMulNum() throws Exception {
        String result = calc.calculate("5*4*2");
        assertEquals(result, "40,000");
    }
    
    @Test
    public void mulInBracketAndMulNum() throws Exception {
        String result = calc.calculate("(5*4)*2");
        assertEquals(result, "40,000");
    }
    
    @Test
    public void mulAndDivNum() throws Exception {
        String result = calc.calculate("5*4/2");
        assertEquals(result, "10,000");
    }
    
    @Test
    public void mulInBracketAndDivNum() throws Exception {
        String result = calc.calculate("(5*4)/2");
        assertEquals(result, "10,000");
    }
    
    @Test
    public void divAndAddNum() throws Exception {
        String result = calc.calculate("5/4+2");
        assertEquals(result, "3,250");
    }
    
    @Test
    public void divInBracketAndAddNum() throws Exception {
        String result = calc.calculate("(5/4)+2");
        assertEquals(result, "3,250");
    }
    
    @Test
    public void divAndSubNum() throws Exception {
        String result = calc.calculate("5/4-2");
        assertEquals(result, "-0,750");
    }
    
    @Test
    public void divInBracketAndSubNum() throws Exception {
        String result = calc.calculate("(5/4)-2");
        assertEquals(result, "-0,750");
    }
    
    @Test
    public void divAndMulNum() throws Exception {
        String result = calc.calculate("5/4*2");
        assertEquals(result, "2,500");
    }
    
    @Test
    public void divInBracketAndMulNum() throws Exception {
        String result = calc.calculate("(5/4)*2");
        assertEquals(result, "2,500");
    }
    
    @Test
    public void divAndDivNum() throws Exception {
        String result = calc.calculate("5/4/2");
        assertEquals(result, "0,625");
    }
    
    @Test
    public void divInBracketAndDivNum() throws Exception {
        String result = calc.calculate("(5/4)/2");
        assertEquals(result, "0,625");
    }
    
    @Test
    public void centerBracketNum() throws Exception {
        String result = calc.calculate("2*(7-3+5)/4");
        assertEquals(result, "4,500");
    }
    
    @Test
    public void endBracketNum() throws Exception {
        String result = calc.calculate("2/4*(5+7-2)");
        assertEquals(result, "5,000");
    }
    
    @Test
    public void divZero() throws Exception {
        String result = null;
        try {
            calc.calculate("5/0");
        } catch (Exception ex) {
            result = ex.getMessage();
        }
        assertEquals(result, "Деление на ноль!");
    }
    
    @Test
    public void benchmarkTest() throws Exception {
        String result = calc.calculate("2+(-5)*(7-8)");
        assertEquals(result, "7,000");
    }
    
    @Test
    public void oneNumber() throws Exception {
        String result = calc.calculate("5");
        assertEquals(result, "5,000");
    }
    
    @Test
    public void oneNegativeNumber() throws Exception {
        String result = calc.calculate("-5");
        assertEquals(result, "-5,000");
    }
    
    @Test
    public void oneNegativeInBracket() throws Exception {
        String result = calc.calculate("(-5)");
        assertEquals(result, "-5,000");
    }
   
    @Test
    public void invalidNumber() {
        String result = null;
        try {
            calc.calculate("55");
        } catch (Exception ex) {
            result = ex.getMessage();
        }
        assertEquals(result, "Выражение не прочитано полностью!");
    }
    
    @Test
    public void invalidCharacter() {
        String result = null;
        try {
            calc.calculate("a");
        } catch (Exception ex) {
            result = ex.getMessage();
        }
        assertEquals(result, "Cинтаксическая ошибка!");
    }
    
    @Test
    public void invalidCharAfterNum() {
        String result = null;
        try {
            calc.calculate("5a");
        } catch (Exception ex) {
            result = ex.getMessage();
        }
        assertEquals(result, "Найден неопознанный символ!");
    }
    
    @Test
    public void missingBracket() {
                String result = null;
        try {
            calc.calculate("(5");
        } catch (Exception ex) {
            result = ex.getMessage();
        }
        assertEquals(result, "Не найдена закрывающая скобка!");
    }
}
