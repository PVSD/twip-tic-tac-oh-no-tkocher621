package com.company;

import java.util.*;

public class Main {

    public static void PvP()
    {
        TicTacToe t = new TicTacToe();
        t.DrawBoard();
        // check if anyone has won
        System.out.println("Player 1 goes first!");
        while (!t.CheckWin())
        {

            // prompt input above
            t.ChangePlayer();
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Which mode would you like to play? \n" +
        "1) Player vs. Player" +
        "2) Player vs. Computer" +
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
