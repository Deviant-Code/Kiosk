package modules;

/* The following interface provides a framework for all modules that run on the Kiosk

Implement this interface for future module development to ensure proper integration with Administrative portal
framework and module subsystems. */

public interface ModuleInterface {

    public abstract void update() throws Exception;

    public abstract void onExit();


}