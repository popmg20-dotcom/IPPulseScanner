package io.sentry;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e5 implements k2 {
    public final String A;
    public HashMap A0;
    public final o5 X;
    public final int Y;
    public final Callable Z;
    public final String b;
    public final Integer f;
    public final String y0;
    public final String z;
    public final Callable z0;

    public e5(o5 o5Var, int i, Callable callable, String str, String str2, String str3, String str4, Integer num, Callable callable2) {
        io.sentry.util.b.r(o5Var, "type is required");
        this.X = o5Var;
        this.b = str;
        this.Y = i;
        this.z = str2;
        this.Z = callable;
        this.y0 = str3;
        this.A = str4;
        this.f = num;
        this.z0 = callable2;
    }

    public final int a() {
        Callable callable = this.Z;
        if (callable == null) {
            return this.Y;
        }
        try {
            return ((Integer) callable.call()).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        String str = this.b;
        if (str != null) {
            cVar.p("content_type");
            cVar.y(str);
        }
        String str2 = this.z;
        if (str2 != null) {
            cVar.p("filename");
            cVar.y(str2);
        }
        cVar.p("type");
        cVar.v(iLogger, this.X);
        String str3 = this.y0;
        if (str3 != null) {
            cVar.p("attachment_type");
            cVar.y(str3);
        }
        String str4 = this.A;
        if (str4 != null) {
            cVar.p("platform");
            cVar.y(str4);
        }
        Integer num = this.f;
        if (num != null) {
            cVar.p("item_count");
            cVar.x(num);
        }
        cVar.p("length");
        cVar.u(a());
        Integer num2 = null;
        Callable callable = this.z0;
        if (callable != null) {
            try {
                num2 = (Integer) callable.call();
            } catch (Throwable unused) {
            }
        }
        if (num2 != null) {
            cVar.p("meta_length");
            cVar.x(num2);
        }
        HashMap map = this.A0;
        if (map != null) {
            for (String str5 : map.keySet()) {
                e.c(this.A0, str5, cVar, str5, iLogger);
            }
        }
        cVar.m();
    }

    public e5(o5 o5Var, Callable callable, String str, String str2, String str3, String str4, Integer num) {
        this(o5Var, -1, callable, str, str2, str3, str4, num, null);
    }

    public e5(o5 o5Var, Callable callable, String str, String str2, String str3) {
        this(o5Var, callable, str, str2, str3, null, null);
    }
}
