package defpackage;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ad4 extends t43 {
    public TextureView e;
    public SurfaceTexture f;
    public yv g;
    public j74 h;
    public boolean i;
    public SurfaceTexture j;
    public AtomicReference k;
    public m10 l;

    @Override // defpackage.t43
    public final View a() {
        return this.e;
    }

    @Override // defpackage.t43
    public final Bitmap b() {
        TextureView textureView = this.e;
        if (textureView == null || !textureView.isAvailable()) {
            return null;
        }
        return this.e.getBitmap();
    }

    @Override // defpackage.t43
    public final void c() {
        if (!this.i || this.j == null) {
            return;
        }
        SurfaceTexture surfaceTexture = this.e.getSurfaceTexture();
        SurfaceTexture surfaceTexture2 = this.j;
        if (surfaceTexture != surfaceTexture2) {
            this.e.setSurfaceTexture(surfaceTexture2);
            this.j = null;
            this.i = false;
        }
    }

    @Override // defpackage.t43
    public final void d() {
        this.i = true;
    }

    @Override // defpackage.t43
    public final void e(j74 j74Var, m10 m10Var) {
        m10 m10Var2;
        Size size = j74Var.b;
        this.a = size;
        size.getClass();
        FrameLayout frameLayout = this.b;
        TextureView textureView = new TextureView(frameLayout.getContext());
        this.e = textureView;
        textureView.setLayoutParams(new FrameLayout.LayoutParams(this.a.getWidth(), this.a.getHeight()));
        this.e.setSurfaceTextureListener(new zc4(this));
        frameLayout.removeAllViews();
        frameLayout.addView(this.e);
        j74 j74Var2 = this.h;
        if (j74Var2 != null && j74Var2.c() && (m10Var2 = this.l) != null) {
            m10Var2.e();
            this.l = null;
        }
        this.h = j74Var;
        this.l = m10Var;
        j74Var.j.a(new xy0(22, this, j74Var), v9.i(this.e.getContext()));
        h();
    }

    @Override // defpackage.t43
    public final nc2 g() {
        vv vvVar = new vv();
        vvVar.c = new wj3();
        yv yvVar = new yv(vvVar);
        vvVar.b = yvVar;
        vvVar.a = fw.class;
        try {
            this.k.set(vvVar);
            vvVar.a = "textureViewImpl_waitForNextFrame";
            return yvVar;
        } catch (Exception e) {
            yvVar.b(e);
            return yvVar;
        }
    }

    public final void h() {
        SurfaceTexture surfaceTexture;
        Size size = this.a;
        if (size == null || (surfaceTexture = this.f) == null || this.h == null) {
            return;
        }
        surfaceTexture.setDefaultBufferSize(size.getWidth(), this.a.getHeight());
        Surface surface = new Surface(this.f);
        j74 j74Var = this.h;
        yv yvVarM = fx3.m(new ed(18, this, surface));
        this.g = yvVarM;
        yvVarM.f.a(new iy(this, surface, yvVarM, j74Var, 6), v9.i(this.e.getContext()));
        this.d = true;
        f();
    }
}
