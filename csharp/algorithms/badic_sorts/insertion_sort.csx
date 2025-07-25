void InsertionSort(int[] array)
{
    int n = array.Length;

    for (int i = 1; i < n; i++)
    {
        int key = array[i];
        int j = i - 1;

        // Move elements that are greater than key to one position ahead
        while (j >= 0 && array[j] > key)
        {
            array[j + 1] = array[j];
            j--;
        }

        array[j + 1] = key;
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
var numbers = new int[] { 9, 5, 1, 4, 3 };

Console.WriteLine("Before sorting:");
PrintArray(numbers);

InsertionSort(numbers);

Console.WriteLine("After sorting:");
PrintArray(numbers);