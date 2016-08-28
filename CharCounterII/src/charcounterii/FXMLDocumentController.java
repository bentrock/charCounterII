/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charcounterii;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

/**
 *
 * @author bendev
 */
public class FXMLDocumentController implements Initializable {

   private static int [] data = new int [26];
    
    static void getChars(int[] charCount) {
      
        data=charCount;
    }
    
    @FXML
    private Label label;
    @FXML
    private BarChart<?, ?> barChart;
    
   
    public void initialize(URL url, ResourceBundle rb) {
         //barChart.setTitle ("I am a bar chart");
       XYChart.Series series = new XYChart.Series();
        series.setName("letters");       
        String letter ="";
        int occurance =0;
        for(int i=0; i<data.length;i++){
             letter=Character.toString((char) (i+65));
             occurance = data[i];
            series.getData().add(new XYChart.Data(letter, occurance));
        }
       
         barChart.getData().addAll(series);
        
        
        
        
         
      
    }    

    
    
}
