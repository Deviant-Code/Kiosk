# last updated: 10/17/2019

all: Main 

Main: KioskManager
	javac Main.java 

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
