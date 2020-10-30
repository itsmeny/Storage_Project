package storage_project;

import java.util.Scanner;

public final class Storage {

    private String[] Storage_Name = {};
    private boolean[] Storage_Status = {};
    private int[] Storage_password = {};
    private int slots = 0;

    public Storage() {
        Scanner input = new Scanner(System.in);
        System.out.print("How many storage: ");
        int amount = input.nextInt();
        if (amount < 1) {
            amount = 1;
        }
        Storage_Name = new String[amount];
        Storage_Status = new boolean[amount];
        Storage_password = new int[amount];
        for (int i = 0; i <= amount - 1; i++) {
            int num = i + 1;
            this.Storage_Name[i] = "Storage " + num;
            this.Storage_Status[i] = false;
            this.Storage_password[i] = 0;
        }

        int select_menu;

        while (true) {
            System.out.println("== Storage Rental Application ==");
            System.out.printf("Storage Slots %d/%d\n\n", this.getSlots(), Storage_Name.length);
            System.out.print("1.) Rent Storage \n");
            System.out.print("2.) Edit Storage Info\n");
            System.out.print("3.) Reset Storage.\n");
            System.out.print("4.) Get Storage Info.\n");
            System.out.print("5.) Get All Storage Info\n");
            System.out.print("6.) Get Available Storage\n");
            System.out.print("7.) Reset All Storage\n");
            System.out.print("0.) Exit Application\n");
            System.out.print("\nEnter Your Menu Choice: ");

            select_menu = input.nextInt();

            switch (select_menu) {

                case 1:
                    System.out.println("[Rent Storage]");
                    System.out.printf("Storage Number (1 - %d):", Storage_Name.length);
                    int Storage_Number = input.nextInt();
                    input.nextLine();
                    if (Storage_Number < 1) {
                        Storage_Number = 1;
                    } else if (Storage_Number > Storage_Name.length) {
                        Storage_Number = Storage_Name.length;
                    }
                    if (this.getStorageStatus(Storage_Number) == false) {
                        System.out.printf("Storage Number #%d Name: ", Storage_Number);
                        String Storage_name = input.nextLine();
                        System.out.printf("Storage Number #%d Password (digits): ", Storage_Number);
                        int Storage_Password = input.nextInt();
                        this.rentStorage(Storage_Number, Storage_name, Storage_Password);
                        System.out.printf("Storage Number #%d Rent Successfully!\n", Storage_Number);
                    } else {
                        System.out.printf("Storage Number #%d is unavailable!\n", Storage_Number);
                    }
                    break;

                case 2:
                    System.out.println("[Edit Storage]");
                    System.out.printf("Storage Number (1 - %d):", Storage_Name.length);
                    int Storage_Edit = input.nextInt();
                    input.nextLine();
                    if (Storage_Edit < 1) {
                        Storage_Edit = 1;
                    } else if (Storage_Edit > Storage_Name.length) {
                        Storage_Edit = Storage_Name.length;
                    }
                    if (this.getStorageStatus(Storage_Edit) == true) {
                        System.out.printf("Storage Number #%d Password (digits): ", Storage_Edit);
                        int Storage_OldPassword = input.nextInt();
                        input.nextLine();
                        if (this.AdminGetPassword(Storage_Edit) == Storage_OldPassword) {
                            System.out.printf("New Storage Number #%d Name: ", Storage_Edit);
                            String Storage_EditName = input.nextLine();
                            System.out.printf("New Storage Number #%d Password (digits): ", Storage_Edit);
                            int Storage_EditPassword = input.nextInt();
                            this.editStorageInfo(Storage_Edit, Storage_EditName, Storage_EditPassword);
                            System.out.printf("Storage Number #%d Edit Info Successfully!\n", Storage_Edit);
                        } else {
                            System.out.println("Wrong Password!");
                        }

                    } else {
                        System.out.printf("Storage Number #%d is still available!\n", Storage_Edit);
                    }
                    break;

                case 3:
                    System.out.println("[Reset Storage]");
                    System.out.printf("Storage Number (1 - %d):", Storage_Name.length);
                    int Storage_Reset = input.nextInt();
                    input.nextLine();
                    if (Storage_Reset < 1) {
                        Storage_Reset = 1;
                    } else if (Storage_Reset > Storage_Name.length) {
                        Storage_Reset = Storage_Name.length;
                    }
                    if (this.getStorageStatus(Storage_Reset) == true) {
                        System.out.printf("Storage Number #%d Password (digits): ", Storage_Reset);
                        int Storage_OldPassword = input.nextInt();
                        input.nextLine();
                        if (this.AdminGetPassword(Storage_Reset) == Storage_OldPassword) {
                            this.resetStorage(Storage_Reset);
                            System.out.printf("Reset Storage Number #%d Successfully!\n", Storage_Reset);
                        } else {
                            System.out.println("Wrong Password!");
                        }

                    } else {
                        System.out.printf("Storage Number #%d is still available!\n", Storage_Reset);
                    }
                    break;

                case 4:
                    System.out.println("[Get Storage Info]");
                    System.out.printf("Storage Number (1 - %d):", Storage_Name.length);
                    int Storage_Info = input.nextInt();
                    if (Storage_Info < 1) {
                        Storage_Info = 1;
                    } else if (Storage_Info > Storage_Name.length) {
                        Storage_Info = Storage_Name.length;
                    }
                    System.out.println(this.getStorageInfo(Storage_Info));
                    break;

                case 5:
                    System.out.println("[All Storage Info]");
                    this.getAllStorageInfo();
                    break;
                case 6:
                    this.getAvailableStorage();
                    break;
                case 7:
                    System.out.println("[Reset All Storage]");
                    System.out.print("Admin password (digits):");
                    int admin_password = input.nextInt();
                    input.nextLine();
                    if (admin_password == 6969) {
                        for (int i = 1; i <= Storage_Name.length; i++) {
                            resetStorage(i);
                        }
                        System.out.println("Reset All Storage Successfully!\n");
                        this.slots = 0;
                    } else {
                        System.out.println("Wrong password!");
                    }
                    break;

                case 0:
                    System.exit(0);

                default:
                    break;
            }
        }
    }

