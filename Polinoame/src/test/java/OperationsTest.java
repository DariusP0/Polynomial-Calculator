import Polinom.Polinoame;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.HashMap;

import static org.junit.Assert.assertEquals;
public class OperationsTest {
    private static Polinoame p1,p2;
    @BeforeClass
    public static void setup() {
        p1 = new Polinoame("2x^2+3x+3");
        p2 = new Polinoame("3x^2+3");
    }
    @Test
    public void addTest(){
        Polinoame p3 = new Polinoame("5x^2+3x+6");
        System.out.println(p1.add(p1,p2));
        assertEquals(p1.add(p1,p2), p3.getHash());
    }
    @Test
    public void subTest(){
        Polinoame p3 = new Polinoame("-x^2+3x+0");
        System.out.println(p1.sub(p1,p2));
        assertEquals(p1.sub(p1,p2), p3.getHash());
    }
    @Test
    public void derTest(){
        Polinoame p3 = new Polinoame("4x+3");
        System.out.println(p1.derivative(p1));
        assertEquals(p1.derivative(p1), p3.getHash());
    }
    @Test
    public void integralTest(){
        Polinoame p3 = new Polinoame("x^3+3x");
        HashMap<Double,Double> result = new HashMap(p2.integral(p2));
        System.out.println(result);
         result.put(3.0, Math.round(result.get(3.0) * 100) / 100.0);
        assertEquals(result, p3.getHash());
    }
    @Test
    public void multiplyTest(){
        Polinoame p3 = new Polinoame("6x^4+9x^3+15x^2+9x+9");
        HashMap<Double,Double> result = new HashMap(p2.multiply(p1,p2));
        System.out.println(result);
        assertEquals(result, p3.getHash());

    }
}

