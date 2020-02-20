/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_sun_media_jfxmediaimpl_NativeAudioSpectrum */

#ifndef _Included_com_sun_media_jfxmediaimpl_NativeAudioSpectrum
#define _Included_com_sun_media_jfxmediaimpl_NativeAudioSpectrum
#ifdef __cplusplus
extern "C" {
#endif
#undef com_sun_media_jfxmediaimpl_NativeAudioSpectrum_DEFAULT_THRESHOLD
#define com_sun_media_jfxmediaimpl_NativeAudioSpectrum_DEFAULT_THRESHOLD -60L
#undef com_sun_media_jfxmediaimpl_NativeAudioSpectrum_DEFAULT_BANDS
#define com_sun_media_jfxmediaimpl_NativeAudioSpectrum_DEFAULT_BANDS 128L
#undef com_sun_media_jfxmediaimpl_NativeAudioSpectrum_DEFAULT_INTERVAL
#define com_sun_media_jfxmediaimpl_NativeAudioSpectrum_DEFAULT_INTERVAL 0.1
/*
 * Class:     com_sun_media_jfxmediaimpl_NativeAudioSpectrum
 * Method:    nativeGetEnabled
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_media_jfxmediaimpl_NativeAudioSpectrum_nativeGetEnabled
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_media_jfxmediaimpl_NativeAudioSpectrum
 * Method:    nativeSetEnabled
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_com_sun_media_jfxmediaimpl_NativeAudioSpectrum_nativeSetEnabled
  (JNIEnv *, jobject, jlong, jboolean);

/*
 * Class:     com_sun_media_jfxmediaimpl_NativeAudioSpectrum
 * Method:    nativeSetBands
 * Signature: (JI[F[F)V
 */
JNIEXPORT void JNICALL Java_com_sun_media_jfxmediaimpl_NativeAudioSpectrum_nativeSetBands
  (JNIEnv *, jobject, jlong, jint, jfloatArray, jfloatArray);

/*
 * Class:     com_sun_media_jfxmediaimpl_NativeAudioSpectrum
 * Method:    nativeGetInterval
 * Signature: (J)D
 */
JNIEXPORT jdouble JNICALL Java_com_sun_media_jfxmediaimpl_NativeAudioSpectrum_nativeGetInterval
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_media_jfxmediaimpl_NativeAudioSpectrum
 * Method:    nativeSetInterval
 * Signature: (JD)V
 */
JNIEXPORT void JNICALL Java_com_sun_media_jfxmediaimpl_NativeAudioSpectrum_nativeSetInterval
  (JNIEnv *, jobject, jlong, jdouble);

/*
 * Class:     com_sun_media_jfxmediaimpl_NativeAudioSpectrum
 * Method:    nativeGetThreshold
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_sun_media_jfxmediaimpl_NativeAudioSpectrum_nativeGetThreshold
  (JNIEnv *, jobject, jlong);

/*
 * Class:     com_sun_media_jfxmediaimpl_NativeAudioSpectrum
 * Method:    nativeSetThreshold
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_com_sun_media_jfxmediaimpl_NativeAudioSpectrum_nativeSetThreshold
  (JNIEnv *, jobject, jlong, jint);

#ifdef __cplusplus
}
#endif
#endif
