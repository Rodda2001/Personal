import java.io.Serializable;

public class Doctor extends Person implements Serializable {
    private String medicalLicenceNumber;
    private String specialisation;


    public Doctor(String name, String surName, String dateOfBirth, String mobileNumber, String specialisation, String medicalLicenceNumber) {
        super(name, surName, dateOfBirth, mobileNumber);
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialisation = specialisation;
    }

    public String getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    public void setMedicalLicenceNumber(String medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @Override
    public String toString() {
        return super.toString() + "Doctor{" +
                "medicalLicenceNumber='" + medicalLicenceNumber + '\'' +
                ", specialisation='" + specialisation + '\'' +
                '}';
    }
}
