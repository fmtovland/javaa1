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
		int i,j;
		FileString[] hello=Spiderbot.getFiles("why art thou romeo".split("\\s+"));

		for(i=0; i<hello.length; i++)
		{
			SearchScore.getSearchScore(hello[i],"why art thou romeo");
		}

		Arrays.sort(hello);

		for(i=0; i<hello.length; i++)
		{
			System.out.println(hello[i].getFilename()+" "+hello[i].getPriority());
			System.out.println(hello[i].getContents(hello[i].getHighpoint(),hello[i].getHighpoint()+hello[i].getHighscore()));
		}
	}
}
