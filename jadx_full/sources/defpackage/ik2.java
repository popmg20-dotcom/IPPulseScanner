package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.core.content.FileProvider;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ik2 implements View.OnClickListener {
    public static final ik2 b = new ik2();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context = view.getContext();
        context.getClass();
        File fileN = xb5.n(context);
        File file = fileN != null ? new File(fileN, "mini.hprof") : null;
        if (file != null) {
            Context context2 = view.getContext();
            context2.getClass();
            try {
                Uri uriC = FileProvider.c(context2, context2.getPackageName() + ".files_provider", file);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", uriC);
                intent.setType(HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE);
                intent.addFlags(1);
                try {
                    context2.startActivity(Intent.createChooser(intent, ContextUtilsKt.k(R.string.share_oom)));
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                    p95.C(R.string.share_failed, new Object[0]);
                }
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                p95.C(R.string.share_failed, new Object[0]);
            }
        }
    }
}
