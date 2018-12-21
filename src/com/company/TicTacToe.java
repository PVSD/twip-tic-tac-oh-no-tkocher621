package com.company;

public class TicTacToe {

    public String pMark = "o";
    private String board[][] = new String[3][3];
    // [down][right]

    public TicTacToe()
    {
        InitializeBoard();
    }

    private void InitializeBoard()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int a = 0; a < 3; a++)
            {
                board[i][a] = "-";
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
        //CheckEnd();
        //ChangePlayer();
    }

    public boolean CheckEnd() // FIX ME
    {
        boolean isWin = true;
        for (int i = 0; i < 3; i++)
        {
            for (int a = 0; a < 3; a++)
            {
                if (!board[i][a].equals(pMark))
                {
                    isWin = false;
                }
            }
        }
        return isWin;
    }

    public void ChangePlayer()
    {
        pMark = (pMark.equals("x")) ? "o" : "x";
    }

}
