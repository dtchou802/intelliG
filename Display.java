package intelliGreen;

import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class Display extends FlowPane {

	/*
	 * This class creates the user Display using JavaFX
	 */
	Label lbl_currentHeading = new Label("Sensor Values");
	Label lbl_temperature = new Label();
	Label lbl_humidity = new Label();
	Label lbl_moisture = new Label();
	Label lbl_PH = new Label();
	Label lbl_CO2 = new Label();
	VBox vbox_sensorValues = new VBox();

	Label lbl_desiredHeading = new Label("Desired Values");
	Label lbl_desiredTemp = new Label();
	Label lbl_desiredHumid = new Label();
	Label lbl_desiredMoist = new Label();
	Label lbl_desiredPH = new Label();
	Label lbl_desiredCO2 = new Label();
	VBox vbox_desiredValues = new VBox();
	
	//TODO: Implement status of lights
	Label lbl_hardwareHeading = new Label("Hardware Statuses");
	Label lbl_AirCond = new Label();
	Label lbl_Humidifier = new Label();
	Label lbl_Irrigation = new Label();
	Label lbl_Ventilator = new Label();
	Label lbl_CO2release = new Label();
	VBox vbox_hardwareStatus = new VBox();

	public Display() {
		setPadding(new Insets(10, 20, 20, 20));
		vbox_sensorValues.getChildren().addAll(lbl_currentHeading, lbl_temperature, lbl_humidity, lbl_moisture, lbl_PH, lbl_CO2);
		getChildren().add(vbox_sensorValues);
		setHgap(100);
		vbox_desiredValues.getChildren().addAll(lbl_desiredHeading, lbl_desiredTemp, lbl_desiredHumid, lbl_desiredMoist, lbl_desiredPH,
				lbl_desiredCO2);
		getChildren().add(vbox_desiredValues);
		vbox_hardwareStatus.getChildren().addAll(lbl_hardwareHeading, lbl_AirCond, lbl_Humidifier, lbl_Irrigation, lbl_Ventilator,
				lbl_CO2release);
		getChildren().add(vbox_hardwareStatus);
	}

	// Sensor Labels
	public Label getLbl_temperature() {
		return lbl_temperature;
	}

	public void setLbl_temperature(int temp) {
		lbl_temperature.setText("Temperature: " + temp + " deg F");
	}

	public Label getLbl_humidity() {
		return lbl_humidity;
	}

	public void setLbl_humidity(int humidity) {
		lbl_humidity.setText("Humidity: " + humidity + "%");
	}

	public Label getLbl_moisture() {
		return lbl_moisture;
	}

	public void setLbl_moisture(int moisture) {
		lbl_moisture.setText("Soil Moisture: " + moisture + "%");
	}

	public Label getLbl_PH() {
		return lbl_PH;
	}

	public void setLbl_PH(int ph) {
		lbl_PH.setText("Soil PH: " + ph);
	}

	public Label getLbl_CO2() {
		return lbl_CO2;
	}

	public void setLbl_CO2(int CO2) {
		lbl_CO2.setText("CO2: " + CO2 + "ppm");
	}

	// Desired Labels
	public Label getLbl_desiredTemp() {
		return lbl_desiredTemp;
	}

	public void setLbl_desiredTemp(int desiredTemp) {
		lbl_desiredTemp.setText(desiredTemp + " deg F");
	}

	public Label getLbl_desiredHumid() {
		return lbl_desiredHumid;
	}

	public void setLbl_desiredHumid(int desiredHumid) {
		lbl_desiredHumid.setText(desiredHumid + "%");
	}

	public Label getLbl_desiredMoist() {
		return lbl_desiredMoist;
	}

	public void setLbl_desiredMoisture(int desiredMoist) {
		lbl_desiredMoist.setText(desiredMoist + "%");
	}

	public Label getLbl_desiredPH() {
		return lbl_desiredPH;
	}

	public void setLbl_desiredPH(int desiredph) {
		lbl_desiredPH.setText(Integer.toString(desiredph));
	}

	public Label getLbl_desiredCO2() {
		return lbl_desiredCO2;
	}

	public void setLbl_desiredCO2(int desiredCO2) {
		lbl_desiredCO2.setText(desiredCO2 + "ppm");
	}

	// Hardware Labels
	public void setLbl_AirCond(String string) {
		lbl_AirCond.setText(string);
	}

	public void setLbl_Humidifier(String s) {
		lbl_Humidifier.setText(s);
	}

	public void setLbl_Irrigation(String s) {
		lbl_Irrigation.setText(s);
	}

	public void setLbl_Ventilator(String s) {
		lbl_Ventilator.setText(s);
	}

	public void setLbl_CO2release(String s) {
		lbl_CO2release.setText(s);
	}

}
