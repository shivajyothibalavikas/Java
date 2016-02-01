package com.kenscio.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileContent{

	public static String fetch(String FileName) throws IOException {
		File file = new File(FileName);
		String string = FileUtils.readFileToString(file);
		System.out.println("Read in: " + string);
		return string;
	}
}