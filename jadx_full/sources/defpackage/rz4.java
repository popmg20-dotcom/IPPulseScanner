package defpackage;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseIntArray;
import io.sentry.android.core.a1;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rz4 implements of5, v65 {
    public final /* synthetic */ int b;
    public final Object f;

    public rz4(int i) {
        this.b = i;
        switch (i) {
            case 2:
                this.f = new EnumMap(r95.class);
                break;
            default:
                Object obj = lp1.c;
                this.f = new SparseIntArray();
                break;
        }
    }

    @Override // defpackage.v65
    public /* synthetic */ void a(String str, int i, Throwable th, byte[] bArr, Map map) {
        ((ff5) this.f).w(str, i, th, bArr, map);
    }

    @Override // defpackage.of5
    public void b(String str, String str2, Bundle bundle) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        ib5 ib5Var = (ib5) this.f;
        if (!zIsEmpty) {
            xe.q("Unexpected call on client side");
        } else {
            ((k85) ib5Var.f).B0.getClass();
            ib5Var.a1("auto", "_err", bundle, true, true, System.currentTimeMillis());
        }
    }

    public Object c() {
        x95 x95Var = (x95) this.f;
        ContentResolver contentResolver = x95Var.a;
        Uri uri = x95Var.b;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        try {
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                a1.n("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
                return Collections.EMPTY_MAP;
            }
            try {
                Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, x95.j, null, null, null);
                try {
                    if (cursorQuery == null) {
                        a1.n("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                        Map map = Collections.EMPTY_MAP;
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                        return map;
                    }
                    int count = cursorQuery.getCount();
                    if (count == 0) {
                        Map map2 = Collections.EMPTY_MAP;
                        cursorQuery.close();
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                        return map2;
                    }
                    Map ieVar = count <= 256 ? new ie(count) : new HashMap(count, 1.0f);
                    while (cursorQuery.moveToNext()) {
                        ieVar.put(cursorQuery.getString(0), cursorQuery.getString(1));
                    }
                    if (cursorQuery.isAfterLast()) {
                        cursorQuery.close();
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                        return ieVar;
                    }
                    a1.n("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                    Map map3 = Collections.EMPTY_MAP;
                    cursorQuery.close();
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    return map3;
                } finally {
                }
            } catch (RemoteException e) {
                a1.o("ConfigurationContentLdr", "ContentProvider query failed, using default values", e);
                Map map4 = Collections.EMPTY_MAP;
                contentProviderClientAcquireUnstableContentProviderClient.release();
                return map4;
            }
        } catch (Throwable th) {
            contentProviderClientAcquireUnstableContentProviderClient.release();
            throw th;
        }
    }

    public void d(int i, String str, List list, boolean z, boolean z2) {
        q65 q65Var;
        k85 k85Var = (k85) ((x75) this.f).f;
        int i2 = i - 1;
        if (i2 == 0) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            q65Var = t65Var.G0;
        } else if (i2 != 1) {
            if (i2 == 3) {
                t65 t65Var2 = k85Var.Y;
                k85.h(t65Var2);
                q65Var = t65Var2.H0;
            } else if (i2 != 4) {
                t65 t65Var3 = k85Var.Y;
                k85.h(t65Var3);
                q65Var = t65Var3.F0;
            } else if (z) {
                t65 t65Var4 = k85Var.Y;
                k85.h(t65Var4);
                q65Var = t65Var4.D0;
            } else if (z2) {
                t65 t65Var5 = k85Var.Y;
                k85.h(t65Var5);
                q65Var = t65Var5.C0;
            } else {
                t65 t65Var6 = k85Var.Y;
                k85.h(t65Var6);
                q65Var = t65Var6.E0;
            }
        } else if (z) {
            t65 t65Var7 = k85Var.Y;
            k85.h(t65Var7);
            q65Var = t65Var7.A0;
        } else if (z2) {
            t65 t65Var8 = k85Var.Y;
            k85.h(t65Var8);
            q65Var = t65Var8.z0;
        } else {
            t65 t65Var9 = k85Var.Y;
            k85.h(t65Var9);
            q65Var = t65Var9.B0;
        }
        int size = list.size();
        if (size == 1) {
            q65Var.b(list.get(0), str);
            return;
        }
        if (size == 2) {
            q65Var.c(str, list.get(0), list.get(1));
        } else if (size != 3) {
            q65Var.a(str);
        } else {
            q65Var.d(str, list.get(0), list.get(1), list.get(2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(r95 r95Var, int i) {
        z15 z15Var;
        if (i == -30) {
            z15Var = z15.TCF;
        } else if (i == -20) {
            z15Var = z15.API;
        } else if (i == -10) {
            z15Var = z15.MANIFEST;
        } else if (i != 0) {
            z15Var = i != 30 ? z15.UNSET : z15.INITIALIZATION;
        }
        ((EnumMap) this.f).put(r95Var, z15Var);
    }

    public void f(r95 r95Var, z15 z15Var) {
        ((EnumMap) this.f).put(r95Var, z15Var);
    }

    public String toString() {
        switch (this.b) {
            case 2:
                StringBuilder sb = new StringBuilder("1");
                for (r95 r95Var : r95.values()) {
                    z15 z15Var = (z15) ((EnumMap) this.f).get(r95Var);
                    if (z15Var == null) {
                        z15Var = z15.UNSET;
                    }
                    sb.append(z15Var.b);
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ rz4(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    public rz4(EnumMap enumMap) {
        this.b = 2;
        EnumMap enumMap2 = new EnumMap(r95.class);
        this.f = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
