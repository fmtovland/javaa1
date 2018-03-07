/*
Description: Load a file into memory as a String[]
Author: Liam McCormick
Java version:1.8.0_162_b12
*/

package com.assignment1.search;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class FileString
{
	private String filename;
	private String[] contents;

	FileString(String filename) throws FileNotFoundException
	{
		try
		{
			String tmp="";     //hold file contents before sorting
			File file1=new File(filename);
			Scanner scan1= new Scanner(file1);
			while(scan1.hasNextLine())
				tmp=tmp+scan1.nextLine();
			scan1.close();

			this.filename=filename;
			this.contents=tmp.split("\\s+");
		}

		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
	}
}
