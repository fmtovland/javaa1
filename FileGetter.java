//open all files. a drop in replacement for the intended spiderbot, which was canceled due to time management issues
package com.assignment1.search;

import java.io.File;
import java.nio.file.Paths;

class FileGetter
{
	//a method to get a list of files to open which contain the string
	public static FileString[] getFiles(String[] searchterm)
	{
		int i;
		File workingDir=new File(FileString.getWorkingDir());
		File[] fileList=workingDir.listFiles();
		FileString[] returnme=new FileString[fileList.length];

		for(i=0; i<fileList.length; i++)
		{
			returnme[i]=new FileString(fileList[i].getName());
		}

		return returnme;
	}
}
