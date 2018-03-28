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
	private static String workingDir="library/";	//the folder where all files are stored
	private String filename;
	private String[] contents;
	private int priority=0;		//the higher this number grows, the higher the file will appear in search results
	private int highpoint=0;	//the point in the file that best matches the search term
	private int highscore=0;	//how many words in highpoint match

	//constructer
	FileString(String filename)
	{
		try
		{
			String tmp="";     //hold file contents before sorting
			File file1=new File(workingDir+filename);
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
		return that.getPriority()-this.getPriority();
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

	public static String getWorkingDir()
	{
		return workingDir;
	}

	public String[] getContents()
	{
		return this.contents;
	}

	public String getContents(int num)	//return a word at index, as all lower case to be used with searchscore
	{
		return this.contents[num].toLowerCase();
	}

	public String getContents(int start, int end)	//return all words between the indexes of start and end
	{
		int i;
		String returnme="";

		for(i=start; i<end; i++)
			returnme=returnme+contents[i]+" ";

		return returnme;
	}

	public String getBestLine()		//return a string somewhere around the highpoint
	{
		String returnme="";

		if(highpoint>5 && highpoint+highscore+5<contents.length)
		{
			returnme=returnme+this.getContents(highpoint-5,highpoint-1)+"<font color=\"red\">";
			returnme=returnme+this.getContents(highpoint,highpoint+highscore)+"</font>";
			returnme=returnme+this.getContents(highpoint+highscore+1,highpoint+highscore+5);
		}

		else if(highpoint>5)
		{
			returnme=returnme+this.getContents(highpoint-5,highpoint-1)+"<font color=\"red\">";
			returnme=returnme+this.getContents(highpoint,highpoint+highscore)+"</font>";
		}

		else if(highpoint+highscore+5<contents.length)
			returnme=returnme+this.getContents(highpoint,highpoint+highscore+5);

		else
			returnme=returnme+"<font color=\"red\">"+this.getContents(highpoint,highpoint+highscore)+"</font>";

		returnme=returnme+"";
		return returnme;
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

	public void setHighpoint(int highpoint)
	{
		this.highpoint=highpoint;
	}

	public int getHighpoint()
	{
		return this.highpoint;
	}

	public void setHighscore(int highscore)
	{
		this.highscore=highscore;
	}

	public int getHighscore()
	{
		return this.highscore;
	}

}
