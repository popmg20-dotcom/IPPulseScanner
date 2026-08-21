package defpackage;

import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n74 implements SurfaceHolder.Callback {
    public Size a;
    public j74 b;
    public j74 c;
    public m10 d;
    public Size e;
    public boolean f = false;
    public boolean g = false;
    public final /* synthetic */ o74 h;

    public n74(o74 o74Var) {
        this.h = o74Var;
    }

    public final void a() {
        m10 m10Var;
        if (this.b != null) {
            ez4.o("SurfaceViewImpl", "Request canceled: " + this.b);
            if (!this.b.c() || (m10Var = this.d) == null) {
                return;
            }
            m10Var.e();
        }
    }

    public final boolean b() {
        o74 o74Var = this.h;
        Surface surface = o74Var.e.getHolder().getSurface();
        if (this.f || this.b == null || !Objects.equals(this.a, this.e)) {
            return false;
        }
        ez4.o("SurfaceViewImpl", "Surface set on Preview.");
        m10 m10Var = this.d;
        j74 j74Var = this.b;
        Objects.requireNonNull(j74Var);
        j74Var.a(surface, v9.i(o74Var.e.getContext()), new e74(1, m10Var));
        this.f = true;
        o74Var.d = true;
        o74Var.f();
        return true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        ez4.o("SurfaceViewImpl", "Surface changed. Size: " + i2 + "x" + i3);
        this.e = new Size(i2, i3);
        b();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        j74 j74Var;
        ez4.o("SurfaceViewImpl", "Surface created.");
        if (!this.g || (j74Var = this.c) == null) {
            return;
        }
        j74Var.c();
        j74Var.i.b(null);
        this.c = null;
        this.g = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        ez4.o("SurfaceViewImpl", "Surface destroyed.");
        if (!this.f) {
            a();
        } else if (this.b != null) {
            ez4.o("SurfaceViewImpl", "Surface closed " + this.b);
            this.b.k.a();
        }
        this.g = true;
        j74 j74Var = this.b;
        if (j74Var != null) {
            this.c = j74Var;
        }
        this.f = false;
        this.b = null;
        this.d = null;
        this.e = null;
        this.a = null;
    }
}
