package pkg;

import java.util.Scanner;

public class Code {

    private int[] accountNums = {2003, 2000, 2050};
    private int[] money = {50, 40, 2000};
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
    }
}
