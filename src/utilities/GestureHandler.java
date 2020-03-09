/*
TouchHandler.java
Singleton Class

Helper class to built in JavaFX Event Handling

Latest OpenJFX does not handle TouchEvents on Linux. Touch Event handling is missing from

 */

package utilities;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.SwipeEvent;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class GestureHandler {

    //Gesture Processing
    private final BooleanProperty inMotion = new SimpleBooleanProperty();
    private final long dragTimeThreshold = 500; // Max time for a gesture before being consumed in ms
    private final double distanceThreshold = 200; // Min distance for a gesture
    private final double differenceThreshold = .25; // Percent difference between vert. and horiz. distance to be considered a swipe
    private long startTime = -1l; // Records the time a touch gesture begins

    private double startX; // Start location of gesture
    private double startY; // End location of gesturedouble horizontalShift = event.getX() - startX;

    private double horizontalShift;
    private double verticalShift;
    private double horizontalMagnitude;
    private double verticalMagnitude;

    public GestureHandler (){

    }

    public void startGesture(MouseEvent event){
        if(event.getEventType().equals(MouseEvent.DRAG_DETECTED) || event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){
            setInMotion(true);
            startTime = System.currentTimeMillis();
            startX = event.getSceneX();
            startY = event.getSceneY();
        }
    }

    private void reset() {
        setInMotion(false);
        startTime = -1l;
        startX = 0;
        startY = 0;
        horizontalShift = 0;
        verticalShift = 0;
        horizontalMagnitude = 0;
        verticalMagnitude = 0;
    }

    public boolean validate(MouseEvent event){

        long netTime = System.currentTimeMillis() - startTime;

        if(inMotion() && netTime < dragTimeThreshold && netTime != -1l){
            //User has swiped Screen and within the time threshold
            //Calculate gesture coordinates and validate swipe type
            horizontalShift = event.getSceneX() - startX;
            verticalShift = event.getSceneY() - startY;
            horizontalMagnitude = Math.abs(horizontalShift);
            verticalMagnitude = Math.abs(verticalShift);
            if(!((horizontalMagnitude < distanceThreshold && verticalMagnitude < distanceThreshold)
                    ||  Math.abs((1.0-(verticalMagnitude/horizontalMagnitude))) < differenceThreshold )){
                return true;
            }
        }
        reset();
        return false;
    }

    public EventType<SwipeEvent> processGesture(){
        EventType<SwipeEvent> swipeResult = null;
        if(horizontalMagnitude > verticalMagnitude && (horizontalMagnitude - verticalMagnitude) > differenceThreshold){
            if(horizontalShift < 0){
                //Left Swipe
                swipeResult = SwipeEvent.SWIPE_LEFT;
            } else {
                //Right Swipe
                swipeResult = SwipeEvent.SWIPE_RIGHT;
            }
        } else if((verticalMagnitude - horizontalMagnitude) > differenceThreshold){
            //Process Swipe Up or Swipe Down
            if(verticalShift < 0){
                //Swipe Up
                swipeResult = SwipeEvent.SWIPE_UP;
            } else {
                swipeResult = SwipeEvent.SWIPE_DOWN;
            }
        }
        reset();
        return swipeResult;
    }

    public final boolean inMotion(){
        return inMotion.get();
    }

    public final void setInMotion(Boolean state){
        inMotion.set(state);
    }

    public BooleanProperty inMotionProperty(){
        return inMotion;
    }
}
