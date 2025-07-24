void SelectionSort(int[] array)
{
    int n = array.Length;

    for (int i = 0; i < n - 1; i++)
    {
        int minIndex = i;

        // Find the index of the minimum element in the unsorted part
        for (int j = i + 1; j < n; j++)
        {
            if (array[j] < array[minIndex])
            {
                minIndex = j;
            }
        }

        // Swap the found minimum with the first element
        if (minIndex != i)
        {
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}

void PrintArray(int[] array)
{
    foreach (int item in array)
    {
        Console.Write(item + " ");
    }
    Console.WriteLine();
}

// Example usage
var numbers = new int[] { 64, 25, 12, 22, 11 };

Console.WriteLine("Before sorting:");
PrintArray(numbers);

SelectionSort(numbers);

Console.WriteLine("After sorting:");
PrintArray(numbers);