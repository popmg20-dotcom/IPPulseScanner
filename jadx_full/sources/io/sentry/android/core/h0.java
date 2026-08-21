package io.sentry.android.core;

import android.view.View;
import defpackage.vf2;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends CopyOnWriteArrayList {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ h0(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.b) {
            case 0:
                g0 g0Var = (g0) obj;
                boolean zAdd = super.add(g0Var);
                if (Boolean.FALSE.equals(((i0) this.f).f.A)) {
                    g0Var.g();
                } else if (Boolean.TRUE.equals(((i0) this.f).f.A)) {
                    g0Var.n();
                }
                return zAdd;
            default:
                io.sentry.android.replay.e eVar = (io.sentry.android.replay.e) obj;
                io.sentry.android.replay.s sVar = (io.sentry.android.replay.s) this.f;
                io.sentry.util.a aVar = sVar.f;
                aVar.g();
                try {
                    for (View view : sVar.A) {
                        if (eVar != null) {
                            eVar.g(view, true);
                        }
                        break;
                    }
                    vf2.e(aVar, null);
                    return super.add(eVar);
                } finally {
                }
        }
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public /* bridge */ boolean contains(Object obj) {
        switch (this.b) {
            case 1:
                if (obj == null ? true : obj instanceof io.sentry.android.replay.e) {
                    return super.contains((io.sentry.android.replay.e) obj);
                }
                return false;
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public /* bridge */ int indexOf(Object obj) {
        switch (this.b) {
            case 1:
                if (obj == null ? true : obj instanceof io.sentry.android.replay.e) {
                    return super.indexOf((io.sentry.android.replay.e) obj);
                }
                return -1;
            default:
                return super.indexOf(obj);
        }
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public /* bridge */ int lastIndexOf(Object obj) {
        switch (this.b) {
            case 1:
                if (obj == null ? true : obj instanceof io.sentry.android.replay.e) {
                    return super.lastIndexOf((io.sentry.android.replay.e) obj);
                }
                return -1;
            default:
                return super.lastIndexOf(obj);
        }
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public /* bridge */ boolean remove(Object obj) {
        switch (this.b) {
            case 1:
                if (obj == null ? true : obj instanceof io.sentry.android.replay.e) {
                    return super.remove((io.sentry.android.replay.e) obj);
                }
                return false;
            default:
                return super.remove(obj);
        }
    }
}
