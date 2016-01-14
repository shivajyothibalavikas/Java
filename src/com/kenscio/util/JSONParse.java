package com.kenscio.util;

import java.io.FileReader;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class JSONParse {

	public static StringBuffer parse(FileReader reader) {
		StringBuffer sb = new StringBuffer();
		JsonParser parser = Json.createParser(reader);
		while (parser.hasNext()) {
			JsonParser.Event event = parser.next();
			switch (event) {
			case START_ARRAY: {
				sb.append("[");
				break;
			}
			case START_OBJECT: {
				sb.append("{\n");
				break;
			}

			case END_OBJECT: {
				sb.append("\n}");
				break;
			}
			case END_ARRAY: {
				sb.append("]");
				break;
			}
			case KEY_NAME: {
				sb.append("\t"+parser.getString());
				sb.append(" = ");
				break;
			}
			case VALUE_FALSE: {
				sb.append("false"+"\n");
				break;
			}
			case VALUE_NULL: {
				sb.append("null\n");
				break;
			}
			case VALUE_NUMBER: {
				if (parser.isIntegralNumber()) {
					sb.append(parser.getInt()+"\n");
				} else {
					sb.append(parser.getBigDecimal()+"\n");
				}
				break;
			}
			case VALUE_STRING: {
				sb.append(parser.getString()+"\n");
				break;
			}
			case VALUE_TRUE: {
				sb.append("true\n");
				break;
			}
			default: {

			}
			}
		}
		return sb;
	}
}
