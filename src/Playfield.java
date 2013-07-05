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
	JLabel lblCredit, lblPrize;
	JTextField tfCreditText, tfPrizeText;
	JButton btnStart, btnStop;
	JLabel[] lblAutomat = new JLabel[4]; 
	
	spielautomat game;
	Integer[] numerics;
	RollingNumericsThread rollingNumericsThread;

	Playfield(){
		this.game = spielautomat.getInstance();
		this.game.addspielListener( new MySpielautomatListener(this) );
		
		this.panelCreditPrize = new JPanel();
		this.panelSlotMachine = new JPanel();
		this.panelStartStopBtn = new JPanel();
		
		this.setLayout( new BorderLayout() );
		
		//First Panel - Credits, Prize
		this.panelCreditPrize.setLayout( new GridLayout(2,2) );
		
		this.lblCredit = new JLabel("Credit");
		this.lblPrize = new JLabel("Prize");
		
		this.tfCreditText = new JTextField("100");
		this.tfCreditText.setFont( new Font("Arial", Font.PLAIN ,20));
		this.tfPrizeText = new JTextField("0");
		this.tfPrizeText.setFont( new Font("Arial", Font.PLAIN ,20));
		
		this.panelCreditPrize.add(this.lblCredit);
		this.panelCreditPrize.add(this.lblPrize);
		this.panelCreditPrize.add(this.tfCreditText);
		this.panelCreditPrize.add(this.tfPrizeText);
		
		//Second Panel - slot machine
		this.panelSlotMachine.setLayout( new GridBagLayout() );
		this.numerics = this.game.getZiffern();
		
		for(int i = 0; i < 4; i++){
			lblAutomat[i] = new JLabel(this.numerics[i].toString(), JLabel.CENTER);
			lblAutomat[i].setPreferredSize( new Dimension(50, 50) );
			lblAutomat[i].setFont( new Font("Arial", Font.PLAIN, 28));
			lblAutomat[i].setBorder( new LineBorder(Color.RED, 3) );

			this.panelSlotMachine.add(lblAutomat[i]);
		}
		
		//Third Panel - start/stop buttons
		this.btnStart = new JButton("start");
		this.btnStop = new JButton("stop");
		this.btnStart.addActionListener( new ButtonListener(this) );
		this.btnStop.addActionListener( new ButtonListener(this) );
		
		this.panelStartStopBtn.add(this.btnStart);
		this.panelStartStopBtn.add(this.btnStop);
		
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
			this.lblAutomat[i].setText(Integer.toString(numerics[i]));
		}
	}
	
	public void updateCreditPrize(){
		this.tfCreditText.setText( Integer.toString( this.game.getGuthaben() ) );
		this.tfPrizeText.setText( Integer.toString( this.game.getGewinn() ) );
	}
	
	
}