    public String getStorageInfo(int Storage_Number) {
        String Status;
        if (Storage_Status[Storage_Number - 1] == true) {
            Status = "unavailable";
        } else {
            Status = "available";
        }
        return String.format("Storage Number #%d {Storage Name: %s, Storage Status: %s}\n", Storage_Number, Storage_Name[Storage_Number - 1], Status);
    }

    public boolean getStorageStatus(int Storage_Number) {
        return Storage_Status[Storage_Number - 1];
    }

    public void editStorageInfo(int Storage_Number, String Storage_Name, int Storage_Password) {
        this.Storage_Name[Storage_Number - 1] = Storage_Name;
        this.Storage_password[Storage_Number - 1] = Storage_Password;
    }

    public void resetStorage(int Storage_Number) {
        Storage_Name[Storage_Number - 1] = "Storage " + Storage_Number;
        Storage_password[Storage_Number - 1] = 0;
        Storage_Status[Storage_Number - 1] = false;
        this.slots--;
    }

    public void rentStorage(int Storage_Number, String Storage_Name, int Storage_Password) {
        this.Storage_Status[Storage_Number - 1] = true;
        this.Storage_password[Storage_Number - 1] = Storage_Password;
        this.Storage_Name[Storage_Number - 1] = Storage_Name;
        this.slots++;
    }

    public int AdminGetPassword(int Storage_Number) {
        return this.Storage_password[Storage_Number - 1];
    }

    public void getAllStorageInfo() {
        String Status;
        for (int i = 0; i <= Storage_Name.length - 1; i++) {
            if (Storage_Status[i] == true) {
                Status = "unavailable";
            } else {
                Status = "available";
            }
            System.out.printf("Storage Number #%d {Storage Name: %s, Storage Status: %s}\n", i + 1, Storage_Name[i], Status);
        }
    }

    public int getSlots() {
        return slots;
    }

    public void getAvailableStorage() {
        System.out.print("Available Storage Number: ");
        for (int i = 0; i <= Storage_Name.length - 1; i++) {
            if (Storage_Status[i] == false) {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println("");
    }
}
