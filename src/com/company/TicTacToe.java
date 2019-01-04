package com.company;
import java.util.*;

public class TicTacToe {

    public String pMark = "x";
    private String board[][] = new String[3][3];
    public boolean GameOver = false;
    private boolean tieGame = false;
    private int[][] ArrToMagicSquare = new int[][]
            {
                    {4, 9, 2},
                    {3, 5, 7},
                    {8, 1, 6}
            };
    private HashMap<Integer, Integer> MagicSquareToPos = new HashMap<Integer, Integer>()
    {{
        put(4, 1);
        put(9, 2);
        put(2, 3);
        put(3, 4);
        put(5, 5);
        put(7, 6);
        put(8, 7);
        put(1, 8);
        put(6, 9);
    }};

    // [down][right]

    public TicTacToe()
    {
        InitializeBoard();
        DrawBoard(true);
        AnnounceTurn();
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

    public void AnnounceTurn()
    {
        System.out.println("Player " + (pMark.equals("x") ? "1" : "2") + "'s turn!");
    }

    public void DrawBoard(boolean first)
    {
        int count = 1;
        for (int i = 0; i < 3; i++)
        {
            System.out.print("| ");
            for (int a = 0; a < 3; a++)
            {
                System.out.print(((first) ? count : board[i][a]) + " | ");
                count++;
            }
            System.out.println();
            if (i != 2)
                System.out.println("-------------");
        }
    }

    public boolean CanPlace(int position)
    {
        int count = 1;
        for (int i = 0; i < 3; i++)
        {
            for (int a = 0; a < 3; a++)
            {
                if (count == position)
                {
                    if (board[i][a] == "-")
                    {
                        return true;
                    }
                }
                count++;
            }
        }
        return false;
    }

    public boolean PlaceMark(int position)
    {
        if (position > 9 || position < 1)
        {
            System.out.println("Number must be between 1-9.");
            return false;
        }
        int count = 1;
        for (int i = 0; i < 3; i++)
        {
            for (int a = 0; a < 3; a++)
            {
                if (count == position)
                {
                    if (CanPlace(position))
                    {
                        board[i][a] = pMark;
                        return true;
                    }
                    else
                    {
                        System.out.println("There is already a mark there, choose again.");
                        return false;
                    }
                }
                count++;
            }
        }
        return true;
    }

    public void EndGame()
    {
        if (tieGame)
            System.out.println("The game is a tie!");
        else
            System.out.println("Player " + (pMark.equals("x") ? "1" : "2") + " wins!");
        GameOver = true;
    }

    public boolean CheckEnd()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int a = 0; a < 3; a++)
            {
                // I know this isn't a good way of doing this but its late
                if (board[0][0] == pMark && board[0][1] == pMark && board[0][2] == pMark ||
                        board[1][0] == pMark && board[1][1] == pMark && board[1][2] == pMark ||
                        board[2][0] == pMark && board[2][1] == pMark && board[2][2] == pMark ||
                        board[0][0] == pMark && board[1][0] == pMark && board[2][0] == pMark ||
                        board[0][1] == pMark && board[1][1] == pMark && board[2][1] == pMark ||
                        board[0][2] == pMark && board[1][2] == pMark && board[2][2] == pMark ||
                        board[0][0] == pMark && board[1][1] == pMark && board[2][2] == pMark ||
                        board[0][2] == pMark && board[1][1] == pMark && board[2][0] == pMark)
                {
                    return true;
                }
            }
        }

        int hCount = 0;
        int vCount = 0;
        int dnCount = 0;
        int drCount = 0;

        for (int i = 0; i < 3; i++)
        {
            hCount = 0;
            vCount = 0;
            dnCount = 0;
            drCount = 0;
            for (int a = 0; a < 3; a++)
            {
                if (board[i][a].equals("x") || board[i][a].equals("o"))
                {
                    hCount++;
                }
                if (board[a][i].equals("x") || board[a][i].equals("o"))
                {
                    vCount++;
                }
                if (board[a][a].equals("x") || board[a][a].equals("o"))
                {
                    dnCount++;
                }
                if (board[a][Math.abs(-2 + a)].equals("x") || board[a][Math.abs(-2 + a)].equals("o"))
                {
                    drCount++;
                }
            }
        }
        if (hCount == 3 && vCount == 3 && dnCount == 3 && drCount == 3)
        {
            tieGame = true;
            return true;
        }
        return false;
    }

    public void ChangePlayer()
    {
        pMark = (pMark.equals("x")) ? "o" : "x";
    }

    public int GetNextMove(boolean block)
    {
        String player = (block) ? "x" : "o";

        int max = 15;

        for (int i = 0; i < 3; i++)
        {
            int count = 0;
            int total = 0;
            for (int a = 0; a < 3; a++)
            {
                if (board[i][a].equals(player))
                {
                    count++;
                    total += ArrToMagicSquare[i][a];
                }
            }
            if (count == 2)
            {
                int num = MagicSquareToPos.get(max - total);
                if (CanPlace(num))
                    return num;
            }
        }

        for (int i = 0; i < 3; i++)
        {
            int count = 0;
            int total = 0;
            for (int a = 0; a < 3; a++)
            {
                if (board[a][i].equals(player))
                {
                    count++;
                    total += ArrToMagicSquare[a][i];
                }
            }
            if (count == 2)
            {
                int num = MagicSquareToPos.get(max - total);
                if (CanPlace(num))
                    return num;
            }
        }

        for (int i = 0; i < 3; i++)
        {
            int count = 0;
            int total = 0;
            for (int a = 0; a < 3; a++)
            {
                if (board[a][a].equals(player))
                {
                    count++;
                    total += ArrToMagicSquare[a][a];
                }
            }
            if (count == 2)
            {
                int num = MagicSquareToPos.get(max - total);
                if (CanPlace(num))
                    return num;
            }
        }

        for (int i = 0; i < 3; i++)
        {
            int count = 0;
            int total = 0;
            for (int a = 0; a < 3; a++)
            {
                if (board[a][Math.abs(-2 + a)].equals(player))
                {
                    count++;
                    total += ArrToMagicSquare[a][Math.abs(-2 + a)];
                }
            }
            if (count == 2)
            {
                int num = MagicSquareToPos.get(max - total);
                if (CanPlace(num))
                    return num;
            }
        }
        return -1;
    }

    public int GetRandomPos()
    {
        if (CanPlace(5))
        {
            return 5;
        }

        int num = CalcRandomCorner();
        if (num != -1)
            return num;
        num = CalcRandomSide();
        if (num != -1)
            return num;
        return -1;
    }

    public int CalcNextMove()
    {
        int nMove;

        // TRY TO WIN
        nMove = GetNextMove(false);
        if (nMove != -1)
        {
            return nMove;
        }

        // BLOCK PLAYER FROM WINNING
        nMove = GetNextMove(true);
        if (nMove != -1)
        {
            return nMove;
        }

        // PLACE RANDOM
        nMove = GetRandomPos();
        return nMove;
    }

    public void AIMove()
    {
        PlaceMark(CalcNextMove());
    }

    public int GetRandomChoice(ArrayList<Integer> nums)
    {
        Random rand = new Random();
        for (int i = 0; i < nums.size(); i++)
        {
            int num = nums.get(rand.nextInt(nums.size()));
            if (CanPlace(num))
                return num;
            else
            {
                nums.remove(i);
            }
        }

        return -1;
    }

    public int CalcRandomCorner()
    {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(0);
        nums.add(3);
        nums.add(7);
        nums.add(9);
        return GetRandomChoice(nums);
    }

    public int CalcRandomSide()
    {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(4);
        nums.add(6);
        nums.add(8);
        return GetRandomChoice(nums);
    }
}
