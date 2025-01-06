using System;
using System.Collections.Generic;

List<int> list = new List<int>();
list.Add(10); // Adding at the end => O(1)
list.Add(20);

Console.WriteLine($"List after additions: {string.Join(", ", list)}"); // Output: 10, 20
