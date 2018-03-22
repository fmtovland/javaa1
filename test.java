//this will be used to test all other functions. it will not exist in the final product

package com.assignment1.search;

import java.io.File;
import java.nio.file.Paths;
import java.io.FileNotFoundException;

import java.util.Arrays;

class test
{
	public static void main(String[] args)
	{
		int i;
		File workingDir=new File("library/");
		File[] fileList=workingDir.listFiles();
		FileString[] hello=new FileString[fileList.length];

		for(i=0; i<fileList.length; i++)
		{
			hello[i]=new FileString("library/"+fileList[i].getName());
		}

		String[] searchme={"why","art","thou","romeo"};

		for(i=0; i<hello.length; i++)
		{
			SearchScore.getSearchScore(hello[i],searchme);
		}

		Arrays.sort(hello);

		for(i=0; i<hello.length; i++)
			System.out.println(hello[i].getFilename()+" "+hello[i].getPriority());
	}
}
