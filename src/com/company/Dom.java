package com.company;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dom {

    String  pathTo;
    private static List<MyData> students;
    public  void setStuds(List<MyData> studs, String path){
        students = studs;
        pathTo = path;
    }

    public static List<MyData> getStudents() {
        return students;
    }


    private  Node createBookElement(Document doc, String name,
                                          String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));

        return node;
    }

    private  Node createBook(Document document, String name, int Account, String Address, long Mob_Phone, int Home_Phone) {
        Element student = document.createElement("student");

        student.appendChild(createBookElement(document, "name", name));

        student.appendChild(createBookElement(document, "Account", String.valueOf(Account)));
        student.appendChild(createBookElement(document, "Address", Address));
        student.appendChild(createBookElement(document, "Mob_Phone", String.valueOf(Mob_Phone)));
        student.appendChild(createBookElement(document, "Home_Phone", String.valueOf(Home_Phone)));
        return student;
    }

    public  void addBook(MyData student){
        students.add(student);
    }

    public  void setBooks() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElementNS("", "Students");
            document.appendChild(root);
            for (MyData st : students) {
                root.appendChild(createBook(document, st.getName(),st.getAccount(), st.getAddress(), st.getMob_Phone(),st.getHome_phone()));
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transf = null;
            try {
                transf = transformerFactory.newTransformer();
                transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transf.setOutputProperty(OutputKeys.INDENT, "yes");
                transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

                DOMSource source = new DOMSource(document);

                File myFile = new File(pathTo);

                StreamResult file = new StreamResult(myFile);

                transf.transform(source, file);
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
