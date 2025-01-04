int BinarySearch(int[] arr, int target)
{
	int left = 0;
	int right = arr.Length - 1;

	while (left <= right)
	{
		int mid = left + (right - left) / 2;
		if (arr[mid] == target)
			return mid; // Target found
		if (arr[mid] < target)
			left = mid + 1; // Search in the right half
		else
			right = mid - 1; // Search in the left half
	}
	return - 1; // Target not found
}

int[] numbers = { 1, 3, 5, 7, 9, 11, 13, 15 };
int target = 7;

int result = BinarySearch(numbers, target);

if (result != -1)
	Console.WriteLine($"Target {target} found at index {result}.");
else
	Console.WriteLine($"Target {target} not found.");

