# BestTower
Author: Jiazhi Zhou

## What it does
This repository is for a tech test. The purpose of the functions are to get a list of files and 
find the best average RSSI (Received signal strength indicator) from all the files for a given Farm. 
The farm ID would be provided when trying to run the script and returns the ID of the best tower.

## How to run
This script is coded in Java. See below for how to run the scripts.
### Depdendencies
This script uses Java 16 SDK. First run this script in the "Command Prompt" for your given systemto ensure that Java is downloaded.

`java --show-version`

If the first line of the output denotes that a Java Run-Time Environment version of at least 16 is downloaded, we can proceed!

### Run Console Application
The console application script shows a rerunnable application that has a command prompt interface. To run this, navigate to the root folder
of this repository, and run

`java -jar consoleApp.jar`

And the interface should show up.

### Running the Script directly
The script can also be ran as a java script using inline arguments. To run this, simply navigate to the root folder of this repository and run:

`java -jar functionScript.jar <FarmIDArg>`

Make sure you replace the `<FarmIdArg>` with a valid farm id without any `""` or `''` sounrounding it. This script will output the correct tower ID directly.

### Running the scripts in IDE
This is a Maven project which handles all the dependencies. Using an IDE, navigate to the root folder of this project in the IDE's add project function and import the project.
When asked about import as "Maven Project", make sure to click "yes".

The "Main" class would be the equivalent as the console application script, while running the "RunFunction" class would require Arguments be set in the run configuration of your IDE.

### Running the Unit Tests
Unit tests are in place to test the functionalities. When trying to run the tests, simply right click the test scripts and click "run". Or run all the tests by running the entire folder in the IDE.


