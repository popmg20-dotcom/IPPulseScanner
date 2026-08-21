package defpackage;

import android.os.Handler;
import android.os.Looper;
import io.sentry.util.k;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uj0 extends ThreadLocal {
    public final /* synthetic */ int a;

    public /* synthetic */ uj0(int i) {
        this.a = i;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.a) {
            case 0:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(jz4.a);
                return simpleDateFormat;
            case 1:
                return new Random();
            case 2:
                return new jq3();
            case 3:
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    return vf2.q();
                }
                if (Looper.myLooper() != null) {
                    return new xq1(new Handler(Looper.myLooper()));
                }
                return null;
            case 4:
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(257).order(ByteOrder.nativeOrder());
                byteBufferOrder.getClass();
                return byteBufferOrder;
            case 5:
                return qb4.b;
            case 6:
                return new char[1024];
            case 7:
                return new DecimalFormat("#.################", DecimalFormatSymbols.getInstance(Locale.ROOT));
            case 8:
                return new k();
            default:
                return 0L;
        }
    }
}
