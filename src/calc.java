import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class calc{
	
	JFrame frame1;
	JButton numButtons[], mrcBut, mPlusBut, mMinusBut, sqrtBut, percentBut, 
			dotBut, cBut, isEqualBut, addBut, subtractBut, divideBut, multipleBut;
	JTextArea textArea;
	
	
	public static void main(String [] args){
		System.out.println("test nr 2");
		new calc();
		
		
	}
	
	public calc(){
		frame1=new JFrame();
		frame1.setSize(400,300);
		frame1.setLocationRelativeTo(null);
		frame1.setTitle("SKCalc");
		
		JPanel testPanel=new JPanel();
		JPanel panel1=new JPanel(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		
		
		numButtons=new JButton[10];
		for(int i=0;i<10;i++){
			numButtons[i]=new JButton(Integer.toString(i));
		}
		
		
		mrcBut=new JButton("MRC");
		mPlusBut=new JButton("M+");
		mMinusBut=new JButton("M-");
		sqrtBut=new JButton("sqrt");
		percentBut=new JButton("%");
		dotBut=new JButton(".");
		cBut=new JButton("C/CE");
		isEqualBut=new JButton("=");
		addBut=new JButton("+");
		subtractBut=new JButton("-");
		divideBut=new JButton("/");
		multipleBut=new JButton("*");
		
		textArea=new JTextArea("testing, no logic jet");
		c.fill=(GridBagConstraints.BOTH);
		
		c.weighty=100000;
		c.weightx=1000000;
		c.insets=new Insets(5,5,5,5);
		
		c.gridx=0; c.gridy=0;
		c.gridwidth=4;
		panel1.add(textArea, c);
		c.gridwidth=1;
		
		c.gridx=0; c.gridy=1;
		panel1.add(mrcBut, c);
		c.gridx=1; panel1.add( mMinusBut,c);
		c.gridx++; panel1.add( mPlusBut,c);
		c.gridx++; panel1.add( sqrtBut,c);
		c.gridx++; panel1.add( percentBut,c);
		c.gridx=3; c.gridy=2; panel1.add(divideBut,c);
		c.gridy++; panel1.add(multipleBut,c);
		c.gridy++; panel1.add(subtractBut,c);
		c.gridy++; panel1.add(addBut,c);
		
		c.gridx=0; c.gridy=5; c.gridwidth=2; 
		panel1.add(numButtons[0],c);
		c.gridx+=2;  c.gridwidth=1; 
		panel1.add(dotBut,c);
		c.gridx=4; c.gridy=2; c.gridheight=2; 
		panel1.add(cBut,c);
		c.gridy+=2;
		panel1.add(isEqualBut,c);
		c.gridheight=1;
		
		
		
		
		
		
		

		
		

		for(int y=0;y<3;y++){
			c.gridy=y+2;
			for(int x=0;x<3;x++){
				c.gridx=x;
				panel1.add(numButtons[y*3+x+1],c);
				
			}
		}
		
		
		frame1.add(panel1);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);
		
	}
}