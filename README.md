
# Rule Engine with Abstract Syntax Tree (AST)

This project implements a rule engine to determine user eligibility based on attributes such as age, department, income, and experience. The system uses an Abstract Syntax Tree (AST) to represent the rules and supports dynamic rule creation, combination, and evaluation.

# Table Of Content

1.Overview    
2.Design Choices  
3.Project Structure   
4.Dependencies    
5.Setup and Running       
6.Running Locally          
8.Examples    
9.Security Considerations

## Project Structure
 #### Main.java:
 Contains test cases for creating and evaluating rules.
 #### Node.java:
 Defines the structure of AST nodes used to represent rules.
 #### RuleEngine.java:
 Contains logic to parse rule strings into ASTs, combine ASTs, and evaluate rules against user data.



## Overview

The rule engine takes logical rules like the following:

```bash
 (age > 30 AND department = 'Sales') OR (salary > 50000)

```
The engine parses them into an AST and evaluates them against user-provided data. This enables dynamic rule modification and flexible evaluation based on changing inputs.

## Design Choices

### Abstract Syntax Tree (AST) Structure:      
Logical expressions are parsed into an AST for efficient rule management

### Modularity:     
Node class: Defines the structure of AST nodes.     
RuleEngine class: Manages rule parsing, AST generation, and evaluation.     
### Technology:
Java: Portability and robust support for parsing rules.     
Docker: Easy deployment.    
MySQL (Optional): Persistence for rules and user data.

## 📦 Dependencies

1. **Java Development Kit (JDK 11 or higher)**:  
   - Download JDK from the official website: [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

2. **Visual Studio Code:**:  
   - Install VS Code: [VS Code official website](https://code.visualstudio.com/)

## ⚙️ Setup and Running

### Running Locally
Clone the repository:

```bash
 git clone https://github.com/nidhihey1/Rule_engine.git
cd Rule_engine
```
### Compile the Java code:
```bash
javac src/*.java

```
 ### Run the application:
```bash
java -cp src Main

```
## 📊 Examples
### Example 1: Simple Rule Evaluation

#### 1.Rule:     
 age > 30 AND department = 'Sales'   
#### 2.User Data:
```bash
 Map<String, Object> userData = new HashMap<>();
userData.put("age", 35);
userData.put("department", "Sales");
```
#### Expected Output:    
 True
 ### Example 2: Combined Rule

#### 1.Rule:     
 (age > 30 AND department = 'Sales') AND (salary > 50000 OR experience > 5)
#### 2.User Data:
```bash
Map<String, Object> userData = new HashMap<>();
userData.put("age", 35);
userData.put("department", "Sales");
userData.put("salary", 60000);
userData.put("experience", 3);

```
#### Expected Output:    
 True
 
 
