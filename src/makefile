# last updated: 10/18/2019
PATH_TO_FX_LINUX = "javafx-sdk-11.0.2_LINUX/lib"
PATH_TO_FX_WIN = "javafx-sdk-11.0.2_WIN/lib"

all: Main 

run:
	java --module-path $(PATH_TO_FX_WIN) --add-modules javafx.controls,javafx.fxml,javafx.graphics Main 

Main: KioskManager
	javac --module-path $(PATH_TO_FX_WIN) --add-modules javafx.controls,javafx.fxml,javafx.graphics Main.java 

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
