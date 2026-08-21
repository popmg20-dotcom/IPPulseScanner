package defpackage;

import android.graphics.RectF;
import android.view.View;
import com.google.android.material.navigation.NavigationView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class av3 extends zu3 {
    public boolean d = false;

    public av3(NavigationView navigationView) {
        c(navigationView);
    }

    private void c(View view) {
        view.setOutlineProvider(new zk0(this));
    }

    @Override // defpackage.zu3
    public final void a(NavigationView navigationView) {
        RectF rectF = this.b;
        rectF.isEmpty();
        rectF.isEmpty();
        this.d = false;
        navigationView.setClipToOutline(!b());
        if (b()) {
            navigationView.invalidate();
        } else {
            navigationView.invalidateOutline();
        }
    }

    @Override // defpackage.zu3
    public final boolean b() {
        return !this.d || this.a;
    }
}
