//sort an array of FileStrings by the priority attribute from biggest to smallest.
//bubble sort is used in this case out of ease to implement.
//it could easily be switched out for merge sort or binary sort

package com.assignment1.search;

class SortFileArray
{
	static void sort(FileString[] sortme)
	{
		int i;
		FileString tmp;
		boolean complete=false;

		while(!complete)
		{
			complete=true;
			for(i=0; i<(sortme.length-1); i++)
			{
				if(sortme[i].getPriority()<sortme[i+1].getPriority())
				{
					complete=false;
					tmp=sortme[i];
					sortme[i]=sortme[i+1];
					sortme[i+1]=tmp;
				}
			}
		}

	}
}
