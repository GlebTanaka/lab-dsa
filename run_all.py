import subprocess

commands = {
    "Java": [
        "jshell",
        "-q",
        "java/algorithms/merge_sort/benchmarkMergeSort01.jsh"
    ],
    "C#": [
        "dotnet-script",
        "csharp/algorithms/merge_sort/benchmarkMergeSort.csx"
    ],
    "Python": [
        "python",
        "python/algorithms/merge_sort/benchmark_mergesort_01.py"
    ]
}

log_file = "benchmark_results.log"

with open(log_file, "w") as log:
    for lang, cmd in commands.items():
        log.write(f"--- {lang} ---\n")
        try:
            result = subprocess.run(cmd, capture_output=True, text=True, check=True, timeout=30)
            log.write(result.stdout + "\n")
        except subprocess.CalledProcessError as e:
            log.write(f"Error running {lang}: {e}\n")
            log.write(e.stderr + "\n")

print(f"All benchmarks finished. Results saved in {log_file}")
