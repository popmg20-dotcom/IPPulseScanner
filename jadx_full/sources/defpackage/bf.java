package defpackage;

import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bf implements Parcelable {
    public static final Parcelable.Creator<bf> CREATOR = new o3(4);

    /* JADX WARN: Removed duplicated region for block: B:42:0x00f1 A[Catch: all -> 0x0058, TryCatch #2 {all -> 0x0058, blocks: (B:4:0x0007, B:42:0x00f1, B:44:0x0123, B:46:0x012b, B:48:0x0136, B:49:0x0139, B:53:0x0155, B:67:0x0168, B:68:0x016b, B:7:0x001a, B:9:0x0022, B:11:0x002c, B:13:0x003e, B:17:0x005d, B:19:0x006b, B:21:0x006f, B:23:0x0074, B:25:0x007a, B:28:0x0086, B:30:0x0090, B:32:0x009c, B:34:0x00a6, B:36:0x00c1, B:38:0x00cf, B:40:0x00d3, B:41:0x00d6, B:65:0x0166, B:50:0x0147, B:52:0x0152, B:63:0x0162, B:64:0x0165), top: B:75:0x0007, inners: #1, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File a() {
        File file;
        String str;
        String str2;
        synchronized (ko1.a) {
            try {
                SharedPreferences sharedPreferences = ko1.b;
                ge0 ge0Var = null;
                String string = sharedPreferences.getString(RtspHeaders.Values.URL, null);
                String string2 = sharedPreferences.getString("file_name", null);
                if (string != null || string2 != null) {
                    file = ko1.e;
                    if (!file.exists() || file.length() <= 0) {
                        InputStream inputStreamOpen = ContextUtilsKt.getContext().getAssets().open("dbsize");
                        inputStreamOpen.getClass();
                        long j = Long.parseLong((String) d70.d0(p44.B0(new String(l72.S(inputStreamOpen), y30.a))));
                        File file2 = ko1.f;
                        if (!file2.exists() || file2.length() != j) {
                            ko1.c.mkdirs();
                            if (!file2.exists()) {
                                file2.createNewFile();
                            }
                            InputStream inputStreamOpen2 = ContextUtilsKt.getContext().getAssets().open("Country.mmdb");
                            try {
                                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                try {
                                    inputStreamOpen2.getClass();
                                    l72.h(inputStreamOpen2, fileOutputStream);
                                    fileOutputStream.close();
                                    inputStreamOpen2.close();
                                } finally {
                                }
                            } finally {
                            }
                        }
                        file = file2;
                    } else {
                        String str3 = "getGeoIPDatabaseStream: " + file;
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 1, "GeoIPConfig", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str3);
                            str = str3;
                        } else {
                            str = str3;
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d("GeoIPConfig", str, null);
                        }
                        if (string != null) {
                            Long lValueOf = file.exists() ? Long.valueOf(file.lastModified()) : null;
                            if (System.currentTimeMillis() - (lValueOf != null ? lValueOf.longValue() : Long.MAX_VALUE) > 86400000) {
                                String strConcat = "trigger geoip database file auto update: ".concat(string);
                                if (fy4.b) {
                                    Xlog.logWrite2(0L, 1, "GeoIPConfig", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                                    str2 = strConcat;
                                } else {
                                    str2 = strConcat;
                                }
                                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                    Log.d("GeoIPConfig", str2, null);
                                }
                                x32 x32VarB = je.b();
                                gm0 gm0Var = qv0.a;
                                ji0.B(p95.a(tj4.W(x32VarB, pl0.z)), null, null, new jo1(string, ge0Var, 0), 3);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return bf.class.equals(obj != null ? obj.getClass() : null);
    }

    public final int hashCode() {
        return bf.class.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeInt(1);
    }
}
