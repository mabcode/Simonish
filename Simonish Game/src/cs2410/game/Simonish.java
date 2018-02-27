/**
 * @author marc bigler
 * @version CS2410-002.Assn6
 */

package cs2410.game;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.SwingUtilities;
import java.util.Random;
import java.util.Vector;

import cs2410.components.ColorPiece;
import cs2410.components.GameBoard;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Simonish extends JFrame implements ActionListener, MouseListener {

	private ColorPiece[][] btnBoard;
	private int btnSize = 200;
	private int width = 2;
	private int height = 2;
	boolean isRunning=true;
	Vector<ColorPiece> vect= new Vector<ColorPiece>();

	JButton boardBtn;
	JLabel highScore;
	JLabel lowScore;
	Container pane;
	JPanel boardPanel;
	GameBoard gamePanel;

	private Simonish() {
		this.setTitle("Simonish");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		pane = this.getContentPane();
		pane.setLayout(null);
		pane.removeAll();
		boardPanel = new JPanel();
		pane.setPreferredSize(new Dimension(width * btnSize, ((height) * btnSize) + 100));
		gamePanel = new GameBoard();
		boardPanel.setLayout(null);
		boardPanel.setBounds(0, 100, width * btnSize, height * btnSize);
		pane.add(boardPanel);
		pane.add(gamePanel);
		initBtns();
		resetBtn();
		pane.update(pane.getGraphics());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void startGame() {
		gamePanel.setScore(0);
		gamePanel.getCurrentScore();
		gamePanel.update(this.gamePanel.getGraphics());
		gamePanel.setGameOver();

		setPattern();
		setPath();
	}

	private void resetBtn() {
		this.gamePanel.getStartBtn().addActionListener(this);

	}

	private void setPath() {
		Random rnd = new Random();
		int tmpX;
		int tmpY;
		while(isRunning) {
			tmpX = rnd.nextInt(2);
			tmpY = rnd.nextInt(2);

			vect.add(this.btnBoard[tmpX][tmpY]);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.btnBoard[tmpX][tmpY].setBackground(this.btnBoard[tmpX][tmpY].getBackground().brighter());
			this.btnBoard[tmpX][tmpY].update(this.btnBoard[tmpX][tmpY].getGraphics());

			try {
				Thread.sleep(400);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			this.btnBoard[tmpX][tmpY].setBackground(this.btnBoard[tmpX][tmpY].getBackground().darker());
			this.btnBoard[tmpX][tmpY].update(this.btnBoard[tmpX][tmpY].getGraphics());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(boardPanel!=btnBoard[tmpX][tmpY]){
				isRunning=true;
			}
		}	
		
	}
	
	

	private void setPattern() {
		int count = 1;

		for (int w = 0; w < width; w++) {
			for (int h = 0; h < height; h++) {
				count++;

				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				this.btnBoard[w][h].setBackground(this.btnBoard[w][h].getBackground().brighter());
				this.btnBoard[w][h].update(this.btnBoard[w][h].getGraphics());

				try {
					Thread.sleep(400);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				this.btnBoard[w][h].setBackground(this.btnBoard[w][h].getBackground().darker());
				this.btnBoard[w][h].update(this.btnBoard[w][h].getGraphics());
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

	}

	private void initBtns() {

		this.btnBoard = new ColorPiece[width][height];

		for (int w = 0; w < width; w++) {
			for (int h = 0; h < height; h++) {
				ColorPiece tmp = new ColorPiece(w, h, btnSize, btnBoard);
				tmp.addMouseListener(this);
				btnBoard[w][h] = tmp;
				boardPanel.add(btnBoard[w][h]);
			}
		}
	}

	public static void main(String[] args) {
		new Simonish();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == gamePanel.getStartBtn()) {
			startGame();

		}
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		ColorPiece tmp = (ColorPiece) e.getSource();
		tmp.setBackground(tmp.getBackground().brighter());
		
	}

	public void mouseReleased(MouseEvent e) {
		ColorPiece tmp = (ColorPiece) e.getSource();
		tmp.setBackground(tmp.getBackground().darker());
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

}
