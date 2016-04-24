package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import science.ChoiseElement;
import science.Value;

/**
 * Created by User on 27.03.2016.
 */

public class DialogController {
    private NumberAxis x = new NumberAxis();
    private NumberAxis y = new NumberAxis();
    @FXML
    LineChart<Number, Number> numberLineChart = new LineChart<Number, Number>(x,y);
    @FXML
    NumberAxis xAxis;
    @FXML
    JFXTextField input;
    private double k =0;
    public void showDialog2(ActionEvent actionEvent) throws Exception {
        if(input != null) {
            System.out.println("прошло проверку на нул");
            if (Double.parseDouble(input.getText()) >= 0 && Double.parseDouble(input.getText()) < 0.7) {
                k = Double.parseDouble(input.getText());
                System.out.println("input прошел проверку на нул и на коректность числа");
                System.out.println(input.getText());
            }
        }
        numberLineChart.setTitle("Упругость");
        numberLineChart.setLegendVisible(false);
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("cos(x)");
        series1.setName("sin(x)");
        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();

        //xAxis.setAutoRanging(false);
        xAxis.setTickUnit(10);

//        for(double i = 0; i < 10; i+=0.01) {
//            datas.add(new XYChart.Data<>((double)i, sin(i)));
//        }
        Value value = new Value(ChoiseElement.getMatrix(), ChoiseElement.getVolokno(), ChoiseElement.getKryg() );
        ChoiseElement.getKryg().setCs(k);
        System.out.println("Matrix" + ChoiseElement.getMatrix().getEm() + " " + ChoiseElement.getMatrix().getCm());
        System.out.println("Volokno" + ChoiseElement.getVolokno().getEf()
                + " " + ChoiseElement.getVolokno().getCf()
                + " " + ChoiseElement.getVolokno().getL()
                + " " + ChoiseElement.getVolokno().getD());
        System.out.println("Kryg" + ChoiseElement.getKryg().getEs() + " " +
                        ChoiseElement.getKryg().getCs());

        for(double i = 0 ; i < (0.7 - ChoiseElement.getKryg().getCs()); i+=0.005){
            if(i == 0)
                System.out.println("первый ответ " + value.getEIEm());
            ChoiseElement.getVolokno().setCf(i);
            datas.add(new XYChart.Data<>(i,value.getEIEm()));
//            value.logs();
        }

        series1.setData(datas);
            numberLineChart.getData().add(series1);

    }
    public void clearData(){
        if(numberLineChart!= null && numberLineChart.getData() !=null)
            numberLineChart.getData().clear();
    }
}
