# last updated: 10/14/2019

all: KioskManager Slideshow Video Schedules Map 

KioskManager: KioskView Module AdminPortalListener
	javac KioskManager.java 

AdminPortalListener: 
	javac AdminPortalListener.java

KioskView:
	javac view/KioskView.java
	
Module: 
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
