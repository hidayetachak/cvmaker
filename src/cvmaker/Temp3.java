package cvmaker;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Temp3 implements tempate {
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
        Temp3 cvCreator = new Temp3();
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
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputPath));

          document.open();

// Add Picture
if (picturePath != null && !picturePath.isEmpty()) {
    try {
        Image picture = Image.getInstance(picturePath);
        picture.setAbsolutePosition(473f, 750f);
        picture.scaleAbsolute(80f, 70f);
        document.add(picture);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

// Design 1
document.add(new Paragraph(nameField.getText() + "  ", FontFactory.getFont(FontFactory.TIMES_BOLD, 32, java.awt.Font.BOLD, BaseColor.DARK_GRAY)));
document.add(new Paragraph("", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, java.awt.Font.PLAIN, BaseColor.DARK_GRAY)));
document.add(new Paragraph("", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, java.awt.Font.PLAIN, BaseColor.DARK_GRAY)));
document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
document.add(new Paragraph("CONTACT DETAILS", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, java.awt.Font.BOLD, BaseColor.DARK_GRAY)));
document.add(new Paragraph(emailField.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7, java.awt.Font.PLAIN, BaseColor.DARK_GRAY)));
document.add(new Paragraph(phoneField.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7, java.awt.Font.PLAIN, BaseColor.DARK_GRAY)));

// Design 2
document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
document.add(new Paragraph("SKILLS", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, java.awt.Font.BOLD, BaseColor.DARK_GRAY)));
document.add(new Paragraph(phoneField.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7, java.awt.Font.PLAIN, BaseColor.DARK_GRAY)));

// Design 3
document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
document.add(new Paragraph("QUALIFICATIONS", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, java.awt.Font.BOLD, BaseColor.DARK_GRAY)));
document.add(new Paragraph(phoneField.getText(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7, java.awt.Font.PLAIN, BaseColor.DARK_GRAY)));

// Design 4
document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
document.add(new Paragraph("WORK EXPERIENCE", FontFactory.getFont(FontFactory.TIMES_BOLD, 10, java.awt.Font.BOLD, BaseColor.DARK_GRAY)));
document.add(new Paragraph(experienceArea.getText() + System.lineSeparator(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7, java.awt.Font.PLAIN, BaseColor.DARK_GRAY)));

// Design 5
document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
document.add(new Paragraph("ADDITIONAL INFO", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, java.awt.Font.BOLD, BaseColor.DARK_GRAY)));
document.add(new Paragraph(additionalInfoArea.getText() + System.lineSeparator(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7, java.awt.Font.PLAIN, BaseColor.DARK_GRAY)));

// Design 6
document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
document.add(new Paragraph("PUBLICATIONS OR RESEARCH", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, java.awt.Font.BOLD, BaseColor.DARK_GRAY)));
document.add(new Paragraph(publicationsArea.getText() + System.lineSeparator(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7, java.awt.Font.PLAIN, BaseColor.DARK_GRAY)));

// Design 7
document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
document.add(new Paragraph("ACHIEVEMENTS", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, java.awt.Font.BOLD, BaseColor.DARK_GRAY)));
document.add(new Paragraph(achievementsArea.getText() + System.lineSeparator(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7, java.awt.Font.PLAIN, BaseColor.DARK_GRAY)));

// Design 8
document.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
document.add(new Paragraph("PROJECTS", FontFactory.getFont(FontFactory.TIMES_BOLD, 9, java.awt.Font.BOLD, BaseColor.DARK_GRAY)));
document.add(new Paragraph(projectsArea.getText() + System.lineSeparator(), FontFactory.getFont(FontFactory.TIMES_BOLD, 7, java.awt.Font.PLAIN, BaseColor.DARK_GRAY)));

// Adding borders
PdfContentByte canvas = writer.getDirectContent();
canvas.setLineWidth(0.5f);
canvas.setLineDash(3, 0);
canvas.rectangle(30, 20, document.getPageSize().getWidth() - 60, document.getPageSize().getHeight() - 40);
canvas.stroke();

document.close();



            JOptionPane.showMessageDialog(frame, "CV generated successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Failed to generate CV.");
            e.printStackTrace();
        }
    }
}

