package com.company;

import java.util.*;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void PvP()
    {
        TicTacToe t = new TicTacToe();
        while (!t.GameOver)
        {
            if (t.PlaceMark(scan.nextInt()))
            {
                t.DrawBoard(false);
                if (t.CheckEnd())
                {
                    t.EndGame();
                }
                else
                {
                    t.ChangePlayer();
                    t.AnnounceTurn();
                }
            }
        }
    }

    public static void PvC()
    {
        TicTacToe t = new TicTacToe();
        while (!t.GameOver)
        {
            if (t.PlaceMark(scan.nextInt()))
            {
                if (t.CheckEnd())
                {
                    t.EndGame();
                }
                else
                {
                    t.ChangePlayer();
                    t.AIMove();
                    t.DrawBoard(false);
                    if (t.CheckEnd())
                    {
                        t.EndGame();
                    }
                    else
                    {
                        t.ChangePlayer();
                        t.AnnounceTurn();
                    }
                }
            }
        }
    }

    public static void PromptInput()
    {
        System.out.println("Which mode would you like to play? \n" +
                "1) Player vs. Player \n" +
                "2) Player vs. Computer");

        String input = scan.nextLine();

        switch (input)
        {
            case "1":
            {
                PvP();
                break;
            }
            case "2":
            {
                PvC();
                break;
            }
            default:
            {
                System.out.println("Invalid option!");
                PromptInput();
            }
        }
    }

    public static void main(String[] args)
    {
        PromptInput();
    }
}
