using System;
using System.Collections.Generic;

List<int> list = new List<int> {10, 20};
list.Add(30); // Causes resize if capacity is exceeded => O(n)

Console.WriteLine($"List after resizing: {string.Join(", ", list)}");
