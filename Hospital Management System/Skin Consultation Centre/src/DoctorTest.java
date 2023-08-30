import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoctorTest {

    @Test
    void getMedicalLicenceNumber() {
        Doctor doctor = new Doctor("Ravindu", "Herath", "09-04-2001", "0769087754", "medical", "2000");
        assertEquals("2000", doctor.getMedicalLicenceNumber());
    }

    @Test
    void setMedicalLicenceNumber() {
        Doctor doctor = new Doctor("Ravindu", "Herath", "09-04-2001", "0769087754", "medical", "2000");
        doctor.setMedicalLicenceNumber("2000");
        assertEquals("2000", doctor.getMedicalLicenceNumber());
    }

    @Test
    void getSpecialisation() {
        Doctor doctor = new Doctor("Ravindu", "Herath", "09-04-2001", "0769087754", "medical","2000");
        assertEquals("medical", doctor.getSpecialisation());
    }

    @Test
    void setSpecialisation() {
        Doctor doctor = new Doctor("Ravindu" , "Herath", "09-04-2001", "0769087754", "medical","2000");
        doctor.setSpecialisation("medical");
        assertEquals("medical", doctor.getSpecialisation());
    }
}

