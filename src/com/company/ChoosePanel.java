package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChoosePanel extends JPanel {

    private JPanel textPanel;

    private JTextField name;
    private JTextField Phone;
    private JTextField Account;

    ChoosePanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createLabels();
        createText();
    }

    private void createLabels(){
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));


        JLabel name = new JLabel("name");
        JLabel Account = new JLabel("Account");
        JLabel Phone = new JLabel("Phone");
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(name);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(Account);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(Phone);
        labelPanel.add(Box.createHorizontalGlue());

        add(labelPanel);
    }

    private void createText(){
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.LINE_AXIS));

        final int WIDTH = 100;
        final int HEIGHT = 20;

        name = new JTextField();
        name.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        name.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        Account = new JTextField();
        Account.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        Account.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        Phone = new JTextField();
        Phone.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        Phone.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        textPanel.add(name);
        textPanel.add(Account);
        textPanel.add(Phone);

        add(textPanel);
    }

    public List<String> getStudentFromFields(){
        List<String> result = new ArrayList<>();
        result.add(getfieldName());
        result.add(getAccount());
        result.add(getPhone());
        return result;
    }

    public String getfieldName() {return name.getText(); }

    public String getAccount() {return Account.getText(); }

    public String getPhone() {return Phone.getText(); }

}
