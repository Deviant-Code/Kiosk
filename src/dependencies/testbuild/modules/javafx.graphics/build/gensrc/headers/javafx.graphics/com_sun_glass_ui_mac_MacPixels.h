/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_sun_glass_ui_mac_MacPixels */

#ifndef _Included_com_sun_glass_ui_mac_MacPixels
#define _Included_com_sun_glass_ui_mac_MacPixels
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_sun_glass_ui_mac_MacPixels
 * Method:    _initIDs
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_sun_glass_ui_mac_MacPixels__1initIDs
  (JNIEnv *, jclass);

/*
 * Class:     com_sun_glass_ui_mac_MacPixels
 * Method:    _copyPixels
 * Signature: (Ljava/nio/Buffer;Ljava/nio/Buffer;I)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_mac_MacPixels__1copyPixels
  (JNIEnv *, jobject, jobject, jobject, jint);

/*
 * Class:     com_sun_glass_ui_mac_MacPixels
 * Method:    _attachInt
 * Signature: (JIILjava/nio/IntBuffer;[II)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_mac_MacPixels__1attachInt
  (JNIEnv *, jobject, jlong, jint, jint, jobject, jintArray, jint);

/*
 * Class:     com_sun_glass_ui_mac_MacPixels
 * Method:    _attachByte
 * Signature: (JIILjava/nio/ByteBuffer;[BI)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_mac_MacPixels__1attachByte
  (JNIEnv *, jobject, jlong, jint, jint, jobject, jbyteArray, jint);

#ifdef __cplusplus
}
#endif
#endif
