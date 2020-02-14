/*
 * This file creates the GUI
 * @author StrangeQuark
 * @version 0.001
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.SplitPane.Divider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ZIDEGui extends Application
{
  @Override
  public void start(Stage primaryStage) throws Exception
  {
    primaryStage.setTitle("zIDE");
    GuiMenuBar menuBar = new GuiMenuBar();
    FileList fileList = new FileList();
    TextEditor textEditor = new TextEditor();
    OutputArea outputArea = new OutputArea();
    GuiToolBar toolBar = new GuiToolBar();
    BorderPane layout = new BorderPane();
    VBox vBox = new VBox(menuBar.getMenuBar(), toolBar.getToolBar());
    
    SplitPane splitPane = new SplitPane(fileList.getFileList(), textEditor.getTextArea());
    SplitPane splitPane2 = new SplitPane(splitPane, outputArea.getOutputArea());
    splitPane2.setOrientation(Orientation.VERTICAL);
    
    layout.setTop(vBox);
    layout.setLeft(fileList.getFileList());
    layout.setCenter(splitPane2);
    
    Scene scene = new Scene(layout, 450, 450);
    
    primaryStage.setScene(scene);
    primaryStage.show();
    primaryStage.setAlwaysOnTop(true);
    primaryStage.setAlwaysOnTop(false);
    primaryStage.setMaximized(true);
    
    splitPane.setDividerPositions(0.1);
    splitPane2.setDividerPositions(0.8);
  }
  
  public static void main(String[] args)
  {
    launch(args);
  }
}