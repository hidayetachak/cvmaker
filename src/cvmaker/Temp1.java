/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvmaker;

/**
 *
 * @author Hidayet
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Temp1 implements tempate{
    private JFrame frame;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextArea experienceArea;
    private JTextArea educationArea;
    private JTextArea projectsArea;
    private JTextArea achievementsArea;
    private JTextArea publicationsArea;
    private JTextArea additionalInfoArea;
    private JButton pictureButton;
    private String picturePath;

    public static void main(String[] args) {
        Temp1 cvCreator = new Temp1();
        cvCreator.createForm();
    }

    public void createForm() {
        frame = new JFrame("CV Creator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 10, 80, 25);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 10, 200, 25);
        panel.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 40, 80, 25);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 40, 200, 25);
        panel.add(emailField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(10, 70, 80, 25);
        panel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(100, 70, 200, 25);
        panel.add(phoneField);

        JLabel experienceLabel = new JLabel("Experience:");
        experienceLabel.setBounds(10, 100, 80, 25);
        panel.add(experienceLabel);

        experienceArea = new JTextArea();
        experienceArea.setBounds(100, 100, 200, 80);
        panel.add(experienceArea);

        JLabel educationLabel = new JLabel("Education:");
        educationLabel.setBounds(10, 190, 80, 25);
        panel.add(educationLabel);

        educationArea = new JTextArea();
        educationArea.setBounds(100, 190, 200, 80);
        panel.add(educationArea);

        JLabel projectsLabel = new JLabel("Projects:");
        projectsLabel.setBounds(10, 280, 80, 25);
        panel.add(projectsLabel);

        projectsArea = new JTextArea();
        projectsArea.setBounds(100, 280, 200, 80);
        panel.add(projectsArea);

        JLabel achievementsLabel = new JLabel("Achievements and Awards:");
        achievementsLabel.setBounds(10, 370, 150, 25);
        panel.add(achievementsLabel);
        achievementsArea = new JTextArea();
        achievementsArea.setBounds(160, 370, 200, 80);
        panel.add(achievementsArea);

        JLabel publicationsLabel = new JLabel("Publications or Research:");
        publicationsLabel.setBounds(10, 460, 150, 25);
        panel.add(publicationsLabel);

        publicationsArea = new JTextArea();
        publicationsArea.setBounds(160, 460, 200, 80);
        panel.add(publicationsArea);

        JLabel additionalInfoLabel = new JLabel("Additional Information:");
        additionalInfoLabel.setBounds(10, 550, 150, 25);
        panel.add(additionalInfoLabel);

        additionalInfoArea = new JTextArea();
        additionalInfoArea.setBounds(160, 550, 200, 80);
        panel.add(additionalInfoArea);

        pictureButton = new JButton("Choose Picture");
        pictureButton.setBounds(10, 640, 150, 25);
        pictureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choosePicture();
            }
        });
        panel.add(pictureButton);

        JButton generateButton = new JButton("Generate CV");
        generateButton.setBounds(10, 670, 150, 25);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateCV();
            }
        });
        panel.add(generateButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public void choosePicture() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            picturePath = fileChooser.getSelectedFile().getAbsolutePath();
        }
    }

    public void generateCV() {
        if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || phoneField.getText().isEmpty()
                || experienceArea.getText().isEmpty() || educationArea.getText().isEmpty()
                || projectsArea.getText().isEmpty() || achievementsArea.getText().isEmpty()
                || publicationsArea.getText().isEmpty() || additionalInfoArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
            return;
        }

        try {
            Document document = new Document();
            // Set the output file path
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        
        // Get the user's desktop path
        String desktopPath = System.getProperty("user.home") + "/Desktop/";
        
        // Create the output file path on the desktop
        String outputPath = desktopPath + "CV_" + timestamp + ".pdf";
        
        // Create a new PDF writer
        PdfWriter.getInstance(document, new FileOutputStream(outputPath));
            
            document.open();
            
            
            
            // Add Title
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24, BaseColor.BLACK);
            Paragraph title = new Paragraph("Resume", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
             // Add Picture
           if (picturePath != null && !picturePath.isEmpty()) {
            try {
                Image picture = Image.getInstance(picturePath);
                picture.scaleAbsolute(100, 100);
                picture.setAlignment(Element.ALIGN_CENTER);
                document.add(picture);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            // Add Personal Information
            Font infoFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
            Paragraph personalInfo = new Paragraph();
            personalInfo.add(new Phrase("Name: ", infoFont));
            personalInfo.add(new Phrase(nameField.getText(), infoFont));
            personalInfo.add(new Phrase("\nEmail: ", infoFont));
            personalInfo.add(new Phrase(emailField.getText(), infoFont));
            personalInfo.add(new Phrase("\nPhone: ", infoFont));
            personalInfo.add(new Phrase(phoneField.getText(), infoFont));
            personalInfo.add(new Phrase("\n\n", infoFont));
            document.add(personalInfo);

            // Add Experience
                        Font sectionFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);
            Paragraph experience = new Paragraph("Experience", sectionFont);
            experience.setSpacingAfter(10);
            document.add(experience);

            PdfPTable experienceTable = new PdfPTable(1);
            experienceTable.setWidthPercentage(100);
            PdfPCell experienceCell = new PdfPCell();
            experienceCell.setPadding(5);

            // Add Experience Details
            String experienceText = experienceArea.getText();
            Paragraph experienceDetails = new Paragraph(experienceText, infoFont);
            experienceCell.addElement(experienceDetails);
            experienceTable.addCell(experienceCell);
            document.add(experienceTable);

            // Add Education
            Paragraph education = new Paragraph("Education", sectionFont);
            education.setSpacingAfter(10);
            document.add(education);

            PdfPTable educationTable = new PdfPTable(1);
            educationTable.setWidthPercentage(100);
            PdfPCell educationCell = new PdfPCell();
            educationCell.setPadding(5);

            // Add Education Details
            String educationText = educationArea.getText();
            Paragraph educationDetails = new Paragraph(educationText, infoFont);
            educationCell.addElement(educationDetails);
            educationTable.addCell(educationCell);
            document.add(educationTable);

            // Add Projects
            Paragraph projects = new Paragraph("Projects", sectionFont);
            projects.setSpacingAfter(10);
            document.add(projects);

            PdfPTable projectsTable = new PdfPTable(1);
            projectsTable.setWidthPercentage(100);
            PdfPCell projectsCell = new PdfPCell();
            projectsCell.setPadding(5);

            // Add Projects Details
            String projectsText = projectsArea.getText();
            Paragraph projectsDetails = new Paragraph(projectsText, infoFont);
            projectsCell.addElement(projectsDetails);
            projectsTable.addCell(projectsCell);
            document.add(projectsTable);

            // Add Achievements and Awards
            Paragraph achievements = new Paragraph("Achievements and Awards", sectionFont);
            achievements.setSpacingAfter(10);
            document.add(achievements);

            PdfPTable achievementsTable = new PdfPTable(1);
            achievementsTable.setWidthPercentage(100);
            PdfPCell achievementsCell = new PdfPCell();
            achievementsCell.setPadding(5);

            // Add Achievements and Awards Details
            String achievementsText = achievementsArea.getText();
            Paragraph achievementsDetails = new Paragraph(achievementsText, infoFont);
            achievementsCell.addElement(achievementsDetails);
            achievementsTable.addCell(achievementsCell);
            document.add(achievementsTable);

            // Add Publications or Research
            Paragraph publications = new Paragraph("Publications or Research", sectionFont);
            publications.setSpacingAfter(10);
            document.add(publications);

            PdfPTable publicationsTable = new PdfPTable(1);
            publicationsTable.setWidthPercentage(100);
            PdfPCell publicationsCell = new PdfPCell();
            publicationsCell.setPadding(5);

            // Add Publications or Research Details
            String publicationsText = publicationsArea.getText();
            Paragraph publicationsDetails = new Paragraph(publicationsText, infoFont);
            publicationsCell.addElement(publicationsDetails);
            publicationsTable.addCell(publicationsCell);
            document.add(publicationsTable);

            // Add Additional Information
            Paragraph additionalInfo = new Paragraph("Additional Information", sectionFont);
            additionalInfo.setSpacingAfter(10);
            document.add(additionalInfo);

            PdfPTable additionalInfoTable = new PdfPTable(1);
            additionalInfoTable.setWidthPercentage(100);
            PdfPCell additionalInfoCell = new PdfPCell();
            additionalInfoCell.setPadding(5);

                        // Add Additional Information Details
            String additionalInfoText = additionalInfoArea.getText();
            Paragraph additionalInfoDetails = new Paragraph(additionalInfoText, infoFont);
            additionalInfoCell.addElement(additionalInfoDetails);
            additionalInfoTable.addCell(additionalInfoCell);
            document.add(additionalInfoTable);

           

            document.close();
            JOptionPane.showMessageDialog(frame, "CV generated successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Failed to generate CV.");
            e.printStackTrace();
        }
    }
}
