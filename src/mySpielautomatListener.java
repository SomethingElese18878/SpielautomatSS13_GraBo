import model.spielautomatEvent;
import model.spielautomatListener;


public class mySpielautomatListener implements spielautomatListener {
	Playfield playfield;
	
	
	public mySpielautomatListener(Playfield _playfield) {
		this.playfield = _playfield;
	
	}

	@Override
	public void ModelChanged(spielautomatEvent arg0) {
		// TODO Auto-generated method stub
		this.playfield.printRollingNumerics();
		System.out.println("ModelChanged");
	}

	@Override
	public void StatusChanged(spielautomatEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("StatusChanged");
	}

}
