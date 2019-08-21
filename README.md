# ReservationGapProgram
## What is this program
This program is designed to take in a json file in a specific format and return campground availability based on a reservation start and end date. This is done by allowing the user to specify a filepath of a json file to
reference for data and a minimum gap allowed between bookings.
## How to Build And Run this Program
1. You will need to clone the project locally to a path of your choice
2. This program has a built copy and is ready to run. You will find it as an executable jar file in the root folder of this program and it is called "CabinReservation".
3. Once you have the project locally, open your cmd line on your system and navigate to the root folder (ReservationGapProgram)
4. From here, make sure that you have a json file to input. There is a test one in the root directory called "test-case". Ideally, the json file is is the same directory as the executable jar file for easy navigation in the program.
5. In the root directory, you can launch the program by typing `java -jar CabinReservation.jar`
6. The program will ask you for a filepath which will be the json file file path and for a gap in days.
7. The result will be a list of available campsites/cabins based on what was entered.
