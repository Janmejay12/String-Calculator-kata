# 🚀 String Calculator - TDD Kata (Java)

This repository contains the complete implementation of the **String Calculator Kata** in **Java**, developed using a **Test-Driven Development (TDD)** approach with **JUnit 5**.

The primary goal of this project is to showcase a disciplined TDD cycle while iteratively building and refining a robust string calculator.

---

## ✨ Features Implemented

* `add(String numbers)` method that:

    * Returns `0` for an empty string
    * Handles one or more comma-separated numbers
    * Supports newline characters as valid delimiters
    * Allows custom **single-character delimiters** (e.g., `//; 1;2`)
    * Throws exceptions for **negative numbers** and reports them
    * Ignores numbers **greater than 1000** (e.g., `2,1001` → `2`)
    * Supports **custom delimiters of any length** (e.g., `//[***] 1***2***3` → `6`)
    * Supports **multiple delimiters** (e.g., `//[*][%] 1*2%3` → `6`)
    * Supports **multiple delimiters of length > 1** (e.g., `//[**][%%] 1**2%%3` → `6`)

---

## 🧪 TDD Test Flow Steps

Each feature was implemented through the Red-Green-Refactor cycle with a corresponding test. Every commit in the repository reflects one complete **TDD cycle**, embodying the "one Red-Green means one cycle" philosophy:

1. Empty string returns `0`
2. One number returns itself
3. Two numbers return their sum
4. Any number of comma-separated numbers
5. Newline character as delimiter
6. Custom delimiter: `//<delimiter>\n`
7. Exception on negative numbers
8. Ignore numbers > 1000
9. Delimiters of any length: `//[***]`
10. Multiple delimiters: `//[*][%]`
11. Multiple long delimiters: `//[**][%%]`

---

## 📁 Project Structure

* `src/main/java/StringCalculator.java` — Core calculator logic
* `src/test/java/StringCalculatorTest.java` — JUnit 5 test cases for each TDD step
* `pom.xml` — Maven configuration with JUnit 5
* `screenshots/` — TDD cycle visuals (before/after test executions)

---

## 📦 Prerequisites

* Java 8 or higher
* Maven (or IntelliJ IDEA / VS Code)

### 🛠️ Setup and Run Tests

```bash
# Clone the repository
git clone https://github.com/Janmejay12/String-Calculator-kata.git
cd String-Calculator-Kata

# Run all tests
mvn test
```

---

# 🛠 Software Craftsmanship & Code Quality

This project reflects **software craftsmanship** and **clean architecture** principles through the following highlights:

---

## ✅ Key Highlights

### 🧪 Test-Driven Development (TDD)
- Followed a **strict TDD workflow**
- Every feature was developed using **Red-Green-Refactor** cycles

### 🔁 Incremental Development
- Each commit represents a **complete TDD cycle**
- Promotes clarity, traceability, and isolated feature implementation

### ✍️ Minimal Comments
- Code is **self-explanatory** and **self-documenting**
- Clear structure eliminates the need for verbose comments

### 📐 Single Responsibility Principle (SRP)
- All classes and methods serve a **focused, singular purpose**
- Promotes modularity and easier maintenance

### 🔍 Readable and Clean Code
- Consistent naming conventions
- Clean logic with **no unnecessary duplication**

### 🧼 Refactoring Discipline
- Multiple commits are dedicated solely to **refactoring and cleanup**
- Maintains simplicity and elegance in the codebase

### 🔒 Full Test Coverage
- Edge cases like:
    - **Negative numbers**
    - **Custom delimiters**
    - **Large numerical values**
- All handled gracefully and validated via unit tests

### 📈 Evolvable & Scalable Design
- Architecture designed to be **extendable and production-ready**

---

## 📸 Screenshots of Test-Driven Development Process

