/*
Program Description: Search through a file and give it a score in relationship to a search term
Author: Liam McCormick
Java version:1.8.0_162_b12
*/

package com.assignment1.search;

class SearchScore
{
	static void getSearchScore(FileString myFileString, String[] SearchTerm)
	{
		int i,j;

		for(i=0; i<myFileString.getSizeofContents(); i++)
		{
			for(j=0; j<SearchTerm.length; j++)
			{
				if(myFileString.getContents(i).equals(SearchTerm[j]))
					myFileString.incresePriority(100);
			}
		}
	}
}
