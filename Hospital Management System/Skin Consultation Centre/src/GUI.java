import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class GUI extends JFrame {

    // Create a arraylist to hold Patients
    public static ArrayList<Patient> patientArrayList = new ArrayList<>();

    // Calling the doctorArrayList
    public static ArrayList<Doctor> doctorArrayList = WestminsterSkinConsultationManager.doctorArrayList;

    // Create a arraylist to hold Consultation
    public static ArrayList<Consultation> consultationArrayList = new ArrayList<>();

    private JTable table;
    private DefaultTableModel tableModel;


// Crearing the GUI and Method To call GUI
    public GUI() {
        setTitle("Westminster SkinConsultation Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 750);

        // Create the label
        JLabel label = new JLabel();
        label.setText("Chanelling");
        label.setHorizontalTextPosition(JLabel.LEFT);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.TOP);

        JLabel table1 = new JLabel();
        label.setText("Doctors Table");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);

        // Create the panel for the label
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        labelPanel.add(label);

        JPanel labelPanel2 = new JPanel();
        labelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        labelPanel.add(table1);


        // Create the table model with 6 columns
        Vector<String> columnNames = new Vector<>();
        columnNames.add("License Number");
        columnNames.add("Name");
        columnNames.add("Surname");
        columnNames.add("Date of Birth");
        columnNames.add("Mobile Number");
        columnNames.add("Specialization");
        tableModel = new DefaultTableModel(columnNames, 0);

        // Create the table with the table model
        table = new JTable(tableModel);

        // Create a scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a panel to hold the table
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Create the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(labelPanel, BorderLayout.NORTH);
        mainPanel.add(table1, BorderLayout.CENTER);
        mainPanel.add(tablePanel, BorderLayout.CENTER);

        // Add the main panel to the frame
        add(mainPanel);

        // Set frame properties
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);

        // Set the icon image
        ImageIcon icon = new ImageIcon("Doctor.png");
        setIconImage(icon.getImage());

        // Load the data into the table
        loadDoctorData();
    }

    private void loadDoctorData() {
        for (Doctor doctor : doctorArrayList) {
            Vector<String> rowData = new Vector<>();
            rowData.add(doctor.getMedicalLicenceNumber());
            rowData.add(doctor.getName());
            rowData.add(doctor.getSurName());
            rowData.add(doctor.getDateOfBirth());
            rowData.add(doctor.getMobileNumber());
            rowData.add(doctor.getSpecialisation());
            tableModel.addRow(rowData);
        }
    }
}





