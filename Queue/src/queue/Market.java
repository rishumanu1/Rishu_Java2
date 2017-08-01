package queue;


import queue.Queue;
import java.util.NoSuchElementException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Education Unlimited
 */
public class Market {
    private Queue q;
    private double capitolGains;
    private double totalShares;
    
    public Market()
    {
        q = new Queue();
        capitolGains = 0;
        totalShares = 0;
    }
    public void buyShares(int x, double y) {
         for (int i = x; i >= 0; i--)
         {
               q.insert(y);
               totalShares += x;
         }
    }
    
    public void sellShares(int x, double y) {
        if (x > totalShares) {
            throw new NoSuchElementException();
        }
        double total = x * y;
        
        for (int i = x; i > 0; i--)
        {
            total = total - q.remove();
        }
        capitolGains += total;
    }
    
    public double getGains() {
        return capitolGains;
    }

   
}

