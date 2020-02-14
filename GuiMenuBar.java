import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import java.io.File;

public class GuiMenuBar
{
  MenuBar menuBar;
  
  Menu fileMenu;
  MenuItem newFile;
  MenuItem openFile;
  MenuItem saveFile;
  MenuItem saveFileAs;
  
  File file = null;
  FileChooser fileChooser;
  
  public GuiMenuBar()
  {
    fileMenu = new Menu("File");
    menuBar = new MenuBar();
    
    newFile = new MenuItem("New");
    openFile = new MenuItem("Open...");
    saveFile = new MenuItem("Save");
    saveFileAs = new MenuItem("Save as...");
    
    //newFileAction
    newFile.setOnAction(e -> 
                        {
      OutputArea.outputArea.setText("");
      System.out.println("New file");
    });
    //openFileAction
    openFile.setOnAction(e -> 
                          {
      OutputArea.outputArea.setText("");
      fileChooser = new FileChooser();
      fileChooser.setTitle("Select source file");
      file = fileChooser.showOpenDialog(null);
      try
      {
      TextEditor.setTextFromFile(file);
      FileList.addToList(file);
      }catch(Exception ex){ex.printStackTrace();}
    });
    //saveFileAction
    saveFile.setOnAction(e -> 
                          {
      OutputArea.outputArea.setText("");
      System.out.println("Save");
      if(file == null)
      {
        saveFileAs.fire();
      }
      else
      {
        try
        {
          TextEditor.saveTextToFile(file);
        }catch(Exception ex){ex.printStackTrace();}
      }
    });
    //saveFileAsAction
    saveFileAs.setOnAction(e -> 
                          {
      OutputArea.outputArea.setText("");
      System.out.println("Save as");
      fileChooser = new FileChooser();
      fileChooser.setTitle("Save source file");
      FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("JAVA files (*.java)", "*.java");
      fileChooser.getExtensionFilters().add(extensionFilter);
      file = fileChooser.showSaveDialog(null);
      try
      {
        TextEditor.saveTextToFile(file);
      }catch(Exception ex){ex.printStackTrace();}
    });
    
    
    fileMenu.getItems().add(newFile);
    fileMenu.getItems().add(openFile);
    fileMenu.getItems().add(saveFile);
    fileMenu.getItems().add(saveFileAs);
    
    menuBar.getMenus().add(fileMenu);
  }
  
  public MenuBar getMenuBar()
  {
    return(menuBar);
  }
}