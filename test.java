//this will be used to test all other functions. it will not exist in the final product

package com.assignment1.search;

import java.io.FileNotFoundException;


class test
{
	public static void main(String[] args) throws FileNotFoundException
	{
		int i;
		FileString hello=new FileString("test.java");
		for(i=0; i<100; i++)
			System.out.println(hello.getContents()[i]);
	}
}
