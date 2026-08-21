package defpackage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.preference.Preference;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x23 implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
    public final Preference b;

    public x23(Preference preference) {
        this.b = preference;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Preference preference = this.b;
        CharSequence charSequenceG = preference.g();
        if (!preference.T0 || TextUtils.isEmpty(charSequenceG)) {
            return;
        }
        contextMenu.setHeaderTitle(charSequenceG);
        contextMenu.add(0, 0, 0, R.string.copy).setOnMenuItemClickListener(this);
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Preference preference = this.b;
        Context context = preference.b;
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        CharSequence charSequenceG = preference.g();
        clipboardManager.setPrimaryClip(ClipData.newPlainText("Preference", charSequenceG));
        Toast.makeText(context, context.getString(R.string.preference_copied, charSequenceG), 0).show();
        return true;
    }
}
