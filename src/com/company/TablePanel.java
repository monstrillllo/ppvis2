package com.company;

import javax.swing.*;
import java.util.List;

public class TablePanel extends JPanel {
    DataController DC;

    JTable table;
    JPanel controlPane;
    JLabel count;
    JLabel page;

    int left;
    int right;
    int pageCounter;

    TablePanel(DataController DC){
        this.DC = DC;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        table = new JTable(10,5);

        makeControlButtons();
        createLabels();
        add(table);
        add(controlPane);
    }

    public void createLabels(){
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));

        JLabel name = new JLabel("name");
        JLabel account = new JLabel("account");
        JLabel address = new JLabel("address");
        JLabel mob_phone = new JLabel("mob");
        JLabel home_phone = new JLabel("home");

        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(name);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(account);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(address);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(mob_phone);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(home_phone);
        labelPanel.add(Box.createHorizontalGlue());

        add(labelPanel);
    }

    void makeControlButtons(){
        left = 1;
        right = 10;
        pageCounter = 1;

        controlPane = new JPanel();
        controlPane.setLayout(new BoxLayout(controlPane, BoxLayout.LINE_AXIS));
        count = new JLabel("Students " + left + " - " + right);
        page = new JLabel("Page: " + pageCounter);

        JButton nextPage = new JButton("Next");
        nextPage.addActionListener(actionEvent -> {
            if(DC.isExists(right+1)) {
                left += 10;
                right += 10;
                pageCounter++;
                count.setText("Students " + left + " - " + right);
                page.setText("Page: " + pageCounter);
                showTable(DC);
            }
        });

        JButton prevPage = new JButton("Previous");
        prevPage.addActionListener(actionEvent -> {
            if(pageCounter > 1) {
                left -= 10;
                right -= 10;
                pageCounter--;
                count.setText("Students " + left + " - " + right);
                page.setText("Page: " + pageCounter);
                showTable(DC);
            }
        });

        controlPane.add(count);
        controlPane.add(Box.createHorizontalGlue());
        controlPane.add(page);
        controlPane.add(Box.createHorizontalGlue());
        controlPane.add(prevPage);
        controlPane.add(nextPage);
    }

    private void addStudent(int row, MyData student){
        table.setValueAt(student.getName(), row, 0);
        table.setValueAt(student.getAccount(), row, 1);
        table.setValueAt(student.getAddress(), row, 2);
        table.setValueAt(student.getMob_Phone(), row, 3);
        table.setValueAt(student.getHome_phone(), row, 4);
    }

    private void addEmpty(int row){
        table.setValueAt(" ", row, 0);
        table.setValueAt(" ", row, 1);
        table.setValueAt(" ", row, 2);
        table.setValueAt(" ", row, 3);
        table.setValueAt(" ", row, 4);
    }

    public void setStudents(DataController data){
        DC = data;
    }
    
    public  void showTable(DataController DC){
        int index = 0;
        for(int i = left-1; i < right; i++){
            if(DC.isExists(i)) {
                addStudent(index, DC.atIndex(i));
            }else{
                addEmpty(index);
            }
            index++;
        }
    }
}
