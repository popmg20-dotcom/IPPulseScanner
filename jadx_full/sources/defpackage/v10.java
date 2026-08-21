package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.a;
import androidx.fragment.app.u;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.MainActivity;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.d;
import io.sentry.android.replay.screenshot.b;
import io.sentry.android.replay.util.g;
import io.sentry.android.replay.v;
import io.sentry.p5;
import io.sentry.p6;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v10 extends r82 implements pl1 {
    public final /* synthetic */ int f;
    public final /* synthetic */ Object z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v10(int i, Object obj) {
        super(0);
        this.f = i;
        this.z = obj;
    }

    @Override // defpackage.pl1
    public final Object a() {
        switch (this.f) {
            case 0:
                z10 z10Var = (z10) this.z;
                Stack stack = z10Var.h;
                if (!stack.isEmpty() && (stack.peek() instanceof SubMenu)) {
                    Object objPop = stack.pop();
                    objPop.getClass();
                    z10Var.a(((b54) objPop).A, false);
                }
                return xl4.a;
            case 1:
                Object obj = be1.d;
                File file = (File) this.z;
                synchronized (obj) {
                    be1.c.remove(file.getAbsolutePath());
                }
                return xl4.a;
            case 2:
                qp1 qp1Var = (qp1) this.z;
                try {
                    u parentFragmentManager = qp1Var.getParentFragmentManager();
                    parentFragmentManager.getClass();
                    a aVar = new a(parentFragmentManager);
                    aVar.j(qp1Var);
                    aVar.l(false, pp1.f);
                    aVar.e();
                    break;
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
                return xl4.a;
            case 3:
                return (ImageView) ((tk2) this.z).u.findViewById(R.id.icon);
            case 4:
                File file2 = (File) ((ig0) this.z).a();
                if (!le1.S(file2).equals("preferences_pb")) {
                    ad0.j("File extension for file: ", file2, " does not match required extension for Preferences file: preferences_pb");
                    return null;
                }
                File absoluteFile = file2.getAbsoluteFile();
                absoluteFile.getClass();
                return absoluteFile;
            case 5:
                lk3 lk3Var = (lk3) this.z;
                qt qtVar = lk3Var.c;
                if (qtVar != null && qtVar.b / 100 != 2) {
                    return g41.b;
                }
                ArrayList arrayList = lk3Var.d;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    if (((i83) obj2).b.b / 100 == 2) {
                        arrayList2.add(obj2);
                    }
                }
                ArrayList arrayList3 = new ArrayList(f70.Q(10, arrayList2));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(((i83) it.next()).a);
                }
                return f70.R(arrayList3);
            case 6:
                View viewInflate = View.inflate((MainActivity) ((v62) this.z).f, R.layout.splash_screen_view, null);
                if (viewInflate != null) {
                    return (ViewGroup) viewInflate;
                }
                zo2.n("null cannot be cast to non-null type android.view.ViewGroup");
                return null;
            case 7:
                ((io.sentry.android.replay.u) this.z).A.set(true);
                return xl4.a;
            case 8:
                Matrix matrix = new Matrix();
                v vVar = ((b) this.z).d;
                matrix.preScale(vVar.c, vVar.d);
                return matrix;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new Canvas((Bitmap) ((g) this.z).b.getValue());
            default:
                d dVar = (d) this.z;
                io.sentry.android.replay.video.a aVar2 = (io.sentry.android.replay.video.a) dVar.b;
                p6 p6Var = (p6) dVar.a;
                String str = aVar2.f;
                int iIntValue = aVar2.e;
                try {
                    MediaCodecInfo.VideoCapabilities videoCapabilities = ((MediaCodec) dVar.c).getCodecInfo().getCapabilitiesForType(str).getVideoCapabilities();
                    if (videoCapabilities != null && !videoCapabilities.getBitrateRange().contains(Integer.valueOf(iIntValue))) {
                        p6Var.getLogger().h(p5.DEBUG, "Encoder doesn't support the provided bitRate: " + iIntValue + ", the value will be clamped to the closest one", new Object[0]);
                        Object objClamp = videoCapabilities.getBitrateRange().clamp(Integer.valueOf(iIntValue));
                        objClamp.getClass();
                        iIntValue = ((Number) objClamp).intValue();
                    }
                    break;
                } catch (Throwable th) {
                    p6Var.getLogger().d(p5.DEBUG, "Could not retrieve MediaCodec info", th);
                }
                MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(str, aVar2.b, aVar2.c);
                mediaFormatCreateVideoFormat.getClass();
                mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
                mediaFormatCreateVideoFormat.setInteger("bitrate", iIntValue);
                mediaFormatCreateVideoFormat.setFloat("frame-rate", aVar2.d);
                mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 6);
                return mediaFormatCreateVideoFormat;
        }
    }
}
