# Vacation Notes – Japan 🇯🇵

Taking a short break, but noting down some ideas to follow up when I’m back.

---

## 📝 Idea: Extend DSA Benchmarks with C++

Recently I added **C++** to the `dsa/` branch. To keep the benchmarks consistent across all supported languages (Java, Python, C#, and now C++), I want to extend the benchmark script.

### Steps

1. **Handle compilation for C++**
   - Unlike interpreted languages, C++ requires compilation before execution.
   - Use `g++` (or `clang++`) with optimization flags:
     ```bash
     g++ -O2 -std=c++17 cpp/algorithms/merge_sort/merge_sort.cpp -o cpp/algorithms/merge_sort/merge_sort
     ```

2. **Update the benchmark script**
   Example (pseudo-Bash flow):
   ```bash
   echo "Running Java benchmark..."
   javac java/algorithms/merge_sort/MergeSort.java
   java -cp java/algorithms/merge_sort MergeSort

   echo "Running Python benchmark..."
   python3 python/algorithms/merge_sort/merge_sort.py

   echo "Running C# benchmark..."
   dotnet run --project csharp/algorithms/merge_sort

   echo "Running C++ benchmark..."
   g++ -O2 -std=c++17 cpp/algorithms/merge_sort/merge_sort.cpp -o cpp/algorithms/merge_sort/merge_sort
   ./cpp/algorithms/merge_sort/merge_sort
   ```
3. Consistency
   - Make sure all languages use the same input data (store in data/ folder).
   - This ensures fair comparisons.

4. Optional improvements
   - Add an argument to run only one language:
  
   ```
   ./benchmark.sh cpp
   ```

   - Default: run all languages in sequence.

### 🌱 Next Steps After Vacation

- Implement the C++ benchmark integration.
- Test with existing sorting algorithms (e.g., Merge Sort).
- Add timing measurements for fair performance comparison.

## 2. DSA Repo – C++ Addition
- I recently added **C++** to the DSA repo alongside Java (`.jsh`), C# (`.csx`), and Python.  
- Unlike those languages, C++ requires **compilation before execution**.  

### Tooling decision:
- Stick with **classic `.cpp` files** + `g++` or `clang++` for compilation.  
- Add a **helper script** (Bash/PowerShell) to make running examples smoother:
  ```bash
  ./run_cpp.sh algorithms/merge_sort/merge_sort.cpp
  ```

- This keeps benchmarks realistic and performance-oriented.
- Remember to .gitignore compiled binaries (*.exe, a.out).

#### Benchmark Script Update

- Once the C++ tooling is in place, I’ll extend the benchmark script to include .cpp examples.
- Goal: unified comparison across Java, C#, Python, and C++ implementations.

#### Keep .cpp but wrap in a helper script

For consistency, you can add a wrapper (run cpp.sh or PowerShell equivalent) so that from the user perspective it feels like running a script:

```bash
#!/bin/bash
file=$1
out="${file%.cpp}"
g++ -std=c++17 -O2 "$file" -o "$out"
"./$out"
```

### Cling (C++ REPL)

- Use cling, an interactive C++ interpreter (similar to jshell / .csx).
- Allows quick testing without setting up build steps.
- Could use .cxx or .icpp files to distinguish interactive examples.
- Not as fast as compiled C++, but great for experimenting & keeping workflow consistent with other REPL-based languages.
- Example:
  ```bash
  cling myfile.cpp
  ```

- This would fit my .jsh/.csx pattern better, but tooling setup is heavier and less standard.


