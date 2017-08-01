package queue;

import java.util.NoSuchElementException;

public class Queue {

    private class Node {

        double price;
        Node next;
    }
    private Node head = null;
    private Node tail = null;
 
    public boolean isempty() {
        return (head == null);
    }

    public void insert(double newprice) {
        Node n = new Node();
        n.price = newprice;
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }
        public double remove() {
            double x = 0;
            if (isempty()){
                throw new NoSuchElementException();
            }
            if (head == tail)  {
               x = head.price;
               head = null;
               tail = null;
            }
            else {
             x = head.price;
            head = head.next;
             
            
            }
            return x;
            
        }
        
        public double peek() {
             if (isempty() == true){
                throw new NoSuchElementException();
            }
            return head.price;
        }
    

}
