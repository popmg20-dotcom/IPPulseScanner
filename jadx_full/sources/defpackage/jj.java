package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.fragment.app.o;
import com.getsurfboard.R;
import com.getsurfboard.backup.model.BackupSection;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jj {
    public final o a;
    public final r4 b;

    public jj(o oVar) {
        this.a = oVar;
        r4 r4VarRegisterForActivityResult = oVar.registerForActivityResult(new n4(2), new jd(1, this));
        r4VarRegisterForActivityResult.getClass();
        this.b = r4VarRegisterForActivityResult;
    }

    public static int b(BackupSection backupSection) {
        int i = zi.a[backupSection.ordinal()];
        if (i == 1) {
            return R.string.backup_section_profiles;
        }
        if (i == 2) {
            return R.string.backup_section_settings;
        }
        if (i == 3) {
            return R.string.backup_section_metadata;
        }
        if (i == 4) {
            return R.string.backup_section_hosts;
        }
        g.d();
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(Uri uri, ie0 ie0Var) {
        dj djVar;
        if (ie0Var instanceof dj) {
            djVar = (dj) ie0Var;
            int i = djVar.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                djVar.Z = i - Integer.MIN_VALUE;
            } else {
                djVar = new dj(this, ie0Var);
            }
        }
        Object obj = djVar.X;
        int i2 = djVar.Z;
        int i3 = 0;
        int i4 = 2;
        o oVar = this.a;
        int i5 = 1;
        ge0 ge0Var = null;
        mf0 mf0Var = mf0.b;
        try {
        } catch (ki unused) {
            p95.C(R.string.backup_corrupted, new Object[0]);
            return null;
        } catch (nj e) {
            String string = oVar.getString(R.string.backup_too_new, e.b);
            string.getClass();
            p95.D(string);
            return null;
        } catch (si unused2) {
            djVar.A = null;
            djVar.Z = 2;
            z00 z00Var = new z00(1, p95.u(djVar));
            z00Var.w();
            Context contextRequireContext = oVar.requireContext();
            contextRequireContext.getClass();
            final zf2 zf2Var = new zf2(7, contextRequireContext);
            final bj bjVar = new bj(this, uri, z00Var);
            cj cjVar = new cj(i3, z00Var);
            View viewInflate = LayoutInflater.from(contextRequireContext).inflate(R.layout.dialog_backup_password, (ViewGroup) null, false);
            int i6 = R.id.password;
            TextInputEditText textInputEditText = (TextInputEditText) vf2.l(viewInflate, R.id.password);
            if (textInputEditText != null) {
                i6 = R.id.password_layout;
                TextInputLayout textInputLayout = (TextInputLayout) vf2.l(viewInflate, R.id.password_layout);
                if (textInputLayout != null) {
                    LinearLayout linearLayout = (LinearLayout) viewInflate;
                    final eg0 eg0Var = new eg0(linearLayout, textInputEditText, textInputLayout, 6);
                    wh2 wh2Var = new wh2(contextRequireContext);
                    wh2Var.x(R.string.backup_import);
                    wh2Var.y(linearLayout);
                    wh2Var.u(R.string.cancel, new y5(i5, cjVar));
                    wh2Var.w(R.string.confirm, null);
                    ((p6) wh2Var.z).n = false;
                    final u6 u6VarH = wh2Var.h();
                    textInputEditText.addTextChangedListener(new ri(i3, eg0Var, u6VarH));
                    u6VarH.setOnShowListener(new DialogInterface.OnShowListener() { // from class: oi
                        @Override // android.content.DialogInterface.OnShowListener
                        public final void onShow(DialogInterface dialogInterface) {
                            final u6 u6Var = u6VarH;
                            final Button button = u6Var.Z.j;
                            button.setEnabled(false);
                            final eg0 eg0Var2 = eg0Var;
                            final bj bjVar2 = bjVar;
                            button.setOnClickListener(new View.OnClickListener() { // from class: pi
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    String string2;
                                    eg0 eg0Var3 = eg0Var2;
                                    Editable text = ((TextInputEditText) eg0Var3.f).getText();
                                    if (text == null || (string2 = text.toString()) == null) {
                                        string2 = "";
                                    }
                                    if (string2.length() == 0) {
                                        return;
                                    }
                                    char[] charArray = string2.toCharArray();
                                    charArray.getClass();
                                    bjVar2.e(charArray, u6Var, new qi(0, eg0Var3, button));
                                }
                            });
                            ((TextInputEditText) eg0Var2.f).post(new s7(2, eg0Var2, zf2Var));
                        }
                    });
                    u6VarH.show();
                    Object objU = z00Var.u();
                    if (objU != mf0Var) {
                        return objU;
                    }
                }
            }
            zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i6)));
            return null;
        } catch (Exception e2) {
            xb5.L(e2);
            String message = e2.getMessage();
            if (message == null) {
                message = e2.getClass().getSimpleName();
            }
            String string2 = oVar.getString(R.string.backup_import_failed, message);
            string2.getClass();
            p95.D(string2);
            return null;
        }
        if (i2 == 0) {
            n12.S(obj);
            gm0 gm0Var = qv0.a;
            pl0 pl0Var = pl0.z;
            gd gdVar = new gd(this, uri, ge0Var, i4);
            djVar.A = uri;
            djVar.Z = 1;
            Object objB0 = ji0.b0(pl0Var, gdVar, djVar);
            return objB0 == mf0Var ? mf0Var : objB0;
        }
        if (i2 == 1) {
            Uri uri2 = djVar.A;
            n12.S(obj);
            return obj;
        }
        if (i2 == 2) {
            n12.S(obj);
            return obj;
        }
        xe.q("call to 'resume' before 'invoke' with coroutine");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(Uri uri, char[] cArr, ie0 ie0Var) {
        ij ijVar;
        if (ie0Var instanceof ij) {
            ijVar = (ij) ie0Var;
            int i = ijVar.Y;
            if ((i & Integer.MIN_VALUE) != 0) {
                ijVar.Y = i - Integer.MIN_VALUE;
            } else {
                ijVar = new ij(this, ie0Var);
            }
        }
        Object objB0 = ijVar.A;
        int i2 = ijVar.Y;
        o oVar = this.a;
        vi viVar = vi.a;
        try {
            if (i2 == 0) {
                n12.S(objB0);
                gm0 gm0Var = qv0.a;
                pl0 pl0Var = pl0.z;
                ej ejVar = new ej(this, uri, cArr, null);
                ijVar.Y = 1;
                objB0 = ji0.b0(pl0Var, ejVar, ijVar);
                mf0 mf0Var = mf0.b;
                if (objB0 == mf0Var) {
                    return mf0Var;
                }
            } else {
                if (i2 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(objB0);
            }
            return new wi((k03) objB0);
        } catch (ki unused) {
            p95.C(R.string.backup_corrupted, new Object[0]);
            return viVar;
        } catch (nj e) {
            String string = oVar.getString(R.string.backup_too_new, e.b);
            string.getClass();
            p95.D(string);
            return viVar;
        } catch (oj unused2) {
            return xi.a;
        } catch (Exception e2) {
            xb5.L(e2);
            String message = e2.getMessage();
            if (message == null) {
                message = e2.getClass().getSimpleName();
            }
            String string2 = oVar.getString(R.string.backup_import_failed, message);
            string2.getClass();
            p95.D(string2);
            return viVar;
        }
    }
}
