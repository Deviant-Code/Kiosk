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
#include "com_sun_scenario_effect_impl_sw_sse_SSEPerspectiveTransformPeer.h"

JNIEXPORT void JNICALL
Java_com_sun_scenario_effect_impl_sw_sse_SSEPerspectiveTransformPeer_filter
  (JNIEnv *env, jclass klass,
   jintArray dst_arr,
   jint dstx, jint dsty, jint dstw, jint dsth, jint dstscan,
jintArray baseImg_arr,
jfloat src0Rect_x1, jfloat src0Rect_y1,
jfloat src0Rect_x2, jfloat src0Rect_y2,
jint src0w, jint src0h, jint src0scan,
jfloat tx0_x, jfloat tx0_y, jfloat tx0_z,
jfloat tx1_x, jfloat tx1_y, jfloat tx1_z,
jfloat tx2_x, jfloat tx2_y, jfloat tx2_z)
{
    int dyi;
    float color_x, color_y, color_z, color_w;

    jint *dst = (jint *)env->GetPrimitiveArrayCritical(dst_arr, 0);
    if (dst == NULL) return;
    float baseImg_vals[4];
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
            float p1_x;
            float p1_y;
            float p1_z;
            float p2_x;
            float p2_y;
            float p2_z;
            p1_x = pos0_x;
            p1_y = pos0_y;
            p1_z = 1.0f;
            float dot_res;
            {
            float x_tmp_x = p1_x;
            float x_tmp_y = p1_y;
            float x_tmp_z = p1_z;
            float y_tmp_x = tx2_x;
            float y_tmp_y = tx2_y;
            float y_tmp_z = tx2_z;
            dot_res = (x_tmp_x * y_tmp_x)+
            (x_tmp_y * y_tmp_y)+
            (x_tmp_z * y_tmp_z);

            }
            p2_z = dot_res;
            {
            float x_tmp_x = p1_x;
            float x_tmp_y = p1_y;
            float x_tmp_z = p1_z;
            float y_tmp_x = tx0_x;
            float y_tmp_y = tx0_y;
            float y_tmp_z = tx0_z;
            dot_res = (x_tmp_x * y_tmp_x)+
            (x_tmp_y * y_tmp_y)+
            (x_tmp_z * y_tmp_z);

            }
            p2_x = dot_res / p2_z;
            {
            float x_tmp_x = p1_x;
            float x_tmp_y = p1_y;
            float x_tmp_z = p1_z;
            float y_tmp_x = tx1_x;
            float y_tmp_y = tx1_y;
            float y_tmp_z = tx1_z;
            dot_res = (x_tmp_x * y_tmp_x)+
            (x_tmp_y * y_tmp_y)+
            (x_tmp_z * y_tmp_z);

            }
            p2_y = dot_res / p2_z;
            float sample_res_x, sample_res_y, sample_res_z, sample_res_w;
            {
            float loc_tmp_x = p2_x;
            float loc_tmp_y = p2_y;
            lsample(baseImg, loc_tmp_x, loc_tmp_y,
                    src0w, src0h, src0scan,
                    baseImg_vals);
            sample_res_x = baseImg_vals[0];
            sample_res_y = baseImg_vals[1];
            sample_res_z = baseImg_vals[2];
            sample_res_w = baseImg_vals[3];

            }
            color_x = sample_res_x;
            color_y = sample_res_y;
            color_z = sample_res_z;
            color_w = sample_res_w;
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
