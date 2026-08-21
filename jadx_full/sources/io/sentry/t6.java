package io.sentry;

import defpackage.st4;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t6 extends defpackage.m0 {
    public static final List u = DesugarCollections.unmodifiableList(Arrays.asList("Content-Type", "Content-Length", "Accept"));
    public volatile boolean c;
    public Double d;
    public Double e;
    public s6 f;
    public int g;
    public long h;
    public long i;
    public long j;
    public boolean k;
    public io.sentry.protocol.u l;
    public boolean m;
    public m4 n;
    public boolean o;
    public List p;
    public List q;
    public boolean r;
    public List s;
    public List t;

    public final void A(ArrayList arrayList) {
        this.p = DesugarCollections.unmodifiableList(new ArrayList(arrayList));
    }

    public final void B(ArrayList arrayList) {
        this.q = DesugarCollections.unmodifiableList(new ArrayList(arrayList));
    }

    public final void C(ArrayList arrayList) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(u);
        linkedHashSet.addAll(arrayList);
        this.s = DesugarCollections.unmodifiableList(new ArrayList(linkedHashSet));
    }

    public final void D(ArrayList arrayList) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(u);
        linkedHashSet.addAll(arrayList);
        this.t = DesugarCollections.unmodifiableList(new ArrayList(linkedHashSet));
    }

    public final void E(Double d) {
        if (io.sentry.util.b.m(d, true)) {
            this.e = d;
        } else {
            st4.p("The value ", d, " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
        }
    }

    public final void F(Double d) {
        if (io.sentry.util.b.m(d, true)) {
            this.d = d;
        } else {
            st4.p("The value ", d, " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
        }
    }

    @Override // defpackage.m0
    public final void u(boolean z) {
        if (!z) {
            y();
        }
        super.u(z);
    }

    @Override // defpackage.m0
    public final void v(boolean z) {
        if (!z) {
            y();
        }
        super.v(z);
    }

    @Override // defpackage.m0
    public final void y() {
        if (this.c) {
            return;
        }
        this.c = true;
        io.sentry.util.b.a("ReplayCustomMasking");
    }
}
