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
    }
    
    public void createWallet(String name){
        names[walletCount] = name;
        wallets[walletCount] = new OptionsWallet();
        currentOpenWallet = walletCount;
        walletCount++;
    }
    
    public void savePath(String path){
        paths[currentOpenWallet] = path;
    }
    
    public void saveWallet(OptionsWallet wallet){
        wallets[currentOpenWallet] = wallet;
    }
}
