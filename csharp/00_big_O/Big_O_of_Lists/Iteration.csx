using System;
using System.Collections.Generic;

List<int> list = new List<int> {10, 20, 30};

foreach (int item in list) { // O(n)
	Console.WriteLine($"Item: {item}");
}
