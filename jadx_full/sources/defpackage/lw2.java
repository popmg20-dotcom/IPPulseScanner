package defpackage;

import android.app.Notification;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a1;
import io.sentry.android.core.cache.a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class lw2 {
    public static final short[] f = {5, 1, 1, 1, 1, 1, 1, 1, 1, 10, 10, 1, 1, 10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 12, 4, 7, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 6, 5, 5, 5, 5, 6, 6, 6, 6, 7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5, 5, 5, 5, 1};
    public final /* synthetic */ int a;
    public int b;
    public Object c;
    public Object d;
    public Object e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0277  */
    /* JADX WARN: Type inference failed for: r17v1, types: [android.graphics.Bitmap, java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public lw2(us2 us2Var) {
        Notification.Builder builderC;
        ArrayList arrayList;
        int i;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        Notification notification;
        Iterator it;
        char c;
        Icon iconCreateWithBitmap;
        String strM;
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        int i2;
        this.a = 4;
        this.e = new Bundle();
        this.d = us2Var;
        Context context = us2Var.a;
        ArrayList arrayList5 = us2Var.u;
        ArrayList arrayList6 = us2Var.c;
        ArrayList arrayList7 = us2Var.d;
        int i3 = 26;
        if (Build.VERSION.SDK_INT >= 26) {
            builderC = v02.c(context, us2Var.q);
            this.c = builderC;
        } else {
            Notification.Builder builder = new Notification.Builder(context);
            this.c = builder;
            builderC = builder;
        }
        Notification notification2 = us2Var.s;
        Object obj = null;
        int i4 = 0;
        builderC.setWhen(notification2.when).setSmallIcon(notification2.icon, notification2.iconLevel).setContent(notification2.contentView).setTicker(notification2.tickerText, null).setVibrate(notification2.vibrate).setLights(notification2.ledARGB, notification2.ledOnMS, notification2.ledOffMS).setOngoing((notification2.flags & 2) != 0).setOnlyAlertOnce((notification2.flags & 8) != 0).setAutoCancel((notification2.flags & 16) != 0).setDefaults(notification2.defaults).setContentTitle(us2Var.e).setContentText(us2Var.f).setContentInfo(null).setContentIntent(us2Var.g).setDeleteIntent(notification2.deleteIntent).setFullScreenIntent(null, (notification2.flags & 128) != 0).setNumber(0).setProgress(0, 0, false);
        builderC.setLargeIcon((Icon) null);
        builderC.setSubText(us2Var.l).setUsesChronometer(us2Var.j).setPriority(us2Var.h);
        Iterator it2 = us2Var.b.iterator();
        while (it2.hasNext()) {
            ts2 ts2Var = (ts2) it2.next();
            IconCompat iconCompatA = ts2Var.b;
            int i5 = i4;
            if (iconCompatA == null && (i2 = ts2Var.e) != 0) {
                iconCompatA = IconCompat.a(i2);
                ts2Var.b = iconCompatA;
            }
            IconCompat iconCompat = iconCompatA;
            boolean z = ts2Var.c;
            Bundle bundle = ts2Var.a;
            if (iconCompat != null) {
                ?? r17 = obj;
                int i6 = iconCompat.a;
                switch (i6) {
                    case -1:
                        arrayList2 = arrayList5;
                        arrayList3 = arrayList6;
                        arrayList4 = arrayList7;
                        notification = notification2;
                        it = it2;
                        c = 2;
                        iconCreateWithBitmap = (Icon) iconCompat.b;
                        break;
                    case 0:
                    default:
                        xe.k("Unknown type");
                        throw r17;
                    case 1:
                        arrayList2 = arrayList5;
                        arrayList3 = arrayList6;
                        arrayList4 = arrayList7;
                        notification = notification2;
                        it = it2;
                        c = 2;
                        iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.b);
                        colorStateList = iconCompat.g;
                        if (colorStateList != null) {
                            iconCreateWithBitmap.setTintList(colorStateList);
                        }
                        mode = iconCompat.h;
                        if (mode != IconCompat.k) {
                            iconCreateWithBitmap.setTintMode(mode);
                        }
                        break;
                    case 2:
                        arrayList2 = arrayList5;
                        arrayList3 = arrayList6;
                        arrayList4 = arrayList7;
                        notification = notification2;
                        it = it2;
                        if (i6 == -1) {
                            Object obj2 = iconCompat.b;
                            if (Build.VERSION.SDK_INT >= 28) {
                                strM = u9.m(obj2);
                            } else {
                                try {
                                    strM = (String) obj2.getClass().getMethod("getResPackage", null).invoke(obj2, null);
                                } catch (IllegalAccessException e) {
                                    a1.e("IconCompat", "Unable to get icon package", e);
                                    strM = null;
                                } catch (NoSuchMethodException e2) {
                                    a1.e("IconCompat", "Unable to get icon package", e2);
                                    strM = null;
                                } catch (InvocationTargetException e3) {
                                    a1.e("IconCompat", "Unable to get icon package", e3);
                                    strM = null;
                                }
                            }
                            c = 2;
                        } else {
                            c = 2;
                            if (i6 != 2) {
                                s53.j(iconCompat, "called getResPackage() on ");
                                throw null;
                            }
                            String str = iconCompat.j;
                            strM = (str == null || TextUtils.isEmpty(str)) ? ((String) iconCompat.b).split(":", -1)[i5] : iconCompat.j;
                        }
                        iconCreateWithBitmap = Icon.createWithResource(strM, iconCompat.e);
                        colorStateList = iconCompat.g;
                        if (colorStateList != null) {
                        }
                        mode = iconCompat.h;
                        if (mode != IconCompat.k) {
                        }
                        break;
                    case 3:
                        arrayList2 = arrayList5;
                        arrayList3 = arrayList6;
                        arrayList4 = arrayList7;
                        notification = notification2;
                        it = it2;
                        iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.b, iconCompat.e, iconCompat.f);
                        c = 2;
                        colorStateList = iconCompat.g;
                        if (colorStateList != null) {
                        }
                        mode = iconCompat.h;
                        if (mode != IconCompat.k) {
                        }
                        break;
                    case 4:
                        arrayList2 = arrayList5;
                        arrayList3 = arrayList6;
                        arrayList4 = arrayList7;
                        notification = notification2;
                        it = it2;
                        iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.b);
                        c = 2;
                        colorStateList = iconCompat.g;
                        if (colorStateList != null) {
                        }
                        mode = iconCompat.h;
                        if (mode != IconCompat.k) {
                        }
                        break;
                    case 5:
                        int i7 = Build.VERSION.SDK_INT;
                        Object obj3 = iconCompat.b;
                        if (i7 >= i3) {
                            iconCreateWithBitmap = v02.e((Bitmap) obj3);
                            arrayList2 = arrayList5;
                            arrayList3 = arrayList6;
                            arrayList4 = arrayList7;
                            notification = notification2;
                            it = it2;
                            c = 2;
                            colorStateList = iconCompat.g;
                            if (colorStateList != null) {
                            }
                            mode = iconCompat.h;
                            if (mode != IconCompat.k) {
                            }
                        } else {
                            int iMin = (int) (Math.min(r10.getWidth(), r10.getHeight()) * 0.6666667f);
                            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
                            arrayList3 = arrayList6;
                            Canvas canvas = new Canvas(bitmapCreateBitmap);
                            it = it2;
                            Paint paint = new Paint(3);
                            float f2 = iMin * 0.5f;
                            arrayList4 = arrayList7;
                            paint.setColor(-16777216);
                            arrayList2 = arrayList5;
                            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                            BitmapShader bitmapShader = new BitmapShader((Bitmap) obj3, tileMode, tileMode);
                            Matrix matrix = new Matrix();
                            notification = notification2;
                            matrix.setTranslate((-(r10.getWidth() - iMin)) / 2.0f, (-(r10.getHeight() - iMin)) / 2.0f);
                            bitmapShader.setLocalMatrix(matrix);
                            paint.setShader(bitmapShader);
                            canvas.drawCircle(f2, f2, f2 * 0.9166667f, paint);
                            canvas.setBitmap(r17);
                            iconCreateWithBitmap = Icon.createWithBitmap(bitmapCreateBitmap);
                            c = 2;
                            colorStateList = iconCompat.g;
                            if (colorStateList != null) {
                            }
                            mode = iconCompat.h;
                            if (mode != IconCompat.k) {
                            }
                        }
                        break;
                    case 6:
                        if (Build.VERSION.SDK_INT < 30) {
                            a.c(iconCompat.c(), "Context is required to resolve the file uri of the icon: ");
                            throw r17;
                        }
                        iconCreateWithBitmap = j2.c(iconCompat.c());
                        arrayList2 = arrayList5;
                        arrayList3 = arrayList6;
                        arrayList4 = arrayList7;
                        notification = notification2;
                        it = it2;
                        c = 2;
                        colorStateList = iconCompat.g;
                        if (colorStateList != null) {
                        }
                        mode = iconCompat.h;
                        if (mode != IconCompat.k) {
                        }
                        break;
                }
            } else {
                arrayList2 = arrayList5;
                arrayList3 = arrayList6;
                arrayList4 = arrayList7;
                notification = notification2;
                it = it2;
                c = 2;
                iconCreateWithBitmap = null;
            }
            Notification.Action.Builder builder2 = new Notification.Action.Builder(iconCreateWithBitmap, ts2Var.f, ts2Var.g);
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putBoolean("android.support.allowGeneratedReplies", z);
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 24) {
                ga5.B(builder2, z);
            }
            bundle2.putInt("android.support.action.semanticAction", i5);
            if (i8 >= 28) {
                u9.E(builder2);
            }
            if (i8 >= 29) {
                v9.u(builder2);
            }
            if (i8 >= 31) {
                ut0.g(builder2);
            }
            bundle2.putBoolean("android.support.action.showsUserInterface", ts2Var.d);
            builder2.addExtras(bundle2);
            ((Notification.Builder) this.c).addAction(builder2.build());
            arrayList6 = arrayList3;
            it2 = it;
            arrayList7 = arrayList4;
            arrayList5 = arrayList2;
            notification2 = notification;
            i3 = 26;
            obj = null;
            i4 = 0;
        }
        ArrayList arrayList8 = arrayList5;
        ArrayList arrayList9 = arrayList6;
        ArrayList arrayList10 = arrayList7;
        Notification notification3 = notification2;
        Bundle bundle3 = us2Var.o;
        if (bundle3 != null) {
            ((Bundle) this.e).putAll(bundle3);
        }
        ((Notification.Builder) this.c).setShowWhen(us2Var.i);
        ((Notification.Builder) this.c).setLocalOnly(us2Var.m);
        ((Notification.Builder) this.c).setGroup(null);
        ((Notification.Builder) this.c).setSortKey(null);
        ((Notification.Builder) this.c).setGroupSummary(false);
        this.b = 0;
        ((Notification.Builder) this.c).setCategory(us2Var.n);
        ((Notification.Builder) this.c).setColor(0);
        ((Notification.Builder) this.c).setVisibility(us2Var.p);
        ((Notification.Builder) this.c).setPublicVersion(null);
        ((Notification.Builder) this.c).setSound(notification3.sound, notification3.audioAttributes);
        if (Build.VERSION.SDK_INT < 28) {
            if (arrayList9 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList9.size());
                Iterator it3 = arrayList9.iterator();
                if (it3.hasNext()) {
                    throw dw2.z(it3);
                }
            }
            if (arrayList == null) {
                arrayList = arrayList8;
            } else if (arrayList8 != null) {
                me meVar = new me(arrayList8.size() + arrayList.size());
                meVar.addAll(arrayList);
                meVar.addAll(arrayList8);
                arrayList = new ArrayList(meVar);
            }
        } else {
            arrayList = arrayList8;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                ((Notification.Builder) this.c).addPerson((String) it4.next());
            }
        }
        if (arrayList10.size() > 0) {
            Bundle bundle4 = us2Var.o;
            if (bundle4 == null) {
                bundle4 = new Bundle();
                us2Var.o = bundle4;
            }
            Bundle bundle5 = bundle4.getBundle("android.car.EXTENSIONS");
            bundle5 = bundle5 == null ? new Bundle() : bundle5;
            Bundle bundle6 = new Bundle(bundle5);
            Bundle bundle7 = new Bundle();
            int i9 = 0;
            while (i9 < arrayList10.size()) {
                String string = Integer.toString(i9);
                ArrayList arrayList11 = arrayList10;
                ts2 ts2Var2 = (ts2) arrayList11.get(i9);
                Bundle bundle8 = new Bundle();
                IconCompat iconCompatA2 = ts2Var2.b;
                if (iconCompatA2 == null && (i = ts2Var2.e) != 0) {
                    iconCompatA2 = IconCompat.a(i);
                    ts2Var2.b = iconCompatA2;
                }
                Bundle bundle9 = ts2Var2.a;
                bundle8.putInt("icon", iconCompatA2 != null ? iconCompatA2.b() : 0);
                bundle8.putCharSequence("title", ts2Var2.f);
                bundle8.putParcelable("actionIntent", ts2Var2.g);
                Bundle bundle10 = bundle9 != null ? new Bundle(bundle9) : new Bundle();
                bundle10.putBoolean("android.support.allowGeneratedReplies", ts2Var2.c);
                bundle8.putBundle("extras", bundle10);
                bundle8.putParcelableArray("remoteInputs", null);
                bundle8.putBoolean("showsUserInterface", ts2Var2.d);
                bundle8.putInt("semanticAction", 0);
                bundle7.putBundle(string, bundle8);
                i9++;
                arrayList10 = arrayList11;
            }
            bundle5.putBundle("invisible_actions", bundle7);
            bundle6.putBundle("invisible_actions", bundle7);
            Bundle bundle11 = us2Var.o;
            if (bundle11 == null) {
                bundle11 = new Bundle();
                us2Var.o = bundle11;
            }
            bundle11.putBundle("android.car.EXTENSIONS", bundle5);
            ((Bundle) this.e).putBundle("android.car.EXTENSIONS", bundle6);
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            ((Notification.Builder) this.c).setExtras(us2Var.o);
            ga5.D((Notification.Builder) this.c);
        }
        if (i10 >= 26) {
            v02.C((Notification.Builder) this.c);
            v02.K((Notification.Builder) this.c);
            v02.L((Notification.Builder) this.c);
            v02.M((Notification.Builder) this.c);
            v02.F((Notification.Builder) this.c, 0);
            if (!TextUtils.isEmpty(us2Var.q)) {
                ((Notification.Builder) this.c).setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i10 >= 28) {
            Iterator it5 = arrayList9.iterator();
            if (it5.hasNext()) {
                throw dw2.z(it5);
            }
        }
        if (i10 >= 29) {
            v9.s((Notification.Builder) this.c, us2Var.r);
            v9.t((Notification.Builder) this.c);
        }
        if (i10 >= 36) {
            m2.g((Notification.Builder) this.c);
        }
        if (us2Var.t) {
            ((us2) this.d).getClass();
            this.b = 1;
            ((Notification.Builder) this.c).setVibrate(null);
            ((Notification.Builder) this.c).setSound(null);
            int i11 = notification3.defaults & (-4);
            notification3.defaults = i11;
            ((Notification.Builder) this.c).setDefaults(i11);
            if (i10 >= 26) {
                ((us2) this.d).getClass();
                if (TextUtils.isEmpty(null)) {
                    ((Notification.Builder) this.c).setGroup("silent");
                }
                v02.F((Notification.Builder) this.c, 1);
            }
        }
    }

    public static void f(StringBuilder sb, int i, int i2, byte[] bArr, int i3) {
        int i4 = i2 * i;
        sb.append(":T:");
        sb.append(i);
        sb.append(':');
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return;
            }
            sb.append(new String(bArr, i3, 1));
            i4 = i5;
            i3++;
        }
    }

    public static int h(int i, k0 k0Var) {
        if (i >= 128) {
            return 4;
        }
        if (i != 0 || k0Var.b <= 1) {
            return f[i];
        }
        return 20;
    }

    public static void j(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }

    public void a(byte b, k0 k0Var) {
        int i = b & 255;
        byte[] bArr = (byte[]) this.e;
        if (bArr[i] == 0) {
            bArr[i] = 1;
            this.b = h(i, k0Var) + this.b;
        }
    }

    public void b(eg0 eg0Var) {
        if (eg0Var != null) {
            pt0 pt0Var = (pt0) eg0Var;
            tj tjVar = (tj) this.c;
            tj[] tjVarArr = (tj[]) pt0Var.z;
            for (tj tjVar2 : tjVarArr) {
                if (tjVar2 != null) {
                    tjVar2.c();
                }
            }
            pt0Var.Z(tjVarArr, tjVar);
            xo xoVar = (xo) pt0Var.f;
            boolean z = pt0Var.A;
            xk3 xk3Var = z ? xoVar.b : xoVar.d;
            xk3 xk3Var2 = z ? xoVar.c : xoVar.e;
            int iL = pt0Var.L((int) xk3Var.b);
            int iL2 = pt0Var.L((int) xk3Var2.b);
            int i = -1;
            int iMax = 1;
            int i2 = 0;
            while (iL < iL2) {
                tj tjVar3 = tjVarArr[iL];
                if (tjVar3 != null) {
                    int i3 = tjVar3.f;
                    int i4 = i3 - i;
                    if (i4 == 0) {
                        i2++;
                    } else {
                        if (i4 == 1) {
                            iMax = Math.max(iMax, i2);
                            i = tjVar3.f;
                        } else if (i4 < 0 || i3 >= tjVar.f || i4 > iL) {
                            tjVarArr[iL] = null;
                        } else {
                            if (iMax > 2) {
                                i4 *= iMax - 2;
                            }
                            boolean z2 = i4 >= iL;
                            for (int i5 = 1; i5 <= i4 && !z2; i5++) {
                                z2 = tjVarArr[iL - i5] != null;
                            }
                            if (z2) {
                                tjVarArr[iL] = null;
                            } else {
                                i = tjVar3.f;
                            }
                        }
                        i2 = 1;
                    }
                }
                iL++;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x002d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:105:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int c(int i, StringBuilder sb) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        byte[][] bArr = (byte[][]) this.d;
        sb.append('[');
        String[] strArr = lt2.a;
        int[] iArr = (int[]) this.c;
        sb.append(strArr[iArr[i]]);
        int[] iArr2 = lt2.b;
        int i10 = iArr[i];
        int i11 = iArr2[i10];
        if (i11 != -1) {
            i3 = i + 1;
            switch (i11) {
                case 1:
                    sb.append(":(");
                    sb.append(iArr[i3]);
                    sb.append(')');
                    i3 = i + 2;
                    break;
                case 2:
                    sb.append(":(");
                    sb.append(iArr[i3]);
                    sb.append(')');
                    i3 = i + 2;
                    break;
                case 3:
                    sb.append(':');
                    sb.append(iArr[i3]);
                    i3 = i + 2;
                    break;
                case 4:
                    sb.append(':');
                    sb.append(iArr[i3]);
                    i3 = i + 2;
                    break;
                case 5:
                    sb.append(':');
                    sb.append(iArr[i3]);
                    i3 = i + 2;
                    break;
                case 6:
                    sb.append(':');
                    sb.append(iArr[i3]);
                    i3 = i + 3;
                    break;
            }
        } else {
            int i12 = i + 1;
            if (i10 == 26 || i10 == 27) {
                i2 = i + 2;
                g(sb, 1, i12);
                i3 = i2;
            } else {
                if (i10 != 82) {
                    if (i10 != 83) {
                        int i13 = 0;
                        if (i10 == 98) {
                            byte[] bArr2 = new byte[6];
                            int i14 = 0;
                            while (true) {
                                int i15 = i12 + i14;
                                if (i15 < iArr.length && i14 < 6) {
                                    bArr2[i14] = (byte) iArr[i15];
                                    i14++;
                                }
                            }
                            int iR = ((k0) this.e).r(0, 6, bArr2);
                            g(sb, iR, i12);
                            i3 = i12 + iR;
                        } else if (i10 != 99) {
                            switch (i10) {
                                case 2:
                                    break;
                                case 3:
                                    g(sb, 2, i12);
                                    i3 = i + 3;
                                    break;
                                case 4:
                                    g(sb, 3, i12);
                                    i3 = i + 4;
                                    break;
                                case 5:
                                    g(sb, 4, i12);
                                    i3 = i + 5;
                                    break;
                                case 6:
                                    g(sb, 5, i12);
                                    i3 = i + 6;
                                    break;
                                case 7:
                                    i5 = iArr[i12];
                                    i6 = i + 2;
                                    if (!ja0.C) {
                                        e(sb, i5, 1, i6);
                                        i3 = i6 + i5;
                                    } else {
                                        int i16 = iArr[i6];
                                        i7 = i + 4;
                                        f(sb, i5, 1, bArr[i16], iArr[i + 3]);
                                        i3 = i7;
                                    }
                                    break;
                                case 8:
                                    g(sb, 2, i12);
                                    i3 = i + 3;
                                    break;
                                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                                    g(sb, 4, i12);
                                    i3 = i + 5;
                                    break;
                                case 10:
                                    g(sb, 6, i12);
                                    i3 = i + 7;
                                    break;
                                case 11:
                                    int i17 = iArr[i12];
                                    i8 = i + 2;
                                    if (!ja0.C) {
                                        e(sb, i17, 2, i8);
                                        i9 = i17 * 2;
                                        i3 = i9 + i8;
                                    } else {
                                        int i18 = iArr[i8];
                                        i7 = i + 4;
                                        f(sb, i17, 2, bArr[i18], iArr[i + 3]);
                                        i3 = i7;
                                    }
                                    break;
                                case FileClientSessionCache.MAX_SIZE /* 12 */:
                                    int i19 = iArr[i12];
                                    i8 = i + 2;
                                    if (!ja0.C) {
                                        e(sb, i19, 3, i8);
                                        i9 = i19 * 3;
                                        i3 = i9 + i8;
                                    } else {
                                        int i20 = iArr[i8];
                                        i7 = i + 4;
                                        f(sb, i19, 3, bArr[i20], iArr[i + 3]);
                                        i3 = i7;
                                    }
                                    break;
                                case 13:
                                    int i21 = iArr[i12];
                                    int i22 = iArr[i + 2];
                                    int i23 = i + 3;
                                    int i24 = i22 * i21;
                                    if (!ja0.C) {
                                        sb.append(":");
                                        sb.append(i21);
                                        sb.append(":");
                                        sb.append(i22);
                                        sb.append(":");
                                        while (true) {
                                            i3 = i23;
                                            int i25 = i24 - 1;
                                            if (i24 > 0) {
                                                i23 = i3 + 1;
                                                sb.append(new String(new byte[]{(byte) iArr[i3]}));
                                                i24 = i25;
                                            }
                                        }
                                    } else {
                                        int i26 = iArr[i23];
                                        int i27 = iArr[i + 4];
                                        int i28 = i + 5;
                                        sb.append(":T:");
                                        sb.append(i21);
                                        sb.append(":");
                                        sb.append(i22);
                                        sb.append(":");
                                        while (true) {
                                            int i29 = i24 - 1;
                                            if (i24 <= 0) {
                                                i3 = i28;
                                            } else {
                                                sb.append(new String(bArr[i26], i27, 1));
                                                i24 = i29;
                                                i27++;
                                            }
                                        }
                                    }
                                    break;
                                case 14:
                                    break;
                                case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                                    i5 = iArr[i12];
                                    i6 = i + 2;
                                    if (!ja0.C) {
                                        e(sb, i5, 1, i6);
                                        i3 = i6 + i5;
                                    } else {
                                        int i30 = iArr[i6];
                                        i7 = i + 4;
                                        f(sb, i5, 1, bArr[i30], iArr[i + 3]);
                                        i3 = i7;
                                    }
                                    break;
                                case 16:
                                    dn dnVar = new dn();
                                    System.arraycopy(iArr, i12, dnVar.a, 0, 8);
                                    int iF = dnVar.f();
                                    i2 = i + 9;
                                    sb.append(':');
                                    sb.append(iF);
                                    break;
                                case 17:
                                case 20:
                                    int i31 = iArr[i12];
                                    int i32 = i + 2;
                                    int i33 = iArr[i32];
                                    i2 = i32 + i31;
                                    sb.append(':');
                                    sb.append(i33);
                                    sb.append(':');
                                    sb.append(i31);
                                    break;
                                case 18:
                                case 21:
                                    dn dnVar2 = new dn();
                                    System.arraycopy(iArr, i12, dnVar2.a, 0, 8);
                                    int iF2 = dnVar2.f();
                                    int i34 = iArr[i + 9];
                                    int i35 = i + 10;
                                    int i36 = iArr[i35];
                                    i4 = i35 + i34;
                                    sb.append(':');
                                    sb.append(iF2);
                                    sb.append(':');
                                    sb.append(i36);
                                    sb.append(':');
                                    sb.append(i34);
                                    break;
                                case 19:
                                    dn dnVar3 = new dn();
                                    System.arraycopy(iArr, i12, dnVar3.a, 0, 8);
                                    int iF3 = dnVar3.f();
                                    i2 = i + 9;
                                    sb.append(':');
                                    sb.append(iF3);
                                    break;
                                default:
                                    switch (i10) {
                                        case 49:
                                            int i37 = iArr[i12];
                                            i2 = i + 2;
                                            sb.append(':');
                                            sb.append(i37);
                                            break;
                                        case 50:
                                        case 51:
                                            sb.append(' ');
                                            int i38 = iArr[i12];
                                            i4 = i + 2;
                                            while (i13 < i38) {
                                                int i39 = iArr[i4];
                                                i4++;
                                                if (i13 > 0) {
                                                    sb.append(", ");
                                                }
                                                sb.append(i39);
                                                i13++;
                                            }
                                            break;
                                        case 52:
                                            int i40 = iArr[i12];
                                            sb.append(':');
                                            sb.append(i40);
                                            int i41 = iArr[i + 2];
                                            sb.append(':');
                                            sb.append(i41);
                                            sb.append(' ');
                                            int i42 = iArr[i + 3];
                                            i4 = i + 4;
                                            while (i13 < i42) {
                                                int i43 = iArr[i4];
                                                i4++;
                                                if (i13 > 0) {
                                                    sb.append(", ");
                                                }
                                                sb.append(i43);
                                                i13++;
                                            }
                                            break;
                                        default:
                                            switch (i10) {
                                                case 64:
                                                case 65:
                                                    int i44 = iArr[i12];
                                                    sb.append(":(");
                                                    sb.append(i44);
                                                    sb.append(')');
                                                    g(sb, 1, i + 2);
                                                    i3 = i + 3;
                                                    break;
                                                case 66:
                                                case 67:
                                                    int i45 = iArr[i12];
                                                    int i46 = iArr[i + 2];
                                                    i4 = i + 3;
                                                    sb.append(':');
                                                    sb.append(i45);
                                                    sb.append(':');
                                                    sb.append(i46);
                                                    break;
                                                default:
                                                    switch (i10) {
                                                        case 90:
                                                            int i47 = iArr[i12];
                                                            int i48 = iArr[i + 2];
                                                            i4 = i + 3;
                                                            sb.append(':');
                                                            sb.append(i47);
                                                            sb.append(":");
                                                            sb.append(i48);
                                                            break;
                                                        case 91:
                                                        case 92:
                                                            int i49 = iArr[i12];
                                                            int i50 = iArr[i + 2];
                                                            i4 = i + 3;
                                                            sb.append(':');
                                                            sb.append(i49);
                                                            sb.append(":(");
                                                            sb.append(i50);
                                                            sb.append(')');
                                                            break;
                                                        default:
                                                            throw new l12("undefined code: " + iArr[i]);
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                        }
                    } else {
                        int i51 = iArr[i12];
                        int i52 = iArr[i + 2];
                        i4 = i + 3;
                        sb.append(':');
                        sb.append(i52);
                        sb.append(":(");
                        sb.append(i51);
                        sb.append(')');
                    }
                    i3 = i4;
                } else {
                    int i53 = iArr[i12];
                    i2 = i + 2;
                    sb.append(':');
                    sb.append(i53);
                }
                i3 = i2;
            }
        }
        sb.append(']');
        if (ja0.L) {
            sb.append('@');
            sb.append(i);
            sb.append('(');
            sb.append(i3 - i);
            sb.append(')');
        }
        return i3;
    }

    public void d(lw2 lw2Var) {
        hm2 hm2Var = (hm2) this.c;
        hm2 hm2Var2 = (hm2) lw2Var.c;
        hm2Var.b = hm2Var2.b;
        hm2Var.c = hm2Var2.c;
        hm2 hm2Var3 = (hm2) this.d;
        hm2 hm2Var4 = (hm2) lw2Var.d;
        hm2Var3.b = hm2Var4.b;
        hm2Var3.c = hm2Var4.c;
        this.b = lw2Var.b;
        byte[] bArr = (byte[]) lw2Var.e;
        System.arraycopy(bArr, 0, (byte[]) this.e, 0, bArr.length);
    }

    public void e(StringBuilder sb, int i, int i2, int i3) {
        int i4 = i2 * i;
        sb.append(':');
        sb.append(i);
        sb.append(':');
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return;
            }
            sb.append(new String(new byte[]{(byte) ((int[]) this.c)[i3]}));
            i4 = i5;
            i3++;
        }
    }

    public void g(StringBuilder sb, int i, int i2) {
        sb.append(':');
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                return;
            }
            sb.append(new String(new byte[]{(byte) ((int[]) this.c)[i2]}));
            i = i3;
            i2++;
        }
    }

    public synchronized void i(Bitmap bitmap, BlurMaskFilter blurMaskFilter, Canvas canvas) {
        ((Paint) this.c).setMaskFilter(blurMaskFilter);
        Bitmap bitmapExtractAlpha = bitmap.extractAlpha((Paint) this.c, new int[2]);
        ((Paint) this.d).setAlpha(30);
        canvas.drawBitmap(bitmapExtractAlpha, r0[0], r0[1], (Paint) this.d);
        ((Paint) this.d).setAlpha(61);
        canvas.drawBitmap(bitmapExtractAlpha, r0[0], (this.b * 0.020833334f) + r0[1], (Paint) this.d);
        ((Paint) this.d).setAlpha(DnsRecord.CLASS_ANY);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) this.d);
    }

    public String toString() {
        switch (this.a) {
            case 3:
                int i = this.b;
                eg0[] eg0VarArr = (eg0[]) this.d;
                eg0 eg0Var = eg0VarArr[0];
                if (eg0Var == null) {
                    eg0Var = eg0VarArr[i + 1];
                }
                Formatter formatter = new Formatter();
                for (int i2 = 0; i2 < ((tj[]) eg0Var.z).length; i2++) {
                    try {
                        formatter.format("CW %3d:", Integer.valueOf(i2));
                        for (int i3 = 0; i3 < i + 2; i3++) {
                            eg0 eg0Var2 = eg0VarArr[i3];
                            if (eg0Var2 == null) {
                                formatter.format("    |   ", new Object[0]);
                            } else {
                                tj tjVar = ((tj[]) eg0Var2.z)[i2];
                                if (tjVar == null) {
                                    formatter.format("    |   ", new Object[0]);
                                } else {
                                    formatter.format(" %3d|%3d", Integer.valueOf(tjVar.f), Integer.valueOf(tjVar.e));
                                }
                            }
                        }
                        formatter.format("%n", new Object[0]);
                    } catch (Throwable th) {
                        try {
                            formatter.close();
                            break;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                String string = formatter.toString();
                formatter.close();
                return string;
            default:
                return super.toString();
        }
    }

    public lw2(th3 th3Var) {
        this.a = 1;
        this.c = th3Var.a;
        this.b = th3Var.b;
        this.d = th3Var.G;
        this.e = th3Var.p;
    }

    public lw2(tj tjVar, xo xoVar) {
        this.a = 3;
        this.c = tjVar;
        int i = tjVar.b;
        this.b = i;
        this.e = xoVar;
        this.d = new eg0[i + 2];
    }

    public lw2(int i) {
        this.a = 5;
        this.b = i;
        this.c = new Paint(3);
        this.d = new Paint(3);
        this.e = new BlurMaskFilter(i * 0.010416667f, BlurMaskFilter.Blur.NORMAL);
    }

    public lw2(byte b, int i) {
        this.a = i;
        switch (i) {
            case 7:
                break;
            default:
                this.c = new hm2(0);
                this.d = new hm2(5);
                this.e = new byte[ja0.b];
                break;
        }
    }

    public lw2(int i, jp jpVar, cf0 cf0Var, zf1 zf1Var) {
        this.a = 6;
        this.c = zf1Var;
        this.b = i;
        this.d = jpVar;
        this.e = cf0Var;
    }

    public lw2(List list) {
        this.a = 2;
        this.b = ((n70) list.get(list.size() - 1)).c + 1;
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(Short.valueOf(((n70) it.next()).c));
        }
        this.d = new int[this.b];
        short s = 0;
        while (true) {
            int i = this.b;
            if (s < i) {
                if (hashSet.contains(Short.valueOf(s))) {
                    ((int[]) this.d)[s] = 1073741824;
                }
                s = (short) (s + 1);
            } else {
                this.c = new q70((short) 514, (short) 16, (i * 4) + 16);
                this.e = new j40(list, hashSet, i);
                return;
            }
        }
    }
}
