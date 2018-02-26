/*
Description: Take in a string and try to remove suffix
Author: Liam McCormick
Java version:1.8.0_162_b12
*/

package com.assignment1.search;

class WildCards
{
	static String normalise(String wildcard)
	{
		int len=wildcard.length();	//length of wildcard

		if(bi(wildcard))
			return wildcard.substring(0,len-2);
		else
			return wildcard;
	}

	static boolean bi(String term)	//check if term has two letter suffix
	{
		int i;				//for for loops
		int len=term.length();		//length of wildcard
		String[] suffixes={"ed","er"};	//all know 2 letter suffixes

		for(i=0; i<suffixes.length; i++)
		{
			if(term.substring(len-2,len).equals(suffixes[i]))
				return true;
		}

		return false;

	}
}
