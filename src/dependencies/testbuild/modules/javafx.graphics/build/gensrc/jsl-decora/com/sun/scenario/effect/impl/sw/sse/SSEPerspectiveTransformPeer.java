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

package com.sun.scenario.effect.impl.sw.sse;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import com.sun.scenario.effect.Effect;
import com.sun.scenario.effect.FilterContext;
import com.sun.scenario.effect.FloatMap;
import com.sun.scenario.effect.ImageData;
import com.sun.scenario.effect.PerspectiveTransform;
import com.sun.scenario.effect.impl.BufferUtil;
import com.sun.scenario.effect.impl.HeapImage;
import com.sun.scenario.effect.impl.Renderer;
import com.sun.scenario.effect.impl.state.*;
import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.transform.BaseTransform;

public class SSEPerspectiveTransformPeer extends SSEEffectPeer  {

    public SSEPerspectiveTransformPeer(FilterContext fctx, Renderer r, String uniqueName) {
        super(fctx, r, uniqueName);
    }

    @Override
    protected final PerspectiveTransform getEffect() {
        return (PerspectiveTransform)super.getEffect();
    }


    private float[][] getITX() {
        PerspectiveTransformState state = (PerspectiveTransformState)
            AccessHelper.getState(getEffect());
        return state.getITX();
    }

    private float[] getTx0() {
        Rectangle ib = getInputBounds(0);
        Rectangle nb = getInputNativeBounds(0);
        float scalex = (float) ib.width / (float) nb.width;
        float itx0[] = getITX()[0];
        return new float[] { itx0[0] * scalex, itx0[1] * scalex, itx0[2] * scalex };
    }
    private float[] getTx1() {
        Rectangle ib = getInputBounds(0);
        Rectangle nb = getInputNativeBounds(0);
        float scaley = (float) ib.height / (float) nb.height;
        float itx1[] = getITX()[1];
        return new float[] { itx1[0] * scaley, itx1[1] * scaley, itx1[2] * scaley };
    }
    private float[] getTx2() {
        return getITX()[2];
    }

    @Override
    public int getTextureCoordinates(int inputIndex, float coords[],
                                     float srcX, float srcY,
                                     float srcNativeWidth,
                                     float srcNativeHeight,
                                     Rectangle dstBounds,
                                     com.sun.javafx.geom.transform.BaseTransform transform)
    {
        coords[0] = dstBounds.x;
        coords[1] = dstBounds.y;
        coords[2] = dstBounds.x + dstBounds.width;
        coords[3] = dstBounds.y + dstBounds.height;
        return 4;
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
        HeapImage src0 = (HeapImage)inputs[0].getUntransformedImage();
        int src0x = 0;
        int src0y = 0;
        int src0w = src0.getPhysicalWidth();
        int src0h = src0.getPhysicalHeight();
        int src0scan = src0.getScanlineStride();
        int[] baseImg =
            src0.getPixelArray();
        Rectangle src0Bounds = new Rectangle(src0x, src0y, src0w, src0h);
        Rectangle src0InputBounds = inputs[0].getUntransformedBounds();
        BaseTransform src0Transform = inputs[0].getTransform();
        setInputBounds(0, src0InputBounds);
        setInputNativeBounds(0, src0Bounds);


        float[] src0Rect = new float[4];
        getTextureCoordinates(0, src0Rect,
                              src0InputBounds.x, src0InputBounds.y,
                              src0w, src0h,
                              dstBounds, src0Transform);


        final int dstx = 0;
        final int dsty = 0;
        final int dstw = dstBounds.width;
        final int dsth = dstBounds.height;

        HeapImage dst = (HeapImage)getRenderer().getCompatibleImage(dstw, dsth);
        setDestNativeBounds(dst.getPhysicalWidth(), dst.getPhysicalHeight());
        int dstscan = dst.getScanlineStride();
        int[] dstPixels = dst.getPixelArray();

        float[] tx0_arr = getTx0();
        float[] tx1_arr = getTx1();
        float[] tx2_arr = getTx2();


        filter(dstPixels, dstx, dsty, dstw, dsth, dstscan,
baseImg,
src0Rect[0], src0Rect[1],
src0Rect[2], src0Rect[3],
src0w, src0h, src0scan,
tx0_arr[0], tx0_arr[1], tx0_arr[2],
tx1_arr[0], tx1_arr[1], tx1_arr[2],
tx2_arr[0], tx2_arr[1], tx2_arr[2]);


        return new ImageData(getFilterContext(), dst, dstBounds);
    }

    private static native void filter(int[] dstPixels,
                                      int dstx, int dsty,
                                      int dstw, int dsth,
                                      int dstscan,
int[] baseImg_arr,
float src0Rect_x1, float src0Rect_y1,
float src0Rect_x2, float src0Rect_y2,
int src0w, int src0h, int src0scan,
float tx0_x, float tx0_y, float tx0_z,
float tx1_x, float tx1_y, float tx1_z,
float tx2_x, float tx2_y, float tx2_z);
}
