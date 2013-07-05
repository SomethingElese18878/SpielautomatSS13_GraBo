import model.spielautomatEvent;
import model.spielautomatListener;


public class MySpielautomatListener implements spielautomatListener {
	Playfield playfield;
	
	
	public MySpielautomatListener(Playfield _playfield) {
		this.playfield = _playfield;
	
	}

	@Override
	public void ModelChanged(spielautomatEvent arg0) {
//		this.playfield.printRollingNumerics();
		System.out.println("ModelChanged");
	}

	@Override
	public void StatusChanged(spielautomatEvent arg0) {
		System.out.println("StatusChanged");
		this.playfield.updateCreditPrize();
	}

}
