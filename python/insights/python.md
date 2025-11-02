# Python DSA Insights

## Numeric behavior
- `/` always returns a float (double precision, 64-bit)
- `//` does floor division (rounds down, even for negatives)
- `%` gives remainder, works with both int and float

Example:
```python
45 / 6   # 7.5
45 // 6  # 7
```

### Key differences from Java

**Arbitrary precision integers:**
- Python `int` has unlimited precision (no overflow!)
- Java has fixed sizes: `int` (32-bit), `long` (64-bit)

**Floor division with negatives:**
- Python `//` always floors toward negative infinity
- Java `/` truncates toward zero
```python
# Python
-7 // 3  # -3 (floors down)
-7 % 3   # 2 (remainder has sign of divisor)

# Java
-7 / 3   # -2 (truncates toward zero)
-7 % 3   # -1 (remainder has sign of dividend)
```

**Type conversions:**
- Python automatically promotes int to float when needed
- No explicit type declarations needed
```python
# Python
x = 5      # int
x = x / 2  # now float (2.5)

# Java requires explicit types
int x = 5;
double y = x / 2.0;  # must use 2.0 or cast
```

**Useful for DSA:**
- Use `//` for array indexing: `mid = (left + right) // 2`
- To truncate toward zero (Java-style): `int(x / y)` or `math.trunc(x / y)`
- Powers: `**` operator (e.g., `2 ** 10` = 1024)
- No `++` or `--` operators; use `x += 1` or `x -= 1`
````
