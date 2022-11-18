package ru.clevertec.task1;

public class Main {


    public static void main(String[] args) {
        System.out.println(checkTicket(2324));
    }

    private static boolean checkTicket(int ticket) {
        int num1 = 0;
        int num2 = 0;

        String number = String.valueOf(ticket);

        int digitCountOfHalf = number.length()/2;

        String firstHalf = number.substring(0, digitCountOfHalf);
        String secondHalf = number.substring(digitCountOfHalf);

        for (int i = 0; i < digitCountOfHalf; i++) {
            num1 += Character.getNumericValue(firstHalf.charAt(i));
            num2 += Character.getNumericValue(secondHalf.charAt(i));
        }
        return num1 == num2;
    }
}