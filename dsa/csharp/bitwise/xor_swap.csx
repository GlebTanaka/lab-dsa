int a = 5;
int b = 3;

// Traditional swap
Console.WriteLine($"Before traditional swap: a = {a} ({Convert.ToString(a, 2).PadLeft(4, '0')}), b = {b} ({Convert.ToString(b, 2).PadLeft(4, '0')})");
int temp = a;
a = b;
b = temp;
Console.WriteLine($"After traditional swap: a = {a} ({Convert.ToString(a, 2).PadLeft(4, '0')}), b = {b} ({Convert.ToString(b, 2).PadLeft(4, '0')})");

// Reset values
a = 5;
b = 3;

// XOR swap with binary state prints
Console.WriteLine($"\nBefore XOR swap: a = {a} ({Convert.ToString(a, 2).PadLeft(4, '0')}), b = {b} ({Convert.ToString(b, 2).PadLeft(4, '0')})");

a = a ^ b;
Console.WriteLine($"After a = a ^ b: a = {a} ({Convert.ToString(a, 2).PadLeft(4, '0')}), b = {b} ({Convert.ToString(b, 2).PadLeft(4, '0')})");

b = a ^ b;
Console.WriteLine($"After b = a ^ b: a = {a} ({Convert.ToString(a, 2).PadLeft(4, '0')}), b = {b} ({Convert.ToString(b, 2).PadLeft(4, '0')})");

a = a ^ b;
Console.WriteLine($"After a = a ^ b: a = {a} ({Convert.ToString(a, 2).PadLeft(4, '0')}), b = {b} ({Convert.ToString(b, 2).PadLeft(4, '0')})");