package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

public class Sax {
    private String name;
    private int Account;
    private String Address;
    private long Mob_Phone;
    private int Home_Phone;

    private String endEl;

    private MyData student;
    private static List<MyData> students = new ArrayList<>();

    public void parse(String fileName) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bName = false;
                boolean bAccount = false;
                boolean bAddress = false;
                boolean bMob_Phone = false;
                boolean bHome_phone = false;


                public void startElement(String uri, String localName, String queryName,
                                         Attributes attributes) throws SAXException {
                    if (queryName.equalsIgnoreCase(EValidParams.NAME.toString())) {
                        bName = true;
                    }
                    if (queryName.equalsIgnoreCase(EValidParams.ACCOUNT.toString())) {
                        bAccount = true;
                    }
                    if (queryName.equalsIgnoreCase(EValidParams.ADDRESS.toString())) {
                        bAddress = true;
                    }
                    if (queryName.equalsIgnoreCase(EValidParams.MOB_PHONE.toString())) {
                        bMob_Phone = true;
                    }
                    if (queryName.equalsIgnoreCase(EValidParams.HOME_PHONE.toString())) {
                        bHome_phone = true;
                    }
                }

                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {
                    endEl = qName;


                }

                public void characters(char[] ch, int start, int length) throws SAXException {

                    if (bName) {
                        System.out.println("name: " + new String(ch, start, length));
                        setName(new String(ch, start, length));
                        bName = false;
                    } else if (bAccount) {
                        System.out.println("account : " + new String(ch, start, length));
                        setAccount(Integer.parseInt(new String(ch, start, length)));
                        bAccount = false;
                    } else if (bAddress) {
                        System.out.println("address : " + new String(ch, start, length));
                        setAddress(new String(ch, start, length));
                        bAddress = false;
                    } else if (bMob_Phone) {
                        System.out.println("mob phone : " + new String(ch, start, length));
                        setMob_Phone(Long.parseLong(new String(ch, start, length)));
                        bMob_Phone = false;
                    } else if (bHome_phone) {
                        System.out.println("home phone : " + new String(ch, start, length));
                        setHome_Phone(Integer.parseInt(new String(ch, start, length)));
                        bHome_phone = false;
                        MyData book = new MyData();
                        book.setName(getName());
                        book.setAccount(getAccount());
                        book.setAddress(getAddress());
                        book.setMob_Phone(getMob_Phone());
                        book.setHome_phone(getHome_Phone());
                        students.add(book);
                    }

                }

            };

            saxParser.parse(fileName, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static List<MyData> getStudents() {
        return students;
    }

    public MyData getStudent() {
        return student;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccount() {
        return Account;
    }

    public void setAccount(int Account) {
        this.Account = Account;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public long getMob_Phone() {
        return Mob_Phone;
    }

    public void setMob_Phone(long Mob_Phone) {
        this.Mob_Phone = Mob_Phone;
    }

    public int getHome_Phone() {
        return Home_Phone;
    }

    public void setHome_Phone(int Home_Phone) {
        this.Home_Phone = Home_Phone;
    }
}
