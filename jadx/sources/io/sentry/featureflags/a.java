package io.sentry.featureflags;

import defpackage.dw2;
import io.sentry.protocol.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b {
    public volatile CopyOnWriteArrayList b;
    public final io.sentry.util.a f;

    public a(a aVar) {
        this.f = new io.sentry.util.a();
        this.b = new CopyOnWriteArrayList(aVar.b);
    }

    @Override // io.sentry.featureflags.b
    public final void clear() {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            this.b.clear();
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // io.sentry.featureflags.b
    public final b clone() {
        return new a(this);
    }

    @Override // io.sentry.featureflags.b
    public final j d() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.b.iterator();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
        return new j(arrayList);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public final Object m4clone() {
        return new a(this);
    }

    public a(int i, CopyOnWriteArrayList copyOnWriteArrayList) {
        this.f = new io.sentry.util.a();
        this.b = copyOnWriteArrayList;
    }

    public a(int i) {
        this.f = new io.sentry.util.a();
        this.b = new CopyOnWriteArrayList();
    }
}
