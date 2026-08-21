package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.backup.model.BackupSection;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.Comparator;
import java.util.Map;
import java.util.WeakHashMap;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e1 implements Comparator {
    public static final /* synthetic */ e1 f = new e1(28);
    public final /* synthetic */ int b;

    public /* synthetic */ e1(int i) {
        this.b = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:176:0x016b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x013b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016f  */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int compare(Object obj, Object obj2) {
        int upperCase;
        int upperCase2;
        int upperCase3;
        int upperCase4;
        int iOffsetByCodePoints;
        int iOffsetByCodePoints2;
        int iOffsetByCodePoints3;
        int iCodePointCount;
        int iCodePointCount2;
        switch (this.b) {
            case 0:
                rd1 rd1Var = (rd1) obj;
                rd1 rd1Var2 = (rd1) obj2;
                if (rd1Var.m.equals(rd1Var2.m)) {
                    return 0;
                }
                return rd1Var.x < rd1Var2.x ? -1 : 1;
            case 1:
                return ((int[]) obj)[0] - ((int[]) obj2)[0];
            case 2:
                return ye.f(Integer.valueOf(((j51) BackupSection.getEntries()).indexOf((BackupSection) obj)), Integer.valueOf(((j51) BackupSection.getEntries()).indexOf((BackupSection) obj2)));
            case 3:
                return ye.f(((xs) obj).a.packageName, ((xs) obj2).a.packageName);
            case 4:
                return ye.f(Long.valueOf(((xs) obj2).a.firstInstallTime), Long.valueOf(((xs) obj).a.firstInstallTime));
            case 5:
                return ye.f(Long.valueOf(((xs) obj2).a.lastUpdateTime), Long.valueOf(((xs) obj).a.lastUpdateTime));
            case 6:
                return ((byte[]) obj).length - ((byte[]) obj2).length;
            case 7:
                String str = (String) obj;
                String str2 = (String) obj2;
                str.getClass();
                str2.getClass();
                int iMin = Math.min(str.length(), str2.length());
                int i = 4;
                while (true) {
                    if (i >= iMin) {
                        int length = str.length();
                        int length2 = str2.length();
                        if (length == length2) {
                            return 0;
                        }
                        if (length < length2) {
                            return -1;
                        }
                    } else {
                        char cCharAt = str.charAt(i);
                        char cCharAt2 = str2.charAt(i);
                        if (cCharAt == cCharAt2) {
                            i++;
                        } else if (n12.l(cCharAt, cCharAt2) < 0) {
                            return -1;
                        }
                    }
                }
                return 1;
            case 8:
                return ((n70) obj).c - ((n70) obj2).c;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                WeakHashMap weakHashMap = wp4.a;
                float z = ((View) obj).getZ();
                float z2 = ((View) obj2).getZ();
                if (z > z2) {
                    return -1;
                }
                return z < z2 ? 1 : 0;
            case 10:
                return Integer.compare(((bt0) obj).z.Z, ((bt0) obj2).z.Z);
            case 11:
                return ((iu0) obj).a - ((iu0) obj2).a;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return ye.f(((aa1) obj).a, ((aa1) obj2).a);
            case 13:
                return ((String) obj2).compareTo((String) obj);
            case 14:
                hn1 hn1Var = (hn1) obj;
                hn1 hn1Var2 = (hn1) obj2;
                RecyclerView recyclerView = hn1Var.d;
                if ((recyclerView == null) == (hn1Var2.d == null)) {
                    boolean z3 = hn1Var.a;
                    if (z3 == hn1Var2.a) {
                        int i2 = hn1Var2.b - hn1Var.b;
                        if (i2 != 0) {
                            return i2;
                        }
                        int i3 = hn1Var.c - hn1Var2.c;
                        if (i3 != 0) {
                            return i3;
                        }
                        return 0;
                    }
                    if (z3) {
                        return -1;
                    }
                } else if (recyclerView != null) {
                    return -1;
                }
                return 1;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            case 16:
                zk zkVar = (zk) obj;
                zk zkVar2 = (zk) obj2;
                zkVar.getClass();
                zkVar2.getClass();
                String name = zkVar.getName();
                String name2 = zkVar2.getName();
                int iOffsetByCodePoints4 = 0;
                int iOffsetByCodePoints5 = 0;
                int i4 = 0;
                while (iOffsetByCodePoints4 < name.length() && iOffsetByCodePoints5 < name2.length()) {
                    int iCodePointAt = name.codePointAt(iOffsetByCodePoints4);
                    int iCodePointAt2 = name2.codePointAt(iOffsetByCodePoints5);
                    if (Character.isDigit(iCodePointAt) && Character.isDigit(iCodePointAt2)) {
                        int iOffsetByCodePoints6 = iOffsetByCodePoints4;
                        do {
                            iOffsetByCodePoints6 = name.offsetByCodePoints(iOffsetByCodePoints6, 1);
                            if (iOffsetByCodePoints6 < name.length()) {
                            }
                            iOffsetByCodePoints = iOffsetByCodePoints5;
                            do {
                                iOffsetByCodePoints = name2.offsetByCodePoints(iOffsetByCodePoints, 1);
                                if (iOffsetByCodePoints >= name2.length()) {
                                }
                                iOffsetByCodePoints2 = iOffsetByCodePoints4;
                                while (iOffsetByCodePoints2 < iOffsetByCodePoints6 && Character.digit(name.codePointAt(iOffsetByCodePoints2), 10) == 0) {
                                    iOffsetByCodePoints2 = name.offsetByCodePoints(iOffsetByCodePoints2, 1);
                                }
                                iOffsetByCodePoints3 = iOffsetByCodePoints5;
                                while (iOffsetByCodePoints3 < iOffsetByCodePoints && Character.digit(name2.codePointAt(iOffsetByCodePoints3), 10) == 0) {
                                    iOffsetByCodePoints3 = name2.offsetByCodePoints(iOffsetByCodePoints3, 1);
                                }
                                iCodePointCount = name.codePointCount(iOffsetByCodePoints2, iOffsetByCodePoints6);
                                iCodePointCount2 = name2.codePointCount(iOffsetByCodePoints3, iOffsetByCodePoints);
                                if (iCodePointCount == iCodePointCount2) {
                                    return iCodePointCount - iCodePointCount2;
                                }
                                int iOffsetByCodePoints7 = iOffsetByCodePoints2;
                                int iOffsetByCodePoints8 = iOffsetByCodePoints3;
                                while (iOffsetByCodePoints7 < iOffsetByCodePoints6) {
                                    int iDigit = Character.digit(name.codePointAt(iOffsetByCodePoints7), 10);
                                    int iDigit2 = Character.digit(name2.codePointAt(iOffsetByCodePoints8), 10);
                                    if (iDigit != iDigit2) {
                                        return iDigit - iDigit2;
                                    }
                                    iOffsetByCodePoints7 = name.offsetByCodePoints(iOffsetByCodePoints7, 1);
                                    iOffsetByCodePoints8 = name2.offsetByCodePoints(iOffsetByCodePoints8, 1);
                                }
                                int iCodePointCount3 = name.codePointCount(iOffsetByCodePoints4, iOffsetByCodePoints2);
                                int iCodePointCount4 = name2.codePointCount(iOffsetByCodePoints5, iOffsetByCodePoints3);
                                if (iCodePointCount3 != iCodePointCount4 && i4 == 0) {
                                    i4 = iCodePointCount3 - iCodePointCount4;
                                }
                                iOffsetByCodePoints4 = iOffsetByCodePoints6;
                                iOffsetByCodePoints5 = iOffsetByCodePoints;
                            } while (Character.isDigit(name2.codePointAt(iOffsetByCodePoints)));
                            iOffsetByCodePoints2 = iOffsetByCodePoints4;
                            while (iOffsetByCodePoints2 < iOffsetByCodePoints6) {
                                iOffsetByCodePoints2 = name.offsetByCodePoints(iOffsetByCodePoints2, 1);
                            }
                            iOffsetByCodePoints3 = iOffsetByCodePoints5;
                            while (iOffsetByCodePoints3 < iOffsetByCodePoints) {
                                iOffsetByCodePoints3 = name2.offsetByCodePoints(iOffsetByCodePoints3, 1);
                            }
                            iCodePointCount = name.codePointCount(iOffsetByCodePoints2, iOffsetByCodePoints6);
                            iCodePointCount2 = name2.codePointCount(iOffsetByCodePoints3, iOffsetByCodePoints);
                            if (iCodePointCount == iCodePointCount2) {
                            }
                        } while (Character.isDigit(name.codePointAt(iOffsetByCodePoints6)));
                        iOffsetByCodePoints = iOffsetByCodePoints5;
                        do {
                            iOffsetByCodePoints = name2.offsetByCodePoints(iOffsetByCodePoints, 1);
                            if (iOffsetByCodePoints >= name2.length()) {
                            }
                            iOffsetByCodePoints2 = iOffsetByCodePoints4;
                            while (iOffsetByCodePoints2 < iOffsetByCodePoints6) {
                            }
                            iOffsetByCodePoints3 = iOffsetByCodePoints5;
                            while (iOffsetByCodePoints3 < iOffsetByCodePoints) {
                            }
                            iCodePointCount = name.codePointCount(iOffsetByCodePoints2, iOffsetByCodePoints6);
                            iCodePointCount2 = name2.codePointCount(iOffsetByCodePoints3, iOffsetByCodePoints);
                            if (iCodePointCount == iCodePointCount2) {
                            }
                        } while (Character.isDigit(name2.codePointAt(iOffsetByCodePoints)));
                        iOffsetByCodePoints2 = iOffsetByCodePoints4;
                        while (iOffsetByCodePoints2 < iOffsetByCodePoints6) {
                        }
                        iOffsetByCodePoints3 = iOffsetByCodePoints5;
                        while (iOffsetByCodePoints3 < iOffsetByCodePoints) {
                        }
                        iCodePointCount = name.codePointCount(iOffsetByCodePoints2, iOffsetByCodePoints6);
                        iCodePointCount2 = name2.codePointCount(iOffsetByCodePoints3, iOffsetByCodePoints);
                        if (iCodePointCount == iCodePointCount2) {
                        }
                    } else {
                        int upperCase5 = Character.toUpperCase(iCodePointAt);
                        int upperCase6 = Character.toUpperCase(iCodePointAt2);
                        if (upperCase5 != upperCase6 && Character.toLowerCase(upperCase5) != Character.toLowerCase(upperCase6)) {
                            if (iCodePointAt == iCodePointAt2 || (upperCase = Character.toUpperCase(iCodePointAt)) == (upperCase2 = Character.toUpperCase(iCodePointAt2)) || (upperCase3 = Character.toUpperCase(upperCase)) == (upperCase4 = Character.toUpperCase(upperCase2))) {
                                return 0;
                            }
                            return upperCase3 - upperCase4;
                        }
                        iOffsetByCodePoints4 = name.offsetByCodePoints(iOffsetByCodePoints4, 1);
                        iOffsetByCodePoints5 = name2.offsetByCodePoints(iOffsetByCodePoints5, 1);
                    }
                }
                int iCodePointCount5 = name.codePointCount(iOffsetByCodePoints4, name.length());
                int iCodePointCount6 = name2.codePointCount(iOffsetByCodePoints5, name2.length());
                return iCodePointCount5 != iCodePointCount6 ? iCodePointCount5 - iCodePointCount6 : i4 != 0 ? i4 : name.compareTo(name2);
            case 17:
                return ((jz3) obj).f - ((jz3) obj2).f;
            case 18:
                return ye.f(((f82) obj).z, ((f82) obj2).z);
            case 19:
                return ye.f((Integer) ((Map.Entry) obj).getKey(), (Integer) ((Map.Entry) obj2).getKey());
            case 20:
                return ye.f((Integer) ((Map.Entry) obj).getKey(), (Integer) ((Map.Entry) obj2).getKey());
            case 21:
                return ye.f(((ka4) obj).a, ((ka4) obj2).a);
            case 22:
                return ye.f(((ma4) obj).a, ((ma4) obj2).a);
            case 23:
                return ye.f((Integer) ((Map.Entry) obj).getKey(), (Integer) ((Map.Entry) obj2).getKey());
            case 24:
                return ((View) obj).getTop() - ((View) obj2).getTop();
            case 25:
                pd pdVar = (pd) obj2;
                pd pdVar2 = (pd) obj;
                return ye.f(Long.valueOf(pdVar.e + pdVar.d), Long.valueOf(pdVar2.e + pdVar2.d));
            case 26:
                pd pdVar3 = (pd) obj2;
                pd pdVar4 = (pd) obj;
                return ye.f(Long.valueOf(pdVar3.c + pdVar3.b), Long.valueOf(pdVar4.c + pdVar4.b));
            case 27:
                return ye.f(((ny4) obj).a, ((ny4) obj2).a);
            default:
                return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
        }
    }
}
