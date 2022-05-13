//package com.mkyong.xml.dom;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Write {

    public static void main(String[] args)
            throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("inventory");
        doc.appendChild(rootElement);
        Element item = doc.createElement("item");
        rootElement.appendChild(item);
        Element name = doc.createElement("name");
        name.setTextContent("ITEMNAME");
        item.appendChild(name);
        Element category = doc.createElement("category");
        category.setTextContent("CATEGORY");
        item.appendChild(category);
        Element price = doc.createElement("price");
        price.setTextContent("5000");
        item.appendChild(price);
        Element quantity = doc.createElement("quantity");
        quantity.setTextContent("100");
        item.appendChild(quantity);
        //writeXml(doc, System.out);

        try (FileOutputStream output = new FileOutputStream("your output here")) {
            writeXml(doc, output);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // write doc to output stream
    private static void writeXml(Document doc,
                                 OutputStream output)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        // pretty print
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }

    public static void saveInventory() {
        System.out.println("NOT FUNCTIONAL");
        System.out.println("Please press Enter!");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}