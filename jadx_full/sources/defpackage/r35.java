package defpackage;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r35 extends mz4 implements t35 {
    @Override // defpackage.t35
    public final void beginAdUnitExposure(String str, long j) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeLong(j);
        E(parcelC, 23);
    }

    @Override // defpackage.t35
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        d35.b(parcelC, bundle);
        E(parcelC, 9);
    }

    @Override // defpackage.t35
    public final void endAdUnitExposure(String str, long j) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeLong(j);
        E(parcelC, 24);
    }

    @Override // defpackage.t35
    public final void generateEventId(v35 v35Var) {
        Parcel parcelC = c();
        d35.c(parcelC, v35Var);
        E(parcelC, 22);
    }

    @Override // defpackage.t35
    public final void getCachedAppInstanceId(v35 v35Var) {
        Parcel parcelC = c();
        d35.c(parcelC, v35Var);
        E(parcelC, 19);
    }

    @Override // defpackage.t35
    public final void getConditionalUserProperties(String str, String str2, v35 v35Var) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        d35.c(parcelC, v35Var);
        E(parcelC, 10);
    }

    @Override // defpackage.t35
    public final void getCurrentScreenClass(v35 v35Var) {
        Parcel parcelC = c();
        d35.c(parcelC, v35Var);
        E(parcelC, 17);
    }

    @Override // defpackage.t35
    public final void getCurrentScreenName(v35 v35Var) {
        Parcel parcelC = c();
        d35.c(parcelC, v35Var);
        E(parcelC, 16);
    }

    @Override // defpackage.t35
    public final void getGmpAppId(v35 v35Var) {
        Parcel parcelC = c();
        d35.c(parcelC, v35Var);
        E(parcelC, 21);
    }

    @Override // defpackage.t35
    public final void getMaxUserProperties(String str, v35 v35Var) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        d35.c(parcelC, v35Var);
        E(parcelC, 6);
    }

    @Override // defpackage.t35
    public final void getUserProperties(String str, String str2, boolean z, v35 v35Var) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        ClassLoader classLoader = d35.a;
        parcelC.writeInt(z ? 1 : 0);
        d35.c(parcelC, v35Var);
        E(parcelC, 5);
    }

    @Override // defpackage.t35
    public final void initialize(wv1 wv1Var, j45 j45Var, long j) {
        Parcel parcelC = c();
        d35.c(parcelC, wv1Var);
        d35.b(parcelC, j45Var);
        parcelC.writeLong(j);
        E(parcelC, 1);
    }

    @Override // defpackage.t35
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        d35.b(parcelC, bundle);
        parcelC.writeInt(z ? 1 : 0);
        parcelC.writeInt(1);
        parcelC.writeLong(j);
        E(parcelC, 2);
    }

    @Override // defpackage.t35
    public final void logHealthData(int i, String str, wv1 wv1Var, wv1 wv1Var2, wv1 wv1Var3) {
        Parcel parcelC = c();
        parcelC.writeInt(5);
        parcelC.writeString("Error with data collection. Data lost.");
        d35.c(parcelC, wv1Var);
        d35.c(parcelC, wv1Var2);
        d35.c(parcelC, wv1Var3);
        E(parcelC, 33);
    }

    @Override // defpackage.t35
    public final void onActivityCreatedByScionActivityInfo(k45 k45Var, Bundle bundle, long j) {
        Parcel parcelC = c();
        d35.b(parcelC, k45Var);
        d35.b(parcelC, bundle);
        parcelC.writeLong(j);
        E(parcelC, 53);
    }

    @Override // defpackage.t35
    public final void onActivityDestroyedByScionActivityInfo(k45 k45Var, long j) {
        Parcel parcelC = c();
        d35.b(parcelC, k45Var);
        parcelC.writeLong(j);
        E(parcelC, 54);
    }

    @Override // defpackage.t35
    public final void onActivityPausedByScionActivityInfo(k45 k45Var, long j) {
        Parcel parcelC = c();
        d35.b(parcelC, k45Var);
        parcelC.writeLong(j);
        E(parcelC, 55);
    }

    @Override // defpackage.t35
    public final void onActivityResumedByScionActivityInfo(k45 k45Var, long j) {
        Parcel parcelC = c();
        d35.b(parcelC, k45Var);
        parcelC.writeLong(j);
        E(parcelC, 56);
    }

    @Override // defpackage.t35
    public final void onActivitySaveInstanceStateByScionActivityInfo(k45 k45Var, v35 v35Var, long j) {
        Parcel parcelC = c();
        d35.b(parcelC, k45Var);
        d35.c(parcelC, v35Var);
        parcelC.writeLong(j);
        E(parcelC, 57);
    }

    @Override // defpackage.t35
    public final void onActivityStartedByScionActivityInfo(k45 k45Var, long j) {
        Parcel parcelC = c();
        d35.b(parcelC, k45Var);
        parcelC.writeLong(j);
        E(parcelC, 51);
    }

    @Override // defpackage.t35
    public final void onActivityStoppedByScionActivityInfo(k45 k45Var, long j) {
        Parcel parcelC = c();
        d35.b(parcelC, k45Var);
        parcelC.writeLong(j);
        E(parcelC, 52);
    }

    @Override // defpackage.t35
    public final void retrieveAndUploadBatches(x35 x35Var) {
        Parcel parcelC = c();
        d35.c(parcelC, x35Var);
        E(parcelC, 58);
    }

    @Override // defpackage.t35
    public final void setConditionalUserProperty(Bundle bundle, long j) {
        Parcel parcelC = c();
        d35.b(parcelC, bundle);
        parcelC.writeLong(j);
        E(parcelC, 8);
    }

    @Override // defpackage.t35
    public final void setCurrentScreenByScionActivityInfo(k45 k45Var, String str, String str2, long j) {
        Parcel parcelC = c();
        d35.b(parcelC, k45Var);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeLong(j);
        E(parcelC, 50);
    }

    @Override // defpackage.t35
    public final void setDataCollectionEnabled(boolean z) {
        throw null;
    }
}
