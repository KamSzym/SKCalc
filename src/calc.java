import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class calc{
	modeSelection mode;
	JFrame frame1;
	JButton numButtons[], mrcBut, mPlusBut, mMinusBut, sqrtBut, percentBut, 
			dotBut, cBut, isEqualBut, addBut, subtractBut, divideBut, multipleBut;
	JTextArea textArea;
	
	String inputString;
	Double num1, num2, num2Old;
	
	
	public static void main(String [] args){
		
		System.out.println("test nr 2");
		calc calcFrame =new calc();
		calcFrame.frameInit();		
	}
	
	public calc(){
		
		mode=modeSelection.NOTHING;
		inputString="";
		num1=(double) 0;
		num2=(double)0;
		frame1=new JFrame();
		
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
		
		textArea=new JTextArea("jebać stare kurwy pdk");
		
		
	}
	public void frameInit(){
		
		butListener butPressed=new butListener();
		for(int i=0;i<10;i++){
			
			numButtons[i].addActionListener(butPressed);
		}
		
		frame1.setSize(400,300);
		frame1.setLocationRelativeTo(null);
		frame1.setTitle("socjetChan.gov");
		
		JPanel panel1=new JPanel(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		
		c.fill=(GridBagConstraints.BOTH);
		c.weighty=1;
		c.weightx=1;
		c.insets=new Insets(5,5,5,5);
		
		c.gridx=0; c.gridy=0; c.gridwidth=4;
		panel1.add(textArea, c);
		c.gridwidth=1; c.gridx=0; c.gridy=1;
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
		addBut.addActionListener(butPressed);
		subtractBut.addActionListener(butPressed);
		multipleBut.addActionListener(butPressed);
		divideBut.addActionListener(butPressed);
		dotBut.addActionListener(butPressed);
		isEqualBut.addActionListener(butPressed);
		sqrtBut.addActionListener(butPressed);
		cBut.addActionListener(butPressed);
		
	}
	
	private void keyAction(final JButton button)throws NumberFormatException{

		if(button==addBut){
			makeAction(modeSelection.ADD);
		}else if(button==subtractBut){
			makeAction(modeSelection.SUBTRACT);
		}else if(button==isEqualBut){
			makeAction(modeSelection.ISEQUAL);
		}else if(button==cBut)
		{
			makeAction(modeSelection.CLEAR);			
		}else if(button==multipleBut){
			makeAction(modeSelection.MULTIPLY);
			
		}else if(button==divideBut){
			makeAction(modeSelection.DIVIDE);
			
		}else if(button==sqrtBut){
			makeAction(modeSelection.SQRT);
			
		}else{
			inputString+=button.getText();
			textArea.setText(inputString);
		}
		
	}
	public void makeAction(modeSelection newMode){
		
		if(inputString.startsWith("") || inputString.charAt(0)=='.'){
			inputString="0"+inputString;
		}
		
		
		if(newMode==modeSelection.CLEAR)
		{
			num1=(double) 0;
			num2=(double) 0;
			inputString=""; textArea.setText(num2.toString());
			newMode=modeSelection.NOTHING;
			
		}else if(newMode==modeSelection.SQRT)
		{
			num1=Double.parseDouble(inputString);
			if(num1!=0)
			{
				num2Old=num1;
				num2=Math.sqrt(num1);
				
			}
			else
			{
				num2Old=num2;
				num2=Math.sqrt(num2);
				
			}
			
			inputString=""; textArea.setText("sqrt("+num2Old+") = "+num2.toString());
			newMode=modeSelection.ISEQUAL;
		}
		
		
		
		
		else if(mode==modeSelection.ADD){
			num1=Double.parseDouble(inputString);
			num2Old=num2;
			num2+=num1;
			inputString=""; textArea.setText(num2Old.toString()+" + "+ num1.toString()+" = "+num2.toString());
		}else if(mode==modeSelection.SUBTRACT)
		{
			num1=Double.parseDouble(inputString);
			num2Old=num2;
			num2-=num1;
			inputString=""; textArea.setText(num2Old.toString()+" - "+ num1.toString()+" = "+num2.toString());
			
		}else if(mode==modeSelection.NOTHING)
		{
			num1=Double.parseDouble(inputString);
			num2=num1;
			inputString=""; textArea.setText(num2.toString());
			
		}else if(mode==modeSelection.ISEQUAL)
		{
			num1=Double.parseDouble(inputString);
			if(num1!=0){
				num2=num1;
			}
			inputString=""; textArea.setText(num2.toString());
			
		}else if(mode==modeSelection.MULTIPLY)
		{
			num1=Double.parseDouble(inputString);
			num2Old=num2;
			num2=num2*num1;
			inputString=""; textArea.setText(num2Old.toString()+" * "+ num1.toString()+" = "+num2.toString());
			
		}
		else if(mode==modeSelection.DIVIDE)
		{
			num1=Double.parseDouble(inputString);
			num2Old=num2;
			num2=num2/num1;
			inputString=""; textArea.setText(num2Old.toString()+" / "+ num1.toString()+" = "+num2.toString());
			
		}
		
		
		mode=newMode;
	}
	
	
	private class butListener implements ActionListener{

		@Override
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try{
			
				keyAction((JButton)e.getSource());
			}catch (NumberFormatException exception){
			
				String message="Sorry error ocured!\nYou have propably done something wrong\nError message:  "
							+exception.getMessage();
				JOptionPane.showMessageDialog(frame1, message, "error", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
		
	}
	public enum modeSelection{
		ADD, SUBTRACT, DIVIDE, MULTIPLY, NOTHING, ISEQUAL, CLEAR, SQRT
	}
}