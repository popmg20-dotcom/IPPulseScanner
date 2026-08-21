package io.sentry.android.core;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.getsurfboard.R;
import defpackage.ed;
import defpackage.mk;
import io.sentry.k5;
import io.sentry.n5;
import io.sentry.p4;
import io.sentry.p5;
import io.sentry.p6;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a2 extends AlertDialog {
    public final k5 A;
    public w1 X;
    public z1 Y;
    public boolean b;
    public io.sentry.protocol.w f;
    public DialogInterface.OnDismissListener z;

    public a2(Context context) {
        Activity activity;
        super(context, 0);
        this.b = false;
        k5 feedbackOptions = p4.c().getOptions().getFeedbackOptions();
        k5 k5Var = new k5();
        k5Var.a = false;
        k5Var.b = true;
        k5Var.c = false;
        k5Var.d = true;
        k5Var.e = true;
        k5Var.f = true;
        k5Var.g = false;
        k5Var.a = feedbackOptions.a;
        k5Var.b = feedbackOptions.b;
        k5Var.c = feedbackOptions.c;
        k5Var.d = feedbackOptions.d;
        k5Var.e = feedbackOptions.e;
        k5Var.f = feedbackOptions.f;
        k5Var.g = feedbackOptions.g;
        k5Var.h = feedbackOptions.h;
        this.A = k5Var;
        n5.d().a("UserFeedbackWidget");
        k5 feedbackOptions2 = p4.c().getOptions().getFeedbackOptions();
        if (!k5Var.g || feedbackOptions2.g) {
            return;
        }
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                activity = null;
                break;
            } else {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (activity == null) {
            return;
        }
        this.X = new w1(p4.c().getOptions().getLogger());
        WeakReference weakReference = new WeakReference(activity);
        this.X.c(activity, new ed(26, this, weakReference));
        Application application = activity.getApplication();
        z1 z1Var = new z1(this, weakReference);
        this.Y = z1Var;
        application.registerActivityLifecycleCallbacks(z1Var);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        io.sentry.protocol.j0 j0VarH;
        super.onCreate(bundle);
        setContentView(R.layout.sentry_dialog_user_feedback);
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(131072);
        }
        setCancelable(this.b);
        TextView textView = (TextView) findViewById(R.id.sentry_dialog_user_feedback_title);
        ImageView imageView = (ImageView) findViewById(R.id.sentry_dialog_user_feedback_logo);
        final TextView textView2 = (TextView) findViewById(R.id.sentry_dialog_user_feedback_txt_name);
        final EditText editText = (EditText) findViewById(R.id.sentry_dialog_user_feedback_edt_name);
        final TextView textView3 = (TextView) findViewById(R.id.sentry_dialog_user_feedback_txt_email);
        final EditText editText2 = (EditText) findViewById(R.id.sentry_dialog_user_feedback_edt_email);
        final TextView textView4 = (TextView) findViewById(R.id.sentry_dialog_user_feedback_txt_description);
        final EditText editText3 = (EditText) findViewById(R.id.sentry_dialog_user_feedback_edt_description);
        Button button = (Button) findViewById(R.id.sentry_dialog_user_feedback_btn_send);
        Button button2 = (Button) findViewById(R.id.sentry_dialog_user_feedback_btn_cancel);
        final k5 k5Var = this.A;
        if (k5Var.f) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        if (k5Var.b || k5Var.a) {
            textView2.setVisibility(0);
            editText.setVisibility(0);
            textView2.setText("Name");
            editText.setHint("Your Name");
            if (k5Var.a) {
                textView2.append(" (Required)");
            }
        } else {
            textView2.setVisibility(8);
            editText.setVisibility(8);
        }
        if (k5Var.d || k5Var.c) {
            textView3.setVisibility(0);
            editText2.setVisibility(0);
            textView3.setText("Email");
            editText2.setHint("your.email@example.org");
            if (k5Var.c) {
                textView3.append(" (Required)");
            }
        } else {
            textView3.setVisibility(8);
            editText2.setVisibility(8);
        }
        if (k5Var.e && (j0VarH = p4.c().t().H()) != null) {
            editText.setText(j0VarH.z);
            editText2.setText(j0VarH.b);
        }
        textView4.setText("Description");
        textView4.append(" (Required)");
        editText3.setHint("What's the bug? What did you expect?");
        textView.setText("Report a Bug");
        button.setText("Send Bug Report");
        button.setOnClickListener(new View.OnClickListener() { // from class: io.sentry.android.core.x1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditText editText4 = editText;
                String strTrim = editText4.getText().toString().trim();
                EditText editText5 = editText2;
                String strTrim2 = editText5.getText().toString().trim();
                EditText editText6 = editText3;
                String strTrim3 = editText6.getText().toString().trim();
                boolean zIsEmpty = strTrim.isEmpty();
                k5 k5Var2 = k5Var;
                if (zIsEmpty && k5Var2.a) {
                    editText4.setError(textView2.getText());
                    return;
                }
                if (strTrim2.isEmpty() && k5Var2.c) {
                    editText5.setError(textView3.getText());
                    return;
                }
                if (strTrim3.isEmpty()) {
                    editText6.setError(textView4.getText());
                    return;
                }
                io.sentry.protocol.k kVar = new io.sentry.protocol.k(strTrim3);
                kVar.z = strTrim;
                kVar.f = strTrim2;
                a2 a2Var = this.b;
                io.sentry.protocol.w wVar = a2Var.f;
                if (wVar != null) {
                    kVar.X = wVar;
                }
                if (p4.c().u().a(kVar).equals(io.sentry.protocol.w.f)) {
                    k5Var2.getClass();
                } else {
                    Context context = a2Var.getContext();
                    k5Var2.getClass();
                    Toast.makeText(context, "Thank you for your report!", 0).show();
                }
                a2Var.cancel();
            }
        });
        button2.setText("Cancel");
        button2.setOnClickListener(new mk(26, this));
        setOnDismissListener(this.z);
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        EditText editText = (EditText) findViewById(R.id.sentry_dialog_user_feedback_edt_description);
        editText.getText().clear();
        editText.setError(null);
        p6 options = p4.c().getOptions();
        options.getFeedbackOptions().getClass();
        options.getReplayController().n(Boolean.FALSE);
        this.f = options.getReplayController().g();
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        this.b = z;
    }

    @Override // android.app.Dialog
    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.z = onDismissListener;
        final Runnable runnable = p4.c().getOptions().getFeedbackOptions().h;
        if (runnable != null) {
            super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: io.sentry.android.core.y1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    runnable.run();
                    a2 a2Var = this.b;
                    a2Var.f = null;
                    DialogInterface.OnDismissListener onDismissListener2 = a2Var.z;
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(dialogInterface);
                    }
                }
            });
        } else {
            super.setOnDismissListener(this.z);
        }
    }

    @Override // android.app.Dialog
    public final void show() {
        io.sentry.f1 f1VarC = p4.c();
        p6 options = f1VarC.getOptions();
        if (f1VarC.isEnabled() && options.isEnabled()) {
            super.show();
        } else {
            options.getLogger().h(p5.WARNING, "Sentry is disabled. Feedback dialog won't be shown.", new Object[0]);
        }
    }
}
