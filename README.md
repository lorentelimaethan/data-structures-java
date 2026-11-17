# Data Structures in Java

Small Java data structures and practice exercises for learning how they work.

## Structures

- `MyHashMap`: stores key-value pairs in buckets and uses `LinkedList` to handle collisions.
- `TreeNode`: represents a binary tree and searches for a value recursively.
- `MyLinkedList`: a singly linked list with `add`, `get`, and `size`.
- `MyArray`: a resizable integer array with `add`, `get`, and `size`.

## Practice exercises

`Main.java` keeps the exercises separate from the data structure classes:

- **Hash map:** add entries and look up keys that exist or do not exist.
- **Binary tree:** search for values and compare two trees.
- **Linked list:** find the middle value, search for a value, and find a value from the end using two pointers.
- **Array:** find a value at an index, find the index of a value, and calculate the best profit from a sequence of prices.

The examples print the expected result next to the actual result.

## Run

From the repository root, run:

```bash
javac src/*.java
java -cp src Main
```
