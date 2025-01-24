#load "LinkedList.csx" // Load your LinkedList class if it's in a separate file

// Test LinkedList functionality
Console.WriteLine("---- Test: LinkedList Constructor ----");
LinkedList list = new LinkedList(10);
list.PrintList();
Console.WriteLine("Length: " + list.Length); // Expected: 1
Console.WriteLine();

Console.WriteLine("---- Test: Append Method ----");
list.Append(20);
list.Append(30);
list.PrintList(); // Expected: 10 -> 20 -> 30 -> null
Console.WriteLine("Length: " + list.Length); // Expected: 3
Console.WriteLine();

Console.WriteLine("---- Test: Prepend Method ----");
list.Prepend(5);
list.PrintList(); // Expected: 5 -> 10 -> 20 -> 30 -> null
Console.WriteLine("Length: " + list.Length); // Expected: 4
Console.WriteLine();

Console.WriteLine("---- Test: GetAtIndex Method ----");
var nodeAtIndex1 = list.GetAtIndex(1);
Console.WriteLine("Data at Index 1: " + (nodeAtIndex1 != null ? nodeAtIndex1.Data.ToString() : "null")); // Expected: 10
var nodeAtInvalidIndex = list.GetAtIndex(10);
Console.WriteLine("Data at Invalid Index 10: " + (nodeAtInvalidIndex != null ? nodeAtInvalidIndex.Data.ToString() : "null")); // Expected: null
Console.WriteLine();

Console.WriteLine("---- Test: SetAtIndex Method ----");
list.SetAtIndex(1, 15);
list.PrintList(); // Expected: 5 -> 15 -> 20 -> 30 -> null
list.SetAtIndex(10, 99); // Should display "Cannot set data: Index out of bounds."
Console.WriteLine();

Console.WriteLine("---- Test: Insert Method ----");
list.Insert(2, 25); // Insert in middle
list.PrintList(); // Expected: 5 -> 15 -> 25 -> 20 -> 30 -> null
list.Insert(0, 0); // Insert at the beginning
list.PrintList(); // Expected: 0 -> 5 -> 15 -> 25 -> 20 -> 30 -> null
list.Insert(7, 35); // Insert at the end
list.PrintList(); // Expected: 0 -> 5 -> 15 -> 25 -> 20 -> 30 -> 35 -> null
list.Insert(20, 99); // Should display "Index out of bounds."
Console.WriteLine();

Console.WriteLine("---- Test: RemoveFirst Method ----");
var removedFirst = list.RemoveFirst();
Console.WriteLine("Removed Node Data: " + (removedFirst != null ? removedFirst.Data.ToString() : "null")); // Expected: 0
list.PrintList(); // Expected: 5 -> 15 -> 25 -> 20 -> 30 -> 35 -> null
Console.WriteLine("Length: " + list.Length); // Expected: 6
Console.WriteLine();

Console.WriteLine("---- Test: RemoveLast Method ----");
var removedLast = list.RemoveLast();
Console.WriteLine("Removed Node Data: " + (removedLast != null ? removedLast.Data.ToString() : "null")); // Expected: 35
list.PrintList(); // Expected: 5 -> 15 -> 25 -> 20 -> 30 -> null
Console.WriteLine("Length: " + list.Length); // Expected: 5
Console.WriteLine();

Console.WriteLine("---- Test: RemoveAtIndex Method ----");
var removedAtIndex2 = list.RemoveAtIndex(2);
Console.WriteLine("Removed Node Data at Index 2: " + (removedAtIndex2 != null ? removedAtIndex2.Data.ToString() : "null")); // Expected: 25
list.PrintList(); // Expected: 5 -> 15 -> 20 -> 30 -> null
var removedInvalidIndex = list.RemoveAtIndex(10); // Should display "Index out of bounds."
Console.WriteLine();

Console.WriteLine("---- Test: Reverse Method ----");
list.Reverse();
list.PrintList(); // Expected: 30 -> 20 -> 15 -> 5 -> null
Console.WriteLine();

Console.WriteLine("---- Test Completed ----");
