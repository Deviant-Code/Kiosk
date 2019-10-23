# last updated: 10/18/2019
PATH_TO_FX_LINUX = "dependencies/javafx-sdk-11.0.2_LINUX/lib"
PATH_TO_FX_WIN = "dependencies/javafx-sdk-11.0.2_WIN/lib"
PATH_TO_GSON = "dependencies/gson/gson-2.8.6.jar"

all: Main 

run:
	java --module-path $(PATH_TO_FX_LINUX) --add-modules javafx.controls,javafx.fxml,javafx.graphics Main 

Main: KioskManager
	javac --module-path $(PATH_TO_FX_LINUX) --add-modules javafx.controls,javafx.fxml,javafx.graphics Main.java MenuController.java

KioskManager: Module KioskSettings AdminPortalListener 
	javac manager/KioskManager.java

AdminPortalListener: KioskSettings
	javac -cp $(PATH_TO_GSON) manager/AdminPortalListener.java

KioskSettings:
	javac manager/KioskSettings.java
	
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
