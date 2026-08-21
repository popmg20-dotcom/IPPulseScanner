package io.sentry.android.replay;

import defpackage.bh3;
import defpackage.d70;
import defpackage.j70;
import defpackage.kb0;
import defpackage.le1;
import defpackage.n84;
import defpackage.p44;
import defpackage.vf2;
import defpackage.y30;
import io.sentry.p5;
import io.sentry.p6;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Closeable {
    public final io.sentry.util.a A;
    public final LinkedHashMap A0;
    public final n84 B0;
    public final io.sentry.util.a X;
    public final io.sentry.util.a Y;
    public io.sentry.android.core.d Z;
    public final p6 b;
    public final io.sentry.protocol.w f;
    public final n84 y0;
    public final AtomicBoolean z;
    public final ArrayList z0;

    public j(p6 p6Var, io.sentry.protocol.w wVar) {
        p6Var.getClass();
        wVar.getClass();
        this.b = p6Var;
        this.f = wVar;
        this.z = new AtomicBoolean(false);
        this.A = new io.sentry.util.a();
        this.X = new io.sentry.util.a();
        this.Y = new io.sentry.util.a();
        this.y0 = new n84(new g(this, 1));
        this.z0 = new ArrayList();
        this.A0 = new LinkedHashMap();
        this.B0 = new n84(new g(this, 0));
    }

    public final String C(long j) {
        bh3 bh3Var = new bh3();
        io.sentry.util.a aVar = this.Y;
        aVar.g();
        try {
            d70.o0(this.z0, new i(j, this, bh3Var, 0));
            vf2.e(aVar, null);
            return (String) bh3Var.b;
        } finally {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        io.sentry.util.a aVar = this.A;
        aVar.g();
        try {
            io.sentry.android.core.d dVar = this.Z;
            if (dVar != null) {
                dVar.f();
            }
            this.Z = null;
            vf2.e(aVar, null);
            this.z.set(true);
        } finally {
        }
    }

    public final void g(File file, long j, String str) {
        k kVar = new k(file, j, str);
        io.sentry.util.a aVar = this.Y;
        aVar.g();
        try {
            this.z0.add(kVar);
            vf2.e(aVar, null);
        } finally {
        }
    }

    public final void n(File file) {
        p6 p6Var = this.b;
        try {
            if (file.delete()) {
                return;
            }
            p6Var.getLogger().h(p5.ERROR, "Failed to delete replay frame: %s", file.getAbsolutePath());
        } catch (Throwable th) {
            p6Var.getLogger().b(p5.ERROR, th, "Failed to delete replay frame: %s", file.getAbsolutePath());
        }
    }

    public final File s() {
        return (File) this.y0.getValue();
    }

    public final void x(String str, String str2) {
        File file;
        File file2;
        n84 n84Var = this.B0;
        LinkedHashMap linkedHashMap = this.A0;
        io.sentry.util.a aVar = this.X;
        aVar.g();
        try {
            if (this.z.get()) {
                vf2.e(aVar, null);
                return;
            }
            File file3 = (File) n84Var.getValue();
            if ((file3 == null || !file3.exists()) && (file = (File) n84Var.getValue()) != null) {
                file.createNewFile();
            }
            if (linkedHashMap.isEmpty() && (file2 = (File) n84Var.getValue()) != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2), y30.a), 8192);
                try {
                    Iterator it = new kb0(new j70(1, bufferedReader)).iterator();
                    while (it.hasNext()) {
                        List listL0 = p44.L0((String) it.next(), new String[]{"="}, 2);
                        linkedHashMap.put((String) listL0.get(0), (String) listL0.get(1));
                    }
                    bufferedReader.close();
                } finally {
                }
            }
            if (str2 == null) {
                linkedHashMap.remove(str);
            } else {
                linkedHashMap.put(str, str2);
            }
            File file4 = (File) n84Var.getValue();
            if (file4 != null) {
                Set setEntrySet = linkedHashMap.entrySet();
                setEntrySet.getClass();
                le1.W(file4, d70.j0(setEntrySet, "\n", null, null, h.f, 30));
            }
            vf2.e(aVar, null);
        } finally {
        }
    }
}
