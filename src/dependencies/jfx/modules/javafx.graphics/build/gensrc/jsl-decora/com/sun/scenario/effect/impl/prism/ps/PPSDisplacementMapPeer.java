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

package com.sun.scenario.effect.impl.prism.ps;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import com.sun.prism.ps.Shader;
import com.sun.scenario.effect.DisplacementMap;
import com.sun.scenario.effect.Effect;
import com.sun.scenario.effect.FilterContext;
import com.sun.scenario.effect.impl.BufferUtil;
import com.sun.scenario.effect.impl.Renderer;
import com.sun.scenario.effect.impl.state.*;
import com.sun.javafx.geom.Rectangle;

public class PPSDisplacementMapPeer extends PPSTwoSamplerPeer  {

    public PPSDisplacementMapPeer(FilterContext fctx, Renderer r, String shaderName) {
        super(fctx, r, shaderName);
    }

    @Override
    protected final DisplacementMap getEffect() {
        return (DisplacementMap)super.getEffect();
    }


    private float[] getSampletx() {
        return new float[] {
            getEffect().getOffsetX(),
            getEffect().getOffsetY(),
            getEffect().getScaleX(),
            getEffect().getScaleY(),
        };
    }
    private float[] getImagetx() {
        float inset = getEffect().getWrap() ? 0.5f : 0f;
        return new float[] {
            inset / getInputNativeBounds(0).width,
            inset / getInputNativeBounds(0).height,
            (getInputBounds(0).width-2*inset) / getInputNativeBounds(0).width,
            (getInputBounds(0).height-2*inset) / getInputNativeBounds(0).height,
        };
    }
    private float getWrap() {
        return getEffect().getWrap() ? 1f : 0f;
    }

    @Override
    protected Object getSamplerData(int i) {
        return getEffect().getMapData();
    }

    @Override
    public int getTextureCoordinates(int inputIndex, float coords[],
                                     float srcX, float srcY,
                                     float srcNativeWidth,
                                     float srcNativeHeight,
                                     Rectangle dstBounds,
                                     com.sun.javafx.geom.transform.BaseTransform transform)
    {
        coords[0] = coords[1] = 0f;
        coords[2] = coords[3] = 1f;
        return 4;
    }


    @Override
    protected boolean isSamplerLinear(int i) {
        switch (i) {
        case 0:
            return true;
        case 1:
            return true;

        default:
            return false;
        }
    }

    @Override
    protected Shader createShader() {
        HashMap<String, Integer> samplers = new HashMap<String, Integer>();
        samplers.put("origImg", 0);
        samplers.put("mapImg", 1);

        HashMap<String, Integer> params = new HashMap<String, Integer>();
        params.put("imagetx", 1);
        params.put("wrap", 2);
        params.put("sampletx", 0);

        return getRenderer().createShader(getShaderName(), samplers, params,
                                          false);
    }

    @Override
    protected void updateShader(Shader shader) {
        float[] imagetx_tmp = getImagetx();
        shader.setConstant("imagetx", imagetx_tmp[0], imagetx_tmp[1], imagetx_tmp[2], imagetx_tmp[3]);
        shader.setConstant("wrap", getWrap());
        float[] sampletx_tmp = getSampletx();
        shader.setConstant("sampletx", sampletx_tmp[0], sampletx_tmp[1], sampletx_tmp[2], sampletx_tmp[3]);

    }
}
