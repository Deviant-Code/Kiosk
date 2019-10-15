# last updated: 10/14/2019

all: KioskManager Slideshow

KioskManager: KioskView Module
	javac KioskManager.java 

KioskView:
	javac view/KioskView.java
	
Module: 
	javac modules/Module.java

Slideshow: 
	javac modules/Slideshow.java

clean:
	find . -type f -name '*.class' -exec rm {} +
