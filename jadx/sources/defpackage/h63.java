package defpackage;

import android.view.MenuItem;
import com.getsurfboard.ui.activity.ProfileEditorActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h63 implements MenuItem.OnActionExpandListener {
    public final /* synthetic */ ProfileEditorActivity a;

    public h63(ProfileEditorActivity profileEditorActivity) {
        this.a = profileEditorActivity;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        menuItem.getClass();
        int i = ProfileEditorActivity.Y0;
        this.a.x();
        return true;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        menuItem.getClass();
        return true;
    }
}
