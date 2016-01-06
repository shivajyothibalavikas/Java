package com.kenscio.util;

import java.io.FileReader;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class JSONParse 
{

	public static StringBuffer parse(FileReader reader) 
	{
		StringBuffer sb = new StringBuffer();
		JsonParser parser = Json.createParser(reader);
		while (parser.hasNext()) {
			switch (parser.next()) {
			case START_OBJECT:
				sb.append("{\n");
				break;
			case END_OBJECT:
				sb.append("\n}");
				break;
			case END_ARRAY:
				sb.append("]");
				break;
			case VALUE_NUMBER:
				sb.append(parser.getInt() + ",");
				break;
			case KEY_NAME:
				System.out.print(parser.getString() + ":");
				Event event = parser.next();
				if (event == Event.VALUE_TRUE) {
					sb.append("true\n");
					break;
				} else if (event == Event.START_OBJECT) {
					sb.append("{\n");
					break;
				} else if (event == Event.VALUE_FALSE) {
					sb.append("false\n");
					break;
				} else if (event == Event.VALUE_STRING) {
					sb.append(parser.getString() + "\n");
					break;
				} else if (event == Event.VALUE_NUMBER) {
					sb.append(parser.getInt() + "\n");
					break;
				} else if (event == Event.START_ARRAY) {
					sb.append("[");
					break;
				} else if (event == Event.END_ARRAY) {
					sb.append("]");
					break;
				}
			default:
				break;
			}
		}
		return sb;
	}
}
