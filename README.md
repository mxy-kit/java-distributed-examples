# Java Distributed Examples

This repository collects **five independent Java demo projects**,  
combining **object-oriented simulation** with **distributed programming**.  
It demonstrates design patterns, scripting, SOAP web services, and gRPC.

---

## 📂 Projects

### 1. Car Simulation (Basic)
A grid-based car simulation using the **Command Pattern**.  
- Car moves on a 10×12 grid (`FieldMatrix`).  
- Supports commands like `DownCommand`, `URCommand`, `ColorCommand`, `NameCommand`, `SpeedCommand`.  
- Commands can be executed directly or batched using a `Script`.  

**Concepts:** Command Pattern, OOP simulation design.  

---

### 2. Car Simulation (Scripted)
A **script-driven simulation** that loads the field from `field.txt`  
and a sequence of commands from `script.txt`.  
- Allows external configuration of car movement and attributes.  
- Demonstrates decoupling execution from code by using input files.  

**Concepts:** File-driven execution, flexible simulation control.  

---

### 3. Car Simulation (Resources)
A variant using **resource files** (`Field10x10.txt`, `script.txt`).  
- Compact loader API: `Script.load(car, reader)`.  
- Useful for quick demos with fixed grid size.  

**Concepts:** Resource-based configuration, compact scripting API.  

---

### 4. Car Server (SOAP Web Service)
A **SOAP Web Service** that exposes operations to create and control cars.  
- **Server** publishes at `http://0.0.0.0:8080/CarServer`.  
- Provides operations: `createCar`, `destroyCar`, `moveCarTo`, `setCarName`, `setCarColor`.  
- **Client** connects via WSDL (`http://127.0.0.1:8080/CarServer?wsdl`)  
  and controls cars concurrently with multiple threads.  

**Concepts:** JAX-WS web services, remote method invocation, client-server communication.  

---

### 5. gRPC Echo Client
A minimal **gRPC client** written in Java.  
- Connects to a gRPC server at `localhost:8080`.  
- Reads input from console, sends it as `EchoRequest`, receives `EchoResponse`.  
- Requires matching gRPC server and proto definition.  

**Concepts:** gRPC, protobuf, client-server communication.  

---

## 🧩 Topics Demonstrated
- Command Pattern for object actions  
- File- and resource-driven scripting  
- Object-oriented simulation  
- SOAP / JAX-WS Web Services  
- gRPC with protobuf  
- Distributed programming basics in Java  

---

## ⚙️ How to Run
Each project is **independent**.  
Go into the corresponding source folder, compile with `javac`, then run with `java`.  

Examples:

**Basic car simulation**
```bash
javac -d out -sourcepath src src/car/Main.java
java -cp out car.Main
javac -d out -sourcepath src src/server/Server.java
java -cp out server.Server
javac -cp "lib/*" -d out src/grpc/hello/EchoClient.java
java -cp "out:lib/*" grpc.hello.EchoClient
