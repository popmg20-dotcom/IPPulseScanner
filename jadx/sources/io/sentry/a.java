package io.sentry;

import defpackage.ft4;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final byte[] a;
    public final io.sentry.protocol.k0 b;
    public final ft4 c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public a(io.sentry.protocol.k0 k0Var) {
        this.a = null;
        this.b = k0Var;
        this.c = null;
        this.e = "view-hierarchy.json";
        this.f = HttpHeaders.Values.APPLICATION_JSON;
        this.g = "event.view_hierarchy";
    }

    public a(String str, String str2, String str3, byte[] bArr) {
        this.a = bArr;
        this.b = null;
        this.c = null;
        this.e = str;
        this.f = str2;
        this.g = str3;
    }

    public a(String str, String str2, byte[] bArr) {
        this(str, str2, "event.attachment", bArr);
    }

    public a(ft4 ft4Var) {
        this.a = null;
        this.b = null;
        this.c = ft4Var;
        this.e = "screenshot.png";
        this.f = "image/png";
        this.g = "event.attachment";
    }

    public a(String str) {
        this.d = str;
        this.e = "logcat.txt";
        this.b = null;
        this.c = null;
        this.f = HttpPostBodyUtil.DEFAULT_TEXT_CONTENT_TYPE;
        this.g = "event.attachment";
    }
}
