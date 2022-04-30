# Havel-Hakimi
The Havel-Hakimi algorithm determines whether a given degree sequence is graphical or not, i.e., whether a simple graph can be constructed from the values. The algorithm was first published by Havel in 1955, and later by Hakimi in 1962.

A useful step-by-step run-through of the algorithm trace is available to view as the accepted answer in <a href="https://math.stackexchange.com/questions/2246437/what-am-i-proving-with-the-havel-hakimi-theorem">this</a> question.

# Files
Two versions of the program are available in the repository. The original version was written in early 2019 and is available as `Havel_Hakimi.java`, while the updated code is available as two files in the HavelHakimi_2022 folder.

# Usage
Compile the code by entering the parent directory and running `javac Havel_Hakimi.java` or `javac HavelHakimi.java Main.java`. The code can then be run via `java Havel_Hakimi` or `java Main DEGREE_SEQUENCE`.

The original version of the code uses a `Scanner` to retrieve the input degree sequence, while the updated version uses a command-line argument in the format of: `n,n,n,n...etc` up until a total of 10 elements.
