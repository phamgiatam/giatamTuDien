package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLOutput;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    DictionaryManagement dictionaryManagement = new DictionaryManagement();


    @FXML
    private Button nhan = new Button();
    @FXML
    private TextField nhap = new TextField();
    @FXML
    private TextArea out = new TextArea();
    @FXML
    private ListView<String> list = new ListView<>();
    @FXML
    private Button add = new Button();
    @FXML
    private Button fix = new Button();
    @FXML
    private Button remove = new Button();
    @FXML
    private TextField WordTarget = new TextField();
    @FXML
    private TextField WordExplain = new TextField();
    @FXML
    private TextField fixWordTarget = new TextField();
    @FXML
    private TextField fixWordExplain = new TextField();
    @FXML
    private TextField deleteWord = new TextField();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handleinput(ActionEvent e) {
        String search = nhap.getText();
        List<String> temp = dictionaryManagement.dictionarySearcher(search);
        list.getItems().clear();
        for(int i = 0 ; i < temp.size(); i++){
            list.getItems().add(temp.get(i));
        }

        //dictionaryManagement.dictionarySearcher();
        //list.getItems().add(search);

    }

    public void Add(ActionEvent e) {
        String addTarget = WordTarget.getText();
        String addExplain = WordExplain.getText();
        dictionaryManagement.dictionaryAdd(addTarget,addExplain);
        System.out.println("Add!!");
        dictionaryManagement.exportToFile();
    }

    public void Fix(ActionEvent e) {
        String fixTarget = fixWordTarget.getText();
        String fixExplain = fixWordExplain.getText();
        dictionaryManagement.dictionaryFix(fixTarget, fixExplain);
        System.out.println("Fixed!!");
        dictionaryManagement.exportToFile();
    }

    public void Delete(ActionEvent e){
        String deleteTarget = deleteWord.getText();
        dictionaryManagement.dictionaryDelete(deleteTarget);
        System.out.println("Deleted!!");
        dictionaryManagement.exportToFile();
    }


    public void print(MouseEvent e) {
        String in =list.getSelectionModel().getSelectedItem();


        out.setText(dictionaryManagement.dictionaryLookup(in));
    }
}
