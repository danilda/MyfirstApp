package sample;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import science.*;

public class Controller {
    @FXML
    JFXComboBox<String>choiceBoxMatrix;
    @FXML
    JFXComboBox<String>choiceBoxMatrix2;
    @FXML
    JFXComboBox<String>choiceBoxMatrix3;
    @FXML
    JFXComboBox<String> matrix;
    @FXML
    Label em;
    @FXML
    Label ef;
    @FXML
    Label l;
    @FXML
    Label d;
    @FXML
    Label es;


    @FXML
    public void showDialog(ActionEvent actionEvent) throws Exception {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("edit.fxml"));
            stage.setTitle("Hello World");
            stage.setMinHeight(600);
            stage.setMinWidth(610);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (Exception e){
            throw new Exception("Ошибка в showDialog");
        }

    }
    public void comboBox(ActionEvent actionEvent){
        String n = choiceBoxMatrix.getValue();
        Matrix tmp =  DataMatrix.findElement(n);
        if(tmp != null){
            em.setText(new Double(tmp.getEm()).toString());
        } else
        System.out.println("выбранная матрица не найдена");
        ChoiseElement.setMatrix(tmp);
    }
    public void comboBox2(ActionEvent actionEvent){
        String n = choiceBoxMatrix2.getValue();
        Kryg tmp =  DataKryg.findElement(n);
        if(tmp != null){
            es.setText(new Double(tmp.getEs()).toString());
        } else
            System.out.println("выбранное дисперсное влючение не найдено");
        ChoiseElement.setKryg(tmp);
    }
    public void comboBox3(ActionEvent actionEvent){
        String n = choiceBoxMatrix3.getValue();
        Volokno tmp =  DataVolokno.findElement(n);
        if(tmp != null){
            ef.setText(new Double(tmp.getEf()).toString());
            l.setText(new Double(tmp.getL()).toString());
            d.setText(new Double(tmp.getD()).toString());
        } else
            System.out.println("выбранное волокно не найдено");
        ChoiseElement.setVolokno(tmp);
    }





//            (new ItemListener() {
//        @Override
//        public void itemStateChanged(ItemEvent e) {
//            // здесь ваш код если вы выбрали один из пунктов
//        }
//    });


}
