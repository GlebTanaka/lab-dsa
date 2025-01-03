void ComplexMethod(int[] arr)
{
	// Nested loop: O(n^2)
	for (int i = 0; i < arr.Length; i++)
	{
		for (int j = 0; j < arr.Length; j++)
		{
			Console.WriteLine($"Processing pair ({arr[i]}, {arr[j]})");
		}
	}

	// Single loop: O(n)
	for (int k = 0; k < arr.Length; k++)
	{
		Console.WriteLine($"Processing singel element {arr[k]}");
	}
}

int [] numbers = { 1, 2, 3, 4 };
ComplexMethod(numbers); // call the method with an array
