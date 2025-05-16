void PrintFirstElement(int[] arr)
{
	if (arr.Length > 0)
	{
		Console.WriteLine($"First element is: {arr[0]}");
	}
	else
	{
		Console.WriteLine("Array is empty.");
	}
}

int[] numbers = { 10, 20, 30, 40, 50 };
PrintFirstElement(numbers);
