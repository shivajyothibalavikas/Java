package com.kenscio.util;

import java.io.FileReader;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class JSONParse 
{

	public static void parse(FileReader reader) 
	{
		JsonParser parser = Json.createParser(reader);
		while (parser.hasNext()) {
			switch (parser.next()) {
			case START_OBJECT:
				System.out.print("{\n");
				break;
			case END_OBJECT:
				System.out.print("\n}");
				break;
			case END_ARRAY:
				System.out.print("]");
				break;
			case VALUE_NUMBER:
				System.out.print(parser.getInt() + ",");
				break;
			case KEY_NAME:
				System.out.print(parser.getString() + ":");
				Event event = parser.next();
				if (event == Event.VALUE_TRUE) {
					System.out.print("true\n");
					break;
				} else if (event == Event.START_OBJECT) {
					System.out.print("{\n");
					break;
				} else if (event == Event.VALUE_FALSE) {
					System.out.print("false\n");
					break;
				} else if (event == Event.VALUE_STRING) {
					System.out.print(parser.getString() + "\n");
					break;
				} else if (event == Event.VALUE_NUMBER) {
					System.out.print(parser.getInt() + "\n");
					break;
				} else if (event == Event.START_ARRAY) {
					System.out.print("[");
					break;
				} else if (event == Event.END_ARRAY) {
					System.out.print("]");
					break;
				}
			default:
				break;
			}
		}
	}
}
