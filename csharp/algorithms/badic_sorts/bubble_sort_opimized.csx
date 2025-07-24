void BubbleSortOptimized(int[] array)
{
    int n = array.Length;
    for (int i = 0; i < n - 1; i++)
    {
        bool swapped = false;

        for (int j = 0; j < n - i - 1; j++)
        {
            if (array[j] > array[j + 1])
            {
                // Swap elements
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                swapped = true;
            }
        }

        // If no two elements were swapped in inner loop, break
        if (!swapped)
        {
            break;
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
var numbers = new int[] { 5, 1, 4, 2, 8 };

Console.WriteLine("Before sorting:");
PrintArray(numbers);

BubbleSortOptimized(numbers);

Console.WriteLine("After sorting:");
PrintArray(numbers);