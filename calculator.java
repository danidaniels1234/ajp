// Java program to create a simple calculator
// with basic +, -, /, * using java swing elements
// 4 GUI CALCULATOR

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class calculator extends JFrame implements ActionListener {
	// create a frame
	static JFrame f;

	// create a textfield
	static JTextField l;

	// store operator and operands
	String s0, s1, s2;

	// default constructor
	calculator()
	{
		s0 = s1 = s2 = "";
	}

	// main function
	public static void main(String args[])
	{
		// create a frame
		f = new JFrame("calculator");

		try {
			// set look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// create a object of class
		calculator c = new calculator();

		// create a textfield
		l = new JTextField(16);

		// set the textfield to non editable
		l.setEditable(false);

		// create number buttons and some operators
		JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;

		// create number buttons
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");

		// equals button
		beq1 = new JButton("=");

		// create operator buttons
		ba = new JButton("+");
		bs = new JButton("-");
		bd = new JButton("/");
		bm = new JButton("*");
		beq = new JButton("C");

		// create . button
		be = new JButton(".");

		// create a panel
		JPanel p = new JPanel();

		// add action listeners
		bm.addActionListener(c);
		bd.addActionListener(c);
		bs.addActionListener(c);
		ba.addActionListener(c);
		b9.addActionListener(c);
		b8.addActionListener(c);
		b7.addActionListener(c);
		b6.addActionListener(c);
		b5.addActionListener(c);
		b4.addActionListener(c);
		b3.addActionListener(c);
		b2.addActionListener(c);
		b1.addActionListener(c);
		b0.addActionListener(c);
		be.addActionListener(c);
		beq.addActionListener(c);
		beq1.addActionListener(c);

		// add elements to panel
		p.add(l);
		p.add(ba);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(bs);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(bm);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(bd);
		p.add(be);
		p.add(b0);
		p.add(beq);
		p.add(beq1);

		// set Background of panel
		p.setBackground(Color.blue);

		// add panel to frame
		f.add(p);

		f.setSize(200, 220);
		f.show();
	}
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

		// if the value is a number
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
			// if operand is present then add to second no
			if (!s1.equals(""))
				s2 = s2 + s;
			else
				s0 = s0 + s;

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == 'C') {
			// clear the one letter
			s0 = s1 = s2 = "";

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == '=') {

			double te;

			// store the value in 1st
			if (s1.equals("+"))
				te = (Double.parseDouble(s0) + Double.parseDouble(s2));
			else if (s1.equals("-"))
				te = (Double.parseDouble(s0) - Double.parseDouble(s2));
			else if (s1.equals("/"))
				te = (Double.parseDouble(s0) / Double.parseDouble(s2));
			else
				te = (Double.parseDouble(s0) * Double.parseDouble(s2));

			// set the value of text
			l.setText(s0 + s1 + s2 + "=" + te);

			// convert it to string
			s0 = Double.toString(te);

			s1 = s2 = "";
		}
		else {
			// if there was no operand
			if (s1.equals("") || s2.equals(""))
				s1 = s;
			// else evaluate
			else {
				double te;

				// store the value in 1st
				if (s1.equals("+"))
					te = (Double.parseDouble(s0) + Double.parseDouble(s2));
				else if (s1.equals("-"))
					te = (Double.parseDouble(s0) - Double.parseDouble(s2));
				else if (s1.equals("/"))
					te = (Double.parseDouble(s0) / Double.parseDouble(s2));
				else
					te = (Double.parseDouble(s0) * Double.parseDouble(s2));

				// convert it to string
				s0 = Double.toString(te);

				// place the operator
				s1 = s;

				// make the operand blank
				s2 = "";
			}

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
	}
}


/*
import java.lang.*;
import java.awt.*;
import java.awt.event.*;

class MarvellousFrame extends WindowAdapter implements ActionListener
{
    public Frame fobj;
    public TextField tobj1,tobj2,tobj3;
    public Button bobj1,bobj2,bobj3,bobj4;
    public Label lobj1,lobj2,lobj3;

    public MarvellousFrame(String name)
    {
        fobj = new Frame(name);
        
        tobj1 = new TextField();
        tobj1.setBounds(100,70,200,30);
        tobj2 = new TextField();
        tobj2.setBounds(100,140,200,30);
        tobj3 = new TextField();
        tobj3.setBounds(100,210,200,30);
        tobj3.setEditable(false);

        lobj1 = new Label("Enter First Number");
        lobj1.setBounds(100,40,150,30);
        lobj2 = new Label("Enter Second Number");
        lobj2.setBounds(100,110,110,30);
        lobj3 = new Label("Calculation is:");
        lobj3.setBounds(100,180,150,30);

        bobj1 = new Button("+");
        bobj1.setBounds(70,270,50,20);
        bobj2 = new Button("-");
        bobj2.setBounds(150,270,50,20);
        bobj3 = new Button("*");
        bobj3.setBounds(230,270,50,20);
        bobj4 = new Button("/");
        bobj4.setBounds(310,270,50,20);

        fobj.add(tobj1);
        fobj.add(tobj2);
        fobj.add(tobj3);
        fobj.add(bobj1);
        fobj.add(bobj2);
        fobj.add(bobj3);
        fobj.add(bobj4);
        fobj.add(lobj1);
        fobj.add(lobj2);
        fobj.add(lobj3);

        fobj.setSize(400,400);
        fobj.setLayout(null);
        fobj.setVisible(true);

        fobj.addWindowListener(this);
        bobj1.addActionListener(this);
        bobj2.addActionListener(this);
        bobj3.addActionListener(this);
        bobj4.addActionListener(this);
    }
    
    public void windowClosing(WindowEvent obj)
    {
        System.exit(0);
    }

    public void actionPerformed(ActionEvent obj)
    {
        String str1 = tobj1.getText();
        String str2 = tobj2.getText();

        int iNo1 = Integer.parseInt(str1);
        int iNo2 = Integer.parseInt(str2);
        int iNo3 = 0;

        if(obj.getSource() == bobj1)
        {
            iNo3 = iNo1 + iNo2;            
        }
        else if(obj.getSource() == bobj2)
        {
            iNo3 = iNo1 - iNo2;
        }
        else if(obj.getSource() == bobj3)
        {
            iNo3 = iNo1 * iNo2;
        }
        else if(obj.getSource() == bobj4)
        {
            iNo3 = iNo1 / iNo2;
        }

        String iRet = String.valueOf(iNo3);
        tobj3.setText(iRet);

    }
    
}

class Calculator
{
    public static void main(String arg[])
    {

        MarvellousFrame mobj = new MarvellousFrame("Calculator");

    }
}
*/
