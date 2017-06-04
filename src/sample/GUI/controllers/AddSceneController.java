package sample.GUI.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import sample.veiculos.Carro;
import sample.veiculos.Veiculo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Gabriel on 03/06/2017.
 */
public class AddSceneController extends BasicController {


    @FXML
    private ChoiceBox marca;

    @FXML
    private TextField numeroPlaca;

    @FXML
    private TextField valorVeiculo;

    @FXML
    private DatePicker anoFabricado;

    @FXML
    public void salvarVeiculo(ActionEvent actionEvent) {
        Veiculo veiculo = new Carro();

        setAnoFabricado(veiculo);
        setValor(veiculo);

        goBack();
    }

    private boolean setValor(Veiculo veiculo){
        boolean success = false;
        try{
            String texto = valorVeiculo.getText();
            Long valor =  Long.parseLong(texto);
            veiculo.setValorDoVeiculo(valor);

            success = true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return success;
    }

    /**
     * @param veiculo instancia do veiculo para colocar a data
     * @return se conseguiu colocar ou nao a data de fabricacao no veiculo
     */
    private boolean setAnoFabricado(Veiculo veiculo){
        boolean success = false;
        try{
            String str = anoFabricado.getEditor().getText();
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date startDate = formatter.parse(str);
            Calendar c = new GregorianCalendar();
            c.setTime(startDate);
            veiculo.setAnoFabricacao(c);
            success = true;

        } catch (Exception e){
            e.printStackTrace();
        }

        return success;
    }
}
