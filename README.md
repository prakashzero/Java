# Java Basics 

## 📌 Introduction

Java was developed by **James Gosling** (known as the *Father of Java*) and others at Sun Microsystems. It was created to solve a key problem with C/C++ in the mid-1990s — **lack of platform independence**.

### ⚠️ Problem with C/C++ (Pre-1995)

In C/C++, source code is compiled into platform-specific executable code:

```
High-Level Code (C++) ──► Compiler ──► Machine Code (Platform Dependent)
```

This meant a program had to be rewritten for every OS.

### ✅ Solution: Java's Platform Independence

Java introduced a two-step compilation model using the JVM (Java Virtual Machine):

```
Java Code ──► Compiler ──► Bytecode (.class file)
                         ↓
                    JVM (on any OS)
                         ↓
                   Machine Code
```

> This allows Java to follow **WORA** — *Write Once, Run Anywhere*.

---

## 🧱 JDK vs JRE vs JVM

| Component | Description              | Role                                                    |
| --------- | ------------------------ | ------------------------------------------------------- |
| **JDK**   | Java Development Kit     | Needed to **write and compile** Java code               |
| **JRE**   | Java Runtime Environment | Provides libraries and environment to **run** Java code |
| **JVM**   | Java Virtual Machine     | Converts **bytecode to machine code** and runs it       |

---

## 🧠 Memory Management: Stack vs Heap

### Diagram:

```
Stack (method-level)
┌────────────┐
│ main()     │──┐
│ └── ref s1 │  │
└────────────┘  ▼
             ┌─────────────┐
             │    Heap     │
             │ ┌─────────┐ │
             │ │ Student │ │ <- s1 points here
             │ └─────────┘ │
             └─────────────┘
```

* **Stack**: Stores method calls and local variables.
* **Heap**: Stores objects and instance variables.
* **Object Reference**: Stored in stack, actual object in heap.

---

## 🔤 String Memory Model in Java

### ✅ Basics

```java
String s = "Bhanu";                 // Stored in String Constant Pool
String s2 = new String("Bhanu");    // Creates a new object in heap
```

* Strings are **immutable**.
* Java reuses strings from the **String Constant Pool** to save memory.

---

### 📂 Interning & Immutability Explained

```java
String s1 = "Navin";
String s2 = "Navin";
System.out.println(s1 == s2); // true
```

* `"Navin"` is stored **once** in the String Pool.
* Both `s1` and `s2` point to **same memory address** in the constant pool.
* `==` returns `true` as both reference the **same object**.

---

### 🔄 Reassignment Behavior

```java
String name = "Navin";
name = name + " Reddy";
System.out.println(name); // Navin Reddy
```

#### What Happened:

* `"Navin"` → constant pool.
* `name` refers to `"Navin"` in stack.
* `"Reddy"` added → new object `"Navin Reddy"` created in **heap**.
* `name`'s stack reference updated to point to new heap object.

---

### 🧠 Memory Flowchart

```
Stack                        Heap
┌─────────────┐             ┌──────────────────────┐
│ name        │───┐         │ "Navin" (Pool)       │
└─────────────┘   └────▶──┐ │                      │
                          └▶"Navin Reddy" (New)    │
                            └──────────────────────┘
```

* First reference: `name → "Navin"`
* After reassignment: `name → "Navin Reddy"`

---

### 🔁 Mutable Strings

```java
StringBuffer sb = new StringBuffer("Bhanu");
sb.append(" Prakash");
System.out.println(sb); // Bhanu Prakash
```

* **StringBuffer**: Mutable and thread-safe.
* **StringBuilder**: Mutable but **not** thread-safe (faster in single-threaded environments).

#### Capacity Example:

```java
StringBuffer sb = new StringBuffer();
System.out.println(sb.capacity()); // 16
sb.append("Bhanu Prakash");
System.out.println(sb.capacity()); // Grows as needed
```

---

## 🧪 Methods in Java

### Why Methods?

Each object in Java has **properties (variables)** and **behaviors (methods)**. Methods define the behavior.

### Example: Method Overloading

```java
public int MethodOverloading(int a, int b) { return a + b; }
public double MethodOverloading(double a, double b) { return a + b; }
```

> Same method name, different parameter types = **Overloading**

---

## 📚 Arrays and Memory

### Why Use Arrays?

* Store multiple values in one variable.
* Replace redundant variables (e.g., `int a1, a2, a3` → `int[] arr`)

### Types:

* **1D Array**: `int[] nums = {1, 2, 3};`
* **2D Array**: `int[][] arr = new int[3][2];`
* **Jagged Array**: Rows with different number of columns.

### Disadvantages of Arrays:

* Fixed size
* Homogeneous (same type)
* Memory in heap is **contiguous** and can be inefficient

---

## 🎓 Custom Class: Student

```java
class Student {
  String name;
  int rollno;
  int marks;
}
```

### Object Creation and Storage:

```java
Student[] students = new Student[3];
students[0] = new Student();
```

Use of array to store multiple object references and loop over them with enhanced for-loop.

---

## ⚡ Enhanced For Loop

```java
for (Student s : students) {
    System.out.println(s.name);
}
```

Simplifies iteration for arrays and collections.

---

## 🚀 Sample Output Snippets

```java
Bhanu
4
multidimensional
random 2D numbers...
Bhanu 1 99
Prakash 2 98
Sham 3 98
Bhanu Prakash
true
created sBuffer 16
After adding the Bhanu 32
Bhanu Prakash something
```

---

## 🔍 JIT vs AOT Compilation

| Term                    | Description                                                         |
| ----------------------- | ------------------------------------------------------------------- |
| **JIT (Just-In-Time)**  | Java uses JIT at runtime to convert bytecode to native code         |
| **AOT (Ahead-of-Time)** | Compilation before runtime, used in native-image tools like GraalVM |

---

## ✅ Advantages of Java

* Platform independent (WORA)
* Strong memory management (GC, heap/stack split)
* Object-oriented
* Rich standard library
* Secure (JVM sandboxing)

## ❌ Disadvantages

* Slower than natively compiled languages like C/C++
* Memory-heavy for small applications
* Verbose syntax

---

## 📄 Source Code

See [`Basic.java`](Basic.java) for the complete working example with arrays, classes, strings, and method overloading.
