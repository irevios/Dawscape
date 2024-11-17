![Logo](img/Interfaz/titulo.png)

**Dawscape** is an escape room game built with Java Swing, using the **Model-View-Controller (MVC)** design pattern. It offers an interactive and immersive experience where players solve puzzles and navigate through scenes to escape.


## Features

### **Model**
- Manages game scene data and objects discovered by the player.
- Defines random variables for each game session, ensuring unique gameplay every time.
- Supports saving, exporting, and importing game sessions for continuity.

### **View**
- Displays the game interface, presenting scenes and events to the player.
- Dynamically updates based on player actions, such as picking up objects or interacting with the environment (e.g., opening drawers or doors).

The scenes were originally designed using **SketchUp** and rendered with **Indigo Renderer**, ensuring high-quality visuals. Each image depicts a detailed scene with interactive objects.

![Interactive Drawers](img/cajonesEnAccion.gif)

### **Controller**
- Acts as a bridge between the Model and View, handling user inputs and coordinating updates between the two.


## How to Play Dawscape

### **Quick Start**
1. Ensure you have Java installed on your system. [Download Java](https://www.java.com/es/download/)
2. Download the [Dawscape.jar](Dawscape.jar) file.
3. Double-click the file to launch the game—you're ready to play!

### **Manual Setup**
1. Download all repository files.
2. Open the project in any Java IDE (e.g., Eclipse, NetBeans).
3. Ensure you import the `zip4j` library to enable game session export/import functionality.  
   [Download the `zip4j` library here](zip4j-1.3.2.jar).
4. Compile and run the project from your IDE.
