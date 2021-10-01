package com.TeamEnigma.Gui;
import com.TeamEnigma.cognito.IdPassReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Button_templete extends JFrame {
    public JButton  speak, attendSheet, login,submit,resultToHome,confirmAttendance;
    public JTextField UserName;
    public Container container ;
    public JLabel display,usernamelabel,passwordlabel;
    private Font font,displayFont;
    public JPasswordField Password;
    public JDialog jDialog;


    public void frame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(450, 280, 435, 355);
        this.setResizable(false);
    }

    public void container(){
        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(new Color(128, 219, 219));
        Button_Method();
    }

    public void Button_Method(){
        font = new Font("Arial",Font.BOLD,17);
        jDialog = new JDialog();
        jDialog.setTitle("DialogBox");
        JLabel l = new JLabel("this is a dialog box");

        jDialog.add(l);
        jDialog.setSize(100, 100);
        jDialog.add(l);
        container.add(l);

        displayFont = new Font("Arial",Font.BOLD ,22 );
        display = new JLabel();
        display.setBounds(160, 28, 500, 60);
        display.setText("Welcome To Voice Recognition ");
        container.add(display);
        display.setFont(displayFont);

        speak = new JButton("Speak");
        speak.setBounds(130, 150, 93, 50);
        container.add(speak);

        login = new JButton("Log In");
        login.setBounds(390, 150, 93, 50);
        container.add(login);

        UserName = new JTextField();
        UserName.setBounds(190, 350, 300, 45);
        UserName.setFont(font);
        UserName.setVisible(false);
        container.add(UserName);

        resultToHome = new JButton("Home");
        resultToHome.setBounds(450,50,100,40);
        resultToHome.setVisible(false);
        container.add(resultToHome);

        confirmAttendance = new JButton("Confirm");
        confirmAttendance.setBounds(240,400,100,40);
        confirmAttendance.setVisible(false);
        container.add(confirmAttendance);

        Password = new JPasswordField();
        Password.setBounds(190, 415, 300, 45);
        Password.setText( "");
        Password.setVisible(false);
        container.add(Password);

        submit = new JButton("Submit");
        submit.setBounds(250, 480, 99, 51);
        submit.setVisible(false);
        container.add(submit);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id =  UserName.getText();
                String password = Password.getText();
                System.out.println(id+" "+password);

                try {
                  boolean result = IdPassReader.idPassChecker(id,password);
                    System.out.println(result);
                  if (result){
                      AfterLogin afterLogin = new AfterLogin();
                      afterLogin.setVisible(true);
                      dispose();
                  }
                  else {
                      JOptionPane.showMessageDialog(container,"Invalid ID Password");
                  }

                } catch (Exception Exception) {
                   Exception.printStackTrace();
                }

               /* AfterLogin afterLogin = new AfterLogin();
                afterLogin.setVisible(true);
                dispose();*/
            }
        });

        usernamelabel = new JLabel("User ID : ");
        usernamelabel.setBounds(50,350,80,45);
        usernamelabel.setVisible(false);
        usernamelabel.setFont(font);
        container.add(usernamelabel);


        passwordlabel = new JLabel("Password : ");
        passwordlabel.setBounds(50,415,110,45);
        passwordlabel.setVisible(false);
        passwordlabel.setFont(font);
        container.add(passwordlabel);

    }

    /*public static void main(String[] args) {
        Button_templete b = new Button_templete();
        b.setVisible(true);
    }*/

}
