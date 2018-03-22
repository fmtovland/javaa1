/*
Description: Load a file into memory as a String[]
Author: Liam McCormick
Java version:1.8.0_162_b12
*/

package com.assignment1.search;

import java.util.Comparator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class FileString implements Comparable<FileString>
{
	private String filename;
	private String[] contents;
	private int priority=0;		//the higher this number grows, the higher the file will appear in search results

	//constructer
	FileString(String filename)
	{
		try
		{
			String tmp="";     //hold file contents before sorting
			File file1=new File(filename);
			Scanner scan1= new Scanner(file1);
			while(scan1.hasNextLine())
				tmp=tmp+" "+scan1.nextLine();
			scan1.close();

			this.filename=filename;
			this.contents=tmp.split("\\s+");
		}

		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
	}

	//implement comparable
	public int compareTo(FileString that)
	{
		return this.priority-that.getPriority();
	}

	//setters and getters
	public void setFilename(String filename)
	{
		this.filename=filename;
	}

	public String getFilename()
	{
		return this.filename;
	}

	public String[] getContents()
	{
		return this.contents;
	}

	public String getContents(int num)	//return a word at index, as all lower case to be used with searchscore
	{
		return this.contents[num].toLowerCase();
	}

	public int getSizeofContents()
	{
		return this.contents.length;
	}

	public int getPriority()
	{
		return this.priority;
	}

	public void incresePriority(int amount)	//allow Priority to be incresed but not reduced
	{
		this.priority=this.priority+amount;
	}
}
