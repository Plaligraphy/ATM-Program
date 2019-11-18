package pkg;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Code {

    private int[] accountNums = {2003, 2000, 2050};
    int money[] = new int[10];
    //= {50, 40, 2000};
    private int place;

    Scanner in = new Scanner(System.in);

    public void init() {
        System.out.println("ATM");
        System.out.println("-- Withdraw --");
        System.out.println("-- Deposit --");
        System.out.println("-- Balance --");
        System.out.println("-- Settings --");
        System.out.println("--------------");
        String option = in.nextLine();
        switch(option.toLowerCase()) {
            case "withdraw":
                management(0);
                break;
            case "deposit":
                management(1);
                break;
            case "balance":

                break;
            case "settings":
                settings();
                break;
            case "d":
                write();
                break;
        }
    }private void management(int opt) {
        accntCheck();
        switch(opt) {
            case 0:
                System.out.println("Current Balance: " + money[place]);
                System.out.println("Withdrawl amount?: ");
                int sub = in.nextInt();
                money[place] = money[place] - sub;
                System.out.println("New Balance: " + money[place]);
                break;
            case 1:
                break;
        }
    }private void settings() {

    }private void accntCheck() {
        System.out.println("Account Number?");
        int acn = in.nextInt();
        if(check(accountNums, acn)) {
        System.out.println("Validated!");
        }else {
            System.out.println("Not Validated!");
            init();
        }
    }private boolean check(int[] arr, int toCheckValue){
        place = -1;
        boolean test = false;
        for (int element : arr) {
            place++;
            if (element == toCheckValue) {
                test = true;
                break;
            }}return test;
    }private void read() {
        try {
            Scanner scanner = new Scanner(new File("balance.txt"));
            int [] tall = new int [10];
            int i = 0;
            while(scanner.hasNextInt()){
                tall[i++] = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }private void write() {
        //doesnt work correctly yet
        money[0] = 50;
        money[1] = 340;
        money[2] = 123;
        try {
            FileWriter file = new FileWriter("balance.txt");
            for (int i = 0; i < money.length; i++) {
                file.write(money[i]);
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error - " + e.toString());
        }
    }
}
