import javafx.scene.control.TextArea;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class OutputArea extends OutputStream
{
  static TextArea outputArea;
  PrintStream printStream;
  
  public OutputArea()
  {
    outputArea = new TextArea();
    outputArea.setEditable(false);
    printStream = new PrintStream(this, true);
    System.setOut(printStream);
    System.setErr(printStream);
  }
  
  public TextArea getOutputArea()
  {
    return(outputArea);
  }
  
  @Override
  public void write(int i) throws IOException
  {
    outputArea.appendText(String.valueOf((char) i));
  }
}