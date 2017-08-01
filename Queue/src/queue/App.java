package queue;


import java.util.Scanner;
import queue.Queue;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Education Unlimited
 */
public class App {
    public static void main(String[] args)
    {
        Market test = new Market();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of shares purchased");
        int x = sc.nextInt();
        System.out.println("Enter the price of share purchased");
        double y = sc.nextDouble();
        test.buyShares(x,y);
        System.out.println("Enter the number of shares sold");
        int z = sc.nextInt();
        System.out.println("Enter the price of share sold");
        double m = sc.nextDouble();
        test.sellShares(z,m);
        System.out.println("The profit is: " + test.getGains());
    }
}
