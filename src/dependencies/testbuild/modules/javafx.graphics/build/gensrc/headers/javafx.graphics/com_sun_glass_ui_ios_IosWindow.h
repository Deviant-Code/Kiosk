/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_sun_glass_ui_ios_IosWindow */

#ifndef _Included_com_sun_glass_ui_ios_IosWindow
#define _Included_com_sun_glass_ui_ios_IosWindow
#ifdef __cplusplus
extern "C" {
#endif
#undef com_sun_glass_ui_ios_IosWindow_UNTITLED
#define com_sun_glass_ui_ios_IosWindow_UNTITLED 0L
#undef com_sun_glass_ui_ios_IosWindow_TITLED
#define com_sun_glass_ui_ios_IosWindow_TITLED 1L
#undef com_sun_glass_ui_ios_IosWindow_TRANSPARENT
#define com_sun_glass_ui_ios_IosWindow_TRANSPARENT 2L
#undef com_sun_glass_ui_ios_IosWindow_NORMAL
#define com_sun_glass_ui_ios_IosWindow_NORMAL 0L
#undef com_sun_glass_ui_ios_IosWindow_UTILITY
#define com_sun_glass_ui_ios_IosWindow_UTILITY 4L
#undef com_sun_glass_ui_ios_IosWindow_POPUP
#define com_sun_glass_ui_ios_IosWindow_POPUP 8L
#undef com_sun_glass_ui_ios_IosWindow_CLOSABLE
#define com_sun_glass_ui_ios_IosWindow_CLOSABLE 16L
#undef com_sun_glass_ui_ios_IosWindow_MINIMIZABLE
#define com_sun_glass_ui_ios_IosWindow_MINIMIZABLE 32L
#undef com_sun_glass_ui_ios_IosWindow_MAXIMIZABLE
#define com_sun_glass_ui_ios_IosWindow_MAXIMIZABLE 64L
#undef com_sun_glass_ui_ios_IosWindow_RIGHT_TO_LEFT
#define com_sun_glass_ui_ios_IosWindow_RIGHT_TO_LEFT 128L
#undef com_sun_glass_ui_ios_IosWindow_UNIFIED
#define com_sun_glass_ui_ios_IosWindow_UNIFIED 256L
#undef com_sun_glass_ui_ios_IosWindow_MODAL
#define com_sun_glass_ui_ios_IosWindow_MODAL 512L
/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _createWindow
 * Signature: (JJI)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_ios_IosWindow__1createWindow
  (JNIEnv *, jobject, jlong, jlong, jint);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _createChildWindow
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_ios_IosWindow__1createChildWindow
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _close
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_glass_ui_ios_IosWindow__1close
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _setView
 * Signature: (JLcom/sun/glass/ui/View;)Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_glass_ui_ios_IosWindow__1setView
  (JNIEnv *, jobject, jlong, jobject);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _setBounds
 * Signature: (JIIZZIIIIFF)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_ios_IosWindow__1setBounds
  (JNIEnv *, jobject, jlong, jint, jint, jboolean, jboolean, jint, jint, jint, jint, jfloat, jfloat);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _setMenubar
 * Signature: (JJ)Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_glass_ui_ios_IosWindow__1setMenubar
  (JNIEnv *, jobject, jlong, jlong);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _minimize
 * Signature: (JZ)Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_glass_ui_ios_IosWindow__1minimize
  (JNIEnv *, jobject, jlong, jboolean);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _maximize
 * Signature: (JZZ)Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_glass_ui_ios_IosWindow__1maximize
  (JNIEnv *, jobject, jlong, jboolean, jboolean);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _setVisible
 * Signature: (JZ)Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_glass_ui_ios_IosWindow__1setVisible
  (JNIEnv *, jobject, jlong, jboolean);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _setResizable
 * Signature: (JZ)Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_glass_ui_ios_IosWindow__1setResizable
  (JNIEnv *, jobject, jlong, jboolean);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _requestFocus
 * Signature: (JI)Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_glass_ui_ios_IosWindow__1requestFocus
  (JNIEnv *, jobject, jlong, jint);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _setFocusable
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_ios_IosWindow__1setFocusable
  (JNIEnv *, jobject, jlong, jboolean);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _setTitle
 * Signature: (JLjava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_glass_ui_ios_IosWindow__1setTitle
  (JNIEnv *, jobject, jlong, jstring);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _setLevel
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_ios_IosWindow__1setLevel
  (JNIEnv *, jobject, jlong, jint);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _setAlpha
 * Signature: (JF)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_ios_IosWindow__1setAlpha
  (JNIEnv *, jobject, jlong, jfloat);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _setBackground
 * Signature: (JFFF)Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_glass_ui_ios_IosWindow__1setBackground
  (JNIEnv *, jobject, jlong, jfloat, jfloat, jfloat);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _setEnabled
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_ios_IosWindow__1setEnabled
  (JNIEnv *, jobject, jlong, jboolean);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _setMinimumSize
 * Signature: (JII)Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_glass_ui_ios_IosWindow__1setMinimumSize
  (JNIEnv *, jobject, jlong, jint, jint);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _setMaximumSize
 * Signature: (JII)Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_glass_ui_ios_IosWindow__1setMaximumSize
  (JNIEnv *, jobject, jlong, jint, jint);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _setIcon
 * Signature: (JLcom/sun/glass/ui/Pixels;)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_ios_IosWindow__1setIcon
  (JNIEnv *, jobject, jlong, jobject);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _toFront
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_ios_IosWindow__1toFront
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _toBack
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_ios_IosWindow__1toBack
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _enterModal
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_ios_IosWindow__1enterModal
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _enterModalWithWindow
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_ios_IosWindow__1enterModalWithWindow
  (JNIEnv *, jobject, jlong, jlong);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _exitModal
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_ios_IosWindow__1exitModal
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _grabFocus
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_glass_ui_ios_IosWindow__1grabFocus
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _ungrabFocus
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_ios_IosWindow__1ungrabFocus
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _requestInput
 * Signature: (JLjava/lang/String;IDDDDDDDDDDDDDD)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_ios_IosWindow__1requestInput
  (JNIEnv *, jobject, jlong, jstring, jint, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble, jdouble);

/*
 * Class:     com_sun_glass_ui_ios_IosWindow
 * Method:    _releaseInput
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_ios_IosWindow__1releaseInput
  (JNIEnv *, jobject, jlong);

#ifdef __cplusplus
}
#endif
#endif
