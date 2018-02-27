
package cs2410.components;

import javax.swing.border.BevelBorder;

import java.util.Vector;

import javax.swing.BorderFactory;

import javax.swing.JPanel;

public class ColorPiece extends JPanel {
	
	private int locX;
	private int locY;
	private static int count = 1;

	public ColorPiece() {
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

	}

	public ColorPiece(int x, int y, int size, ColorPiece[][] btnBoard) {
		this();
		locX = x;
		locY = y;
		this.setBounds(x * size, y * size, size, size);
		if (count == 1) {
			this.setBackground(java.awt.Color.BLUE.darker());
		}
		if (count == 2) {
			this.setBackground(java.awt.Color.RED.darker());
		}
		if (count == 3) {
			this.setBackground(java.awt.Color.GREEN.darker());
		}
		if (count == 4) {
			this.setBackground(java.awt.Color.YELLOW.darker());
		}
		count++;

	}
}