package com.internshala.helllofx;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Mymain extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }

    @Override
    public void start(Stage stage) throws IOException   {
        System.out.println("Start");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hj.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar=createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);

        stage.setScene(scene);
        stage.setTitle("Heergfegvervbergberberlfewe");
        stage.show();
    }
    private MenuBar createMenu(){
        Menu filemenu =new Menu("file"); //file menu
        MenuItem newmenuItem=new MenuItem("New");
        newmenuItem.setOnAction(actionEvent -> {
            System.out.println("New menu item clicked");
        });

        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();

        MenuItem quitmenuItem=new MenuItem("Quit");
        quitmenuItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });

        filemenu.getItems().addAll(newmenuItem,separatorMenuItem,quitmenuItem);

        Menu helpmenu=new Menu("Help"); //Help menu
        MenuItem aboutApp=new MenuItem("About");

        aboutApp.setOnAction(actionEvent -> aboutApp());

        helpmenu.getItems().addAll(aboutApp);

        MenuBar menuBar=new MenuBar();//menu bar
        menuBar.getMenus().addAll(filemenu,helpmenu);
        return menuBar;
    }

    private void aboutApp() {
        Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My first project");
        alertDialog.setHeaderText("learning javaFX");
        alertDialog.setContentText("helllllllllllllllllllllllll start game program bigner");

        ButtonType yesbtn=new ButtonType("yes");
        ButtonType nobtn=new ButtonType("No");

        alertDialog.getButtonTypes().setAll(yesbtn,nobtn);

        Optional<ButtonType> clickbutton=alertDialog.showAndWait();
        if(clickbutton.get()== yesbtn){
            System.out.println("grg");
        }
        if(clickbutton.get()==nobtn){
            System.out.println("noooooooo");
        }
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stop");
        super.stop();
    }
}
