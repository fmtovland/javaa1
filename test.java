//this will be used to test all other functions. it will not exist in the final product

package com.assignment1.search;

class test
{
	public static void main(String[] args)
	{
		int i;
		String[] mystring1=WildCards.getWildCards("killer");
		String[] mystring2=WildCards.getWildCards("birds");
		String[] mystring3=WildCards.getWildCards("places");

		for(i=0; i<6; i++)
			System.out.println(mystring1[i]+"\n"+mystring2[i]+"\n"+mystring3[i]);
	}
}
