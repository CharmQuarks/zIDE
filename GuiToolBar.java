import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.stage.FileChooser;
import java.io.File;

public class GuiToolBar
{
  ToolBar toolBar;
  Button newButton;
  Button openButton;
  Button saveButton;
  Button undoButton;
  Button redoButton;
  Button compileButton;
  Button runButton;
  FileChooser fileChooser;
  File file = null;
  
  public GuiToolBar()
  {
    newButton = new Button("New");
    openButton = new Button("Open");
    saveButton = new Button("Save");
    undoButton = new Button("Undo");
    redoButton = new Button("Redo");
    compileButton = new Button("Compile");
    runButton = new Button("Run");
    
    //newButtonAction
    newButton.setOnAction(e -> 
                        {
      OutputArea.outputArea.setText("");
      System.out.println("New file");
    });
    //openButtonAction
    openButton.setOnAction(e -> 
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
    //saveButtonAction
    saveButton.setOnAction(e -> 
                          {
      OutputArea.outputArea.setText("");
      System.out.println("Save");
      if(file == null)
      {
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
      }
      else
      {
        try
        {
          TextEditor.saveTextToFile(file);
        }catch(Exception ex){ex.printStackTrace();}
      }
    });
    //undoButtonAction
    undoButton.setOnAction(e -> 
                        {
      OutputArea.outputArea.setText("");
      System.out.println("Undo");
    });
    //redoButtonAction
    redoButton.setOnAction(e -> 
                        {
      OutputArea.outputArea.setText("");
      System.out.println("Redo");
    });
    //compileButtonAction
    compileButton.setOnAction(e -> 
                        {
      OutputArea.outputArea.setText("");
      System.out.println("Compile");
    });
    //runButtonAction
    runButton.setOnAction(e -> 
                        {
      OutputArea.outputArea.setText("");
      System.out.println("Run");
    });
    
    toolBar = new ToolBar(newButton, openButton, saveButton, undoButton, redoButton, compileButton, runButton);
  }
  
  public ToolBar getToolBar()
  {
    return(toolBar);
  }
}