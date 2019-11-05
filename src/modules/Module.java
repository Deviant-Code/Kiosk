package modules;

/*
TODO:
   Determine shared methods and fields for the below modules for Module class
   Determine unique methods and fields for the below modules for child classes
   Current Modules:
       SlideShow Module
       Video Module
       Map Module
       Schedules Module */

public abstract class Module {
    public boolean enabled;

    abstract void Update();
} 