package climates.measurements;

public class RadiationAbsorbtion extends ClimateMeasurement {
	
	public enum RadiationIntensity {
		LOW,
		MEDIUM,
		HIGH
	}
	
	private RadiationIntensity radiationIntensity;
	private double unitAbsorbtionValue;
	
	public RadiationAbsorbtion(int year, String month) {
		super(year, month);
		// gives values between (5, 20)
		unitAbsorbtionValue = Math.random()*15+5;
		int index = (int)Math.floor(Math.random()*3);
		radiationIntensity = RadiationIntensity.values()[index];
	}
	
	public RadiationIntensity getRadiationIntensity() {
		return radiationIntensity;
	}

	public double getUnitAbsorbtionValue() {
		return unitAbsorbtionValue;
	}

	
}
