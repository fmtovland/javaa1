//search through the library and make a record of which file contains which words

package com.assignment1.search;

import java.io.File;
import java.nio.file.Paths;

//sql stuff
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import com.mysql.jdbc.*;

class Spiderbot
{
	//a method to get a list of files to open which contain the string
	//for now it will just return all files in the library
	public static FileString[] getFiles(String[] searchterm)
	{
		int i;
		File workingDir=new File("library/");
		File[] fileList=workingDir.listFiles();
		FileString[] returnme=new FileString[fileList.length];

		for(i=0; i<fileList.length; i++)
		{
			returnme[i]=new FileString("library/"+fileList[i].getName());
		}

		return returnme;
	}

}
