# C++ DSA Playground

A minimal C++ project for practicing data structures and algorithms. Designed to work on Windows (MinGW-w64) and WSL (Ubuntu with Clang), and to be productive in CLion.

## Prerequisites

You can use CLion’s bundled CMake to get started, but having CMake and Ninja installed system-wide makes CLI builds and WSL integration smoother.

### Windows (MinGW-w64 via Scoop)

#### powershell
* Install tools

```
scoop install cmake ninja
```

* Optional, if you don't have it already:

```
scoop install mingw
scoop install gdb
```

* Verify

```
cmake --version ninja --version g++ --version gdb --version
```

Notes:
- Ensure your Scoop MinGW `bin` directory is on PATH (usually handled by Scoop).
- If you installed MinGW elsewhere, adjust PATH accordingly.

### WSL (Ubuntu with Clang)

#### bash

* Inside WSL (Ubuntu)

```
sudo apt update sudo apt install -y cmake ninja-build build-essential gdb
```

* Optional if you prefer Clang/LLDB:

```
sudo apt install -y clang lldb
```
* Verify

```
cmake --version ninja --version g++ --version # or: clang++ --version gdb --version
```

## Getting Started

Add a .gitignore (recommended). Minimal example:

```gitignore
# Build directories (CLion/CMake)
cmake-build-*/ build/ out/ bin/ lib/
# Object files and binaries
*.o *.obj *.a *.lib *.so *.dylib *.dll *.exe *.pdb
# CMake generated files
CMakeFiles/ CMakeCache.txt cmake_install.cmake Makefile compile_commands.json install_manifest.txt
# JetBrains
.idea/
# OS junk
.DS_Store Thumbs.db
```

## Project Layout

Suggested structure:

```
cpp/ CMakeLists.txt src/ main.cpp include/ (your headers) tests/ (optional: GoogleTest)
```

If you need a starter CMakeLists and main.cpp, see “Scaffold a Minimal Project” below.

## Using CLion

Create two toolchains and CMake profiles so you can build both in Windows and WSL.

1) Toolchains
- File > Settings > Build, Execution, Deployment > Toolchains
    - MinGW (Windows): point C/C++ compilers to your MinGW g++/gcc, Debugger to gdb. CMake can be Bundled or the Scoop one.
    - WSL: add a WSL toolchain and choose your Ubuntu distro. Ensure CMake, Ninja/Make, a compiler, and gdb exist inside WSL (see prerequisites).

2) CMake Profiles
- File > Settings > Build, Execution, Deployment > CMake
    - Create:
        - Debug-MinGW → Toolchain: MinGW, Build type: Debug, Generator: Ninja (optional)
        - Debug-WSL → Toolchain: WSL, Build type: Debug, Generator: Ninja (optional)

Switch profiles from the top-right profile selector and run/debug as usual.

## Building from the Command Line

### Windows (PowerShell or CMD)

#### powershell

* From project root

```
cmake -S . -B build -G "Ninja" -DCMAKE_BUILD_TYPE=Debug cmake --build build --config Debug
```
* Run (path may differ based on your target name)

```
./build/dsa
```

If you didn’t install Ninja, omit -G "Ninja" to use default Makefiles (or specify "MinGW Makefiles").

### WSL (Ubuntu bash)

#### bash

* From project root (inside WSL)

```
cmake -S . -B build -G "Ninja" -DCMAKE_BUILD_TYPE=Debug cmake --build build --config Debug ./build/dsa
```

## Enabling Sanitizers (Debug builds)

Sanitizers catch memory bugs and undefined behavior early.

Add the following to your CMakeLists.txt for Debug builds when using GCC/Clang:

cmake if (CMAKE_BUILD_TYPE STREQUAL "Debug") add_compile_options(-Wall -Wextra -Wpedantic) if (CMAKE_CXX_COMPILER_ID MATCHES "Clang|GNU") add_compile_options(-fsanitize=address,undefined) add_link_options(-fsanitize=address,undefined) endif() endif()

Note: ASan/UBSan are supported with GCC/Clang (MinGW/WSL). MSVC uses different flags.

## Scaffold a Minimal Project (optional)

Create these files to get started quickly.

CMakeLists.txt:
```cmake
cmake_minimum_required(VERSION 3.22)
project(dsa_cpp LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Debugging aids (toggle as needed)
if (CMAKE_BUILD_TYPE STREQUAL "Debug")
    add_compile_options(-Wall -Wextra -Wpedantic)
    if (CMAKE_CXX_COMPILER_ID MATCHES "Clang|GNU")
        add_compile_options(-fsanitize=address,undefined)
        add_link_options(-fsanitize=address,undefined)
    endif()
endif()

add_executable(dsa
        src/main.cpp
        src/structures/vector_based_stack.hpp
)
target_include_directories(dsa PRIVATE src)
```
src/main.cpp:

```c++
cpp #include <bits/stdc++.h> // for quick experimenting; replace with specific headers in real code 
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Try a simple DSA kata
    vector<int> a = {5, 1, 4, 2, 3};
    sort(a.begin(), a.end());
    for (int x : a) cout << x << ' ';
    cout << '\n';
    return 0;
}
```
## Testing (optional)

You can add GoogleTest as a subdirectory or via CLion’s built-in support.

Quick approach (as subproject):
- Add googletest as a submodule: `git submodule add https://github.com/google/googletest.git extern/googletest`
- In CMakeLists.txt:
  ```cmake
  add_subdirectory(extern/googletest)
  add_executable(dsa_tests tests/example_test.cpp)
  target_link_libraries(dsa_tests gtest_main)
  add_test(NAME dsa_tests COMMAND dsa_tests)
  enable_testing()
  ```
- Run tests with `ctest` or from CLion.

## Troubleshooting

- CMake not found in WSL toolchain:
    - Install it inside WSL: `sudo apt install cmake ninja-build`
- Compiler not detected in CLion:
    - Check Toolchains paths, confirm `g++ --version` works in the selected environment.
- PATH changes not seen:
    - Restart CLion or your shell after installing tools via Scoop/apt.
- ASan/UBSan linking errors:
    - Ensure you’re using GCC/Clang and building in Debug with the sanitizer flags.

## License

Choose a license (e.g., MIT) and add a LICENSE file if you plan to share your solutions publicly.