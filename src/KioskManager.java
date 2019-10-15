import view.KioskView;
import modules.Module;

public class KioskManager {
    
    Module activeModule;
    //Settings object - We need to determine how we want to sustain 
    //this between the two platforms

    public static void main(String[] args){       
        KioskView view = new KioskView();
        AdminPortalListener listner = new AdminPortalListener();
    }
}