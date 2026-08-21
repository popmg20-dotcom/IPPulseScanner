package defpackage;

import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.Pair;
import io.sentry.android.core.u;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fd5 extends pe5 {
    public final u A0;
    public final u B0;
    public final u C0;
    public final u D0;
    public final HashMap Z;
    public final u y0;
    public final u z0;

    public fd5(ff5 ff5Var) {
        super(ff5Var);
        this.Z = new HashMap();
        l75 l75Var = ((k85) this.f).X;
        k85.f(l75Var);
        this.y0 = new u(l75Var, "last_delete_stale", 0L);
        l75 l75Var2 = ((k85) this.f).X;
        k85.f(l75Var2);
        this.z0 = new u(l75Var2, "last_delete_stale_batch", 0L);
        l75 l75Var3 = ((k85) this.f).X;
        k85.f(l75Var3);
        this.A0 = new u(l75Var3, "backoff", 0L);
        l75 l75Var4 = ((k85) this.f).X;
        k85.f(l75Var4);
        this.B0 = new u(l75Var4, "last_upload", 0L);
        l75 l75Var5 = ((k85) this.f).X;
        k85.f(l75Var5);
        this.C0 = new u(l75Var5, "last_upload_attempt", 0L);
        l75 l75Var6 = ((k85) this.f).X;
        k85.f(l75Var6);
        this.D0 = new u(l75Var6, "midnight_offset", 0L);
    }

    public final Pair Z0(String str) {
        ed5 ed5Var;
        h6 h6VarA;
        V0();
        k85 k85Var = (k85) this.f;
        wl3 wl3Var = k85Var.B0;
        x15 x15Var = k85Var.A;
        wl3Var.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashMap map = this.Z;
        ed5 ed5Var2 = (ed5) map.get(str);
        if (ed5Var2 != null && jElapsedRealtime < ed5Var2.c) {
            return new Pair(ed5Var2.a, Boolean.valueOf(ed5Var2.b));
        }
        long jC1 = x15Var.c1(str, r55.b) + jElapsedRealtime;
        try {
            try {
                h6VarA = i6.a(k85Var.b);
            } catch (PackageManager.NameNotFoundException unused) {
                if (ed5Var2 != null && jElapsedRealtime < ed5Var2.c + x15Var.c1(str, r55.c)) {
                    return new Pair(ed5Var2.a, Boolean.valueOf(ed5Var2.b));
                }
                h6VarA = null;
            }
        } catch (Exception e) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.G0.b(e, "Unable to get advertising id");
            ed5Var = new ed5("", false, jC1);
        }
        if (h6VarA == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String str2 = h6VarA.c;
        ed5Var = str2 != null ? new ed5(str2, h6VarA.b, jC1) : new ed5("", h6VarA.b, jC1);
        map.put(str, ed5Var);
        return new Pair(ed5Var.a, Boolean.valueOf(ed5Var.b));
    }

    public final String a1(String str, boolean z) {
        V0();
        String str2 = z ? (String) Z0(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestM1 = qf5.m1();
        if (messageDigestM1 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestM1.digest(str2.getBytes())));
    }

    @Override // defpackage.pe5
    public final void Y0() {
    }
}
