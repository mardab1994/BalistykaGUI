package kontrolery;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import pociski.PociskPneumatyczny;
import pociski.PociskProchowy;
import symulacjaLotu.symulacja;

public class mainWindowController {
	public mainWindowController() {
		
	}
	
	@FXML private TextField getMasa = new TextField();
	@FXML private TextField getVo=new TextField();
	@FXML private TextField getAngle=new TextField();
	
	@FXML private NumberAxis osX;
	@FXML private NumberAxis osY;
	@FXML LineChart<Double,Double > wykres;
	
	
	/*
*Wywo³ana zaraz po konstruktorze, gwarantuje, ¿e wstrzykniete elementy 
	 * zostan¹ zainicjalizowane*/
	@FXML
	void initialize() {}
	
	@FXML
	public void buttonModelG1() {
		double masa=Double.parseDouble(getMasa.getText());
		double predkoscPoczatkowa=Double.parseDouble(getVo.getText());
		double katWystrzalu=Double.parseDouble(getAngle.getText());

		PociskPneumatyczny p1=new PociskPneumatyczny(masa,predkoscPoczatkowa);
		symulacja s1=new symulacja(p1,katWystrzalu);
		wykres.getData().clear();
		
		XYChart.Series<Double, Double> series = new XYChart.Series<Double,Double>();
		double x=0;
		double y=0;
		s1.start();
		do {
			series.getData().add(new XYChart.Data<Double,Double>(x,y));
			x++;
			y=s1.lot(x);
		}while(y>=0);
		series.setName("Model G1");
		wykres.getData().add(series);
	}
	
	public void buttonModelG2() {
		double masa=Double.parseDouble(getMasa.getText());
		double predkoscPoczatkowa=Double.parseDouble(getVo.getText());
		double katWystrzalu=Double.parseDouble(getAngle.getText());
		
		PociskProchowy p2=new PociskProchowy(masa,predkoscPoczatkowa);
		symulacja s1=new symulacja(p2,katWystrzalu);
	//	wykres.getData().clear();
		
		XYChart.Series<Double, Double> series = new XYChart.Series<Double,Double>();
		double x=0;
		double y=0;
		s1.start();
		do {
			series.getData().add(new XYChart.Data<Double,Double>(x,y));
			x++;
			y=s1.lot(x);
		}while(y>=0);
		
		series.setName("Model G2");
		wykres.getData().add(series);	
	}
}

