package myPackage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class TicTacToe implements ActionListener{
	Random random;
	JFrame frame;
	JPanel buttonPanel;
	JPanel titlePanel;
	JLabel textField;
	JButton[] buttons = new JButton[10];
	boolean player1_turn;
	
	public TicTacToe(){
		random = new Random();
		frame = new JFrame();
		buttonPanel = new JPanel();
		titlePanel = new JPanel ();
		textField = new JLabel();
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(25,255,0));
		textField.setFont(new Font("Ink Free",Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic-tac-toe");
		textField.setOpaque(true);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0,0,800,100);
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(150,150,150));
		
		for(int i = 0; i<9;i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			
		}
		
		titlePanel.add(textField);
		frame.add(titlePanel,BorderLayout.NORTH);
		frame.add(buttonPanel);
		
		firstTurn();
	}
	

	public static void main(String[] args) {
		new TicTacToe();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1_turn=false;
						textField.setText("O turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1_turn=true;
						textField.setText("X turn");
						check();
				}
			}
		}
	}
		
}
	public void firstTurn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		if(random.nextInt(2) == 0) {
			player1_turn = true;
			textField.setText("X turn");
		}else {
			player1_turn = false;
			textField.setText("O turn");
		}
	}
	public void check() {
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		
//		//Check O wins
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
	}
		
	}

	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0; i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText("X Wins!");
	}
	public void oWins(int a, int b, int c) {
	buttons[a].setBackground(Color.GREEN);
	buttons[b].setBackground(Color.GREEN);
	buttons[c].setBackground(Color.GREEN);		
	for(int i = 0; i<9; i++) {
			buttons[i].setEnabled(false);
	}
		textField.setText("O Wins!");
	}
}
