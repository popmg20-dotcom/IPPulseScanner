package defpackage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import io.sentry.android.core.u;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l75 extends k95 {
    public static final Pair T0 = new Pair("", 0L);
    public final ue1 A0;
    public String B0;
    public boolean C0;
    public long D0;
    public final u E0;
    public final f75 F0;
    public final ue1 G0;
    public final ih4 H0;
    public final f75 I0;
    public final u J0;
    public final u K0;
    public boolean L0;
    public final f75 M0;
    public final f75 N0;
    public final u O0;
    public final ue1 P0;
    public final ue1 Q0;
    public final u R0;
    public final ih4 S0;
    public SharedPreferences Y;
    public SharedPreferences Z;
    public i40 y0;
    public final u z0;

    public l75(k85 k85Var) {
        super(k85Var);
        this.E0 = new u(this, "session_timeout", 1800000L);
        this.F0 = new f75(this, "start_new_session", true);
        this.J0 = new u(this, "last_pause_time", 0L);
        this.K0 = new u(this, "session_id", 0L);
        this.G0 = new ue1(this, "non_personalized_ads");
        this.H0 = new ih4(this, "last_received_uri_timestamps_by_source");
        this.I0 = new f75(this, "allow_remote_dynamite", false);
        this.z0 = new u(this, "first_open_time", 0L);
        tj4.f("app_install_time");
        this.A0 = new ue1(this, "app_instance_id");
        this.M0 = new f75(this, "app_backgrounded", false);
        this.N0 = new f75(this, "deep_link_retrieval_complete", false);
        this.O0 = new u(this, "deep_link_retrieval_attempts", 0L);
        this.P0 = new ue1(this, "firebase_feature_rollouts");
        this.Q0 = new ue1(this, "deferred_attribution_cache");
        this.R0 = new u(this, "deferred_attribution_cache_timestamp", 0L);
        this.S0 = new ih4(this, "default_event_parameters");
    }

    @Override // defpackage.k95
    public final boolean W0() {
        return true;
    }

    public final SharedPreferences Z0() {
        V0();
        X0();
        tj4.i(this.Y);
        return this.Y;
    }

    public final SharedPreferences a1() {
        V0();
        X0();
        SharedPreferences sharedPreferences = this.Z;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        k85 k85Var = (k85) this.f;
        String strValueOf = String.valueOf(k85Var.b.getPackageName());
        t65 t65Var = k85Var.Y;
        k85.h(t65Var);
        q65 q65Var = t65Var.H0;
        String strConcat = strValueOf.concat("_preferences");
        q65Var.b(strConcat, "Default prefs file");
        SharedPreferences sharedPreferences2 = k85Var.b.getSharedPreferences(strConcat, 0);
        this.Z = sharedPreferences2;
        return sharedPreferences2;
    }

    public final SparseArray b1() {
        Bundle bundleF = this.H0.f();
        int[] intArray = bundleF.getIntArray("uriSources");
        long[] longArray = bundleF.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.z0.a("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < intArray.length; i++) {
            sparseArray.put(intArray[i], Long.valueOf(longArray[i]));
        }
        return sparseArray;
    }

    public final t95 c1() {
        V0();
        return t95.c(Z0().getInt("consent_source", 100), Z0().getString("consent_settings", "G1"));
    }

    public final boolean d1(ae5 ae5Var) {
        V0();
        String string = Z0().getString("stored_tcf_param", "");
        String strA = ae5Var.a();
        if (strA.equals(string)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = Z0().edit();
        editorEdit.putString("stored_tcf_param", strA);
        editorEdit.apply();
        return true;
    }

    public final void e1(boolean z) {
        V0();
        t65 t65Var = ((k85) this.f).Y;
        k85.h(t65Var);
        t65Var.H0.b(Boolean.valueOf(z), "App measurement setting deferred collection");
        SharedPreferences.Editor editorEdit = Z0().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z);
        editorEdit.apply();
    }

    public final boolean f1(long j) {
        return j - this.E0.a() > this.J0.a();
    }
}
