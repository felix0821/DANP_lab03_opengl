package com.idnp.openglsample;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Tetrahedron {
    private FloatBuffer mVertexBuffer;
    private FloatBuffer mColorBuffer;
    private ByteBuffer mIndexBuffer;

    private FloatBuffer vertexBuffer;  // Buffer for vertex-array
    private int numFaces = 4;

    private float[] vertices = {
            -1.0f, -1.0f,  1.0f,
            1.0f, -1.0f,  1.0f,
            1.0f,  1.0f,  1.0f,
            -1.0f, -1.0f,  1.0f,
            1.0f,  1.0f, 1.0f,
            -1.0f, -1.0f, -1.0f,
            1.0f, -1.0f, 1.0f,
            -1.0f, -1.0f, -1.0f,
            1.0f,  1.0f, 1.0f,
            -1.0f, -1.0f, 1.0f,
            -1.0f, -1.0f, -1.0f,
            1.0f, -1.0f,  1.0f
    };

    private float[][] colors = {
            {1.0f,  1.0f,  0.2f,  0.2f},
            {0.2f,  0.2f,  0.1f, 1.0f},
            {0.3f, 0.3f, 0.1f, 1.0f},
            {0.2f,  0.2f,  0.1f, 1.0f},
    };

    public Tetrahedron() {
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);
    }

    public void draw(GL10 gl) {
        gl.glFrontFace(GL10.GL_CCW);
        gl.glCullFace(GL10.GL_BACK);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        for (int face = 0; face < numFaces; face++) {
            gl.glColor4f(colors[face][0], colors[face][1], colors[face][2],colors[face][3]);
            gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, face*3, 3);
        }
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisable(GL10.GL_CULL_FACE);
    }
}
