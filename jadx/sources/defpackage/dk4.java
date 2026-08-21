package defpackage;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class dk4 {
    public static final uf2 a;
    public static final if2 b;
    public static Paint c;

    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    static {
        /*
            java.lang.String r0 = "TypefaceCompat static init"
            java.lang.String r0 = defpackage.vo.O(r0)
            android.os.Trace.beginSection(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            r2 = 23
            if (r0 < r1) goto L19
            jk4 r0 = new jk4
            r0.<init>(r2)
            defpackage.dk4.a = r0
            goto L5d
        L19:
            r1 = 29
            if (r0 < r1) goto L25
            ik4 r0 = new ik4
            r0.<init>(r2)
            defpackage.dk4.a = r0
            goto L5d
        L25:
            r1 = 28
            if (r0 < r1) goto L31
            hk4 r0 = new hk4
            r0.<init>()
            defpackage.dk4.a = r0
            goto L5d
        L31:
            r1 = 26
            if (r0 < r1) goto L3d
            gk4 r0 = new gk4
            r0.<init>()
            defpackage.dk4.a = r0
            goto L5d
        L3d:
            r1 = 24
            if (r0 < r1) goto L56
            java.lang.reflect.Method r0 = defpackage.fk4.C0
            if (r0 != 0) goto L4c
            java.lang.String r1 = "TypefaceCompatApi24Impl"
            java.lang.String r3 = "Unable to collect necessary private methods.Fallback to legacy implementation."
            io.sentry.android.core.a1.n(r1, r3)
        L4c:
            if (r0 == 0) goto L56
            fk4 r0 = new fk4
            r0.<init>(r2)
            defpackage.dk4.a = r0
            goto L5d
        L56:
            ek4 r0 = new ek4
            r0.<init>(r2)
            defpackage.dk4.a = r0
        L5d:
            if2 r0 = new if2
            r1 = 16
            r0.<init>(r1)
            defpackage.dk4.b = r0
            r0 = 0
            defpackage.dk4.c = r0
            android.os.Trace.endSection()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dk4.<clinit>():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e7, code lost:
    
        r7 = r12.build();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface a(android.content.Context r16, defpackage.gi1 r17, android.content.res.Resources r18, int r19, java.lang.String r20, int r21, int r22, defpackage.ji0 r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 650
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dk4.a(android.content.Context, gi1, android.content.res.Resources, int, java.lang.String, int, int, ji0, boolean):android.graphics.Typeface");
    }

    public static String b(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }

    public static Typeface c(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface typefaceCreate = Typeface.create(str, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate != null && !typefaceCreate.equals(typefaceCreate2)) {
                return typefaceCreate;
            }
        }
        return null;
    }

    public static Font d(Typeface typeface) {
        Paint paint = c;
        if (paint == null) {
            paint = new Paint();
            c = paint;
        }
        paint.setTextSize(10.0f);
        c.setTypeface(typeface);
        PositionedGlyphs positionedGlyphsShapeTextRun = TextRunShaper.shapeTextRun((CharSequence) " ", 0, 1, 0, 1, 0.0f, 0.0f, false, c);
        if (positionedGlyphsShapeTextRun.glyphCount() == 0) {
            return null;
        }
        return positionedGlyphsShapeTextRun.getFont(0);
    }
}
