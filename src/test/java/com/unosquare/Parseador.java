package com.unosquare;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parseador {
	
static Object Parsea(String ruta) throws IOException, ParseException {	
	  JSONParser json = new JSONParser();
	  FileReader reader = new FileReader(ruta);
	  Object obj = json.parse(reader);
	  return obj;
	}
}
