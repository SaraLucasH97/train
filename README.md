TRAINSJAVASL

A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.
 
A rover’s position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.
 
In order to control a rover, NASA sends a simple string of letters. The possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ makes the rover spin 90 degrees left or right respectively, without moving from its current spot. ‘M’ means move forward one grid point, and maintain the same heading.
 
Assume that the square directly North from (x, y) is (x, y+1).
 
Input:

    The first line of input is the upper-right coordinates of the plateau, the lowerleft coordinates are assumed to be 0,0.
    The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover’s position, and the second line is a series of instructions telling the rover how to explore the plateau.
    The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover’s orientation.
    Each rover will be finished sequentially, which means that the second rover won’t start to move until the first one has finished moving.

Output: The output for each rover should be its final co-ordinates and heading.

----------------------------------------------------
Getting Started
----------------------------------------------------
PREREQUISITES
	This code has been done in Java.
	JUNIT4, Mockito are libraries for testing
	Eclipse has been used to compile the code, but another IDE to Java can be used too.
	The project is a Maven project to ease set up dependencies.

INSTALLING
	As a consequence of avoid jar file or any similar, and if you don't want to use an IDE like Eclipse, this project can be run using the next commands on cmd:
		$ train\TrainsJavaSL\src>javac material/Punto.java
		$ train\TrainsJavaSL\src>javac material/Rover.java
		$ train\TrainsJavaSL\src>javac material/Plateau.java	
		$ train\TrainsJavaSL\src>java material/Plateau train\TrainsJavaSL\input.txt
The input.txt structure has to be like in introduction. 
Some inputs and outputs for them can be:
	3 4
	0 0 N
	2 2 S
Output:
	2 2 S
	0 0 S

	0 0
	1 2 N
	MM
Output:
	java.lang.RuntimeException: Value out of bound.It has to be equal or lower than0
        at material.Plateau.main(Plateau.java:107)
	It produces an exception cause the rover has got out of the grid
CODE DECISIONS
	In this part of the file I'm going to explain some features of the code. Tests are explained in the next title.
	Plateau.java
		Attributes:
			Two ArrayLists are used to store the Rover and the corresponding orders for each one. These will be the same size assuming the input file is correct. Also, two integer variables that represent the x and y limits of the area to be explored are used.I n a first approach to the problem, the representation of the zone was thought of as a matrix.
		Methods:
			Getters and setter of the attributes and the moveRover () method. This last method goes through both lists and each Rover executes the corresponding actions. The result that will be displayed per console is stored in the initial Rover array cause during execution the action changes the object's values.			
			Main:
				In the main, the existence or not of the input file is checked using the arg array. Using the scanner class, all lines of the text file are read. When processing Rover objects, it is checked if this data is correct. Finally, even if an exception occurred, the object of the scanner class is closed.
	Rover.java
		Attributes:
			A Point object and a String that represents the orientation.
		Methods:
			turnRight () and turnLeft () are methods that change the orientation of the object either right or left and take a value that depends on the current orientation of the object. For example, turnRight () when the heading is N return heading = E.
			move () increases or decreases the x or y coordinate depending on the heading of the object.
	Punto.java
		Two attributes of integer coordinates representing the x and y axes.


JUNIT TEST
	RoverTest.java
		As a consequence of the dependence of Rover class to Punto class, its necessary to use the Mockito library to do a mock for Punto class.
		coordinateTest() 
			I don't use the mock so we use only assertThat sentences.
		moveTest()
			to verify the result is correct I use a verify sentence of the mock because it receives the new coordinate.
	PlateauTest.java
		The same as RoverTest.jave there is a dependency of classes but I decided don't use mock because there were many steps between the result and the beginning of the test.
		moveRoverTest() 
			it works with the example of the email.
		moveExceptionTest() 
			it checks that when we receive a wrong input it throws an exception.
	























	
	 
	
	