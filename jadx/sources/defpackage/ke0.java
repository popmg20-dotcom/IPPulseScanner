package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Xml;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.TrafficListActivity;
import io.netty.handler.codec.rtsp.RtspHeaders;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.IDN;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.functions.Function2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ke0 implements le0 {
    public static final qv a = new qv();
    public static final Object b = new Object();
    public static final g10 c = new g10(6);
    public static final g10 d = new g10(7);

    public static long B(String str) {
        long j;
        int length = str.length();
        str.getClass();
        long j2 = 0;
        if (length < 0) {
            e04.f(fw.s(length, 0, "endIndex < beginIndex: ", " < "));
            return 0L;
        }
        if (length > str.length()) {
            StringBuilder sbD = dw2.D("endIndex > string.length: ", length, " > ");
            sbD.append(str.length());
            throw new IllegalArgumentException(sbD.toString().toString());
        }
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                j2++;
            } else {
                if (cCharAt < 2048) {
                    j = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    j = 3;
                } else {
                    int i2 = i + 1;
                    char cCharAt2 = i2 < length ? str.charAt(i2) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j2++;
                        i = i2;
                    } else {
                        j2 += 4;
                        i += 2;
                    }
                }
                j2 += j;
            }
            i++;
        }
        return j2;
    }

    public static void C(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    public static List D(String str, char c2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int iIndexOf = str.indexOf(c2, i);
            if (iIndexOf == -1) {
                break;
            }
            arrayList.add(str.substring(i, iIndexOf));
            i = iIndexOf + 1;
        }
        if (i == 0) {
            return Collections.singletonList(str);
        }
        arrayList.add(str.substring(i));
        int size = arrayList.size();
        while (size > 0 && ((String) arrayList.get(size - 1)).isEmpty()) {
            size--;
        }
        return size == arrayList.size() ? arrayList : arrayList.subList(0, size);
    }

    public static void E(View view, cg4 cg4Var) {
        Intent intent = new Intent(view.getContext(), (Class<?>) TrafficListActivity.class);
        intent.putExtra("sort_mode", cg4Var.name());
        view.getContext().startActivity(intent, l72.z(view));
    }

    public static boolean F(String str, char c2) {
        return str.length() != 0 && str.charAt(0) == c2;
    }

    public static void G(yx yxVar, ArrayList arrayList) {
        if (yxVar instanceof zx) {
            Iterator it = ((zx) yxVar).a.iterator();
            while (it.hasNext()) {
                G((yx) it.next(), arrayList);
            }
        } else if (yxVar instanceof d10) {
            arrayList.add(((d10) yxVar).a);
        } else {
            arrayList.add(new hx(yxVar));
        }
    }

    public static final List H(ArrayList arrayList) {
        int size = arrayList.size();
        return size != 0 ? size != 1 ? DesugarCollections.unmodifiableList(new ArrayList(arrayList)) : Collections.singletonList(d70.d0(arrayList)) : g41.b;
    }

    public static final Map I(Map map) {
        int size = map.size();
        if (size == 0) {
            return h41.b;
        }
        if (size != 1) {
            return DesugarCollections.unmodifiableMap(new LinkedHashMap(map));
        }
        Map.Entry entry = (Map.Entry) d70.c0(map.entrySet());
        return Collections.singletonMap(entry.getKey(), entry.getValue());
    }

    public static final String J(String str) {
        String str2;
        if (str == null || p44.x0(str)) {
            return "";
        }
        if2 if2Var = fx0.a;
        String str3 = (String) fx0.a.h(str);
        if (str3 != null) {
            return str3;
        }
        if (p44.o0(str, "xn--", true)) {
            try {
                str2 = IDN.toUnicode(str) + "(" + str + ")";
            } catch (Exception unused) {
                str2 = str;
            }
        } else {
            str2 = str;
        }
        if2 if2Var2 = fx0.a;
        fx0.a.l(str, str2);
        return str2;
    }

    public static void K(Bundle bundle, Object obj) {
        if (obj instanceof Double) {
            bundle.putDouble("value", ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            bundle.putLong("value", ((Long) obj).longValue());
        } else {
            bundle.putString("value", obj.toString());
        }
    }

    public static Object L(Bundle bundle, String str, Class cls, Object obj) {
        Object obj2 = bundle.get(str);
        if (obj2 == null) {
            return obj;
        }
        if (cls.isAssignableFrom(obj2.getClass())) {
            return obj2;
        }
        String canonicalName = cls.getCanonicalName();
        xe.q(fw.y(fw.E("Invalid conditional user property field type. '", str, "' expected [", canonicalName, "] but was ["), obj2.getClass().getCanonicalName(), "]"));
        return null;
    }

    public static int b(tt ttVar, boolean z) {
        int i = ttVar.b;
        int i2 = ttVar.c;
        int i3 = z ? i2 : i;
        if (!z) {
            i = i2;
        }
        byte[][] bArr = (byte[][]) ttVar.d;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            byte b2 = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < i; i7++) {
                byte b3 = z ? bArr[i5][i7] : bArr[i7][i5];
                if (b3 == b2) {
                    i6++;
                } else {
                    if (i6 >= 5) {
                        i4 += i6 - 2;
                    }
                    i6 = 1;
                    b2 = b3;
                }
            }
            if (i6 >= 5) {
                i4 = (i6 - 2) + i4;
            }
        }
        return i4;
    }

    public static final void e(j50 j50Var, Object obj) {
        if (j50Var.d(obj)) {
            obj.getClass();
            return;
        }
        throw new ClassCastException("Value cannot be cast to " + j50Var.b());
    }

    public static boolean f(String str, char c2) {
        return str.length() != 0 && str.charAt(str.length() - 1) == c2;
    }

    public static final cf0 h(pl3 pl3Var, ie0 ie0Var) {
        if (!pl3Var.k()) {
            return ((ce0) pl3Var.f()).b;
        }
        if (ie0Var.j().Z(hg4.b) != null) {
            st4.n();
            return null;
        }
        ce0 ce0Var = pl3Var.a;
        if (ce0Var != null) {
            return ce0Var.b;
        }
        n12.T("coroutineScope");
        throw null;
    }

    public static Rect i(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 30) {
            return j2.f(windowManager);
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        Rect rect = new Rect();
        rect.right = point.x;
        rect.bottom = point.y;
        return rect;
    }

    public static final Map j() {
        return fh2.V(new e03(cd4.b, Integer.valueOf(R.style.Theme_Surfboard)), new e03(cd4.f, Integer.valueOf(R.style.AppTheme_Green)), new e03(cd4.z, Integer.valueOf(R.style.AppTheme_Pink)), new e03(cd4.A, Integer.valueOf(R.style.AppTheme_Purple)), new e03(cd4.X, Integer.valueOf(R.style.AppTheme_Orange)), new e03(cd4.Y, Integer.valueOf(R.style.AppTheme_Green_1)), new e03(cd4.Z, Integer.valueOf(R.style.AppTheme_Yellow_1)));
    }

    public static boolean l(u03 u03Var) {
        bu buVarP = u03Var.b;
        int iK = bu.k(buVarP, f.a);
        if (iK == -1) {
            iK = bu.k(u03Var.b, f.b);
        }
        if (iK != -1) {
            buVarP = bu.p(buVarP, iK + 1, 0, 2);
        } else if (u03Var.e() != null && buVarP.d() == 2) {
            buVarP = bu.A;
        }
        return !w44.d0(buVarP.r(), ".class", true);
    }

    public static int m(int i, int i2, int i3) throws IOException {
        if ((i2 & 8) != 0) {
            i--;
        }
        if (i3 <= i) {
            return i - i3;
        }
        vp1.i(fw.s(i3, i, "PROTOCOL_ERROR padding ", " > remaining length "));
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v13 */
    public static gi1 q(XmlResourceParser xmlResourceParser, Resources resources) throws Exception {
        int next;
        int i;
        int i2;
        ?? r3;
        Throwable th;
        ?? r32;
        do {
            next = xmlResourceParser.next();
            i = 2;
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlResourceParser.require(2, null, "font-family");
        if (!xmlResourceParser.getName().equals("font-family")) {
            C(xmlResourceParser);
            return null;
        }
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), yc3.b);
        int i3 = 0;
        String string = typedArrayObtainAttributes.getString(0);
        String string2 = typedArrayObtainAttributes.getString(5);
        String string3 = typedArrayObtainAttributes.getString(6);
        String string4 = typedArrayObtainAttributes.getString(2);
        int resourceId = typedArrayObtainAttributes.getResourceId(1, 0);
        int i4 = 3;
        int integer = typedArrayObtainAttributes.getInteger(3, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(4, 500);
        String string5 = typedArrayObtainAttributes.getString(7);
        typedArrayObtainAttributes.recycle();
        if (string == null || string2 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlResourceParser.next() != 3) {
                if (xmlResourceParser.getEventType() == 2) {
                    if (xmlResourceParser.getName().equals("font")) {
                        TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), yc3.c);
                        int i5 = typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(8) ? 8 : 1, 400);
                        boolean z = 1 == typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(6) ? 6 : 2, 0);
                        int i6 = typedArrayObtainAttributes2.hasValue(9) ? 9 : 3;
                        String string6 = typedArrayObtainAttributes2.getString(typedArrayObtainAttributes2.hasValue(7) ? 7 : 4);
                        int i7 = typedArrayObtainAttributes2.getInt(i6, 0);
                        int i8 = typedArrayObtainAttributes2.hasValue(5) ? 5 : 0;
                        int resourceId2 = typedArrayObtainAttributes2.getResourceId(i8, 0);
                        String string7 = typedArrayObtainAttributes2.getString(i8);
                        typedArrayObtainAttributes2.recycle();
                        while (xmlResourceParser.next() != 3) {
                            C(xmlResourceParser);
                        }
                        arrayList.add(new ii1(i5, i7, resourceId2, string7, string6, z));
                    } else {
                        C(xmlResourceParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new hi1((ii1[]) arrayList.toArray(new ii1[0]));
        }
        List listV = v(resources, resourceId);
        ArrayList arrayList2 = new ArrayList();
        while (xmlResourceParser.next() != i4) {
            if (xmlResourceParser.getEventType() == i) {
                if (xmlResourceParser.getName().equals("fallback")) {
                    TypedArray typedArrayObtainAttributes3 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), yc3.d);
                    try {
                        String string8 = typedArrayObtainAttributes3.getString(i3);
                        String string9 = typedArrayObtainAttributes3.getString(1);
                        i2 = integer;
                        String string10 = typedArrayObtainAttributes3.getString(i);
                        if (string8 == null) {
                            r3 = typedArrayObtainAttributes3;
                            throw new XmlPullParserException("query attribute must be set in fallback element");
                        }
                        while (xmlResourceParser.next() != i4) {
                            try {
                                C(xmlResourceParser);
                            } catch (Throwable th2) {
                                th = th2;
                                r32 = typedArrayObtainAttributes3;
                            }
                        }
                        r3 = typedArrayObtainAttributes3;
                        try {
                            ai1 ai1Var = new ai1(string, string2, string8, listV, string9, string10);
                            if (r3 instanceof AutoCloseable) {
                                ((AutoCloseable) r3).close();
                            } else if (r3 instanceof ExecutorService) {
                                l0.u((ExecutorService) r3);
                            } else {
                                r3.recycle();
                            }
                            arrayList2.add(ai1Var);
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        th = th3;
                    } catch (Throwable th4) {
                        th = th4;
                        r3 = typedArrayObtainAttributes3;
                    }
                    th = th;
                    r32 = r3;
                    if (r32 == 0) {
                        throw th;
                    }
                    try {
                        if (r32 instanceof AutoCloseable) {
                            ((AutoCloseable) r32).close();
                        } else if (r32 instanceof ExecutorService) {
                            l0.u((ExecutorService) r32);
                        } else {
                            r32.recycle();
                        }
                        throw th;
                    } catch (Throwable th5) {
                        th.addSuppressed(th5);
                        throw th;
                    }
                }
                i2 = integer;
                C(xmlResourceParser);
                integer = i2;
                i = 2;
                i3 = 0;
                i4 = 3;
            }
        }
        int i9 = integer;
        if (!arrayList2.isEmpty()) {
            return new ji1(arrayList2, i9, integer2, string5);
        }
        if (string3 == null) {
            xe.k("The provider font XML requires query attribute or fallback children.");
            return null;
        }
        arrayList2.add(new ai1(string, string2, string3, listV, null, null));
        if (string4 != null) {
            arrayList2.add(new ai1(string, string2, string4, listV, null, null));
        }
        return new ji1(arrayList2, i9, integer2, string5);
    }

    public static final Object r(pl3 pl3Var, boolean z, boolean z2, am1 am1Var) {
        pl3Var.getClass();
        pl3Var.a();
        if (!pl3Var.k() || pl3Var.l() || pl3Var.h.get() == null) {
            return co4.R(new ch0(null, am1Var, pl3Var, z2, z));
        }
        xe.q("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object s(defpackage.ge0 r7, defpackage.am1 r8, defpackage.pl3 r9, boolean r10) {
        /*
            boolean r0 = r7 instanceof defpackage.eh0
            if (r0 == 0) goto L13
            r0 = r7
            eh0 r0 = (defpackage.eh0) r0
            int r1 = r0.y0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.y0 = r1
            goto L18
        L13:
            eh0 r0 = new eh0
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.Z
            int r1 = r0.y0
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            mf0 r6 = defpackage.mf0.b
            if (r1 == 0) goto L42
            if (r1 == r5) goto L3e
            if (r1 == r4) goto L34
            if (r1 != r3) goto L2e
            defpackage.n12.S(r7)
            return r7
        L2e:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r7)
            return r2
        L34:
            boolean r10 = r0.Y
            am1 r8 = r0.X
            pl3 r9 = r0.A
            defpackage.n12.S(r7)
            goto L75
        L3e:
            defpackage.n12.S(r7)
            return r7
        L42:
            defpackage.n12.S(r7)
            boolean r7 = r9.k()
            if (r7 == 0) goto L66
            boolean r7 = r9.o()
            if (r7 == 0) goto L66
            boolean r7 = r9.l()
            if (r7 == 0) goto L66
            fh0 r7 = new fh0
            r7.<init>(r2, r8, r9, r10)
            r0.y0 = r5
            java.lang.Object r7 = r9.r(r10, r7, r0)
            if (r7 != r6) goto L65
            goto L88
        L65:
            return r7
        L66:
            r0.A = r9
            r0.X = r8
            r0.Y = r10
            r0.y0 = r4
            cf0 r7 = h(r9, r0)
            if (r7 != r6) goto L75
            goto L88
        L75:
            cf0 r7 = (defpackage.cf0) r7
            dh0 r1 = new dh0
            r1.<init>(r2, r8, r9, r10)
            r0.A = r2
            r0.X = r2
            r0.y0 = r3
            java.lang.Object r7 = defpackage.ji0.b0(r7, r1, r0)
            if (r7 != r6) goto L89
        L88:
            return r6
        L89:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ke0.s(ge0, am1, pl3, boolean):java.lang.Object");
    }

    public static i14 t(Class cls, final CopyOnWriteArraySet copyOnWriteArraySet) {
        return (i14) cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: a61
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                Iterator it = copyOnWriteArraySet.iterator();
                Throwable th = null;
                while (it.hasNext()) {
                    try {
                        method.invoke((i14) it.next(), objArr);
                    } catch (Throwable th2) {
                        Throwable thA = n61.a(th2);
                        if (th == null) {
                            th = thA;
                        } else if (thA != null && thA != th) {
                            th.addSuppressed(thA);
                        }
                    }
                }
                if (th == null) {
                    return null;
                }
                throw n12.X(th);
            }
        }));
    }

    public static yl2 u(MappedByteBuffer mappedByteBuffer) throws IOException {
        long j;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
        int i = byteBufferDuplicate.getShort() & 65535;
        if (i > 100) {
            vp1.i("Cannot read metadata.");
            return null;
        }
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 6);
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                j = -1;
                break;
            }
            int i3 = byteBufferDuplicate.getInt();
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            j = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            if (1835365473 == i3) {
                break;
            }
            i2++;
        }
        if (j != -1) {
            byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) (j - ((long) byteBufferDuplicate.position()))));
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 12);
            long j2 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            for (int i4 = 0; i4 < j2; i4++) {
                int i5 = byteBufferDuplicate.getInt();
                long j3 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
                byteBufferDuplicate.getInt();
                if (1164798569 == i5 || 1701669481 == i5) {
                    byteBufferDuplicate.position((int) (j3 + j));
                    yl2 yl2Var = new yl2();
                    byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                    yl2Var.A = byteBufferDuplicate;
                    yl2Var.b = iPosition;
                    int i6 = iPosition - byteBufferDuplicate.getInt(iPosition);
                    yl2Var.f = i6;
                    yl2Var.z = ((ByteBuffer) yl2Var.A).getShort(i6);
                    return yl2Var;
                }
            }
        }
        vp1.i("Cannot read metadata.");
        return null;
    }

    public static List v(Resources resources, int i) {
        if (i == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (typedArrayObtainTypedArray.getType(0) == 1) {
                for (int i2 = 0; i2 < typedArrayObtainTypedArray.length(); i2++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static final List w(io3 io3Var) {
        int iD = xb5.d(io3Var, "id");
        int iD2 = xb5.d(io3Var, RtspHeaders.Values.SEQ);
        int iD3 = xb5.d(io3Var, "from");
        int iD4 = xb5.d(io3Var, "to");
        ub2 ub2VarI = p95.i();
        while (io3Var.C0()) {
            ub2VarI.add(new pi1((int) io3Var.getLong(iD), (int) io3Var.getLong(iD2), io3Var.e0(iD3), io3Var.e0(iD4)));
        }
        return d70.t0(p95.c(ub2VarI));
    }

    public static final ma4 x(go3 go3Var, String str, boolean z) {
        io3 io3VarD0 = go3Var.D0("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int iD = xb5.d(io3VarD0, "seqno");
            int iD2 = xb5.d(io3VarD0, "cid");
            int iD3 = xb5.d(io3VarD0, "name");
            int iD4 = xb5.d(io3VarD0, "desc");
            if (iD != -1 && iD2 != -1 && iD3 != -1 && iD4 != -1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                while (io3VarD0.C0()) {
                    if (((int) io3VarD0.getLong(iD2)) >= 0) {
                        int i = (int) io3VarD0.getLong(iD);
                        String strE0 = io3VarD0.e0(iD3);
                        String str2 = io3VarD0.getLong(iD4) > 0 ? "DESC" : "ASC";
                        linkedHashMap.put(Integer.valueOf(i), strE0);
                        linkedHashMap2.put(Integer.valueOf(i), str2);
                    }
                }
                List listU0 = d70.u0(linkedHashMap.entrySet(), new e1(19));
                ArrayList arrayList = new ArrayList(f70.Q(10, listU0));
                Iterator it = listU0.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Map.Entry) it.next()).getValue());
                }
                List listY0 = d70.y0(arrayList);
                List listU02 = d70.u0(linkedHashMap2.entrySet(), new e1(20));
                ArrayList arrayList2 = new ArrayList(f70.Q(10, listU02));
                Iterator it2 = listU02.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((String) ((Map.Entry) it2.next()).getValue());
                }
                ma4 ma4Var = new ma4(str, z, listY0, d70.y0(arrayList2));
                vf2.e(io3VarD0, null);
                return ma4Var;
            }
            vf2.e(io3VarD0, null);
            return null;
        } finally {
        }
    }

    public static final Object y(Object obj) {
        return obj instanceof r80 ? n12.r(((r80) obj).a) : obj;
    }

    public static final Object z(cf0 cf0Var, Function2 function2) throws Throwable {
        b61 b61VarA;
        cf0 cf0VarP;
        long jG0;
        Thread threadCurrentThread = Thread.currentThread();
        bf0 bf0Var = pr1.f;
        ef0 ef0Var = (ef0) cf0Var.Z(bf0Var);
        c41 c41Var = c41.b;
        if (ef0Var == null) {
            b61VarA = qd4.a();
            cf0VarP = co4.p(c41Var, cf0Var.X(b61VarA), true);
            gm0 gm0Var = qv0.a;
            if (cf0VarP != gm0Var && cf0VarP.Z(bf0Var) == null) {
                cf0VarP = cf0VarP.X(gm0Var);
            }
        } else {
            b61VarA = (b61) qd4.a.get();
            cf0VarP = co4.p(c41Var, cf0Var, true);
            gm0 gm0Var2 = qv0.a;
            if (cf0VarP != gm0Var2 && cf0VarP.Z(bf0Var) == null) {
                cf0VarP = cf0VarP.X(gm0Var2);
            }
        }
        vn vnVar = new vn(cf0VarP, threadCurrentThread, b61VarA);
        vnVar.l0(of0.b, vnVar, function2);
        b61 b61Var = vnVar.X;
        if (b61Var != null) {
            int i = b61.Y;
            b61Var.F0(false);
        }
        while (true) {
            if (b61Var != null) {
                try {
                    jG0 = b61Var.G0();
                } catch (Throwable th) {
                    if (b61Var != null) {
                        int i2 = b61.Y;
                        b61Var.x0(false);
                    }
                    throw th;
                }
            } else {
                jG0 = Long.MAX_VALUE;
            }
            if (vnVar.P()) {
                break;
            }
            LockSupport.parkNanos(vnVar, jG0);
            if (Thread.interrupted()) {
                vnVar.q(new InterruptedException());
            }
        }
        if (b61Var != null) {
            int i3 = b61.Y;
            b61Var.x0(false);
        }
        Object objA = f42.a(vnVar.H());
        r80 r80Var = objA instanceof r80 ? (r80) objA : null;
        if (r80Var == null) {
            return objA;
        }
        throw r80Var.a;
    }

    public abstract b72 A(Class cls);

    public abstract ke0 a(Annotation annotation);

    public abstract cp1 c();

    public abstract o9 d();

    public v62 g(nj4 nj4Var, gt3 gt3Var, nm nmVar) {
        b72 b72VarI = gt3Var.i(nj4Var, nmVar);
        return new v62(18, b72VarI, n(nj4Var.L0, b72VarI), false);
    }

    public abstract boolean k(Annotation annotation);

    public abstract ke0 n(Class cls, b72 b72Var);

    public abstract void o(int i);

    public abstract void p(Typeface typeface, boolean z);
}
