//this will be used to test all other functions. it will not exist in the final product

package com.assignment1.search;

import java.io.FileNotFoundException;


class test
{
	public static void main(String[] args) throws FileNotFoundException
	{
		String[] searchme={"why","art","thou","romeo"};
		int i;
		FileString hello=new FileString("testdocs/romeo+juliet.txt");
		SearchScore.getSearchScore(hello,searchme);
		System.out.println(hello.getPriority());
	}
}