### ✅ 1. Empty String Returns 0
* *Test:* `assertEquals(0, calc.add(""))`
* *Description:* Verifies empty input returns zero.  
  <img src="screenshots/Screenshot%202025-07-04%20231344.png" alt="Empty string input returns 0" width="550"/>

---

### ✅ 2. Single Integer Input
* *Test:* `assertEquals(1, calculator.add("1"))`
* *Description:* Verifies a single number returns itself.  
  <img src="screenshots/Screenshot%202025-07-04%20231702.png" alt="Empty string input returns 0" width="550"/>

---
### ✅ 3. Sum of Two Integers
* *Test:* `assertEquals(10, calc.add("1,9"))`
* *Description:* Handles two comma-separated numbers.  
  <img src="screenshots/Screenshot%202025-07-05%20011117.png" alt="Sum of two comma-separated numbers" width="550"/>
---

### ✅ 4. Sum of Multiple Integers
* *Test:* `assertEquals(15, calc.add("1,2,3,4,5"))`
* *Description:* Handles multiple comma-separated numbers.  
  <img src="screenshots/Screenshot%202025-07-05%20014134.png" alt="Sum of comma-separated numbers" width="550"/>

---

### ✅ 5. Newline as Delimiter
* *Test:* `assertEquals(15, calc.add("3\n1,5,4\n2"))`
* *Description:* Supports newline characters in addition to commas.  
  <img src="screenshots/Screenshot%202025-07-05%20144937.png" alt="Newline and comma delimiters" width="550"/>
* <img src="screenshots/Screenshot%202025-07-05%20133038.png" alt="Newline and comma delimiters" width="550"/>
*  

---

### ✅ 6. Custom Delimiters (Single Char)
* *Test:* `assertEquals(4, calc.add("//;\n3;1"))`
* *Description:* Uses single-character custom delimiter.  
  <img src="screenshots/Screenshot%202025-07-05%20144953.png" alt="Newline and comma delimiters" width="550"/>
* <img src="screenshots/Screenshot%202025-07-05%20144937.png" alt="Newline and comma delimiters" width="550"/>
---

### ✅ 7. Negative Number Check
* *Test:* `calc.add("1,-3,4,5,-6,1")`
* *Description:* Throws exception listing all negative values.  
  <img src="screenshots/Screenshot%202025-07-05%20151025.png" alt="Newline and comma delimiters" width="550"/>

---

### ✅ 8. Ignore Numbers Greater than 1000
* *Test:* `assertEquals(2, calc.add("1001,1,1"))`
* *Description:* Ignores values greater than 1000.  
  <img src="screenshots/Screenshot%202025-07-05%20160338.png" alt="Numbers >1000 are ignored" width="550"/>

---

### ✅ 9. Delimiters of Any Length
* *Test:* `assertEquals(4, calc.add("//[***]\n3***1"))`
* *Description:* Custom delimiter with multiple characters.  
  <img src="screenshots/Screenshot%202025-07-05%20164702.png" alt="Multi-character delimiter support" width="550"/>
  <img src="screenshots/Screenshot%202025-07-05%20163523.png" alt="Multiple custom single-char delimiters" width="550"/>

---

### ✅ 10. Multiple Delimiters
* *Test:* `assertEquals(6, calc.add("//[*][%]\n1*2%3"))`
* *Description:* Multiple single-character delimiters.  
  <img src="screenshots/Screenshot%202025-07-05%20163523.png" alt="Multiple custom single-char delimiters" width="550"/>
  <img src="screenshots/Screenshot%202025-07-05%20164702.png" alt="Multi-character delimiter support" width="550"/>

---

### ✅ 11. Multiple Delimiters with Length > 1
* *Test:* `assertEquals(6, calc.add("//[***][%%]\n1***2%%3"))`
* *Description:* Multiple custom delimiters of any length.  
  <img src="screenshots/Screenshot%202025-07-05%20164702.png" alt="Multi-character delimiter support" width="550"/>

---

