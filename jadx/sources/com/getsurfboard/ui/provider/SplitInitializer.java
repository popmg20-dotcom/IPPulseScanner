package com.getsurfboard.ui.provider;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import com.getsurfboard.R;
import defpackage.b31;
import defpackage.c31;
import defpackage.d02;
import defpackage.d70;
import defpackage.dw2;
import defpackage.e04;
import defpackage.eg0;
import defpackage.ew0;
import defpackage.fh2;
import defpackage.fw0;
import defpackage.g4;
import defpackage.g41;
import defpackage.g91;
import defpackage.gb4;
import defpackage.gw0;
import defpackage.h91;
import defpackage.hw0;
import defpackage.iw0;
import defpackage.jw0;
import defpackage.k04;
import defpackage.k41;
import defpackage.kw0;
import defpackage.m04;
import defpackage.me;
import defpackage.n04;
import defpackage.pc3;
import defpackage.r04;
import defpackage.s04;
import defpackage.s21;
import defpackage.st4;
import defpackage.t04;
import defpackage.t21;
import defpackage.u04;
import defpackage.u21;
import defpackage.v04;
import defpackage.vf2;
import defpackage.w21;
import defpackage.x21;
import defpackage.xb5;
import defpackage.xe;
import defpackage.ye;
import defpackage.yr2;
import defpackage.z4;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class SplitInitializer implements d02 {
    @Override // defpackage.d02
    public final List a() {
        return g41.b;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // defpackage.d02
    public final Object b(Context context) throws XmlPullParserException, IOException {
        k04 k04Var;
        k04 k04Var2;
        k04 k04Var3;
        k04 k04Var4;
        Context context2;
        int i;
        z4 z4Var;
        HashSet hashSet;
        XmlResourceParser xmlResourceParser;
        kw0 jw0Var;
        int i2;
        float f;
        k04 k04Var5;
        k04 k04Var6;
        XmlResourceParser xmlResourceParser2;
        u04 u04Var;
        fw0 fw0Var = hw0.a;
        ew0 ew0Var = kw0.c;
        k04 k04Var7 = k04.c;
        t21 t21Var = u21.a;
        context.getClass();
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        h91 h91Var = h91.f;
        if (h91.f == null) {
            h91.g.lock();
            try {
                if (h91.f == null) {
                    Context applicationContext2 = applicationContext.getApplicationContext();
                    applicationContext2.getClass();
                    h91.f = new h91(applicationContext2, vf2.u(applicationContext2));
                }
            } finally {
            }
        }
        h91 h91Var2 = h91.f;
        h91Var2.getClass();
        g91 g91Var = new g91(h91Var2);
        k04 k04Var8 = k04.g;
        k04 k04Var9 = k04.f;
        k04 k04Var10 = k04.e;
        k04 k04Var11 = k04.d;
        Context applicationContext3 = context.getApplicationContext();
        applicationContext3.getClass();
        Set set = k41.b;
        u04 u04Var2 = u04.e;
        HashSet hashSet2 = null;
        try {
            XmlResourceParser xml = applicationContext3.getResources().getXml(R.xml.main_split_config);
            xml.getClass();
            HashSet hashSet3 = new HashSet();
            int depth = xml.getDepth();
            int next = xml.next();
            z4 z4Var2 = null;
            t04 t04Var = null;
            s04 s04Var = null;
            while (next != 1 && (next != 3 || xml.getDepth() > depth)) {
                if (xml.getEventType() != 2 || "split-config".equals(xml.getName())) {
                    z4 z4Var3 = z4Var2;
                    k04Var = k04Var8;
                    k04Var2 = k04Var9;
                    k04Var3 = k04Var10;
                    k04Var4 = k04Var11;
                    context2 = applicationContext3;
                    XmlResourceParser xmlResourceParser3 = xml;
                    HashSet hashSet4 = hashSet3;
                    i = depth;
                    next = xmlResourceParser3.next();
                    xml = xmlResourceParser3;
                    hashSet3 = hashSet4;
                    z4Var2 = z4Var3;
                } else {
                    String name = xml.getName();
                    if (name != null) {
                        k04Var = k04Var8;
                        k04Var2 = k04Var9;
                        switch (name.hashCode()) {
                            case 304713008:
                                k04Var3 = k04Var10;
                                k04Var4 = k04Var11;
                                context2 = applicationContext3;
                                xmlResourceParser = xml;
                                hashSet = hashSet3;
                                i = depth;
                                if (!name.equals("DividerAttributes")) {
                                    z4Var = z4Var2;
                                } else {
                                    if (s04Var == null && t04Var == null) {
                                        xe.k("Found orphaned DividerAttributes");
                                        return null;
                                    }
                                    TypedArray typedArrayObtainStyledAttributes = context2.getTheme().obtainStyledAttributes(xmlResourceParser, pc3.c, 0, 0);
                                    int i3 = typedArrayObtainStyledAttributes.getInt(3, 0);
                                    boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(1);
                                    boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(0);
                                    boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(5);
                                    if (i3 != 1) {
                                        if (zHasValue) {
                                            xe.k("Fixed divider does not allow attribute dragRangeMinRatio!");
                                            return null;
                                        }
                                        if (zHasValue2) {
                                            xe.k("Fixed divider does not allow attribute dragRangeMaxRatio!");
                                            return null;
                                        }
                                        if (zHasValue3) {
                                            xe.k("Fixed divider does not allow attribute isDraggingToFullscreenAllowed!");
                                            return null;
                                        }
                                    }
                                    int i4 = typedArrayObtainStyledAttributes.getInt(4, -1);
                                    int color = typedArrayObtainStyledAttributes.getColor(2, -16777216);
                                    float f2 = typedArrayObtainStyledAttributes.getFloat(1, -1.0f);
                                    float f3 = typedArrayObtainStyledAttributes.getFloat(0, -1.0f);
                                    boolean z = typedArrayObtainStyledAttributes.getBoolean(5, false);
                                    if (i3 != 0) {
                                        z4Var = z4Var2;
                                        if (i3 != 1) {
                                            throw new IllegalArgumentException("Got unknown divider type " + i3 + '!');
                                        }
                                        if (i4 != -1 && i4 < 0) {
                                            e04.f(dw2.A(i4, "widthDp must be greater than or equal to 0 or WIDTH_SYSTEM_DEFAULT. Got: "));
                                            return null;
                                        }
                                        if ((color >>> 24) != 255) {
                                            st4.o(Integer.toHexString(color), "Divider color must be opaque. Got: ");
                                            return null;
                                        }
                                        jw0Var = new iw0(i4, color, (f2 == -1.0f || f3 == -1.0f) ? fw0Var : new gw0(f2, f3), z);
                                    } else {
                                        z4Var = z4Var2;
                                        if (i4 != -1 && i4 < 0) {
                                            e04.f(dw2.A(i4, "widthDp must be greater than or equal to 0 or WIDTH_SYSTEM_DEFAULT. Got: "));
                                            return null;
                                        }
                                        if ((color >>> 24) != 255) {
                                            st4.o(Integer.toHexString(color), "Divider color must be opaque. Got: ");
                                            return null;
                                        }
                                        jw0Var = new jw0(i4, color);
                                    }
                                    if (s04Var != null) {
                                        n04 n04Var = s04Var.g;
                                        hashSet.remove(s04Var);
                                        m04 m04Var = m04.c;
                                        m04 m04Var2 = n04Var.a;
                                        m04Var2.getClass();
                                        k04 k04Var12 = n04Var.b;
                                        k04Var12.getClass();
                                        w21 w21Var = n04Var.c;
                                        w21Var.getClass();
                                        n04Var.d.getClass();
                                        n04 n04Var2 = new n04(m04Var2, k04Var12, w21Var, jw0Var);
                                        Set set2 = s04Var.j;
                                        x21 x21Var = v04.h;
                                        m04 m04Var3 = m04.c;
                                        s04 s04Var2 = new s04(set2, n04Var2, s04Var.a(), s04Var.k, s04Var.l, s04Var.m, s04Var.b, s04Var.c, s04Var.d, s04Var.e, s04Var.f);
                                        gb4.e(hashSet, s04Var2);
                                        s04Var = s04Var2;
                                    } else if (t04Var != null) {
                                        n04 n04Var3 = t04Var.g;
                                        hashSet.remove(t04Var);
                                        m04 m04Var4 = m04.c;
                                        m04 m04Var5 = n04Var3.a;
                                        m04Var5.getClass();
                                        k04 k04Var13 = n04Var3.b;
                                        k04Var13.getClass();
                                        w21 w21Var2 = n04Var3.c;
                                        w21Var2.getClass();
                                        n04Var3.d.getClass();
                                        n04 n04Var4 = new n04(m04Var5, k04Var13, w21Var2, jw0Var);
                                        Set set3 = t04Var.j;
                                        Intent intent = t04Var.k;
                                        x21 x21Var2 = v04.h;
                                        m04 m04Var6 = m04.c;
                                        t04 t04Var2 = new t04(t04Var.a(), set3, intent, t04Var.l, t04Var.m, t04Var.b, t04Var.c, t04Var.d, t04Var.e, t04Var.f, n04Var4);
                                        gb4.e(hashSet, t04Var2);
                                        t04Var = t04Var2;
                                    }
                                }
                                z4Var2 = z4Var;
                                next = xmlResourceParser.next();
                                xml = xmlResourceParser;
                                hashSet3 = hashSet;
                                break;
                            case 511422343:
                                k04Var3 = k04Var10;
                                k04Var4 = k04Var11;
                                context2 = applicationContext3;
                                xmlResourceParser = xml;
                                hashSet = hashSet3;
                                i = depth;
                                if (name.equals("ActivityFilter")) {
                                    if (z4Var2 == null && t04Var == null) {
                                        xe.k("Found orphaned ActivityFilter");
                                        return null;
                                    }
                                    TypedArray typedArrayObtainStyledAttributes2 = context2.getTheme().obtainStyledAttributes(xmlResourceParser, pc3.a, 0, 0);
                                    String string = typedArrayObtainStyledAttributes2.getString(1);
                                    String string2 = typedArrayObtainStyledAttributes2.getString(0);
                                    String packageName = context2.getApplicationContext().getPackageName();
                                    packageName.getClass();
                                    g4 g4Var = new g4(gb4.n(packageName, string), string2);
                                    if (z4Var2 != null) {
                                        hashSet.remove(z4Var2);
                                        String strA = z4Var2.a();
                                        Set set4 = z4Var2.b;
                                        LinkedHashSet linkedHashSet = new LinkedHashSet(fh2.U(set4.size() + 1));
                                        linkedHashSet.addAll(set4);
                                        linkedHashSet.add(g4Var);
                                        z4 z4Var4 = new z4(strA, linkedHashSet, z4Var2.c);
                                        gb4.e(hashSet, z4Var4);
                                        z4Var2 = z4Var4;
                                    } else if (t04Var != null) {
                                        hashSet.remove(t04Var);
                                        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                                        linkedHashSet2.addAll(t04Var.j);
                                        linkedHashSet2.add(g4Var);
                                        Set setC0 = d70.C0(linkedHashSet2);
                                        Intent intent2 = t04Var.k;
                                        m04 m04Var7 = m04.c;
                                        t04Var = new t04(t04Var.a(), setC0, intent2, t04Var.l, t04Var.m, t04Var.b, t04Var.c, t04Var.d, t04Var.e, t04Var.f, t04Var.g);
                                        gb4.e(hashSet, t04Var);
                                    }
                                    next = xmlResourceParser.next();
                                    xml = xmlResourceParser;
                                    hashSet3 = hashSet;
                                }
                                z4Var = z4Var2;
                                z4Var2 = z4Var;
                                next = xmlResourceParser.next();
                                xml = xmlResourceParser;
                                hashSet3 = hashSet;
                                break;
                            case 520447504:
                                k04Var3 = k04Var10;
                                k04Var4 = k04Var11;
                                context2 = applicationContext3;
                                xmlResourceParser = xml;
                                hashSet = hashSet3;
                                i2 = depth;
                                if (name.equals("SplitPairRule")) {
                                    TypedArray typedArrayObtainStyledAttributes3 = context2.getTheme().obtainStyledAttributes(xmlResourceParser, pc3.e, 0, 0);
                                    String string3 = typedArrayObtainStyledAttributes3.getString(14);
                                    float f4 = typedArrayObtainStyledAttributes3.getFloat(13, 0.5f);
                                    int integer = typedArrayObtainStyledAttributes3.getInteger(11, 600);
                                    int integer2 = typedArrayObtainStyledAttributes3.getInteger(9, 600);
                                    int integer3 = typedArrayObtainStyledAttributes3.getInteger(10, 600);
                                    float f5 = typedArrayObtainStyledAttributes3.getFloat(8, v04.h.b);
                                    float f6 = typedArrayObtainStyledAttributes3.getFloat(7, v04.i.b);
                                    int i5 = typedArrayObtainStyledAttributes3.getInt(6, 0);
                                    int i6 = typedArrayObtainStyledAttributes3.getInt(2, 0);
                                    int i7 = typedArrayObtainStyledAttributes3.getInt(3, 1);
                                    boolean z2 = typedArrayObtainStyledAttributes3.getBoolean(1, false);
                                    int color2 = typedArrayObtainStyledAttributes3.getColor(0, 0);
                                    int i8 = typedArrayObtainStyledAttributes3.getInt(12, 0);
                                    int i9 = typedArrayObtainStyledAttributes3.getInt(5, 0);
                                    int i10 = typedArrayObtainStyledAttributes3.getInt(4, 0);
                                    typedArrayObtainStyledAttributes3.recycle();
                                    i = i2;
                                    w21 w21Var3 = new w21(Color.alpha(color2) != 255 ? t21Var : new s21(color2), vf2.o(i8), vf2.o(i9), vf2.o(i10));
                                    m04 m04VarH = m04.c;
                                    if (f4 != m04VarH.b) {
                                        m04VarH = xb5.H(f4);
                                    }
                                    if (i5 == 1) {
                                        f = f5;
                                        k04Var5 = k04Var4;
                                    } else if (i5 == 2) {
                                        f = f5;
                                        k04Var5 = k04Var3;
                                    } else if (i5 == 0) {
                                        f = f5;
                                        k04Var5 = k04Var7;
                                    } else if (i5 == 3) {
                                        f = f5;
                                        k04Var5 = k04Var2;
                                    } else {
                                        if (i5 != 4) {
                                            xe.k(dw2.A(i5, "Undefined value:"));
                                            return null;
                                        }
                                        f = f5;
                                        k04Var5 = k04Var;
                                    }
                                    s04 s04Var3 = new s04(set, new n04(m04VarH, k04Var5, w21Var3, ew0Var), string3, ye.t(i6), ye.t(i7), z2, integer, integer2, integer3, yr2.c(f), yr2.c(f6));
                                    gb4.e(hashSet, s04Var3);
                                    s04Var = s04Var3;
                                    z4Var2 = null;
                                    t04Var = null;
                                    next = xmlResourceParser.next();
                                    xml = xmlResourceParser;
                                    hashSet3 = hashSet;
                                }
                                z4Var = z4Var2;
                                i = i2;
                                z4Var2 = z4Var;
                                next = xmlResourceParser.next();
                                xml = xmlResourceParser;
                                hashSet3 = hashSet;
                                break;
                            case 1579230604:
                                k04Var3 = k04Var10;
                                k04Var4 = k04Var11;
                                context2 = applicationContext3;
                                xmlResourceParser = xml;
                                hashSet = hashSet3;
                                i2 = depth;
                                if (name.equals("SplitPairFilter")) {
                                    if (s04Var == null) {
                                        xe.k("Found orphaned SplitPairFilter outside of SplitPairRule");
                                        return null;
                                    }
                                    TypedArray typedArrayObtainStyledAttributes4 = context2.getTheme().obtainStyledAttributes(xmlResourceParser, pc3.d, 0, 0);
                                    String string4 = typedArrayObtainStyledAttributes4.getString(0);
                                    String string5 = typedArrayObtainStyledAttributes4.getString(2);
                                    String string6 = typedArrayObtainStyledAttributes4.getString(1);
                                    String packageName2 = context2.getApplicationContext().getPackageName();
                                    packageName2.getClass();
                                    r04 r04Var = new r04(gb4.n(packageName2, string4), gb4.n(packageName2, string5), string6);
                                    hashSet.remove(s04Var);
                                    LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                                    linkedHashSet3.addAll(s04Var.j);
                                    linkedHashSet3.add(r04Var);
                                    Set setC02 = d70.C0(linkedHashSet3);
                                    m04 m04Var8 = m04.c;
                                    s04 s04Var4 = new s04(setC02, s04Var.g, s04Var.a(), s04Var.k, s04Var.l, s04Var.m, s04Var.b, s04Var.c, s04Var.d, s04Var.e, s04Var.f);
                                    gb4.e(hashSet, s04Var4);
                                    s04Var = s04Var4;
                                    i = i2;
                                    next = xmlResourceParser.next();
                                    xml = xmlResourceParser;
                                    hashSet3 = hashSet;
                                }
                                z4Var = z4Var2;
                                i = i2;
                                z4Var2 = z4Var;
                                next = xmlResourceParser.next();
                                xml = xmlResourceParser;
                                hashSet3 = hashSet;
                                break;
                            case 1793077963:
                                k04Var3 = k04Var10;
                                k04Var4 = k04Var11;
                                context2 = applicationContext3;
                                xmlResourceParser = xml;
                                hashSet = hashSet3;
                                i2 = depth;
                                if (name.equals("ActivityRule")) {
                                    TypedArray typedArrayObtainStyledAttributes5 = context2.getTheme().obtainStyledAttributes(xmlResourceParser, pc3.b, 0, 0);
                                    String string7 = typedArrayObtainStyledAttributes5.getString(1);
                                    boolean z3 = typedArrayObtainStyledAttributes5.getBoolean(0, false);
                                    typedArrayObtainStyledAttributes5.recycle();
                                    if (string7 == null) {
                                        string7 = null;
                                    }
                                    z4Var2 = new z4(string7, set, z3);
                                    gb4.e(hashSet, z4Var2);
                                    i = i2;
                                    t04Var = null;
                                    s04Var = null;
                                    next = xmlResourceParser.next();
                                    xml = xmlResourceParser;
                                    hashSet3 = hashSet;
                                }
                                z4Var = z4Var2;
                                i = i2;
                                z4Var2 = z4Var;
                                next = xmlResourceParser.next();
                                xml = xmlResourceParser;
                                hashSet3 = hashSet;
                                break;
                            case 2050988213:
                                if (name.equals("SplitPlaceholderRule")) {
                                    TypedArray typedArrayObtainStyledAttributes6 = applicationContext3.getTheme().obtainStyledAttributes(xml, pc3.f, 0, 0);
                                    String string8 = typedArrayObtainStyledAttributes6.getString(14);
                                    String string9 = typedArrayObtainStyledAttributes6.getString(2);
                                    boolean z4 = typedArrayObtainStyledAttributes6.getBoolean(13, false);
                                    int i11 = typedArrayObtainStyledAttributes6.getInt(1, 1);
                                    if (i11 == 0) {
                                        xe.k("Never is not a valid configuration for Placeholder activities. Please use FINISH_ALWAYS or FINISH_ADJACENT instead or refer to the current API");
                                        return null;
                                    }
                                    float f7 = typedArrayObtainStyledAttributes6.getFloat(12, 0.5f);
                                    int integer4 = typedArrayObtainStyledAttributes6.getInteger(10, 600);
                                    int integer5 = typedArrayObtainStyledAttributes6.getInteger(8, 600);
                                    int integer6 = typedArrayObtainStyledAttributes6.getInteger(9, 600);
                                    float f8 = typedArrayObtainStyledAttributes6.getFloat(7, v04.h.b);
                                    float f9 = typedArrayObtainStyledAttributes6.getFloat(6, v04.i.b);
                                    int i12 = typedArrayObtainStyledAttributes6.getInt(5, 0);
                                    k04Var3 = k04Var10;
                                    int color3 = typedArrayObtainStyledAttributes6.getColor(0, 0);
                                    k04Var4 = k04Var11;
                                    int i13 = typedArrayObtainStyledAttributes6.getInt(11, 0);
                                    int i14 = typedArrayObtainStyledAttributes6.getInt(4, 0);
                                    int i15 = typedArrayObtainStyledAttributes6.getInt(3, 0);
                                    typedArrayObtainStyledAttributes6.recycle();
                                    context2 = applicationContext3;
                                    w21 w21Var4 = new w21(Color.alpha(color3) != 255 ? t21Var : new s21(color3), vf2.o(i13), vf2.o(i14), vf2.o(i15));
                                    m04 m04VarH2 = m04.c;
                                    if (f7 != m04VarH2.b) {
                                        m04VarH2 = xb5.H(f7);
                                    }
                                    if (i12 == 1) {
                                        k04Var6 = k04Var4;
                                    } else if (i12 == 2) {
                                        k04Var6 = k04Var3;
                                    } else if (i12 == 0) {
                                        k04Var6 = k04Var7;
                                    } else if (i12 == 3) {
                                        k04Var6 = k04Var2;
                                    } else {
                                        if (i12 != 4) {
                                            xe.k(dw2.A(i12, "Undefined value:"));
                                            return null;
                                        }
                                        k04Var6 = k04Var;
                                    }
                                    n04 n04Var5 = new n04(m04VarH2, k04Var6, w21Var4, ew0Var);
                                    String packageName3 = context2.getApplicationContext().getPackageName();
                                    packageName3.getClass();
                                    Intent component = new Intent().setComponent(gb4.n(packageName3, string9));
                                    component.getClass();
                                    x21 x21VarC = yr2.c(f8);
                                    x21 x21VarC2 = yr2.c(f9);
                                    u04 u04Var3 = u04.d;
                                    if (i11 == 0) {
                                        u04Var = u04Var3;
                                        xmlResourceParser2 = xml;
                                        xmlResourceParser = xmlResourceParser2;
                                        hashSet = hashSet3;
                                        Set set5 = set;
                                        t04 t04Var3 = new t04(string8, set5, component, z4, u04Var, integer4, integer5, integer6, x21VarC, x21VarC2, n04Var5);
                                        set = set5;
                                        gb4.e(hashSet, t04Var3);
                                        i = depth;
                                        t04Var = t04Var3;
                                        z4Var2 = null;
                                        s04Var = null;
                                        next = xmlResourceParser.next();
                                        xml = xmlResourceParser;
                                        hashSet3 = hashSet;
                                    } else if (i11 != 1) {
                                        u04Var3 = u04.f;
                                        if (i11 != 2) {
                                            xe.k(dw2.A(i11, "Unknown finish behavior:"));
                                            return null;
                                        }
                                        u04Var = u04Var3;
                                        xmlResourceParser2 = xml;
                                        xmlResourceParser = xmlResourceParser2;
                                        hashSet = hashSet3;
                                        Set set52 = set;
                                        t04 t04Var32 = new t04(string8, set52, component, z4, u04Var, integer4, integer5, integer6, x21VarC, x21VarC2, n04Var5);
                                        set = set52;
                                        gb4.e(hashSet, t04Var32);
                                        i = depth;
                                        t04Var = t04Var32;
                                        z4Var2 = null;
                                        s04Var = null;
                                        next = xmlResourceParser.next();
                                        xml = xmlResourceParser;
                                        hashSet3 = hashSet;
                                    } else {
                                        xmlResourceParser2 = xml;
                                        u04Var = u04Var2;
                                        xmlResourceParser = xmlResourceParser2;
                                        hashSet = hashSet3;
                                        Set set522 = set;
                                        t04 t04Var322 = new t04(string8, set522, component, z4, u04Var, integer4, integer5, integer6, x21VarC, x21VarC2, n04Var5);
                                        set = set522;
                                        gb4.e(hashSet, t04Var322);
                                        i = depth;
                                        t04Var = t04Var322;
                                        z4Var2 = null;
                                        s04Var = null;
                                        next = xmlResourceParser.next();
                                        xml = xmlResourceParser;
                                        hashSet3 = hashSet;
                                    }
                                    break;
                                }
                            default:
                                z4Var = z4Var2;
                                break;
                        }
                    } else {
                        z4Var = z4Var2;
                        k04Var = k04Var8;
                        k04Var2 = k04Var9;
                    }
                    k04Var3 = k04Var10;
                    k04Var4 = k04Var11;
                    context2 = applicationContext3;
                    xmlResourceParser = xml;
                    hashSet = hashSet3;
                    i = depth;
                    z4Var2 = z4Var;
                    next = xmlResourceParser.next();
                    xml = xmlResourceParser;
                    hashSet3 = hashSet;
                }
                k04Var8 = k04Var;
                k04Var9 = k04Var2;
                depth = i;
                k04Var10 = k04Var3;
                k04Var11 = k04Var4;
                applicationContext3 = context2;
            }
            hashSet2 = hashSet3;
        } catch (Resources.NotFoundException unused) {
        }
        if (hashSet2 != null) {
            set = hashSet2;
        }
        h91 h91Var3 = g91Var.a;
        eg0 eg0Var = h91Var3.d;
        ReentrantLock reentrantLock = h91.g;
        reentrantLock.lock();
        try {
            eg0Var.S(set);
            c31 c31Var = h91Var3.b;
            if (c31Var != null) {
                reentrantLock.lock();
                Set setC03 = d70.C0((me) eg0Var.f);
                reentrantLock.unlock();
                ((b31) c31Var).e(setC03);
            }
            return g91Var;
        } catch (Throwable th) {
            throw th;
        } finally {
        }
    }
}
