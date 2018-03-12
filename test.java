//this will be used to test all other functions. it will not exist in the final product

package com.assignment1.search;

import java.io.FileNotFoundException;


class test
{
	public static void main(String[] args) throws FileNotFoundException
	{
		String[] searchme={"why","art","thou","romeo"};
		int i;
		FileString[] hello={new FileString("library/kingLear.txt"),new FileString("library/romeo+juliet.txt"),new FileString("library/MerchantOfVenice.txt")};
		for(i=0; i<hello.length; i++)
		{
			SearchScore.getSearchScore(hello[i],searchme);
			System.out.println(hello[i].getPriority());
		}

		SortFileArray.sort(hello);

		for(i=0; i<hello.length; i++)
			System.out.println(hello[i].getFilename()+" "+hello[i].getPriority());
	}
}
