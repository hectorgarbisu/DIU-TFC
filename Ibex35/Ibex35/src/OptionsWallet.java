
import java.util.ArrayList;

/**
 *
 * @author geco
 */
public class OptionsWallet {
    public ArrayList<Opcion> options = new ArrayList<>();
    
    public OptionsWallet(){
    }
    
    public void addOption(Opcion opt){
        options.add(opt);  
    }
    public Opcion[] getOptionsAsArray(){
        return (Opcion[]) options.toArray();
    }
    public void removeOption(Opcion opt){
        removeOption(opt,1);
    }
    public void removeOption(Opcion opt,int howMany){
        for(int i = 0;i<options.size();i++){
            if(howMany<1)break;
            if(options.get(i).isEqual(opt)){
                options.remove(i);
                i--;
                howMany--;
            }
        }
    }
    public void removeEachOcurrence(Opcion opt){
        for(int i = 0;i<options.size();i++){
            if(options.get(i).isEqual(opt)){
                options.remove(i);
                i--;
            }
        }
    }
    public void clear(){
        options.clear();
    }
    
    public void saveToFile(String path){
    }
}
