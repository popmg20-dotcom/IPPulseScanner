package io.sentry.android.replay.screenshot;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ i f;

    public /* synthetic */ c(i iVar, int i) {
        this.b = i;
        this.f = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        i iVar = this.f;
        switch (i) {
            case 0:
                if (!iVar.g.isRecycled()) {
                    synchronized (iVar.g) {
                        if (!iVar.g.isRecycled()) {
                            iVar.g.recycle();
                        }
                        break;
                    }
                }
                iVar.j.close();
                return;
            default:
                try {
                    iVar.a.j0(iVar.g);
                    return;
                } finally {
                    iVar.h();
                }
        }
    }
}
