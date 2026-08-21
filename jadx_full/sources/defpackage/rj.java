package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import com.getsurfboard.R;
import io.netty.handler.codec.dns.DnsRecord;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rj {
    public final qj a;
    public final qj b = new qj();
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final int i;
    public final int j;
    public final int k;
    public int l;

    public rj(Context context, qj qjVar) {
        AttributeSet attributeSetAsAttributeSet;
        int styleAttribute;
        int next;
        qjVar = qjVar == null ? new qj() : qjVar;
        int i = qjVar.b;
        if (i != 0) {
            try {
                XmlResourceParser xml = context.getResources().getXml(i);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                if (!TextUtils.equals(xml.getName(), "badge")) {
                    throw new XmlPullParserException("Must have a <" + ((Object) "badge") + "> start tag");
                }
                attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                styleAttribute = attributeSetAsAttributeSet.getStyleAttribute();
            } catch (IOException | XmlPullParserException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            }
        } else {
            attributeSetAsAttributeSet = null;
            styleAttribute = 0;
        }
        TypedArray typedArrayV = fx3.v(context, attributeSetAsAttributeSet, rc3.c, R.attr.badgeStyle, styleAttribute == 0 ? R.style.Widget_MaterialComponents_Badge : styleAttribute, new int[0]);
        Resources resources = context.getResources();
        this.c = typedArrayV.getDimensionPixelSize(5, -1);
        this.i = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_horizontal_edge_offset);
        this.j = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_text_horizontal_edge_offset);
        this.d = typedArrayV.getDimensionPixelSize(15, -1);
        this.e = typedArrayV.getDimension(13, resources.getDimension(R.dimen.m3_badge_size));
        this.g = typedArrayV.getDimension(18, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.f = typedArrayV.getDimension(4, resources.getDimension(R.dimen.m3_badge_size));
        this.h = typedArrayV.getDimension(14, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.k = typedArrayV.getInt(25, 1);
        this.l = typedArrayV.getInt(2, 0);
        qj qjVar2 = this.b;
        int i2 = qjVar.z0;
        qjVar2.z0 = i2 == -2 ? DnsRecord.CLASS_ANY : i2;
        int i3 = qjVar.B0;
        if (i3 != -2) {
            qjVar2.B0 = i3;
        } else {
            boolean zHasValue = typedArrayV.hasValue(24);
            qj qjVar3 = this.b;
            if (zHasValue) {
                qjVar3.B0 = typedArrayV.getInt(24, 0);
            } else {
                qjVar3.B0 = -1;
            }
        }
        String str = qjVar.A0;
        if (str != null) {
            this.b.A0 = str;
        } else if (typedArrayV.hasValue(8)) {
            this.b.A0 = typedArrayV.getString(8);
        }
        qj qjVar4 = this.b;
        qjVar4.F0 = qjVar.F0;
        CharSequence charSequence = qjVar.G0;
        qjVar4.G0 = charSequence == null ? context.getString(R.string.mtrl_badge_numberless_content_description) : charSequence;
        qj qjVar5 = this.b;
        int i4 = qjVar.H0;
        qjVar5.H0 = i4 == 0 ? R.plurals.mtrl_badge_content_description : i4;
        int i5 = qjVar.I0;
        qjVar5.I0 = i5 == 0 ? R.string.mtrl_exceed_max_badge_number_content_description : i5;
        Boolean bool = qjVar.K0;
        qjVar5.K0 = Boolean.valueOf(bool == null || bool.booleanValue());
        qj qjVar6 = this.b;
        int i6 = qjVar.C0;
        qjVar6.C0 = i6 == -2 ? typedArrayV.getInt(22, -2) : i6;
        qj qjVar7 = this.b;
        int i7 = qjVar.D0;
        qjVar7.D0 = i7 == -2 ? typedArrayV.getInt(23, -2) : i7;
        qj qjVar8 = this.b;
        Integer num = qjVar.X;
        qjVar8.X = Integer.valueOf(num == null ? typedArrayV.getResourceId(6, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num.intValue());
        qj qjVar9 = this.b;
        Integer num2 = qjVar.Y;
        qjVar9.Y = Integer.valueOf(num2 == null ? typedArrayV.getResourceId(7, 0) : num2.intValue());
        qj qjVar10 = this.b;
        Integer num3 = qjVar.Z;
        qjVar10.Z = Integer.valueOf(num3 == null ? typedArrayV.getResourceId(16, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num3.intValue());
        qj qjVar11 = this.b;
        Integer num4 = qjVar.y0;
        qjVar11.y0 = Integer.valueOf(num4 == null ? typedArrayV.getResourceId(17, 0) : num4.intValue());
        qj qjVar12 = this.b;
        Integer num5 = qjVar.f;
        qjVar12.f = Integer.valueOf(num5 == null ? l72.r(context, typedArrayV, 1).getDefaultColor() : num5.intValue());
        qj qjVar13 = this.b;
        Integer num6 = qjVar.A;
        qjVar13.A = Integer.valueOf(num6 == null ? typedArrayV.getResourceId(9, R.style.TextAppearance_MaterialComponents_Badge) : num6.intValue());
        Integer num7 = qjVar.z;
        if (num7 != null) {
            this.b.z = num7;
        } else {
            boolean zHasValue2 = typedArrayV.hasValue(10);
            qj qjVar14 = this.b;
            if (zHasValue2) {
                qjVar14.z = Integer.valueOf(l72.r(context, typedArrayV, 10).getDefaultColor());
            } else {
                this.b.z = Integer.valueOf(new kb4(context, qjVar14.A.intValue()).k.getDefaultColor());
            }
        }
        qj qjVar15 = this.b;
        Integer num8 = qjVar.J0;
        qjVar15.J0 = Integer.valueOf(num8 == null ? typedArrayV.getInt(3, 8388661) : num8.intValue());
        qj qjVar16 = this.b;
        Integer num9 = qjVar.L0;
        qjVar16.L0 = Integer.valueOf(num9 == null ? typedArrayV.getDimensionPixelSize(12, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding)) : num9.intValue());
        qj qjVar17 = this.b;
        Integer num10 = qjVar.M0;
        qjVar17.M0 = Integer.valueOf(num10 == null ? typedArrayV.getDimensionPixelSize(11, resources.getDimensionPixelSize(R.dimen.m3_badge_with_text_vertical_padding)) : num10.intValue());
        qj qjVar18 = this.b;
        Integer num11 = qjVar.N0;
        qjVar18.N0 = Integer.valueOf(num11 == null ? typedArrayV.getDimensionPixelOffset(19, 0) : num11.intValue());
        qj qjVar19 = this.b;
        Integer num12 = qjVar.O0;
        qjVar19.O0 = Integer.valueOf(num12 == null ? typedArrayV.getDimensionPixelOffset(26, 0) : num12.intValue());
        qj qjVar20 = this.b;
        Integer num13 = qjVar.P0;
        qjVar20.P0 = Integer.valueOf(num13 == null ? typedArrayV.getDimensionPixelOffset(20, qjVar20.N0.intValue()) : num13.intValue());
        qj qjVar21 = this.b;
        Integer num14 = qjVar.Q0;
        qjVar21.Q0 = Integer.valueOf(num14 == null ? typedArrayV.getDimensionPixelOffset(27, qjVar21.O0.intValue()) : num14.intValue());
        qj qjVar22 = this.b;
        Integer num15 = qjVar.T0;
        qjVar22.T0 = Integer.valueOf(num15 == null ? typedArrayV.getDimensionPixelOffset(21, 0) : num15.intValue());
        qj qjVar23 = this.b;
        Integer num16 = qjVar.R0;
        qjVar23.R0 = Integer.valueOf(num16 == null ? 0 : num16.intValue());
        qj qjVar24 = this.b;
        Integer num17 = qjVar.S0;
        qjVar24.S0 = Integer.valueOf(num17 == null ? 0 : num17.intValue());
        qj qjVar25 = this.b;
        Boolean bool2 = qjVar.U0;
        qjVar25.U0 = Boolean.valueOf(bool2 == null ? typedArrayV.getBoolean(0, false) : bool2.booleanValue());
        typedArrayV.recycle();
        Locale locale = qjVar.E0;
        qj qjVar26 = this.b;
        if (locale == null) {
            qjVar26.E0 = Build.VERSION.SDK_INT >= 24 ? Locale.getDefault(Locale.Category.FORMAT) : Locale.getDefault();
        } else {
            qjVar26.E0 = locale;
        }
        this.a = qjVar;
    }
}
