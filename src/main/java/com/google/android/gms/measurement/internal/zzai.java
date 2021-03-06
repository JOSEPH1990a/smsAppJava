package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.annotation.WorkerThread;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzrx;
import com.google.android.gms.internal.measurement.zzsh;
import com.google.android.gms.internal.measurement.zzsi;
import com.google.android.gms.internal.measurement.zzso;
import com.gsmmodem.Servers.MyHttpServer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@VisibleForTesting
public final class zzai {
    private static volatile zzbw zzada;
    static zzn zzaih;
    static List<zza<Integer>> zzaii = new ArrayList();
    static List<zza<Long>> zzaij = new ArrayList();
    static List<zza<Boolean>> zzaik = new ArrayList();
    static List<zza<String>> zzail = new ArrayList();
    static List<zza<Double>> zzaim = new ArrayList();
    private static final zzso zzain = new zzso(zzsh.zzfq("com.google.android.gms.measurement"));
    @VisibleForTesting
    private static Boolean zzaio;
    private static zza<Boolean> zzaip = zza.zzb("measurement.log_third_party_store_events_enabled", false, false);
    private static zza<Boolean> zzaiq = zza.zzb("measurement.log_installs_enabled", false, false);
    private static zza<Boolean> zzair = zza.zzb("measurement.log_upgrades_enabled", false, false);
    public static zza<Boolean> zzais = zza.zzb("measurement.log_androidId_enabled", false, false);
    public static zza<Boolean> zzait = zza.zzb("measurement.upload_dsid_enabled", false, false);
    public static zza<String> zzaiu = zza.zzd("measurement.log_tag", "FA", "FA-SVC");
    public static zza<Long> zzaiv = zza.zzb("measurement.ad_id_cache_time", 10000, 10000);
    public static zza<Long> zzaiw = zza.zzb("measurement.monitoring.sample_period_millis", 86400000, 86400000);
    public static zza<Long> zzaix = zza.zzb("measurement.config.cache_time", 86400000, 3600000);
    public static zza<String> zzaiy = zza.zzd("measurement.config.url_scheme", "https", "https");
    public static zza<String> zzaiz = zza.zzd("measurement.config.url_authority", "app-measurement.com", "app-measurement.com");
    public static zza<Integer> zzaja = zza.zzc("measurement.upload.max_bundles", 100, 100);
    public static zza<Integer> zzajb = zza.zzc("measurement.upload.max_batch_size", 65536, 65536);
    public static zza<Integer> zzajc = zza.zzc("measurement.upload.max_bundle_size", 65536, 65536);
    public static zza<Integer> zzajd = zza.zzc("measurement.upload.max_events_per_bundle", 1000, 1000);
    public static zza<Integer> zzaje = zza.zzc("measurement.upload.max_events_per_day", 100000, 100000);
    public static zza<Integer> zzajf = zza.zzc("measurement.upload.max_error_events_per_day", 1000, 1000);
    public static zza<Integer> zzajg = zza.zzc("measurement.upload.max_public_events_per_day", 50000, 50000);
    public static zza<Integer> zzajh = zza.zzc("measurement.upload.max_conversions_per_day", 500, 500);
    public static zza<Integer> zzaji = zza.zzc("measurement.upload.max_realtime_events_per_day", 10, 10);
    public static zza<Integer> zzajj = zza.zzc("measurement.store.max_stored_events_per_app", 100000, 100000);
    public static zza<String> zzajk = zza.zzd("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a");
    public static zza<Long> zzajl = zza.zzb("measurement.upload.backoff_period", 43200000, 43200000);
    public static zza<Long> zzajm = zza.zzb("measurement.upload.window_interval", 3600000, 3600000);
    public static zza<Long> zzajn = zza.zzb("measurement.upload.interval", 3600000, 3600000);
    public static zza<Long> zzajo = zza.zzb("measurement.upload.realtime_upload_interval", 10000, 10000);
    public static zza<Long> zzajp = zza.zzb("measurement.upload.debug_upload_interval", 1000, 1000);
    public static zza<Long> zzajq = zza.zzb("measurement.upload.minimum_delay", 500, 500);
    public static zza<Long> zzajr = zza.zzb("measurement.alarm_manager.minimum_interval", (long) MyHttpServer.MINUTE_MILLIS, (long) MyHttpServer.MINUTE_MILLIS);
    public static zza<Long> zzajs = zza.zzb("measurement.upload.stale_data_deletion_interval", 86400000, 86400000);
    public static zza<Long> zzajt = zza.zzb("measurement.upload.refresh_blacklisted_config_interval", 604800000, 604800000);
    public static zza<Long> zzaju = zza.zzb("measurement.upload.initial_upload_delay_time", 15000, 15000);
    public static zza<Long> zzajv = zza.zzb("measurement.upload.retry_time", 1800000, 1800000);
    public static zza<Integer> zzajw = zza.zzc("measurement.upload.retry_count", 6, 6);
    public static zza<Long> zzajx = zza.zzb("measurement.upload.max_queue_time", 2419200000L, 2419200000L);
    public static zza<Integer> zzajy = zza.zzc("measurement.lifetimevalue.max_currency_tracked", 4, 4);
    public static zza<Integer> zzajz = zza.zzc("measurement.audience.filter_result_max_count", ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
    public static zza<Long> zzaka = zza.zzb("measurement.service_client.idle_disconnect_millis", 5000, 5000);
    public static zza<Boolean> zzakb = zza.zzb("measurement.test.boolean_flag", false, false);
    public static zza<String> zzakc = zza.zzd("measurement.test.string_flag", "---", "---");
    public static zza<Long> zzakd = zza.zzb("measurement.test.long_flag", -1, -1);
    public static zza<Integer> zzake = zza.zzc("measurement.test.int_flag", -2, -2);
    public static zza<Double> zzakf = zza.zza("measurement.test.double_flag", -3.0d, -3.0d);
    public static zza<Integer> zzakg = zza.zzc("measurement.experiment.max_ids", 50, 50);
    public static zza<Boolean> zzakh = zza.zzb("measurement.lifetimevalue.user_engagement_tracking_enabled", true, true);
    public static zza<Boolean> zzaki = zza.zzb("measurement.audience.complex_param_evaluation", true, true);
    public static zza<Boolean> zzakj = zza.zzb("measurement.validation.internal_limits_internal_event_params", false, false);
    public static zza<Boolean> zzakk = zza.zzb("measurement.quality.unsuccessful_update_retry_counter", true, true);
    public static zza<Boolean> zzakl = zza.zzb("measurement.iid.disable_on_collection_disabled", true, true);
    public static zza<Boolean> zzakm = zza.zzb("measurement.app_launch.call_only_when_enabled", true, true);
    public static zza<Boolean> zzakn = zza.zzb("measurement.run_on_worker_inline", true, false);
    public static zza<Boolean> zzako = zza.zzb("measurement.audience.dynamic_filters", true, true);
    public static zza<Boolean> zzakp = zza.zzb("measurement.reset_analytics.persist_time", false, false);
    public static zza<Boolean> zzakq = zza.zzb("measurement.validation.value_and_currency_params", false, false);
    public static zza<Boolean> zzakr = zza.zzb("measurement.sampling.time_zone_offset_enabled", false, false);
    public static zza<Boolean> zzaks = zza.zzb("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", false, false);
    public static zza<Boolean> zzakt = zza.zzb("measurement.fetch_config_with_admob_app_id", true, true);
    public static zza<Boolean> zzaku = zza.zzb("measurement.sessions.session_id_enabled", false, false);
    public static zza<Boolean> zzakv = zza.zzb("measurement.sessions.session_number_enabled", false, false);
    public static zza<Boolean> zzakw = zza.zzb("measurement.sessions.immediate_start_enabled", false, false);
    public static zza<Boolean> zzakx = zza.zzb("measurement.sessions.background_sessions_enabled", false, false);
    public static zza<Boolean> zzaky = zza.zzb("measurement.collection.firebase_global_collection_flag_enabled", true, true);
    public static zza<Boolean> zzakz = zza.zzb("measurement.collection.efficient_engagement_reporting_enabled", false, false);
    public static zza<Boolean> zzala = zza.zzb("measurement.collection.redundant_engagement_removal_enabled", false, false);
    public static zza<Boolean> zzalb = zza.zzb("measurement.remove_app_instance_id_cache_enabled", true, true);
    public static zza<Boolean> zzalc = zza.zzb("measurement.collection.init_params_control_enabled", true, true);
    public static zza<Boolean> zzald = zza.zzb("measurement.upload.disable_is_uploader", false, false);
    public static zza<Boolean> zzale = zza.zzb("measurement.experiment.enable_experiment_reporting", false, false);
    public static zza<Boolean> zzalf = zza.zzb("measurement.collection.log_event_and_bundle_v2", true, true);
    public static zza<Boolean> zzalg = zza.zzb("measurement.collection.null_empty_event_name_fix", true, true);

    public static Map<String, String> zzm(Context context) {
        return zzrx.zza(context.getContentResolver(), zzsh.zzfq("com.google.android.gms.measurement")).zztk();
    }

    @VisibleForTesting
    public static final class zza<V> {
        private final V zzaan;
        private zzsi<V> zzalh;
        private final V zzali;
        private volatile V zzalj;
        private final String zzoj;

        private zza(String str, V v, V v2) {
            this.zzoj = str;
            this.zzaan = v;
            this.zzali = v2;
        }

        static zza<Boolean> zzb(String str, boolean z, boolean z2) {
            zza<Boolean> zza = new zza<>(str, Boolean.valueOf(z), Boolean.valueOf(z2));
            zzai.zzaik.add(zza);
            return zza;
        }

        static zza<String> zzd(String str, String str2, String str3) {
            zza<String> zza = new zza<>(str, str2, str3);
            zzai.zzail.add(zza);
            return zza;
        }

        static zza<Long> zzb(String str, long j, long j2) {
            zza<Long> zza = new zza<>(str, Long.valueOf(j), Long.valueOf(j2));
            zzai.zzaij.add(zza);
            return zza;
        }

        static zza<Integer> zzc(String str, int i, int i2) {
            zza<Integer> zza = new zza<>(str, Integer.valueOf(i), Integer.valueOf(i2));
            zzai.zzaii.add(zza);
            return zza;
        }

        static zza<Double> zza(String str, double d, double d2) {
            zza<Double> zza = new zza<>(str, Double.valueOf(-3.0d), Double.valueOf(-3.0d));
            zzai.zzaim.add(zza);
            return zza;
        }

        public final String getKey() {
            return this.zzoj;
        }

        /* access modifiers changed from: private */
        public static void zzq() {
            synchronized (zza.class) {
                for (zza<Boolean> zza : zzai.zzaik) {
                    zzso zzso = zzai.zzain;
                    String str = ((zza) zza).zzoj;
                    zzn zzn = zzai.zzaih;
                    ((zza) zza).zzalh = (zzsi<V>) zzso.zzd(str, ((zza) zza).zzaan.booleanValue());
                }
                for (zza<String> zza2 : zzai.zzail) {
                    zzso zzso2 = zzai.zzain;
                    String str2 = ((zza) zza2).zzoj;
                    zzn zzn2 = zzai.zzaih;
                    ((zza) zza2).zzalh = (zzsi<V>) zzso2.zzy(str2, ((zza) zza2).zzaan);
                }
                for (zza<Long> zza3 : zzai.zzaij) {
                    zzso zzso3 = zzai.zzain;
                    String str3 = ((zza) zza3).zzoj;
                    zzn zzn3 = zzai.zzaih;
                    ((zza) zza3).zzalh = (zzsi<V>) zzso3.zze(str3, ((zza) zza3).zzaan.longValue());
                }
                for (zza<Integer> zza4 : zzai.zzaii) {
                    zzso zzso4 = zzai.zzain;
                    String str4 = ((zza) zza4).zzoj;
                    zzn zzn4 = zzai.zzaih;
                    ((zza) zza4).zzalh = (zzsi<V>) zzso4.zzd(str4, ((zza) zza4).zzaan.intValue());
                }
                for (zza<Double> zza5 : zzai.zzaim) {
                    zzso zzso5 = zzai.zzain;
                    String str5 = ((zza) zza5).zzoj;
                    zzn zzn5 = zzai.zzaih;
                    ((zza) zza5).zzalh = (zzsi<V>) zzso5.zzb(str5, ((zza) zza5).zzaan.doubleValue());
                }
            }
        }

        @WorkerThread
        private static void zzja() {
            synchronized (zza.class) {
                if (!zzn.isMainThread()) {
                    zzn zzn = zzai.zzaih;
                    try {
                        for (zza<Boolean> zza : zzai.zzaik) {
                            ((zza) zza).zzalj = ((zza) zza).zzalh.get();
                        }
                        for (zza<String> zza2 : zzai.zzail) {
                            ((zza) zza2).zzalj = ((zza) zza2).zzalh.get();
                        }
                        for (zza<Long> zza3 : zzai.zzaij) {
                            ((zza) zza3).zzalj = ((zza) zza3).zzalh.get();
                        }
                        for (zza<Integer> zza4 : zzai.zzaii) {
                            ((zza) zza4).zzalj = ((zza) zza4).zzalh.get();
                        }
                        for (zza<Double> zza5 : zzai.zzaim) {
                            ((zza) zza5).zzalj = ((zza) zza5).zzalh.get();
                        }
                    } catch (SecurityException e) {
                        zzai.zza(e);
                    }
                } else {
                    throw new IllegalStateException("Tried to refresh flag cache on main thread or on package side.");
                }
            }
        }

        public final V get() {
            if (zzai.zzaih == null) {
                return this.zzaan;
            }
            zzn zzn = zzai.zzaih;
            if (zzn.isMainThread()) {
                return this.zzalj == null ? this.zzaan : this.zzalj;
            }
            zzja();
            try {
                return this.zzalh.get();
            } catch (SecurityException e) {
                zzai.zza(e);
                return this.zzalh.getDefaultValue();
            }
        }

        public final V get(V v) {
            if (v != null) {
                return v;
            }
            if (zzai.zzaih == null) {
                return this.zzaan;
            }
            zzn zzn = zzai.zzaih;
            if (zzn.isMainThread()) {
                return this.zzalj == null ? this.zzaan : this.zzalj;
            }
            zzja();
            try {
                return this.zzalh.get();
            } catch (SecurityException e) {
                zzai.zza(e);
                return this.zzalh.getDefaultValue();
            }
        }
    }

    static void zza(zzbw zzbw) {
        zzada = zzbw;
    }

    @VisibleForTesting
    static void zza(Exception exc) {
        if (zzada != null) {
            Context context = zzada.getContext();
            if (zzaio == null) {
                zzaio = Boolean.valueOf(GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) == 0);
            }
            if (zzaio.booleanValue()) {
                zzada.zzgt().zzjg().zzg("Got Exception on PhenotypeFlag.get on Play device", exc);
            }
        }
    }

    static void zza(zzn zzn) {
        zzaih = zzn;
        zza.zzq();
    }
}
