
/*
 * Name: Ahmar Mohammed
 * ID: 23132761
 */


import java.awt.*;     
import javax.swing.*;      // importing whole package is so easy and simple.
import java.awt.event.*;


public class TicTacToeGUI implements ActionListener
{
	//Asking user
	JFrame frame = new JFrame();
	JTextField jtf = new JTextField("Would you like to play?");
	JButton button1 = new JButton("Yes");
	JButton button2 = new JButton("No");
	
	// actual game board
	JFrame window = new JFrame("Tic Tac Toe");
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton b4 = new JButton("4");
	JButton b5 = new JButton("5");
	JButton b6 = new JButton("6");
	JButton b7 = new JButton("7");
	JButton b8 = new JButton("8");
	JButton b9 = new JButton("9");
	String letter = "";
	int count = -1;
	boolean win = false;

//===============  Constructor =================== //
	public TicTacToeGUI()
	{
		// asking use
		frame.setTitle("Tic Tac Toe");
		frame.setSize(200,130);
		frame.setLocation(500,250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());


		frame.add(jtf);
		frame.add(button1);
		frame.add(button2);

		jtf.setEditable(false);
		jtf.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);

		frame.setVisible(true); // Making frame visible.

		window.setSize(300,300);
		window.setLocation(500,250);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new GridLayout(3,3));

		window.add(b1); // adding buttons to the window in a grid layout.
		window.add(b2);
		window.add(b3);
		window.add(b4);
		window.add(b5);
		window.add(b6);
		window.add(b7);
		window.add(b8);
		window.add(b9);


		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		
		window.setVisible(false);  //Is false because we first need to ask the user if he or she wants to play 

	}
// =================== End of Constructor =========================//
	
	
	public void actionPerformed(ActionEvent event)   
	{

		String s = event.getActionCommand();
		if(s.equals("Yes"))
		{
			frame.setVisible(false);
			window.setVisible(true); // making it visible on users demand
		}
		else if(s.equals("No"))
		{
			System.exit(0);
		}

		// Giving the turn
		count++;  
		if(count == 1 || count == 3 || count == 5 || count == 7 || count == 9)
		{
			letter = "X";
		}
		else if(count == 2 || count == 4 || count == 6 || count == 8 || count == 10)
		{
			letter = "O";	
		}


		//Display
		if(event.getSource() == b1)
		{
			b1.setText(letter);
			b1.setEnabled(false); // making it disable once used.
		}
		else if(event.getSource() == b2)
		{
			b2.setText(letter);
			b2.setEnabled(false);
		}
		else if(event.getSource() == b3)
		{
			b3.setText(letter);
			b3.setEnabled(false);
		}
		else if(event.getSource() == b4)
		{
			b4.setText(letter);
			b4.setEnabled(false);
		}
		else if(event.getSource() == b5)
		{
			b5.setText(letter);
			b5.setEnabled(false);
		}
		else if(event.getSource() == b6)
		{
			b6.setText(letter);
			b6.setEnabled(false);
		}
		else if(event.getSource() == b7)
		{
			b7.setText(letter);
			b7.setEnabled(false);
		}
		else if(event.getSource() == b8)
		{
			b8.setText(letter);
			b8.setEnabled(false);
		}
		else if(event.getSource() == b9)
		{
			b9.setText(letter);
			b9.setEnabled(false);
		}

		//Checking if somebody has won the game.

		//Horizontal winning
		//    123,456,789
		if(b1.getText() == b2.getText() && b2.getText() == b3.getText() && b1.getText() != "1")
		{
			win = true;
		} 
		else if(b4.getText() == b5.getText() && b5.getText() == b6.getText() && b4.getText() != "4")
		{
			win = true;
		}
		else if(b7.getText() == b8.getText() && b8.getText() == b9.getText() && b7.getText() != "7")
		{
			win = true;
		}

		// vertical winning
		//    147,258,369
		else if(b1.getText() == b4.getText() && b4.getText() == b7.getText() && b1.getText() != "1")
		{
			win = true;
		} 
		else if(b2.getText() == b5.getText() && b5.getText() == b8.getText() && b2.getText() != "2")
		{
			win = true;
		}
		else if(b3.getText() == b6.getText() && b6.getText() == b9.getText() && b3.getText() != "3")
		{
			win = true;
		}

		// diagonal
		//  159,357
		else if(b1.getText() == b5.getText() && b5.getText() == b9.getText() && b1.getText() != "1")
		{
			win = true;
		} 
		else if(b3.getText() == b5.getText() && b5.getText() == b7.getText() && b3.getText() != "3")
		{
			win = true;
		}
		else
		{
			win = false;
		}
		if(win == true)
		{
			JOptionPane.showMessageDialog(null,"Player "+ letter + " Wins");
			window.setVisible(false);
			new TicTacToeGUI();      // Asking again
		}
		else if(count == 9 && win == false)
		{
			JOptionPane.showMessageDialog(null,"It's a tie!");
			window.setVisible(false);
			new TicTacToeGUI();  
		}	
	}

// ======================== Main Method ============================== //
	public static void main(String []args)
	{
		new TicTacToeGUI();
	}
// =======================End of Main =================================//	

}


