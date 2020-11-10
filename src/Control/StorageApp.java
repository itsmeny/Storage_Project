package Control;

import java.util.Scanner;

public class StorageApp {

    StorageControl StorageApp = new StorageControl(0);

    public StorageApp() {
        HowManyStorage();
    }

    public void HowManyStorage() {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("How many storage? (number only): ");
            int amount = input.nextInt();
            if (amount < 1) {
                amount = 1;
            }
            StorageApp = new StorageControl(amount);
            for (int i = 0; i <= amount - 1; i++) {
                this.StorageApp.setStorage();
            }
            Storage_App();
        } catch (Exception e) {
            System.out.println("Wrong input!");
            input.reset();
            input.next();
            HowManyStorage();
        }
    }

    public void Storage_App() {

        Scanner input = new Scanner(System.in);
        try {

            while (true) {
                System.out.println("== Storage Rental Application ==");
                System.out.printf("Storage Slots %d/%d\n\n", StorageApp.getSlots(), StorageApp.getAllSlots());
                System.out.print("1.) Rent Storage.\n");
                System.out.print("2.) Edit Storage Info.\n");
                System.out.print("3.) Reset Storage.\n");
                System.out.print("4.) Get Storage Info.\n");
                System.out.print("5.) Get All Storage Info.\n");
                System.out.print("6.) Get All Available Storage.\n");
                System.out.print("7.) Show Storage Items.\n");
                System.out.print("8.) Add Storage Items.\n");
                System.out.print("9.) Remove Storage Items.\n");
                System.out.print("10.) Reset All Storage.\n");
                System.out.print("0.) Exit Application.\n");
                System.out.print("\nEnter Your Menu Choice: ");

                int select_menu = input.nextInt();

                switch (select_menu) {

                    case 1:
                        System.out.println("[Rent Storage]");
                        System.out.printf("Storage Number (1 - %d): ", StorageApp.getAllSlots());
                        int Storage_Number = input.nextInt();
                        input.nextLine();
                        if (Storage_Number < 1) {
                            Storage_Number = 1;
                        } else if (Storage_Number > StorageApp.getAllSlots()) {
                            Storage_Number = StorageApp.getAllSlots();
                        }
                        if (StorageApp.getStorageStatus(Storage_Number) == false) {
                            System.out.printf("Storage Number #%d Name: ", Storage_Number);
                            String Storage_name = input.nextLine();
                            System.out.printf("Storage Number #%d Password (number only): ", Storage_Number);
                            int Storage_Password = input.nextInt();
                            StorageApp.rentStorage(Storage_Number, Storage_name, Storage_Password);
                            System.out.printf("Storage Number #%d Rent Successfully!\n", Storage_Number);
                        } else {
                            System.out.printf("Storage Number #%d is unavailable!\n", Storage_Number);
                        }
                        break;

                    case 2:
                        System.out.println("[Edit Storage]");
                        System.out.printf("Storage Number (1 - %d): ", StorageApp.getAllSlots());
                        int Storage_Edit = input.nextInt();
                        input.nextLine();
                        if (Storage_Edit < 1) {
                            Storage_Edit = 1;
                        } else if (Storage_Edit > StorageApp.getAllSlots()) {
                            Storage_Edit = StorageApp.getAllSlots();
                        }
                        if (StorageApp.getStorageStatus(Storage_Edit) == true) {
                            System.out.printf("Storage Number #%d Password (number only): ", Storage_Edit);
                            int Storage_OldPassword = input.nextInt();
                            input.nextLine();
                            if (StorageApp.getPassword(Storage_Edit) == Storage_OldPassword) {
                                System.out.printf("New Storage Number #%d Name: ", Storage_Edit);
                                String Storage_EditName = input.nextLine();
                                System.out.printf("New Storage Number #%d Password (number only): ", Storage_Edit);
                                int Storage_EditPassword = input.nextInt();
                                StorageApp.editStorageInfo(Storage_Edit, Storage_EditName, Storage_EditPassword);
                                System.out.printf("Storage Number #%d Edit Info Successfully!\n", Storage_Edit);
                            } else {
                                System.out.printf("Wrong Password for Storage Number #%d!\n", Storage_Edit);
                            }

                        } else {
                            System.out.printf("Storage Number #%d is still available!\n", Storage_Edit);
                        }
                        break;

                    case 3:
                        System.out.println("[Reset Storage]");
                        System.out.printf("Storage Number (1 - %d): ", StorageApp.getAllSlots());
                        int Storage_Reset = input.nextInt();
                        input.nextLine();
                        if (Storage_Reset < 1) {
                            Storage_Reset = 1;
                        } else if (Storage_Reset > StorageApp.getAllSlots()) {
                            Storage_Reset = StorageApp.getAllSlots();
                        }
                        if (StorageApp.getStorageStatus(Storage_Reset) == true) {
                            System.out.printf("Storage Number #%d Password (number only): ", Storage_Reset);
                            int Storage_OldPassword = input.nextInt();
                            input.nextLine();
                            if (StorageApp.getPassword(Storage_Reset) == Storage_OldPassword) {
                                StorageApp.resetStorage(Storage_Reset);
                                StorageApp.resetItems(Storage_Reset);
                                System.out.printf("Reset Storage Number #%d Successfully!\n", Storage_Reset);
                            } else {
                                System.out.printf("Wrong Password for Storage Number #%d!\n", Storage_Reset);
                            }

                        } else {
                            System.out.printf("Storage Number #%d is still available!\n", Storage_Reset);
                        }
                        break;

                    case 4:
                        System.out.println("[Get Storage Info]");
                        System.out.printf("Storage Number (1 - %d): ", StorageApp.getAllSlots());
                        int Storage_Info = input.nextInt();
                        if (Storage_Info < 1) {
                            Storage_Info = 1;
                        } else if (Storage_Info > StorageApp.getAllSlots()) {
                            Storage_Info = StorageApp.getAllSlots();
                        }
                        StorageApp.getStorageInfo(Storage_Info);
                        break;

                    case 5:
                        System.out.println("[All Storage Info]");
                        StorageApp.getAllStorageInfo();
                        break;

                    case 6:
                        StorageApp.getAllAvailableStorage();
                        break;

                    case 7:
                        System.out.println("[Show Storage Items]");
                        System.out.printf("Storage Number (1-%d): ", StorageApp.getAllSlots());
                        int showItems = input.nextInt();
                        input.nextLine();
                        if (showItems < 1) {
                            showItems = 1;
                        } else if (showItems > StorageApp.getAllSlots()) {
                            showItems = StorageApp.getAllSlots();
                        }
                        if (StorageApp.getStorageStatus(showItems) == true) {
                            System.out.printf("Storage Number #%d Password (number only): ", showItems);
                            int Storage_OldPassword = input.nextInt();
                            input.nextLine();
                            if (StorageApp.getPassword(showItems) == Storage_OldPassword) {
                                System.out.printf("Items in Storage Number #%d = ", showItems);
                                StorageApp.showStorageItems(showItems);
                            } else {
                                System.out.printf("Wrong Password for Storage Number #%d!\n", showItems);
                            }
                        } else {
                            System.out.printf("Storage Number #%d is still available!\n", showItems);
                        }
                        break;

                    case 8:
                        int add_pos;
                        System.out.println("[Add Storage Items]");
                        System.out.printf("Storage Number (1-%d): ", StorageApp.getAllSlots());
                        int add_Items = input.nextInt();
                        input.nextLine();
                        if (add_Items < 1) {
                            add_Items = 1;
                        } else if (add_Items > StorageApp.getAllSlots()) {
                            add_Items = StorageApp.getAllSlots();
                        }
                        if (StorageApp.getStorageStatus(add_Items) == true) {
                            System.out.printf("Storage Number #%d Password (number only): ", add_Items);
                            int Storage_OldPassword = input.nextInt();
                            input.nextLine();
                            if (StorageApp.getPassword(add_Items) == Storage_OldPassword) {
                                if (StorageApp.getCount(add_Items) < 10) {
                                    for (int i = 1; i < StorageApp.getItemsLength(add_Items) + 1; i++) {
                                        if (StorageApp.showSelectItems(add_Items, i) == null == true) {
                                            add_pos = i;
                                            System.out.print("Items to add (type 'exit' to exit): ");
                                            String ItemsToAdd = input.nextLine();
                                            if (ItemsToAdd.equals("exit")) {
                                                Storage_App();
                                            } else {
                                                StorageApp.addStorageItems(add_Items, add_pos, ItemsToAdd);
                                                System.out.printf("Add '%s' into Storage Number #%d Successfully!\n", ItemsToAdd, add_Items);
                                            }
                                        }
                                    }
                                } else {
                                    System.out.printf("Storage Number #%d Full\n", add_Items);
                                }
                            } else {
                                System.out.printf("Wrong Password for Storage Number #%d!\n", add_Items);
                            }
                        } else {
                            System.out.printf("Storage Number #%d is still available!\n", add_Items);
                        }
                        break;

                    case 9:
                        int rm_pos;
                        System.out.println("[Remove Storage Items]");
                        System.out.printf("Storage Number (1-%d): ", StorageApp.getAllSlots());
                        int rm_Items = input.nextInt();
                        input.nextLine();
                        if (rm_Items < 1) {
                            rm_Items = 1;
                        } else if (rm_Items > StorageApp.getAllSlots()) {
                            rm_Items = StorageApp.getAllSlots();
                        }
                        if (StorageApp.getStorageStatus(rm_Items) == true) {
                            System.out.printf("Storage Number #%d Password (number only): ", rm_Items);
                            int Storage_OldPassword = input.nextInt();
                            input.nextLine();
                            if (StorageApp.getPassword(rm_Items) == Storage_OldPassword) {
                                while (true) {
                                    System.out.print("Items to remove (type 'exit' to exit): ");
                                    String ItemsToRemove = input.nextLine();
                                    for (int x = 1; x < StorageApp.getItemsLength(rm_Items) + 1; x++) {
                                        if (ItemsToRemove.equals("exit")) {
                                            Storage_App();
                                        } else if (StorageApp.showSelectItems(rm_Items, x) == null ? ItemsToRemove == null : StorageApp.showSelectItems(rm_Items, x).equals(ItemsToRemove)) {
                                            rm_pos = x;
                                            StorageApp.removeStorageItems(rm_Items, rm_pos);
                                            System.out.printf("Remove '%s' from Storage Number #%d Successfully!\n", ItemsToRemove, rm_Items);

                                        }
                                    }
                                }
                            } else {
                                System.out.printf("Wrong Password for Storage Number #%d!\n", rm_Items);
                            }
                        } else {
                            System.out.printf("Storage Number #%d is still available!\n", rm_Items);
                        }
                        break;

                    case 10:
                        System.out.println("[Reset All Storage]");
                        System.out.print("Admin password (number only): ");
                        int admin_password = input.nextInt();
                        input.nextLine();
                        if (admin_password == 6969) {
                            for (int i = 1; i <= StorageApp.getAllSlots(); i++) {
                                StorageApp.resetStorage(i);
                                StorageApp.resetItems(i);
                            }
                            System.out.println("Reset All Storage Successfully!\n");
                            StorageApp.setSlots(0);
                        } else {
                            System.out.println("Wrong password for Reset All Storage!");
                        }
                        break;

                    case 0:
                        System.exit(0);

                    default:
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong input!");
            input.reset();
            input.next();
            Storage_App();
        }
    }
}
