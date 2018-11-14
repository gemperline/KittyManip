import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;


public class KittyGame extends JFrame implements ActionListener{


	
	JButton upButton = new JButton("UP");
	JButton leftButton = new JButton("LEFT");
	JButton rightButton = new JButton("RIGHT");
	JButton downButton = new JButton("DOWN");
	
	JLabel kitty = new JLabel("=^.^=");

	
	private final int ROWS = 8;
	private final int COLS = 8;
	private final int GAP = 2;
	
	private JPanel pane = new JPanel
			(new GridLayout(ROWS, COLS, GAP, GAP));
	
	private JPanel[][] panel = new JPanel[ROWS][COLS];
	private Color color1 = Color.WHITE;
	private Color color2 = Color.BLUE;
	private Color tempColor;
	
	private JLabel[][] labelArray = new JLabel[ROWS][COLS]; // create a loop as done below and add labels using panel[i][j].add(labelArray[i][j]); 
	
	// variables to hold row/col position
	public int x = 4;
	public int y = 4;
	
	public KittyGame() {
		super("Run Kitty Run");
		
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set panels 
		add(upButton, BorderLayout.NORTH);
		add(leftButton, BorderLayout.WEST);
		add(pane, BorderLayout.CENTER);
		add(rightButton, BorderLayout.EAST);
		add(downButton, BorderLayout.SOUTH);
		upButton.addActionListener(this);
		downButton.addActionListener(this);
		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
		
	// loop to add panes				
		for(int i = 0; i < ROWS; i++)
		{
	
				for(int j = 0; j < COLS; j++)
				{
					
					panel[i][j] = new JPanel();
					pane.add(panel[i][j]);
					
					// place kitty face in center of label array
					if(i == 4 && j == 4)
					{
						labelArray[i][j] = new JLabel("=^.^=");
					}
					else
					{	// add blank label to all other spaces in label array
						labelArray[i][j] = new JLabel("");
					}
									
					if(j % COLS == 0)
					{
						tempColor = color1;
						color1 = color2;
						color2 = tempColor;
					}		

									
					if(j % 2 == 0)
					{
						panel[i][j].setBackground(color1);
					}
					else
					{
						panel[i][j].setBackground(color2);
					}
					panel[i][j].add(labelArray[i][j]);
				}	
		}
}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == upButton)
		{
			// bounds check
			if(x > 0)
			{
				labelArray[x][y].setText("");
				x = x -1;
				labelArray[x][y].setText("=^.^=");
			}		
		}
		
		if(source == downButton)
		{
			// bounds check
			if(x < 7)
			{
				labelArray[x][y].setText("");
				x = x + 1;
				labelArray[x][y].setText("=^.^=");
			}		
		}
		
		if(source == leftButton)
		{
			// bounds check
			if(y > 0)
			{
				labelArray[x][y].setText("");
				y = y -1;
				labelArray[x][y].setText("=^.^=");
			}		
		}
		
		if(source == rightButton)
		{
			// bounds check
			if(y < 7)
			{
				labelArray[x][y].setText("");
				y = y + 1;
				labelArray[x][y].setText("=^.^=");
			}		
		}
		
	}
}