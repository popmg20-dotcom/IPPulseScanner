package io.sentry.android.replay.capture;

import defpackage.d82;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final /* synthetic */ int a;
    public final AtomicReference b;
    public final /* synthetic */ d c;
    public final /* synthetic */ d d;

    public b(d dVar, d dVar2, int i) {
        this.a = i;
        switch (i) {
            case 2:
                this.c = dVar;
                this.d = dVar2;
                this.b = new AtomicReference(null);
                break;
            case 3:
                Boolean bool = Boolean.FALSE;
                this.c = dVar;
                this.d = dVar2;
                this.b = new AtomicReference(bool);
                break;
            case 4:
                this.c = dVar;
                this.d = dVar2;
                this.b = new AtomicReference(null);
                break;
            case 5:
                this.c = dVar;
                this.d = dVar2;
                this.b = new AtomicReference(null);
                break;
            case 6:
                this.c = dVar;
                this.d = dVar2;
                this.b = new AtomicReference(null);
                break;
            default:
                this.c = dVar;
                this.d = dVar2;
                this.b = new AtomicReference(-1);
                break;
        }
    }

    public Object a(Object obj, d82 d82Var) {
        int i = this.a;
        AtomicReference atomicReference = this.b;
        d82Var.getClass();
        switch (i) {
        }
        return atomicReference.get();
    }

    public b(Object obj, d dVar, d dVar2) {
        this.a = 0;
        this.c = dVar;
        this.d = dVar2;
        this.b = new AtomicReference(obj);
    }
}
