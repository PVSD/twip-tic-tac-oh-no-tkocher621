package com.company;

import java.util.*;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void PvP()
    {
        TicTacToe t = new TicTacToe();
        t.DrawBoard();

        System.out.println("Enter a number 1-9 to place your mark.");
        while (true)
        {
            System.out.println("Player " + ((t.pMark.equals("x")) ? "1" : "2") + "'s turn!");

            t.PlaceMark(scan.nextInt());
        }

        //System.out.println("Player " + ((t.pMark.equals("x")) ? "1" : "2") + " wins!");
    }

    public static void main(String[] args) {

        System.out.println("Which mode would you like to play? \n" +
        "1) Player vs. Player \n" +
        "2) Player vs. Computer \n" +
        "3) Computer vs. Computer");

        String input = scan.nextLine();

        switch (input)
        {
            case "1":
            {
                PvP();
                break;
            }
        }


    }
}
