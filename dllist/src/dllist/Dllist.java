package dllist;

import java.util.NoSuchElementException;

public class Dllist {

    public enum position {

        FIRST, PREVIOUS, FOLLOWING, LAST
    };

    private class node {

        String item;
        node prev;
        node next;
    }

    private node first = null;
    private node current = null;
    private node last = null;
    private int currentPosition = 0;

    public void setPosition(position pos) {
        switch (pos) {
            case FIRST: {
                current = first;
                currentPosition = 0;
                break;
            }

            case PREVIOUS: {
                if (current != first) {
                    current = current.prev;
                    currentPosition--;
                }
                break;
            }
            case FOLLOWING: {
                if (current != last) {
                    current = current.next;
                    currentPosition++;
                }
                break;
            }
            case LAST: {
                current = last;
                int x = 0;
                node t = first;
                while (t != last) {
                    x++;
                    t = t.next;
                }
                currentPosition = x;
                break;
            }

        }
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public String getItem() throws NoSuchElementException {
        if (current == null) {
            throw new NoSuchElementException();
        } else {
            return current.item;
        }
    }

    public int getPosition() throws NoSuchElementException {
        if (first == null) {
            throw new NoSuchElementException();
        } else {
            return currentPosition;
        }
    }

    public void delete() throws NoSuchElementException {
        if (first == null) {
            throw new NoSuchElementException();
        }
        if (current == first && current == last) {
            first = null;
            last = null;
            current = null;
            currentPosition = 0;
        }
        if (current == first) {
            first = current.next;
            current = first;
            currentPosition = 0;
        }
        if (current == last) {
            node t = current;
            current = current.next;
            current.prev = t.prev;
            t.prev.next = current;
            currentPosition++;
        } else {
            last = current.prev;
            current = last;
            int pos = 0;
            node t = first;
            while (t != last) {
                pos++;
                t = t.next;
            }
            currentPosition = pos;
        }

    }

    public void insert(String item, position pos) throws IllegalArgumentException {
        node n = new node();
        n.item = item;
        switch (pos) {
            case FIRST: {
                if (first == null) {
                    first = n;
                } else {
                    first.prev = n;
                    n.next = first;
                    first = n;
                }
                break;
            }
            case LAST: {
                if (last == null) {
                    last = n;
                } else {
                    last.next = n;
                    n.prev = last;
                    last = n;
                }
                break;
            }
            case PREVIOUS: {
                if (current == first) {
                    throw new IllegalArgumentException();
                } else {
                    node t = current;
                    node y = current.prev;
                    current = n;
                    current.next = t;
                    t.prev = current;
                    current.prev = y;
                    y.next = current;
                }
                break;
            }
            case FOLLOWING: {
                if (current == last) {
                    throw new IllegalArgumentException();
                } else {
                    node t = current;
                    node y = current.next;
                    current = n;
                    current.prev = t;
                    t.next = current;
                    current.next = y;
                    y.prev = current;
                    currentPosition++;
                }
                break;

            }

        }

    }

     public void traverse(){
         
         node t = first;
        boolean done=false;
        while(!done){
             if(t == null){
                done=true;
            }
             else {
                 System.out.println(t.item);
              t = t.next;
             }
        }
    }
     

    public static void main(String[] args) {
        Dllist x = new Dllist();
        x.insert("word", position.FIRST);
        x.insert("by", position.LAST);
        x.setPosition(position.FIRST);
        x.insert("two", position.FOLLOWING);
        x.insert("hello", position.FOLLOWING);
        x.setPosition(position.FOLLOWING);
        x.isEmpty();
        x.delete();
        x.getPosition();
        x.getItem();

    }
}
