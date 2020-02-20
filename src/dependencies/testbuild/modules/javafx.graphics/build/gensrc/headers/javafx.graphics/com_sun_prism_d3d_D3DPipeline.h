/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_sun_prism_d3d_D3DPipeline */

#ifndef _Included_com_sun_prism_d3d_D3DPipeline
#define _Included_com_sun_prism_d3d_D3DPipeline
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_sun_prism_d3d_D3DPipeline
 * Method:    nInit
 * Signature: (Ljava/lang/Class;)Z
 */
JNIEXPORT jboolean JNICALL Java_com_sun_prism_d3d_D3DPipeline_nInit
  (JNIEnv *, jclass, jclass);

/*
 * Class:     com_sun_prism_d3d_D3DPipeline
 * Method:    nGetErrorMessage
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_sun_prism_d3d_D3DPipeline_nGetErrorMessage
  (JNIEnv *, jclass);

/*
 * Class:     com_sun_prism_d3d_D3DPipeline
 * Method:    nDispose
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_sun_prism_d3d_D3DPipeline_nDispose
  (JNIEnv *, jclass);

/*
 * Class:     com_sun_prism_d3d_D3DPipeline
 * Method:    nGetAdapterOrdinal
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_com_sun_prism_d3d_D3DPipeline_nGetAdapterOrdinal
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_sun_prism_d3d_D3DPipeline
 * Method:    nGetAdapterCount
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_sun_prism_d3d_D3DPipeline_nGetAdapterCount
  (JNIEnv *, jclass);

/*
 * Class:     com_sun_prism_d3d_D3DPipeline
 * Method:    nGetDriverInformation
 * Signature: (ILcom/sun/prism/d3d/D3DDriverInformation;)Lcom/sun/prism/d3d/D3DDriverInformation;
 */
JNIEXPORT jobject JNICALL Java_com_sun_prism_d3d_D3DPipeline_nGetDriverInformation
  (JNIEnv *, jclass, jint, jobject);

/*
 * Class:     com_sun_prism_d3d_D3DPipeline
 * Method:    nGetMaxSampleSupport
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_sun_prism_d3d_D3DPipeline_nGetMaxSampleSupport
  (JNIEnv *, jclass, jint);

#ifdef __cplusplus
}
#endif
#endif
