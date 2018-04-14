//a class who's singlur function is to cleanup the filestrings who fail to match the search critera
package com.assignment1.search;

class Chop
{
	static FileString[] cleanup(FileString[] cutme)
	{
		int i,j;
		int size=0;
		FileString[] returnme;

		//check how big the new array shall be
		for(i=0; i<cutme.length; i++)
			if(cutme[i].getHighpoint()>0)
				size++;

		returnme=new FileString[size];

		//clean out the zeros and shrink the array
		j=0;
		for(i=0; i<cutme.length; i++)
			if(cutme[i].getHighpoint()>0)
			{
				returnme[j]=cutme[i];
				j++;
			}

		return returnme;
	}
}
