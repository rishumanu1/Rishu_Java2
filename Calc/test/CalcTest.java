
import org.junit.Test;
import static org.junit.Assert.*;

public class CalcTest {

    private double EPSILON = 1e-15;

    @Test
    public void basicTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.push(2.0);
        c.add();
        assertEquals(4.0, c.pop(), EPSILON);
    }

    @Test
    public void exprTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.push(3.0);
        c.multiply();
        c.push(4.0);
        c.push(5.0);
        c.multiply();
        c.add();
        assertEquals(26.0, c.pop(), EPSILON);
    }

    @Test
    public void pushDepthTest() {
        Calc c = new Calc();
        c.push(5.0);
        assertEquals(1, c.depth());
        c.push(6.0);
        assertEquals(2, c.depth());
        c.push(-10.0);
        assertEquals(3, c.depth());
    }

    @Test(expected = Exception.class)
    public void emptyPopTest() {
        Calc c = new Calc();
        c.pop();
    }

    @Test(expected = Exception.class)
    public void tooManyPopTest() {
        Calc c = new Calc();
        c.push(3.0);
        c.push(4.0);
        c.add();
        c.pop();
        c.pop();
    }

    @Test(expected = Exception.class)
    public void tooManyPushTest() {
        Calc c = new Calc();
        for (int i = 0; i < 1e6; i++) {
            c.push(100.0);
        }
    }

    @Test(expected = Exception.class)
    public void nopeekTest() {
        Calc c = new Calc();
        double v = c.peek();
    }

    @Test
    public void peekTest() {
        Calc c = new Calc();
        c.push(2.0);
        assertEquals(2.0, c.peek(), EPSILON);
        c.push(3.0);
        assertEquals(3.0, c.peek(), EPSILON);
        c.multiply();
        assertEquals(6.0, c.peek(), EPSILON);
        c.push(4.0);
        assertEquals(4.0, c.peek(), EPSILON);
        c.push(5.0);
        assertEquals(5.0, c.peek(), EPSILON);
        c.multiply();
        assertEquals(20.0, c.peek(), EPSILON);
        c.add();
        assertEquals(26.0, c.peek(), EPSILON);
    }

    @Test(expected = Exception.class)
    public void underflowAddTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.add();
    }

    @Test
    public void singleSubtractTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.push(-10.0);
        c.subtract();
        assertEquals(12.0, c.pop(), EPSILON);
    }

    @Test
    public void doubleMultiplyTest() {
        Calc c = new Calc();
        c.push(-1.0);
        c.push(37.0);
        c.push(10.0);
        c.multiply();
        c.multiply();
        assertEquals(-370.0, c.pop(), EPSILON);
    }

    @Test
    public void addHundredTest() {
        Calc c = new Calc();
        int i;
        for (i = 0; i < 100; i++) {
            c.push(1.0);
        }
        for (i = 0; i < 99; i++) {
            c.add();
        }
        assertEquals(100.0, c.pop(), EPSILON);
    }

    @Test(expected = Exception.class)
    public void underflowTest() {
        Calc c = new Calc();
        int i;
        for (i = 0; i < 100; i++) {
            c.push(1.0);
        }
        for (i = 0; i < 100; i++) {
            c.add();
        }
    }

    @Test
    public void depthAndPeekTest() {
        Calc c = new Calc();
        c.push(5.0);
        c.push(3.0);
        c.push(4.0);
        c.push(1.0);
        c.push(2.0);
        c.subtract();
        c.add();
        assertEquals(3, c.depth(), EPSILON);
        assertEquals(3.0, c.peek(), EPSILON);
    }

    @Test(expected = Exception.class)
    public void tooManyOperationsTest() {
        Calc c = new Calc();
        c.push(5.0);
        c.push(3.0);
        c.push(4.0);
        c.push(1.0);
        c.push(2.0);
        c.subtract();
        c.add();
        c.multiply();
        c.multiply();
        c.divide();
    }

    @Test
    public void reciprocalTest() {
        Calc c = new Calc();
        c.push(5.0);
        c.reciprocal();
        assertEquals(0.2, c.peek(), EPSILON);
    }

    @Test(expected = Exception.class)
    public void emptyReciprocalTest() {
        Calc c = new Calc();
        c.reciprocal();
    }

    @Test
    public void pushPopDepthTest() {
        Calc c = new Calc();
        c.push(5.0);
        c.push(7.0);
        c.push(8.0);
        c.push(132.0);
        c.pop();
        c.pop();
        c.push(25);
        c.push(32);
        c.pop();
        c.pop();
        c.push(6);
        c.push(9);
        c.pop();
        c.push(71);
        c.depth();
        assertEquals(4, c.depth(), EPSILON);

    }

    @Test(expected = Exception.class)
    public void underflowSubtractTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.subtract();
    }

    @Test(expected = Exception.class)
    public void underflowMultiplyTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.multiply();
    }

    @Test(expected = Exception.class)
    public void underflowDivideTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.divide();
    }

    @Test
    public void singleAddTest() {
        Calc c = new Calc();
        c.push(12.0);
        c.push(50.0);
        c.add();
        assertEquals(62.0, c.pop(), EPSILON);
    }

    @Test
    public void singleMultiplyTest() {
        Calc c = new Calc();
        c.push(3.0);
        c.push(6.0);
        c.multiply();
        assertEquals(18.0, c.pop(), EPSILON);
    }

    @Test
    public void singleDivideTest() {
        Calc c = new Calc();
        c.push(10.0);
        c.push(2.0);
        c.divide();
        assertEquals(5.0, c.pop(), EPSILON);
    }

    @Test
    public void doubleAddTest() {
        Calc c = new Calc();
        c.push(5.0);
        c.push(37.0);
        c.push(10.0);
        c.add();
        c.add();
        assertEquals(52.0, c.pop(), EPSILON);
    }

    @Test
    public void doubleSubtractTest() {
        Calc c = new Calc();
        c.push(10.0);
        c.push(20.0);
        c.push(15.0);
        c.subtract();
        c.subtract();
        assertEquals(5.0, c.pop(), EPSILON);
    }

    @Test
    public void doubleDivideTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.push(6.0);
        c.push(3.0);
        c.divide();
        c.divide();
        assertEquals(1.0, c.pop(), EPSILON);
    }

    @Test
    public void compoundTest() {
        Calc c = new Calc();
        c.push(2.0);
        c.push(3.0);
        c.push(11);
        c.add();
        c.push(5.0);
        c.subtract();
        c.multiply();
        assertEquals(18.0, c.pop(), EPSILON);
    }
}
