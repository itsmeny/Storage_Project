package Control;

public class StorageData {

    private String StorageName;
    private int StoragePassword;
    private boolean StorageStatus;

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
