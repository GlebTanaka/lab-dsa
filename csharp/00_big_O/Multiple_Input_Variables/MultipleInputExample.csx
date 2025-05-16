using System;
using System.Collections.Generic;

void ProcessData(int[] list1, int[] list2)
{
	// O(n^2); Pairwise comparison within list1
	for (int i = 0; i < list1.Length; i++)
	{
		for (int j = i + 1; j < list1.Length; j++)
		{
			Console.WriteLine($"Comparing {list1[i]} and {list1[j]}");
		}
	}

	// O(m): Printing elements of list2
	foreach (int num in list2)
	{
		Console.WriteLine($"Element from list2: {num}");
	}
}

int[] list1 = { 1, 2, 3 };
int[] list2 = { 10, 20, 30, 40 };
ProcessData(list1, list2);
