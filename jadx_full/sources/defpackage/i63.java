package defpackage;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.tencent.mars.xlog.Xlog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i63 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public final /* synthetic */ boolean Y;
    public final /* synthetic */ Object Z;
    public final /* synthetic */ Object y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i63(ProfileEditorActivity profileEditorActivity, Uri uri, boolean z, ge0 ge0Var) {
        super(2, ge0Var);
        this.X = 0;
        this.Z = profileEditorActivity;
        this.y0 = uri;
        this.Y = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) throws IOException {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
            case 0:
                return ((i63) n(ge0Var, lf0Var)).p(xl4Var);
            case 1:
                ((i63) n(ge0Var, lf0Var)).p(xl4Var);
                return xl4Var;
            default:
                return ((i63) n(ge0Var, lf0Var)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.y0;
        Object obj3 = this.Z;
        switch (i) {
            case 0:
                return new i63((ProfileEditorActivity) obj3, (Uri) obj2, this.Y, ge0Var);
            case 1:
                return new i63((b84) obj3, this.Y, (List) obj2, ge0Var, 1);
            default:
                return new i63((e24) obj3, this.Y, (List) obj2, ge0Var, 2);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) throws IOException {
        BufferedReader bufferedReader;
        String strT;
        Object tk3Var;
        String str;
        final int i = 1;
        final int i2 = 0;
        switch (this.X) {
            case 0:
                n12.S(obj);
                InputStream inputStreamOpenInputStream = ((ProfileEditorActivity) this.Z).getContentResolver().openInputStream((Uri) this.y0);
                boolean z = this.Y;
                try {
                    if (inputStreamOpenInputStream == null) {
                        throw new IllegalArgumentException("Failed to open input stream");
                    }
                    if (z) {
                        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStreamOpenInputStream);
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, y30.a), 8192);
                            try {
                                strT = l72.T(bufferedReader);
                                bufferedReader.close();
                                gZIPInputStream.close();
                            } finally {
                            }
                        } finally {
                        }
                    } else {
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenInputStream, y30.a), 8192);
                        try {
                            strT = l72.T(bufferedReader);
                            bufferedReader.close();
                        } finally {
                        }
                    }
                    inputStreamOpenInputStream.close();
                    return strT;
                } finally {
                }
            case 1:
                n12.S(obj);
                b84 b84Var = (b84) this.Z;
                boolean z2 = this.Y;
                List list = (List) this.y0;
                final t6 t6Var = new t6(b84Var.requireContext());
                p6 p6Var = (p6) t6Var.z;
                p6Var.g = p6Var.a.getText(R.string.media_file_saved_to_gallery);
                p6Var.l = p6Var.a.getText(R.string.i_got_it);
                p6Var.m = null;
                if (list.size() == 1) {
                    final Uri uri = (Uri) d70.d0(list);
                    final String str2 = z2 ? "image/jpeg" : "video/mp4";
                    DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: x74
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            int i4 = i2;
                            String str3 = str2;
                            Uri uri2 = uri;
                            t6 t6Var2 = t6Var;
                            switch (i4) {
                                case 0:
                                    try {
                                        ((p6) t6Var2.z).a.startActivity(Intent.createChooser(new Intent("android.intent.action.VIEW").setDataAndType(uri2, str3), ContextUtilsKt.k(R.string.view)));
                                    } catch (ActivityNotFoundException e) {
                                        e.printStackTrace();
                                        String message = e.getMessage();
                                        if (message == null) {
                                            message = ContextUtilsKt.k(R.string.unknown_error);
                                        }
                                        p95.D(message);
                                    }
                                    break;
                                default:
                                    try {
                                        ((p6) t6Var2.z).a.startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").putExtra("android.intent.extra.STREAM", uri2).setType(str3), ContextUtilsKt.k(R.string.share)));
                                    } catch (ActivityNotFoundException e2) {
                                        e2.printStackTrace();
                                        String message2 = e2.getMessage();
                                        if (message2 == null) {
                                            message2 = ContextUtilsKt.k(R.string.share_failed);
                                        }
                                        p95.D(message2);
                                        return;
                                    }
                                    break;
                            }
                        }
                    };
                    p6Var.h = p6Var.a.getText(R.string.view);
                    p6Var.i = onClickListener;
                    DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: x74
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            int i4 = i;
                            String str3 = str2;
                            Uri uri2 = uri;
                            t6 t6Var2 = t6Var;
                            switch (i4) {
                                case 0:
                                    try {
                                        ((p6) t6Var2.z).a.startActivity(Intent.createChooser(new Intent("android.intent.action.VIEW").setDataAndType(uri2, str3), ContextUtilsKt.k(R.string.view)));
                                    } catch (ActivityNotFoundException e) {
                                        e.printStackTrace();
                                        String message = e.getMessage();
                                        if (message == null) {
                                            message = ContextUtilsKt.k(R.string.unknown_error);
                                        }
                                        p95.D(message);
                                    }
                                    break;
                                default:
                                    try {
                                        ((p6) t6Var2.z).a.startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").putExtra("android.intent.extra.STREAM", uri2).setType(str3), ContextUtilsKt.k(R.string.share)));
                                    } catch (ActivityNotFoundException e2) {
                                        e2.printStackTrace();
                                        String message2 = e2.getMessage();
                                        if (message2 == null) {
                                            message2 = ContextUtilsKt.k(R.string.share_failed);
                                        }
                                        p95.D(message2);
                                        return;
                                    }
                                    break;
                            }
                        }
                    };
                    p6Var.j = p6Var.a.getText(R.string.share);
                    p6Var.k = onClickListener2;
                }
                t6Var.r();
                b84Var.j(false, false);
                return xl4.a;
            default:
                n12.S(obj);
                e24 e24Var = (e24) this.Z;
                boolean z3 = this.Y;
                List<zk> list2 = (List) this.y0;
                try {
                    lu2 lu2Var = (lu2) e24Var.z;
                    String strConcat = p44.G0("/", (String) e24Var.f).concat("/Surfboard/");
                    e24.g(lu2Var, strConcat, new dt4(lu2Var, strConcat, i2));
                    if (z3) {
                        lu2 lu2Var2 = (lu2) e24Var.z;
                        String strConcat2 = p44.G0("/", (String) e24Var.f).concat("/Surfboard/profiles");
                        e24.g(lu2Var2, strConcat2, new dt4(lu2Var2, strConcat2, i));
                    }
                    lu2 lu2Var3 = (lu2) e24Var.z;
                    String strConcat3 = p44.G0("/", (String) e24Var.f).concat("/Surfboard/profiles");
                    e24.g(lu2Var3, strConcat3, new dt4(lu2Var3, strConcat3, i2));
                    ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));
                    ArrayList arrayList = new ArrayList(f70.Q(10, list2));
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(executorCompletionService.submit(new ft4(1, e24Var, (zk) it.next())));
                    }
                    if (!list2.isEmpty()) {
                        for (zk zkVar : list2) {
                            Object obj2 = executorCompletionService.take().get();
                            obj2.getClass();
                            if (((Boolean) obj2).booleanValue() && (i2 = i2 + 1) < 0) {
                                e70.O();
                                throw null;
                            }
                        }
                    }
                    String str3 = "upload " + i2 + " local profile to remote finished";
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "WebDAVClient", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str3);
                        str = str3;
                    } else {
                        str = str3;
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("WebDAVClient", str, null);
                    }
                    tk3Var = Boolean.TRUE;
                } catch (Throwable th) {
                    tk3Var = new tk3(th);
                }
                return new uk3(tk3Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i63(Object obj, boolean z, List list, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = obj;
        this.Y = z;
        this.y0 = list;
    }
}
