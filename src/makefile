# Last Updated 11-4-19

# Dependencies Path
PATH_TO_FX_LINUX = "dependencies/javafx-13-sdk_new/lib"
PATH_TO_FX_WIN = "dependencies/javafx-sdk-11.0.2_WIN/lib"
PATH_TO_GSON = "dependencies/gson/gson-2.8.6.jar"

JC = javac
MODULES = ALL-MODULE-PATH
JFLAGS = --module-path $(PATH_TO_FX_LINUX) --add-modules $(MODULES)

# Source Pathss
MODULES_PATH = modules
MANAGER_PATH = manager
CONTROLLERS_PATH = controllers

dirs = $(SRC_PATH) $(MODULES_PATH) $(MANAGER_PATH)
SOURCES := $(foreach dir, $(dirs),$(shell find $(SOURCEDIR) -name '*.j'))

all: Main

run: 
	java $(JFLAGS) Main 

Main: KioskManager
	$(JC) $(JFLAGS) Main.java

KioskManager: Module KioskSettings AdminPortalListener Controllers
	$(JC) $(JFLAGS) $(MANAGER_PATH)/KioskManager.java

Controllers :
	$(JC) $(JFLAGS) $(CONTROLLERS_PATH)/*.java

AdminPortalListener: 
	$(JC) -cp $(PATH_TO_GSON) $(MANAGER_PATH)/AdminPortalListener.java

KioskSettings:
	$(JC) $(MANAGER_PATH)/KioskSettings.java

Module: Slideshow Video Schedules Map
	$(JC) $(MODULES_PATH)/Module.java 

Slideshow:
	$(JC) $(JFLAGS) $(MODULES_PATH)/Slideshow.java

Video:
	$(JC) $(JFLAGS) $(MODULES_PATH)/Video.java

Schedules:
	$(JC) $(JFLAGS) $(MODULES_PATH)/Schedules.java

Map:
	$(JC) $(JFLAGS) $(MODULES_PATH)/Map.java

clean:
	find . -type f -name '*.class' -exec rm {} +
