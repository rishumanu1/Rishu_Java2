/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import queue.Queue;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Education Unlimited
 */
public class QueueTest {
    private double EPSILON = 1e-15;
    
    @Test
    public void PeekTest() {
        Queue q = new Queue();
        q.insert(10.12);
        q.insert(13.14);
        q.insert(31.00);
        q.insert(26.00);
        assertEquals(10.12, q.peek(), EPSILON);
    }
    @Test
    public void DeleteTest() {
        
      Queue q = new Queue();
        q.insert(10.12);
        q.insert(13.14);
        assertEquals(10.12, q.peek(), EPSILON);
        assertEquals(10.12, q.remove(), EPSILON);
        q.insert(31.7);
        q.insert(31.00);
        q.insert(26.00);
        assertEquals(13.14, q.remove(), EPSILON);
    }
}
