package io.sentry.android.core;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import defpackage.kw2;
import io.sentry.ILogger;
import io.sentry.p5;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w1 implements SensorEventListener {
    public SensorManager a;
    public Sensor b;
    public HandlerThread c;
    public Handler d;
    public volatile u1 e;
    public ILogger f;
    public boolean g;
    public final kw2 h = new kw2(2);

    public w1(ILogger iLogger) {
        this.f = iLogger;
    }

    public final synchronized void a() {
        this.g = true;
        d();
        HandlerThread handlerThread = this.c;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.c = null;
            this.d = null;
        }
    }

    public final synchronized void b(Context context) {
        try {
            if (this.g) {
                return;
            }
            SensorManager sensorManager = this.a;
            if (sensorManager == null) {
                sensorManager = (SensorManager) context.getSystemService("sensor");
                this.a = sensorManager;
            }
            if (sensorManager != null && this.b == null) {
                this.b = sensorManager.getDefaultSensor(1, false);
            }
            if (this.b != null && this.c == null) {
                HandlerThread handlerThread = new HandlerThread("sentry-shake");
                this.c = handlerThread;
                handlerThread.start();
                this.d = new Handler(this.c.getLooper());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(Activity activity, u1 u1Var) {
        if (this.g) {
            return;
        }
        this.e = u1Var;
        b(activity);
        SensorManager sensorManager = this.a;
        if (sensorManager == null) {
            this.f.h(p5.WARNING, "SensorManager is not available. Shake detection disabled.", new Object[0]);
            return;
        }
        Sensor sensor = this.b;
        if (sensor == null) {
            this.f.h(p5.WARNING, "Accelerometer sensor not available. Shake detection disabled.", new Object[0]);
        } else {
            sensorManager.registerListener(this, sensor, 3, this.d);
        }
    }

    public final synchronized void d() {
        try {
            this.e = null;
            SensorManager sensorManager = this.a;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
            Handler handler = this.d;
            if (handler != null) {
                handler.post(new g(6, this));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0070, code lost:
    
        r15 = r3;
     */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i;
        int i2;
        v1 v1Var;
        int i3;
        v1 v1Var2;
        int i4 = 1;
        if (sensorEvent.sensor.getType() != 1) {
            return;
        }
        float[] fArr = sensorEvent.values;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        boolean z = Math.sqrt((double) ((f3 * f3) + ((f2 * f2) + (f * f)))) > 13.0d;
        kw2 kw2Var = this.h;
        long j = sensorEvent.timestamp;
        q0 q0Var = (q0) kw2Var.c;
        long j2 = j - 500000000;
        while (true) {
            i = kw2Var.a;
            if (i >= 4 && (v1Var2 = (v1) kw2Var.d) != null) {
                i2 = i4;
                if (j2 - v1Var2.a <= 0) {
                    break;
                }
                if (v1Var2.b) {
                    kw2Var.b -= i2;
                }
                kw2Var.a = i - 1;
                v1 v1Var3 = v1Var2.c;
                kw2Var.d = v1Var3;
                if (v1Var3 == null) {
                    kw2Var.e = null;
                }
                v1Var2.c = (v1) q0Var.b;
                q0Var.b = v1Var2;
                i4 = i2;
            } else {
                break;
            }
        }
        v1 v1Var4 = (v1) q0Var.b;
        if (v1Var4 == null) {
            v1Var4 = new v1();
        } else {
            q0Var.b = v1Var4.c;
        }
        v1Var4.a = j;
        v1Var4.b = z;
        v1Var4.c = null;
        v1 v1Var5 = (v1) kw2Var.e;
        if (v1Var5 != null) {
            v1Var5.c = v1Var4;
        }
        kw2Var.e = v1Var4;
        if (((v1) kw2Var.d) == null) {
            kw2Var.d = v1Var4;
        }
        kw2Var.a = i + i2;
        if (z) {
            kw2Var.b += i2;
        }
        kw2 kw2Var2 = this.h;
        v1 v1Var6 = (v1) kw2Var2.e;
        if (v1Var6 == null || (v1Var = (v1) kw2Var2.d) == null || (i3 = kw2Var2.a) < 4 || v1Var6.a - v1Var.a < 250000000 || kw2Var2.b < (i3 >> 1) + (i3 >> 2)) {
            return;
        }
        while (true) {
            v1 v1Var7 = (v1) kw2Var2.d;
            if (v1Var7 == null) {
                break;
            }
            kw2Var2.d = v1Var7.c;
            q0 q0Var2 = (q0) kw2Var2.c;
            v1Var7.c = (v1) q0Var2.b;
            q0Var2.b = v1Var7;
        }
        kw2Var2.e = null;
        kw2Var2.a = 0;
        kw2Var2.b = 0;
        u1 u1Var = this.e;
        if (u1Var != null) {
            u1Var.c();
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
