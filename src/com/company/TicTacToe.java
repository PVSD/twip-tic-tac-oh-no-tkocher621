package com.company;

public class TicTacToe {

    private String pMark = "x";
    private String board[][] = new String[3][3];

    public TicTacToe()
    {
        InitializeBoard();
    }

    private void InitializeBoard()
    {
        int count = 1;
        for (int i = 0; i < 3; i++)
        {
            for (int a = 0; a < 3; a++)
            {
                board[i][a] = "-";
                count++;
            }
        }
    }

    public void DrawBoard()
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.print("| ");
            for (int a = 0; a < 3; a++)
            {
                System.out.print(board[i][a] + " | ");
            }
            System.out.println();
            if (i != 2)
                System.out.println("-------------");
        }
    }

    public void PlaceMark(int position)
    {
        int count = 1;
        for (int i = 0; i < 3; i++)
        {
            for (int a = 0; a < 3; a++)
            {
                if (count == position)
                    board[i][a] = pMark;
                count++;
            }
        }
        DrawBoard();
    }

    public boolean CheckWin()
    {

    }

    public void ChangePlayer()
    {
        pMark = (pMark.equals("x")) ? "o" : "x";
    }

}
