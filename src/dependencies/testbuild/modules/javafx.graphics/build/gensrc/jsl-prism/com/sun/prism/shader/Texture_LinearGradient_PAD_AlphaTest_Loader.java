/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.shader;

import java.io.InputStream;
import java.util.HashMap;
import com.sun.prism.ps.Shader;
import com.sun.prism.ps.ShaderFactory;

public class Texture_LinearGradient_PAD_AlphaTest_Loader {

    private Texture_LinearGradient_PAD_AlphaTest_Loader() {
    }

    public static Shader loadShader(ShaderFactory factory,
                                    InputStream pixelShaderCode)
    {
        HashMap<String, Integer> samplers = new HashMap<String, Integer>();
        samplers.put("maskInput", 0);
        samplers.put("colors", 1);

        HashMap<String, Integer> params = new HashMap<String, Integer>();
        params.put("perspVec", 14);
        params.put("gradParams", 13);
        params.put("offset", 12);
        params.put("fractions", 0);

        return factory.createShader(pixelShaderCode, samplers, params,
                                    0,
                                    true, true);
    }
}
