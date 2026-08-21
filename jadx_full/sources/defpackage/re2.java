package defpackage;

import android.net.Uri;
import io.sentry.android.core.a1;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class re2 extends Thread {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public re2(se2 se2Var) {
        super("logcat-activity");
        this.b = 0;
        this.f = se2Var;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Scanner scanner;
        switch (this.b) {
            case 0:
                super.run();
                ((se2) this.f).A = true;
                try {
                    try {
                        ArrayList arrayList = new ArrayList(e70.L("logcat", "-v", "threadtime"));
                        Date date = ((se2) this.f).X;
                        if (date != null) {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
                            arrayList.add("-T");
                            arrayList.add(simpleDateFormat.format(date));
                        }
                        Process processStart = new ProcessBuilder(arrayList).start();
                        ((se2) this.f).Y = processStart;
                        Scanner scanner2 = new Scanner(processStart.getInputStream());
                        ((se2) this.f).Z = scanner2;
                        se2 se2Var = (se2) this.f;
                        if (se2Var.A) {
                            se2Var.z0.postDelayed(se2Var.A0, 50L);
                        }
                        while (((se2) this.f).A && scanner2.hasNextLine()) {
                            String strNextLine = scanner2.nextLine();
                            if (!ge2.l.matcher(strNextLine).matches()) {
                                Iterator it = ((se2) this.f).f.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (((Pattern) it.next()).matcher(strNextLine).matches()) {
                                        }
                                        break;
                                    } else {
                                        try {
                                            ge2 ge2Var = new ge2(strNextLine);
                                            se2 se2Var2 = (se2) this.f;
                                            se2Var2.X = ge2Var.a;
                                            synchronized (se2Var2.y0) {
                                                try {
                                                    se2Var2.y0.add(ge2Var);
                                                    if (se2Var2.y0.size() > 1000) {
                                                        ArrayList arrayList2 = se2Var2.y0;
                                                        arrayList2.subList(0, arrayList2.size() - 1000).clear();
                                                    }
                                                    if (se2Var2.y0.size() > 300) {
                                                        Thread.sleep(10L);
                                                    }
                                                } catch (Throwable th) {
                                                    throw th;
                                                }
                                            }
                                        } catch (IllegalStateException e) {
                                            e.printStackTrace();
                                        } catch (NumberFormatException e2) {
                                            e2.printStackTrace();
                                        } catch (ParseException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                        Process process = ((se2) this.f).Y;
                        if (process != null) {
                            process.destroy();
                        }
                        scanner = ((se2) this.f).Z;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        Process process2 = ((se2) this.f).Y;
                        if (process2 != null) {
                            process2.destroy();
                        }
                        scanner = ((se2) this.f).Z;
                        if (scanner != null) {
                        }
                    }
                    if (scanner != null) {
                        scanner.close();
                    }
                    se2 se2Var3 = (se2) this.f;
                    se2Var3.A = false;
                    se2Var3.z0.removeCallbacks(se2Var3.A0);
                    return;
                } catch (Throwable th2) {
                    Process process3 = ((se2) this.f).Y;
                    if (process3 != null) {
                        process3.destroy();
                    }
                    Scanner scanner3 = ((se2) this.f).Z;
                    if (scanner3 != null) {
                        scanner3.close();
                    }
                    se2 se2Var4 = (se2) this.f;
                    se2Var4.A = false;
                    se2Var4.z0.removeCallbacks(se2Var4.A0);
                    throw th2;
                }
            case 1:
                ((pl1) this.f).a();
                return;
            default:
                HashMap map = (HashMap) this.f;
                Uri.Builder builderBuildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
                for (String str : map.keySet()) {
                    builderBuildUpon.appendQueryParameter(str, (String) map.get(str));
                }
                String string = builderBuildUpon.build().toString();
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
                    try {
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode < 200 || responseCode >= 300) {
                            StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 65);
                            sb.append("Received non-success response code ");
                            sb.append(responseCode);
                            sb.append(" from pinging URL: ");
                            sb.append(string);
                            a1.n("HttpUrlPinger", sb.toString());
                            break;
                        }
                        httpURLConnection.disconnect();
                        return;
                    } catch (Throwable th3) {
                        httpURLConnection.disconnect();
                        throw th3;
                    }
                } catch (IOException e5) {
                    e = e5;
                    String message = e.getMessage();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + String.valueOf(string).length() + 27);
                    sb2.append("Error while pinging URL: ");
                    sb2.append(string);
                    sb2.append(". ");
                    sb2.append(message);
                    a1.o("HttpUrlPinger", sb2.toString(), e);
                    return;
                } catch (IndexOutOfBoundsException e6) {
                    String message2 = e6.getMessage();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(message2).length() + String.valueOf(string).length() + 32);
                    sb3.append("Error while parsing ping URL: ");
                    sb3.append(string);
                    sb3.append(". ");
                    sb3.append(message2);
                    a1.o("HttpUrlPinger", sb3.toString(), e6);
                    return;
                } catch (RuntimeException e7) {
                    e = e7;
                    String message3 = e.getMessage();
                    StringBuilder sb22 = new StringBuilder(String.valueOf(message3).length() + String.valueOf(string).length() + 27);
                    sb22.append("Error while pinging URL: ");
                    sb22.append(string);
                    sb22.append(". ");
                    sb22.append(message3);
                    a1.o("HttpUrlPinger", sb22.toString(), e);
                    return;
                }
        }
    }

    public /* synthetic */ re2(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }
}
