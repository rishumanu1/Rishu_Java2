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
                while (currentLine !=null && currentLine.charAt(0) == 'o') {
                    x.options[i] = currentLine.substring(2, currentLine.length());
                    currentLine = reader.readLine();
                    x.roomNext[i] = currentLine.substring(2, currentLine.length());
                    i++;
                    currentLine = reader.readLine();
                }
                r.add(x);
                }
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
    }

    private static void swapRooms(int i, int j, ArrayList<room> r) {

        room temp;
        temp = r.get(j);
        r.remove(j);
        r.add(j, r.get(i));
        r.remove(i);
        r.add(i, temp);
    }

    public room search(String d, int upperbound, int lowerbound) {
        if (d.compareTo(r.get((upperbound + lowerbound) / 2).name) == 0) {
            return r.get((upperbound - lowerbound) / 2);
        } else {
            if (d.compareTo(r.get((upperbound + lowerbound) / 2).name) < 0) {
                upperbound = (upperbound + lowerbound) / 2;

            }
            if (d.compareTo(r.get((upperbound + lowerbound) / 2).name) > 0) {
                lowerbound = (upperbound + lowerbound) / 2;

            }
            return search(d, upperbound, lowerbound);
        }
    }

    public void print(room d) {
        
        System.out.println(d.description);
        int i = 0;
        while (d.options[i] != null) {
            if (i == 0) {
                System.out.println("a: " + d.options[i]);
            }

            if (i == 1) {
                System.out.println("b: " + d.options[i]);
            }
            if (i == 2) {
                System.out.println("c: " + d.options[i]);
            }
            if (i == 3) {
                System.out.println("d: " + d.options[i]);
            }
            if (i == 4) {
                System.out.println("e: " + d.options[i]);
            }
            if (i == 5) {
                System.out.println("f: " + d.options[i]);
            }
            if (i == 6) {
                System.out.println("g: " + d.options[i]);
            }
            if (i == 7) {
                System.out.println("h: " + d.options[i]);
            }
            if (i == 8) {
                System.out.println("i: " + d.options[i]);
            }
            if (i == 9) {
                System.out.println("j: " + d.options[i]);
            }
            if (i == 10) {
                System.out.println("k: " + d.options[i]);
            }
            if (i == 11) {
                System.out.println("l: " + d.options[i]);
            }
            i++;

        }
    }

    public void change(String x) {
        if (x.equals("a")) {
            room z = search(s.peek().roomNext[0], 0, r.size());
            s.push(z);
            print(z);
        } else if (x.equals("b")) {
            room z = search(s.peek().roomNext[1], 0, r.size());
            s.push(z);
            print(z);
        } else if (x.equals("c")) {
            room z = search(s.peek().roomNext[2], 0, r.size());
            s.push(z);
            print(z);
        } else if (x.equals("d")) {
            room z = search(s.peek().roomNext[3], 0, r.size());
            s.push(z);
            print(z);
        } else if (x.equals("e")) {
            room z = search(s.peek().roomNext[4], 0, r.size());
            s.push(z);
            print(z);
        } else if (x.equals("f")) {
            room z = search(s.peek().roomNext[5], 0, r.size());
            s.push(z);
            print(z);
        } else if (x.equals("g")) {
            room z = search(s.peek().roomNext[6], 0, r.size());
            s.push(z);
            print(z);
        } else if (x.equals("h")) {
            room z = search(s.peek().roomNext[7], 0, r.size());
            s.push(z);
            print(z);
        } else if (x.equals("i")) {
            room z = search(s.peek().roomNext[8], 0, r.size());
            s.push(z);
            print(z);
        } else if (x.equals("j")) {
            room z = search(s.peek().roomNext[9], 0, r.size());
            s.push(z);
            print(z);
        } else if (x.equals("k")) {
            room z = search(s.peek().roomNext[10], 0, r.size());
            s.push(z);
            print(z);
        } else if (x.equals("l")) {
            room z = search(s.peek().roomNext[11], 0, r.size());
            s.push(z);
            print(z);
        } else if (x.equals("y")) {
            for (int i = 0; i < r.size(); i++) {
                print(r.get(i));
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
