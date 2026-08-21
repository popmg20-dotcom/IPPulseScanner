package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.netty.handler.ssl.OpenSslSessionTicketKey;
import io.sentry.android.core.a1;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import org.conscrypt.FileClientSessionCache;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ac0 {
    public static final int[] c = {0, 4, 8};
    public static final SparseIntArray d;
    public static final SparseIntArray e;
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        d = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        e = sparseIntArray2;
        sparseIntArray.append(82, 25);
        sparseIntArray.append(83, 26);
        sparseIntArray.append(85, 29);
        sparseIntArray.append(86, 30);
        sparseIntArray.append(92, 36);
        sparseIntArray.append(91, 35);
        sparseIntArray.append(63, 4);
        sparseIntArray.append(62, 3);
        sparseIntArray.append(58, 1);
        sparseIntArray.append(60, 91);
        sparseIntArray.append(59, 92);
        sparseIntArray.append(101, 6);
        sparseIntArray.append(102, 7);
        sparseIntArray.append(70, 17);
        sparseIntArray.append(71, 18);
        sparseIntArray.append(72, 19);
        sparseIntArray.append(54, 99);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(87, 32);
        sparseIntArray.append(88, 33);
        sparseIntArray.append(69, 10);
        sparseIntArray.append(68, 9);
        sparseIntArray.append(106, 13);
        sparseIntArray.append(109, 16);
        sparseIntArray.append(107, 14);
        sparseIntArray.append(104, 11);
        sparseIntArray.append(108, 15);
        sparseIntArray.append(105, 12);
        sparseIntArray.append(95, 40);
        sparseIntArray.append(80, 39);
        sparseIntArray.append(79, 41);
        sparseIntArray.append(94, 42);
        sparseIntArray.append(78, 20);
        sparseIntArray.append(93, 37);
        sparseIntArray.append(67, 5);
        sparseIntArray.append(81, 87);
        sparseIntArray.append(90, 87);
        sparseIntArray.append(84, 87);
        sparseIntArray.append(61, 87);
        sparseIntArray.append(57, 87);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(96, 95);
        sparseIntArray.append(73, 96);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(97, 54);
        sparseIntArray.append(74, 55);
        sparseIntArray.append(98, 56);
        sparseIntArray.append(75, 57);
        sparseIntArray.append(99, 58);
        sparseIntArray.append(76, 59);
        sparseIntArray.append(64, 61);
        sparseIntArray.append(66, 62);
        sparseIntArray.append(65, 63);
        sparseIntArray.append(28, 64);
        sparseIntArray.append(121, 65);
        sparseIntArray.append(35, 66);
        sparseIntArray.append(122, 67);
        sparseIntArray.append(113, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(112, 68);
        sparseIntArray.append(100, 69);
        sparseIntArray.append(77, 70);
        sparseIntArray.append(111, 97);
        sparseIntArray.append(32, 71);
        sparseIntArray.append(30, 72);
        sparseIntArray.append(31, 73);
        sparseIntArray.append(33, 74);
        sparseIntArray.append(29, 75);
        sparseIntArray.append(114, 76);
        sparseIntArray.append(89, 77);
        sparseIntArray.append(123, 78);
        sparseIntArray.append(56, 80);
        sparseIntArray.append(55, 81);
        sparseIntArray.append(116, 82);
        sparseIntArray.append(120, 83);
        sparseIntArray.append(119, 84);
        sparseIntArray.append(118, 85);
        sparseIntArray.append(117, 86);
        sparseIntArray2.append(85, 6);
        sparseIntArray2.append(85, 7);
        sparseIntArray2.append(0, 27);
        sparseIntArray2.append(89, 13);
        sparseIntArray2.append(92, 16);
        sparseIntArray2.append(90, 14);
        sparseIntArray2.append(87, 11);
        sparseIntArray2.append(91, 15);
        sparseIntArray2.append(88, 12);
        sparseIntArray2.append(78, 40);
        sparseIntArray2.append(71, 39);
        sparseIntArray2.append(70, 41);
        sparseIntArray2.append(77, 42);
        sparseIntArray2.append(69, 20);
        sparseIntArray2.append(76, 37);
        sparseIntArray2.append(60, 5);
        sparseIntArray2.append(72, 87);
        sparseIntArray2.append(75, 87);
        sparseIntArray2.append(73, 87);
        sparseIntArray2.append(57, 87);
        sparseIntArray2.append(56, 87);
        sparseIntArray2.append(5, 24);
        sparseIntArray2.append(7, 28);
        sparseIntArray2.append(23, 31);
        sparseIntArray2.append(24, 8);
        sparseIntArray2.append(6, 34);
        sparseIntArray2.append(8, 2);
        sparseIntArray2.append(3, 23);
        sparseIntArray2.append(4, 21);
        sparseIntArray2.append(79, 95);
        sparseIntArray2.append(64, 96);
        sparseIntArray2.append(2, 22);
        sparseIntArray2.append(13, 43);
        sparseIntArray2.append(26, 44);
        sparseIntArray2.append(21, 45);
        sparseIntArray2.append(22, 46);
        sparseIntArray2.append(20, 60);
        sparseIntArray2.append(18, 47);
        sparseIntArray2.append(19, 48);
        sparseIntArray2.append(14, 49);
        sparseIntArray2.append(15, 50);
        sparseIntArray2.append(16, 51);
        sparseIntArray2.append(17, 52);
        sparseIntArray2.append(25, 53);
        sparseIntArray2.append(80, 54);
        sparseIntArray2.append(65, 55);
        sparseIntArray2.append(81, 56);
        sparseIntArray2.append(66, 57);
        sparseIntArray2.append(82, 58);
        sparseIntArray2.append(67, 59);
        sparseIntArray2.append(59, 62);
        sparseIntArray2.append(58, 63);
        sparseIntArray2.append(28, 64);
        sparseIntArray2.append(105, 65);
        sparseIntArray2.append(34, 66);
        sparseIntArray2.append(106, 67);
        sparseIntArray2.append(96, 79);
        sparseIntArray2.append(1, 38);
        sparseIntArray2.append(97, 98);
        sparseIntArray2.append(95, 68);
        sparseIntArray2.append(83, 69);
        sparseIntArray2.append(68, 70);
        sparseIntArray2.append(32, 71);
        sparseIntArray2.append(30, 72);
        sparseIntArray2.append(31, 73);
        sparseIntArray2.append(33, 74);
        sparseIntArray2.append(29, 75);
        sparseIntArray2.append(98, 76);
        sparseIntArray2.append(74, 77);
        sparseIntArray2.append(107, 78);
        sparseIntArray2.append(55, 80);
        sparseIntArray2.append(54, 81);
        sparseIntArray2.append(100, 82);
        sparseIntArray2.append(104, 83);
        sparseIntArray2.append(103, 84);
        sparseIntArray2.append(102, 85);
        sparseIntArray2.append(101, 86);
        sparseIntArray2.append(94, 97);
    }

    public static int[] b(vj vjVar, String str) {
        int iIntValue;
        String[] strArrSplit = str.split(",");
        Context context = vjVar.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i = 0;
        int i2 = 0;
        while (i < strArrSplit.length) {
            String strTrim = strArrSplit[i].trim();
            Object obj = null;
            try {
                iIntValue = nc3.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && vjVar.isInEditMode() && (vjVar.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) vjVar.getParent();
                if (ha0.w(strTrim)) {
                    HashMap map = constraintLayout.G0;
                    if (map != null && map.containsKey(strTrim)) {
                        obj = constraintLayout.G0.get(strTrim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
            }
            iArr[i2] = iIntValue;
            i++;
            i2++;
        }
        return i2 != strArrSplit.length ? Arrays.copyOf(iArr, i2) : iArr;
    }

    public static vb0 c(Context context, AttributeSet attributeSet, boolean z) {
        int i;
        int i2;
        vb0 vb0Var = new vb0();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z ? wc3.c : wc3.a);
        String[] strArr = vo.C0;
        yb0 yb0Var = vb0Var.b;
        zb0 zb0Var = vb0Var.e;
        xb0 xb0Var = vb0Var.c;
        wb0 wb0Var = vb0Var.d;
        int[] iArr = c;
        SparseIntArray sparseIntArray = d;
        if (z) {
            ub0 ub0Var = new ub0();
            ub0Var.a = new int[10];
            ub0Var.b = new int[10];
            ub0Var.c = 0;
            ub0Var.d = new int[10];
            ub0Var.e = new float[10];
            ub0Var.f = 0;
            ub0Var.g = new int[5];
            ub0Var.h = new String[5];
            ub0Var.i = 0;
            ub0Var.j = new int[4];
            ub0Var.k = new boolean[4];
            ub0Var.l = 0;
            int i3 = 0;
            for (int indexCount = typedArrayObtainStyledAttributes.getIndexCount(); i3 < indexCount; indexCount = i2) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                int i4 = i3;
                switch (e.get(index)) {
                    case 2:
                        i2 = indexCount;
                        ub0Var.b(2, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.I));
                        continue;
                        i3 = i4 + 1;
                        break;
                    case 3:
                    case 4:
                    case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    case 10:
                    case 25:
                    case 26:
                    case 29:
                    case 30:
                    case 32:
                    case 33:
                    case 35:
                    case 36:
                    case 61:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    default:
                        StringBuilder sb = new StringBuilder("Unknown attribute 0x");
                        i2 = indexCount;
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(sparseIntArray.get(index));
                        a1.n("ConstraintSet", sb.toString());
                        break;
                    case 5:
                        i2 = indexCount;
                        ub0Var.c(5, typedArrayObtainStyledAttributes.getString(index));
                        continue;
                        i3 = i4 + 1;
                        break;
                    case 6:
                        i2 = indexCount;
                        ub0Var.b(6, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, wb0Var.C));
                        break;
                    case 7:
                        i2 = indexCount;
                        ub0Var.b(7, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, wb0Var.D));
                        break;
                    case 8:
                        i2 = indexCount;
                        ub0Var.b(8, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.J));
                        break;
                    case 11:
                        i2 = indexCount;
                        ub0Var.b(11, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.P));
                        break;
                    case FileClientSessionCache.MAX_SIZE /* 12 */:
                        i2 = indexCount;
                        ub0Var.b(12, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.Q));
                        break;
                    case 13:
                        i2 = indexCount;
                        ub0Var.b(13, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.M));
                        break;
                    case 14:
                        i2 = indexCount;
                        ub0Var.b(14, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.O));
                        break;
                    case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                        i2 = indexCount;
                        ub0Var.b(15, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.R));
                        break;
                    case 16:
                        i2 = indexCount;
                        ub0Var.b(16, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.N));
                        break;
                    case 17:
                        i2 = indexCount;
                        ub0Var.b(17, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, wb0Var.d));
                        break;
                    case 18:
                        i2 = indexCount;
                        ub0Var.b(18, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, wb0Var.e));
                        break;
                    case 19:
                        i2 = indexCount;
                        ub0Var.a(19, typedArrayObtainStyledAttributes.getFloat(index, wb0Var.f));
                        break;
                    case 20:
                        i2 = indexCount;
                        ub0Var.a(20, typedArrayObtainStyledAttributes.getFloat(index, wb0Var.w));
                        break;
                    case 21:
                        i2 = indexCount;
                        ub0Var.b(21, typedArrayObtainStyledAttributes.getLayoutDimension(index, wb0Var.c));
                        break;
                    case 22:
                        i2 = indexCount;
                        ub0Var.b(22, iArr[typedArrayObtainStyledAttributes.getInt(index, yb0Var.a)]);
                        break;
                    case 23:
                        i2 = indexCount;
                        ub0Var.b(23, typedArrayObtainStyledAttributes.getLayoutDimension(index, wb0Var.b));
                        break;
                    case 24:
                        i2 = indexCount;
                        ub0Var.b(24, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.F));
                        break;
                    case 27:
                        i2 = indexCount;
                        ub0Var.b(27, typedArrayObtainStyledAttributes.getInt(index, wb0Var.E));
                        break;
                    case 28:
                        i2 = indexCount;
                        ub0Var.b(28, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.G));
                        break;
                    case 31:
                        i2 = indexCount;
                        ub0Var.b(31, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.K));
                        break;
                    case 34:
                        i2 = indexCount;
                        ub0Var.b(34, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.H));
                        break;
                    case 37:
                        i2 = indexCount;
                        ub0Var.a(37, typedArrayObtainStyledAttributes.getFloat(index, wb0Var.x));
                        break;
                    case 38:
                        i2 = indexCount;
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, vb0Var.a);
                        vb0Var.a = resourceId;
                        ub0Var.b(38, resourceId);
                        break;
                    case 39:
                        i2 = indexCount;
                        ub0Var.a(39, typedArrayObtainStyledAttributes.getFloat(index, wb0Var.U));
                        break;
                    case 40:
                        i2 = indexCount;
                        ub0Var.a(40, typedArrayObtainStyledAttributes.getFloat(index, wb0Var.T));
                        break;
                    case 41:
                        i2 = indexCount;
                        ub0Var.b(41, typedArrayObtainStyledAttributes.getInt(index, wb0Var.V));
                        break;
                    case 42:
                        i2 = indexCount;
                        ub0Var.b(42, typedArrayObtainStyledAttributes.getInt(index, wb0Var.W));
                        break;
                    case 43:
                        i2 = indexCount;
                        ub0Var.a(43, typedArrayObtainStyledAttributes.getFloat(index, yb0Var.c));
                        break;
                    case 44:
                        i2 = indexCount;
                        ub0Var.d(44, true);
                        ub0Var.a(44, typedArrayObtainStyledAttributes.getDimension(index, zb0Var.m));
                        break;
                    case 45:
                        i2 = indexCount;
                        ub0Var.a(45, typedArrayObtainStyledAttributes.getFloat(index, zb0Var.b));
                        break;
                    case 46:
                        i2 = indexCount;
                        ub0Var.a(46, typedArrayObtainStyledAttributes.getFloat(index, zb0Var.c));
                        break;
                    case 47:
                        i2 = indexCount;
                        ub0Var.a(47, typedArrayObtainStyledAttributes.getFloat(index, zb0Var.d));
                        break;
                    case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                        i2 = indexCount;
                        ub0Var.a(48, typedArrayObtainStyledAttributes.getFloat(index, zb0Var.e));
                        break;
                    case 49:
                        i2 = indexCount;
                        ub0Var.a(49, typedArrayObtainStyledAttributes.getDimension(index, zb0Var.f));
                        break;
                    case 50:
                        i2 = indexCount;
                        ub0Var.a(50, typedArrayObtainStyledAttributes.getDimension(index, zb0Var.g));
                        break;
                    case 51:
                        i2 = indexCount;
                        ub0Var.a(51, typedArrayObtainStyledAttributes.getDimension(index, zb0Var.i));
                        break;
                    case 52:
                        i2 = indexCount;
                        ub0Var.a(52, typedArrayObtainStyledAttributes.getDimension(index, zb0Var.j));
                        break;
                    case 53:
                        i2 = indexCount;
                        ub0Var.a(53, typedArrayObtainStyledAttributes.getDimension(index, zb0Var.k));
                        break;
                    case 54:
                        i2 = indexCount;
                        ub0Var.b(54, typedArrayObtainStyledAttributes.getInt(index, wb0Var.X));
                        break;
                    case 55:
                        i2 = indexCount;
                        ub0Var.b(55, typedArrayObtainStyledAttributes.getInt(index, wb0Var.Y));
                        break;
                    case 56:
                        i2 = indexCount;
                        ub0Var.b(56, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.Z));
                        break;
                    case 57:
                        i2 = indexCount;
                        ub0Var.b(57, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.a0));
                        break;
                    case 58:
                        i2 = indexCount;
                        ub0Var.b(58, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.b0));
                        break;
                    case 59:
                        i2 = indexCount;
                        ub0Var.b(59, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.c0));
                        break;
                    case 60:
                        i2 = indexCount;
                        ub0Var.a(60, typedArrayObtainStyledAttributes.getFloat(index, zb0Var.a));
                        break;
                    case 62:
                        i2 = indexCount;
                        ub0Var.b(62, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.A));
                        break;
                    case 63:
                        i2 = indexCount;
                        ub0Var.a(63, typedArrayObtainStyledAttributes.getFloat(index, wb0Var.B));
                        break;
                    case 64:
                        i2 = indexCount;
                        ub0Var.b(64, e(typedArrayObtainStyledAttributes, index, xb0Var.a));
                        break;
                    case 65:
                        i2 = indexCount;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            ub0Var.c(65, typedArrayObtainStyledAttributes.getString(index));
                        } else {
                            ub0Var.c(65, strArr[typedArrayObtainStyledAttributes.getInteger(index, 0)]);
                        }
                        break;
                    case 66:
                        i2 = indexCount;
                        ub0Var.b(66, typedArrayObtainStyledAttributes.getInt(index, 0));
                        break;
                    case 67:
                        i2 = indexCount;
                        ub0Var.a(67, typedArrayObtainStyledAttributes.getFloat(index, xb0Var.e));
                        break;
                    case 68:
                        i2 = indexCount;
                        ub0Var.a(68, typedArrayObtainStyledAttributes.getFloat(index, yb0Var.d));
                        break;
                    case 69:
                        i2 = indexCount;
                        ub0Var.a(69, typedArrayObtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 70:
                        i2 = indexCount;
                        ub0Var.a(70, typedArrayObtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 71:
                        i2 = indexCount;
                        a1.d("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i2 = indexCount;
                        ub0Var.b(72, typedArrayObtainStyledAttributes.getInt(index, wb0Var.f0));
                        break;
                    case 73:
                        i2 = indexCount;
                        ub0Var.b(73, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.g0));
                        break;
                    case 74:
                        i2 = indexCount;
                        ub0Var.c(74, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case 75:
                        i2 = indexCount;
                        ub0Var.d(75, typedArrayObtainStyledAttributes.getBoolean(index, wb0Var.n0));
                        break;
                    case 76:
                        i2 = indexCount;
                        ub0Var.b(76, typedArrayObtainStyledAttributes.getInt(index, xb0Var.c));
                        break;
                    case 77:
                        i2 = indexCount;
                        ub0Var.c(77, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case 78:
                        i2 = indexCount;
                        ub0Var.b(78, typedArrayObtainStyledAttributes.getInt(index, yb0Var.b));
                        break;
                    case 79:
                        i2 = indexCount;
                        ub0Var.a(79, typedArrayObtainStyledAttributes.getFloat(index, xb0Var.d));
                        break;
                    case 80:
                        i2 = indexCount;
                        ub0Var.d(80, typedArrayObtainStyledAttributes.getBoolean(index, wb0Var.l0));
                        break;
                    case 81:
                        i2 = indexCount;
                        ub0Var.d(81, typedArrayObtainStyledAttributes.getBoolean(index, wb0Var.m0));
                        break;
                    case 82:
                        i2 = indexCount;
                        ub0Var.b(82, typedArrayObtainStyledAttributes.getInteger(index, xb0Var.b));
                        break;
                    case 83:
                        i2 = indexCount;
                        ub0Var.b(83, e(typedArrayObtainStyledAttributes, index, zb0Var.h));
                        break;
                    case 84:
                        i2 = indexCount;
                        ub0Var.b(84, typedArrayObtainStyledAttributes.getInteger(index, xb0Var.g));
                        break;
                    case 85:
                        i2 = indexCount;
                        ub0Var.a(85, typedArrayObtainStyledAttributes.getFloat(index, xb0Var.f));
                        break;
                    case 86:
                        i2 = indexCount;
                        int i5 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i5 == 1) {
                            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            xb0Var.i = resourceId2;
                            ub0Var.b(89, resourceId2);
                            if (xb0Var.i != -1) {
                                ub0Var.b(88, -2);
                            }
                        } else if (i5 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            xb0Var.h = string;
                            ub0Var.c(90, string);
                            if (xb0Var.h.indexOf("/") > 0) {
                                int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                xb0Var.i = resourceId3;
                                ub0Var.b(89, resourceId3);
                                ub0Var.b(88, -2);
                            } else {
                                ub0Var.b(88, -1);
                            }
                        } else {
                            ub0Var.b(88, typedArrayObtainStyledAttributes.getInteger(index, xb0Var.i));
                        }
                        break;
                    case 87:
                        i2 = indexCount;
                        a1.n("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                        break;
                    case 93:
                        i2 = indexCount;
                        ub0Var.b(93, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.L));
                        break;
                    case 94:
                        i2 = indexCount;
                        ub0Var.b(94, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, wb0Var.S));
                        break;
                    case 95:
                        i2 = indexCount;
                        f(ub0Var, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        i2 = indexCount;
                        f(ub0Var, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        i2 = indexCount;
                        ub0Var.b(97, typedArrayObtainStyledAttributes.getInt(index, wb0Var.o0));
                        break;
                    case 98:
                        i2 = indexCount;
                        int i6 = qm2.K0;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            vb0Var.a = typedArrayObtainStyledAttributes.getResourceId(index, vb0Var.a);
                        }
                        break;
                    case 99:
                        i2 = indexCount;
                        ub0Var.d(99, typedArrayObtainStyledAttributes.getBoolean(index, wb0Var.g));
                        break;
                }
                i3 = i4 + 1;
            }
        } else {
            int i7 = 0;
            for (int indexCount2 = typedArrayObtainStyledAttributes.getIndexCount(); i7 < indexCount2; indexCount2 = i) {
                int index2 = typedArrayObtainStyledAttributes.getIndex(i7);
                switch (sparseIntArray.get(index2)) {
                    case 1:
                        i = indexCount2;
                        wb0Var.p = e(typedArrayObtainStyledAttributes, index2, wb0Var.p);
                        continue;
                        i7++;
                        break;
                    case 2:
                        i = indexCount2;
                        wb0Var.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.I);
                        continue;
                        i7++;
                        break;
                    case 3:
                        i = indexCount2;
                        wb0Var.o = e(typedArrayObtainStyledAttributes, index2, wb0Var.o);
                        continue;
                        i7++;
                        break;
                    case 4:
                        i = indexCount2;
                        wb0Var.n = e(typedArrayObtainStyledAttributes, index2, wb0Var.n);
                        continue;
                        i7++;
                        break;
                    case 5:
                        i = indexCount2;
                        wb0Var.y = typedArrayObtainStyledAttributes.getString(index2);
                        continue;
                        i7++;
                        break;
                    case 6:
                        i = indexCount2;
                        wb0Var.C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, wb0Var.C);
                        continue;
                        i7++;
                        break;
                    case 7:
                        i = indexCount2;
                        wb0Var.D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, wb0Var.D);
                        continue;
                        i7++;
                        break;
                    case 8:
                        i = indexCount2;
                        wb0Var.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.J);
                        continue;
                        i7++;
                        break;
                    case Xlog.COMPRESS_LEVEL9 /* 9 */:
                        i = indexCount2;
                        wb0Var.v = e(typedArrayObtainStyledAttributes, index2, wb0Var.v);
                        continue;
                        i7++;
                        break;
                    case 10:
                        i = indexCount2;
                        wb0Var.u = e(typedArrayObtainStyledAttributes, index2, wb0Var.u);
                        continue;
                        i7++;
                        break;
                    case 11:
                        i = indexCount2;
                        wb0Var.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.P);
                        continue;
                        i7++;
                        break;
                    case FileClientSessionCache.MAX_SIZE /* 12 */:
                        i = indexCount2;
                        wb0Var.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.Q);
                        continue;
                        i7++;
                        break;
                    case 13:
                        i = indexCount2;
                        wb0Var.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.M);
                        continue;
                        i7++;
                        break;
                    case 14:
                        i = indexCount2;
                        wb0Var.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.O);
                        continue;
                        i7++;
                        break;
                    case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                        i = indexCount2;
                        wb0Var.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.R);
                        continue;
                        i7++;
                        break;
                    case 16:
                        i = indexCount2;
                        wb0Var.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.N);
                        continue;
                        i7++;
                        break;
                    case 17:
                        i = indexCount2;
                        wb0Var.d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, wb0Var.d);
                        continue;
                        i7++;
                        break;
                    case 18:
                        i = indexCount2;
                        wb0Var.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, wb0Var.e);
                        continue;
                        i7++;
                        break;
                    case 19:
                        i = indexCount2;
                        wb0Var.f = typedArrayObtainStyledAttributes.getFloat(index2, wb0Var.f);
                        continue;
                        i7++;
                        break;
                    case 20:
                        i = indexCount2;
                        wb0Var.w = typedArrayObtainStyledAttributes.getFloat(index2, wb0Var.w);
                        continue;
                        i7++;
                        break;
                    case 21:
                        i = indexCount2;
                        wb0Var.c = typedArrayObtainStyledAttributes.getLayoutDimension(index2, wb0Var.c);
                        continue;
                        i7++;
                        break;
                    case 22:
                        i = indexCount2;
                        int i8 = typedArrayObtainStyledAttributes.getInt(index2, yb0Var.a);
                        yb0Var.a = i8;
                        yb0Var.a = iArr[i8];
                        continue;
                        i7++;
                        break;
                    case 23:
                        i = indexCount2;
                        wb0Var.b = typedArrayObtainStyledAttributes.getLayoutDimension(index2, wb0Var.b);
                        continue;
                        i7++;
                        break;
                    case 24:
                        i = indexCount2;
                        wb0Var.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.F);
                        continue;
                        i7++;
                        break;
                    case 25:
                        i = indexCount2;
                        wb0Var.h = e(typedArrayObtainStyledAttributes, index2, wb0Var.h);
                        continue;
                        i7++;
                        break;
                    case 26:
                        i = indexCount2;
                        wb0Var.i = e(typedArrayObtainStyledAttributes, index2, wb0Var.i);
                        continue;
                        i7++;
                        break;
                    case 27:
                        i = indexCount2;
                        wb0Var.E = typedArrayObtainStyledAttributes.getInt(index2, wb0Var.E);
                        continue;
                        i7++;
                        break;
                    case 28:
                        i = indexCount2;
                        wb0Var.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.G);
                        continue;
                        i7++;
                        break;
                    case 29:
                        i = indexCount2;
                        wb0Var.j = e(typedArrayObtainStyledAttributes, index2, wb0Var.j);
                        continue;
                        i7++;
                        break;
                    case 30:
                        i = indexCount2;
                        wb0Var.k = e(typedArrayObtainStyledAttributes, index2, wb0Var.k);
                        continue;
                        i7++;
                        break;
                    case 31:
                        i = indexCount2;
                        wb0Var.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.K);
                        continue;
                        i7++;
                        break;
                    case 32:
                        i = indexCount2;
                        wb0Var.s = e(typedArrayObtainStyledAttributes, index2, wb0Var.s);
                        continue;
                        i7++;
                        break;
                    case 33:
                        i = indexCount2;
                        wb0Var.t = e(typedArrayObtainStyledAttributes, index2, wb0Var.t);
                        continue;
                        i7++;
                        break;
                    case 34:
                        i = indexCount2;
                        wb0Var.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.H);
                        continue;
                        i7++;
                        break;
                    case 35:
                        i = indexCount2;
                        wb0Var.m = e(typedArrayObtainStyledAttributes, index2, wb0Var.m);
                        continue;
                        i7++;
                        break;
                    case 36:
                        i = indexCount2;
                        wb0Var.l = e(typedArrayObtainStyledAttributes, index2, wb0Var.l);
                        continue;
                        i7++;
                        break;
                    case 37:
                        i = indexCount2;
                        wb0Var.x = typedArrayObtainStyledAttributes.getFloat(index2, wb0Var.x);
                        continue;
                        i7++;
                        break;
                    case 38:
                        i = indexCount2;
                        vb0Var.a = typedArrayObtainStyledAttributes.getResourceId(index2, vb0Var.a);
                        continue;
                        i7++;
                        break;
                    case 39:
                        i = indexCount2;
                        wb0Var.U = typedArrayObtainStyledAttributes.getFloat(index2, wb0Var.U);
                        continue;
                        i7++;
                        break;
                    case 40:
                        i = indexCount2;
                        wb0Var.T = typedArrayObtainStyledAttributes.getFloat(index2, wb0Var.T);
                        continue;
                        i7++;
                        break;
                    case 41:
                        i = indexCount2;
                        wb0Var.V = typedArrayObtainStyledAttributes.getInt(index2, wb0Var.V);
                        continue;
                        i7++;
                        break;
                    case 42:
                        i = indexCount2;
                        wb0Var.W = typedArrayObtainStyledAttributes.getInt(index2, wb0Var.W);
                        continue;
                        i7++;
                        break;
                    case 43:
                        i = indexCount2;
                        yb0Var.c = typedArrayObtainStyledAttributes.getFloat(index2, yb0Var.c);
                        continue;
                        i7++;
                        break;
                    case 44:
                        i = indexCount2;
                        zb0Var.l = true;
                        zb0Var.m = typedArrayObtainStyledAttributes.getDimension(index2, zb0Var.m);
                        continue;
                        i7++;
                        break;
                    case 45:
                        i = indexCount2;
                        zb0Var.b = typedArrayObtainStyledAttributes.getFloat(index2, zb0Var.b);
                        continue;
                        i7++;
                        break;
                    case 46:
                        i = indexCount2;
                        zb0Var.c = typedArrayObtainStyledAttributes.getFloat(index2, zb0Var.c);
                        continue;
                        i7++;
                        break;
                    case 47:
                        i = indexCount2;
                        zb0Var.d = typedArrayObtainStyledAttributes.getFloat(index2, zb0Var.d);
                        continue;
                        i7++;
                        break;
                    case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                        i = indexCount2;
                        zb0Var.e = typedArrayObtainStyledAttributes.getFloat(index2, zb0Var.e);
                        continue;
                        i7++;
                        break;
                    case 49:
                        i = indexCount2;
                        zb0Var.f = typedArrayObtainStyledAttributes.getDimension(index2, zb0Var.f);
                        continue;
                        i7++;
                        break;
                    case 50:
                        i = indexCount2;
                        zb0Var.g = typedArrayObtainStyledAttributes.getDimension(index2, zb0Var.g);
                        continue;
                        i7++;
                        break;
                    case 51:
                        i = indexCount2;
                        zb0Var.i = typedArrayObtainStyledAttributes.getDimension(index2, zb0Var.i);
                        continue;
                        i7++;
                        break;
                    case 52:
                        i = indexCount2;
                        zb0Var.j = typedArrayObtainStyledAttributes.getDimension(index2, zb0Var.j);
                        continue;
                        i7++;
                        break;
                    case 53:
                        i = indexCount2;
                        zb0Var.k = typedArrayObtainStyledAttributes.getDimension(index2, zb0Var.k);
                        continue;
                        i7++;
                        break;
                    case 54:
                        i = indexCount2;
                        wb0Var.X = typedArrayObtainStyledAttributes.getInt(index2, wb0Var.X);
                        continue;
                        i7++;
                        break;
                    case 55:
                        i = indexCount2;
                        wb0Var.Y = typedArrayObtainStyledAttributes.getInt(index2, wb0Var.Y);
                        continue;
                        i7++;
                        break;
                    case 56:
                        i = indexCount2;
                        wb0Var.Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.Z);
                        continue;
                        i7++;
                        break;
                    case 57:
                        i = indexCount2;
                        wb0Var.a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.a0);
                        continue;
                        i7++;
                        break;
                    case 58:
                        i = indexCount2;
                        wb0Var.b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.b0);
                        continue;
                        i7++;
                        break;
                    case 59:
                        i = indexCount2;
                        wb0Var.c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.c0);
                        continue;
                        i7++;
                        break;
                    case 60:
                        i = indexCount2;
                        zb0Var.a = typedArrayObtainStyledAttributes.getFloat(index2, zb0Var.a);
                        continue;
                        i7++;
                        break;
                    case 61:
                        i = indexCount2;
                        wb0Var.z = e(typedArrayObtainStyledAttributes, index2, wb0Var.z);
                        continue;
                        i7++;
                        break;
                    case 62:
                        i = indexCount2;
                        wb0Var.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.A);
                        continue;
                        i7++;
                        break;
                    case 63:
                        i = indexCount2;
                        wb0Var.B = typedArrayObtainStyledAttributes.getFloat(index2, wb0Var.B);
                        continue;
                        i7++;
                        break;
                    case 64:
                        i = indexCount2;
                        xb0Var.a = e(typedArrayObtainStyledAttributes, index2, xb0Var.a);
                        continue;
                        i7++;
                        break;
                    case 65:
                        i = indexCount2;
                        if (typedArrayObtainStyledAttributes.peekValue(index2).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index2);
                        } else {
                            String str = strArr[typedArrayObtainStyledAttributes.getInteger(index2, 0)];
                            i7++;
                        }
                        break;
                    case 66:
                        i = indexCount2;
                        typedArrayObtainStyledAttributes.getInt(index2, 0);
                        continue;
                        i7++;
                        break;
                    case 67:
                        i = indexCount2;
                        xb0Var.e = typedArrayObtainStyledAttributes.getFloat(index2, xb0Var.e);
                        break;
                    case 68:
                        i = indexCount2;
                        yb0Var.d = typedArrayObtainStyledAttributes.getFloat(index2, yb0Var.d);
                        break;
                    case 69:
                        i = indexCount2;
                        wb0Var.d0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 70:
                        i = indexCount2;
                        wb0Var.e0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 71:
                        i = indexCount2;
                        a1.d("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i = indexCount2;
                        wb0Var.f0 = typedArrayObtainStyledAttributes.getInt(index2, wb0Var.f0);
                        break;
                    case 73:
                        i = indexCount2;
                        wb0Var.g0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.g0);
                        break;
                    case 74:
                        i = indexCount2;
                        wb0Var.j0 = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 75:
                        i = indexCount2;
                        wb0Var.n0 = typedArrayObtainStyledAttributes.getBoolean(index2, wb0Var.n0);
                        break;
                    case 76:
                        i = indexCount2;
                        xb0Var.c = typedArrayObtainStyledAttributes.getInt(index2, xb0Var.c);
                        break;
                    case 77:
                        i = indexCount2;
                        wb0Var.k0 = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 78:
                        i = indexCount2;
                        yb0Var.b = typedArrayObtainStyledAttributes.getInt(index2, yb0Var.b);
                        break;
                    case 79:
                        i = indexCount2;
                        xb0Var.d = typedArrayObtainStyledAttributes.getFloat(index2, xb0Var.d);
                        break;
                    case 80:
                        i = indexCount2;
                        wb0Var.l0 = typedArrayObtainStyledAttributes.getBoolean(index2, wb0Var.l0);
                        break;
                    case 81:
                        i = indexCount2;
                        wb0Var.m0 = typedArrayObtainStyledAttributes.getBoolean(index2, wb0Var.m0);
                        break;
                    case 82:
                        i = indexCount2;
                        xb0Var.b = typedArrayObtainStyledAttributes.getInteger(index2, xb0Var.b);
                        break;
                    case 83:
                        i = indexCount2;
                        zb0Var.h = e(typedArrayObtainStyledAttributes, index2, zb0Var.h);
                        break;
                    case 84:
                        i = indexCount2;
                        xb0Var.g = typedArrayObtainStyledAttributes.getInteger(index2, xb0Var.g);
                        break;
                    case 85:
                        i = indexCount2;
                        xb0Var.f = typedArrayObtainStyledAttributes.getFloat(index2, xb0Var.f);
                        break;
                    case 86:
                        i = indexCount2;
                        int i9 = typedArrayObtainStyledAttributes.peekValue(index2).type;
                        if (i9 == 1) {
                            xb0Var.i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                        } else if (i9 == 3) {
                            String string2 = typedArrayObtainStyledAttributes.getString(index2);
                            xb0Var.h = string2;
                            if (string2.indexOf("/") > 0) {
                                xb0Var.i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                            }
                        } else {
                            typedArrayObtainStyledAttributes.getInteger(index2, xb0Var.i);
                        }
                        break;
                    case 87:
                        i = indexCount2;
                        a1.n("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index2) + "   " + sparseIntArray.get(index2));
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        StringBuilder sb2 = new StringBuilder("Unknown attribute 0x");
                        i = indexCount2;
                        sb2.append(Integer.toHexString(index2));
                        sb2.append("   ");
                        sb2.append(sparseIntArray.get(index2));
                        a1.n("ConstraintSet", sb2.toString());
                        break;
                    case 91:
                        i = indexCount2;
                        wb0Var.q = e(typedArrayObtainStyledAttributes, index2, wb0Var.q);
                        break;
                    case 92:
                        i = indexCount2;
                        wb0Var.r = e(typedArrayObtainStyledAttributes, index2, wb0Var.r);
                        break;
                    case 93:
                        i = indexCount2;
                        wb0Var.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.L);
                        break;
                    case 94:
                        i = indexCount2;
                        wb0Var.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, wb0Var.S);
                        break;
                    case 95:
                        i = indexCount2;
                        f(wb0Var, typedArrayObtainStyledAttributes, index2, 0);
                        continue;
                        i7++;
                        break;
                    case 96:
                        i = indexCount2;
                        f(wb0Var, typedArrayObtainStyledAttributes, index2, 1);
                        break;
                    case 97:
                        i = indexCount2;
                        wb0Var.o0 = typedArrayObtainStyledAttributes.getInt(index2, wb0Var.o0);
                        break;
                }
                i7++;
            }
            if (wb0Var.j0 != null) {
                wb0Var.i0 = null;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return vb0Var;
    }

    public static int e(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(Object obj, TypedArray typedArray, int i, int i2) {
        int dimensionPixelSize;
        int i3 = typedArray.peekValue(i).type;
        boolean z = true;
        int i4 = 0;
        if (i3 == 3) {
            String string = typedArray.getString(i);
            if (string == null) {
                return;
            }
            int iIndexOf = string.indexOf(61);
            int length = string.length();
            if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                return;
            }
            String strSubstring = string.substring(0, iIndexOf);
            String strSubstring2 = string.substring(iIndexOf + 1);
            if (strSubstring2.length() > 0) {
                String strTrim = strSubstring.trim();
                String strTrim2 = strSubstring2.trim();
                if ("ratio".equalsIgnoreCase(strTrim)) {
                    if (obj instanceof qb0) {
                        qb0 qb0Var = (qb0) obj;
                        if (i2 == 0) {
                            ((ViewGroup.MarginLayoutParams) qb0Var).width = 0;
                        } else {
                            ((ViewGroup.MarginLayoutParams) qb0Var).height = 0;
                        }
                        g(qb0Var, strTrim2);
                        return;
                    }
                    if (obj instanceof wb0) {
                        ((wb0) obj).y = strTrim2;
                        return;
                    } else {
                        if (obj instanceof ub0) {
                            ((ub0) obj).c(5, strTrim2);
                            return;
                        }
                        return;
                    }
                }
                try {
                    if ("weight".equalsIgnoreCase(strTrim)) {
                        float f = Float.parseFloat(strTrim2);
                        if (obj instanceof qb0) {
                            qb0 qb0Var2 = (qb0) obj;
                            if (i2 == 0) {
                                ((ViewGroup.MarginLayoutParams) qb0Var2).width = 0;
                                qb0Var2.H = f;
                                return;
                            } else {
                                ((ViewGroup.MarginLayoutParams) qb0Var2).height = 0;
                                qb0Var2.I = f;
                                return;
                            }
                        }
                        if (obj instanceof wb0) {
                            wb0 wb0Var = (wb0) obj;
                            if (i2 == 0) {
                                wb0Var.b = 0;
                                wb0Var.U = f;
                                return;
                            } else {
                                wb0Var.c = 0;
                                wb0Var.T = f;
                                return;
                            }
                        }
                        if (obj instanceof ub0) {
                            ub0 ub0Var = (ub0) obj;
                            if (i2 == 0) {
                                ub0Var.b(23, 0);
                                ub0Var.a(39, f);
                                return;
                            } else {
                                ub0Var.b(21, 0);
                                ub0Var.a(40, f);
                                return;
                            }
                        }
                        return;
                    }
                    if ("parent".equalsIgnoreCase(strTrim)) {
                        float fMax = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(strTrim2)));
                        if (obj instanceof qb0) {
                            qb0 qb0Var3 = (qb0) obj;
                            if (i2 == 0) {
                                ((ViewGroup.MarginLayoutParams) qb0Var3).width = 0;
                                qb0Var3.R = fMax;
                                qb0Var3.L = 2;
                                return;
                            } else {
                                ((ViewGroup.MarginLayoutParams) qb0Var3).height = 0;
                                qb0Var3.S = fMax;
                                qb0Var3.M = 2;
                                return;
                            }
                        }
                        if (obj instanceof wb0) {
                            wb0 wb0Var2 = (wb0) obj;
                            if (i2 == 0) {
                                wb0Var2.b = 0;
                                wb0Var2.d0 = fMax;
                                wb0Var2.X = 2;
                                return;
                            } else {
                                wb0Var2.c = 0;
                                wb0Var2.e0 = fMax;
                                wb0Var2.Y = 2;
                                return;
                            }
                        }
                        if (obj instanceof ub0) {
                            ub0 ub0Var2 = (ub0) obj;
                            if (i2 == 0) {
                                ub0Var2.b(23, 0);
                                ub0Var2.b(54, 2);
                                return;
                            } else {
                                ub0Var2.b(21, 0);
                                ub0Var2.b(55, 2);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                } catch (NumberFormatException unused) {
                    return;
                }
            }
            return;
        }
        if (i3 != 5) {
            dimensionPixelSize = typedArray.getInt(i, 0);
            if (dimensionPixelSize == -4) {
                i4 = -2;
            } else if (dimensionPixelSize == -3 || (dimensionPixelSize != -2 && dimensionPixelSize != -1)) {
                z = false;
            }
            if (!(obj instanceof qb0)) {
                qb0 qb0Var4 = (qb0) obj;
                if (i2 == 0) {
                    ((ViewGroup.MarginLayoutParams) qb0Var4).width = i4;
                    qb0Var4.W = z;
                    return;
                } else {
                    ((ViewGroup.MarginLayoutParams) qb0Var4).height = i4;
                    qb0Var4.X = z;
                    return;
                }
            }
            if (obj instanceof wb0) {
                wb0 wb0Var3 = (wb0) obj;
                if (i2 == 0) {
                    wb0Var3.b = i4;
                    wb0Var3.l0 = z;
                    return;
                } else {
                    wb0Var3.c = i4;
                    wb0Var3.m0 = z;
                    return;
                }
            }
            if (obj instanceof ub0) {
                ub0 ub0Var3 = (ub0) obj;
                if (i2 == 0) {
                    ub0Var3.b(23, i4);
                    ub0Var3.d(80, z);
                    return;
                } else {
                    ub0Var3.b(21, i4);
                    ub0Var3.d(81, z);
                    return;
                }
            }
            return;
        }
        dimensionPixelSize = typedArray.getDimensionPixelSize(i, 0);
        z = false;
        i4 = dimensionPixelSize;
        if (!(obj instanceof qb0)) {
        }
    }

    public static void g(qb0 qb0Var, String str) {
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i = -1;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                i = strSubstring.equalsIgnoreCase("W") ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : -1;
                i = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i);
                    if (strSubstring2.length() > 0) {
                        Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f = Float.parseFloat(strSubstring3);
                        float f2 = Float.parseFloat(strSubstring4);
                        if (f > 0.0f && f2 > 0.0f) {
                            if (i == 1) {
                                Math.abs(f2 / f);
                            } else {
                                Math.abs(f / f2);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        qb0Var.G = str;
    }

    public final void a(Context context, int i) {
        ConstraintLayout constraintLayout;
        int i2;
        HashMap map;
        int i3;
        int i4;
        ac0 ac0Var = this;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        int childCount = constraintLayout2.getChildCount();
        HashMap map2 = ac0Var.b;
        map2.clear();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = constraintLayout2.getChildAt(i5);
            qb0 qb0Var = (qb0) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id == -1) {
                zo2.w("All children of ConstraintLayout must have ids to use ConstraintSet");
                return;
            }
            if (!map2.containsKey(Integer.valueOf(id))) {
                map2.put(Integer.valueOf(id), new vb0());
            }
            vb0 vb0Var = (vb0) map2.get(Integer.valueOf(id));
            if (vb0Var == null) {
                constraintLayout = constraintLayout2;
                i2 = childCount;
                map = map2;
                i3 = i5;
            } else {
                yb0 yb0Var = vb0Var.b;
                wb0 wb0Var = vb0Var.d;
                zb0 zb0Var = vb0Var.e;
                constraintLayout = constraintLayout2;
                HashMap map3 = new HashMap();
                i2 = childCount;
                Class<?> cls = childAt.getClass();
                map = map2;
                HashMap map4 = ac0Var.a;
                for (String str : map4.keySet()) {
                    mb0 mb0Var = (mb0) map4.get(str);
                    HashMap map5 = map4;
                    try {
                        if (str.equals("BackgroundColor")) {
                            i4 = i5;
                            try {
                                map3.put(str, new mb0(mb0Var, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                            } catch (IllegalAccessException e2) {
                                e = e2;
                                StringBuilder sbD = fw.D(" Custom Attribute \"", str, "\" not found on ");
                                sbD.append(cls.getName());
                                a1.e("TransitionLayout", sbD.toString(), e);
                            } catch (NoSuchMethodException e3) {
                                e = e3;
                                a1.e("TransitionLayout", cls.getName() + " must have a method " + str, e);
                            } catch (InvocationTargetException e4) {
                                e = e4;
                                StringBuilder sbD2 = fw.D(" Custom Attribute \"", str, "\" not found on ");
                                sbD2.append(cls.getName());
                                a1.e("TransitionLayout", sbD2.toString(), e);
                            }
                        } else {
                            i4 = i5;
                            map3.put(str, new mb0(mb0Var, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                        }
                    } catch (IllegalAccessException e5) {
                        e = e5;
                        i4 = i5;
                    } catch (NoSuchMethodException e6) {
                        e = e6;
                        i4 = i5;
                    } catch (InvocationTargetException e7) {
                        e = e7;
                        i4 = i5;
                    }
                    map4 = map5;
                    i5 = i4;
                }
                i3 = i5;
                vb0Var.f = map3;
                vb0Var.a = id;
                wb0Var.h = qb0Var.e;
                wb0Var.i = qb0Var.f;
                wb0Var.j = qb0Var.g;
                wb0Var.k = qb0Var.h;
                wb0Var.l = qb0Var.i;
                wb0Var.m = qb0Var.j;
                wb0Var.n = qb0Var.k;
                wb0Var.o = qb0Var.l;
                wb0Var.p = qb0Var.m;
                wb0Var.q = qb0Var.n;
                wb0Var.r = qb0Var.o;
                wb0Var.s = qb0Var.s;
                wb0Var.t = qb0Var.t;
                wb0Var.u = qb0Var.u;
                wb0Var.v = qb0Var.v;
                wb0Var.w = qb0Var.E;
                wb0Var.x = qb0Var.F;
                wb0Var.y = qb0Var.G;
                wb0Var.z = qb0Var.p;
                wb0Var.A = qb0Var.q;
                wb0Var.B = qb0Var.r;
                wb0Var.C = qb0Var.T;
                wb0Var.D = qb0Var.U;
                wb0Var.E = qb0Var.V;
                wb0Var.f = qb0Var.c;
                wb0Var.d = qb0Var.a;
                wb0Var.e = qb0Var.b;
                wb0Var.b = ((ViewGroup.MarginLayoutParams) qb0Var).width;
                wb0Var.c = ((ViewGroup.MarginLayoutParams) qb0Var).height;
                wb0Var.F = ((ViewGroup.MarginLayoutParams) qb0Var).leftMargin;
                wb0Var.G = ((ViewGroup.MarginLayoutParams) qb0Var).rightMargin;
                wb0Var.H = ((ViewGroup.MarginLayoutParams) qb0Var).topMargin;
                wb0Var.I = ((ViewGroup.MarginLayoutParams) qb0Var).bottomMargin;
                wb0Var.L = qb0Var.D;
                wb0Var.T = qb0Var.I;
                wb0Var.U = qb0Var.H;
                wb0Var.W = qb0Var.K;
                wb0Var.V = qb0Var.J;
                wb0Var.l0 = qb0Var.W;
                wb0Var.m0 = qb0Var.X;
                wb0Var.X = qb0Var.L;
                wb0Var.Y = qb0Var.M;
                wb0Var.Z = qb0Var.P;
                wb0Var.a0 = qb0Var.Q;
                wb0Var.b0 = qb0Var.N;
                wb0Var.c0 = qb0Var.O;
                wb0Var.d0 = qb0Var.R;
                wb0Var.e0 = qb0Var.S;
                wb0Var.k0 = qb0Var.Y;
                wb0Var.N = qb0Var.x;
                wb0Var.P = qb0Var.z;
                wb0Var.M = qb0Var.w;
                wb0Var.O = qb0Var.y;
                wb0Var.R = qb0Var.A;
                wb0Var.Q = qb0Var.B;
                wb0Var.S = qb0Var.C;
                wb0Var.o0 = qb0Var.Z;
                wb0Var.J = qb0Var.getMarginEnd();
                wb0Var.K = qb0Var.getMarginStart();
                yb0Var.a = childAt.getVisibility();
                yb0Var.c = childAt.getAlpha();
                zb0Var.a = childAt.getRotation();
                zb0Var.b = childAt.getRotationX();
                zb0Var.c = childAt.getRotationY();
                zb0Var.d = childAt.getScaleX();
                zb0Var.e = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    zb0Var.f = pivotX;
                    zb0Var.g = pivotY;
                }
                zb0Var.i = childAt.getTranslationX();
                zb0Var.j = childAt.getTranslationY();
                zb0Var.k = childAt.getTranslationZ();
                if (zb0Var.l) {
                    zb0Var.m = childAt.getElevation();
                }
                if (childAt instanceof vj) {
                    vj vjVar = (vj) childAt;
                    wb0Var.n0 = vjVar.getAllowsGoneWidget();
                    wb0Var.i0 = vjVar.getReferencedIds();
                    wb0Var.f0 = vjVar.getType();
                    wb0Var.g0 = vjVar.getMargin();
                }
            }
            i5 = i3 + 1;
            ac0Var = this;
            constraintLayout2 = constraintLayout;
            childCount = i2;
            map2 = map;
        }
    }

    public final void d(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    vb0 vb0VarC = c(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        vb0VarC.d.a = true;
                    }
                    this.b.put(Integer.valueOf(vb0VarC.a), vb0VarC);
                }
            }
        } catch (IOException e2) {
            a1.e("ConstraintSet", "Error parsing resource: " + i, e2);
        } catch (XmlPullParserException e3) {
            a1.e("ConstraintSet", "Error parsing resource: " + i, e3);
        }
    }
}
