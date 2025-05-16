using System;
using System.Collections.Generic;

List<int> list = new List<int> {10, 20, 30};
list.RemoveAt(1); // Removes element at index 1 (20) => O(n)

Console.WriteLine($"List after removal: {string.Join(", ", list)}");
