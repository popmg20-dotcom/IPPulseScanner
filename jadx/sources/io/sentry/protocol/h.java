package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h implements k2 {
    public String A;
    public Boolean A0;
    public g B0;
    public Boolean C0;
    public Long D0;
    public Long E0;
    public Long F0;
    public Boolean G0;
    public Long H0;
    public Long I0;
    public Long J0;
    public Long K0;
    public Integer L0;
    public Integer M0;
    public Float N0;
    public Integer O0;
    public Date P0;
    public TimeZone Q0;
    public String R0;
    public String S0;
    public String T0;
    public Float U0;
    public Integer V0;
    public Double W0;
    public String X;
    public String X0;
    public String Y;
    public String Y0;
    public String[] Z;
    public ConcurrentHashMap Z0;
    public String b;
    public String f;
    public Float y0;
    public String z;
    public Boolean z0;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && h.class == obj.getClass()) {
            h hVar = (h) obj;
            if (io.sentry.util.b.i(this.b, hVar.b) && io.sentry.util.b.i(this.f, hVar.f) && io.sentry.util.b.i(this.z, hVar.z) && io.sentry.util.b.i(this.A, hVar.A) && io.sentry.util.b.i(this.X, hVar.X) && io.sentry.util.b.i(this.Y, hVar.Y) && Arrays.equals(this.Z, hVar.Z) && io.sentry.util.b.i(this.y0, hVar.y0) && io.sentry.util.b.i(this.z0, hVar.z0) && io.sentry.util.b.i(this.A0, hVar.A0) && this.B0 == hVar.B0 && io.sentry.util.b.i(this.C0, hVar.C0) && io.sentry.util.b.i(this.D0, hVar.D0) && io.sentry.util.b.i(this.E0, hVar.E0) && io.sentry.util.b.i(this.F0, hVar.F0) && io.sentry.util.b.i(this.G0, hVar.G0) && io.sentry.util.b.i(this.H0, hVar.H0) && io.sentry.util.b.i(this.I0, hVar.I0) && io.sentry.util.b.i(this.J0, hVar.J0) && io.sentry.util.b.i(this.K0, hVar.K0) && io.sentry.util.b.i(this.L0, hVar.L0) && io.sentry.util.b.i(this.M0, hVar.M0) && io.sentry.util.b.i(this.N0, hVar.N0) && io.sentry.util.b.i(this.O0, hVar.O0) && io.sentry.util.b.i(this.P0, hVar.P0) && io.sentry.util.b.i(this.R0, hVar.R0) && io.sentry.util.b.i(this.S0, hVar.S0) && io.sentry.util.b.i(this.T0, hVar.T0) && io.sentry.util.b.i(this.U0, hVar.U0) && io.sentry.util.b.i(this.V0, hVar.V0) && io.sentry.util.b.i(this.W0, hVar.W0) && io.sentry.util.b.i(this.X0, hVar.X0) && io.sentry.util.b.i(this.Y0, hVar.Y0)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Arrays.hashCode(new Object[]{this.b, this.f, this.z, this.A, this.X, this.Y, this.y0, this.z0, this.A0, this.B0, this.C0, this.D0, this.E0, this.F0, this.G0, this.H0, this.I0, this.J0, this.K0, this.L0, this.M0, this.N0, this.O0, this.P0, this.Q0, this.R0, this.S0, this.T0, this.U0, this.V0, this.W0, this.X0, this.Y0}) * 31) + Arrays.hashCode(this.Z);
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("name");
            cVar.y(this.b);
        }
        if (this.f != null) {
            cVar.p("manufacturer");
            cVar.y(this.f);
        }
        if (this.z != null) {
            cVar.p("brand");
            cVar.y(this.z);
        }
        if (this.A != null) {
            cVar.p("family");
            cVar.y(this.A);
        }
        if (this.X != null) {
            cVar.p("model");
            cVar.y(this.X);
        }
        if (this.Y != null) {
            cVar.p("model_id");
            cVar.y(this.Y);
        }
        if (this.Z != null) {
            cVar.p("archs");
            cVar.v(iLogger, this.Z);
        }
        if (this.y0 != null) {
            cVar.p("battery_level");
            cVar.x(this.y0);
        }
        if (this.z0 != null) {
            cVar.p("charging");
            cVar.w(this.z0);
        }
        if (this.A0 != null) {
            cVar.p("online");
            cVar.w(this.A0);
        }
        if (this.B0 != null) {
            cVar.p("orientation");
            cVar.v(iLogger, this.B0);
        }
        if (this.C0 != null) {
            cVar.p("simulator");
            cVar.w(this.C0);
        }
        if (this.D0 != null) {
            cVar.p("memory_size");
            cVar.x(this.D0);
        }
        if (this.E0 != null) {
            cVar.p("free_memory");
            cVar.x(this.E0);
        }
        if (this.F0 != null) {
            cVar.p("usable_memory");
            cVar.x(this.F0);
        }
        if (this.G0 != null) {
            cVar.p("low_memory");
            cVar.w(this.G0);
        }
        if (this.H0 != null) {
            cVar.p("storage_size");
            cVar.x(this.H0);
        }
        if (this.I0 != null) {
            cVar.p("free_storage");
            cVar.x(this.I0);
        }
        if (this.J0 != null) {
            cVar.p("external_storage_size");
            cVar.x(this.J0);
        }
        if (this.K0 != null) {
            cVar.p("external_free_storage");
            cVar.x(this.K0);
        }
        if (this.L0 != null) {
            cVar.p("screen_width_pixels");
            cVar.x(this.L0);
        }
        if (this.M0 != null) {
            cVar.p("screen_height_pixels");
            cVar.x(this.M0);
        }
        if (this.N0 != null) {
            cVar.p("screen_density");
            cVar.x(this.N0);
        }
        if (this.O0 != null) {
            cVar.p("screen_dpi");
            cVar.x(this.O0);
        }
        if (this.P0 != null) {
            cVar.p("boot_time");
            cVar.v(iLogger, this.P0);
        }
        if (this.Q0 != null) {
            cVar.p("timezone");
            cVar.v(iLogger, this.Q0);
        }
        if (this.R0 != null) {
            cVar.p("id");
            cVar.y(this.R0);
        }
        if (this.T0 != null) {
            cVar.p("connection_type");
            cVar.y(this.T0);
        }
        if (this.U0 != null) {
            cVar.p("battery_temperature");
            cVar.x(this.U0);
        }
        if (this.S0 != null) {
            cVar.p("locale");
            cVar.y(this.S0);
        }
        if (this.V0 != null) {
            cVar.p("processor_count");
            cVar.x(this.V0);
        }
        if (this.W0 != null) {
            cVar.p("processor_frequency");
            cVar.x(this.W0);
        }
        if (this.X0 != null) {
            cVar.p("cpu_description");
            cVar.y(this.X0);
        }
        if (this.Y0 != null) {
            cVar.p("chipset");
            cVar.y(this.Y0);
        }
        ConcurrentHashMap concurrentHashMap = this.Z0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.Z0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
