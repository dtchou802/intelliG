package intelliGreen;

import java.util.ArrayList;

public class HardwareModule {

	/*
	 * This class simulates hardware systems that adjust the greenhouse environment
	 * to user selected values.
	 * 
	 */

	private ArrayList<Integer> current = new ArrayList<>();
	private ArrayList<Integer> desired = new ArrayList<>();


	private boolean airOn;
	private boolean humidifierOn;
	private boolean lightsOn;
	private boolean ventOn;
	private boolean irrigationOn;
	private boolean CO2releaseOn;

	private enum AirCond {
		HEATING, COOLING, OFF
	};

	private AirCond cond;

	public HardwareModule() {

	}

	public HardwareModule(ArrayList<Integer> current, ArrayList<Integer> desired) {
		this.setCurrent(current);
		this.setDesired(desired);
	}

	public void checkAir(int currentTemp, int desiredTemp) {
		if (currentTemp < desiredTemp) {
			setCond(AirCond.HEATING);
			setAirOn(true);
		} else if (currentTemp > desiredTemp) {
			setCond(AirCond.COOLING);
			setAirOn(true);
		} else {
			setCond(AirCond.OFF);
			setAirOn(false);
		}
		// TODO: should this method return an int value for the incremented/decremented
		// temperature?
	}

	public void checkHumidity(int currentHumid, int desiredHumid) {
		if (currentHumid < desiredHumid) {
			setHumidifierOn(true);
		} else if (currentHumid > desiredHumid) {
			setVentOn(true);
			setHumidifierOn(false);
		} else {
			setVentOn(false);
			setHumidifierOn(false);
		}

	}

	public boolean isHumidifierOn() {
		return humidifierOn;
	}

	public void setHumidifierOn(boolean humidifierOn) {
		this.humidifierOn = humidifierOn;
	}

	//TODO: track hours
	public boolean isLightsOn() {
		return lightsOn;
	}

	public void setLightsOn(boolean lightsOn) {
		this.lightsOn = lightsOn;
	}

	public boolean isVentOn() {
		return ventOn;
	}

	public void setVentOn(boolean ventOn) {
		this.ventOn = ventOn;
	}

	public void checkMoisture(int currentMoisture, int desiredMoisture) {
		if (currentMoisture < desiredMoisture) {
			setIrrigationOn(true);
		} else {
			setIrrigationOn(false);
		}
	}

	public boolean isIrrigationOn() {
		return irrigationOn;
	}

	public void setIrrigationOn(boolean irrigationOn) {
		this.irrigationOn = irrigationOn;
	}
	
	public void checkCO2(int currentCO2, int desiredCO2) {
		if (currentCO2 < desiredCO2) {
			setCO2releaseOn(true);
		} else if (currentCO2 > desiredCO2) {
			setVentOn(true);
			setCO2releaseOn(false);
		}else {
			setCO2releaseOn(false);
			setVentOn(false);
		}
	}

	public boolean isCO2releaseOn() {
		return CO2releaseOn;
	}

	public void setCO2releaseOn(boolean cO2releaseOn) {
		CO2releaseOn = cO2releaseOn;
	}

	public AirCond getCond() {
		return cond;
	}

	public void setCond(AirCond cond) {
		this.cond = cond;
	}

	public boolean isAirOn() {
		return airOn;
	}

	public void setAirOn(boolean airOn) {
		this.airOn = airOn;
	}

	public ArrayList<Integer> getCurrent() {
		return current;
	}

	public void setCurrent(ArrayList<Integer> current) {
		this.current = current;
	}

	public ArrayList<Integer> getDesired() {
		return desired;
	}

	public void setDesired(ArrayList<Integer> desired) {
		this.desired = desired;
	}

}
