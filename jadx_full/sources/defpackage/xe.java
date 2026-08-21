package defpackage;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.fragment.app.o;
import io.netty.util.AsciiString;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class xe implements i43, ny1, st2 {
    public final /* synthetic */ int b;

    public /* synthetic */ xe(ed4 ed4Var) {
        this.b = 21;
    }

    public static /* synthetic */ void d(int i, String str) {
        throw new IllegalStateException(str + i);
    }

    public static /* synthetic */ void f(int i, StringBuilder sb) {
        sb.append(i);
        sb.append(')');
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public static /* synthetic */ void g(o oVar, String str) {
        throw new IllegalStateException(str + ((Object) oVar.toString()) + ((Object) " is already attached to a FragmentManager."));
    }

    public static /* synthetic */ void h(AsciiString asciiString) {
        throw new NumberFormatException(asciiString.toString());
    }

    public static /* synthetic */ void i(Object obj) {
        throw new AssertionError(obj);
    }

    public static /* synthetic */ void j(Object obj, String str) {
        throw new l52(str + ((Object) obj.toString()));
    }

    public static /* synthetic */ void k(String str) {
        throw new IllegalArgumentException(str);
    }

    public static /* synthetic */ void l(String str, Object obj, Object obj2) {
        throw new IllegalStateException(str + obj + obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(String str, Object obj, Object obj2, Object obj3, int i) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3 + ((char) i));
    }

    public static /* synthetic */ void n(StringBuilder sb, Object obj) {
        sb.append(obj);
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void q(String str) {
        throw new IllegalStateException(str);
    }

    public static /* synthetic */ void r(String str, Object obj, Object obj2) {
        throw new IllegalArgumentException(str + obj + obj2);
    }

    @Override // defpackage.st2
    public Object a() {
        switch (this.b) {
            case 26:
                return new pb2(true);
            case 27:
                return new LinkedHashMap();
            case 28:
                return new TreeMap();
            default:
                return new ConcurrentHashMap();
        }
    }

    @Override // defpackage.i43
    public void e(j74 j74Var) {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(j74Var.b.getWidth(), j74Var.b.getHeight());
        surfaceTexture.detachFromGLContext();
        Surface surface = new Surface(surfaceTexture);
        j74Var.a(surface, yu0.a(), new g00(0, surface, surfaceTexture));
    }

    @Override // defpackage.ny1
    public void o(oy1 oy1Var) throws Exception {
        try {
            my1 my1VarI = oy1Var.i();
            if (my1VarI != null) {
                co4.h();
                ez4.a0("CaptureNode", "Discarding ImageProxy which was inadvertently acquired: " + my1VarI);
                my1VarI.close();
            }
        } catch (IllegalStateException unused) {
        }
    }

    public /* synthetic */ xe(int i) {
        this.b = i;
    }
}
