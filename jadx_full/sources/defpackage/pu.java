package defpackage;

import android.graphics.Bitmap;
import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pu {
    public final cm2 a;
    public final ou b;
    public final Date c;
    public final String d;
    public final Date e;
    public final String f;
    public final Date g;
    public final long h;
    public final long i;
    public final String j;
    public final int k;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0042 A[PHI: r7
      0x0042: PHI (r7v3 int) = (r7v1 int), (r7v1 int), (r7v5 int) binds: [B:9:0x0038, B:11:0x0040, B:31:0x009a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public pu(cm2 cm2Var, ou ouVar) {
        int i;
        Date date;
        DateFormat simpleDateFormat;
        this.a = cm2Var;
        this.b = ouVar;
        this.k = -1;
        if (ouVar != null) {
            this.h = ouVar.c;
            this.i = ouVar.d;
            lr1 lr1Var = ouVar.f;
            int size = lr1Var.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                String strZ = gb4.z(lr1Var, i3);
                if (strZ.equalsIgnoreCase("Date")) {
                    String strA = lr1Var.a("Date");
                    if (strA != null) {
                        uj0 uj0Var = vj0.a;
                        if (strA.length() == 0) {
                            date = null;
                            this.c = date;
                            this.d = gb4.B(lr1Var, i3);
                        } else {
                            ParsePosition parsePosition = new ParsePosition(i2);
                            Date date2 = ((DateFormat) vj0.a.get()).parse(strA, parsePosition);
                            if (parsePosition.getIndex() == strA.length()) {
                                date = date2;
                            } else {
                                String[] strArr = vj0.b;
                                synchronized (strArr) {
                                    try {
                                        int length = strArr.length;
                                        for (int i4 = i2; i4 < length; i4++) {
                                            DateFormat[] dateFormatArr = vj0.c;
                                            DateFormat dateFormat = dateFormatArr[i4];
                                            if (dateFormat == null) {
                                                simpleDateFormat = new SimpleDateFormat(vj0.b[i4], Locale.US);
                                                simpleDateFormat.setTimeZone(jz4.a);
                                                dateFormatArr[i4] = simpleDateFormat;
                                                i2 = 0;
                                            } else {
                                                simpleDateFormat = dateFormat;
                                            }
                                            parsePosition.setIndex(i2);
                                            Date date3 = simpleDateFormat.parse(strA, parsePosition);
                                            if (parsePosition.getIndex() != 0) {
                                                date = date3;
                                                break;
                                            }
                                        }
                                        date = null;
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                            this.c = date;
                            this.d = gb4.B(lr1Var, i3);
                        }
                    }
                } else if (strZ.equalsIgnoreCase("Expires")) {
                    this.g = lr1Var.b("Expires");
                } else if (strZ.equalsIgnoreCase("Last-Modified")) {
                    this.e = lr1Var.b("Last-Modified");
                    this.f = gb4.B(lr1Var, i3);
                } else if (strZ.equalsIgnoreCase(HttpHeaders.Names.ETAG)) {
                    this.j = gb4.B(lr1Var, i3);
                } else if (strZ.equalsIgnoreCase(HttpHeaders.Names.AGE)) {
                    String strB = gb4.B(lr1Var, i3);
                    Bitmap.Config config = j.a;
                    Long lN0 = w44.n0(strB);
                    if (lN0 != null) {
                        long jLongValue = lN0.longValue();
                        i = jLongValue > 2147483647L ? ChannelUtils.WRITE_STATUS_SNDBUF_FULL : jLongValue < 0 ? i2 : (int) jLongValue;
                    } else {
                        i = -1;
                    }
                    this.k = i;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final qu a() {
        ou ouVar;
        long jMax;
        String string;
        long time;
        Date date;
        long millis;
        int i;
        cm2 cm2Var = this.a;
        ev1 ev1Var = (ev1) cm2Var.f;
        ou ouVar2 = this.b;
        if (ouVar2 == null) {
            return new qu(cm2Var, null);
        }
        z82 z82Var = ouVar2.a;
        if (ev1Var.f() && !ouVar2.e) {
            return new qu(cm2Var, null);
        }
        ku kuVar = (ku) z82Var.getValue();
        if (cm2Var.e().b || ((ku) z82Var.getValue()).b || n12.c(ouVar2.f.a("Vary"), WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
            return new qu(cm2Var, null);
        }
        ku kuVarE = cm2Var.e();
        if (!kuVarE.a) {
            lr1 lr1Var = (lr1) cm2Var.A;
            String str = "If-Modified-Since";
            if (lr1Var.a("If-Modified-Since") == null && lr1Var.a(HttpHeaders.Names.IF_NONE_MATCH) == null) {
                long time2 = this.i;
                Date date2 = this.c;
                if (date2 != null) {
                    ouVar = ouVar2;
                    jMax = Math.max(0L, time2 - date2.getTime());
                } else {
                    ouVar = ouVar2;
                    jMax = 0;
                }
                TimeUnit timeUnit = TimeUnit.SECONDS;
                int i2 = this.k;
                if (i2 != -1) {
                    jMax = Math.max(jMax, timeUnit.toMillis(i2));
                }
                long time3 = this.h;
                long jLongValue = jMax + (time2 - time3) + (((Number) be4.a.a()).longValue() - time2);
                int i3 = ((ku) z82Var.getValue()).c;
                Date date3 = this.e;
                if (i3 != -1) {
                    time = timeUnit.toMillis(i3);
                } else {
                    Date date4 = this.g;
                    if (date4 != null) {
                        if (date2 != null) {
                            time2 = date2.getTime();
                        }
                        time = date4.getTime() - time2;
                        if (time <= 0) {
                            time = 0;
                        }
                    } else if (date3 != null) {
                        List list = ev1Var.g;
                        if (list == null) {
                            string = null;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            n12.V(list, sb);
                            string = sb.toString();
                        }
                        if (string == null) {
                            if (date2 != null) {
                                time3 = date2.getTime();
                            }
                            long time4 = time3 - date3.getTime();
                            if (time4 > 0) {
                                time = time4 / 10;
                            }
                        }
                    }
                }
                int i4 = kuVarE.c;
                if (i4 != -1) {
                    time = Math.min(time, timeUnit.toMillis(i4));
                }
                int i5 = kuVarE.i;
                long millis2 = i5 != -1 ? timeUnit.toMillis(i5) : 0L;
                if (kuVar.g || (i = kuVarE.h) == -1) {
                    date = date3;
                    millis = 0;
                } else {
                    date = date3;
                    millis = timeUnit.toMillis(i);
                }
                if (!kuVar.a && jLongValue + millis2 < time + millis) {
                    return new qu(null, ouVar);
                }
                ou ouVar3 = ouVar;
                String str2 = this.j;
                if (str2 != null) {
                    str = HttpHeaders.Names.IF_NONE_MATCH;
                } else if (date != null) {
                    str2 = this.f;
                    str2.getClass();
                } else {
                    if (date2 == null) {
                        return new qu(cm2Var, null);
                    }
                    str2 = this.d;
                    str2.getClass();
                }
                v92 v92VarW = cm2Var.w();
                m20 m20Var = (m20) v92VarW.z;
                m20Var.getClass();
                gb4.O(str);
                gb4.P(str2, str);
                gb4.x(m20Var, str, str2);
                return new qu(new cm2(v92VarW), ouVar3);
            }
        }
        return new qu(cm2Var, null);
    }
}
