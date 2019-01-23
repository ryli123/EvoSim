package Ecosystem;

public class Raptor extends Bird implements Carnivore{
	private int talonSize, beakStrength;
	
	public Raptor(String imageName, int size, int speed, int lifespan, String gender, boolean flight, boolean aquatic) {
		super(imageName, size, speed, lifespan, gender, flight, aquatic);
		talonSize = 30;
		beakStrength = 40;
	}
	
	public Raptor(Raptor raptor) {
		super (raptor);
	}
	
	public Raptor(Raptor raptor, boolean canMate) {
		super(raptor, canMate);
	}

	public Animal mate(Animal mate) {
		if (this.canMate(mate))
			return new Raptor(this, this.canMate(mate));
		return null;	
	}
	
	public void encircle(){
		
	}
	
	public void chase(Animal prey){
		
	}
	
	public void feed(Animal prey){
		
	}
}
