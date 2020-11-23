package Control;

public class StorageControl {

    private StorageData[] StorageData;
    private int allSlots;
    private int slots;

    /**
     *
     * @param size how many storage that you want to create.
     */
    public StorageControl(int size) {
        StorageData = new StorageData[size];
    }

    /**
     *
     * @param number number of storage that you want to rent.
     * @param name name of owner or storage name.
     * @param password storage password.
     */
    public void rentStorage(int number, String name, int password) {
        StorageData[number - 1] = new StorageData(name, password, true);
        this.slots++;
    }

    /**
     *
     * @param number number of storage that you want to edit.
     * @param new_name new name of owner or new storage name.
     * @param new_password new password.
     */
    public void editStorageInfo(int number, String new_name, int new_password) {
        StorageData[number - 1] = new StorageData(new_name, new_password, true);
    }

    /**
     *
     * @param number number of storage that you want to getCount.
     * @return how many items in selected storage.
     */
    public int getCount(int number) {
        return StorageData[number - 1].getCount();
    }

    /**
     *
     * @param number number of storage that you want to reset.
     */
    public void resetStorage(int number) {
        StorageData[number - 1] = new StorageData("Storage " + number, 0, false);
        this.slots--;
    }

    /**
     *
     * @param number number of storage that you want to reset items.
     */
    public void resetItems(int number) {
        for (int i = 0; i <= 9; i++) {
            StorageData[number - 1].setItems(i, null);
        }
    }

    /**
     * Set default storage.
     */
    public void setStorage() {
        for (int i = 0; i <= StorageData.length - 1; i++) {
            int num = i + 1;
            StorageData[i] = new StorageData("Storage " + num, 0, false);
        }
        this.allSlots = StorageData.length;

    }

    /**
     *
     * @param number Set number input to slots.
     */
    public void setSlots(int number) {
        this.slots = number;
    }

    /**
     *
     * @return how many storage slots that rented.
     */
    public int getSlots() {
        return this.slots;
    }

    /**
     *
     * @return all storage slots.
     */
    public int getAllSlots() {
        return this.allSlots;
    }

    /**
     *
     * @param number number of storage that you want to getStorageStatus.
     * @return selected storage status.
     */
    public boolean getStorageStatus(int number) {
        return StorageData[number - 1].getStorageStatus();
    }

    /**
     *
     * @param number number of storage that you want to getPassword.
     * @return selected storage password.
     */
    public int getPassword(int number) {
        return StorageData[number - 1].getStoragePassword();
    }

    /**
     *
     * @param number number of storage that you want to getStorageInfo.
     * @return selected StorageInfo.
     */
    public String getStorageInfo(int number) {
        String Status;
        if (StorageData[number - 1].getStorageStatus() == true) {
            Status = "unavailable";
        } else {
            Status = "available";
        }
        return String.format("Storage Number #%d {Storage Name: %s, Storage Status: %s}\n", number, StorageData[number - 1].getStorageName(), Status);
    }

    /**
     *
     * @param StorageNumber number of storage that you want to addStorageItems.
     * @param ItemsNumber number of items that you want to add items to.
     * @param items items that you want to add to selected storage.
     */
    public void addStorageItems(int StorageNumber, int ItemsNumber, String items) {
        StorageData[StorageNumber - 1].setItems(ItemsNumber - 1, items);
    }

    /**
     *
     * @param StorageNumber number of storage that you want to
     * removeStorageItems.
     * @param ItemsNumber number of items that you want to remove.
     */
    public void removeStorageItems(int StorageNumber, int ItemsNumber) {
        StorageData[StorageNumber - 1].removeItems(ItemsNumber - 1);
    }

    /**
     *
     * @param number number of storage that you want to showStorageItems.
     */
    public void showStorageItems(int number) {
        StorageData[number - 1].getStorageItems();
    }

    /**
     *
     * @param number number of storage that you want to showSelectItems.
     * @param itemsNumber number of items that you want to show.
     * @return items in that items number.
     */
    public String showSelectItems(int number, int itemsNumber) {
        return StorageData[number - 1].getStorageItems(itemsNumber);
    }

    /**
     *
     * @return all available storage number.
     */
    public String getAllAvailableStorage() {
        String Storage_Number = "";
        for (int i = 0; i <= StorageData.length - 1; i++) {
            if (StorageData[i].getStorageStatus() == false) {
                Storage_Number += (i + 1 + " ");
            }
        }
        return Storage_Number;
    }

    /**
     *
     * @return all storage info.
     */
    public String getAllStorageInfo() {
        String Status;
        String Storage_Info = "";
        for (int i = 0; i <= StorageData.length - 1; i++) {
            if (StorageData[i].getStorageStatus() == true) {
                Status = "unavailable";
            } else {
                Status = "available";
            }
            Storage_Info += String.format("Storage Number #%d {Storage Name: %s, Storage Status: %s}\n", i + 1, StorageData[i].getStorageName(), Status);
        }
        return Storage_Info;
    }

    /**
     *
     * @param number number of storage that you want to getItemsLength.
     * @return selected storage items length.
     */
    public int getItemsLength(int number) {
        return StorageData[number - 1].getItemsLength();
    }
}
