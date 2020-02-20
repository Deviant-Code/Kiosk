/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * This file was generated by JSLC -- DO NOT EDIT MANUALLY!
 */

#include <jni.h>
#include <math.h>
#include "SSEUtils.h"
#include "com_sun_scenario_effect_impl_sw_sse_SSESepiaTonePeer.h"

JNIEXPORT void JNICALL
Java_com_sun_scenario_effect_impl_sw_sse_SSESepiaTonePeer_filter
  (JNIEnv *env, jclass klass,
   jintArray dst_arr,
   jint dstx, jint dsty, jint dstw, jint dsth, jint dstscan,
jintArray baseImg_arr,
jfloat src0Rect_x1, jfloat src0Rect_y1,
jfloat src0Rect_x2, jfloat src0Rect_y2,
jint src0w, jint src0h, jint src0scan,
jfloat level)
{
    int dyi;
    float color_x, color_y, color_z, color_w;

    jint *dst = (jint *)env->GetPrimitiveArrayCritical(dst_arr, 0);
    if (dst == NULL) return;
    jint *baseImg = (jint *)env->GetPrimitiveArrayCritical(baseImg_arr, 0);
    if (baseImg == NULL) return;


    float inc0_x = (src0Rect_x2 - src0Rect_x1) / dstw;
    float inc0_y = (src0Rect_y2 - src0Rect_y1) / dsth;


    float pos0_y = src0Rect_y1 + inc0_y*0.5f;

    for (int dy = dsty; dy < dsty+dsth; dy++) {
        float pixcoord_y = (float)dy;

        dyi = dy*dstscan;

        float pos0_x = src0Rect_x1 + inc0_x*0.5f;

        for (int dx = dstx; dx < dstx+dstw; dx++) {
            float pixcoord_x = (float)dx;


            {
            float weightBW_x = 0.3f;
            float weightBW_y = 0.59f;
            float weightBW_z = 0.11f;
            float weightSep_x = 1.6f;
            float weightSep_y = 1.2f;
            float weightSep_z = 0.9f;
            float sample_res_x, sample_res_y, sample_res_z, sample_res_w;
            {
            float loc_tmp_x = pos0_x;
            float loc_tmp_y = pos0_y;
            int baseImg_tmp;
            if (loc_tmp_x >= 0 && loc_tmp_y >= 0) {
                int iloc_tmp_x = (int)(loc_tmp_x*src0w);
                int iloc_tmp_y = (int)(loc_tmp_y*src0h);
                jboolean out =
                    iloc_tmp_x >= src0w ||
                    iloc_tmp_y >= src0h;
                baseImg_tmp = out ? 0 :
                    baseImg[iloc_tmp_y*src0scan + iloc_tmp_x];
            } else {
                baseImg_tmp = 0;
            }
            sample_res_x = (((baseImg_tmp >> 16) & 0xff) / 255.f);
            sample_res_y = (((baseImg_tmp >>  8) & 0xff) / 255.f);
            sample_res_z = (((baseImg_tmp      ) & 0xff) / 255.f);
            sample_res_w = (((baseImg_tmp >> 24) & 0xff) / 255.f);

            }
            float srcClr_x = sample_res_x;
            float srcClr_y = sample_res_y;
            float srcClr_z = sample_res_z;
            float srcClr_w = sample_res_w;
            float dot_res;
            {
            float x_tmp_x = srcClr_x;
            float x_tmp_y = srcClr_y;
            float x_tmp_z = srcClr_z;
            float y_tmp_x = weightBW_x;
            float y_tmp_y = weightBW_y;
            float y_tmp_z = weightBW_z;
            dot_res = (x_tmp_x * y_tmp_x)+
            (x_tmp_y * y_tmp_y)+
            (x_tmp_z * y_tmp_z);

            }
            float l = dot_res;
            float lum_x = l;
            float lum_y = l;
            float lum_z = l;
            float sep_x = lum_x * weightSep_x;
            float sep_y = lum_y * weightSep_y;
            float sep_z = lum_z * weightSep_z;
            float mix_res_x, mix_res_y, mix_res_z;
            {
            float x_tmp_x = sep_x;
            float x_tmp_y = sep_y;
            float x_tmp_z = sep_z;
            float y_tmp_x = srcClr_x;
            float y_tmp_y = srcClr_y;
            float y_tmp_z = srcClr_z;
            float a_tmp = 1.0f - level;
            mix_res_x = (x_tmp_x * (1.0f - a_tmp) + y_tmp_x * a_tmp);
            mix_res_y = (x_tmp_y * (1.0f - a_tmp) + y_tmp_y * a_tmp);
            mix_res_z = (x_tmp_z * (1.0f - a_tmp) + y_tmp_z * a_tmp);

            }
            color_x = mix_res_x;
            color_y = mix_res_y;
            color_z = mix_res_z;
            color_w = srcClr_w;
            }


            if (color_w < 0.f) color_w = 0.f; else if (color_w > 1.f) color_w = 1.f;
            if (color_x < 0.f) color_x = 0.f; else if (color_x > color_w) color_x = color_w;
            if (color_y < 0.f) color_y = 0.f; else if (color_y > color_w) color_y = color_w;
            if (color_z < 0.f) color_z = 0.f; else if (color_z > color_w) color_z = color_w;
            dst[dyi+dx] =
                ((int)(color_x * 0xff) << 16) |
                ((int)(color_y * 0xff) <<  8) |
                ((int)(color_z * 0xff) <<  0) |
                ((int)(color_w * 0xff) << 24);

            pos0_x += inc0_x;

        }

        pos0_y += inc0_y;

    }

    env->ReleasePrimitiveArrayCritical(dst_arr, dst, JNI_ABORT);
    env->ReleasePrimitiveArrayCritical(baseImg_arr, baseImg, JNI_ABORT);

}
