/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeviewtable;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author Slashy
 */
public class ViewentableController implements Initializable {

    
    private TreeItem rootTree;
    @FXML
    private TreeView TVlijst;    
    @FXML
    private Button BTNvoegtoe;
    @FXML
    private Button BTNchange;    
    @FXML
    private TextField TFchange;
    @FXML
    private TextField TFnaam;
    @FXML
    private TextField TFcategorie;
    @FXML
    private TextField TFsubcategorie;
    @FXML
    private TextField TFnaamklas;
    @FXML
    private TextField TFklas;
    @FXML
    private TextField TFrichting;
    @FXML
    private TableColumn TCnaam;
    @FXML
    private TableColumn TCklas;
    @FXML
    private TableColumn TCsstudierichting;
    @FXML
    private TableView<klasgenoot> TVklasgenoot;
    @FXML
    private Button BTNaddklasgenoot; 
    List<Categorie> hoofdcategorieen; 
    private ObservableList<klasgenoot> data;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hoofdcategorieen = new ArrayList<>();
        rootTree = new TreeItem(new Categorie("lekker"));
        rootTree.setExpanded(true);
        TVlijst.setRoot(rootTree);
        TVlijst.setShowRoot(false);
        TVlijst.setEditable(true);
        TCnaam.setCellValueFactory(new PropertyValueFactory<klasgenoot, String>("naam"));
        TCnaam.setCellFactory(TextFieldTableCell.forTableColumn());
        TCnaam.setOnEditCommit(
        new EventHandler<CellEditEvent<klasgenoot, String>>() {
        @Override
        public void handle(CellEditEvent<klasgenoot, String> t) {
            ((klasgenoot) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
                ).setnaam(t.getNewValue());}});
        
        TCklas.setCellValueFactory(new PropertyValueFactory<klasgenoot, String>("klas"));
        TCklas.setCellFactory(TextFieldTableCell.forTableColumn());
        TCklas.setOnEditCommit(
        new EventHandler<CellEditEvent<klasgenoot, String>>() {
        @Override
        public void handle(CellEditEvent<klasgenoot, String> t) {
            ((klasgenoot) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
                ).setklas(t.getNewValue());}});
        TCsstudierichting.setCellValueFactory(new PropertyValueFactory<klasgenoot, String>("richting"));
        TCsstudierichting.setCellFactory(TextFieldTableCell.forTableColumn());
        TCsstudierichting.setOnEditCommit(
        new EventHandler<CellEditEvent<klasgenoot, String>>() {
        @Override
        public void handle(CellEditEvent<klasgenoot, String> t) {
            ((klasgenoot) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
                ).setrichting(t.getNewValue());}});
        data = FXCollections.observableArrayList();
        TVklasgenoot.setItems(data);               
    }    
    
    @FXML
    public void maaketen()
    {
        Food food;
        if(!(TFnaam.getText().isEmpty() && TFcategorie.getText().isEmpty()))
        {
            Categorie cato = new Categorie(TFcategorie.getText());
            hoofdcategorieen.add(cato);
            if(!TFsubcategorie.getText().isEmpty())
            {
                Categorie subcato = new Categorie(TFsubcategorie.getText());
                cato.addCategorie(subcato);
                food = new Food(TFnaam.getText());
                subcato.addfood(food);                
            }
            else
            {
               food = new Food(TFnaam.getText());
               cato.addfood(food);                
            }
            
            
            TreeItem categorie = new TreeItem(cato);
            if(cato.getCategorie().size() !=  0)
            {
                for(Categorie cat : cato.getCategorie())
                {
                    TreeItem subcategorie = new TreeItem(cato);
                    TreeItem eten = new TreeItem(food);
                    subcategorie.getChildren().add(eten);
                    categorie.getChildren().add(subcategorie);
                    
                }    
            }
            else
            {                
                TreeItem eten = new TreeItem(food);
                categorie.getChildren().add(eten);
            }
            rootTree.getChildren().add(categorie);            
        }        
    }
    
    @FXML
    public void verandereten()
    {           
        try
        {
            TreeItem<Categorie> changeCategorie = (TreeItem<Categorie>)TVlijst.getSelectionModel().getSelectedItem();
            changeCategorie.getValue().setName(TFchange.getText());
            TreeItem<Categorie> random = new TreeItem<Categorie>();
            rootTree.getChildren().add(random);
            rootTree.getChildren().remove(random);
        }
        catch(Exception e)
        {
            TreeItem<Food> changeeten = (TreeItem<Food>)TVlijst.getSelectionModel().getSelectedItem();
            changeeten.getValue().setName(TFchange.getText());
            TreeItem<Food> random = new TreeItem<Food>();
            rootTree.getChildren().add(random);
            rootTree.getChildren().remove(random);
        }
        
        
    }
    
    @FXML
    public void maakklasgenoot()
    {        
        data.add(new klasgenoot(TFnaamklas.getText(), TFklas.getText(), TFrichting.getText()));
    }
}
