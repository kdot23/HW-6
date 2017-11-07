import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator extends JFrame
{
	private JButton buttons[] = new JButton[16];
	private String captions[] = {"1","2","3","+",
									"4","5","6","-",
									"7","8","9","/",
									"0","=","AC","*"};
	private JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
	private JTextField output = new JTextField(20);
	Container frame;
	private String b;
	private String num1 = "";
	private String num2 = "";
	private String text = "";
	private Boolean num1Done = false;
	private String operand;
	private double answer;
	
	public Calculator()
	{
		frame = getContentPane();
		for (int count=0;count<16;count++)
		{
			buttons[count] = new JButton(captions[count]);
			buttonPanel.add(buttons[count]);
		}
		for (int i = 0; i < 16; i++)
		{
			buttons[i].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					b = ((JButton) event.getSource()).getText();
					//text = calculate(b);
					output.setText(calculate(b));
				}
				public String calculate(String b)
				{
					switch(b)
					{
					case "+" : case "-" :
					case "*" : case "/" : 
						operand = b;
						text = text + b;
						num1Done = true;
						break;
					
					case "AC" : num1 = "";
								num2 = "";
								num1Done = false;
								text = "";
								break;
								
					case "=" : 
						System.out.println(num1);
						System.out.println(num2);
						System.out.println(operand);
						switch(operand)
								{
									case "+" : answer = (Integer.parseInt(num1)) + (Integer.parseInt(num2));
												break;
									case "-" : answer = Integer.parseInt(num1) - Integer.parseInt(num2);
												break;
									case "*" : answer = Integer.parseInt(num1) * Integer.parseInt(num2);
												break;
									case "/" : answer = Double.parseDouble(num1) / Double.parseDouble(num2);
												break;
								}
							text = Double.toString(answer);	
							num1 = "";
							num2 = "";
							num1Done = false;
							break;
					default : 
						if (num1Done == false)
						{
							num1 = num1 + b;
						}
						else
						{
							num2 = num2 + b;
						}
						text = text + b;
						break;
					}
					return text;
				}
				});
			}
				
		frame.setLayout(new BorderLayout());
		frame.add(output,BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

	}

    public static void main(String[] arguments) 
    {
        Calculator c = new Calculator();
    }
}
