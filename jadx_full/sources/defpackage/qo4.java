package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a1;
import java.io.IOException;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qo4 extends ho4 {
    public static final PorterDuff.Mode A0 = PorterDuff.Mode.SRC_IN;
    public ColorFilter A;
    public boolean X;
    public boolean Y;
    public final float[] Z;
    public oo4 f;
    public final Matrix y0;
    public PorterDuffColorFilter z;
    public final Rect z0;

    public qo4() {
        this.Y = true;
        this.Z = new float[9];
        this.y0 = new Matrix();
        this.z0 = new Rect();
        oo4 oo4Var = new oo4();
        oo4Var.c = null;
        oo4Var.d = A0;
        oo4Var.b = new no4();
        this.f = oo4Var;
    }

    public static qo4 a(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            qo4 qo4Var = new qo4();
            ThreadLocal threadLocal = hk3.a;
            qo4Var.b = resources.getDrawable(i, theme);
            new po4(qo4Var.b.getConstantState());
            return qo4Var;
        }
        try {
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
            qo4 qo4Var2 = new qo4();
            qo4Var2.inflate(resources, xml, attributeSetAsAttributeSet, theme);
            return qo4Var2;
        } catch (IOException e) {
            a1.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (XmlPullParserException e2) {
            a1.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public final PorterDuffColorFilter b(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.b;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.z0;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.A;
        if (colorFilter == null) {
            colorFilter = this.z;
        }
        Matrix matrix = this.y0;
        canvas.getMatrix(matrix);
        float[] fArr = this.Z;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, (int) (rect.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && getLayoutDirection() == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        oo4 oo4Var = this.f;
        Bitmap bitmap = oo4Var.f;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != oo4Var.f.getHeight()) {
            oo4Var.f = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            oo4Var.k = true;
        }
        boolean z = this.Y;
        oo4 oo4Var2 = this.f;
        if (!z) {
            oo4Var2.f.eraseColor(0);
            Canvas canvas2 = new Canvas(oo4Var2.f);
            no4 no4Var = oo4Var2.b;
            no4Var.a(no4Var.g, no4.p, canvas2, iMin, iMin2);
        } else if (oo4Var2.k || oo4Var2.g != oo4Var2.c || oo4Var2.h != oo4Var2.d || oo4Var2.j != oo4Var2.e || oo4Var2.i != oo4Var2.b.getRootAlpha()) {
            oo4 oo4Var3 = this.f;
            oo4Var3.f.eraseColor(0);
            Canvas canvas3 = new Canvas(oo4Var3.f);
            no4 no4Var2 = oo4Var3.b;
            no4Var2.a(no4Var2.g, no4.p, canvas3, iMin, iMin2);
            oo4 oo4Var4 = this.f;
            oo4Var4.g = oo4Var4.c;
            oo4Var4.h = oo4Var4.d;
            oo4Var4.i = oo4Var4.b.getRootAlpha();
            oo4Var4.j = oo4Var4.e;
            oo4Var4.k = false;
        }
        oo4 oo4Var5 = this.f;
        if (oo4Var5.b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (oo4Var5.l == null) {
                Paint paint2 = new Paint();
                oo4Var5.l = paint2;
                paint2.setFilterBitmap(true);
            }
            oo4Var5.l.setAlpha(oo4Var5.b.getRootAlpha());
            oo4Var5.l.setColorFilter(colorFilter);
            paint = oo4Var5.l;
        }
        canvas.drawBitmap(oo4Var5.f, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getAlpha() : this.f.b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.f.getChangingConfigurations() | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getColorFilter() : this.A;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.b != null && Build.VERSION.SDK_INT >= 24) {
            return new po4(this.b.getConstantState());
        }
        this.f.a = getChangingConfigurations();
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f.b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f.b.h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i;
        char c;
        int i2;
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        oo4 oo4Var = this.f;
        oo4Var.b = new no4();
        TypedArray typedArrayO = l72.O(resources, theme, attributeSet, vo.b);
        oo4 oo4Var2 = this.f;
        no4 no4Var = oo4Var2.b;
        int i3 = !l72.G(xmlPullParser, "tintMode") ? -1 : typedArrayO.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (i3 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i3 != 5) {
            if (i3 != 9) {
                switch (i3) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        oo4Var2.d = mode;
        ColorStateList colorStateListA = null;
        int i4 = 1;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "tint") != null) {
            TypedValue typedValue = new TypedValue();
            typedArrayO.getValue(1, typedValue);
            int i5 = typedValue.type;
            if (i5 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i5 < 28 || i5 > 31) {
                Resources resources2 = typedArrayO.getResources();
                int resourceId = typedArrayO.getResourceId(1, 0);
                ThreadLocal threadLocal = t70.a;
                try {
                    colorStateListA = t70.a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e) {
                    a1.e("CSLCompat", "Failed to inflate ColorStateList.", e);
                }
            } else {
                colorStateListA = ColorStateList.valueOf(typedValue.data);
            }
        }
        ColorStateList colorStateList = colorStateListA;
        if (colorStateList != null) {
            oo4Var2.c = colorStateList;
        }
        boolean z = oo4Var2.e;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "autoMirrored") != null) {
            z = typedArrayO.getBoolean(5, z);
        }
        oo4Var2.e = z;
        float f = no4Var.j;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportWidth") != null) {
            f = typedArrayO.getFloat(7, f);
        }
        no4Var.j = f;
        float f2 = no4Var.k;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportHeight") != null) {
            f2 = typedArrayO.getFloat(8, f2);
        }
        no4Var.k = f2;
        if (no4Var.j <= 0.0f) {
            throw new XmlPullParserException(typedArrayO.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f2 <= 0.0f) {
            throw new XmlPullParserException(typedArrayO.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        no4Var.h = typedArrayO.getDimension(3, no4Var.h);
        float dimension = typedArrayO.getDimension(2, no4Var.i);
        no4Var.i = dimension;
        if (no4Var.h <= 0.0f) {
            throw new XmlPullParserException(typedArrayO.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArrayO.getPositionDescription() + "<vector> tag requires height > 0");
        }
        float alpha = no4Var.getAlpha();
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "alpha") != null) {
            alpha = typedArrayO.getFloat(4, alpha);
        }
        no4Var.setAlpha(alpha);
        String string = typedArrayO.getString(0);
        if (string != null) {
            no4Var.m = string;
            no4Var.o.put(string, no4Var);
        }
        typedArrayO.recycle();
        oo4Var.a = getChangingConfigurations();
        oo4Var.k = true;
        oo4 oo4Var3 = this.f;
        no4 no4Var2 = oo4Var3.b;
        ArrayDeque arrayDeque = new ArrayDeque();
        ko4 ko4Var = no4Var2.g;
        ie ieVar = no4Var2.o;
        arrayDeque.push(ko4Var);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z2 = true;
        while (eventType != i4 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                ko4 ko4Var2 = (ko4) arrayDeque.peek();
                i = depth;
                if ("path".equals(name)) {
                    jo4 jo4Var = new jo4();
                    jo4Var.e = 0.0f;
                    jo4Var.g = 1.0f;
                    jo4Var.h = 1.0f;
                    jo4Var.i = 0.0f;
                    jo4Var.j = 1.0f;
                    jo4Var.k = 0.0f;
                    Paint.Cap cap = Paint.Cap.BUTT;
                    jo4Var.l = cap;
                    Paint.Join join = Paint.Join.MITER;
                    jo4Var.m = join;
                    jo4Var.n = 4.0f;
                    TypedArray typedArrayO2 = l72.O(resources, theme, attributeSet, vo.z);
                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                        String string2 = typedArrayO2.getString(0);
                        if (string2 != null) {
                            jo4Var.b = string2;
                        }
                        String string3 = typedArrayO2.getString(2);
                        if (string3 != null) {
                            jo4Var.a = n12.s(string3);
                        }
                        jo4Var.f = l72.x(typedArrayO2, xmlPullParser, theme, "fillColor", 1);
                        float f3 = jo4Var.h;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillAlpha") != null) {
                            f3 = typedArrayO2.getFloat(12, f3);
                        }
                        jo4Var.h = f3;
                        int i6 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineCap") != null ? typedArrayO2.getInt(8, -1) : -1;
                        jo4Var.l = i6 != 0 ? i6 != 1 ? i6 != 2 ? jo4Var.l : Paint.Cap.SQUARE : Paint.Cap.ROUND : cap;
                        int i7 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineJoin") != null ? typedArrayO2.getInt(9, -1) : -1;
                        jo4Var.m = i7 != 0 ? i7 != 1 ? i7 != 2 ? jo4Var.m : Paint.Join.BEVEL : Paint.Join.ROUND : join;
                        float f4 = jo4Var.n;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeMiterLimit") != null) {
                            f4 = typedArrayO2.getFloat(10, f4);
                        }
                        jo4Var.n = f4;
                        jo4Var.d = l72.x(typedArrayO2, xmlPullParser, theme, "strokeColor", 3);
                        float f5 = jo4Var.g;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeAlpha") != null) {
                            f5 = typedArrayO2.getFloat(11, f5);
                        }
                        jo4Var.g = f5;
                        float f6 = jo4Var.e;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeWidth") != null) {
                            f6 = typedArrayO2.getFloat(4, f6);
                        }
                        jo4Var.e = f6;
                        float f7 = jo4Var.j;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathEnd") != null) {
                            f7 = typedArrayO2.getFloat(6, f7);
                        }
                        jo4Var.j = f7;
                        float f8 = jo4Var.k;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathOffset") != null) {
                            f8 = typedArrayO2.getFloat(7, f8);
                        }
                        jo4Var.k = f8;
                        float f9 = jo4Var.i;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathStart") != null) {
                            f9 = typedArrayO2.getFloat(5, f9);
                        }
                        jo4Var.i = f9;
                        int i8 = jo4Var.c;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillType") != null) {
                            i8 = typedArrayO2.getInt(13, i8);
                        }
                        jo4Var.c = i8;
                    }
                    typedArrayO2.recycle();
                    ko4Var2.b.add(jo4Var);
                    if (jo4Var.getPathName() != null) {
                        ieVar.put(jo4Var.getPathName(), jo4Var);
                    }
                    oo4Var3.a = oo4Var3.a;
                    z2 = false;
                    c = '\b';
                } else {
                    c = '\b';
                    if ("clip-path".equals(name)) {
                        io4 io4Var = new io4();
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                            TypedArray typedArrayO3 = l72.O(resources, theme, attributeSet, vo.A);
                            String string4 = typedArrayO3.getString(0);
                            if (string4 != null) {
                                io4Var.b = string4;
                            }
                            String string5 = typedArrayO3.getString(1);
                            if (string5 != null) {
                                io4Var.a = n12.s(string5);
                            }
                            io4Var.c = !l72.G(xmlPullParser, "fillType") ? 0 : typedArrayO3.getInt(2, 0);
                            typedArrayO3.recycle();
                        }
                        ko4Var2.b.add(io4Var);
                        if (io4Var.getPathName() != null) {
                            ieVar.put(io4Var.getPathName(), io4Var);
                        }
                        oo4Var3.a = oo4Var3.a;
                    } else if ("group".equals(name)) {
                        ko4 ko4Var3 = new ko4();
                        TypedArray typedArrayO4 = l72.O(resources, theme, attributeSet, vo.f);
                        float f10 = ko4Var3.c;
                        if (l72.G(xmlPullParser, "rotation")) {
                            f10 = typedArrayO4.getFloat(5, f10);
                        }
                        ko4Var3.c = f10;
                        ko4Var3.d = typedArrayO4.getFloat(1, ko4Var3.d);
                        ko4Var3.e = typedArrayO4.getFloat(2, ko4Var3.e);
                        float f11 = ko4Var3.f;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleX") != null) {
                            f11 = typedArrayO4.getFloat(3, f11);
                        }
                        ko4Var3.f = f11;
                        float f12 = ko4Var3.g;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleY") != null) {
                            f12 = typedArrayO4.getFloat(4, f12);
                        }
                        ko4Var3.g = f12;
                        float f13 = ko4Var3.h;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateX") != null) {
                            f13 = typedArrayO4.getFloat(6, f13);
                        }
                        ko4Var3.h = f13;
                        float f14 = ko4Var3.i;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateY") != null) {
                            f14 = typedArrayO4.getFloat(7, f14);
                        }
                        ko4Var3.i = f14;
                        String string6 = typedArrayO4.getString(0);
                        if (string6 != null) {
                            ko4Var3.k = string6;
                        }
                        ko4Var3.c();
                        typedArrayO4.recycle();
                        ko4Var2.b.add(ko4Var3);
                        arrayDeque.push(ko4Var3);
                        if (ko4Var3.getGroupName() != null) {
                            ieVar.put(ko4Var3.getGroupName(), ko4Var3);
                        }
                        oo4Var3.a = oo4Var3.a;
                    }
                }
                i2 = 1;
            } else {
                i = depth;
                c = '\b';
                i2 = 1;
                if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                    arrayDeque.pop();
                }
            }
            eventType = xmlPullParser.next();
            i4 = i2;
            depth = i;
        }
        if (z2) {
            throw new XmlPullParserException("no path defined");
        }
        this.z = b(oo4Var.c, oo4Var.d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.b;
        return drawable != null ? drawable.isAutoMirrored() : this.f.e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        oo4 oo4Var = this.f;
        if (oo4Var == null) {
            return false;
        }
        no4 no4Var = oo4Var.b;
        Boolean boolValueOf = no4Var.n;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(no4Var.g.a());
            no4Var.n = boolValueOf;
        }
        if (boolValueOf.booleanValue()) {
            return true;
        }
        ColorStateList colorStateList = this.f.c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.X && super.mutate() == this) {
            oo4 oo4Var = this.f;
            oo4 oo4Var2 = new oo4();
            oo4Var2.c = null;
            oo4Var2.d = A0;
            if (oo4Var != null) {
                oo4Var2.a = oo4Var.a;
                no4 no4Var = new no4(oo4Var.b);
                oo4Var2.b = no4Var;
                if (oo4Var.b.e != null) {
                    no4Var.e = new Paint(oo4Var.b.e);
                }
                if (oo4Var.b.d != null) {
                    oo4Var2.b.d = new Paint(oo4Var.b.d);
                }
                oo4Var2.c = oo4Var.c;
                oo4Var2.d = oo4Var.d;
                oo4Var2.e = oo4Var.e;
            }
            this.f = oo4Var2;
            this.X = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        Drawable drawable = this.b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        oo4 oo4Var = this.f;
        ColorStateList colorStateList = oo4Var.c;
        if (colorStateList == null || (mode = oo4Var.d) == null) {
            z = false;
        } else {
            this.z = b(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        no4 no4Var = oo4Var.b;
        Boolean boolValueOf = no4Var.n;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(no4Var.g.a());
            no4Var.n = boolValueOf;
        }
        if (boolValueOf.booleanValue()) {
            boolean zB = oo4Var.b.g.b(iArr);
            oo4Var.k |= zB;
            if (zB) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f.b.getRootAlpha() != i) {
            this.f.b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.f.e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.A = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setTint(i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
            return;
        }
        oo4 oo4Var = this.f;
        if (oo4Var.c != colorStateList) {
            oo4Var.c = colorStateList;
            this.z = b(colorStateList, oo4Var.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.setTintMode(mode);
            return;
        }
        oo4 oo4Var = this.f;
        if (oo4Var.d != mode) {
            oo4Var.d = mode;
            this.z = b(oo4Var.c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.b;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public qo4(oo4 oo4Var) {
        this.Y = true;
        this.Z = new float[9];
        this.y0 = new Matrix();
        this.z0 = new Rect();
        this.f = oo4Var;
        this.z = b(oo4Var.c, oo4Var.d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }
}
