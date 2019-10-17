# last updated: 10/17/2019
PATH_TO_FX = "javafx-sdk-11.0.2/lib"

all: Main 

run:
	java --module-path $(PATH_TO_FX) --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.base,javafx.media,javafx.swing,javafx.web Main 

Main: KioskManager
	javac --module-path $(PATH_TO_FX) --add-modules javafx.controls,javafx.fxml,javafx.graphics,javafx.base,javafx.media,javafx.swing,javafx.web Main.java 

KioskManager: Module AdminPortalListener
	javac manager/KioskManager.java

AdminPortalListener: 
	javac manager/AdminPortalListener.java
	
Module: Slideshow Video Schedules Map 
	javac modules/Module.java

Slideshow: 
	javac modules/Slideshow.java

Video: 
	javac modules/Video.java

Schedules: 
	javac modules/Schedules.java

Map: 
	javac modules/Map.java

clean:
	find . -type f -name '*.class' -exec rm {} +
