package manager;

import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modules.*;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KioskManager {

    private static KioskManager instance = null;

    private final static Logger logr = Logger.getLogger(KioskManager.class.getName());

    private static ModuleInterface activeModule; //shows current module being used
    private static final Map<String,ModuleInterface> modules = new HashMap<>();

    // Root for each module to change between scenes
    private Parent pollRoot;
    private Parent deptRoot;
    private Parent scheduleRoot;
    private Parent slideshowRoot;

    private KioskManager(){
        //Private Constructor
        initializeModules();
    }

    public static HashMap getModules(){
        return (HashMap) modules;
    }

    public static KioskManager getInstance(){
        if(instance == null){
            instance = new KioskManager();
        }
        return instance;
    }

    private static void initializeModules() {
        modules.put("slideshow", new Slideshow());
        modules.put("schedules", new Schedules());
        modules.put("polls", new Polls());
        modules.put("department", new Department());
        modules.put("maps", new Maps());
        modules.put("video", new Video());
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