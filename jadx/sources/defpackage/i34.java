package defpackage;

import java.util.Calendar;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i34 extends l34 {
    public final int z;

    public i34(int i, Class cls) {
        super(cls, 0);
        this.z = i;
    }

    @Override // defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        String strValueOf;
        switch (this.z) {
            case 1:
                Date date = (Date) obj;
                gt3Var.getClass();
                if (!gt3Var.b.h(dt3.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
                    i52Var.Q(gt3Var.d().format(date));
                } else {
                    i52Var.Q(String.valueOf(date.getTime()));
                }
                break;
            case 2:
                long timeInMillis = ((Calendar) obj).getTimeInMillis();
                gt3Var.getClass();
                if (!gt3Var.b.h(dt3.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
                    i52Var.Q(gt3Var.d().format(new Date(timeInMillis)));
                } else {
                    i52Var.Q(String.valueOf(timeInMillis));
                }
                break;
            case 3:
                i52Var.Q(((Class) obj).getName());
                break;
            case 4:
                if (gt3Var.b.h(dt3.WRITE_ENUMS_USING_TO_STRING)) {
                    strValueOf = obj.toString();
                } else {
                    Enum r11 = (Enum) obj;
                    strValueOf = gt3Var.b.h(dt3.WRITE_ENUM_KEYS_USING_INDEX) ? String.valueOf(r11.ordinal()) : r11.name();
                }
                i52Var.Q(strValueOf);
                break;
            case 5:
            case 6:
                long jLongValue = ((Number) obj).longValue();
                i52Var.getClass();
                i52Var.Q(Long.toString(jLongValue));
                break;
            case 7:
                yj yjVar = gt3Var.b.f.Z;
                byte[] bArr = (byte[]) obj;
                char[] cArr = yjVar.f;
                int i = yjVar.Y;
                int length = bArr.length;
                StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
                int i2 = i >> 2;
                int i3 = length - 3;
                int i4 = 0;
                while (true) {
                    int i5 = i2;
                    while (i4 <= i3) {
                        int i6 = i4 + 2;
                        int i7 = ((bArr[i4 + 1] & 255) | (bArr[i4] << 8)) << 8;
                        i4 += 3;
                        int i8 = i7 | (bArr[i6] & 255);
                        sb.append(cArr[(i8 >> 18) & 63]);
                        sb.append(cArr[(i8 >> 12) & 63]);
                        sb.append(cArr[(i8 >> 6) & 63]);
                        sb.append(cArr[i8 & 63]);
                        i5--;
                        if (i5 <= 0) {
                        }
                        break;
                    }
                    int i9 = length - i4;
                    if (i9 > 0) {
                        int i10 = i4 + 1;
                        int i11 = bArr[i4] << 16;
                        if (i9 == 2) {
                            i11 |= (bArr[i10] & 255) << 8;
                        }
                        char c = yjVar.X;
                        sb.append(cArr[(i11 >> 18) & 63]);
                        sb.append(cArr[(i11 >> 12) & 63]);
                        if (yjVar.Z) {
                            sb.append(i9 == 2 ? cArr[(i11 >> 6) & 63] : c);
                            sb.append(c);
                        } else if (i9 == 2) {
                            sb.append(cArr[(i11 >> 6) & 63]);
                        }
                    }
                    i52Var.Q(sb.toString());
                    sb.append("\\n");
                }
                break;
            default:
                i52Var.Q(obj.toString());
                break;
        }
    }
}
