package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    public TextArea showid;
    private List<String> data = new ArrayList<>();
    public void chose(ActionEvent actionEvent) {
        fileAdapter fileAdapter = new fileAdapter();
        data = fileAdapter.fileRead();
    }

    public void search(ActionEvent actionEvent) {
        System.out.println(data);
        mapCount map = new mapCount(data);
        map.countData();
//        for (String key : dataMap.keySet()){
//            showid.appendText(key+" : "+dataMap.get(key)+"\n");
//        }
    }
}
