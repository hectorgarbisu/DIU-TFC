
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

    public OptionsWalletManager() {
        walletCount = 0;
        names = new String[32];
        paths = new String[32];
        wallets = new OptionsWallet[32];
    }

    public void createWallet(String name) {
        System.out.println(name);
        names[walletCount] = name;
        wallets[walletCount] = new OptionsWallet();
        currentOpenWallet = walletCount;
        walletCount++;
    }

    void createWallet(File selectedFile) {
        createWallet(selectedFile.getName());
        savePath(selectedFile.getPath());
        System.out.println("cartera creada en slot: "+currentOpenWallet);
    }

    public void savePath(String path) {
        paths[currentOpenWallet] = path;
    }

    public void saveWallet(OptionsWallet wallet) {
        wallets[currentOpenWallet] = wallet;
    }

    public boolean pathExists(String string) {
        for (int i = 0; i < walletCount; i++) {
            if (paths[i].compareToIgnoreCase(string) == 0) {
                return true;
            }
        }
        return false;
    }

    public int getCurrentWalletIndex() {
        return currentOpenWallet;
    }

    public int getWalletCount() {
        return walletCount;
    }

    public String getName(int i) {
        return names[i];
    }

    public void addOptionToCurrentWallet(Opcion get) {
        System.out.println("currentWallet: " + currentOpenWallet);
        wallets[currentOpenWallet].addOption(get);
    }

    public int getCurrentWalletOptionsCount() {
        return wallets[currentOpenWallet].getOptionsAsArray().length;
    }

    public Opcion[] getCurrentWalletOptions() {
        return wallets[currentOpenWallet].getOptionsAsArray();
    }

    public OptionsWallet getCurrentWallet() {
        return wallets[currentOpenWallet];
    }

    void setCurrentWallet(int curr) {
        currentOpenWallet = curr;
    }

    void removeOptionsFromCurrentWallet(int[] rows) {
        wallets[currentOpenWallet].removeOptions(rows);
    }

}
