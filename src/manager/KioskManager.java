package manager;

import modules.Module;
import modules.Slideshow;
import modules.Video;

public class KioskManager {

    static Module activeModule;
    static Slideshow slideshow;
    static Video video;

    public static void main(){
    }


    public static void setSS(Slideshow ss){
        slideshow = ss;
    }

    public static Video getVideo(){
        return video;
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

    public static void setVideo(Video vid) {
        video = vid;
    }
}