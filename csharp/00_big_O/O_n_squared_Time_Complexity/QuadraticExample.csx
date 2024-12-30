void PrintPairs(int[] arr)
{
	for (int i = 0; i < arr.Length; i++)
	{
		for (int j = 0; j < arr.Length; j++)
		{
			Console.WriteLine($"Pair: ({arr[i]}, {arr[j]})");
		}
	}
}

int[] numbers = { 1, 2, 3, 4 };
PrintPairs(numbers);
