package Control;

import java.util.Arrays;

public class StorageData {

    private String StorageName;
    private int StoragePassword;
    private boolean StorageStatus;
    private String[] StorageItems = {null, null, null, null, null, null, null, null, null, null};

    public StorageData(String name, int password, boolean stat) {
        this.StorageName = name;
        this.StoragePassword = password;
        this.StorageStatus = stat;
    }

    public void setStorageName(String name) {
        this.StorageName = name;
    }

    public void setStoragePassword(int password) {
        this.StoragePassword = password;
    }

    public void setStorageStatus(boolean status) {
        this.StorageStatus = status;
    }

    public void setItems(int number, String items) {
        this.StorageItems[number] = items;
    }

    public void removeItems(int number) {
        this.StorageItems[number] = null;
    }
  
    public String getStorageItems(int number) {
        return this.StorageItems[number - 1];
    }

    public void getStorageItems() {
        System.out.println(Arrays.toString(this.StorageItems));
    }

    public String getStorageName() {
        return this.StorageName;
    }

    public int getStoragePassword() {
        return this.StoragePassword;
    }

    public boolean getStorageStatus() {
        return this.StorageStatus;
    }

}
