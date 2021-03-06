package assigment1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interface extends JFrame implements ActionListener {
	public static void main(String args[]) {
		JLabel note= new JLabel("*Note:the inputs must respect the following fomat: a1X^n+a2X^n-1+...+an-1X^1+anX^0");
		JLabel note1= new JLabel("You can also add '-' to the coefficients and you must write '1X' for coefficient '1'");
		JLabel firstPoly = new JLabel("First polynom :");
		JLabel secondPoly = new JLabel("Second polynom :");
		JLabel dataOut = new JLabel("Result :");
		dataOut.setFont(new Font("Serif",Font.PLAIN,30));
		JTextField in1 = new JTextField(25);
		JTextField in2 = new JTextField(25);
		JButton addition = new JButton("+");
		JButton subtraction = new JButton("-");
		JButton deriv = new JButton("x'");
		JButton integr = new JButton("~");
		JButton multiply = new JButton("*");
		JButton devide = new JButton("/");
		JLabel out = new JLabel();
		out.setFont(new Font("Serif",Font.PLAIN,30));

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel p = new JPanel();

		Interface fr = new Interface();
		fr.setLayout(new FlowLayout());
		fr.setSize(800, 400);
		fr.setTitle("Polynomial Calculator");

		panel5.add(note);
		panel6.add(note1);
		panel1.add(firstPoly);
		panel1.add(in1);
		panel1.add(secondPoly);
		panel1.add(in2);
		panel2.add(addition);
		panel2.add(subtraction);
		panel2.add(multiply);
		panel4.add(devide); 
		panel4.add(deriv);
		panel4.add(integr);
		panel3.add(dataOut);
		panel3.add(out);

		p.add(panel5);
		p.add(panel6);
		p.add(panel1);
		p.add(panel2);
		p.add(panel4);
		p.add(panel3);
		

		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		
		
		
		List<Monomial> monomialList1 = new ArrayList<Monomial>();
		Polynomial polynom1 = new Polynomial(monomialList1);
		List<Monomial> monomialList2 = new ArrayList<Monomial>();
		Polynomial polynom2 = new Polynomial(monomialList2);
		
		addition.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				monomialList1.clear();
				monomialList2.clear();
				if(e.getSource()== addition) {
					out.removeAll();
					Operations op=new Operations();
					
					List<Monomial> monomialList3 = new ArrayList<Monomial>();
					Polynomial poly1 = new Polynomial(monomialList3);
					poly1.createPoly(in1.getText());
					for(Monomial item : monomialList3) {
						Monomial m=new Monomial(item.getPower(), item.getCoef());
						monomialList1.add(m);
					}
					
					List<Monomial> monomialList4 = new ArrayList<Monomial>();
					Polynomial poly2 = new Polynomial(monomialList4);
					poly2.createPoly(in2.getText());
					for(Monomial item : monomialList4) {
						Monomial m=new Monomial(item.getPower(), item.getCoef());
						monomialList2.add(m);
					}
					
					
					ArrayList<Monomial> monomialList5 = new ArrayList<Monomial>();
					Polynomial result = new Polynomial(monomialList5);
					result=op.addPolynoms(polynom1, polynom2);
					out.setText(op.toString(result));
					monomialList5.clear();
					
				}
			}
		});
		subtraction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				monomialList1.clear();
				monomialList2.clear();
				if(e.getSource()== subtraction) {
					Operations op=new Operations();
					List<Monomial> monomialList3 = new ArrayList<Monomial>();
					Polynomial poly1 = new Polynomial(monomialList3);
					poly1.createPoly(in1.getText());
					for(Monomial item : monomialList3) {
						Monomial m=new Monomial(item.getPower(), item.getCoef());
						monomialList1.add(m);
					}
					List<Monomial> monomialList4 = new ArrayList<Monomial>();
					Polynomial poly2 = new Polynomial(monomialList4);
					poly2.createPoly(in2.getText());
					for(Monomial item : monomialList4) {
						Monomial m=new Monomial(item.getPower(), item.getCoef());
						monomialList2.add(m);
					}
					List<Monomial> monomialList5 = new ArrayList<Monomial>();
					Polynomial result = new Polynomial(monomialList5);
					result=op.subPolynoms(polynom1, polynom2);
					out.setText(op.toString(result));					
				}
				
			}
		});
		multiply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				monomialList1.clear();
				monomialList2.clear();
				if(e.getSource()== multiply ) {
					Operations op=new Operations();
					List<Monomial> monomialList3 = new ArrayList<Monomial>();
					Polynomial poly1 = new Polynomial(monomialList3);
					poly1.createPoly(in1.getText());
					for(Monomial item : monomialList3) {
						Monomial m=new Monomial(item.getPower(), item.getCoef());
						monomialList1.add(m);
					}
					List<Monomial> monomialList4 = new ArrayList<Monomial>();
					Polynomial poly2 = new Polynomial(monomialList4);
					poly2.createPoly(in2.getText());
					for(Monomial item : monomialList4) {
						Monomial m=new Monomial(item.getPower(), item.getCoef());
						monomialList2.add(m);
					}
					List<Monomial> monomialList5 = new ArrayList<Monomial>();
					Polynomial result = new Polynomial(monomialList5);
					result=op.mulPolynoms(polynom1, polynom2);
					out.setText(op.toString(result));
				}
			}
		});
		deriv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				monomialList1.clear();
				monomialList2.clear();
				if(e.getSource()== deriv ) {
					Operations op=new Operations();
					List<Monomial> monomialList3 = new ArrayList<Monomial>();
					Polynomial poly1 = new Polynomial(monomialList3);
					poly1.createPoly(in1.getText());
					for(Monomial item : monomialList3) {
						Monomial m=new Monomial(item.getPower(), item.getCoef());
						monomialList1.add(m);
					}
					List<Monomial> monomialList5 = new ArrayList<Monomial>();
					Polynomial result = new Polynomial(monomialList5);
					result=op.derivPolynom(polynom1);
					out.setText(op.toString(result));
				}
			}
		});
		integr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				monomialList1.clear();
				monomialList2.clear();
				if(e.getSource()== integr ) {
					Operations op=new Operations();
					List<Monomial> monomialList3 = new ArrayList<Monomial>();
					Polynomial poly1 = new Polynomial(monomialList3);
					poly1.createPoly(in1.getText());
					for(Monomial item : monomialList3) {
						Monomial m=new Monomial(item.getPower(), item.getCoef());
						monomialList1.add(m);
					}
					List<Monomial> monomialList5 = new ArrayList<Monomial>();
					Polynomial result = new Polynomial(monomialList5);
					result=op.integrPolynom(polynom1);
					out.setText(op.toString(result));
				}
			}
		});
		fr.setContentPane(p);
		fr.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

