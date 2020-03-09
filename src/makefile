# Last Updated 11-4-19

# Dependencies Path
PATH_TO_FX_LINUX = ".:dependencies/java8-dependencies/*"
PATH_TO_FX_WIN = "dependencies/javafx-sdk-13.0.2-WIN/lib"
PATH_TO_GSON = "dependencies/gson/gson-2.8.6.jar"

JC = javac
MODULES = ALL-MODULE-PATH
JFLAGS = -cp $(PATH_TO_FX_LINUX)

# Source Pathss
MODULES_PATH = modules
MANAGER_PATH = manager
CONTROLLERS_PATH = controllers
UTILITIES_PATH = utilities

dirs = $(SRC_PATH) $(MODULES_PATH) $(MANAGER_PATH)
SOURCES := $(foreach dir, $(dirs),$(shell find $(SOURCEDIR) -name '*.j'))

all: Main

run: 
	java $(JFLAGS) -Djdk.gtk.version=2 Main 

Main: 
	find -name "*.java" > sources.txt
	$(JC) $(JFLAGS) @sources.txt
	@rm sources.txt

KioskManager: Module WebView Modules KioskSettings AdminPortalListener Controllers
	$(JC) $(JFLAGS) $(MANAGER_PATH)/KioskManager.java

Controllers :
	$(JC) $(JFLAGS) $(CONTROLLERS_PATH)/*.java

AdminPortalListener: 
	$(JC) -cp $(PATH_TO_GSON) $(MANAGER_PATH)/AdminPortalListener.java

KioskSettings:
	$(JC) $(MANAGER_PATH)/KioskSettings.java

Module:
	$(JC) $(MODULES_PATH)/ModuleInterface.java

Modules: Slideshow Video Schedules Map WebView Polls Department

Slideshow:
	$(JC) $(JFLAGS) $(MODULES_PATH)/Slideshow.java

Video:
	$(JC) $(JFLAGS) $(MODULES_PATH)/Video.java

Schedules:
	$(JC) $(JFLAGS) $(MODULES_PATH)/Schedules.java

Map:
	$(JC) $(JFLAGS) $(MODULES_PATH)/Map.java

Polls:
	$(JC) $(JFLAGS) $(MODULES_PATH)/Polls.java

WebView:
	$(JC) $(JFLAGS) $(MODULES_PATH)/WebViewModule.java

Department:
	$(JC) $(JFLAGS) $(MODULES_PATH)/Department.java

clean:
	find . -type f -name '*.class' -exec rm {} +
