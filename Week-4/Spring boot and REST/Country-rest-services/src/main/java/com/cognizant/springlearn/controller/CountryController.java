package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import org.springframework.web.bind.annotation.*;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.InputStream;
import java.util.*;

@RestController
public class CountryController {

    @GetMapping("/countries")
    public List<Country> getAllCountries() {

        List<Country> countries = new ArrayList<>();

        try {
            InputStream input =
                    getClass().getClassLoader()
                    .getResourceAsStream("country.xml");

            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();

            DocumentBuilder builder =
                    factory.newDocumentBuilder();

            Document document = builder.parse(input);

            NodeList nodes =
                    document.getElementsByTagName("country");

            for(int i=0;i<nodes.getLength();i++) {

                Element element = (Element) nodes.item(i);

                String code =
                    element.getElementsByTagName("code")
                    .item(0).getTextContent();

                String name =
                    element.getElementsByTagName("name")
                    .item(0).getTextContent();

                countries.add(new Country(code,name));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return countries;
    }
}