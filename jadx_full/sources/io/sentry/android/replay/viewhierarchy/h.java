package io.sentry.android.replay.viewhierarchy;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public final int a;
    public final int b;
    public final float c;
    public final boolean d;
    public final boolean e;
    public final Rect f;
    public ArrayList g;

    public h(int i, int i2, float f, h hVar, boolean z, boolean z2, Rect rect) {
        this.a = i;
        this.b = i2;
        this.c = f;
        this.d = z;
        this.e = z2;
        this.f = rect;
    }

    public final void a(io.sentry.android.replay.util.f fVar) {
        ArrayList arrayList;
        if (!((Boolean) fVar.g(this)).booleanValue() || (arrayList = this.g) == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((h) it.next()).a(fVar);
        }
    }
}
