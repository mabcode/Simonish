package cs2410.components;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameBoard extends JPanel {
	private boolean gameOver;
	
	private int highScore;
	private int currentScore;
	private JButton startBtn;
	private JLabel topScore;
	private JLabel score;

	public GameBoard() {
		currentScore = 0;
		topScore = new JLabel("Top Score: " + Integer.toString(highScore), SwingConstants.CENTER);
		score = new JLabel("Score: " + Integer.toString(currentScore), SwingConstants.CENTER);
		startBtn = new JButton("START");

		setBounds(0, 0, 390, 100);
		this.setLayout(new GridLayout(1, 3));

		add(topScore);
		add(startBtn);
		add(score);
	}

	public void updateTopScore(int update) {
		if (update > highScore) {
			highScore = update;
			topScore.setText("Top Score: " + Integer.toString(highScore));
		}
	}

	public void updateScore() {
		if (!gameOver) {
			score.setText("Score: " + Integer.toString(currentScore));
			if(currentScore>highScore){
				highScore=currentScore;
				topScore.setText("Top Score: " + Integer.toString(highScore));
			}
		}
	}

	public JButton getStartBtn() {
		return startBtn;
	}

	public void setScore(int currentScore) {
		this.currentScore = currentScore;
	}

	public int getScore() {
		return currentScore;
	}

	public void getCurrentScore() {
		score.setText("Score: " + Integer.toString(currentScore));
	}

	public void setGameOver() {
		startBtn.setVisible(false);
		gameOver = false;

	}
	public boolean getGameOver() {
		return gameOver;
	}
	public void setHighScore(int highScore){
		this.highScore=highScore;
	}
	public int getHighScore(){
		return highScore;
	}
	public void addScore(){
		currentScore++;
		score.setText("Score: " + Integer.toString(currentScore));
		updateScore();
		
	}
}
