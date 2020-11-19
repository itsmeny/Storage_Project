package Control;

public class StorageControl {

    private StorageData[] StorageData;
    private int allSlots;
    private int slots;

    public StorageControl(int size) {
        StorageData = new StorageData[size];
    }

    public void rentStorage(int number, String name, int password) {
        StorageData[number - 1] = new StorageData(name, password, true);
        this.slots++;
    }

    public void editStorageInfo(int number, String new_name, int new_password) {
        StorageData[number - 1] = new StorageData(new_name, new_password, true);
    }

    public int getCount(int number) {
        return StorageData[number - 1].getCount();
    }

    public void resetStorage(int number) {
        StorageData[number - 1] = new StorageData("Storage " + number, 0, false);
        this.slots--;
    }

    public void resetItems(int number) {
        for (int i = 0; i <= 9; i++) {
            StorageData[number - 1].setItems(i, null);
        }
    }

    public void setStorage() {
        for (int i = 0; i <= StorageData.length - 1; i++) {
            int num = i + 1;
            StorageData[i] = new StorageData("Storage " + num, 0, false);
        }
        this.allSlots = StorageData.length;

    }

    public void setSlots(int number) {
        this.slots = number;
    }

    public int getSlots() {
        return this.slots;
    }

    public int getAllSlots() {
        return this.allSlots;
    }

    public boolean getStorageStatus(int number) {
        return StorageData[number - 1].getStorageStatus();
    }

    public int getPassword(int number) {
        return StorageData[number - 1].getStoragePassword();
    }

    public String getStorageInfo(int number) {
        String Status;
        if (StorageData[number - 1].getStorageStatus() == true) {
            Status = "unavailable";
        } else {
            Status = "available";
        }
        return String.format("Storage Number #%d {Storage Name: %s, Storage Status: %s}\n", number, StorageData[number - 1].getStorageName(), Status);
    }

    public void addStorageItems(int StorageNumber, int ItemsNumber, String items) {
        StorageData[StorageNumber - 1].setItems(ItemsNumber - 1, items);
    }

    public void removeStorageItems(int StorageNumber, int ItemsNumber) {
        StorageData[StorageNumber - 1].removeItems(ItemsNumber - 1);
    }

    public void showStorageItems(int number) {
        StorageData[number - 1].getStorageItems();
    }

    public String showSelectItems(int number, int itemsNumber) {
        return StorageData[number - 1].getStorageItems(itemsNumber);
    }

    public String getAllAvailableStorage() {
        String Storage_Number = "";
        for (int i = 0; i <= StorageData.length - 1; i++) {
            if (StorageData[i].getStorageStatus() == false) {
                Storage_Number += (i + 1 + " ");
            }
        }
        return Storage_Number;
    }

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

    public int getItemsLength(int number) {
        return StorageData[number - 1].getItemsLength();
    }
}
