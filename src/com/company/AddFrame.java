package com.company;

import javax.swing.*;
import java.awt.*;

public class AddFrame extends JFrame {

    JPanel labelPanel;
    JPanel textPanel;

    DataController DC;

    JTextField name;
    JTextField Account;
    JTextField Address;
    JTextField Mob_Phone;
    JTextField Home_Phone;

    JButton add;

    AddFrame(DataController DC){
        super("Add Window");
        this.DC = DC;
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add = new JButton("Add");
        createFields();
        createLabels();

        add(labelPanel);
        add(textPanel);
        add(add);

        setSize(600, 150);
        setResizable(false);
    }

    public void createLabels(){
        labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));

        JLabel name = new JLabel("name");
        JLabel Account = new JLabel("Account");
        JLabel Address = new JLabel("Address");
        JLabel Mob_Phone = new JLabel("Mob");
        JLabel Home_Phone = new JLabel("Home");

        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(name);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(Account);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(Address);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(Mob_Phone);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(Home_Phone);
        labelPanel.add(Box.createHorizontalGlue());
    }

    public void createFields(){
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.LINE_AXIS));

        final int WIDTH = 100;
        final int HEIGHT = 20;


        name = new JTextField();
        name.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        Account = new JTextField();
        Account.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        Address = new JTextField();
        Address.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        Mob_Phone = new JTextField();
        Mob_Phone.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        Home_Phone = new JTextField();
        Home_Phone.setMaximumSize(new Dimension(WIDTH, HEIGHT));

        textPanel.add(name);
        textPanel.add(Account);
        textPanel.add(Address);
        textPanel.add(Mob_Phone);
        textPanel.add(Home_Phone);
    }

    public void addStudent(){
        String tempName = name.getText();
        int tempAccount = (Account.getText().equals("") ? 0 : Integer.parseInt(Account.getText()));
        String tempAddress = Address.getText();
        long tempMob_Phone = (Mob_Phone.getText().equals("") ? 0 : Long.parseLong(Mob_Phone.getText()));
        int tempHome_Phone = (Home_Phone.getText().equals("") ? 0 : Integer.parseInt(Home_Phone.getText()));
        DC.Add(new MyData(tempName, tempAccount, tempAddress, tempMob_Phone, tempHome_Phone));
    }

}
