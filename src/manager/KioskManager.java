package manager;

import modules.Module;

public class KioskManager {
    
    Module activeModule;
    KioskSettings mySettings;
    //Settings object - We need to determine how we want to sustain 
    //this between the two platforms

    public static void main(String[] args){       
        AdminPortalListener listener = new AdminPortalListener();
    }
}