package defpackage;

import android.media.MediaCodec;
import android.util.Size;
import com.getsurfboard.ui.provider.ProfilesProvider;
import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.anr.a;
import io.sentry.n1;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i60 implements Comparator {
    public final /* synthetic */ int b;

    /* JADX WARN: Removed duplicated region for block: B:113:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01ea  */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int compare(Object obj, Object obj2) {
        kz3 kz3Var;
        int i;
        int i2;
        int i3 = 1;
        switch (this.b) {
            case 0:
                j60 j60Var = (j60) obj;
                j60 j60Var2 = (j60) obj2;
                int iCompare = Integer.compare(j60Var.c, j60Var2.c);
                return iCompare == 0 ? Integer.compare(j60Var.d, j60Var2.d) : iCompare;
            case 1:
                j60 j60Var3 = (j60) obj;
                j60 j60Var4 = (j60) obj2;
                int iCompare2 = Integer.compare(j60Var3.a, j60Var4.a);
                return iCompare2 == 0 ? Integer.compare(j60Var3.b, j60Var4.b) : iCompare2;
            case 2:
                ax3 ax3Var = (ax3) obj;
                ax3 ax3Var2 = (ax3) obj2;
                ax3Var.getClass();
                ax3Var2.getClass();
                u80 u80Var = ax3Var.c;
                u80 u80Var2 = ax3Var2.c;
                if (u80Var == u80Var2) {
                    kz3Var = ax3Var.e;
                    if (kz3Var == null) {
                        kz3Var = null;
                    }
                    i = kz3Var == null ? kz3Var.b.a : 0;
                    kz3 kz3Var2 = ax3Var2.e;
                    kz3 kz3Var3 = kz3Var2 != null ? kz3Var2 : null;
                    i2 = kz3Var3 == null ? kz3Var3.b.a : 0;
                    if (i >= i2) {
                        if (i > i2) {
                            return -1;
                        }
                        String strF = je.f(ax3Var.b);
                        String strF2 = je.f(ax3Var2.b);
                        if (strF.compareTo(strF2) < 0) {
                            return -1;
                        }
                        if (strF.compareTo(strF2) <= 0) {
                            u80 u80Var3 = ax3Var2.c;
                            int i4 = u80Var3 != null ? u80Var3.b : 0;
                            u80 u80Var4 = ax3Var.c;
                            return i4 - (u80Var4 != null ? u80Var4.b : 0);
                        }
                    }
                } else {
                    u80 u80Var5 = u80.X;
                    if (u80Var != u80Var5) {
                        if (u80Var2 == u80Var5) {
                            return -1;
                        }
                        kz3Var = ax3Var.e;
                        if (kz3Var == null) {
                        }
                        if (kz3Var == null) {
                        }
                        kz3 kz3Var22 = ax3Var2.e;
                        if (kz3Var22 != null) {
                        }
                        if (kz3Var3 == null) {
                        }
                        if (i >= i2) {
                        }
                    }
                }
                return 1;
            case 3:
                b01 b01Var = (b01) obj;
                b01 b01Var2 = (b01) obj2;
                int iA = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                int iA2 = b01Var == null ? Integer.MAX_VALUE : b01Var.a();
                if (b01Var2 != null) {
                    iA = b01Var2.a();
                }
                return Integer.compare(iA2, iA);
            case 4:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i5 = 0; i5 < bArr.length; i5++) {
                    byte b = bArr[i5];
                    byte b2 = bArr2[i5];
                    if (b != b2) {
                        return b - b2;
                    }
                }
                return 0;
            case 5:
                return ((e02) obj).c - ((e02) obj2).c;
            case 6:
                return ((Comparable) ((Map.Entry) obj).getKey()).compareTo((Comparable) ((Map.Entry) obj2).getKey());
            case 7:
                Size size = (Size) obj;
                Size size2 = (Size) obj2;
                return Long.signum((((long) size.getWidth()) * ((long) size.getHeight())) - (((long) size2.getWidth()) * ((long) size2.getHeight())));
            case 8:
                return ((pg) obj).a.compareTo(((pg) obj2).a);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                int i6 = ProfilesProvider.z;
                return n12.m(((File) obj).lastModified(), ((File) obj2).lastModified());
            case 10:
                fh fhVar = (fh) obj2;
                Class cls = ((fh) obj).a.j;
                int i7 = cls == MediaCodec.class ? 2 : (cls == j43.class || cls == z34.class) ? 0 : 1;
                Class cls2 = fhVar.a.j;
                if (cls2 == MediaCodec.class) {
                    i3 = 2;
                } else if (cls2 == j43.class || cls2 == z34.class) {
                    i3 = 0;
                }
                return i7 - i3;
            case 11:
                as2 as2Var = (as2) obj;
                as2 as2Var2 = (as2) obj2;
                if (as2Var == null && as2Var2 == null) {
                    return 0;
                }
                if (as2Var == null) {
                    return -1;
                }
                if (as2Var2 == null) {
                    return 1;
                }
                return Integer.compare(as2Var.a, as2Var2.a);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                l03 l03Var = (l03) obj;
                l03 l03Var2 = (l03) obj2;
                String str = l03Var.a;
                String str2 = l03Var2.a;
                List list = m44.a;
                int iCompareTo = str.compareTo(str2);
                int i8 = iCompareTo >= 0 ? iCompareTo > 0 ? 1 : 0 : -1;
                if (i8 != 0) {
                    return i8;
                }
                int iD = m44.d(l03Var.b, l03Var2.b);
                return iD != 0 ? iD : l03Var.c - l03Var2.c;
            case 13:
                gd4 gd4Var = (gd4) obj;
                gd4 gd4Var2 = (gd4) obj2;
                int i9 = gd4Var.a;
                int i10 = gd4Var2.a;
                if (i9 != i10) {
                    return i10 - i9;
                }
                List list2 = gd4Var.b;
                List list3 = gd4Var2.b;
                int size3 = list2 == null ? 0 : list2.size();
                int size4 = list3 == null ? 0 : list3.size();
                if (size3 == size4) {
                    while (i < size3) {
                        String str3 = (String) list2.get(i);
                        String str4 = (String) list3.get(i);
                        int length = str3.length();
                        int length2 = str4.length();
                        if (length != length2) {
                            return length2 - length;
                        }
                        i++;
                    }
                }
                return size4 - size3;
            case 14:
                n1 n1Var = (n1) obj;
                n1 n1Var2 = (n1) obj2;
                if (n1Var == n1Var2) {
                    return 0;
                }
                int iCompareTo2 = n1Var.u().compareTo(n1Var2.u());
                return iCompareTo2 != 0 ? iCompareTo2 : n1Var.r().f.a().compareTo(n1Var2.r().f.a());
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return Float.compare((((a) obj).b + 1.0f) * r6.f * r6.a, (((a) obj2).b + 1.0f) * r7.f * r7.a);
            default:
                return Long.compare(((File) obj).lastModified(), ((File) obj2).lastModified());
        }
    }

    public /* synthetic */ i60(int i) {
        this.b = i;
    }
}
