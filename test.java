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
		for(i=0; i<hello.getSizeofContents(); i++)
			System.out.println(hello.getContents()[i]);
	}
}
