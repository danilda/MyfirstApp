package sample;

import com.jfoenix.controls.JFXComboBox;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import science.*;


public class Main extends Application {
    @FXML
    JFXComboBox matrix;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 600, 275);
        scene.getStylesheets().add(0, "sample/my.css");

        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(610);
        primaryStage.setScene(scene);
        primaryStage.show();
        DataMatrix.readFile();

        JFXComboBox comboBox = (JFXComboBox) scene.lookup("#choiceBoxMatrix");
        String[] matrixArr = new String[DataMatrix.getLastId()+1];
        for(int i = 0; i < DataMatrix.getLastId()+1; i++) {
            matrixArr[i] =  DataMatrix.getArrayList(i).getName();
        }
        comboBox.setItems(FXCollections.observableArrayList(matrixArr));

        DataKryg.readFile();
        JFXComboBox comboBox2 = (JFXComboBox) scene.lookup("#choiceBoxMatrix2");
        String[] matrixArr2 = new String[DataKryg.getLastId()+1];
        for(int i = 0; i < DataKryg.getLastId()+1; i++) {
            matrixArr2[i] =  DataKryg.getArrayList(i).getName();
        }
        comboBox2.setItems(FXCollections.observableArrayList(matrixArr2));

        DataVolokno.readFile();
        JFXComboBox comboBox3 = (JFXComboBox) scene.lookup("#choiceBoxMatrix3");
        String[] matrixArr3 = new String[DataVolokno.getLastId()+1];
        for(int i = 0; i < DataVolokno.getLastId()+1; i++) {
            matrixArr3[i] =  DataVolokno.getArrayList(i).getName();
        }
        comboBox3.setItems(FXCollections.observableArrayList(matrixArr3));

//        ChoiseElement.setMatrix(new Matrix( 6, "matrixXXX", 410000000));
//        ChoiseElement.setVolokno(new Volokno( 6, "VoloknoXXX", 35000000000.0, 0.12 , 0.001));
//        ChoiseElement.setKryg(new Kryg( 6, "KrygXXX", 500000000));

//        Matrix matrix = new Matrix();
//        Volokno volokno = new Volokno();
//        Kryg kryg = new Kryg();
//        Value value = new Value();


//        DataMatrix.addNewItems("Matrix4", 490 );
//        DataMatrix.readFile();
//        String[] matrixArr3 = new String[DataMatrix.getLastId()+1];
//        for(int i = 0; i < DataMatrix.getLastId()+1; i++) {
//            matrixArr3[i] =  DataMatrix.getArrayList(i).getName();
//        }
//        comboBox.setItems(FXCollections.observableArrayList(matrixArr3));
//
//        DataKryg.addNewItems("Koks4", 490 );
//        DataKryg.readFile();
//        JFXComboBox comboBox4 = (JFXComboBox) scene.lookup("#choiceBoxMatrix2");
//        String[] matrixArr4 = new String[DataMatrix.getLastId()+1];
//        for(int i = 0; i < DataKryg.getLastId()+1; i++) {
//            matrixArr4[i] =  DataKryg.getArrayList(i).getName();
//        }
//        comboBox4.setItems(FXCollections.observableArrayList(matrixArr4));
//
//        DataVolokno.addNewItems("Koks4", 490, 33, 22 );
//        DataVolokno.readFile();
//        JFXComboBox comboBox4 = (JFXComboBox) scene.lookup("#choiceBoxMatrix3");
//        String[] matrixArr4 = new String[DataVolokno.getLastId()+1];
//        for(int i = 0; i < DataVolokno.getLastId()+1; i++) {
//            matrixArr4[i] =  DataVolokno.getArrayList(i).getName();
//        }
//        comboBox4.setItems(FXCollections.observableArrayList(matrixArr4));


    }


    public static void main(String[] args) {
        launch(args);
    }
}
