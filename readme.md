# Kiosk - Read Me

## Project Summary
Discovery Kiosk is a software system and framework with an end goal of providing the means to easily create and maintain an informational kiosk. Discovery Kiosk will be designed with a modular backbone such that all end user features are to be independent. This means developing a proper framework for this modular system to allow for future implementation beyond the scope of this project. To accompany and showcase this framework we plan to release a core module set with the initial release which will include a slideshow module, a video module, a map module, and a schedule module.

## Compiling Kiosk Application
To build and run the source code use "make all" and "make run" (inside src folder)
If on windows, be sure to change the makefile to use the windows dependency path instead of Linux
(Discovery Kiosk REQUIRES Java 8 for compilation. Later versions remove JavaFX library support)

## Running the Admin Portal Web App
To run the Node server use command "npm start" inside the 'adminportal' folder. This runs the app on  port 3000.