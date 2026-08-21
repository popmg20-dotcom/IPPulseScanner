package defpackage;

import android.graphics.SurfaceTexture;
import android.view.TextureView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zc4 implements TextureView.SurfaceTextureListener {
    public final /* synthetic */ ad4 a;

    public zc4(ad4 ad4Var) {
        this.a = ad4Var;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        ez4.o("TextureViewImpl", "SurfaceTexture available. Size: " + i + "x" + i2);
        ad4 ad4Var = this.a;
        ad4Var.f = surfaceTexture;
        if (ad4Var.g == null) {
            ad4Var.h();
            return;
        }
        ad4Var.h.getClass();
        ez4.o("TextureViewImpl", "Surface invalidated " + ad4Var.h);
        ad4Var.h.k.a();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        ad4 ad4Var = this.a;
        ad4Var.f = null;
        yv yvVar = ad4Var.g;
        if (yvVar == null) {
            ez4.o("TextureViewImpl", "SurfaceTexture about to be destroyed");
            return true;
        }
        e24 e24Var = new e24(8, this, surfaceTexture);
        yvVar.a(new um1(0, yvVar, e24Var), v9.i(ad4Var.e.getContext()));
        ad4Var.j = surfaceTexture;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        ez4.o("TextureViewImpl", "SurfaceTexture size changed: " + i + "x" + i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        vv vvVar = (vv) this.a.k.getAndSet(null);
        if (vvVar != null) {
            vvVar.b(null);
        }
    }
}
