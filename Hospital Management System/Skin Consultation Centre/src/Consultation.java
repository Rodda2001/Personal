public class Consultation {
    private String consultationDate;
    private String consultationTime;
    private String consultationFee;
    private String consultationNote;


    public String getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(String consultationDate) {
        this.consultationDate = consultationDate;
    }

    public String getConsultationTime() {
        return consultationTime;
    }

    public void setConsultationTime(String consultationTime) {
        this.consultationTime = consultationTime;
    }

    public String getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(String consultationFee) {
        this.consultationFee = consultationFee;
    }

    public String getConsultationNote() {
        return consultationNote;
    }

    public void setConsultationNote(String consultationNote) {
        this.consultationNote = consultationNote;
    }
    @Override
    public String toString() {
        return "Consultation{" +
                "consultationDate='" + consultationDate + '\'' +
                ", consultationTime='" + consultationTime + '\'' +
                ", consultationFee='" + consultationFee + '\'' +
                ", consultationNote='" + consultationNote + '\'' +
                '}';
    }
}
