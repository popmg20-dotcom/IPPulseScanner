package io.sentry.android.replay.screenshot;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ b f;

    public /* synthetic */ a(b bVar, int i) {
        this.b = i;
        this.f = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        b bVar = this.f;
        switch (i) {
            case 0:
                b.d(bVar);
                return;
            default:
                Bitmap bitmap = bVar.e;
                if (bitmap != null) {
                    synchronized (bitmap) {
                        if (!bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                        break;
                    }
                }
                bVar.m.release();
                bVar.l.release();
                return;
        }
    }
}
