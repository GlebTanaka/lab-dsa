using System;
using System.Collections.Generic;

List<int> list = new List<int> {10, 20};
list.Insert(1, 20); // Adding 20 at index 1 => O(n)

Console.WriteLine($"List after addition: {string.Join(", ", list)}"); // Output: 10, 20, 30
