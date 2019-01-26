/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebajavafx;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;///Importo lo del Calendario

/**
 *
 * @author Cerberus27
 */
public class SampleController implements Initializable {
ObservableList list=FXCollections.observableArrayList();
    @FXML private TextField tfNombre;
    @FXML private TextField tfApellido;
    @FXML private TextField tfDatos;
    @FXML private DatePicker date;
    @FXML private ChoiceBox genero;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try{
            System.out.println("Mostrando el Contenido");
            String nombre = tfNombre.getText();
            String apellido = tfApellido.getText();
            LocalDate fecha = date.getValue();
            String fecha2 = fecha.toString();
            String genero2 = (String) genero.getValue();
            
            if(tfNombre.getText().isEmpty()){
                tfDatos.setText("Le falto ingresar el nombre");
            }else if(tfApellido.getText().isEmpty()){
                tfDatos.setText("Le falto ingresar el apellido");
            }else if(genero2==null){
                tfDatos.setText("Le falto ingresar el genero");
            }else{
                tfDatos.setText("Nombre: "+nombre+" | "+"Apellido: "+apellido+" | "+"Fecha Nacimiento: "+fecha2+" | "+"Genero: "+genero2);
                System.out.println("=>"+nombre);
            }
        }catch(NullPointerException n){
            tfDatos.setText("Dejo un campo en blanco, por favor ingrese los datos correctamente.");
            System.err.println("Se produjo una exepcion del tipo"+n);
        }catch(RuntimeException p){
            tfDatos.setText("Dejo un campo en blanco, por favor ingrese los datos correctamente.");
            System.err.println("Se produjo una exepcion del tipo"+p);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadData();
    }
    
    private void LoadData(){
        list.removeAll(list);
        String a="Masculino";
        String b="Femenino";
        list.addAll(a,b);
        genero.getItems().addAll(list);
    }
}