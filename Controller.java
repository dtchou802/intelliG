package intelliGreen;

import java.time.ZonedDateTime;
import java.util.ArrayList;

import eu.hansolo.colors.MaterialDesign;
import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.GaugeBuilder;
import javafx.animation.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.*;
import javafx.event.*;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.beans.property.SimpleIntegerProperty;


public class Controller extends Application {

	static ArrayList<Integer> current = new ArrayList<>();
	static ArrayList<Integer> desired = new ArrayList<>();
	static DoubleProperty temp = new SimpleDoubleProperty(90);
	static IntegerProperty humid = new SimpleIntegerProperty(45);
	static IntegerProperty moist = new SimpleIntegerProperty(50);
	static IntegerProperty co2 = new SimpleIntegerProperty(1124);


	static SensorModule simulator = new SensorModule();
	HardwareModule hardware = new HardwareModule();
	Display display = new Display();


	static ZonedDateTime time = ZonedDateTime.now();
	static int lastSeconds = time.getSecond();

	public static void main(String[] args) throws InterruptedException {
		current.add(0, simulator.generateTemperature());
		current.add(1, simulator.generateHumidity());
		current.add(2, simulator.generateMoisture());
		current.add(3, simulator.generatePH());
		current.add(4, simulator.generateCO2());

		// TODO: Collect these at the beginning with display
		desired.add(0, 70);
		desired.add(1, 50);
		desired.add(2, 65);
		desired.add(3, 7);
		desired.add(4, 1500);
		Controller.launch(args);


	}

	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		// TODO: at startup ask for desired values, save them to 'desired' ArrayList
		primaryStage.setTitle("IntelliGarden");
		Scene mainScene = new Scene(display, 1000, 500);
		primaryStage.setScene(mainScene);
		primaryStage.show();

//		temp.setValue( simulator.generateTemperature());
//		humid.setValue( simulator.generateHumidity());
//		moist.setValue( simulator.generateMoisture());
//		current.set(3, simulator.generatePH());
//		co2.set(simulator.generateCO2());

		display.tempG.valueProperty().bind(temp);
		display.humidG.valueProperty().bind(humid);
		display.moistG.valueProperty().bind(moist);
		display.co2G.valueProperty().bind(co2);


		display.setLbl_humidity(humid.get());
		display.lbl_humidity.textProperty().bind(Bindings.concat("Humidity: ", humid.asString(),"%"));
		display.setLbl_moisture(moist.get());
		display.lbl_moisture.textProperty().bind(Bindings.concat("Moisture: ", moist.asString(),"%"));
		display.setLbl_PH(current.get(3));

		display.setLbl_CO2(co2.get());
		display.lbl_CO2.textProperty().bind(Bindings.concat("CO2: ", co2.asString(),"PPM"));


		display.setLbl_desiredTemp(desired.get(0));
		display.setLbl_desiredHumid(desired.get(1));
		display.setLbl_desiredMoisture(desired.get(2));
		display.setLbl_desiredPH(desired.get(3));
		display.setLbl_desiredCO2(desired.get(4));


		hardware.checkAir(temp.getValue().intValue(), desired.get(0));
		hardware.checkHumidity(humid.get(), desired.get(1));
		hardware.checkMoisture(moist.get(), desired.get(2));
		hardware.checkCO2(co2.get(), desired.get(4));

//		display.setLbl_AirCond("A/C: " + hardware.getCond());
//		display.setLbl_Humidifier("Humidifier: " + ((hardware.isHumidifierOn() == true) ? "ON" : "OFF"));
		display.setLbl_Irrigation("Irrigation: " + ((hardware.isIrrigationOn() == true) ? "ON" : "OFF"));
//		display.setLbl_CO2release("CO2 release: " + ((hardware.isCO2releaseOn() == true) ? "ON" : "OFF"));
		display.setLbl_Ventilator("Ventilator: " + ((hardware.isVentOn() == true) ? "ON" : "OFF"));


		Timeline timeline = new Timeline(
				new KeyFrame(Duration.seconds(0),
						new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent actionEvent)
							{

								if(hardware.isAirOn()) {
									temp.set(temp.getValue() - 1.5);//I think you should have used an Integer here.
									hardware.checkAir(temp.getValue().intValue(),desired.get(0));
									display.setLbl_AirCond("A/C: " + hardware.getCond());

								}
								if(hardware.isHumidifierOn()) {
									humid.set(humid.getValue() + 1);//I think you should have used an Integer here.
									hardware.checkHumidity(humid.getValue(),desired.get(1));
									display.setLbl_Humidifier("Humidifier: " + ((hardware.isHumidifierOn() == true) ? "ON" : "OFF"));

								}
								if(hardware.isIrrigationOn()) {
									moist.set(moist.getValue() + 1);//I think you should have used an Integer here.
									hardware.checkMoisture(moist.getValue(),desired.get(2));
									display.setLbl_Irrigation("Irrigation: " + ((hardware.isIrrigationOn() == true) ? "ON" : "OFF"));

								}
								if(hardware.isCO2releaseOn()) {
									co2.set(co2.getValue() + 35);//I think you should have used an Integer here.
									hardware.checkCO2(co2.getValue(),desired.get(4));
									display.setLbl_CO2release("CO2 release: " + ((hardware.isCO2releaseOn() == true) ? "ON" : "OFF"));

								}
							}
						}
				),
				new KeyFrame(Duration.seconds(2))//Do something every second. In this case we are going to increment setStrP.
		);
		timeline.setCycleCount(1000);//Repeat this 10 times
		timeline.play();

	}

	private static String formatTime() {
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString(time.getHour() % 12));
		sb.append(":");
		sb.append(Integer.toString(time.getMinute()));
		if (time.getHour() < 12) {
			sb.append(" AM");
		} else {
			sb.append(" PM");
		}
		return sb.toString();
	}

}
