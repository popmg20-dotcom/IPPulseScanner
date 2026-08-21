package defpackage;

import android.os.Bundle;
import j$.util.Objects;
import java.util.EnumMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o25 {
    public static final o25 f = new o25((Boolean) null, 100, (Boolean) null, (String) null);
    public final int a;
    public final String b;
    public final Boolean c;
    public final String d;
    public final EnumMap e;

    public o25(Boolean bool, int i, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(r95.class);
        this.e = enumMap;
        enumMap.put(r95.AD_USER_DATA, bool == null ? o95.UNINITIALIZED : bool.booleanValue() ? o95.GRANTED : o95.DENIED);
        this.a = i;
        this.b = d();
        this.c = bool2;
        this.d = str;
    }

    public static o25 b(String str) {
        if (str == null || str.length() <= 0) {
            return f;
        }
        String[] strArrSplit = str.split(":");
        int i = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(r95.class);
        r95[] r95VarArr = q95.DMA.b;
        int length = r95VarArr.length;
        int i2 = 1;
        int i3 = 0;
        while (i3 < length) {
            enumMap.put(r95VarArr[i3], t95.e(strArrSplit[i2].charAt(0)));
            i3++;
            i2++;
        }
        return new o25(enumMap, i, (Boolean) null, (String) null);
    }

    public static o25 c(int i, Bundle bundle) {
        if (bundle == null) {
            return new o25((Boolean) null, i, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(r95.class);
        for (r95 r95Var : q95.DMA.b) {
            enumMap.put(r95Var, t95.d(bundle.getString(r95Var.b)));
        }
        return new o25(enumMap, i, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public final o95 a() {
        o95 o95Var = (o95) this.e.get(r95.AD_USER_DATA);
        return o95Var == null ? o95.UNINITIALIZED : o95Var;
    }

    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        for (r95 r95Var : q95.DMA.b) {
            sb.append(":");
            sb.append(t95.h((o95) this.e.get(r95Var)));
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o25)) {
            return false;
        }
        o25 o25Var = (o25) obj;
        if (this.b.equalsIgnoreCase(o25Var.b) && Objects.equals(this.c, o25Var.c)) {
            return Objects.equals(this.d, o25Var.d);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.c;
        int i = bool == null ? 3 : true != bool.booleanValue() ? 13 : 7;
        String str = this.d;
        return ((str == null ? 17 : str.hashCode()) * 137) + this.b.hashCode() + (i * 29);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(t95.a(this.a));
        for (r95 r95Var : q95.DMA.b) {
            sb.append(",");
            sb.append(r95Var.b);
            sb.append("=");
            o95 o95Var = (o95) this.e.get(r95Var);
            if (o95Var == null) {
                sb.append("uninitialized");
            } else {
                int iOrdinal = o95Var.ordinal();
                if (iOrdinal == 0) {
                    sb.append("uninitialized");
                } else if (iOrdinal == 1) {
                    sb.append("eu_consent_policy");
                } else if (iOrdinal == 2) {
                    sb.append("denied");
                } else if (iOrdinal == 3) {
                    sb.append("granted");
                }
            }
        }
        Boolean bool = this.c;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str = this.d;
        if (str != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str);
        }
        return sb.toString();
    }

    public o25(EnumMap enumMap, int i, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(r95.class);
        this.e = enumMap2;
        enumMap2.putAll(enumMap);
        this.a = i;
        this.b = d();
        this.c = bool;
        this.d = str;
    }
}
