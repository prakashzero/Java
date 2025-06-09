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
Here's a focused `README.md` covering only **String** and **static** related concepts, with definitions, usage, JVM memory details, examples, and interview-style answers:

---


 
---

## 📌 String in Java

### ✅ Ways to Create a String

```java
String s1 = "bhanu";                // String Literal – stored in String Constant Pool
String s2 = new String("bhanu");    // New Object – stored in Heap
````

* **String literals** are stored in the **String Constant Pool** for memory efficiency.
* **new String(...)** always creates a new object in the **heap**, even if an identical literal exists.

### ✅ String Pool Optimization

```java
String a = "bhanu";
String b = "bhanu";
System.out.println(a == b); // true – both refer to same literal in pool
```

✔️ **Only one object** is created if strings are identical and created using literals.

---

## 📌 Strings are Immutable

```java
String name = "Navin";
name = name + " Reddy";  // new object created
```

* A new object is created in heap, `name` now points to "Navin Reddy".
* `"Navin"` remains unchanged in the pool.
* This **immutability** improves **security**, **thread-safety**, and **memory optimization**.

---

## 📌 String Comparison

```java
String s1 = "Bhanu";
String s2 = "Bhanu";
System.out.println(s1 == s2);       // true – compares reference
System.out.println(s1.equals(s2));  // true – compares value
```

Use `.equals()` to compare content, not `==`.

---

## 📌 String Methods

```java
String s = "Bhanu";
s.charAt(0);            // returns 'B'
s.concat(" Prakash");   // returns new String: "Bhanu Prakash"
```

* Since strings are immutable, operations like `concat` return a new string.

---

## 📌 StringBuffer vs StringBuilder vs String

| Feature     | String          | StringBuffer  | StringBuilder |
| ----------- | --------------- | ------------- | ------------- |
| Mutability  | Immutable       | Mutable       | Mutable       |
| Thread-Safe | Yes (immutable) | Yes           | No            |
| Performance | Slow (new obj)  | Slower (sync) | Fast          |

```java
StringBuffer sb = new StringBuffer();
sb.append("Bhanu");
System.out.println(sb.capacity()); // Default: 16, auto-expands as needed
```

---

## 📌 static in Java

### ✅ static Variables

```java
class MyClass {
    static int count = 0;
}
```

* Shared among all instances.
* Stored in **Method Area** of JVM.
* Not tied to any object.

---

### ✅ static Methods

```java
class MyClass {
    static void greet() {
        System.out.println("Hello");
    }
}
MyClass.greet(); // Called without object
```

* Can access only static members.
* **Cannot access instance variables directly.**

---

### ✅ static Block

```java
class MyClass {
    static int x;
    static {
        x = 10;
        System.out.println("Static block runs once");
    }
}
```

* Runs once when the class is **first loaded** into memory.
* Useful for initializing static variables.

---

### ✅ Accessing Instance Data in static Methods

```java
class MyClass {
    int a = 10;
    static void printA(MyClass obj) {
        System.out.println(obj.a);
    }
}
```

* **Solution**: Pass object as parameter.

---

### ✅ Why `main` is static?

```java
public static void main(String[] args) {
    // entry point
}
```

* JVM can call it **without creating an object**.
* Required as program starts from this method.

---

## ✅ Interview-style Q\&A

| Question                                                | Answer                                                     |
| ------------------------------------------------------- | ---------------------------------------------------------- |
| Why are Strings immutable?                              | To ensure security, enable caching, and thread-safety.     |
| What is the String pool?                                | A JVM-managed memory area to store unique string literals. |
| How many objects in `String s = "a"; String s2 = "a";`? | Only one in the string pool.                               |
| When is a static block executed?                        | When the class is loaded, before `main`.                   |
| Can a static method access instance variables?          | Not directly – it needs an object reference.               |
| Why `main` must be static?                              | JVM calls it without creating object of the class.         |
| Can you overload `main`?                                | Yes, but JVM will only call the one with `String[] args`.  |

---

## ✅ Key Memory Summary (JVM)

| Memory Area | Stores                                            |
| ----------- | ------------------------------------------------- |
| Stack       | Local variables, method calls, references         |
| Heap        | All objects (including new Strings)               |
| Method Area | static variables, class-level data, constant pool |

---

## ✅ Code Snippet Summary

```java
String s = "Bhanu";         // constant pool
String s2 = new String(s);  // new object in heap

StringBuffer sb = new StringBuffer();
sb.append("Bhanu");

class Demo {
    static int value = 5;
    static {
        System.out.println("Static block");
    }
    static void print() {
        System.out.println("Static method");
    }
}
```

---

## ✅ Author

Bhanu Prakash Tugu
*Software Developer | Backend & Java Enthusiast*


---

## 📄 Source Code

See [`Basic.java`](Basic.java) for the complete working example with arrays, classes, strings, and method overloading.
