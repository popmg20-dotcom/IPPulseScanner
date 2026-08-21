package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import io.netty.channel.internal.ChannelUtils;
import j$.util.Objects;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nu0 {
    public final Context a;
    public final ou0 b;
    public VelocityTracker c;
    public float d;
    public int e = -1;
    public int f = -1;
    public int g = -1;
    public final int[] h = {ChannelUtils.WRITE_STATUS_SNDBUF_FULL, 0};

    public nu0(Context context, ou0 ou0Var) {
        this.a = context;
        this.b = ou0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0165  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(MotionEvent motionEvent, int i) {
        int i2;
        int i3;
        int scaledMinimumFlingVelocity;
        int scaledMaximumFlingVelocity;
        boolean z;
        float f;
        float yVelocity;
        long j;
        int i4;
        float f2;
        float fSqrt;
        float f3;
        float[] fArr;
        float f4;
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        int i5 = this.f;
        int[] iArr = this.h;
        if (i5 == source && this.g == deviceId && this.e == i) {
            z = false;
            i2 = 1;
            i3 = 0;
        } else {
            Context context = this.a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int deviceId2 = motionEvent.getDeviceId();
            int source2 = motionEvent.getSource();
            i2 = 1;
            int i6 = Build.VERSION.SDK_INT;
            i3 = 0;
            if (i6 >= 34) {
                Method method = xp4.a;
                scaledMinimumFlingVelocity = l2.k(viewConfiguration, deviceId2, i, source2);
            } else {
                Method method2 = xp4.a;
                InputDevice device = InputDevice.getDevice(deviceId2);
                if (device == null || device.getMotionRange(i, source2) == null) {
                    scaledMinimumFlingVelocity = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                } else {
                    Resources resources = context.getResources();
                    int identifier = (source2 == 4194304 && i == 26) ? resources.getIdentifier("config_viewMinRotaryEncoderFlingVelocity", "dimen", "android") : -1;
                    Objects.requireNonNull(viewConfiguration);
                    if (identifier == -1) {
                        scaledMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                    } else if (identifier == 0 || (scaledMinimumFlingVelocity = resources.getDimensionPixelSize(identifier)) < 0) {
                    }
                }
            }
            iArr[0] = scaledMinimumFlingVelocity;
            int deviceId3 = motionEvent.getDeviceId();
            int source3 = motionEvent.getSource();
            if (i6 >= 34) {
                scaledMaximumFlingVelocity = l2.j(viewConfiguration, deviceId3, i, source3);
            } else {
                InputDevice device2 = InputDevice.getDevice(deviceId3);
                if (device2 == null || device2.getMotionRange(i, source3) == null) {
                    scaledMaximumFlingVelocity = Integer.MIN_VALUE;
                } else {
                    Resources resources2 = context.getResources();
                    int identifier2 = (source3 == 4194304 && i == 26) ? resources2.getIdentifier("config_viewMaxRotaryEncoderFlingVelocity", "dimen", "android") : -1;
                    Objects.requireNonNull(viewConfiguration);
                    if (identifier2 == -1) {
                        scaledMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                    } else if (identifier2 == 0 || (scaledMaximumFlingVelocity = resources2.getDimensionPixelSize(identifier2)) < 0) {
                    }
                }
            }
            iArr[1] = scaledMaximumFlingVelocity;
            this.f = source;
            this.g = deviceId;
            this.e = i;
            z = true;
        }
        int i7 = iArr[i3];
        VelocityTracker velocityTrackerObtain = this.c;
        if (i7 == Integer.MAX_VALUE) {
            if (velocityTrackerObtain != null) {
                velocityTrackerObtain.recycle();
                this.c = null;
                return;
            }
            return;
        }
        if (velocityTrackerObtain == null) {
            velocityTrackerObtain = VelocityTracker.obtain();
            this.c = velocityTrackerObtain;
        }
        Map map = so4.a;
        velocityTrackerObtain.addMovement(motionEvent);
        float f5 = 0.0f;
        int i8 = 20;
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            Map map2 = so4.a;
            if (!map2.containsKey(velocityTrackerObtain)) {
                map2.put(velocityTrackerObtain, new to4());
            }
            to4 to4Var = (to4) map2.get(velocityTrackerObtain);
            long[] jArr = to4Var.b;
            long eventTime = motionEvent.getEventTime();
            int i9 = to4Var.d;
            if (i9 != 0 && eventTime - jArr[to4Var.e] > 40) {
                to4Var.d = i3;
                to4Var.c = 0.0f;
                i9 = 0;
            }
            int i10 = (to4Var.e + 1) % 20;
            to4Var.e = i10;
            if (i9 != 20) {
                to4Var.d = i9 + 1;
            }
            to4Var.a[i10] = motionEvent.getAxisValue(26);
            jArr[to4Var.e] = eventTime;
        }
        velocityTrackerObtain.computeCurrentVelocity(1000, Float.MAX_VALUE);
        to4 to4Var2 = (to4) so4.a.get(velocityTrackerObtain);
        if (to4Var2 != null) {
            float[] fArr2 = to4Var2.a;
            long[] jArr2 = to4Var2.b;
            int i11 = to4Var2.d;
            if (i11 < 2) {
                f2 = Float.MAX_VALUE;
                fSqrt = 0.0f;
                f = 0.0f;
                f4 = fSqrt * 1000.0f;
                to4Var2.c = f4;
                if (f4 >= (-Math.abs(f2))) {
                    to4Var2.c = -Math.abs(f2);
                } else if (to4Var2.c > Math.abs(f2)) {
                    to4Var2.c = Math.abs(f2);
                }
            } else {
                int i12 = to4Var2.e;
                int i13 = ((i12 + 20) - (i11 - 1)) % 20;
                long j2 = jArr2[i12];
                while (true) {
                    j = jArr2[i13];
                    long j3 = j2 - j;
                    i4 = to4Var2.d;
                    if (j3 <= 100) {
                        break;
                    }
                    to4Var2.d = i4 - 1;
                    i13 = (i13 + 1) % 20;
                }
                if (i4 >= 2) {
                    if (i4 == 2) {
                        int i14 = (i13 + 1) % 20;
                        if (j != jArr2[i14]) {
                            fSqrt = fArr2[i14] / (r13 - j);
                            f2 = Float.MAX_VALUE;
                            f = 0.0f;
                        }
                    } else {
                        f2 = Float.MAX_VALUE;
                        float fAbs = 0.0f;
                        int i15 = 0;
                        int i16 = 0;
                        while (true) {
                            if (i15 >= to4Var2.d - 1) {
                                break;
                            }
                            int i17 = i15 + i13;
                            long j4 = jArr2[i17 % 20];
                            int i18 = (i17 + 1) % i8;
                            if (jArr2[i18] == j4) {
                                f3 = f5;
                                fArr = fArr2;
                            } else {
                                i16++;
                                f3 = f5;
                                fArr = fArr2;
                                float fSqrt2 = (fAbs < f5 ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(fAbs) * 2.0f));
                                float f6 = fArr[i18] / (jArr2[i18] - j4);
                                fAbs += Math.abs(f6) * (f6 - fSqrt2);
                                if (i16 == i2) {
                                    fAbs *= 0.5f;
                                }
                            }
                            i15++;
                            f5 = f3;
                            fArr2 = fArr;
                            i8 = 20;
                            i2 = 1;
                        }
                        f = f5;
                        fSqrt = (fAbs < f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(fAbs) * 2.0f));
                    }
                    f4 = fSqrt * 1000.0f;
                    to4Var2.c = f4;
                    if (f4 >= (-Math.abs(f2))) {
                    }
                }
            }
        } else {
            f = 0.0f;
        }
        if (Build.VERSION.SDK_INT >= 34) {
            yVelocity = l2.d(velocityTrackerObtain, i);
        } else if (i == 0) {
            yVelocity = velocityTrackerObtain.getXVelocity();
        } else if (i == 1) {
            yVelocity = velocityTrackerObtain.getYVelocity();
        } else {
            to4 to4Var3 = (to4) so4.a.get(velocityTrackerObtain);
            yVelocity = (to4Var3 == null || i != 26) ? f : to4Var3.c;
        }
        ou0 ou0Var = this.b;
        float fI = ou0Var.i() * yVelocity;
        float fSignum = Math.signum(fI);
        if (z || (fSignum != Math.signum(this.d) && fSignum != f)) {
            ou0Var.r();
        }
        if (Math.abs(fI) < iArr[0]) {
            return;
        }
        float fMax = Math.max(-r1, Math.min(fI, iArr[1]));
        this.d = ou0Var.g(fMax) ? fMax : f;
    }
}
