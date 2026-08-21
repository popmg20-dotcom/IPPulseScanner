package defpackage;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Trace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zh1 {
    public static final if2 a = new if2(2);
    public static final i60 b = new i60(4);

    public static t6 a(Context context, List list) {
        String str;
        Typeface typefaceC;
        Trace.beginSection(vo.O("FontProvider.getFontFamilyResult"));
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                ai1 ai1Var = (ai1) list.get(i);
                if (Build.VERSION.SDK_INT < 31 || (typefaceC = dk4.c((str = ai1Var.e))) == null || dk4.d(typefaceC) == null) {
                    ProviderInfo providerInfoB = b(context.getPackageManager(), ai1Var, context.getResources());
                    if (providerInfoB == null) {
                        return new t6((byte) 0, 4);
                    }
                    arrayList.add(c(context, ai1Var, providerInfoB.authority));
                } else {
                    arrayList.add(new ki1[]{new ki1(str, ai1Var.f)});
                }
            }
            return new t6(arrayList, 4);
        } finally {
            Trace.endSection();
        }
    }

    public static ProviderInfo b(PackageManager packageManager, ai1 ai1Var, Resources resources) {
        i60 i60Var = b;
        if2 if2Var = a;
        Trace.beginSection(vo.O("FontProvider.getProvider"));
        try {
            List listV = ai1Var.d;
            String str = ai1Var.a;
            String str2 = ai1Var.b;
            if (listV == null) {
                listV = ke0.v(resources, 0);
            }
            yh1 yh1Var = new yh1();
            yh1Var.a = str;
            yh1Var.b = str2;
            yh1Var.c = listV;
            ProviderInfo providerInfo = (ProviderInfo) if2Var.h(yh1Var);
            if (providerInfo != null) {
                return providerInfo;
            }
            ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0);
            if (providerInfoResolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: " + str);
            }
            if (!providerInfoResolveContentProvider.packageName.equals(str2)) {
                throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str2);
            }
            Signature[] signatureArr = packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures;
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            Collections.sort(arrayList, i60Var);
            for (int i = 0; i < listV.size(); i++) {
                ArrayList arrayList2 = new ArrayList((Collection) listV.get(i));
                Collections.sort(arrayList2, i60Var);
                if (arrayList.size() == arrayList2.size()) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (!Arrays.equals((byte[]) arrayList.get(i2), (byte[]) arrayList2.get(i2))) {
                            break;
                        }
                    }
                    if2Var.l(yh1Var, providerInfoResolveContentProvider);
                    return providerInfoResolveContentProvider;
                }
            }
            Trace.endSection();
            return null;
        } finally {
            Trace.endSection();
        }
    }

    public static ki1[] c(Context context, ai1 ai1Var, String str) {
        Trace.beginSection(vo.O("FontProvider.query"));
        try {
            ArrayList arrayList = new ArrayList();
            Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
            Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
            xh1 cp1Var = Build.VERSION.SDK_INT < 24 ? new cp1(context, uriBuild) : new ha1(context, uriBuild);
            Cursor cursorO = null;
            try {
                String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                Trace.beginSection(vo.O("ContentQueryWrapper.query"));
                try {
                    cursorO = cp1Var.o(uriBuild, strArr, new String[]{ai1Var.c});
                    Trace.endSection();
                    if (cursorO != null && cursorO.getCount() > 0) {
                        int columnIndex = cursorO.getColumnIndex("result_code");
                        ArrayList arrayList2 = new ArrayList();
                        int columnIndex2 = cursorO.getColumnIndex("_id");
                        int columnIndex3 = cursorO.getColumnIndex("file_id");
                        int columnIndex4 = cursorO.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursorO.getColumnIndex("font_weight");
                        int columnIndex6 = cursorO.getColumnIndex("font_italic");
                        while (cursorO.moveToNext()) {
                            int i = columnIndex != -1 ? cursorO.getInt(columnIndex) : 0;
                            arrayList2.add(new ki1(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorO.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorO.getLong(columnIndex3)), columnIndex4 != -1 ? cursorO.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorO.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorO.getInt(columnIndex6) == 1, ai1Var.f, i));
                        }
                        arrayList = arrayList2;
                    }
                    if (cursorO != null) {
                        cursorO.close();
                    }
                    cp1Var.close();
                    return (ki1[]) arrayList.toArray(new ki1[0]);
                } finally {
                }
            } catch (Throwable th) {
                if (cursorO != null) {
                    cursorO.close();
                }
                cp1Var.close();
                throw th;
            }
        } finally {
        }
    }
}
