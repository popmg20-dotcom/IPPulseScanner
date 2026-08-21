package defpackage;

import android.content.ClipData;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.p;
import androidx.fragment.app.u;
import com.getsurfboard.ui.activity.QRCodeScannerActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n4 extends m4 {
    public final /* synthetic */ int a;

    public /* synthetic */ n4(int i) {
        this.a = i;
    }

    @Override // defpackage.m4
    public final Intent a(p pVar, Object obj) {
        Bundle bundleExtra;
        switch (this.a) {
            case 0:
                String str = (String) obj;
                str.getClass();
                Intent intentPutExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType("application/zip").putExtra("android.intent.extra.TITLE", str);
                intentPutExtra.getClass();
                return intentPutExtra;
            case 1:
                String str2 = (String) obj;
                str2.getClass();
                Intent intentPutExtra2 = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str2).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                intentPutExtra2.getClass();
                return intentPutExtra2;
            case 2:
                String[] strArr = (String[]) obj;
                strArr.getClass();
                Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).setType("*/*");
                type.getClass();
                return type;
            case 3:
                e13 e13Var = (e13) obj;
                e13Var.getClass();
                if (j2.j()) {
                    Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                    intent.setType(j2.i(e13Var.a));
                    e13Var.b.getClass();
                    intent.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", 1);
                    return intent;
                }
                if (pVar.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112) == null) {
                    Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
                    intent2.setType(j2.i(e13Var.a));
                    if (intent2.getType() != null) {
                        return intent2;
                    }
                    intent2.setType("*/*");
                    intent2.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                    return intent2;
                }
                ResolveInfo resolveInfoResolveActivity = pVar.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112);
                if (resolveInfoResolveActivity == null) {
                    xe.q("Required value was null.");
                    return null;
                }
                ActivityInfo activityInfo = resolveInfoResolveActivity.activityInfo;
                Intent intent3 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
                intent3.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
                intent3.setType(j2.i(e13Var.a));
                e13Var.b.getClass();
                intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", 1);
                return intent3;
            case 4:
                String[] strArr2 = (String[]) obj;
                strArr2.getClass();
                Intent intentPutExtra3 = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr2);
                intentPutExtra3.getClass();
                return intentPutExtra3;
            case 5:
                String str3 = (String) obj;
                str3.getClass();
                Intent intentPutExtra4 = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", new String[]{str3});
                intentPutExtra4.getClass();
                return intentPutExtra4;
            case 6:
                Intent intent4 = (Intent) obj;
                intent4.getClass();
                return intent4;
            case 7:
                d12 d12Var = (d12) obj;
                Intent intent5 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent6 = d12Var.f;
                if (intent6 != null && (bundleExtra = intent6.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent5.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intent6.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intent6.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        d12Var = new d12(d12Var.b, null, d12Var.z, d12Var.A);
                    }
                }
                intent5.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", d12Var);
                if (u.M(2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent5);
                }
                return intent5;
            default:
                Intent intentPutExtra5 = new Intent(pVar, (Class<?>) QRCodeScannerActivity.class).putExtra("config", (tp3) obj);
                intentPutExtra5.getClass();
                return intentPutExtra5;
        }
    }

    @Override // defpackage.m4
    public w7 b(p pVar, Object obj) {
        int i = 4;
        switch (this.a) {
            case 0:
                ((String) obj).getClass();
                return null;
            case 1:
                ((String) obj).getClass();
                return null;
            case 2:
                ((String[]) obj).getClass();
                return null;
            case 3:
                ((e13) obj).getClass();
                return null;
            case 4:
                String[] strArr = (String[]) obj;
                strArr.getClass();
                if (strArr.length == 0) {
                    return new w7(i, h41.b);
                }
                for (String str : strArr) {
                    if (v9.a(pVar, str) != 0) {
                        return null;
                    }
                }
                int iU = fh2.U(strArr.length);
                if (iU < 16) {
                    iU = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iU);
                for (String str2 : strArr) {
                    linkedHashMap.put(str2, Boolean.TRUE);
                }
                return new w7(i, linkedHashMap);
            case 5:
                String str3 = (String) obj;
                str3.getClass();
                if (v9.a(pVar, str3) == 0) {
                    return new w7(i, Boolean.TRUE);
                }
                return null;
            default:
                return super.b(pVar, obj);
        }
    }

    @Override // defpackage.m4
    public final Object c(Intent intent, int i) {
        int i2 = this.a;
        List arrayList = g41.b;
        z = false;
        boolean z = false;
        switch (i2) {
            case 0:
                if (i != -1) {
                    intent = null;
                }
                if (intent != null) {
                    return intent.getData();
                }
                return null;
            case 1:
                if (i != -1) {
                    intent = null;
                }
                if (intent == null) {
                    return arrayList;
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Uri data = intent.getData();
                if (data != null) {
                    linkedHashSet.add(data);
                }
                ClipData clipData = intent.getClipData();
                if (clipData == null && linkedHashSet.isEmpty()) {
                    return arrayList;
                }
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i3 = 0; i3 < itemCount; i3++) {
                        Uri uri = clipData.getItemAt(i3).getUri();
                        if (uri != null) {
                            linkedHashSet.add(uri);
                        }
                    }
                }
                return new ArrayList(linkedHashSet);
            case 2:
                if (i != -1) {
                    intent = null;
                }
                if (intent != null) {
                    return intent.getData();
                }
                return null;
            case 3:
                if (i != -1) {
                    intent = null;
                }
                if (intent == null) {
                    return null;
                }
                Uri data2 = intent.getData();
                if (data2 != null) {
                    return data2;
                }
                LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                Uri data3 = intent.getData();
                if (data3 != null) {
                    linkedHashSet2.add(data3);
                }
                ClipData clipData2 = intent.getClipData();
                if (clipData2 != null || !linkedHashSet2.isEmpty()) {
                    if (clipData2 != null) {
                        int itemCount2 = clipData2.getItemCount();
                        for (int i4 = 0; i4 < itemCount2; i4++) {
                            Uri uri2 = clipData2.getItemAt(i4).getUri();
                            if (uri2 != null) {
                                linkedHashSet2.add(uri2);
                            }
                        }
                    }
                    arrayList = new ArrayList(linkedHashSet2);
                }
                return (Uri) d70.e0(arrayList);
            case 4:
                if (i == -1 && intent != null) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null && stringArrayExtra != null) {
                        ArrayList arrayList2 = new ArrayList(intArrayExtra.length);
                        for (int i5 : intArrayExtra) {
                            arrayList2.add(Boolean.valueOf(i5 == 0));
                        }
                        ArrayList arrayListL0 = qe.l0(stringArrayExtra);
                        Iterator it = arrayListL0.iterator();
                        Iterator it2 = arrayList2.iterator();
                        ArrayList arrayList3 = new ArrayList(Math.min(f70.Q(10, arrayListL0), f70.Q(10, arrayList2)));
                        while (it.hasNext() && it2.hasNext()) {
                            arrayList3.add(new e03(it.next(), it2.next()));
                        }
                        return fh2.X(arrayList3);
                    }
                }
                return h41.b;
            case 5:
                if (intent == null || i != -1) {
                    return Boolean.FALSE;
                }
                int[] intArrayExtra2 = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                if (intArrayExtra2 != null) {
                    int length = intArrayExtra2.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 < length) {
                            if (intArrayExtra2[i6] == 0) {
                                z = true;
                            } else {
                                i6++;
                            }
                        }
                    }
                }
                return Boolean.valueOf(z);
            case 6:
                return new k4(intent, i);
            case 7:
                return new k4(intent, i);
            default:
                if (i != -1) {
                    return xp3.a;
                }
                String stringExtra = intent != null ? intent.getStringExtra("result") : null;
                return stringExtra != null ? new wp3(stringExtra) : vp3.a;
        }
    }
}
