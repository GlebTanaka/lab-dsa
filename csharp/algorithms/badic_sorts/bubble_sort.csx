void BubbleSort(int[] array)
{
    int n = array.Length;
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
        {
            if (array[j] > array[j + 1])
            {
                // Swap array[j] and array[j + 1]
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
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
var numbers = new int[] { 64, 34, 25, 12, 22, 11, 90 };

Console.WriteLine("Before sorting:");
PrintArray(numbers);

BubbleSort(numbers);

Console.WriteLine("After sorting:");
PrintArray(numbers);