package defpackage;

import android.net.NetworkRequest;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mc0 {
    public static final mc0 j = new mc0();
    public final pr2 a;
    public final hr2 b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final long g;
    public final long h;
    public final Set i;

    public mc0(mc0 mc0Var) {
        mc0Var.getClass();
        this.c = mc0Var.c;
        this.d = mc0Var.d;
        this.b = mc0Var.b;
        this.a = mc0Var.a;
        this.e = mc0Var.e;
        this.f = mc0Var.f;
        this.i = mc0Var.i;
        this.g = mc0Var.g;
        this.h = mc0Var.h;
    }

    public final NetworkRequest a() {
        return (NetworkRequest) this.b.a;
    }

    public final boolean b() {
        return Build.VERSION.SDK_INT < 24 || !this.i.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !mc0.class.equals(obj.getClass())) {
            return false;
        }
        mc0 mc0Var = (mc0) obj;
        if (this.c == mc0Var.c && this.d == mc0Var.d && this.e == mc0Var.e && this.f == mc0Var.f && this.g == mc0Var.g && this.h == mc0Var.h && n12.c(a(), mc0Var.a()) && this.a == mc0Var.a) {
            return this.i.equals(mc0Var.i);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((((((this.a.hashCode() * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31;
        long j2 = this.g;
        int i = (iHashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.h;
        int iHashCode2 = (this.i.hashCode() + ((i + ((int) (j3 ^ (j3 >>> 32)))) * 31)) * 31;
        NetworkRequest networkRequestA = a();
        return iHashCode2 + (networkRequestA != null ? networkRequestA.hashCode() : 0);
    }

    public final String toString() {
        return "Constraints{requiredNetworkType=" + this.a + ", requiresCharging=" + this.c + ", requiresDeviceIdle=" + this.d + ", requiresBatteryNotLow=" + this.e + ", requiresStorageNotLow=" + this.f + ", contentTriggerUpdateDelayMillis=" + this.g + ", contentTriggerMaxDelayMillis=" + this.h + ", contentUriTriggers=" + this.i + ", }";
    }

    public mc0(hr2 hr2Var, pr2 pr2Var, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, LinkedHashSet linkedHashSet) {
        this.b = hr2Var;
        this.a = pr2Var;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = z4;
        this.g = j2;
        this.h = j3;
        this.i = linkedHashSet;
    }

    public mc0() {
        this.b = new hr2(null);
        this.a = pr2.b;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = -1L;
        this.h = -1L;
        this.i = k41.b;
    }
}
