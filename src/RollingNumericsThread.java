import model.spielautomat;


public class RollingNumericsThread extends Thread {
	
	Playfield playfield;
	spielautomat game;
	
	public RollingNumericsThread(Playfield _playfield){
		this.playfield = _playfield;
		this.game = spielautomat.getInstance();
		
	}
	
	public void run(){
		
		this.playfield.startRolling();
		
		while(true){
			this.playfield.numerics = this.game.getZiffern();
//			System.out.println("THREADnumerics: " +  playfield.numerics[0] + playfield.numerics[1] + playfield.numerics[2] + playfield.numerics[3] );

			for(int i = 0; i < 4; i++){
				this.playfield.automat[i].setText(Integer.toString(playfield.numerics[i]));
			}
		}

	}

}
