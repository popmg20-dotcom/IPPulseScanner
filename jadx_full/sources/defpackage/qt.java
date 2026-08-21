package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Xml;
import android.widget.ImageView;
import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketTimeoutException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qt implements ug4 {
    public static final e1 e = new e1(6);
    public static final qt f = new qt("$base", 1, "");
    public static final qt g = new qt("$self", 1, "");
    public final /* synthetic */ int a;
    public int b;
    public Object c;
    public Object d;

    public qt(byte b, int i) {
        this.a = i;
        switch (i) {
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                this.c = new pf1(0);
                this.d = new yn2();
                this.b = -1;
                return;
            case 10:
            default:
                this.c = new ArrayList();
                this.d = new ArrayList(64);
                this.b = 0;
                return;
            case 11:
                this.d = new ByteArrayOutputStream(4096);
                try {
                    Mac mac = Mac.getInstance("HmacSHA1");
                    this.c = mac;
                    this.b = mac.getMacLength();
                    return;
                } catch (NoSuchAlgorithmException e2) {
                    vp1.p(e2);
                    throw null;
                }
        }
    }

    public static qt b(qt qtVar, String str, xp1 xp1Var) {
        int i;
        int i2;
        int i3;
        am amVarC = xp1Var.j.c(str);
        v62 v62Var = new v62(23, (v62) qtVar.d, str, false);
        z44 z44VarB = ((bd4) xp1Var.h.X).b(v62Var);
        int i4 = qtVar.b;
        if (z44VarB != null) {
            i = z44VarB.a;
            int i5 = z44VarB.b;
            i3 = z44VarB.c;
            i2 = i5;
        } else {
            i = -1;
            i2 = 0;
            i3 = 0;
        }
        return new qt(qtVar, v62Var, co4.T(i4, amVarC.a, amVarC.b, i, i2, i3), 6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01f2, code lost:
    
        if (r12 == 1) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01f5, code lost:
    
        if (r12 == 2) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01f7, code lost:
    
        r17 = (int[]) r0.f;
        r18 = (float[]) r0.z;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0205, code lost:
    
        if (r13 == 1) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0207, code lost:
    
        if (r13 == 2) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0209, code lost:
    
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0214, code lost:
    
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0217, code lost:
    
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x021a, code lost:
    
        r12 = new android.graphics.LinearGradient(r22, r25, r26, r16, r17, r18, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x021e, code lost:
    
        r12 = new android.graphics.SweepGradient(r8, r10, (int[]) r0.f, (float[]) r0.z);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0230, code lost:
    
        if (r24 <= 0.0f) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0232, code lost:
    
        r21 = (int[]) r0.f;
        r22 = (float[]) r0.z;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0241, code lost:
    
        if (r13 == 1) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0244, code lost:
    
        if (r13 == 2) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0246, code lost:
    
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0251, code lost:
    
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0254, code lost:
    
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0257, code lost:
    
        r12 = new android.graphics.RadialGradient(r8, r10, r24, r21, r22, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0264, code lost:
    
        return new defpackage.qt(r12, (java.lang.Object) null, 0, 7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x026c, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d7, code lost:
    
        if (r11.size() <= 0) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d9, code lost:
    
        r0 = new defpackage.eg0(r11, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01df, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e0, code lost:
    
        if (r0 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01e4, code lost:
    
        if (r21 == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e6, code lost:
    
        r0 = new defpackage.eg0(r6, r5, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01ec, code lost:
    
        r0 = new defpackage.eg0(r6, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static qt e(Resources resources, int i, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        float f2;
        int i2;
        float f3;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.getClass();
        int i3 = 7;
        Object obj = null;
        if (!name.equals("gradient")) {
            if (name.equals("selector")) {
                ColorStateList colorStateListB = t70.b(resources, xml, attributeSetAsAttributeSet, theme);
                return new qt(obj, colorStateListB, colorStateListB.getDefaultColor(), i3);
            }
            throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
        String name2 = xml.getName();
        if (!name2.equals("gradient")) {
            throw new XmlPullParserException(xml.getPositionDescription() + ": invalid gradient color tag " + name2);
        }
        TypedArray typedArrayO = l72.O(resources, theme, attributeSetAsAttributeSet, yc3.e);
        float f4 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startX") != null ? typedArrayO.getFloat(8, 0.0f) : 0.0f;
        float f5 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startY") != null ? typedArrayO.getFloat(9, 0.0f) : 0.0f;
        float f6 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endX") != null ? typedArrayO.getFloat(10, 0.0f) : 0.0f;
        float f7 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endY") != null ? typedArrayO.getFloat(11, 0.0f) : 0.0f;
        float f8 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerX") != null ? typedArrayO.getFloat(3, 0.0f) : 0.0f;
        float f9 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerY") != null ? typedArrayO.getFloat(4, 0.0f) : 0.0f;
        int i4 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "type") != null ? typedArrayO.getInt(2, 0) : 0;
        int color = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startColor") != null ? typedArrayO.getColor(0, 0) : 0;
        boolean z = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor") != null;
        int color2 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor") != null ? typedArrayO.getColor(7, 0) : 0;
        int color3 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endColor") != null ? typedArrayO.getColor(1, 0) : 0;
        if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "tileMode") != null) {
            f2 = f4;
            i2 = typedArrayO.getInt(6, 0);
        } else {
            f2 = f4;
            i2 = 0;
        }
        float f10 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "gradientRadius") != null ? typedArrayO.getFloat(5, 0.0f) : 0.0f;
        typedArrayO.recycle();
        int depth = xml.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        float f11 = f10;
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next2 = xml.next();
            float f12 = f5;
            if (next2 == 1) {
                f3 = f6;
                break;
            }
            int depth2 = xml.getDepth();
            f3 = f6;
            if (depth2 < depth && next2 == 3) {
                break;
            }
            if (next2 == 2 && depth2 <= depth && xml.getName().equals("item")) {
                TypedArray typedArrayO2 = l72.O(resources, theme, attributeSetAsAttributeSet, yc3.f);
                boolean zHasValue = typedArrayO2.hasValue(0);
                boolean zHasValue2 = typedArrayO2.hasValue(1);
                if (!zHasValue || !zHasValue2) {
                    break;
                }
                int color4 = typedArrayO2.getColor(0, 0);
                float f13 = typedArrayO2.getFloat(1, 0.0f);
                typedArrayO2.recycle();
                arrayList2.add(Integer.valueOf(color4));
                arrayList.add(Float.valueOf(f13));
            }
            f5 = f12;
            f6 = f3;
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
    }

    @Override // defpackage.ug4
    public void a() {
        ty1 ty1Var = (ty1) this.c;
        Drawable drawable = ty1Var.f.getDrawable();
        sy1 sy1Var = (sy1) this.d;
        Drawable drawableA = sy1Var.a();
        sp3 sp3Var = sy1Var.b().t;
        int i = this.b;
        boolean z = sy1Var instanceof l54;
        fg0 fg0Var = new fg0(drawable, drawableA, sp3Var, i, (z && ((l54) sy1Var).g) ? false : true);
        if (z) {
            ty1Var.b(fg0Var);
        } else if (sy1Var instanceof w51) {
            ty1Var.b(fg0Var);
        } else {
            g.d();
        }
    }

    public void c() {
        cb0 cb0Var;
        ImageView imageView = (ImageView) this.c;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            tx0.a(drawable);
        }
        if (drawable == null || (cb0Var = (cb0) this.d) == null) {
            return;
        }
        int[] drawableState = imageView.getDrawableState();
        PorterDuff.Mode mode = db.b;
        ck3.o(drawable, cb0Var, drawableState);
    }

    public gi3 d() {
        fz1 fz1Var = (fz1) this.d;
        if (fz1Var != null) {
            throw fz1Var.a();
        }
        gi3 gi3VarA = gi3.a(this.b, (Object[]) this.c, this);
        fz1 fz1Var2 = (fz1) this.d;
        if (fz1Var2 == null) {
            return gi3VarA;
        }
        throw fz1Var2.a();
    }

    public boolean equals(Object obj) {
        switch (this.a) {
            case 4:
                int i = this.b;
                if (obj != this) {
                    if (!n50.n(obj, (Class) this.c) || Array.getLength(obj) != i) {
                        return false;
                    }
                    for (int i2 = 0; i2 < i; i2++) {
                        Object obj2 = Array.get(this.d, i2);
                        Object obj3 = Array.get(obj, i2);
                        if (obj2 != obj3 && obj2 != null && !obj2.equals(obj3)) {
                            return false;
                        }
                    }
                }
                return true;
            default:
                return super.equals(obj);
        }
    }

    public y44 f(DatagramSocket datagramSocket, InetAddress inetAddress, int i, boolean z, boolean z2, String str) throws IOException {
        byte[] bArr;
        char c;
        y44 y44Var;
        int i2;
        byte[] bArr2;
        DatagramPacket datagramPacket;
        cd cdVar = (cd) this.d;
        char c2 = 1;
        if (z || z2) {
            bArr = new byte[28];
            bArr[0] = 0;
            bArr[1] = 1;
            bArr[2] = 0;
            bArr[3] = 8;
            bArr[4] = 33;
            bArr[5] = 18;
            bArr[6] = -92;
            bArr[7] = 66;
            id3.b.a(bArr);
            bArr[20] = 0;
            bArr[21] = 3;
            bArr[22] = 0;
            bArr[23] = 4;
            bArr[24] = 0;
            bArr[25] = 0;
            bArr[26] = 0;
            bArr[27] = (byte) ((z ? 4 : 0) | (z2 ? 2 : 0));
        } else {
            bArr = new byte[20];
            bArr[0] = 0;
            bArr[1] = 1;
            bArr[2] = 0;
            bArr[3] = 0;
            bArr[4] = 33;
            bArr[5] = 18;
            bArr[6] = -92;
            bArr[7] = 66;
            id3.b.a(bArr);
        }
        byte[] bArrH0 = qe.h0(8, 20, bArr);
        boolean z3 = z || z2;
        int i3 = 300;
        int i4 = 0;
        while (i4 < 7900) {
            try {
                y44Var = null;
                try {
                    datagramSocket.connect(new InetSocketAddress(inetAddress, i));
                    datagramSocket.setSoTimeout(i3);
                    c = c2;
                    try {
                        datagramSocket.send(new DatagramPacket(bArr, bArr.length));
                        cdVar.k(str, "Binding Request sent.");
                        if (z3) {
                            datagramSocket.disconnect();
                        }
                        i2 = 1500;
                        bArr2 = new byte[1500];
                    } catch (SocketTimeoutException unused) {
                        i4 += i3;
                        if (i4 >= 7900) {
                            cdVar.k(str, "Socket timeout while receiving the response. Maximum retry limit exceeded. Give up.");
                            return y44Var;
                        }
                        cdVar.k(str, "Socket timeout while receiving the response.");
                        i3 = i4 * 2;
                        if (i3 > 1600) {
                            i3 = 1600;
                        }
                    }
                } catch (SocketTimeoutException unused2) {
                    c = c2;
                }
            } catch (SocketTimeoutException unused3) {
                c = c2;
                y44Var = null;
            }
            while (true) {
                datagramPacket = new DatagramPacket(bArr2, i2);
                datagramSocket.receive(datagramPacket);
                if (datagramPacket.getLength() >= 20) {
                    int i5 = (bArr2[c] & 255) | ((bArr2[0] & 255) << 8);
                    if ((i5 == 257 || i5 == 273) && Arrays.equals(qe.h0(8, 20, bArr2), bArrH0)) {
                        break;
                    }
                    c2 = c;
                }
                i2 = 1500;
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr2, datagramPacket.getLength());
            y44 y44VarR = l72.R(bArrCopyOf, bArrCopyOf.length, bArrH0);
            if (y44VarR != null) {
                if (y44VarR.c == null) {
                    return y44VarR;
                }
                cdVar.k(str, "Message header contains an ErrorCode message attribute.");
                return null;
            }
            i4 += i3;
            i3 = i4 * 2;
            if (i3 > 1600) {
                i3 = 1600;
            }
            c2 = c;
        }
        return null;
    }

    public void g(int i) {
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) this.d;
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length - i;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 16;
            ((Mac) this.c).update(byteArray, i2, i3 <= length ? 16 : length - i2);
            i2 = i3;
        }
        byteArrayOutputStream.reset();
    }

    public void h(int i) {
        int i2 = i * 2;
        Object[] objArr = (Object[]) this.c;
        if (i2 > objArr.length) {
            int length = objArr.length;
            if (i2 < 0) {
                xe.k("cannot store more than Integer.MAX_VALUE elements");
                return;
            }
            if (i2 > length) {
                length = length + (length >> 1) + 1;
                if (length < i2) {
                    length = Integer.highestOneBit(i2 - 1) << 1;
                }
                if (length < 0) {
                    length = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                }
            }
            this.c = Arrays.copyOf(objArr, length);
        }
    }

    public synchronized byte[] i(int i) {
        for (int i2 = 0; i2 < ((ArrayList) this.d).size(); i2++) {
            byte[] bArr = (byte[]) ((ArrayList) this.d).get(i2);
            if (bArr.length >= i) {
                this.b -= bArr.length;
                ((ArrayList) this.d).remove(i2);
                ((ArrayList) this.c).remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Serializable j(ie0 ie0Var) {
        nf1 nf1Var;
        yn2 yn2Var;
        if (ie0Var instanceof nf1) {
            nf1Var = (nf1) ie0Var;
            int i = nf1Var.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                nf1Var.Z = i - Integer.MIN_VALUE;
            } else {
                nf1Var = new nf1(this, ie0Var);
            }
        }
        Object obj = nf1Var.X;
        int i2 = nf1Var.Z;
        if (i2 == 0) {
            n12.S(obj);
            yn2 yn2Var2 = (yn2) this.d;
            nf1Var.A = yn2Var2;
            nf1Var.Z = 1;
            Object objG = yn2Var2.g(nf1Var);
            mf0 mf0Var = mf0.b;
            if (objG == mf0Var) {
                return mf0Var;
            }
            yn2Var = yn2Var2;
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            yn2Var = nf1Var.A;
            n12.S(obj);
        }
        try {
            List listG = ((pf1) this.c).g();
            int size = (this.b - listG.size()) + 1;
            ArrayList arrayList = new ArrayList(f70.Q(10, listG));
            int i3 = 0;
            for (Object obj2 : listG) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    e70.P();
                    throw null;
                }
                arrayList.add(new tz1(i3 + size, (jy2) obj2));
                i3 = i4;
            }
            yn2Var.n(null);
            return arrayList;
        } catch (Throwable th) {
            yn2Var.n(null);
            throw th;
        }
    }

    public void k(byte[] bArr) {
        try {
            ((Mac) this.c).init(new SecretKeySpec(bArr, "HmacSHA1"));
        } catch (InvalidKeyException e2) {
            vp1.p(e2);
        }
    }

    public boolean l() {
        return !(((jf) this.c).A != ((bc4) this.d).d || ((jf) this.c).f || ((jf) this.c).isInterrupted());
    }

    public boolean m() {
        ColorStateList colorStateList;
        return ((Shader) this.c) == null && (colorStateList = (ColorStateList) this.d) != null && colorStateList.isStateful();
    }

    public void n(AttributeSet attributeSet, int i) {
        int resourceId;
        ImageView imageView = (ImageView) this.c;
        Context context = imageView.getContext();
        int[] iArr = cd3.f;
        n02 n02VarY = n02.y(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) n02VarY.z;
        wp4.m(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) n02VarY.z, i);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = vo.r(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                tx0.a(drawable);
            }
            if (typedArray.hasValue(2)) {
                imageView.setImageTintList(n02VarY.n(2));
            }
            if (typedArray.hasValue(3)) {
                imageView.setImageTintMode(tx0.c(typedArray.getInt(3, -1), null));
            }
            n02VarY.K();
        } catch (Throwable th) {
            n02VarY.K();
            throw th;
        }
    }

    public qt o(String str, xp1 xp1Var) {
        if (str == null) {
            return this;
        }
        if (str.indexOf(32) == -1) {
            return b(this, str, xp1Var);
        }
        for (String str2 : m44.b(str)) {
            this = b(this, str2, xp1Var);
        }
        return this;
    }

    public void p(Object obj, Object obj2) {
        h(this.b + 1);
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 == null) {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
        Object[] objArr = (Object[]) this.c;
        int i = this.b;
        int i2 = i * 2;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.b = i + 1;
    }

    public void q(Collection collection) {
        if (ha0.w(collection)) {
            h(collection.size() + this.b);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            p(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object r(tz1 tz1Var, ie0 ie0Var) {
        of1 of1Var;
        yn2 yn2Var;
        if (ie0Var instanceof of1) {
            of1Var = (of1) ie0Var;
            int i = of1Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                of1Var.y0 = i - Integer.MIN_VALUE;
            } else {
                of1Var = new of1(this, ie0Var);
            }
        }
        Object obj = of1Var.Y;
        int i2 = of1Var.y0;
        if (i2 == 0) {
            n12.S(obj);
            yn2Var = (yn2) this.d;
            of1Var.A = tz1Var;
            of1Var.X = yn2Var;
            of1Var.y0 = 1;
            Object objG = yn2Var.g(of1Var);
            mf0 mf0Var = mf0.b;
            if (objG == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            yn2 yn2Var2 = of1Var.X;
            tz1 tz1Var2 = of1Var.A;
            n12.S(obj);
            yn2Var = yn2Var2;
            tz1Var = tz1Var2;
        }
        try {
            this.b = tz1Var.a;
            ((pf1) this.c).a((jy2) tz1Var.b);
            yn2Var.n(null);
            return xl4.a;
        } catch (Throwable th) {
            yn2Var.n(null);
            throw th;
        }
    }

    public synchronized void s(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= 4096) {
                ((ArrayList) this.c).add(bArr);
                int iBinarySearch = Collections.binarySearch((ArrayList) this.d, bArr, e);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                ((ArrayList) this.d).add(iBinarySearch, bArr);
                this.b += bArr.length;
                v();
            }
        }
    }

    public void t(int i) {
        ImageView imageView = (ImageView) this.c;
        if (i != 0) {
            Drawable drawableR = vo.r(imageView.getContext(), i);
            if (drawableR != null) {
                tx0.a(drawableR);
            }
            imageView.setImageDrawable(drawableR);
        } else {
            imageView.setImageDrawable(null);
        }
        c();
    }

    public String toString() {
        switch (this.a) {
            case 6:
                ArrayList arrayListB = ((v62) this.d).B();
                StringBuilder sb = new StringBuilder();
                Iterator it = arrayListB.iterator();
                if (it.hasNext()) {
                    while (true) {
                        sb.append((CharSequence) it.next());
                        if (it.hasNext()) {
                            sb.append((CharSequence) " ");
                        }
                    }
                }
                return sb.toString();
            case 13:
                StringBuilder sb2 = new StringBuilder();
                if (((ba3) this.c) == ba3.HTTP_1_0) {
                    sb2.append("HTTP/1.0");
                } else {
                    sb2.append("HTTP/1.1");
                }
                sb2.append(' ');
                sb2.append(this.b);
                sb2.append(' ');
                sb2.append((String) this.d);
                return sb2.toString();
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                StringBuilder sb3 = new StringBuilder();
                if (this.b > 0) {
                    for (int i = 0; i < this.b; i++) {
                        sb3.append("offset + ");
                        sb3.append(((int[]) this.d)[i]);
                        sb3.append(" target: ");
                        sb3.append(((m41[]) this.c)[i].getAddressName());
                    }
                }
                return sb3.toString();
            default:
                return super.toString();
        }
    }

    public vo2 u() throws IOException {
        Object obj;
        InetAddress inetAddress;
        InetSocketAddress inetSocketAddress;
        qt qtVar = this;
        cd cdVar = (cd) qtVar.d;
        String str = (String) qtVar.c;
        InetAddress[] allByName = InetAddress.getAllByName(str);
        allByName.getClass();
        int length = allByName.length;
        int i = 0;
        while (true) {
            obj = null;
            if (i >= length) {
                inetAddress = null;
                break;
            }
            InetAddress inetAddress2 = allByName[i];
            if (inetAddress2 instanceof Inet4Address) {
                inetAddress = inetAddress2;
                break;
            }
            i++;
        }
        if (inetAddress == null) {
            cdVar.k("ERROR", "Cannot resolve IPv4 address for " + str);
            return null;
        }
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces == null) {
            return null;
        }
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
            String name = networkInterfaceNextElement.getName();
            Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddressNextElement = inetAddresses.nextElement();
                if (inetAddressNextElement instanceof Inet4Address) {
                    Inet4Address inet4Address = (Inet4Address) inetAddressNextElement;
                    if (!inet4Address.isLoopbackAddress() && !inet4Address.isLinkLocalAddress()) {
                        DatagramSocket datagramSocket = new DatagramSocket(0, inetAddressNextElement);
                        try {
                            int localPort = datagramSocket.getLocalPort();
                            cdVar.k("Local address", ((Inet4Address) inetAddressNextElement).getHostAddress() + ":" + localPort);
                            cdVar.k(obj, "------------------");
                            y44 y44VarF = qtVar.f(datagramSocket, inetAddress, qtVar.b, false, false, "PUBLIC IP");
                            wo2 wo2Var = wo2.b;
                            if (y44VarF == null) {
                                cdVar.k(obj, "------------------");
                                vo2 vo2Var = new vo2(wo2Var, (Inet4Address) inetAddressNextElement, name, null, 0, null);
                                datagramSocket.close();
                                return vo2Var;
                            }
                            Integer num = y44VarF.c;
                            if (num != null) {
                                cdVar.k("PUBLIC IP", "Server returned error: " + y44VarF.d + " (code " + num + ")");
                                cdVar.k(obj, "------------------");
                                vo2 vo2Var2 = new vo2(wo2Var, (Inet4Address) inetAddressNextElement, name, null, num.intValue(), y44VarF.d);
                                datagramSocket.close();
                                return vo2Var2;
                            }
                            InetSocketAddress inetSocketAddress2 = y44VarF.a;
                            if (inetSocketAddress2 == null) {
                                cdVar.k("PUBLIC IP", "Response does not contain a Mapped or Xor-Mapped Address attribute.");
                                cdVar.k(obj, "------------------");
                                vo2 vo2Var3 = new vo2(wo2Var, (Inet4Address) inetAddressNextElement, name, null, 700, "The server is sending an incomplete response (Mapped Address and Changed Address message attributes are missing). The client should not retry.");
                                datagramSocket.close();
                                return vo2Var3;
                            }
                            InetSocketAddress inetSocketAddress3 = y44VarF.b;
                            boolean z = (inetSocketAddress2.getPort() == localPort && inetSocketAddress2.getAddress().equals(inetAddressNextElement)) ? false : true;
                            cdVar.k("Mapped address", inetSocketAddress2.getAddress().getHostAddress() + ":" + inetSocketAddress2.getPort());
                            if (inetSocketAddress3 != null) {
                                cdVar.k("Other address", inetSocketAddress3.getAddress().getHostAddress() + ":" + inetSocketAddress3.getPort());
                            }
                            if (z) {
                                cdVar.k("PUBLIC IP", "Node is natted.");
                            } else {
                                cdVar.k("PUBLIC IP", "Node is not natted");
                            }
                            cdVar.k(null, "------------------");
                            int i2 = qtVar.b;
                            if (!z) {
                                y44 y44VarF2 = qtVar.f(datagramSocket, inetAddress, i2, true, true, "FULL CONE NAT");
                                cdVar.k(null, "------------------");
                                vo2 vo2Var4 = y44VarF2 != null ? new vo2(wo2.f, (Inet4Address) inetAddressNextElement, name, inetSocketAddress2, 0, null) : new vo2(wo2.Z, (Inet4Address) inetAddressNextElement, name, inetSocketAddress2, 0, null);
                                datagramSocket.close();
                                return vo2Var4;
                            }
                            InetAddress inetAddress3 = inetAddress;
                            if (f(datagramSocket, inetAddress, i2, true, true, "FULL CONE NAT") != null) {
                                cdVar.k(null, "------------------");
                                vo2 vo2Var5 = new vo2(wo2.z, (Inet4Address) inetAddressNextElement, name, inetSocketAddress2, 0, null);
                                datagramSocket.close();
                                return vo2Var5;
                            }
                            cdVar.k(null, "------------------");
                            wo2 wo2Var2 = wo2.y0;
                            if (inetSocketAddress3 == null) {
                                cdVar.k(null, "------------------");
                                vo2 vo2Var6 = new vo2(wo2Var2, (Inet4Address) inetAddressNextElement, name, inetSocketAddress2, 0, null);
                                datagramSocket.close();
                                return vo2Var6;
                            }
                            InetAddress address = inetSocketAddress3.getAddress();
                            address.getClass();
                            y44 y44VarF3 = f(datagramSocket, address, inetSocketAddress3.getPort(), false, false, "SYMMETRIC NAT");
                            if (y44VarF3 == null || (inetSocketAddress = y44VarF3.a) == null) {
                                cdVar.k(null, "------------------");
                                vo2 vo2Var7 = new vo2(wo2Var2, (Inet4Address) inetAddressNextElement, name, inetSocketAddress2, 0, null);
                                datagramSocket.close();
                                return vo2Var7;
                            }
                            cdVar.k("Mapped address", inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort());
                            if (inetSocketAddress.getPort() == inetSocketAddress2.getPort() && inetSocketAddress.getAddress().equals(inetSocketAddress2.getAddress())) {
                                cdVar.k("SYMMETRIC NAT", "Node is not behind a symmetric NAT.");
                                cdVar.k(null, "------------------");
                                y44 y44VarF4 = f(datagramSocket, inetAddress3, this.b, false, true, "RESTRICTED CONE NAT");
                                cdVar.k(null, "------------------");
                                vo2 vo2Var8 = y44VarF4 != null ? new vo2(wo2.A, (Inet4Address) inetAddressNextElement, name, inetSocketAddress2, 0, null) : new vo2(wo2.X, (Inet4Address) inetAddressNextElement, name, inetSocketAddress2, 0, null);
                                datagramSocket.close();
                                return vo2Var8;
                            }
                            cdVar.k("SYMMETRIC NAT", "Node is behind a symmetric NAT.");
                            cdVar.k(null, "------------------");
                            vo2 vo2Var9 = new vo2(wo2.Y, (Inet4Address) inetAddressNextElement, name, inetSocketAddress2, 0, null);
                            datagramSocket.close();
                            return vo2Var9;
                        } finally {
                        }
                    }
                }
                qtVar = this;
                obj = null;
            }
            qtVar = this;
        }
        cdVar.k("LOCAL IP", "Cannot find available local address");
        return null;
    }

    public synchronized void v() {
        while (this.b > 4096) {
            byte[] bArr = (byte[]) ((ArrayList) this.c).remove(0);
            ((ArrayList) this.d).remove(bArr);
            this.b -= bArr.length;
        }
    }

    public void w(byte[] bArr, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) this.d;
        try {
            if (byteArrayOutputStream.size() + i2 > 4096) {
                g(0);
            }
            byteArrayOutputStream.write(bArr, i, i2);
        } catch (IllegalStateException e2) {
            vp1.p(e2);
        }
    }

    public /* synthetic */ qt(int i, int i2, Serializable serializable, Object obj) {
        this.a = i2;
        this.c = serializable;
        this.b = i;
        this.d = obj;
    }

    public /* synthetic */ qt(Object obj, Object obj2, int i, int i2) {
        this.a = i2;
        this.c = obj;
        this.d = obj2;
        this.b = i;
    }

    public qt(ty1 ty1Var, sy1 sy1Var, int i) {
        this.a = 8;
        this.c = ty1Var;
        this.d = sy1Var;
        this.b = i;
        if (i > 0) {
            return;
        }
        xe.k("durationMillis must be > 0.");
        throw null;
    }

    public qt(cn cnVar, ArrayList arrayList, int i) {
        this.a = 12;
        this.d = cnVar;
        this.c = arrayList;
        this.b = i;
    }

    public qt(Context context, int i) {
        this.a = 3;
        this.d = new ConcurrentLinkedQueue();
        this.b = i;
        this.c = context;
    }

    public qt(ImageView imageView) {
        this.a = 2;
        this.b = 0;
        this.c = imageView;
    }

    public qt(String str, int i, cd cdVar) {
        this.a = 14;
        str.getClass();
        this.c = str;
        this.b = i;
        this.d = cdVar;
    }

    public qt(String str, int i, String str2) {
        this.a = 1;
        this.b = i;
        this.c = str;
        this.d = str2;
    }

    public /* synthetic */ qt(char c, int i) {
        this.a = i;
    }

    public qt(bc4 bc4Var, jf jfVar) {
        this.a = 5;
        this.d = bc4Var;
        this.c = jfVar;
    }

    public qt(int i) {
        this.a = 10;
        this.c = new Object[i * 2];
        this.b = 0;
    }
}
