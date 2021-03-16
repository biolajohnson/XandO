package com.games;

public class Main {

    public static void main(String[] args) {
	XandO game = new XandO();
	game.putsMark(1, 2);
	game.putsMark(2,0);
	game.putsMark(1,0);
	game.putsMark(1, 1);
	game.putsMark(0, 0);
	game.putsMark(0,2);

	int winningPlayer = game.winner();
	System.out.println(game);
	String[] outcomes = {"X wins", "draw", "O wins"};
	System.out.println(outcomes[3 + winningPlayer]);
    }
}
