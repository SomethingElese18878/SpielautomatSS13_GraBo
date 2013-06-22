import model.spielautomatEvent;
import model.spielautomatListener;


public class SlotMachineListener implements spielautomatListener {
	Playfield playfield;
	
	
	public SlotMachineListener(Playfield _playfield) {
		this.playfield = _playfield;
	
	}

	@Override
	public void ModelChanged(spielautomatEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void StatusChanged(spielautomatEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
