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
		int len;		//length of wildcard
		len=wildcard.length();

		if(wildcard.substring(len-2,len).equals("ed"))
			return wildcard.substring(0,len-2);
		else
			return wildcard;
	}
}
