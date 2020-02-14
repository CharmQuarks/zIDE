import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.io.File;

public class FileList
{
  ListView<File> listView;
  static ObservableList<File> list;
  
  public FileList()
  {
    list = FXCollections.<File>observableArrayList();
    listView = new ListView<>(list);
    listView.getSelectionModel().selectedItemProperty().addListener(e ->
                                                                    {
      try
      {
        TextEditor.setTextFromFile(listView.getSelectionModel().getSelectedItem());
      }catch(Exception ex){ex.printStackTrace();}
    });
  }
  
  public ListView getFileList()
  {
    return(listView);
  }
  
  public static void addToList(File file) throws Exception
  {
    list.add(file);
  }
}