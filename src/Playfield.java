import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Playfield extends JPanel{
	
	private static final long serialVersionUID = 1L;
	JPanel panelCreditPrize, panelSlotMachine, panelStartStopBtn;
	JLabel credit, prize;
	JTextField creditText, prizeText;
	
	JButton startBtn, stopBtn;

	Playfield(){
		panelCreditPrize = new JPanel();
		panelSlotMachine = new JPanel();
		panelStartStopBtn = new JPanel();
		
		this.setLayout( new BorderLayout() );
		
		//First Panel - Credits, Prize
		panelCreditPrize.setLayout( new GridLayout(2,2) );
		
		this.credit = new JLabel("Credit");
		this.credit.setFont(this.credit.getFont().deriveFont(60));
		this.prize = new JLabel("Prize");
		
		this.creditText = new JTextField("100");
		this.prizeText = new JTextField("0");
		
		this.panelCreditPrize.add(this.credit);
		this.panelCreditPrize.add(this.prize);
		this.panelCreditPrize.add(this.creditText);
		this.panelCreditPrize.add(this.prizeText);
		
		//Second Panel - slot machine
		
		//Third Panel - start/stop buttons
		this.startBtn = new JButton("start");
		this.stopBtn = new JButton("stop");
		
		panelStartStopBtn.add(this.startBtn);
		panelStartStopBtn.add(this.stopBtn);
		
		
		//add the three panels to playfield
		this.add(this.panelCreditPrize, BorderLayout.NORTH);
		this.add(this.panelSlotMachine, BorderLayout.CENTER);
		this.add(this.panelStartStopBtn, BorderLayout.SOUTH);
		
	}

}
