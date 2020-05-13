package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataController {

    private List<MyData> tableData;

    private boolean bName;
    private boolean bAccount;
    private boolean bPhone;

    DataController(){
        tableData = new ArrayList<MyData>();
    }

    private List<MyData> FindTemplate(String name, int Account, long Phone) {
        List<MyData> temp = new ArrayList<>();
        for (MyData tableDatum : tableData) {
            boolean bIsFits = (tableDatum.getName().equals(name) || bName)
                    && (tableDatum.getMob_Phone() == Phone || tableDatum.getHome_phone() == Phone || bPhone)
                    && (tableDatum.getAccount() == Account || bAccount);
            if(bIsFits){
                temp.add(tableDatum);
            }
        }
        return temp;
    }

    public List<MyData> FindStudents(String name, int Account, long Phone){

        bName = (name.equals(""));
        bAccount = (Account == 0);
        bPhone = (Phone == 0);

        return FindTemplate(name, Account, Phone);
    }

    public int DeleteStudents(String name, int Account, long Phone){
        bName = (name.equals(""));
        bAccount = (Account == 0);
        bPhone = (Phone == 0);

        List<MyData> temp = FindTemplate(name, Account, Phone);
        int amount = temp.size();
        tableData.removeAll(temp);
        return amount;
    }

    public void Add(MyData student){
        tableData.add(student);
    }

    public void Read(String pathToFile) throws ParserConfigurationException, SAXException, IOException {
        Sax sax = new Sax();
        sax.parse(pathToFile);
        tableData = sax.getStudents();
    }

    public void Write(String pathToFile){
        Dom dom = new Dom();
        dom.setStuds(tableData, pathToFile);
        dom.setBooks();
    }

    public MyData atIndex(int index){
        return tableData.get(index);
    }

    public boolean isExists(int index){
        return index < tableData.size();
    }

    public void setStudents(List<MyData> data){
        tableData = data;
    }
}
