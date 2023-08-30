public class Patient extends Person {
    private String patientID;

    public Patient(String name, String surName, String dOB, String mobileNumber, String patientID) {
        super(name,surName,dOB,mobileNumber);
        this.patientID = patientID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientID='" + patientID + '\'' +
                '}';
    }
}

