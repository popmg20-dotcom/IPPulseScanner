package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.AndroidRuntimeException;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.material.loadingindicator.LoadingIndicator;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class en4 extends WebViewClient {
    public final /* synthetic */ fn4 a;

    public en4(fn4 fn4Var) {
        this.a = fn4Var;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        ed4 ed4Var = this.a.H0;
        if (ed4Var != null) {
            ((LoadingIndicator) ed4Var.z).setVisibility(8);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        webView.getClass();
        webResourceRequest.getClass();
        String string = webResourceRequest.getUrl().toString();
        String str = this.a.I0;
        if (str == null) {
            n12.T(RtspHeaders.Values.URL);
            throw null;
        }
        if (n12.c(string, str)) {
            return false;
        }
        try {
            webView.getContext().startActivity(new Intent("android.intent.action.VIEW", webResourceRequest.getUrl()));
            return true;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (AndroidRuntimeException e2) {
            e2.printStackTrace();
            return false;
        } catch (SecurityException e3) {
            e3.printStackTrace();
            return false;
        }
    }
}
