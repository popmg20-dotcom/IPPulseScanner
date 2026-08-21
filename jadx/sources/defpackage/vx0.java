package defpackage;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import io.netty.handler.codec.dns.DnsRecord;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class vx0 extends Drawable implements Animatable {
    public static final xk D0 = new xk(10, Float.class, "growFraction");
    public ObjectAnimator A;
    public int B0;
    public ObjectAnimator X;
    public ArrayList Z;
    public final Context b;
    public final el f;
    public boolean y0;
    public float z0;
    public final float Y = -1.0f;
    public final Paint A0 = new Paint();
    public final Rect C0 = new Rect();
    public u8 z = new u8();

    public vx0(Context context, el elVar) {
        this.b = context;
        this.f = elVar;
        setAlpha(DnsRecord.CLASS_ANY);
    }

    public final float b() {
        el elVar = this.f;
        if (elVar.g == 0 && elVar.h == 0) {
            return 1.0f;
        }
        return this.z0;
    }

    public final float c() {
        float f = this.Y;
        if (f > 0.0f) {
            return f;
        }
        boolean z = this instanceof tt0;
        el elVar = this.f;
        if (elVar.b(z) && elVar.m != 0) {
            u8 u8Var = this.z;
            ContentResolver contentResolver = this.b.getContentResolver();
            u8Var.getClass();
            float fA = u8.a(contentResolver);
            if (fA > 0.0f) {
                float fUptimeMillis = (SystemClock.uptimeMillis() % ((long) r6)) / ((int) ((((z ? elVar.j : elVar.k) * 1000.0f) / elVar.m) * fA));
                return fUptimeMillis < 0.0f ? (fUptimeMillis % 1.0f) + 1.0f : fUptimeMillis;
            }
        }
        return 0.0f;
    }

    public final boolean d(boolean z, boolean z2, boolean z3) {
        u8 u8Var = this.z;
        ContentResolver contentResolver = this.b.getContentResolver();
        u8Var.getClass();
        return e(z, z2, z3 && u8.a(contentResolver) > 0.0f);
    }

    public boolean e(boolean z, boolean z2, boolean z3) {
        ObjectAnimator objectAnimator = this.A;
        int i = 0;
        xk xkVar = D0;
        if (objectAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, xkVar, 0.0f, 1.0f);
            this.A = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.A.setInterpolator(t8.b);
            ObjectAnimator objectAnimator2 = this.A;
            if (objectAnimator2 != null && objectAnimator2.isRunning()) {
                xe.k("Cannot set showAnimator while the current showAnimator is running.");
                return false;
            }
            this.A = objectAnimator2;
            objectAnimator2.addListener(new ux0(this, i));
        }
        int i2 = 1;
        if (this.X == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, xkVar, 1.0f, 0.0f);
            this.X = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(500L);
            this.X.setInterpolator(t8.b);
            ObjectAnimator objectAnimator3 = this.X;
            if (objectAnimator3 != null && objectAnimator3.isRunning()) {
                xe.k("Cannot set hideAnimator while the current hideAnimator is running.");
                return false;
            }
            this.X = objectAnimator3;
            objectAnimator3.addListener(new ux0(this, i2));
        }
        if (isVisible() || z) {
            ObjectAnimator objectAnimator4 = z ? this.A : this.X;
            ObjectAnimator objectAnimator5 = z ? this.X : this.A;
            if (!z3) {
                if (objectAnimator5.isRunning()) {
                    boolean z4 = this.y0;
                    this.y0 = true;
                    new ValueAnimator[]{objectAnimator5}[0].cancel();
                    this.y0 = z4;
                }
                if (objectAnimator4.isRunning()) {
                    objectAnimator4.end();
                } else {
                    boolean z5 = this.y0;
                    this.y0 = true;
                    new ValueAnimator[]{objectAnimator4}[0].end();
                    this.y0 = z5;
                }
                return super.setVisible(z, false);
            }
            if (!objectAnimator4.isRunning()) {
                boolean z6 = !z || super.setVisible(z, false);
                el elVar = this.f;
                if (!z ? elVar.h != 0 : elVar.g != 0) {
                    boolean z7 = this.y0;
                    this.y0 = true;
                    new ValueAnimator[]{objectAnimator4}[0].end();
                    this.y0 = z7;
                    return z6;
                }
                if (z2 || !objectAnimator4.isPaused()) {
                    objectAnimator4.start();
                    return z6;
                }
                objectAnimator4.resume();
                return z6;
            }
        }
        return false;
    }

    public final void f(cl clVar) {
        ArrayList arrayList = this.Z;
        if (arrayList == null || !arrayList.contains(clVar)) {
            return;
        }
        this.Z.remove(clVar);
        if (this.Z.isEmpty()) {
            this.Z = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.B0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ObjectAnimator objectAnimator = this.A;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            return true;
        }
        ObjectAnimator objectAnimator2 = this.X;
        return objectAnimator2 != null && objectAnimator2.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.B0 = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.A0.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        return d(z, z2, true);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        e(true, true, false);
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        e(false, true, false);
    }
}
