/*
Program Description: Search through a file and give it a score in relationship to a search term
Author: Liam McCormick
Java version:1.8.0_162_b12
*/

package com.assignment1.search;

class SearchScore
{
	static int i,j;

	static void getSearchScore(FileString myFileString, String[] SearchTerm)
	{
		//make all search terms lowercase
		for(i=0; i<SearchTerm.length; i++)
		{
			SearchTerm[i]=SearchTerm[i].toLowerCase();
		}

		for(i=0; i<myFileString.getSizeofContents(); i++)
		{
			for(j=0; j<SearchTerm.length; j++)
			{
				if(myFileString.getContents(i).equals(SearchTerm[j]))
				{
					myFileString.incresePriority(100);
					recursiveCheck(myFileString,SearchTerm,1);
				}
			}
		}
	}

	static void recursiveCheck(FileString myFileString, String[] SearchTerm, int k)	//circle through the next few search terms, each consecutive 
	{
		if((i+k)<myFileString.getSizeofContents() && (j+k)<SearchTerm.length)	//keep from going out of bounds
		{
			if(myFileString.getContents(i+k).equals(SearchTerm[j+k]))
			{
				myFileString.incresePriority(100+(50*k));
				recursiveCheck(myFileString,SearchTerm,k+1);
			}
		}
	}
}
