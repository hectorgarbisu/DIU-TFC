
import java.io.File;

/**
 *
 * @author geco
 */
public class OptionsWalletManager {
    private String[] paths;
    private String[] names;
    private OptionsWallet[] wallets;
    private int walletCount;
    private int currentOpenWallet;
    
    public OptionsWalletManager(){
        walletCount = 0;
        names = new String[32];
        paths = new String[32];
        wallets = new OptionsWallet[32];
    }
    
    public void createWallet(String name){
        System.out.println(name);
        names[walletCount] = name;
        wallets[walletCount] = new OptionsWallet();
        currentOpenWallet = walletCount;
        walletCount++;
    }
    void createWallet(File selectedFile) {
        createWallet(selectedFile.getName());
        savePath(selectedFile.getPath());
    }
    public void savePath(String path){
        paths[currentOpenWallet] = path;
    }
    
    public void saveWallet(OptionsWallet wallet){
        wallets[currentOpenWallet] = wallet;
    }


}
