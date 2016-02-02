package com.kenscio.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

public class getFileStream {
	public static InputStream getStream(List<FileItem> formItems) throws IOException
	{
		InputStream fileContent = null;
		Iterator<FileItem> iter = formItems.iterator();
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			if (!item.isFormField()) {
				fileContent = item.getInputStream();
				
			}
		}
		return fileContent;
	}
	
	public static String getFileName(List<FileItem> formItems) throws IOException
	{
		String fileName = null;
		Iterator<FileItem> iter = formItems.iterator();
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			if (!item.isFormField()) {
				fileName = FilenameUtils.getName(item.getName());
			}
		}
		return fileName;
	}
}
