package io.sentry;

import io.netty.handler.codec.rtsp.RtspHeaders;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v3 implements k2 {
    public boolean A0;
    public String B0;
    public String D0;
    public String E0;
    public String F0;
    public final ArrayList G0;
    public String H0;
    public String I0;
    public String J0;
    public String K0;
    public String L0;
    public String M0;
    public String N0;
    public String O0;
    public String P0;
    public Date Q0;
    public final HashMap R0;
    public ConcurrentHashMap T0;
    public String X;
    public String Y;
    public String Z;
    public final File b;
    public final Callable f;
    public String y0;
    public int z;
    public String z0;
    public List C0 = new ArrayList();
    public String S0 = null;
    public String A = Locale.getDefault().toString();

    public v3(File file, Date date, ArrayList arrayList, String str, String str2, String str3, String str4, int i, String str5, Callable callable, String str6, String str7, String str8, Boolean bool, String str9, String str10, String str11, String str12, String str13, HashMap map) {
        this.b = file;
        this.Q0 = date;
        this.B0 = str5;
        this.f = callable;
        this.z = i;
        this.X = str6 == null ? "" : str6;
        this.Y = str7 == null ? "" : str7;
        this.z0 = str8 != null ? str8 : "";
        this.A0 = bool != null ? bool.booleanValue() : false;
        this.D0 = str9 != null ? str9 : "0";
        this.Z = "";
        this.y0 = "android";
        this.E0 = "android";
        this.F0 = str10 != null ? str10 : "";
        this.G0 = arrayList;
        this.H0 = str.isEmpty() ? "unknown" : str;
        this.I0 = str4;
        this.J0 = "";
        this.K0 = str11 != null ? str11 : "";
        this.L0 = str2;
        this.M0 = str3;
        this.N0 = io.sentry.config.a.f();
        this.O0 = str12 != null ? str12 : "production";
        this.P0 = str13;
        if (!str13.equals("normal") && !this.P0.equals(RtspHeaders.Values.TIMEOUT) && !this.P0.equals("backgrounded")) {
            this.P0 = "normal";
        }
        this.R0 = map;
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("android_api_level");
        cVar.v(iLogger, Integer.valueOf(this.z));
        cVar.p("device_locale");
        cVar.v(iLogger, this.A);
        cVar.p("device_manufacturer");
        cVar.y(this.X);
        cVar.p("device_model");
        cVar.y(this.Y);
        cVar.p("device_os_build_number");
        cVar.y(this.Z);
        cVar.p("device_os_name");
        cVar.y(this.y0);
        cVar.p("device_os_version");
        cVar.y(this.z0);
        cVar.p("device_is_emulator");
        cVar.z(this.A0);
        cVar.p("architecture");
        cVar.v(iLogger, this.B0);
        cVar.p("device_cpu_frequencies");
        cVar.v(iLogger, this.C0);
        cVar.p("device_physical_memory_bytes");
        cVar.y(this.D0);
        cVar.p("platform");
        cVar.y(this.E0);
        cVar.p("build_id");
        cVar.y(this.F0);
        cVar.p("transaction_name");
        cVar.y(this.H0);
        cVar.p("duration_ns");
        cVar.y(this.I0);
        cVar.p("version_name");
        cVar.y(this.K0);
        cVar.p("version_code");
        cVar.y(this.J0);
        ArrayList arrayList = this.G0;
        if (!arrayList.isEmpty()) {
            cVar.p("transactions");
            cVar.v(iLogger, arrayList);
        }
        cVar.p("transaction_id");
        cVar.y(this.L0);
        cVar.p("trace_id");
        cVar.y(this.M0);
        cVar.p("profile_id");
        cVar.y(this.N0);
        cVar.p("environment");
        cVar.y(this.O0);
        cVar.p("truncation_reason");
        cVar.y(this.P0);
        if (this.S0 != null) {
            cVar.p("sampled_profile");
            cVar.y(this.S0);
        }
        String str = ((io.sentry.vendor.gson.stream.c) cVar.f).A;
        cVar.s("");
        cVar.p("measurements");
        cVar.v(iLogger, this.R0);
        cVar.s(str);
        cVar.p("timestamp");
        cVar.v(iLogger, this.Q0);
        ConcurrentHashMap concurrentHashMap = this.T0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                e.d(this.T0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
