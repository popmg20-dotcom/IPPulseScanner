package io.sentry.android.core;

import android.content.SharedPreferences;
import defpackage.l75;
import defpackage.tj4;
import j$.util.Objects;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u {
    public final long a;
    public boolean b;
    public long c;
    public final Object d;
    public final Object e;

    public u(l75 l75Var, String str, long j) {
        Objects.requireNonNull(l75Var);
        this.e = l75Var;
        tj4.f(str);
        this.d = str;
        this.a = j;
    }

    public long a() {
        if (!this.b) {
            this.b = true;
            l75 l75Var = (l75) this.e;
            this.c = l75Var.Z0().getLong((String) this.d, this.a);
        }
        return this.c;
    }

    public void b(long j) {
        SharedPreferences.Editor editorEdit = ((l75) this.e).Z0().edit();
        editorEdit.putLong((String) this.d, j);
        editorEdit.apply();
        this.c = j;
    }

    public u(long j, long j2, boolean z, File file, HashMap map) {
        this.a = j;
        this.d = file;
        this.c = j2;
        this.e = map;
        this.b = z;
    }
}
