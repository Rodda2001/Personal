import java.io.*;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager  {
    public static void main(String[] args) {
        WestminsterSkinConsultationManager westmskm=new WestminsterSkinConsultationManager();
        westmskm.loadDoctors();
        westmskm.main();
    }

    // Creating Doctor ArrayList to hold 10 doctor maximum
    public static ArrayList<Doctor> doctorArrayList=new ArrayList<>(10);
    public void main() {

        //Printing the menu and get user input of what function to call
    Scanner scanner = new Scanner(System.in);
    do{

        try {
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║   Welcome to Westminster Skin Consultation ║");
            System.out.println("║                Manager                     ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║   1. Add a new doctor                [1]   ║");
            System.out.println("║   2. Delete a doctor                 [2]   ║");
            System.out.println("║   3. Print the list of doctors       [3]   ║");
            System.out.println("║   4. Save to a file                  [4]   ║");
            System.out.println("║   5. GUI                             [5]   ║");
            System.out.println("║   6. Exit                            [6]   ║");
            System.out.println("╚════════════════════════════════════════════╝");

            System.out.println("Select the option from 1-6");
            int option = scanner.nextInt();

            switch (option) {
                case 1:newDoctor();
                    break;
                case 2:deleteDoctor();
                    break;
                case 3:printDoctors();
                    break;
                case 4:saveDoctors();
                    break;
                case 5:new GUI();main();
                    break;
                case 6 :System.exit(0);
                default:
                    System.out.println("Enter a valid input");
                    main();

            }
        } catch (InputMismatchException e) {
            System.out.println("invalid. Enter a number");
            main();

        }}while(true);


    }

    /**newDoctor
     *
     * Use to enter Required details for the doctor
     *This method allows the user to enter the following details for a new doctor
     *License number (ensures it doesn't already exist in the list),Name,Surname,Date of Birth,Mobile Number,Specialization from the user
     *If the entered license number already exists in the doctorArrayList, it prompts the user to enter a different license number.
     *If the doctorArrayList reaches the maximum capacity of 10 doctors, it displays a message indicating that no more doctors can be added.
     *Once all the information is entered, a new Doctor object is created with the provided details and added to the doctorArrayList
     *
     */

    public void newDoctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the License Number:");
        String medicalLicence = scanner.nextLine();
        String medicalLicenceNumber = medicalLicence.replaceAll("\\s", "").trim();

        boolean licenseExists = false;
        for (Doctor doctor : doctorArrayList) {
            if (medicalLicenceNumber.equalsIgnoreCase(doctor.getMedicalLicenceNumber())) {
                licenseExists = true;
                break;
            }
        }

        if (licenseExists) {
            System.out.println(medicalLicenceNumber + " already exists.");
            System.out.println("Add a license number not in the list.\n");
            newDoctor();
        } else {

            if (doctorArrayList.size() >= 10) {
                System.out.println("Maximum number of doctors reached (10). Cannot add more doctors.");
                return;
            }

            System.out.println("Enter Doctor's Name:");
            String name = scanner.next();
            System.out.println("Enter Doctor's Surname:");
            String surName = scanner.next();
            System.out.println("Enter Doctor's Date Of Birth:");
            String dateOfBirth = scanner.next();
            System.out.println("Enter Doctor's Mobile Number:");
            String mobileNumber = scanner.next();
            System.out.println("Enter Doctor's Specialization:");
            String specialization = scanner.next();



            doctorArrayList.add(new Doctor(name, surName, dateOfBirth, mobileNumber, specialization, medicalLicenceNumber));
        }
    }


    /**deleteDoctor
     *
     * Deletes a doctor from the system based on their medical license number.
     *This method prompts the user to enter the medical license number of the doctor they want to delete.
     *It iterates over the doctorArrayList to find a matching doctor with the specified medical license number.
     *If a matching doctor is found, it removes the doctor from the doctorArrayList using the Iterator's remove() method.
     *The method then displays a success message indicating the removal of the doctor from the system.
     *If no doctor is found with the specified medical license number, it displays a message indicating the absence of a matching doctor.
     *The method then recursively calls itself to allow the user to enter a different medical license number.
     *After the deletion operation, the method calls the main() method to return to the main program menu.
     *
     */
    public void deleteDoctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the medical license number of the doctor you want to delete:");
        String medicalLicenceNumber = scanner.next();
        boolean found = false;

        Iterator<Doctor> iterator = doctorArrayList.iterator();
        while (iterator.hasNext()) {
            Doctor doctor = iterator.next();
            if (medicalLicenceNumber.equalsIgnoreCase(doctor.getMedicalLicenceNumber())) {
                iterator.remove();
                found = true;
                System.out.println("Doctor " + doctor.getName() + " has been successfully removed from the system.");
                break;
            }
        }

        if (!found) {
            System.out.println("No doctor found with the specified medical license number.");
            deleteDoctor();
        }

        main();
    }




    /**

     *Comparator class used to sort Doctor objects based on their surname and name in ascending order.
     *This class implements the Comparator interface and defines the compare() method to compare two Doctor objects.
     *The compare() method compares the surnames of the doctors first. If the surnames are equal (result == 0),
     *it then compares the names to determine the order.
     *The comparison is case-insensitive, ensuring that the sorting is not affected by the letter case.
     *This class is used in sorting Doctor objects in ascending order by surname and name.
     * @return Negative value if d1 should be ordered before d2,
        positive value if d1 should be ordered after d2,
        and zero if d1 and d2 are considered equal for sorting purposes.
     */
    public static class SortDoctor implements Comparator<Doctor> {
        public int compare(Doctor d1, Doctor d2) {
            int result = d1.getSurName().compareToIgnoreCase(d2.getSurName());
            if (result == 0) {
                result = d1.getName().compareToIgnoreCase(d2.getName());
            }
            return result;
        }
    }




    /** printDoctors

     *Prints the details of all doctors in the doctorArrayList.
     *This method first sorts the doctorArrayList in ascending order based on the doctors' surname and name using the SortDoctor comparator.
     *If the doctorArrayList is empty, it displays a message indicating that the doctors list is empty.
     *If there are doctors in the list, it iterates over each Doctor object in the doctorArrayList and prints their details,
      Medical license number,Specialization,NameSurname,Date of Birth,Mobile number
     *The doctor details are displayed in a formatted manner, separated by lines for better readability.
     */

    public void printDoctors() {
        Collections.sort(doctorArrayList, new SortDoctor());

        if (doctorArrayList.isEmpty()) {
            System.out.println("Doctors list is empty");
        } else {
            for (Doctor printdoctor : doctorArrayList) {
                System.out.println("Licence No: " + printdoctor.getMedicalLicenceNumber());
                System.out.println("Specialization: " + printdoctor.getSpecialisation());
                System.out.println("Doctor Name: " + printdoctor.getName());
                System.out.println("Doctor Surname: " + printdoctor.getSurName());
                System.out.println("Doctor Date Of Birth: " + printdoctor.getDateOfBirth());
                System.out.println("Doctor Mobile Number: " + printdoctor.getMobileNumber());
                System.out.println("------------------------------");
            }
        }
    }


    /** saveDoctors

     *Saves the details of all doctors in the doctorArrayList to files.
     *This method performs two operations to save the doctor details:
     *Saves the readable doctor details to a text file named "ReadableDoctors.txt".
     *The method iterates over each Doctor object in the doctorArrayList and writes their details in a readable format to the text file.
     *The details include the doctor's first name, surname, date of birth, mobile number, license number, and specialization.
     *The text file is created or overwritten if it already exists.
     *Saves the doctorArrayList object itself to a serialized file named "Doctors.txt".
     *The doctorArrayList object is serialized and written to the file using ObjectOutputStream.
     *This allows the doctorArrayList to be saved in a binary format that can be read and restored later.
     *If any I/O exception occurs during the file operations, a RuntimeException is thrown.
     *After saving the doctor details to files, the method calls the main() method to return to the main program menu.
     *Reference --> https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/ObjectInputStream.html

     */
    public void saveDoctors(){


        try{
            FileWriter fileWriter = new FileWriter("ReadableDoctors.txt");
            for(Doctor doctor : doctorArrayList){
                fileWriter.write("Doctor First name     : "+doctor.getName()+"\n"+
                        "Doctor's sur name         : "+doctor.getSurName()+"\n"+
                        "Doctor's date of birth    : "+doctor.getDateOfBirth()+"\n"+
                        "Doctor's mobile number    : "+doctor.getMobileNumber()+"\n"+
                        "Doctor's licence number   : "+doctor.getMedicalLicenceNumber()+"\n"+
                        "Doctor's specialization   : "+doctor.getSpecialisation()+"\n\n");

            }
            fileWriter.close();
            System.out.println("File ReadableDoctors.txt created and implemented doctor details successfully .");
            System.out.println("");

            FileOutputStream fileOutputStream = new FileOutputStream("Doctors.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(doctorArrayList);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        main();
    }

    /**loadDoctors
     *
     * Loads the saved doctor details from a file and populates the doctorArrayList.
     * This method attempts to load the doctor details from a file named "Doctors.txt".
     * If the file exists, it performs the following operations:
     * Creates a FileInputStream to read the raw bytes from the file.
     * Creates an ObjectInputStream to deserialize the data and objects previously written using an ObjectOutputStream.
     * Reads the serialized doctorArrayList object from the file and assigns it to the doctorArrayList variable.
     * If any exception occurs during the file reading or deserialization process, a RuntimeException is thrown.
     * It is assumed that the file "Doctors.txt" contains a serialized ArrayList<Doctor> object.
     * If the file does not exist, or an error occurs during loading, the doctorArrayList remains unchanged.
     */

    public void loadDoctors() {
        File file = new File("Doctors.txt");
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream("Doctors.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                doctorArrayList = (ArrayList<Doctor>) objectInputStream.readObject();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}











