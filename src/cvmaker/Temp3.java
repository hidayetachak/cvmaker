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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

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
        // Create the frame
    JFrame frame = new JFrame("CV Creator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1920, 1080);
    frame.setLocationRelativeTo(null);

    // Create the main panel
    JPanel panel = new JPanel();
panel.setBackground(new Color(106, 255, 183));
    panel.setLayout(null);

    // Create the labels and fields
    int labelWidth = 120;
    int labelHeight = 25;
    int fieldWidth = 250;
    int fieldHeight = 25;
    int verticalGap = 20;
    int xPosition = 30;
    int yPosition = 30;

    JLabel nameLabel = new JLabel("Name:");
    nameLabel.setBounds(xPosition, yPosition, labelWidth, labelHeight);
    panel.add(nameLabel);

    nameField = new JTextField();
    nameField.setBounds(xPosition + labelWidth + 10, yPosition, fieldWidth, labelHeight);
    panel.add(nameField);

    yPosition += labelHeight + verticalGap;

    JLabel emailLabel = new JLabel("Email:");
    emailLabel.setBounds(xPosition, yPosition, labelWidth, labelHeight);
    panel.add(emailLabel);

    emailField = new JTextField();
    emailField.setBounds(xPosition + labelWidth + 10, yPosition, fieldWidth, labelHeight);
    panel.add(emailField);

    yPosition += labelHeight + verticalGap;

    JLabel phoneLabel = new JLabel("Phone:");
    phoneLabel.setBounds(xPosition, yPosition, labelWidth, labelHeight);
    panel.add(phoneLabel);

    phoneField = new JTextField();
    phoneField.setBounds(xPosition + labelWidth + 10, yPosition, fieldWidth, labelHeight);
    panel.add(phoneField);

    yPosition += labelHeight + verticalGap;

    JLabel experienceLabel = new JLabel("Experience:");
    experienceLabel.setBounds(xPosition, yPosition, labelWidth, labelHeight);
    panel.add(experienceLabel);

    experienceArea = new JTextArea();
    experienceArea.setBounds(xPosition + labelWidth + 10, yPosition, fieldWidth, fieldHeight);
    panel.add(experienceArea);

    yPosition += fieldHeight + verticalGap;

    JLabel educationLabel = new JLabel("Education:");
    educationLabel.setBounds(xPosition, yPosition, labelWidth, labelHeight);
    panel.add(educationLabel);

    educationArea = new JTextArea();
    educationArea.setBounds(xPosition + labelWidth + 10, yPosition, fieldWidth, fieldHeight);
    panel.add(educationArea);

    yPosition += fieldHeight + verticalGap;

    JLabel projectsLabel = new JLabel("Projects:");
    projectsLabel.setBounds(xPosition, yPosition, labelWidth, labelHeight);
    panel.add(projectsLabel);

    projectsArea = new JTextArea();
    projectsArea.setBounds(xPosition + labelWidth + 10, yPosition, fieldWidth, fieldHeight);
    panel.add(projectsArea);

    yPosition += fieldHeight + verticalGap;

    JLabel achievementsLabel = new JLabel("Achievements:");
    achievementsLabel.setBounds(xPosition, yPosition, labelWidth, labelHeight);
    panel.add(achievementsLabel);

    achievementsArea = new JTextArea();
    achievementsArea.setBounds(xPosition + labelWidth + 10, yPosition, fieldWidth, fieldHeight);
    panel.add(achievementsArea);

    yPosition += fieldHeight + verticalGap;
    JLabel publicationsLabel = new JLabel("Publications:");
    publicationsLabel.setBounds(xPosition, yPosition, labelWidth, labelHeight);
    panel.add(publicationsLabel);

     publicationsArea = new JTextArea();
    publicationsArea.setBounds(xPosition + labelWidth + 10, yPosition, fieldWidth, fieldHeight);
    panel.add(publicationsArea);

    yPosition += fieldHeight + verticalGap;

    JLabel additionalInfoLabel = new JLabel("Additional Info:");
    additionalInfoLabel.setBounds(xPosition, yPosition, labelWidth, labelHeight);
    panel.add(additionalInfoLabel);

    additionalInfoArea = new JTextArea();
    additionalInfoArea.setBounds(xPosition + labelWidth + 10, yPosition, fieldWidth, fieldHeight);
    panel.add(additionalInfoArea);

    yPosition += fieldHeight + verticalGap;

  

    // Create the buttons
    JButton pictureButton = new JButton("Choose Picture");
        pictureButton.setBounds(xPosition, yPosition, 150, labelHeight);
        pictureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choosePicture();
            }
        });
        pictureButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Custom border
        pictureButton.setBackground(Color.BLACK); // Black background
        pictureButton.setForeground(Color.WHITE); // Text color
        panel.add(pictureButton);

        JButton generateButton = new JButton("Generate CV");
        generateButton.setBounds(xPosition + 170, yPosition, 150, labelHeight);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateCV();
            }
        });
        generateButton.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2)); // Custom border
        generateButton.setBackground(Color.BLUE); // Blue background
        generateButton.setForeground(Color.WHITE); // Text color
        panel.add(generateButton);


   
    

   // Create the image label
JLabel imageLabel = new JLabel();


// Load and set the image
String imagePath = "cvimg.png"; // Provide the path to your image file
ImageIcon imageIcon = new ImageIcon(imagePath);
imageLabel.setIcon(imageIcon);

JPanel imagePanel = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon(imagePath);
        java.awt.Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }
};
imagePanel.setBounds(520, 0, 500, 700);
imagePanel.setLayout(null);

        

panel.add(imagePanel);

        


    // Add the panel to the frame
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

