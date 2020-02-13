package manager;

import modules.Module;
import modules.Slideshow;

public class KioskManager {

    static Module activeModule;
    static Slideshow slideshow;

    public static void main(){
    }


    public static void setSS(Slideshow ss){
        slideshow = ss;
    }

    public static Slideshow getSS(){
        return slideshow;
    }


    public static void ssActive(boolean b) {
        if(b){
            activeModule = slideshow;
        } else {
            activeModule = null;
        }
    }
}