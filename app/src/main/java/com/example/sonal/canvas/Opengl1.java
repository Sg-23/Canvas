package com.example.sonal.canvas;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Sonal on 05-05-2018.
 */

public class Opengl1 extends AppCompatActivity
{


    private GLSurfaceView mGLView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mGLView = new MyGLSurfaceView(this);
        setContentView(mGLView);
    }
}

    class MyGLSurfaceView extends GLSurfaceView
    {

        private final MyGLRenderer mRenderer;
        private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
        private float mPreviousX;
        private float mPreviousY;

        public MyGLSurfaceView(Context context) {
            super(context);


            setEGLContextClientVersion(2);

            mRenderer = new MyGLRenderer();


            setRenderer(mRenderer);
            // Render the view only when there is a change in the drawing data
            setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
        }


        @Override
        public boolean onTouchEvent(MotionEvent e)
        {

            float x = e.getX();
            float y = e.getY();

            switch (e.getAction())
            {
                case MotionEvent.ACTION_MOVE:

                    float dx = x - mPreviousX;
                    float dy = y - mPreviousY;


                    if (y > getHeight() / 2) {
                        dx = dx * -1 ;
                    }


                    if (x < getWidth() / 2) {
                        dy = dy * -1 ;
                    }

                    mRenderer.setAngle(
                            mRenderer.getAngle() +
                                    ((dx + dy) * TOUCH_SCALE_FACTOR));
                    requestRender();
            }

            mPreviousX = x;
            mPreviousY = y;
            return true;
        }
    }

        class MyGLRenderer implements GLSurfaceView.Renderer
        {

            private triangleshape mtriangle;
            public volatile float mAngle;
            private float[] mRotationMatrix = new float[16];
            private final float[] mMVPMatrix = new float[16];
            private final float[] mProjectionMatrix = new float[16];
            private final float[] mViewMatrix = new float[16];

            public void onSurfaceCreated(GL10 unused, EGLConfig config)
            {
                 GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                mtriangle=new triangleshape();
            }

            public void onDrawFrame(GL10 unused)
            {
                float[] scratch = new float[16];
                Matrix.setLookAtM(mViewMatrix, 0, 0, 0, -3, 0f, 0f, 0f, 0f, 1.0f, 0.0f);
                Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
                mtriangle.draw(mMVPMatrix);
                GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
                Matrix.setRotateM(mRotationMatrix, 0, mAngle, 0, 0, -1.0f);
                Matrix.multiplyMM(scratch, 0, mMVPMatrix, 0, mRotationMatrix, 0);
                mtriangle.draw(scratch);
            }

            public void onSurfaceChanged(GL10 unused, int width, int height)
            {

                GLES20.glViewport(0, 0, width, height);
                float ratio = (float) width / height;
                Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1, 1, 3, 7);
            }

            public static int loadShader(int type, String shaderCode)
            {
                int shader = GLES20.glCreateShader(type);
                GLES20.glShaderSource(shader, shaderCode);
                GLES20.glCompileShader(shader);

                return shader;
            }


            public float getAngle()
            {
                return mAngle;
            }

            public void setAngle(float angle)
            {
                mAngle = angle;
            }
        }





