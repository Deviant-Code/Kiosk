/*
 * Copyright (c) 2008, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.scenario.effect.impl.sw.java;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import com.sun.scenario.effect.Effect;
import com.sun.scenario.effect.FilterContext;
import com.sun.scenario.effect.FloatMap;
import com.sun.scenario.effect.ImageData;
import com.sun.scenario.effect.PhongLighting;
import com.sun.scenario.effect.impl.BufferUtil;
import com.sun.scenario.effect.impl.HeapImage;
import com.sun.scenario.effect.impl.Renderer;
import com.sun.scenario.effect.impl.state.*;
import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.transform.BaseTransform;

public class JSWPhongLighting_DISTANTPeer extends JSWEffectPeer  {

    public JSWPhongLighting_DISTANTPeer(FilterContext fctx, Renderer r, String uniqueName) {
        super(fctx, r, uniqueName);
    }

    @Override
    protected final PhongLighting getEffect() {
        return (PhongLighting)super.getEffect();
    }


    private FloatBuffer kvals;

    private float getSurfaceScale() {
        return getEffect().getSurfaceScale();
    }

    private float getDiffuseConstant() {
        return getEffect().getDiffuseConstant();
    }

    private float getSpecularConstant() {
        return getEffect().getSpecularConstant();
    }

    private float getSpecularExponent() {
        return getEffect().getSpecularExponent();
    }

    private float[] getNormalizedLightPosition() {
        return getEffect().getLight().getNormalizedLightPosition();
    }

    private float[] getLightPosition() {
        com.sun.scenario.effect.light.PointLight plight =
            (com.sun.scenario.effect.light.PointLight)getEffect().getLight();
        return new float[] { plight.getX(), plight.getY(), plight.getZ() };
    }

    private float[] getLightColor() {
        return getEffect().getLight().getColor().getPremultipliedRGBComponents();
    }

    private float getLightSpecularExponent() {
        return ((com.sun.scenario.effect.light.SpotLight)getEffect().getLight()).getSpecularExponent();
    }

    private float[] getNormalizedLightDirection() {
        return ((com.sun.scenario.effect.light.SpotLight)getEffect().getLight()).getNormalizedLightDirection();
    }

    private FloatBuffer getKvals() {
        Rectangle bumpImgBounds = getInputNativeBounds(0);
        float xoff = 1f / bumpImgBounds.width;
        float yoff = 1f / bumpImgBounds.height;

        float[] kx = {
            -1, 0, 1,
            -2, 0, 2,
            -1, 0, 1,
        };
        float[] ky = {
            -1, -2, -1,
             0,  0,  0,
             1,  2,  1,
        };
        if (kvals == null) {
            kvals = BufferUtil.newFloatBuffer(8*4);
        }
        kvals.clear();
        int kidx = 0;
        float factor = -getSurfaceScale() * 0.25f;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    kvals.put(j*xoff);
                    kvals.put(i*yoff);
                    kvals.put(kx[kidx] * factor);
                    kvals.put(ky[kidx] * factor);
                }
                kidx++;
            }
        }
        kvals.rewind();
        return kvals;
    }

    private int getKvalsArrayLength() {
        return 8;
    }


    @Override
    public ImageData filter(Effect effect,
                            RenderState rstate,
                            BaseTransform transform,
                            Rectangle outputClip,
                            ImageData... inputs)
    {
        setEffect(effect);
        Rectangle dstBounds = getResultBounds(transform, outputClip, inputs);
        setDestBounds(dstBounds);

        // TODO: for now, all input images must be TYPE_INT_ARGB_PRE
        HeapImage src0 = (HeapImage)inputs[0].getTransformedImage(dstBounds);
        int src0x = 0;
        int src0y = 0;
        int src0w = src0.getPhysicalWidth();
        int src0h = src0.getPhysicalHeight();
        int src0scan = src0.getScanlineStride();
        int[] bumpImg =
            src0.getPixelArray();
        Rectangle src0Bounds = new Rectangle(src0x, src0y, src0w, src0h);
        Rectangle src0InputBounds = inputs[0].getTransformedBounds(dstBounds);
        BaseTransform src0Transform = BaseTransform.IDENTITY_TRANSFORM;
        setInputBounds(0, src0InputBounds);
        setInputNativeBounds(0, src0Bounds);
        HeapImage src1 = (HeapImage)inputs[1].getTransformedImage(dstBounds);
        int src1x = 0;
        int src1y = 0;
        int src1w = src1.getPhysicalWidth();
        int src1h = src1.getPhysicalHeight();
        int src1scan = src1.getScanlineStride();
        int[] origImg =
            src1.getPixelArray();
        Rectangle src1Bounds = new Rectangle(src1x, src1y, src1w, src1h);
        Rectangle src1InputBounds = inputs[1].getTransformedBounds(dstBounds);
        BaseTransform src1Transform = BaseTransform.IDENTITY_TRANSFORM;
        setInputBounds(1, src1InputBounds);
        setInputNativeBounds(1, src1Bounds);


        float[] src0Rect = new float[4];
        getTextureCoordinates(0, src0Rect,
                              src0InputBounds.x, src0InputBounds.y,
                              src0w, src0h,
                              dstBounds, src0Transform);
        float[] src1Rect = new float[4];
        getTextureCoordinates(1, src1Rect,
                              src1InputBounds.x, src1InputBounds.y,
                              src1w, src1h,
                              dstBounds, src1Transform);


        final int dstx = 0;
        final int dsty = 0;
        final int dstw = dstBounds.width;
        final int dsth = dstBounds.height;

        HeapImage dst = (HeapImage)getRenderer().getCompatibleImage(dstw, dsth);
        setDestNativeBounds(dst.getPhysicalWidth(), dst.getPhysicalHeight());
        int dstscan = dst.getScanlineStride();
        int[] dstPixels = dst.getPixelArray();

        int dyi;
        float color_x, color_y, color_z, color_w;

        float[] normalizedLightPosition_arr = getNormalizedLightPosition();
        float normalizedLightPosition_x = normalizedLightPosition_arr[0], normalizedLightPosition_y = normalizedLightPosition_arr[1], normalizedLightPosition_z = normalizedLightPosition_arr[2];
        float specularExponent = getSpecularExponent();
        FloatBuffer kvals_buf = getKvals();
        float[] kvals_arr = new float[kvals_buf.capacity()];
        kvals_buf.get(kvals_arr);
        float diffuseConstant = getDiffuseConstant();
        float[] lightColor_arr = getLightColor();
        float lightColor_x = lightColor_arr[0], lightColor_y = lightColor_arr[1], lightColor_z = lightColor_arr[2];
        float specularConstant = getSpecularConstant();


        float inc0_x = (src0Rect[2] - src0Rect[0]) / dstw;
        float inc0_y = (src0Rect[3] - src0Rect[1]) / dsth;
        float inc1_x = (src1Rect[2] - src1Rect[0]) / dstw;
        float inc1_y = (src1Rect[3] - src1Rect[1]) / dsth;


        float pos0_y = src0Rect[1] + inc0_y*0.5f;
        float pos1_y = src1Rect[1] + inc1_y*0.5f;

        for (int dy = dsty; dy < dsty+dsth; dy++) {
            float pixcoord_y = (float)dy;

            dyi = dy*dstscan;

            float pos0_x = src0Rect[0] + inc0_x*0.5f;
            float pos1_x = src1Rect[0] + inc1_x*0.5f;

            for (int dx = dstx; dx < dstx+dstw; dx++) {
                float pixcoord_x = (float)dx;


                {
                float sample_res_x, sample_res_y, sample_res_z, sample_res_w;
                {
                float loc_tmp_x = pos1_x;
                float loc_tmp_y = pos1_y;
                int origImg_tmp;
                if (loc_tmp_x >= 0 && loc_tmp_y >= 0) {
                    int iloc_tmp_x = (int)(loc_tmp_x*src1w);
                    int iloc_tmp_y = (int)(loc_tmp_y*src1h);
                    boolean out =
                        iloc_tmp_x >= src1w ||
                        iloc_tmp_y >= src1h;
                    origImg_tmp = out ? 0 :
                        origImg[iloc_tmp_y*src1scan + iloc_tmp_x];
                } else {
                    origImg_tmp = 0;
                }
                sample_res_x = (((origImg_tmp >>  16) & 0xff) / 255f);
                sample_res_y = (((origImg_tmp >>   8) & 0xff) / 255f);
                sample_res_z = (((origImg_tmp       ) & 0xff) / 255f);
                sample_res_w = (((origImg_tmp >>> 24)       ) / 255f);

                }
                float orig_x = sample_res_x;
                float orig_y = sample_res_y;
                float orig_z = sample_res_z;
                float orig_w = sample_res_w;
                int i;
                float sum_x = 0.0f;
                float sum_y = 0.0f;
                float sum_z = 1.0f;
                for (i = 0;
                i < 8;++i){
                {
                float loc_tmp_x = pos0_x + kvals_arr[i * 4 + 0];
                float loc_tmp_y = pos0_y + kvals_arr[i * 4 + 1];
                int bumpImg_tmp;
                if (loc_tmp_x >= 0 && loc_tmp_y >= 0) {
                    int iloc_tmp_x = (int)(loc_tmp_x*src0w);
                    int iloc_tmp_y = (int)(loc_tmp_y*src0h);
                    boolean out =
                        iloc_tmp_x >= src0w ||
                        iloc_tmp_y >= src0h;
                    bumpImg_tmp = out ? 0 :
                        bumpImg[iloc_tmp_y*src0scan + iloc_tmp_x];
                } else {
                    bumpImg_tmp = 0;
                }
                sample_res_w = (((bumpImg_tmp >>> 24)       ) / 255f);

                }
                sum_x += kvals_arr[i * 4 + 2] * sample_res_w;
                sum_y += kvals_arr[i * 4 + 3] * sample_res_w;
                }
                float normalize_res_x, normalize_res_y, normalize_res_z;
                {
                float x_tmp_x = sum_x;
                float x_tmp_y = sum_y;
                float x_tmp_z = sum_z;
                float denom = (float)Math.sqrt((x_tmp_x * x_tmp_x)+
                (x_tmp_y * x_tmp_y)+
                (x_tmp_z * x_tmp_z));
                normalize_res_x = x_tmp_x / denom;
                normalize_res_y = x_tmp_y / denom;
                normalize_res_z = x_tmp_z / denom;

                }
                float N_x = normalize_res_x;
                float N_y = normalize_res_y;
                float N_z = normalize_res_z;
                float Lxyz_x = normalizedLightPosition_x;
                float Lxyz_y = normalizedLightPosition_y;
                float Lxyz_z = normalizedLightPosition_z;
                float Lrgb_x = lightColor_x;
                float Lrgb_y = lightColor_y;
                float Lrgb_z = lightColor_z;
                float E_x = 0.0f;
                float E_y = 0.0f;
                float E_z = 1.0f;
                {
                float x_tmp_x = Lxyz_x + E_x;
                float x_tmp_y = Lxyz_y + E_y;
                float x_tmp_z = Lxyz_z + E_z;
                float denom = (float)Math.sqrt((x_tmp_x * x_tmp_x)+
                (x_tmp_y * x_tmp_y)+
                (x_tmp_z * x_tmp_z));
                normalize_res_x = x_tmp_x / denom;
                normalize_res_y = x_tmp_y / denom;
                normalize_res_z = x_tmp_z / denom;

                }
                float H_x = normalize_res_x;
                float H_y = normalize_res_y;
                float H_z = normalize_res_z;
                float D_x;
                float D_y;
                float D_z;
                float D_w;
                float dot_res;
                {
                float x_tmp_x = N_x;
                float x_tmp_y = N_y;
                float x_tmp_z = N_z;
                float y_tmp_x = Lxyz_x;
                float y_tmp_y = Lxyz_y;
                float y_tmp_z = Lxyz_z;
                dot_res = (x_tmp_x * y_tmp_x)+
                (x_tmp_y * y_tmp_y)+
                (x_tmp_z * y_tmp_z);

                }
                D_x = diffuseConstant * dot_res * Lrgb_x;
                D_y = diffuseConstant * dot_res * Lrgb_y;
                D_z = diffuseConstant * dot_res * Lrgb_z;
                float clamp_res_x, clamp_res_y, clamp_res_z;
                {
                float val_tmp_x = D_x;
                float val_tmp_y = D_y;
                float val_tmp_z = D_z;
                float min_tmp = 0.0f;
                float max_tmp = 1.0f;
                clamp_res_x = (val_tmp_x < min_tmp) ? min_tmp : 
                (val_tmp_x > max_tmp) ? max_tmp : val_tmp_x;
                clamp_res_y = (val_tmp_y < min_tmp) ? min_tmp : 
                (val_tmp_y > max_tmp) ? max_tmp : val_tmp_y;
                clamp_res_z = (val_tmp_z < min_tmp) ? min_tmp : 
                (val_tmp_z > max_tmp) ? max_tmp : val_tmp_z;

                }
                D_x = clamp_res_x;
                D_y = clamp_res_y;
                D_z = clamp_res_z;
                D_w = 1.0f;
                float S_x;
                float S_y;
                float S_z;
                float S_w;
                {
                float x_tmp_x = N_x;
                float x_tmp_y = N_y;
                float x_tmp_z = N_z;
                float y_tmp_x = H_x;
                float y_tmp_y = H_y;
                float y_tmp_z = H_z;
                dot_res = (x_tmp_x * y_tmp_x)+
                (x_tmp_y * y_tmp_y)+
                (x_tmp_z * y_tmp_z);

                }
                float NdotH = dot_res;
                float pow_res;
                {
                float x_tmp = NdotH;
                float y_tmp = specularExponent;
                pow_res = (float)Math.pow(x_tmp, y_tmp);

                }
                S_x = specularConstant * pow_res * Lrgb_x;
                S_y = specularConstant * pow_res * Lrgb_y;
                S_z = specularConstant * pow_res * Lrgb_z;
                float max_res;
                {
                float x_tmp = S_x;
                float y_tmp = S_y;
                max_res = (x_tmp > y_tmp) ? x_tmp : y_tmp;

                }
                S_w = max_res;
                {
                float x_tmp = S_w;
                float y_tmp = S_z;
                max_res = (x_tmp > y_tmp) ? x_tmp : y_tmp;

                }
                S_w = max_res;
                orig_x *= D_x;
                orig_y *= D_y;
                orig_z *= D_z;
                orig_w *= D_w;
                S_x *= orig_w;
                S_y *= orig_w;
                S_z *= orig_w;
                S_w *= orig_w;
                color_x = S_x + (orig_x * (1.0f - S_w));
                color_y = S_y + (orig_y * (1.0f - S_w));
                color_z = S_z + (orig_z * (1.0f - S_w));
                color_w = S_w + (orig_w * (1.0f - S_w));
                }


                if (color_w < 0f) color_w = 0f; else if (color_w > 1f) color_w = 1f;
                if (color_x < 0f) color_x = 0f; else if (color_x > color_w) color_x = color_w;
                if (color_y < 0f) color_y = 0f; else if (color_y > color_w) color_y = color_w;
                if (color_z < 0f) color_z = 0f; else if (color_z > color_w) color_z = color_w;
                dstPixels[dyi+dx] =
                    ((int)(color_x * 0xff) << 16) |
                    ((int)(color_y * 0xff) <<  8) |
                    ((int)(color_z * 0xff) <<  0) |
                    ((int)(color_w * 0xff) << 24);

                pos0_x += inc0_x;
                pos1_x += inc1_x;

            }

            pos0_y += inc0_y;
            pos1_y += inc1_y;

        }

        inputs[0].releaseTransformedImage(src0);
        inputs[1].releaseTransformedImage(src1);


        return new ImageData(getFilterContext(), dst, dstBounds);
    }
}
