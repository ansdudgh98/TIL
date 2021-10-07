package bookcode.ch1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator cal;
    @BeforeEach
    public void setup(){
        cal = new Calculator();
        System.out.println("before");
    }
    @Test
    public void add(){
        //Calculator cal = new Calculator(); 중복 코드 제거
        assertEquals(9,cal.add(6,3));
    }
    @Test
    public void substract(){
        //Calculator cal = new Calculator(); 중복 코드 제거
        assertEquals(3,cal.sub(6,3));
    }
    @AfterEach
    public void teardown(){
        System.out.println("teardown");
    }

}