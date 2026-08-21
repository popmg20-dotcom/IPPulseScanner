package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.getsurfboard.R;
import j$.util.Objects;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p24 implements nu3 {
    public final int a;
    public final ou3 b;
    public final int[][] c;
    public final ou3[] d;

    public p24(lw2 lw2Var) {
        this.a = lw2Var.b;
        this.b = (ou3) lw2Var.c;
        this.c = (int[][]) lw2Var.d;
        this.d = (ou3[]) lw2Var.e;
    }

    public static p24 f(Context context, TypedArray typedArray, int i) {
        XmlResourceParser xml;
        int next;
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0 || !Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return null;
        }
        lw2 lw2Var = new lw2((byte) 0, 7);
        lw2Var.c = new ou3();
        lw2Var.d = new int[10][];
        lw2Var.e = new ou3[10];
        try {
            xml = context.getResources().getXml(resourceId);
        } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
            lw2Var.c = new ou3();
            lw2Var.d = new int[10][];
            lw2Var.e = new ou3[10];
        }
        try {
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
            if (xml.getName().equals("selector")) {
                g(lw2Var, context, xml, attributeSetAsAttributeSet, context.getTheme());
            }
            xml.close();
            if (lw2Var.b == 0) {
                return null;
            }
            return new p24(lw2Var);
        } catch (Throwable th) {
            if (xml != null) {
                try {
                    xml.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void g(lw2 lw2Var, Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlResourceParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth && xmlResourceParser.getName().equals("item")) {
                Resources resources = context.getResources();
                int[] iArr = rc3.z;
                TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                ou3 ou3VarB = ou3.f(context, typedArrayObtainAttributes.getResourceId(0, 0), typedArrayObtainAttributes.getResourceId(1, 0)).b();
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i = 0;
                for (int i2 = 0; i2 < attributeCount; i2++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i2);
                    if (attributeNameResource != R.attr.shapeAppearance && attributeNameResource != R.attr.shapeAppearanceOverlay) {
                        int i3 = i + 1;
                        if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i] = attributeNameResource;
                        i = i3;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i);
                int i4 = lw2Var.b;
                if (i4 == 0 || iArrTrimStateSet.length == 0) {
                    lw2Var.c = ou3VarB;
                }
                int[][] iArr3 = (int[][]) lw2Var.d;
                if (i4 >= iArr3.length) {
                    int i5 = i4 + 10;
                    int[][] iArr4 = new int[i5][];
                    System.arraycopy(iArr3, 0, iArr4, 0, i4);
                    lw2Var.d = iArr4;
                    ou3[] ou3VarArr = new ou3[i5];
                    System.arraycopy((ou3[]) lw2Var.e, 0, ou3VarArr, 0, i4);
                    lw2Var.e = ou3VarArr;
                }
                int[][] iArr5 = (int[][]) lw2Var.d;
                int i6 = lw2Var.b;
                iArr5[i6] = iArrTrimStateSet;
                ((ou3[]) lw2Var.e)[i6] = ou3VarB;
                lw2Var.b = i6 + 1;
            }
        }
    }

    @Override // defpackage.nu3
    public final ou3 a(float f) {
        return this.b.a(f);
    }

    @Override // defpackage.nu3
    public final ou3 b(int[] iArr) {
        int i;
        int i2;
        int[][] iArr2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = -1;
            i2 = this.a;
            iArr2 = this.c;
            if (i4 >= i2) {
                i4 = -1;
                break;
            }
            if (StateSet.stateSetMatches(iArr2[i4], iArr)) {
                break;
            }
            i4++;
        }
        if (i4 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                if (StateSet.stateSetMatches(iArr2[i3], iArr3)) {
                    i = i3;
                    break;
                }
                i3++;
            }
            i4 = i;
        }
        return this.d[i4];
    }

    @Override // defpackage.nu3
    public final ou3[] c() {
        return this.d;
    }

    @Override // defpackage.nu3
    public final ou3 d() {
        return this.b;
    }

    @Override // defpackage.nu3
    public final boolean e() {
        return this.a > 1;
    }
}
