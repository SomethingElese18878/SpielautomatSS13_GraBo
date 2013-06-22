import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Playfield extends JPanel{
	
	private static final long serialVersionUID = 1L;
	JPanel panelCreditPrize = new JPanel();
	JLabel credit, prize;
	JTextField creditText, prizeText;

	Playfield(){
		panelCreditPrize.setLayout( new GridLayout(2,2) );
		
		this.credit = new JLabel("Credit");
		this.prize = new JLabel("Prize");
		
		this.creditText = new JTextField("100");
		this.prizeText = new JTextField("0");
		
		this.panelCreditPrize.add(this.credit);
		this.panelCreditPrize.add(this.prize);
		this.panelCreditPrize.add(this.creditText);
		this.panelCreditPrize.add(this.prizeText);
		
		this.add(this.panelCreditPrize);
		
	}

}
