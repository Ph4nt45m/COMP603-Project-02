/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author m4ria
 */
public final class FileManager {

    private BufferedReader br;
    private BufferedWriter bw;
    private String singleRoomDetails;
    private String doubleRoomDetails;
    private String familyRoomDetails;
    private String groupRoomDetails;
    private String details;
    protected Vouchers vouchers;
    protected int packageIndex;
    protected int momentaryIndex;
    private LocalDate date;

    //Constructs a new FileManager object. Initializes instance variables for storing room details.
    public FileManager() {
        this.singleRoomDetails = "";
        this.doubleRoomDetails = "";
        this.familyRoomDetails = "";
        this.groupRoomDetails = "";
        this.details = "";
    }

    /*Constructs a new FileManager object with the given vouchers. Initializes
     * instance variables for storing vouchers, package index, and current date.
     */
    public FileManager(Vouchers voucher) {
        this.vouchers = voucher;
        this.packageIndex = 0;
        this.date = LocalDate.now();
    }

    /*Reads the room details from a text file based on the given room type.
     * Appends the room details to the corresponding instance variables.
     */
    public String readRoomDetails(String roomType) {
        try {
            br = new BufferedReader(new FileReader("./resources/" + roomType + ".txt"));
            String line = null;

            try {
                while ((line = br.readLine()) != null) {
                    if (roomType.contains("Single")) {
                        this.singleRoomDetails += line + "\n";
                    } else if (roomType.contains("Double")) {
                        this.doubleRoomDetails += line + "\n";
                    } else if (roomType.contains("Family")) {
                        this.familyRoomDetails += line + "\n";
                    } else if (roomType.contains("Group")) {
                        this.groupRoomDetails += line + "\n";
                    }
                }
            } catch (IOException ex) {
                System.out.println("IOException: " + ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File for Single Room details was not found!");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("There was an error closing BufferedReader");
                }
            }

            if (roomType.contains("Single")) {
                this.details += this.singleRoomDetails;
            } else if (roomType.contains("Double")) {
                this.details += this.doubleRoomDetails;
            } else if (roomType.contains("Family")) {
                this.details += this.familyRoomDetails;
            } else if (roomType.contains("Group")) {
                this.details += this.groupRoomDetails;
            }
        }

        return this.details;
    }

    /*Generates a voucher based on the selected voucher option in the Vouchers object.
    * Calls the corresponding method to create the voucher.
     */
    public void makeVoucher() {
        if (vouchers.voucherOptionsGroup.getSelection() != null) {
            if (vouchers.voucherOptionsGroup.getSelection() == vouchers.packageRadioButton.getModel()) {
                firstVoucher();
            } else if (vouchers.voucherOptionsGroup.getSelection() == vouchers.momentaryRadioButton.getModel()) {
                momentaryVoucher();
            }
        }
    }

    /* Generates a package voucher and writes the voucher details to a file.
     * Uses the packageIndex to create a unique file name and adds the voucher
     * to the voucher list.
     */
    public void firstVoucher() {
        String fileName = "";
        try {
            String start = "PackageVoucher";
            String end = ".txt";
            String path = "./vouchers/";

            boolean exist = true;

            while (exist) {
                fileName = start + packageIndex + end;
                File file = new File(path + fileName);
                if (file.exists()) {
                    packageIndex++;
                } else {
                    exist = false;
                }
            }
            bw = new BufferedWriter(new FileWriter(new File("./vouchers/" + fileName)));
            bw.write("$200 Gift Voucher for Marl Avenue Hotel\n");
            bw.write("To: " + vouchers.voucherDetails.recipient + "\n");
            bw.write("From: " + vouchers.voucherDetails.giver + "\n");
            bw.write("Valid till: " + date.getDayOfMonth() + "/" + (date.getYear()+1) + "/" + date.getYear()+1 + "\n");
            bw.write("Find us on www.MarlAvenueHotel.co.nz\n");
            bw.close();

            packageIndex++;

        } catch (IOException e) {
            System.out.println("An IOException occurred.\n");
        }
    }

    /*Generates a gift voucher for a recipient with a minimum value of $50. Prompts the user to input the name of the recipient 
    *and the name of the giver, ensuring that the inputs are alphabetic characters only. Prompts the user to input the value of the voucher,
    *ensuring that the input is a valid number of at least $50. Finally, writes the voucher details to a file and adds the voucher to a list 
    *of vouchers.
     */
    public void momentaryVoucher() {
        String fileName = "";
        try {
            String start = "MomentaryVoucher";
            String end = ".txt";
            String path = "./vouchers/";

            boolean exist = true;

            while (exist) {
                fileName = start + momentaryIndex + end;
                File file = new File(path + fileName);
                if (file.exists()) {
                    momentaryIndex++;
                } else {
                    exist = false;
                }
            }
            bw = new BufferedWriter(new FileWriter(new File("./vouchers/" + fileName)));
            bw.write("Gift Voucher for Marl Avenue with the value of: $" + vouchers.voucherDetails.amount + "\n");
            bw.write("To: " + vouchers.voucherDetails.recipient + "\n");
            bw.write("From: " + vouchers.voucherDetails.giver + "\n");
            bw.write("Valid till: " + date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + (date.getYear()+1) + "\n");
            bw.write("Find us on www.MarlAvenueHotel.co.nz\n");
            bw.close();

        } catch (IOException e) {
            System.out.println("An IOException occurred.\n");
        }
    }
}
