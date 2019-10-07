package com.codewars;

public class Dinglemouse {

    final static char[][] buttons = {
            {'a', 'b', 'c', 'd', 'e', '1', '2', '3'},
            {'f', 'g', 'h',	'i', 'j', '4', '5',	'6'},
            {'k', 'l', 'm',	'n', 'o', '7', '8',	'9'},
            {'p', 'q', 'r',	's', 't', '.', '@',	'0'},
            {'u', 'v', 'w',	'x', 'y', 'z', '_',	'/'},
            {'A','S'}
    };

    public static int tvRemote(final String words) {
        int moves = 0;
        int curRow = 0;
        int curCol = 0;
        int newRow, newCol;
        boolean flag = false;
        for (int i=0; i<words.length(); i++) {
            char c = words.charAt(i);
            if ((Character.isUpperCase(c) && !flag) || (Character.isLowerCase(c) && flag)){
                newRow = getRowNum('A');
                newCol = getColNum('A');
                moves = moves + Math.abs(curRow - newRow) + Math.abs(curCol - newCol);
                curRow = newRow;
                curCol = newCol;
                c = Character.toLowerCase(c);
                moves++;
                flag = !flag;
            }
            if ((Character.isUpperCase(c) && flag)) {
                c = Character.toLowerCase(c);
            }
            if (c ==' '){
                newRow = getRowNum('S');
                newCol = getColNum('S');
                moves = moves + Math.abs(curRow - newRow) + Math.abs(curCol - newCol);
                curRow = newRow;
                curCol = newCol;
                moves++;
                continue;
            }
            newRow = getRowNum(c);
            newCol = getColNum(c);
            moves = moves + Math.abs(curRow - newRow) + Math.abs(curCol - newCol);
            curRow = newRow;
            curCol = newCol;
            moves++;
        }
        return moves;
    }

    public static int getRowNum(char value){
        for (int i=0; i< buttons.length; i++) {
            for (int j=0; j<buttons[i].length; j++){
                if (value==buttons[i][j]){
                    return i;
                }
            }
        }
        return 0;
    }

    public static int getColNum(char value){
        for (int i=0; i< buttons.length; i++) {
            for (int j=0; j<buttons[i].length; j++){
                if (value==buttons[i][j]){
                    return j;
                }
            }
        }
        return 0;
    }

}