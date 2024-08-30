package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField pan, aadhar;
    JComboBox religion, category, occupation, education, income;
    JRadioButton syes, sno, eyes, eno;
    JButton next;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel Religion = new JLabel("Religion:");
        Religion.setFont(new Font("Raleway", Font.BOLD, 20));
        Religion.setBounds(100, 140, 100, 30);
        add(Religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);  // Use the class-level variable
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);

        JLabel Category = new JLabel("Category:");
        Category.setFont(new Font("Raleway", Font.BOLD, 20));
        Category.setBounds(100, 190, 200, 30);
        add(Category);

        String valCategory[] = {"Open", "OBC", "SC", "NT", "ST", "Other"};
        category = new JComboBox(valCategory);  // Use the class-level variable
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);

        JLabel Income = new JLabel("Income:");
        Income.setFont(new Font("Raleway", Font.BOLD, 20));
        Income.setBounds(100, 240, 200, 30);
        add(Income);

        String incomeCategory[] = {"NULL", "<1,50,000", "<2,50,000", "<5,00,000", "upto 10,00,000"};
        income = new JComboBox(incomeCategory);  // Use the class-level variable
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);

        JLabel Educational = new JLabel("Educational");
        Educational.setFont(new Font("Raleway", Font.BOLD, 20));
        Educational.setBounds(100, 290, 200, 30);
        add(Educational);

        JLabel Qualification = new JLabel("Qualification:");
        Qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        Qualification.setBounds(100, 315, 200, 30);
        add(Qualification);

        String educationValues[] = {"10th", "12th", "UG", "PG", "Other"};
        education = new JComboBox(educationValues);  // Use the class-level variable
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.white);
        add(education);

        JLabel Occupation = new JLabel("Occupation:");
        Occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        Occupation.setBounds(100, 390, 200, 30);
        add(Occupation);

        String occupationValues[] = {"Salaried", "Self-Employed", "Business", "Retired", "Other"};
        occupation = new JComboBox(occupationValues);  // Use the class-level variable
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);

        JLabel PAN = new JLabel("PAN Number:");
        PAN.setFont(new Font("Raleway", Font.BOLD, 20));
        PAN.setBounds(100, 440, 200, 30);
        add(PAN);

        pan = new JTextField();
        pan.setFont(new Font("Releway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel Adhar = new JLabel("Adhar Number:");
        Adhar.setFont(new Font("Raleway", Font.BOLD, 20));
        Adhar.setBounds(100, 490, 200, 30);
        add(Adhar);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Releway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel Senior = new JLabel("Senior Citizen:");
        Senior.setFont(new Font("Raleway", Font.BOLD, 20));
        Senior.setBounds(100, 540, 200, 30);
        add(Senior);

        syes = new JRadioButton("YES");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.white);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        JLabel Existing = new JLabel("Existing Account:");
        Existing.setFont(new Font("Raleway", Font.BOLD, 20));
        Existing.setBounds(100, 590, 200, 30);
        add(Existing);

        eyes = new JRadioButton("YES");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.white);
        add(eno);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(eyes);
        existingGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorCitizen = null;
        if (syes.isSelected()) {
            seniorCitizen = "YES";
        } else if (sno.isSelected()) {
            seniorCitizen = "NO";
        }

        String existingAccount = null;
        if (eyes.isSelected()) {
            existingAccount = "YES";
        } else if (eno.isSelected()) {
            existingAccount = "NO";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();

        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + saadhar + "','" + seniorCitizen + "','" + existingAccount + "')";
            c.s.executeUpdate(query); 
            
            //signup3 object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
            

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo(" ");
    }
}
