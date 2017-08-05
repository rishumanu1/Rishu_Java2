/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Education Unlimited
 */
package Final;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class game {

    private class room {

        String[] options = new String[12];
        String name;
        String description;
        String[] roomNext = new String[12];

    }
    private ArrayList<room> r = new ArrayList();
    private Stack s = new Stack();

    public game() {

        String FILENAME = "game.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {

            String currentLine = reader.readLine();

            while (currentLine != null) {
                room x = new room();
                if (!currentLine.equals("")) {
                    if (currentLine.charAt(0) == 'r') {
                        x.name = currentLine.substring(2, currentLine.length());
                        x.description = "";
                        currentLine = reader.readLine();
                    }
                    while (currentLine.charAt(0) == 'd') {
                        x.description = x.description.concat(currentLine.substring(2, currentLine.length()) + " ");
                        currentLine = reader.readLine();
                    }
                    int i = 0;
                    while (currentLine != null && currentLine.charAt(0) == 'o') {
                        x.options[i] = currentLine.substring(2, currentLine.length());
                        currentLine = reader.readLine();
                        x.roomNext[i] = currentLine.substring(2, currentLine.length());
                        i++;
                        currentLine = reader.readLine();
                    }
                    
                }
                r.add(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bubbleSort() {
        int n = r.size();
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                int j = i + 1;
                int x = r.get(i).name.compareTo(r.get(j).name);
                if (x > 0) {
                    swapRooms(i, j, r);
                }
            }

        }
    }

    public void begin() {

        s.push(r.get(0));
        print(r.get(0));
        bubbleSort();

    }

    private static void swapRooms(int i, int j, ArrayList<room> r) {

        room temp;
        temp = r.get(j);
        r.remove(j);
        r.add(j, r.get(i));
        r.remove(i);
        r.add(i, temp);
    }

    public room search(String d) /*int upperbound, int lowerbound*/ {
        /*System.out.println("search on " + upperbound + " , " + lowerbound);
        if (d.compareTo(r.get((upperbound + lowerbound) / 2).name) == 0) {
            return r.get((upperbound - lowerbound) / 2);
        } else if (upperbound == lowerbound) {
            return null;
        } else {
            if (d.compareTo(r.get((upperbound + lowerbound) / 2).name) < 0) {
                return search(d, ((upperbound + lowerbound) / 2), lowerbound);

            } else {
                return search(d, upperbound, ((upperbound + lowerbound) / 2));

            }
    }*/
        room f = new room();
        for (int i = 0; i < r.size(); i++){
            if (d.equals(r.get(i).name)){
                f = r.get(i);
            }
        }
        return f;
    }

    public void print(room z) {

        System.out.println(z.description);
        int i = 0;
        while (z.options[i] != null) {
            if (i == 0) {
                System.out.println("a: " + z.options[i]);
            }

            if (i == 1) {
                System.out.println("b: " + z.options[i]);
            }
            if (i == 2) {
                System.out.println("c: " + z.options[i]);
            }
            if (i == 3) {
                System.out.println("d: " + z.options[i]);
            }
            if (i == 4) {
                System.out.println("e: " + z.options[i]);
            }
            if (i == 5) {
                System.out.println("f: " + z.options[i]);
            }
            if (i == 6) {
                System.out.println("g: " + z.options[i]);
            }
            if (i == 7) {
                System.out.println("h: " + z.options[i]);
            }
            if (i == 8) {
                System.out.println("i: " + z.options[i]);
            }
            if (i == 9) {
                System.out.println("j: " + z.options[i]);
            }
            if (i == 10) {
                System.out.println("k: " + z.options[i]);
            }
            if (i == 11) {
                System.out.println("l: " + z.options[i]);
            }
            i++;

        }
    }

    public void change(String x) {
        if (x.equals("a")) {
            room z = search(s.peek().roomNext[0]);
            s.push(z);
            print(z);
        } else if (x.equals("b")) {
            room z = search(s.peek().roomNext[0]);
            s.push(z);
            print(z);
        } else if (x.equals("c")) {
            room z = search(s.peek().roomNext[0]);
            s.push(z);
            print(z);
        } else if (x.equals("d")) {
            room z = search(s.peek().roomNext[0]);
            s.push(z);
            print(z);
        } else if (x.equals("e")) {
            room z = search(s.peek().roomNext[0]);
            s.push(z);
            print(z);
        } else if (x.equals("f")) {
            room z = search(s.peek().roomNext[0]);
            s.push(z);
            print(z);
        } else if (x.equals("g")) {
            room z = search(s.peek().roomNext[0]);
            s.push(z);
            print(z);
        } else if (x.equals("h")) {
            room z = search(s.peek().roomNext[0]);
            s.push(z);
            print(z);
        } else if (x.equals("i")) {
            room z = search(s.peek().roomNext[0]);
            s.push(z);
            print(z);
        } else if (x.equals("j")) {
            room z = search(s.peek().roomNext[0]);
            s.push(z);
            print(z);
        } else if (x.equals("k")) {
            room z = search(s.peek().roomNext[0]);
            s.push(z);
            print(z);
        } else if (x.equals("l")) {
            room z = search(s.peek().roomNext[0]);
            s.push(z);
            print(z);
        } else if (x.equals("y")) {
            for (room xxxx : r) {
                print(xxxx);
            }
            print(s.peek());
        } else if (x.equals("z")) {
            s.pop();
            print(s.peek());
        } else if (x.equals("r")) {
            Stack l = new Stack();
            s = l;
            begin();
        } /*else {
         System.out.print("Not a Valid Option");
         print(s.peek());
         }*/

    }

    class Stack {

        private room[] stack;
        private int size;

        // Constructor for stack
        Stack() {
            stack = new room[100];
            size = 0;
        }

        public void push(room d) {
            //adds the double d onto the stack, increments the size
            stack[size++] = d;

        }

        public room pop() {
            room x = stack[size - 1];
            stack[size - 1] = null;
            size--;
            return x;
        }

        public room peek() {
            //returns the top number of the stack without modifying it
            return stack[size - 1];
        }

        public int size() {
            //returns the current size of the stack
            return size;
        }

    }

}
