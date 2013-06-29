import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.spielautomat;


public class Playfield extends JPanel{
	private static final long serialVersionUID = 1L;
	JPanel panelCreditPrize, panelSlotMachine, panelStartStopBtn;
	JLabel credit, prize;
	JTextField creditText, prizeText;
	JButton startBtn, stopBtn;
	JLabel[] automat = new JLabel[4]; 
	spielautomat game;
	Integer[] numerics;

	Playfield(){
		this.game = spielautomat.getInstance();
		this.game.addspielListener( new mySpielautomatListener(this) );
		
		this.panelCreditPrize = new JPanel();
		this.panelSlotMachine = new JPanel();
		this.panelStartStopBtn = new JPanel();
		
		this.setLayout( new BorderLayout() );
		
		//First Panel - Credits, Prize
		this.panelCreditPrize.setLayout( new GridLayout(2,2) );
		
		this.credit = new JLabel("Credit");
		this.prize = new JLabel("Prize");
		
		this.creditText = new JTextField("100");
		this.creditText.setFont( new Font("Arial", Font.PLAIN ,20));
		this.prizeText = new JTextField("0");
		this.prizeText.setFont( new Font("Arial", Font.PLAIN ,20));
		
		this.panelCreditPrize.add(this.credit);
		this.panelCreditPrize.add(this.prize);
		this.panelCreditPrize.add(this.creditText);
		this.panelCreditPrize.add(this.prizeText);
		
		//Second Panel - slot machine
		this.panelSlotMachine.setLayout( new GridBagLayout() );
		this.numerics = this.game.getZiffern();
		
		for(int i = 0; i < 4; i++){
			automat[i] = new JLabel(this.numerics[i].toString(), JLabel.CENTER);
			automat[i].setPreferredSize( new Dimension(50, 50) );
			automat[i].setFont( new Font("Arial", Font.PLAIN, 28));
			automat[i].setBorder( new LineBorder(Color.RED, 3) );

			this.panelSlotMachine.add(automat[i]);
		}
		
		//Third Panel - start/stop buttons
		this.startBtn = new JButton("start");
		this.stopBtn = new JButton("stop");
		this.startBtn.addActionListener( new ButtonListener(this) );
		this.stopBtn.addActionListener( new ButtonListener(this) );
		
		this.panelStartStopBtn.add(this.startBtn);
		this.panelStartStopBtn.add(this.stopBtn);
		
		//add the three panels to playfield
		this.add(this.panelCreditPrize, BorderLayout.NORTH);
		this.add(this.panelSlotMachine, BorderLayout.CENTER);
		this.add(this.panelStartStopBtn, BorderLayout.SOUTH);
	}
	
	public void startRolling(){
		this.game.startRollen();
	}
	
	public void printRollingNumerics(){
		this.numerics = this.game.getZiffern();
		System.out.println("numerics: " +  numerics[0] + numerics[1] + numerics[2] + numerics[3] );

		for(int i = 0; i < 4; i++){
			this.automat[i].setText(Integer.toString(numerics[i]));
		}
	}
	
	
}
