package Control;

import java.util.Arrays;

public class StorageData {

    private String StorageName;
    private int StoragePassword;
    private boolean StorageStatus;
    private String[] StorageItems;
    private int itemsCount = 0;

    /**
     *
     * @param name Storage name or owner name.
     * @param password Storage password.
     * @param stat Storage status.
     */
    public StorageData(String name, int password, boolean stat) {
        this.StorageItems = new String[10];
        this.StorageName = name;
        this.StoragePassword = password;
        this.StorageStatus = stat;
    }

    /**
     *
     * @param name set Storage name.
     */
    public void setStorageName(String name) {
        this.StorageName = name;
    }

    /**
     *
     * @param password set Storage password.
     */
    public void setStoragePassword(int password) {
        this.StoragePassword = password;
    }

    /**
     *
     * @param status set Storage status.
     */
    public void setStorageStatus(boolean status) {
        this.StorageStatus = status;
    }

    /**
     *
     * @param number items number that you want to setItems.
     * @param items items that you want to set in selected storage.
     */
    public void setItems(int number, String items) {
        itemsCount++;
        this.StorageItems[number] = items;
    }

    /**
     *
     * @param number storage number that you want to removeItems.
     */
    public void removeItems(int number) {
        itemsCount--;
        this.StorageItems[number] = null;
    }

    /**
     *
     * @param number items number that you want to getStorageItems.
     * @return Storage Items in selected storage.
     */
    public String getStorageItems(int number) {
        return this.StorageItems[number - 1];
    }

    /**
     * show arrays of items.
     */
    public void getStorageItems() {
        System.out.println(Arrays.toString(this.StorageItems));
    }

    /**
     *
     * @return Storage Name.
     */
    public String getStorageName() {
        return this.StorageName;
    }

    /**
     *
     * @return Storage Password.
     */
    public int getStoragePassword() {
        return this.StoragePassword;
    }

    /**
     *
     * @return Storage Status.
     */
    public boolean getStorageStatus() {
        return this.StorageStatus;
    }

    /**
     *
     * @return how many items in storage.
     */
    public int getCount() {
        return this.itemsCount;
    }

    /**
     *
     * @return maximum items in storage.
     */
    public int getItemsLength() {
        return this.StorageItems.length;
    }
}
