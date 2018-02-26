//this will be used to test all other functions. it will not exist in the final product

package com.assignment1.search;

class test
{
	public static void main(String[] args)
	{
		String mystring1=WildCards.normalise("killed");
		String mystring2=WildCards.normalise("flowers");
		String mystring3=WildCards.normalise("glasses");

		System.out.println(mystring1+"\n"+mystring2+"\n"+mystring3);
	}
}
