/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_sun_glass_ui_mac_MacPasteboard */

#ifndef _Included_com_sun_glass_ui_mac_MacPasteboard
#define _Included_com_sun_glass_ui_mac_MacPasteboard
#ifdef __cplusplus
extern "C" {
#endif
#undef com_sun_glass_ui_mac_MacPasteboard_General
#define com_sun_glass_ui_mac_MacPasteboard_General 1L
#undef com_sun_glass_ui_mac_MacPasteboard_DragAndDrop
#define com_sun_glass_ui_mac_MacPasteboard_DragAndDrop 2L
#undef com_sun_glass_ui_mac_MacPasteboard_UtfIndex
#define com_sun_glass_ui_mac_MacPasteboard_UtfIndex 0L
#undef com_sun_glass_ui_mac_MacPasteboard_ObjectIndex
#define com_sun_glass_ui_mac_MacPasteboard_ObjectIndex 1L
/*
 * Class:     com_sun_glass_ui_mac_MacPasteboard
 * Method:    _initIDs
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_mac_MacPasteboard__1initIDs
  (JNIEnv *, jclass);

/*
 * Class:     com_sun_glass_ui_mac_MacPasteboard
 * Method:    _createSystemPasteboard
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_mac_MacPasteboard__1createSystemPasteboard
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_sun_glass_ui_mac_MacPasteboard
 * Method:    _createUserPasteboard
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_mac_MacPasteboard__1createUserPasteboard
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_sun_glass_ui_mac_MacPasteboard
 * Method:    _getName
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_sun_glass_ui_mac_MacPasteboard__1getName
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_mac_MacPasteboard
 * Method:    _getUTFs
 * Signature: (J)[[Ljava/lang/String;
 */
JNIEXPORT jobjectArray JNICALL Java_com_sun_glass_ui_mac_MacPasteboard__1getUTFs
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_mac_MacPasteboard
 * Method:    _getItemAsRawImage
 * Signature: (JI)[B
 */
JNIEXPORT jbyteArray JNICALL Java_com_sun_glass_ui_mac_MacPasteboard__1getItemAsRawImage
  (JNIEnv *, jobject, jlong, jint);

/*
 * Class:     com_sun_glass_ui_mac_MacPasteboard
 * Method:    _getItemStringForUTF
 * Signature: (JILjava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_sun_glass_ui_mac_MacPasteboard__1getItemStringForUTF
  (JNIEnv *, jobject, jlong, jint, jstring);

/*
 * Class:     com_sun_glass_ui_mac_MacPasteboard
 * Method:    _getItemBytesForUTF
 * Signature: (JILjava/lang/String;)[B
 */
JNIEXPORT jbyteArray JNICALL Java_com_sun_glass_ui_mac_MacPasteboard__1getItemBytesForUTF
  (JNIEnv *, jobject, jlong, jint, jstring);

/*
 * Class:     com_sun_glass_ui_mac_MacPasteboard
 * Method:    _putItemsFromArray
 * Signature: (J[Ljava/lang/Object;I)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_mac_MacPasteboard__1putItemsFromArray
  (JNIEnv *, jobject, jlong, jobjectArray, jint);

/*
 * Class:     com_sun_glass_ui_mac_MacPasteboard
 * Method:    _clear
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_mac_MacPasteboard__1clear
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_mac_MacPasteboard
 * Method:    _getSeed
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_mac_MacPasteboard__1getSeed
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_mac_MacPasteboard
 * Method:    _getAllowedOperation
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_sun_glass_ui_mac_MacPasteboard__1getAllowedOperation
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_mac_MacPasteboard
 * Method:    _release
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_mac_MacPasteboard__1release
  (JNIEnv *, jobject, jlong);

#ifdef __cplusplus
}
#endif
#endif
