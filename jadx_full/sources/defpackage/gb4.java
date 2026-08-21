package defpackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.text.TextUtils;
import android.util.Range;
import android.util.SparseIntArray;
import android.view.ContextThemeWrapper;
import android.view.Surface;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.camera.camera2.internal.compat.quirk.FlashAvailabilityBufferUnderflowQuirk;
import com.getsurfboard.R;
import com.google.android.material.appbar.MaterialToolbar;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.util.internal.StringUtil;
import j$.util.DesugarCollections;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class gb4 implements er4 {
    public static char[] a;
    public static byte b;
    public static final p70 c = new p70(1, "android");
    public static final e1 d = new e1(8);
    public static final Object e = new Object();
    public static final e1 f = new e1(24);

    public static final m20 A(lr1 lr1Var) {
        lr1Var.getClass();
        m20 m20Var = new m20(1);
        d70.V(m20Var.a, lr1Var.b);
        return m20Var;
    }

    public static final String B(lr1 lr1Var, int i) {
        lr1Var.getClass();
        String str = (String) qe.m0((i * 2) + 1, lr1Var.b);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + i + ']');
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static wh1 C(ld0 ld0Var, boolean z, bc4 bc4Var, tv2 tv2Var, qt qtVar) {
        uv2 uv2Var;
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        ArrayList arrayList = new ArrayList();
        int size = ld0Var.b.size() + 1;
        arrayList.add(new v43(-1, size, size));
        int i = 0;
        for (int size2 = ld0Var.b.size() - 1; size2 >= 0 && qtVar.l(); size2--) {
            int i2 = bc4Var.B(size2).a.d;
            v43 v43Var = (v43) fw.r(arrayList, 1);
            if (i2 == -1) {
                if (z) {
                    v43Var.b = size2;
                }
            } else if (tv2Var == null || (uv2Var = bc4Var.B(size2).a.b) == null) {
                if (v43Var.a > i2) {
                    do {
                        arrayList.remove(arrayList.size() - 1);
                        v43Var = (v43) arrayList.get(arrayList.size() - 1);
                    } while (v43Var.a > i2);
                    int i3 = v43Var.b - 1;
                    if (i3 - size2 >= 1 && size2 <= 16777215 && i3 <= 16777215) {
                        sparseIntArray.put(i, size2);
                        sparseIntArray2.put(i, i3);
                        i++;
                    }
                }
                if (v43Var.a == i2) {
                    v43Var.b = size2;
                } else {
                    arrayList.add(new v43(i2, size2, size2));
                }
            } else if (uv2Var.count() >= 2) {
                int size3 = arrayList.size() - 1;
                while (size3 > 0 && ((v43) arrayList.get(size3)).a != -2) {
                    size3--;
                }
                if (size3 > 0) {
                    v43 v43Var2 = (v43) arrayList.get(size3);
                    int i4 = v43Var2.c;
                    if (size2 <= 16777215 && i4 <= 16777215) {
                        sparseIntArray.put(i, size2);
                        sparseIntArray2.put(i, i4);
                        i++;
                    }
                    v43Var2.c = size2;
                    v43Var2.a = i2;
                    v43Var2.b = size2;
                }
            } else {
                arrayList.add(new v43(-2, size2, size2));
            }
        }
        return new wh1(sparseIntArray, sparseIntArray2);
    }

    public static byte[] D(ContextThemeWrapper contextThemeWrapper, HashMap map) throws IOException {
        p70 p70Var;
        if (map.entrySet().isEmpty()) {
            xe.k("No color resources provided for harmonization.");
            return null;
        }
        p70 p70Var2 = new p70(127, contextThemeWrapper.getPackageName());
        HashMap map2 = new HashMap();
        n70 n70Var = null;
        for (Map.Entry entry : map.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            String resourceEntryName = contextThemeWrapper.getResources().getResourceEntryName(((Integer) entry.getKey()).intValue());
            n70 n70Var2 = new n70(iIntValue, ((Integer) entry.getValue()).intValue(), resourceEntryName);
            if (!contextThemeWrapper.getResources().getResourceTypeName(((Integer) entry.getKey()).intValue()).equals("color")) {
                xe.n(fw.D("Non color resource found: name=", resourceEntryName, ", typeId="), Integer.toHexString(n70Var2.b & 255));
                return null;
            }
            byte b2 = n70Var2.a;
            if (b2 == 1) {
                p70Var = c;
            } else {
                if (b2 != 127) {
                    xe.k(dw2.A(b2, "Not supported with unknown package id: "));
                    return null;
                }
                p70Var = p70Var2;
            }
            if (!map2.containsKey(p70Var)) {
                map2.put(p70Var, new ArrayList());
            }
            ((List) map2.get(p70Var)).add(n70Var2);
            n70Var = n70Var2;
        }
        byte b3 = n70Var.b;
        b = b3;
        if (b3 == 0) {
            xe.k("No color resources found for harmonization.");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ArrayList<o70> arrayList = new ArrayList();
        int size = map2.size();
        r70 r70Var = new r70(false, new String[0]);
        for (Map.Entry entry2 : map2.entrySet()) {
            List list = (List) entry2.getValue();
            Collections.sort(list, d);
            arrayList.add(new o70((p70) entry2.getKey(), list));
        }
        Iterator it = arrayList.iterator();
        int iA = 0;
        while (it.hasNext()) {
            iA += ((o70) it.next()).a();
        }
        int i = r70Var.l + 12 + iA;
        byteArrayOutputStream.write(W((short) 2));
        byteArrayOutputStream.write(W((short) 12));
        byteArrayOutputStream.write(Q(i));
        byteArrayOutputStream.write(Q(size));
        r70Var.a(byteArrayOutputStream);
        for (o70 o70Var : arrayList) {
            r70 r70Var2 = o70Var.c;
            o70Var.a.a(byteArrayOutputStream);
            p70 p70Var3 = o70Var.b;
            byteArrayOutputStream.write(Q(p70Var3.a));
            char[] charArray = p70Var3.b.toCharArray();
            for (int i2 = 0; i2 < 128; i2++) {
                if (i2 < charArray.length) {
                    char c2 = charArray[i2];
                    byteArrayOutputStream.write(new byte[]{(byte) (c2 & 255), (byte) ((c2 >> '\b') & DnsRecord.CLASS_ANY)});
                } else {
                    byteArrayOutputStream.write(new byte[]{0, 0});
                }
            }
            byteArrayOutputStream.write(Q(288));
            byteArrayOutputStream.write(Q(0));
            byteArrayOutputStream.write(Q(r70Var2.l + 288));
            byteArrayOutputStream.write(Q(0));
            byteArrayOutputStream.write(Q(0));
            r70Var2.a(byteArrayOutputStream);
            o70Var.d.a(byteArrayOutputStream);
            lw2 lw2Var = o70Var.e;
            ((q70) lw2Var.c).a(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{b, 0, 0, 0});
            byteArrayOutputStream.write(Q(lw2Var.b));
            for (int i3 : (int[]) lw2Var.d) {
                byteArrayOutputStream.write(Q(i3));
            }
            j40 j40Var = (j40) lw2Var.e;
            q70 q70Var = (q70) j40Var.c;
            int[] iArr = (int[]) j40Var.e;
            q70Var.a(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{b, 0, 0, 0});
            byteArrayOutputStream.write(Q(j40Var.b));
            byteArrayOutputStream.write(Q((iArr.length * 4) + 84));
            byteArrayOutputStream.write((byte[]) j40Var.d);
            for (int i4 : iArr) {
                byteArrayOutputStream.write(Q(i4));
            }
            for (hm2 hm2Var : (hm2[]) j40Var.f) {
                hm2Var.getClass();
                byteArrayOutputStream.write(W((short) 8));
                byteArrayOutputStream.write(W((short) 2));
                byteArrayOutputStream.write(Q(hm2Var.b));
                byteArrayOutputStream.write(W((short) 8));
                byteArrayOutputStream.write(new byte[]{0, 28});
                byteArrayOutputStream.write(Q(hm2Var.c));
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static final Object E(long j, v74 v74Var) {
        if (j > 0) {
            z00 z00Var = new z00(1, p95.u(v74Var));
            z00Var.w();
            if (j < Long.MAX_VALUE) {
                J(z00Var.X).U(j, z00Var);
            }
            Object objU = z00Var.u();
            if (objU == mf0.b) {
                return objU;
            }
        }
        return xl4.a;
    }

    public static float F(float f2, float f3, float f4, float f5) {
        double d2 = f2 - f4;
        double d3 = f3 - f5;
        return (float) Math.sqrt((d3 * d3) + (d2 * d2));
    }

    public static float G(int i, int i2, int i3, int i4) {
        double d2 = i - i3;
        double d3 = i2 - i4;
        return (float) Math.sqrt((d3 * d3) + (d2 * d2));
    }

    public static byte[] H(short s) {
        return s > 127 ? new byte[]{(byte) ((127 & (s >> 8)) | 128), (byte) (s & 255)} : new byte[]{(byte) (s & 255)};
    }

    public static boolean I(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static final on0 J(cf0 cf0Var) {
        af0 af0VarZ = cf0Var.Z(pr1.f);
        on0 on0Var = af0VarZ instanceof on0 ? (on0) af0VarZ : null;
        return on0Var == null ? jl0.a : on0Var;
    }

    public static Set K() {
        try {
            Object objInvoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
            if (objInvoke == null) {
                return Collections.EMPTY_SET;
            }
            Set set = (Set) objInvoke;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.EMPTY_SET;
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.EMPTY_SET;
        }
    }

    public static ArrayList L(MaterialToolbar materialToolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < materialToolbar.getChildCount(); i++) {
            View childAt = materialToolbar.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    public static final byte[] M(String str) throws IOException {
        str.getClass();
        byte[] bytes = str.getBytes(y30.a);
        bytes.getClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                byteArray.getClass();
                return byteArray;
            } finally {
            }
        } finally {
        }
    }

    public static String N(String str) {
        bu buVar = bu.A;
        byte[] bytes = str.getBytes(y30.a);
        bytes.getClass();
        return t60.p(bytes).c("MD5").e();
    }

    public static final void O(String str) {
        str.getClass();
        if (str.length() <= 0) {
            xe.k("name is empty");
            return;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ('!' > cCharAt || cCharAt >= 127) {
                StringBuilder sb = new StringBuilder("Unexpected char 0x");
                yr2.g(16);
                String string = Integer.toString(cCharAt, 16);
                string.getClass();
                if (string.length() < 2) {
                    string = "0".concat(string);
                }
                sb.append(string);
                sb.append(" at ");
                sb.append(i);
                sb.append(" in header name: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }

    public static final void P(String str, String str2) {
        str.getClass();
        str2.getClass();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                StringBuilder sb = new StringBuilder("Unexpected char 0x");
                yr2.g(16);
                String string = Integer.toString(cCharAt, 16);
                string.getClass();
                if (string.length() < 2) {
                    string = "0".concat(string);
                }
                sb.append(string);
                sb.append(" at ");
                sb.append(i);
                sb.append(" in ");
                sb.append(str2);
                sb.append(" value");
                sb.append(hz4.j(str2) ? "" : ": ".concat(str));
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }

    public static byte[] Q(int i) {
        return new byte[]{(byte) (i & DnsRecord.CLASS_ANY), (byte) ((i >> 8) & DnsRecord.CLASS_ANY), (byte) ((i >> 16) & DnsRecord.CLASS_ANY), (byte) ((i >> 24) & DnsRecord.CLASS_ANY)};
    }

    public static boolean R(fx fxVar) {
        Boolean bool;
        CameraCharacteristics.Key key;
        try {
            CameraCharacteristics.Key key2 = CameraCharacteristics.FLASH_INFO_AVAILABLE;
            switch (fxVar.a) {
                case 0:
                    key = CameraCharacteristics.FLASH_INFO_AVAILABLE;
                    break;
                default:
                    key = CameraCharacteristics.FLASH_INFO_AVAILABLE;
                    break;
            }
            bool = (Boolean) fxVar.b.a(key);
        } catch (BufferUnderflowException e2) {
            if (xt0.a.z(FlashAvailabilityBufferUnderflowQuirk.class) != null) {
                ez4.o("FlashAvailability", String.format("Device is known to throw an exception while checking flash availability. Flash is not available. [Manufacturer: %s, Model: %s, API Level: %d].", Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT)));
            } else {
                ez4.r("FlashAvailability", String.format("Exception thrown while checking for flash availability on device not known to throw exceptions during this check. Please file an issue at https://issuetracker.google.com/issues/new?component=618491&template=1257717 with this error message [Manufacturer: %s, Model: %s, API Level: %d].\nFlash is not available.", Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT)), e2);
            }
            bool = Boolean.FALSE;
        }
        if (bool == null) {
            ez4.a0("FlashAvailability", "Characteristics did not contain key FLASH_INFO_AVAILABLE. Flash is not available.");
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static char[] S(int i) {
        char[] cArr;
        synchronized (gb4.class) {
            cArr = a;
            a = null;
        }
        return (cArr == null || cArr.length < i) ? new char[i] : cArr;
    }

    public static String T(String str) {
        str.getClass();
        return "\"" + w44.i0(str, "\"", "\\\"") + StringUtil.DOUBLE_QUOTE;
    }

    public static void U(char[] cArr) {
        if (cArr.length > 1000) {
            return;
        }
        synchronized (gb4.class) {
            a = cArr;
        }
    }

    public static int V(float f2) {
        return (int) (f2 + (f2 < 0.0f ? -0.5f : 0.5f));
    }

    public static byte[] W(short s) {
        return new byte[]{(byte) (s & 255), (byte) ((s >> 8) & DnsRecord.CLASS_ANY)};
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String X(String str) {
        int iHashCode = str.hashCode();
        switch (iHashCode) {
            case -2061550653:
                if (str.equals("kotlin.jvm.internal.DoubleCompanionObject")) {
                    return "Companion";
                }
                return null;
            case -2056817302:
                if (str.equals("java.lang.Integer")) {
                    return "Int";
                }
                return null;
            case -2034166429:
                if (str.equals("java.lang.Cloneable")) {
                    return "Cloneable";
                }
                return null;
            case -1979556166:
                if (str.equals("java.lang.annotation.Annotation")) {
                    return "Annotation";
                }
                return null;
            case -1571515090:
                if (str.equals("java.lang.Comparable")) {
                    return "Comparable";
                }
                return null;
            case -1383349348:
                if (str.equals("java.util.Map")) {
                    return "Map";
                }
                return null;
            case -1383343454:
                if (str.equals("java.util.Set")) {
                    return "Set";
                }
                return null;
            case -1325958191:
                if (str.equals("double")) {
                    return "Double";
                }
                return null;
            case -1182275604:
                if (str.equals("kotlin.jvm.internal.ByteCompanionObject")) {
                    return "Companion";
                }
                return null;
            case -1062240117:
                if (str.equals("java.lang.CharSequence")) {
                    return "CharSequence";
                }
                return null;
            case -688322466:
                if (str.equals("java.util.Collection")) {
                    return "Collection";
                }
                return null;
            case -527879800:
                if (str.equals("java.lang.Float")) {
                    return "Float";
                }
                return null;
            case -515992664:
                if (str.equals("java.lang.Short")) {
                    return "Short";
                }
                return null;
            case -246476834:
                if (str.equals("kotlin.jvm.internal.CharCompanionObject")) {
                    return "Companion";
                }
                return null;
            case -207262728:
                if (str.equals("kotlin.jvm.internal.LongCompanionObject")) {
                    return "Companion";
                }
                return null;
            case -165139126:
                if (str.equals("java.util.Map$Entry")) {
                    return "Entry";
                }
                return null;
            case 104431:
                if (str.equals("int")) {
                    return "Int";
                }
                return null;
            case 3039496:
                if (str.equals("byte")) {
                    return "Byte";
                }
                return null;
            case 3052374:
                if (str.equals("char")) {
                    return "Char";
                }
                return null;
            case 3327612:
                if (str.equals("long")) {
                    return "Long";
                }
                return null;
            case 64711720:
                if (str.equals("boolean")) {
                    return "Boolean";
                }
                return null;
            case 65821278:
                if (str.equals("java.util.List")) {
                    return "List";
                }
                return null;
            case 77230534:
                if (str.equals("kotlin.jvm.internal.ShortCompanionObject")) {
                    return "Companion";
                }
                return null;
            case 97526364:
                if (str.equals("float")) {
                    return "Float";
                }
                return null;
            case 109413500:
                if (str.equals("short")) {
                    return "Short";
                }
                return null;
            case 155276373:
                if (str.equals("java.lang.Character")) {
                    return "Char";
                }
                return null;
            case 226173651:
                if (str.equals("kotlin.jvm.internal.EnumCompanionObject")) {
                    return "Companion";
                }
                return null;
            case 344809556:
                if (str.equals("java.lang.Boolean")) {
                    return "Boolean";
                }
                return null;
            case 398507100:
                if (str.equals("java.lang.Byte")) {
                    return "Byte";
                }
                return null;
            case 398585941:
                if (str.equals("java.lang.Enum")) {
                    return "Enum";
                }
                return null;
            case 398795216:
                if (str.equals("java.lang.Long")) {
                    return "Long";
                }
                return null;
            case 482629606:
                if (str.equals("kotlin.jvm.internal.FloatCompanionObject")) {
                    return "Companion";
                }
                return null;
            case 499831342:
                if (str.equals("java.util.Iterator")) {
                    return "Iterator";
                }
                return null;
            case 577341676:
                if (str.equals("java.util.ListIterator")) {
                    return "ListIterator";
                }
                return null;
            case 599019395:
                if (str.equals("kotlin.jvm.internal.StringCompanionObject")) {
                    return "Companion";
                }
                return null;
            case 761287205:
                if (str.equals("java.lang.Double")) {
                    return "Double";
                }
                return null;
            case 1052881309:
                if (str.equals("java.lang.Number")) {
                    return "Number";
                }
                return null;
            case 1063877011:
                if (str.equals("java.lang.Object")) {
                    return "Any";
                }
                return null;
            case 1195259493:
                if (str.equals("java.lang.String")) {
                    return "String";
                }
                return null;
            case 1275614662:
                if (str.equals("java.lang.Iterable")) {
                    return "Iterable";
                }
                return null;
            case 1383693018:
                if (str.equals("kotlin.jvm.internal.BooleanCompanionObject")) {
                    return "Companion";
                }
                return null;
            case 1630335596:
                if (str.equals("java.lang.Throwable")) {
                    return "Throwable";
                }
                return null;
            case 1877171123:
                if (str.equals("kotlin.jvm.internal.IntCompanionObject")) {
                    return "Companion";
                }
                return null;
            default:
                switch (iHashCode) {
                    case -1811142716:
                        if (str.equals("kotlin.jvm.functions.Function10")) {
                            return "Function10";
                        }
                        return null;
                    case -1811142715:
                        if (str.equals("kotlin.jvm.functions.Function11")) {
                            return "Function11";
                        }
                        return null;
                    case -1811142714:
                        if (str.equals("kotlin.jvm.functions.Function12")) {
                            return "Function12";
                        }
                        return null;
                    case -1811142713:
                        if (str.equals("kotlin.jvm.functions.Function13")) {
                            return "Function13";
                        }
                        return null;
                    case -1811142712:
                        if (str.equals("kotlin.jvm.functions.Function14")) {
                            return "Function14";
                        }
                        return null;
                    case -1811142711:
                        if (str.equals("kotlin.jvm.functions.Function15")) {
                            return "Function15";
                        }
                        return null;
                    case -1811142710:
                        if (str.equals("kotlin.jvm.functions.Function16")) {
                            return "Function16";
                        }
                        return null;
                    case -1811142709:
                        if (str.equals("kotlin.jvm.functions.Function17")) {
                            return "Function17";
                        }
                        return null;
                    case -1811142708:
                        if (str.equals("kotlin.jvm.functions.Function18")) {
                            return "Function18";
                        }
                        return null;
                    case -1811142707:
                        if (str.equals("kotlin.jvm.functions.Function19")) {
                            return "Function19";
                        }
                        return null;
                    default:
                        switch (iHashCode) {
                            case -1811142685:
                                if (str.equals("kotlin.jvm.functions.Function20")) {
                                    return "Function20";
                                }
                                return null;
                            case -1811142684:
                                if (str.equals("kotlin.jvm.functions.Function21")) {
                                    return "Function21";
                                }
                                return null;
                            case -1811142683:
                                if (str.equals("kotlin.jvm.functions.Function22")) {
                                    return "Function22";
                                }
                                return null;
                            default:
                                switch (iHashCode) {
                                    case 80123371:
                                        if (str.equals("kotlin.jvm.functions.Function0")) {
                                            return "Function0";
                                        }
                                        return null;
                                    case 80123372:
                                        if (str.equals("kotlin.jvm.functions.Function1")) {
                                            return "Function1";
                                        }
                                        return null;
                                    case 80123373:
                                        if (str.equals("kotlin.jvm.functions.Function2")) {
                                            return "Function2";
                                        }
                                        return null;
                                    case 80123374:
                                        if (str.equals("kotlin.jvm.functions.Function3")) {
                                            return "Function3";
                                        }
                                        return null;
                                    case 80123375:
                                        if (str.equals("kotlin.jvm.functions.Function4")) {
                                            return "Function4";
                                        }
                                        return null;
                                    case 80123376:
                                        if (str.equals("kotlin.jvm.functions.Function5")) {
                                            return "Function5";
                                        }
                                        return null;
                                    case 80123377:
                                        if (str.equals("kotlin.jvm.functions.Function6")) {
                                            return "Function6";
                                        }
                                        return null;
                                    case 80123378:
                                        if (str.equals("kotlin.jvm.functions.Function7")) {
                                            return "Function7";
                                        }
                                        return null;
                                    case 80123379:
                                        if (str.equals("kotlin.jvm.functions.Function8")) {
                                            return "Function8";
                                        }
                                        return null;
                                    case 80123380:
                                        if (str.equals("kotlin.jvm.functions.Function9")) {
                                            return "Function9";
                                        }
                                        return null;
                                    default:
                                        return null;
                                }
                        }
                }
        }
    }

    public static final dm3 Y(int i, float f2, xe0 xe0Var) {
        xe0Var.getClass();
        if (f2 <= 0.0f) {
            xe.k("Star radii must both be greater than 0");
            return null;
        }
        if (f2 >= 1.0f) {
            xe.k("innerRadius must be less than radius");
            return null;
        }
        float[] fArr = new float[i * 4];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f3 = eo4.b / i;
            long jE = eo4.e(1.0f, 2.0f * f3 * i3);
            fArr[i2] = yr2.H(jE) + 0.0f;
            fArr[i2 + 1] = yr2.I(jE) + 0.0f;
            long jE2 = eo4.e(f2, f3 * ((i3 * 2) + 1));
            int i4 = i2 + 3;
            fArr[i2 + 2] = yr2.H(jE2) + 0.0f;
            i2 += 4;
            fArr[i4] = yr2.I(jE2) + 0.0f;
        }
        return vf2.b(fArr, xe0Var, null, 0.0f, 0.0f);
    }

    public static z02 Z(int i, b12 b12Var) {
        b12Var.getClass();
        q(i > 0, Integer.valueOf(i));
        int i2 = b12Var.b;
        int i3 = b12Var.f;
        if (b12Var.z <= 0) {
            i = -i;
        }
        return new z02(i2, i3, i);
    }

    public static final kk3 a0(kk3 kk3Var) {
        kk3Var.getClass();
        jk3 jk3VarN = kk3Var.n();
        ok3 ok3Var = kk3Var.Z;
        jk3VarN.g = new km4(ok3Var.s(), ok3Var.n());
        return jk3VarN.a();
    }

    public static int b0(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    public static final String c0(byte[] bArr) throws IOException {
        bArr.getClass();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, y30.a), 8192);
                try {
                    String strT = l72.T(bufferedReader);
                    bufferedReader.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return strT;
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public static r54 d() {
        return new r54(null);
    }

    public static b12 d0(int i, int i2) {
        if (i2 > Integer.MIN_VALUE) {
            return new b12(i, i2 - 1, 1);
        }
        b12 b12Var = b12.A;
        return b12.A;
    }

    public static void e(HashSet hashSet, d31 d31Var) {
        String strA = d31Var.a();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            d31 d31Var2 = (d31) it.next();
            if (strA != null && strA.equals(d31Var2.a())) {
                a71.h("Duplicated tag: ", strA, " for ", d31Var, ". The tag must be unique in XML rule definition.");
                return;
            }
        }
        hashSet.add(d31Var);
    }

    public static void f(f10 f10Var, CaptureRequest.Builder builder) {
        Range rangeA = f10Var.a();
        if (!rangeA.equals(ih.h)) {
            builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, rangeA);
        }
        ez4.o("Camera2CaptureRequestBuilder", "applyAeFpsRange: expectedFrameRateRange = " + rangeA);
    }

    public static void g(CaptureRequest.Builder builder, sw2 sw2Var) {
        cp1 cp1VarC = qx.d(sw2Var).c();
        for (pg pgVar : cp1VarC.m().t()) {
            CaptureRequest.Key key = (CaptureRequest.Key) pgVar.c;
            try {
                builder.set(key, cp1VarC.m().u(pgVar));
            } catch (IllegalArgumentException unused) {
                ez4.q("Camera2CaptureRequestBuilder", "CaptureRequest.Key is not supported: " + key);
            }
        }
    }

    public static void h(CaptureRequest.Builder builder, int i, dt0 dt0Var) {
        Map mapUnmodifiableMap;
        if (i == 3 && dt0Var.b) {
            HashMap map = new HashMap();
            map.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 1);
            mapUnmodifiableMap = DesugarCollections.unmodifiableMap(map);
        } else {
            if (i != 4) {
                dt0Var.getClass();
            } else if (dt0Var.c) {
                HashMap map2 = new HashMap();
                map2.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 2);
                mapUnmodifiableMap = DesugarCollections.unmodifiableMap(map2);
            }
            mapUnmodifiableMap = Collections.EMPTY_MAP;
        }
        for (Map.Entry entry : mapUnmodifiableMap.entrySet()) {
            builder.set((CaptureRequest.Key) entry.getKey(), entry.getValue());
        }
    }

    public static void i(Activity activity, int i) {
        View viewPeekDecorView;
        Context context;
        activity.getTheme().applyStyle(i, true);
        Window window = activity.getWindow();
        Resources.Theme theme = (window == null || (viewPeekDecorView = window.peekDecorView()) == null || (context = viewPeekDecorView.getContext()) == null) ? null : context.getTheme();
        if (theme != null) {
            theme.applyStyle(i, true);
        }
    }

    public static yv j(gn0 gn0Var) {
        vv vvVar = new vv();
        vvVar.c = new wj3();
        yv yvVar = new yv(vvVar);
        vvVar.b = yvVar;
        vvVar.a = fw.class;
        try {
            gn0Var.M(new ze0(0, vvVar, gn0Var));
            vvVar.a = "Deferred.asListenableFuture";
        } catch (Exception e2) {
            yvVar.b(e2);
        }
        return yvVar;
    }

    public static final Object k(nc2 nc2Var, v74 v74Var) throws Throwable {
        try {
            if (nc2Var.isDone()) {
                return x1.g(nc2Var);
            }
            z00 z00Var = new z00(1, p95.u(v74Var));
            nc2Var.a(new tm1(13, nc2Var, z00Var), wu0.b);
            z00Var.y(new ij0(1, nc2Var));
            return z00Var.u();
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause != null) {
                throw cause;
            }
            m82 m82Var = new m82();
            n12.P(m82Var, n12.class.getName());
            throw m82Var;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void l(ie0 ie0Var) {
        qn0 qn0Var;
        if (ie0Var instanceof qn0) {
            qn0Var = (qn0) ie0Var;
            int i = qn0Var.X;
            if ((i & Integer.MIN_VALUE) != 0) {
                qn0Var.X = i - Integer.MIN_VALUE;
            } else {
                qn0Var = new qn0(ie0Var);
            }
        }
        Object obj = qn0Var.A;
        int i2 = qn0Var.X;
        if (i2 == 0) {
            n12.S(obj);
            qn0Var.X = 1;
            z00 z00Var = new z00(1, p95.u(qn0Var));
            z00Var.w();
            if (z00Var.u() == mf0.b) {
                return;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return;
            }
            n12.S(obj);
        }
        throw new t80();
    }

    public static CaptureRequest m(f10 f10Var, CameraDevice cameraDevice, HashMap map, boolean z, dt0 dt0Var) throws CameraAccessException {
        CaptureRequest.Builder builderCreateCaptureRequest;
        Integer num = null;
        if (cameraDevice != null) {
            ArrayList arrayList = f10Var.a;
            int i = f10Var.c;
            sw2 sw2Var = f10Var.b;
            TreeMap treeMap = sw2Var.b;
            List listUnmodifiableList = DesugarCollections.unmodifiableList(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = listUnmodifiableList.iterator();
            while (it.hasNext()) {
                Surface surface = (Surface) map.get((dn0) it.next());
                if (surface == null) {
                    xe.k("DeferrableSurface not in configuredSurfaceMap");
                    return null;
                }
                arrayList2.add(surface);
            }
            if (!arrayList2.isEmpty()) {
                fy fyVar = f10Var.g;
                if (i == 5 && fyVar != null && (fyVar.j() instanceof TotalCaptureResult)) {
                    ez4.o("Camera2CaptureRequestBuilder", "createReprocessCaptureRequest");
                    builderCreateCaptureRequest = cameraDevice.createReprocessCaptureRequest((TotalCaptureResult) fyVar.j());
                } else {
                    ez4.o("Camera2CaptureRequestBuilder", "createCaptureRequest");
                    if (i == 5) {
                        builderCreateCaptureRequest = cameraDevice.createCaptureRequest(z ? 1 : 2);
                    } else {
                        builderCreateCaptureRequest = cameraDevice.createCaptureRequest(i);
                    }
                }
                h(builderCreateCaptureRequest, i, dt0Var);
                f(f10Var, builderCreateCaptureRequest);
                if (f10Var.b() == 1 || f10Var.c() == 1) {
                    num = 0;
                } else if (f10Var.b() == 2) {
                    num = 2;
                } else if (f10Var.c() == 2) {
                    num = 1;
                }
                if (num != null) {
                    builderCreateCaptureRequest.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, num);
                }
                ez4.o("Camera2CaptureRequestBuilder", "applyVideoStabilization: mode = " + num);
                pg pgVar = f10.h;
                if (treeMap.containsKey(pgVar)) {
                    builderCreateCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, (Integer) sw2Var.u(pgVar));
                }
                pg pgVar2 = f10.i;
                if (treeMap.containsKey(pgVar2)) {
                    builderCreateCaptureRequest.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) sw2Var.u(pgVar2)).byteValue()));
                }
                g(builderCreateCaptureRequest, sw2Var);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    builderCreateCaptureRequest.addTarget((Surface) it2.next());
                }
                builderCreateCaptureRequest.setTag(f10Var.f);
                return builderCreateCaptureRequest.build();
            }
        }
        return null;
    }

    public static ComponentName n(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            xe.k("Activity name must not be null");
            return null;
        }
        String string = str2.toString();
        if (string.charAt(0) == '.') {
            return new ComponentName(str, str.concat(string));
        }
        int iU0 = p44.u0(string, '/', 0, 6);
        if (iU0 > 0) {
            str = string.substring(0, iU0);
            string = string.substring(iU0 + 1);
        }
        if (string.equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD) || p44.u0(string, '.', 0, 6) >= 0) {
            return new ComponentName(str, string);
        }
        return new ComponentName(str, str + '.' + string);
    }

    public static CaptureRequest o(f10 f10Var, CameraDevice cameraDevice, dt0 dt0Var) throws CameraAccessException {
        if (cameraDevice == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("template type = ");
        int i = f10Var.c;
        sb.append(i);
        ez4.o("Camera2CaptureRequestBuilder", sb.toString());
        CaptureRequest.Builder builderCreateCaptureRequest = cameraDevice.createCaptureRequest(i);
        h(builderCreateCaptureRequest, i, dt0Var);
        f(f10Var, builderCreateCaptureRequest);
        g(builderCreateCaptureRequest, f10Var.b);
        return builderCreateCaptureRequest.build();
    }

    public static final void p(View view) {
        view.getClass();
        ts3 ts3Var = new ts3();
        gq4 gq4Var = new gq4(view, ts3Var);
        gq4Var.z = ts3Var;
        ts3Var.A = gq4Var;
        while (ts3Var.hasNext()) {
            View view2 = (View) ts3Var.next();
            b23 b23Var = (b23) view2.getTag(R.id.pooling_container_listener_holder_tag);
            if (b23Var == null) {
                b23Var = new b23();
                view2.setTag(R.id.pooling_container_listener_holder_tag, b23Var);
            }
            ArrayList arrayList = b23Var.a;
            int size = arrayList.size() - 1;
            if (-1 < size) {
                throw qe4.r(arrayList, size);
            }
        }
    }

    public static final void q(boolean z, Number number) {
        if (z) {
            return;
        }
        s53.g(number, 46, "Step must be positive, was: ");
    }

    public static dm3 r(int i) {
        return vf2.a((i & 1) != 0 ? 8 : 10, 1.0f / ((float) Math.cos(eo4.b / r3)), new xe0(2), null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String s(String str) {
        int iHashCode = str.hashCode();
        switch (iHashCode) {
            case -2061550653:
                if (str.equals("kotlin.jvm.internal.DoubleCompanionObject")) {
                    return "kotlin.Double.Companion";
                }
                return null;
            case -2056817302:
                if (str.equals("java.lang.Integer")) {
                    return "kotlin.Int";
                }
                return null;
            case -2034166429:
                if (str.equals("java.lang.Cloneable")) {
                    return "kotlin.Cloneable";
                }
                return null;
            case -1979556166:
                if (str.equals("java.lang.annotation.Annotation")) {
                    return "kotlin.Annotation";
                }
                return null;
            case -1571515090:
                if (str.equals("java.lang.Comparable")) {
                    return "kotlin.Comparable";
                }
                return null;
            case -1383349348:
                if (str.equals("java.util.Map")) {
                    return "kotlin.collections.Map";
                }
                return null;
            case -1383343454:
                if (str.equals("java.util.Set")) {
                    return "kotlin.collections.Set";
                }
                return null;
            case -1325958191:
                if (str.equals("double")) {
                    return "kotlin.Double";
                }
                return null;
            case -1182275604:
                if (str.equals("kotlin.jvm.internal.ByteCompanionObject")) {
                    return "kotlin.Byte.Companion";
                }
                return null;
            case -1062240117:
                if (str.equals("java.lang.CharSequence")) {
                    return "kotlin.CharSequence";
                }
                return null;
            case -688322466:
                if (str.equals("java.util.Collection")) {
                    return "kotlin.collections.Collection";
                }
                return null;
            case -527879800:
                if (str.equals("java.lang.Float")) {
                    return "kotlin.Float";
                }
                return null;
            case -515992664:
                if (str.equals("java.lang.Short")) {
                    return "kotlin.Short";
                }
                return null;
            case -246476834:
                if (str.equals("kotlin.jvm.internal.CharCompanionObject")) {
                    return "kotlin.Char.Companion";
                }
                return null;
            case -207262728:
                if (str.equals("kotlin.jvm.internal.LongCompanionObject")) {
                    return "kotlin.Long.Companion";
                }
                return null;
            case -165139126:
                if (str.equals("java.util.Map$Entry")) {
                    return "kotlin.collections.Map.Entry";
                }
                return null;
            case 104431:
                if (str.equals("int")) {
                    return "kotlin.Int";
                }
                return null;
            case 3039496:
                if (str.equals("byte")) {
                    return "kotlin.Byte";
                }
                return null;
            case 3052374:
                if (str.equals("char")) {
                    return "kotlin.Char";
                }
                return null;
            case 3327612:
                if (str.equals("long")) {
                    return "kotlin.Long";
                }
                return null;
            case 64711720:
                if (str.equals("boolean")) {
                    return "kotlin.Boolean";
                }
                return null;
            case 65821278:
                if (str.equals("java.util.List")) {
                    return "kotlin.collections.List";
                }
                return null;
            case 77230534:
                if (str.equals("kotlin.jvm.internal.ShortCompanionObject")) {
                    return "kotlin.Short.Companion";
                }
                return null;
            case 97526364:
                if (str.equals("float")) {
                    return "kotlin.Float";
                }
                return null;
            case 109413500:
                if (str.equals("short")) {
                    return "kotlin.Short";
                }
                return null;
            case 155276373:
                if (str.equals("java.lang.Character")) {
                    return "kotlin.Char";
                }
                return null;
            case 226173651:
                if (str.equals("kotlin.jvm.internal.EnumCompanionObject")) {
                    return "kotlin.Enum.Companion";
                }
                return null;
            case 344809556:
                if (str.equals("java.lang.Boolean")) {
                    return "kotlin.Boolean";
                }
                return null;
            case 398507100:
                if (str.equals("java.lang.Byte")) {
                    return "kotlin.Byte";
                }
                return null;
            case 398585941:
                if (str.equals("java.lang.Enum")) {
                    return "kotlin.Enum";
                }
                return null;
            case 398795216:
                if (str.equals("java.lang.Long")) {
                    return "kotlin.Long";
                }
                return null;
            case 482629606:
                if (str.equals("kotlin.jvm.internal.FloatCompanionObject")) {
                    return "kotlin.Float.Companion";
                }
                return null;
            case 499831342:
                if (str.equals("java.util.Iterator")) {
                    return "kotlin.collections.Iterator";
                }
                return null;
            case 577341676:
                if (str.equals("java.util.ListIterator")) {
                    return "kotlin.collections.ListIterator";
                }
                return null;
            case 599019395:
                if (str.equals("kotlin.jvm.internal.StringCompanionObject")) {
                    return "kotlin.String.Companion";
                }
                return null;
            case 761287205:
                if (str.equals("java.lang.Double")) {
                    return "kotlin.Double";
                }
                return null;
            case 1052881309:
                if (str.equals("java.lang.Number")) {
                    return "kotlin.Number";
                }
                return null;
            case 1063877011:
                if (str.equals("java.lang.Object")) {
                    return "kotlin.Any";
                }
                return null;
            case 1195259493:
                if (str.equals("java.lang.String")) {
                    return "kotlin.String";
                }
                return null;
            case 1275614662:
                if (str.equals("java.lang.Iterable")) {
                    return "kotlin.collections.Iterable";
                }
                return null;
            case 1383693018:
                if (str.equals("kotlin.jvm.internal.BooleanCompanionObject")) {
                    return "kotlin.Boolean.Companion";
                }
                return null;
            case 1630335596:
                if (str.equals("java.lang.Throwable")) {
                    return "kotlin.Throwable";
                }
                return null;
            case 1877171123:
                if (str.equals("kotlin.jvm.internal.IntCompanionObject")) {
                    return "kotlin.Int.Companion";
                }
                return null;
            default:
                switch (iHashCode) {
                    case -1811142716:
                        if (str.equals("kotlin.jvm.functions.Function10")) {
                            return "kotlin.Function10";
                        }
                        return null;
                    case -1811142715:
                        if (str.equals("kotlin.jvm.functions.Function11")) {
                            return "kotlin.Function11";
                        }
                        return null;
                    case -1811142714:
                        if (str.equals("kotlin.jvm.functions.Function12")) {
                            return "kotlin.Function12";
                        }
                        return null;
                    case -1811142713:
                        if (str.equals("kotlin.jvm.functions.Function13")) {
                            return "kotlin.Function13";
                        }
                        return null;
                    case -1811142712:
                        if (str.equals("kotlin.jvm.functions.Function14")) {
                            return "kotlin.Function14";
                        }
                        return null;
                    case -1811142711:
                        if (str.equals("kotlin.jvm.functions.Function15")) {
                            return "kotlin.Function15";
                        }
                        return null;
                    case -1811142710:
                        if (str.equals("kotlin.jvm.functions.Function16")) {
                            return "kotlin.Function16";
                        }
                        return null;
                    case -1811142709:
                        if (str.equals("kotlin.jvm.functions.Function17")) {
                            return "kotlin.Function17";
                        }
                        return null;
                    case -1811142708:
                        if (str.equals("kotlin.jvm.functions.Function18")) {
                            return "kotlin.Function18";
                        }
                        return null;
                    case -1811142707:
                        if (str.equals("kotlin.jvm.functions.Function19")) {
                            return "kotlin.Function19";
                        }
                        return null;
                    default:
                        switch (iHashCode) {
                            case -1811142685:
                                if (str.equals("kotlin.jvm.functions.Function20")) {
                                    return "kotlin.Function20";
                                }
                                return null;
                            case -1811142684:
                                if (str.equals("kotlin.jvm.functions.Function21")) {
                                    return "kotlin.Function21";
                                }
                                return null;
                            case -1811142683:
                                if (str.equals("kotlin.jvm.functions.Function22")) {
                                    return "kotlin.Function22";
                                }
                                return null;
                            default:
                                switch (iHashCode) {
                                    case 80123371:
                                        if (str.equals("kotlin.jvm.functions.Function0")) {
                                            return "kotlin.Function0";
                                        }
                                        return null;
                                    case 80123372:
                                        if (str.equals("kotlin.jvm.functions.Function1")) {
                                            return "kotlin.Function1";
                                        }
                                        return null;
                                    case 80123373:
                                        if (str.equals("kotlin.jvm.functions.Function2")) {
                                            return "kotlin.Function2";
                                        }
                                        return null;
                                    case 80123374:
                                        if (str.equals("kotlin.jvm.functions.Function3")) {
                                            return "kotlin.Function3";
                                        }
                                        return null;
                                    case 80123375:
                                        if (str.equals("kotlin.jvm.functions.Function4")) {
                                            return "kotlin.Function4";
                                        }
                                        return null;
                                    case 80123376:
                                        if (str.equals("kotlin.jvm.functions.Function5")) {
                                            return "kotlin.Function5";
                                        }
                                        return null;
                                    case 80123377:
                                        if (str.equals("kotlin.jvm.functions.Function6")) {
                                            return "kotlin.Function6";
                                        }
                                        return null;
                                    case 80123378:
                                        if (str.equals("kotlin.jvm.functions.Function7")) {
                                            return "kotlin.Function7";
                                        }
                                        return null;
                                    case 80123379:
                                        if (str.equals("kotlin.jvm.functions.Function8")) {
                                            return "kotlin.Function8";
                                        }
                                        return null;
                                    case 80123380:
                                        if (str.equals("kotlin.jvm.functions.Function9")) {
                                            return "kotlin.Function9";
                                        }
                                        return null;
                                    default:
                                        return null;
                                }
                        }
                }
        }
    }

    public static float t(float f2, float f3, float f4) {
        if (f3 <= f4) {
            return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f4 + " is less than minimum " + f3 + '.');
    }

    public static int u(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static int v(int i, b12 b12Var) {
        b12Var.getClass();
        int i2 = b12Var.f;
        int i3 = b12Var.b;
        if (!b12Var.isEmpty()) {
            return i < Integer.valueOf(i3).intValue() ? Integer.valueOf(i3).intValue() : i > Integer.valueOf(i2).intValue() ? Integer.valueOf(i2).intValue() : i;
        }
        s53.g(b12Var, 46, "Cannot coerce value to an empty range: ");
        return 0;
    }

    public static long w(long j, long j2, long j3) {
        if (j2 <= j3) {
            return j < j2 ? j2 : j > j3 ? j3 : j;
        }
        StringBuilder sbC = fw.C("Cannot coerce value to an empty range: maximum ", " is less than minimum ", j3);
        sbC.append(j2);
        sbC.append('.');
        throw new IllegalArgumentException(sbC.toString());
    }

    public static final void x(m20 m20Var, String str, String str2) {
        str.getClass();
        str2.getClass();
        ArrayList arrayList = m20Var.a;
        arrayList.add(str);
        arrayList.add(p44.U0(str2).toString());
    }

    public static final lr1 y(m20 m20Var) {
        m20Var.getClass();
        return new lr1((String[]) m20Var.a.toArray(new String[0]));
    }

    public static final String z(lr1 lr1Var, int i) {
        lr1Var.getClass();
        String str = (String) qe.m0(i * 2, lr1Var.b);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + i + ']');
    }

    @Override // defpackage.er4
    public void a() {
    }

    @Override // defpackage.er4
    public void b() {
    }
}
