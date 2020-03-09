package manager;

import javafx.scene.Parent;
import modules.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KioskManager {
    private final static Logger logr = Logger.getLogger(KioskManager.class.getName());
    private static final Map<String,ModuleInterface> modules = new HashMap<String, ModuleInterface>();

    private static KioskManager instance = null;
    private static ModuleInterface activeModule; //shows current module being used

    private KioskManager(){
        //Private Constructor
        initializeModules();
    }

    public static KioskManager getInstance(){
        if(instance == null){
            instance = new KioskManager();
        }
        return instance;
    }

    public HashMap<String, ModuleInterface> getModules(){
        return (HashMap<String,ModuleInterface>) modules;
    }

    private void initializeModules() {
        modules.put("slideshow", new Slideshow());
        modules.put("schedules", new Schedules());
        modules.put("polls", new Polls());
        modules.put("department", new Department());
        //modules.put("maps", new Maps());
        //modules.put("video", new Video());
        activeModule = modules.get("slideshow");
    }

    // Manages the transition between two modules at the data level
    public void transition(String moduleName){
        ModuleInterface module = modules.get(moduleName);

        if(module == null){
            logr.log(Level.SEVERE, "Requested module was not found in HashMap. String: ", moduleName);
        } else if(activeModule != module){
            activeModule.onSleep();
            module.onWake();
            activeModule = module;
        }
    }


    // *********** Getters and Setters *********** \\


    public ModuleInterface getModule(String moduleName){
        return modules.get(moduleName);
    }

    public int getModuleCount() {
        return modules.size();
    }
}