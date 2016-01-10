
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        names[walletCount] = name;
        wallets[walletCount] = new OptionsWallet();
        currentOpenWallet = walletCount;
        walletCount++;
    }

    void createWallet(File selectedFile) {
        createWallet(selectedFile.getName());
        savePath(selectedFile.getPath());
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

    private void saveWalletToFile(int idx) {
        OptionsWallet wal = wallets[idx];
        try {
            PrintWriter writer = new PrintWriter(paths[idx], "UTF-8");
            for (Opcion opt : wal.getOptions()) {
                writer.println(opt.toString());
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OptionsWalletManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(OptionsWalletManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveCurrentWalletToFile() {
        saveWalletToFile(currentOpenWallet);
    }

    public void saveAllWalletsToFile() {
        for (int i = 0; i < walletCount; i++) {
            saveWalletToFile(i);
        }
    }

    void openWallet(File selectedFile) {
        String path = selectedFile.getAbsolutePath();
        String name = selectedFile.getName();
        if (walletCount> 0) {
            for (String path1 : paths) {
                if (path1.compareToIgnoreCase(path) == 0) {
                    return; //wallet already open
                }
            }
        }
        if (walletCount > 31) {
            return;
        }
        currentOpenWallet = walletCount;
        walletCount++;
        paths[currentOpenWallet] = path;
        names[currentOpenWallet] = name;
        wallets[currentOpenWallet] = new OptionsWallet();
        BufferedReader br = null;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(path));
            while ((sCurrentLine = br.readLine()) != null) {
                wallets[currentOpenWallet].addOption(new Opcion(sCurrentLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
