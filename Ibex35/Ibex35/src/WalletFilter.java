import java.io.File;
import javax.swing.filechooser.*;  

public class WalletFilter extends FileFilter {
        
    public boolean accept(File f) {         
        if (f.isDirectory()) {             
            return true;
        }         
        String filename = f.getName();
        int dot = filename.lastIndexOf('.');
        String extension = filename.substring(dot + 1);
  
        if (extension != null) {             
            if( extension.equals("wlt")) {                     
                return true;             
            } else {                 
                return false;             
            }        
        }           
        return false;     
    }       
    public String getDescription() {         
        return "Tipo Cartera";     
    } 
}