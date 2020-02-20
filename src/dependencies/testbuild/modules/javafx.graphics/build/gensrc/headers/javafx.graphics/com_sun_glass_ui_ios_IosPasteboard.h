/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_sun_glass_ui_ios_IosPasteboard */

#ifndef _Included_com_sun_glass_ui_ios_IosPasteboard
#define _Included_com_sun_glass_ui_ios_IosPasteboard
#ifdef __cplusplus
extern "C" {
#endif
#undef com_sun_glass_ui_ios_IosPasteboard_General
#define com_sun_glass_ui_ios_IosPasteboard_General 1L
#undef com_sun_glass_ui_ios_IosPasteboard_UtfIndex
#define com_sun_glass_ui_ios_IosPasteboard_UtfIndex 0L
#undef com_sun_glass_ui_ios_IosPasteboard_ObjectIndex
#define com_sun_glass_ui_ios_IosPasteboard_ObjectIndex 1L
/*
 * Class:     com_sun_glass_ui_ios_IosPasteboard
 * Method:    _createSystemPasteboard
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_ios_IosPasteboard__1createSystemPasteboard
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_sun_glass_ui_ios_IosPasteboard
 * Method:    _createUserPasteboard
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_ios_IosPasteboard__1createUserPasteboard
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_sun_glass_ui_ios_IosPasteboard
 * Method:    _getName
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_sun_glass_ui_ios_IosPasteboard__1getName
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_ios_IosPasteboard
 * Method:    _getUTFs
 * Signature: (J)[[Ljava/lang/String;
 */
JNIEXPORT jobjectArray JNICALL Java_com_sun_glass_ui_ios_IosPasteboard__1getUTFs
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_ios_IosPasteboard
 * Method:    _getItemAsRawImage
 * Signature: (JI)[B
 */
JNIEXPORT jbyteArray JNICALL Java_com_sun_glass_ui_ios_IosPasteboard__1getItemAsRawImage
  (JNIEnv *, jobject, jlong, jint);

/*
 * Class:     com_sun_glass_ui_ios_IosPasteboard
 * Method:    _getItemAsString
 * Signature: (JI)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_sun_glass_ui_ios_IosPasteboard__1getItemAsString
  (JNIEnv *, jobject, jlong, jint);

/*
 * Class:     com_sun_glass_ui_ios_IosPasteboard
 * Method:    _getItemStringForUTF
 * Signature: (JILjava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_sun_glass_ui_ios_IosPasteboard__1getItemStringForUTF
  (JNIEnv *, jobject, jlong, jint, jstring);

/*
 * Class:     com_sun_glass_ui_ios_IosPasteboard
 * Method:    _getItemBytesForUTF
 * Signature: (JILjava/lang/String;)[B
 */
JNIEXPORT jbyteArray JNICALL Java_com_sun_glass_ui_ios_IosPasteboard__1getItemBytesForUTF
  (JNIEnv *, jobject, jlong, jint, jstring);

/*
 * Class:     com_sun_glass_ui_ios_IosPasteboard
 * Method:    _getItemForUTF
 * Signature: (JILjava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_ios_IosPasteboard__1getItemForUTF
  (JNIEnv *, jobject, jlong, jint, jstring);

/*
 * Class:     com_sun_glass_ui_ios_IosPasteboard
 * Method:    _putItemsFromArray
 * Signature: (J[Ljava/lang/Object;I)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_ios_IosPasteboard__1putItemsFromArray
  (JNIEnv *, jobject, jlong, jobjectArray, jint);

/*
 * Class:     com_sun_glass_ui_ios_IosPasteboard
 * Method:    _clear
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_ios_IosPasteboard__1clear
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_ios_IosPasteboard
 * Method:    _getSeed
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_com_sun_glass_ui_ios_IosPasteboard__1getSeed
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_ios_IosPasteboard
 * Method:    _getAllowedOperation
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_sun_glass_ui_ios_IosPasteboard__1getAllowedOperation
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_glass_ui_ios_IosPasteboard
 * Method:    _release
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_sun_glass_ui_ios_IosPasteboard__1release
  (JNIEnv *, jobject, jlong);

#ifdef __cplusplus
}
#endif
#endif
