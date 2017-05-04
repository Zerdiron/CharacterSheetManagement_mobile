package zerdiron.fr.charactersheetmanagement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    // ### ATTRIBUTES ### \\\
    static int proficiency = 2;                                  // Proficiency for saves
    static int strBase = 10, strModify = 0, strLevel = 0, strMagic = 0, strProficiency = 0;
    static int dexBase = 10, dexModify = 0, dexLevel = 0, dexMagic = 0, dexProficiency = 0;
    static int conBase = 10, conModify = 0, conLevel = 0, conMagic = 0, conProficiency = 0;
    static int intBase = 10, intModify = 0, intLevel = 0, intMagic = 0, intProficiency = 0;
    static int wisBase = 10, wisModify = 0, wisLevel = 0, wisMagic = 0, wisProficiency = 0;
    static int chaBase = 10, chaModify = 0, chaLevel = 0, chaMagic = 0, chaProficiency = 0;
    static int level = 1;
    static String height = "7", weight = "180";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            // Create a new Fragment to be placed in the activity layout
            OverviewFragment overviewFragment = new OverviewFragment();
            StatsFragment statsFragment = new StatsFragment();
            SavesFragment savesFragment = new SavesFragment();

            switch (item.getItemId()) {
                case R.id.navigation_overview:
                    if (findViewById(R.id.fragmentContent) != null) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContent, overviewFragment).commit();
                    }
                    return true;
                case R.id.navigation_stats:
                    if (findViewById(R.id.fragmentContent) != null) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContent, statsFragment).commit();
                    }
                    return true;
                case R.id.navigation_saves:
                    if (findViewById(R.id.fragmentContent) != null) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContent, savesFragment).commit();
                    }
                    return true;
                case R.id.navigation_attacks:
                    if (findViewById(R.id.fragmentContent) != null) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContent, savesFragment).commit();
                    }
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OverviewFragment overviewFragment = new OverviewFragment();

        if (findViewById(R.id.fragmentContent) != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContent, overviewFragment).commit();
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
