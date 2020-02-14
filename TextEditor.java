import javafx.scene.control.TextArea;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class TextEditor
{
  static TextArea textArea;
  static Scanner scanner;
  static FileWriter fileWriter;
  
  public TextEditor()
  {
    textArea = new TextArea();
  }
  
  public TextArea getTextArea()
  {
    return(textArea);
  }
  
  public static void setTextFromFile(File file) throws Exception
  {
    scanner = new Scanner(file);
    textArea.setText("");
    
    while(scanner.hasNextLine())
    {
      textArea.appendText(scanner.nextLine() + "\n");
    }
  }
  
  public static void saveTextToFile(File file) throws Exception
  {
    fileWriter = new FileWriter(file);
    fileWriter.write(textArea.getText());
    fileWriter.close();
  }
}