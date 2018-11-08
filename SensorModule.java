package intelliGreen;

import java.util.Random;

public class SensorModule {

	/*
	 * This class simulates sensor readings by generating a random value for normal
	 * ranges in real life. Its purpose is to retrieve values from real sensors to
	 * monitor the greenhouse environment
	 * 
	 * temperature: 20 to 100 degrees Fahrenheit humidity: 0% to 100% moisture: 0%
	 * to 100% pH: 4 to 8 carbon dioxide: 0 to 2,000ppm 
	 * 
	 * TODO: verify that values fall in a probabilistic range, especially for moisture 
	 * and CO2
	 */

	private int temperature;
	private int humidity;
	private int moisture;
	private int pH;
	private int CO2;

	private Random random = new Random();

	public SensorModule() {

	}

	public int getTemperature() {
		return temperature;
	}

	/*
	 * temperatures are assumed to range between 20 and 100 degrees Fahrenheit.
	 * Random generates a number between 0 and the given upper bound, and since we
	 * don't want values to start at 0, we add 20. Then our upper bound is 100 - 20
	 * = 80.
	 */
	public int generateTemperature() {
		temperature = random.nextInt(80) + 20;
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public int generateHumidity() {
		humidity = random.nextInt(100);
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getMoisture() {
		return moisture;
	}

	public int generateMoisture() {
		moisture = random.nextInt(100);
		return moisture;
	}

	public void setMoisture(int moisture) {
		this.moisture = moisture;
	}

	public int getPH() {
		return pH;
	}

	/*
	 * pH levels in soil are assumed to range between 4 and 8. Random generates a
	 * number between 0 and the given upper bound, and since we don't want values to
	 * start at 0, we add 4. Then our upper bound is 8 - 4 = 4.
	 */
	public int generatePH() {
		pH = 7;
		return pH;
	}

	public void setPH(int pH) {
		this.pH = pH;
	}

	public int getCO2() {
		return CO2;
	}

	public int generateCO2() {
		CO2 = random.nextInt(2000);
		return CO2;
	}

	public void setCO2(int cO2) {
		CO2 = cO2;
	}

}
