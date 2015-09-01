package com.gmail.abhishekdas1503.email.popularmovies;


import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

/**
 * A {@link PreferenceActivity} that presents a set of Settings.
 * <p> See <a href="http://developer.android.com/design/patterns/settings.html">
 * Android Design: Settings</a> for the design guidelines and <a href =
 * "http://developer.android.com/guide/topics/ui/settings.html">Settings API
 * Guide</a> for more on developing a Settings UI
 * </p>
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getFragmentManager().
                    beginTransaction().
                    replace(android.R.id.content, new SettingsFragment()).
                    commit();
        }
    }

    public static class SettingsFragment extends PreferenceFragment
        implements Preference.OnPreferenceChangeListener {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_general);
            bindPreferenceSummaryToValue(findPreference("sortkey"));
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            String stringValue = value.toString();
            // If preference is a ListPreference look up for the
            // correct value in preferences list
            if (preference instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) preference;
                int prefIndex = listPreference.findIndexOfValue(stringValue);

                if (prefIndex >= 0) {
                    preference.setSummary(listPreference.getEntries()[prefIndex]);
                }
            }
            return true;
        }

        /**
         * Attaches a listener to the preference so that whenever there is a change
         * in the value of preference , it updates the summary. It also fires the listener
         * once
         */
        public void bindPreferenceSummaryToValue(Preference preference) {
            // Set the listener to watch for values
            preference.setOnPreferenceChangeListener(this);

            // Trigger the listener for the first time
            onPreferenceChange(preference,
                    PreferenceManager
                            .getDefaultSharedPreferences(preference.getContext())
                            .getString(preference.getKey(), ""));
        }
    }
}
