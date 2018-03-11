/*
Description: Take in a string and try to remove suffix
Author: Liam McCormick
Java version:1.8.0_162_b12
*/
package com.assignment1.search;

class WildCards
{
	static String[] uniSuffixes={"s"};			//1 letter suffixes
	static String[] biSuffixes={"es","ed","er"};		//2 letter suffixes
	static String[] triSuffixes={"ing","est"};		//3 letter suffixes
	//total number of suffixes
	static int sufno=uniSuffixes.length+biSuffixes.length+triSuffixes.length;

	static String normalise(String wildcard)
	{
		int len=wildcard.length();	//length of wildcard


		//check for suffixes from longest to shortest
		if(checkSuffix(wildcard,3))		//check for 3 letter suffix
			return wildcard.substring(0,len-3);
		else if(checkSuffix(wildcard,2))	//check for 2 letter suffix
			return wildcard.substring(0,len-2);
		else if(checkSuffix(wildcard,1))	//check for 1 letter suffix
			return wildcard.substring(0,len-1);
		else
			return wildcard;
	}

	static boolean checkSuffix(String term, int slen)	//check if term has $slen letter suffix
	{
		int i;					//for for loops
		int len=term.length();			//length of wildcard

		//select correct suffix list
		if(slen==1)
			for(i=0; i<uniSuffixes.length; i++)
			{
				if(term.substring(len-slen,len).equals(uniSuffixes[i]))
					return true;
			}

		else if(slen==2)
			for(i=0; i<biSuffixes.length; i++)
			{
				if(term.substring(len-slen,len).equals(biSuffixes[i]))
					return true;
			}

		else if(slen==3)
			for(i=0; i<triSuffixes.length; i++)
			{
				if(term.substring(len-slen,len).equals(triSuffixes[i]))
					return true;
			}

		return false;

	}

	static String[] getWildCards(String input)	//get a list of wildcards for a word
	{
		String[] returnable=new String[sufno];
		int i=0;	//for for loops
		int j=0;	//bookmark in output

		input=normalise(input);	//remove existing suffix

		for(i=0; i<uniSuffixes.length; i++)
		{
			returnable[j]=input+uniSuffixes[i];
			j++;
		}

		for(i=0; i<biSuffixes.length; i++)
		{
			returnable[j]=input+biSuffixes[i];
			j++;
		}

		for(i=0; i<triSuffixes.length; i++)
		{
			returnable[j]=input+triSuffixes[i];
			j++;
		}

		return returnable;
	}
}
