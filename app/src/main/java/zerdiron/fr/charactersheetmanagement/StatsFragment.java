package zerdiron.fr.charactersheetmanagement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import static zerdiron.fr.charactersheetmanagement.Calculation.calculationMod;
import static zerdiron.fr.charactersheetmanagement.Calculation.sum;

public class StatsFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View statsFragment = inflater.inflate(R.layout.fragment_stats, container, false);

        Spinner spinner = (Spinner) statsFragment.findViewById(R.id.alignmentSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.alignmentContent, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        /// ### FIRST LINE(STR) ### \\\
        // Set TextView in code from View.
        final TextView strTot = (TextView) statsFragment.findViewById(R.id.strTotal);
        final TextView strMod = (TextView) statsFragment.findViewById(R.id.strMod);
        final TextView strBas = (TextView) statsFragment.findViewById(R.id.strBase);
        final TextView strLev = (TextView) statsFragment.findViewById(R.id.strLevel);
        final TextView strMag = (TextView) statsFragment.findViewById(R.id.strMagic);

        // Create TextWatcher
        final TextWatcher strWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (strBas.getText().toString().equals("-")) {
                    MainActivity.strBase = 0;
                } else if (!strBas.getText().toString().equals("")) {
                    MainActivity.strBase = Integer.parseInt(strBas.getText().toString());
                } else {
                    MainActivity.strBase = 0;
                }
                if (strLev.getText().toString().equals("-")) {
                    MainActivity.strLevel = 0;
                } else if (!strLev.getText().toString().equals("")) {
                    MainActivity.strLevel = Integer.parseInt(strLev.getText().toString());
                } else {
                    MainActivity.strLevel = 0;
                }
                if (strMag.getText().toString().equals("-")) {
                    MainActivity.strMagic = 0;
                } else if (!strMag.getText().toString().equals("")) {
                    MainActivity.strMagic = Integer.parseInt(strMag.getText().toString());
                } else {
                    MainActivity.strMagic = 0;
                }

                strTot.setText(Integer.toString(sum(MainActivity.strBase, MainActivity.strLevel, MainActivity.strMagic)));
                MainActivity.strModify = calculationMod(sum(MainActivity.strBase, MainActivity.strLevel, MainActivity.strMagic));
                strMod.setText(Integer.toString(MainActivity.strModify));
            }
        };

        // Insert saved values before adding Listener.
        strBas.setText(Integer.toString(MainActivity.strBase));
        strLev.setText(Integer.toString(MainActivity.strLevel));

        // Add Listener.
        strBas.addTextChangedListener(strWatcher);
        strLev.addTextChangedListener(strWatcher);
        strMag.addTextChangedListener(strWatcher);

        // Insert saved value to trigger TextWatcher.
        strMag.setText(Integer.toString(MainActivity.strMagic));

        /// ### SECOND LINE(DEX) ### \\\
        // Set TextView in code from View.
        final TextView dexTot = (TextView) statsFragment.findViewById(R.id.dexTotal);
        final TextView dexMod = (TextView) statsFragment.findViewById(R.id.dexMod);
        final TextView dexBas = (TextView) statsFragment.findViewById(R.id.dexBase);
        final TextView dexLev = (TextView) statsFragment.findViewById(R.id.dexLevel);
        final TextView dexMag = (TextView) statsFragment.findViewById(R.id.dexMagic);

        // Create TextWatcher
        final TextWatcher dexWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (dexBas.getText().toString().equals("-")) {
                    MainActivity.dexBase = 0;
                } else if (!dexBas.getText().toString().equals("")) {
                    MainActivity.dexBase = Integer.parseInt(dexBas.getText().toString());
                } else {
                    MainActivity.dexBase = 0;
                }
                if (dexLev.getText().toString().equals("-")) {
                    MainActivity.dexLevel = 0;
                } else if (!dexLev.getText().toString().equals("")) {
                    MainActivity.dexLevel = Integer.parseInt(dexLev.getText().toString());
                } else {
                    MainActivity.dexLevel = 0;
                }
                if (dexMag.getText().toString().equals("-")) {
                    MainActivity.dexMagic = 0;
                } else if (!dexMag.getText().toString().equals("")) {
                    MainActivity.dexMagic = Integer.parseInt(dexMag.getText().toString());
                } else {
                    MainActivity.dexMagic = 0;
                }

                dexTot.setText(Integer.toString(sum(MainActivity.dexBase, MainActivity.dexLevel, MainActivity.dexMagic)));
                MainActivity.dexModify = calculationMod(sum(MainActivity.dexBase, MainActivity.dexLevel, MainActivity.dexMagic));
                dexMod.setText(Integer.toString(MainActivity.dexModify));
            }
        };

        // Insert saved values before adding Listener.
        dexBas.setText(Integer.toString(MainActivity.dexBase));
        dexLev.setText(Integer.toString(MainActivity.dexLevel));

        // Add Listener.
        dexBas.addTextChangedListener(dexWatcher);
        dexLev.addTextChangedListener(dexWatcher);
        dexMag.addTextChangedListener(dexWatcher);

        // Insert saved value to trigger TextWatcher.
        dexMag.setText(Integer.toString(MainActivity.dexMagic));

        /// ### THIRD LINE(CON) ### \\\
        // Set TextView in code from View.
        final TextView conTot = (TextView) statsFragment.findViewById(R.id.conTotal);
        final TextView conMod = (TextView) statsFragment.findViewById(R.id.conMod);
        final TextView conBas = (TextView) statsFragment.findViewById(R.id.conBase);
        final TextView conLev = (TextView) statsFragment.findViewById(R.id.conLevel);
        final TextView conMag = (TextView) statsFragment.findViewById(R.id.conMagic);

        // Create TextWatcher
        final TextWatcher conWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (conBas.getText().toString().equals("-")) {
                    MainActivity.conBase = 0;
                } else if (!conBas.getText().toString().equals("")) {
                    MainActivity.conBase = Integer.parseInt(conBas.getText().toString());
                } else {
                    MainActivity.conBase = 0;
                }
                if (conLev.getText().toString().equals("-")) {
                    MainActivity.conLevel = 0;
                } else if (!conLev.getText().toString().equals("")) {
                    MainActivity.conLevel = Integer.parseInt(conLev.getText().toString());
                } else {
                    MainActivity.conLevel = 0;
                }
                if (conMag.getText().toString().equals("-")) {
                    MainActivity.conMagic = 0;
                } else if (!conMag.getText().toString().equals("")) {
                    MainActivity.conMagic = Integer.parseInt(conMag.getText().toString());
                } else {
                    MainActivity.conMagic = 0;
                }

                conTot.setText(Integer.toString(sum(MainActivity.conBase, MainActivity.conLevel, MainActivity.conMagic)));
                MainActivity.conModify = calculationMod(sum(MainActivity.conBase, MainActivity.conLevel, MainActivity.conMagic));
                conMod.setText(Integer.toString(MainActivity.conModify));
            }
        };

        // Insert saved values before adding Listener.
        conBas.setText(Integer.toString(MainActivity.conBase));
        conLev.setText(Integer.toString(MainActivity.conLevel));

        // Add Listener.
        conBas.addTextChangedListener(conWatcher);
        conLev.addTextChangedListener(conWatcher);
        conMag.addTextChangedListener(conWatcher);

        // Insert saved value to trigger TextWatcher.
        conMag.setText(Integer.toString(MainActivity.conMagic));

        /// ### FOURTH LINE(INT) ### \\\
        // Set TextView in code from View.
        final TextView intTot = (TextView) statsFragment.findViewById(R.id.intTotal);
        final TextView intMod = (TextView) statsFragment.findViewById(R.id.intMod);
        final TextView intBas = (TextView) statsFragment.findViewById(R.id.intBase);
        final TextView intLev = (TextView) statsFragment.findViewById(R.id.intLevel);
        final TextView intMag = (TextView) statsFragment.findViewById(R.id.intMagic);

        // Create TextWatcher
        final TextWatcher intWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (intBas.getText().toString().equals("-")) {
                    MainActivity.intBase = 0;
                } else if (!intBas.getText().toString().equals("")) {
                    MainActivity.intBase = Integer.parseInt(intBas.getText().toString());
                } else {
                    MainActivity.intBase = 0;
                }
                if (intLev.getText().toString().equals("-")) {
                    MainActivity.intLevel = 0;
                } else if (!intLev.getText().toString().equals("")) {
                    MainActivity.intLevel = Integer.parseInt(intLev.getText().toString());
                } else {
                    MainActivity.intLevel = 0;
                }
                if (intMag.getText().toString().equals("-")) {
                    MainActivity.intMagic = 0;
                } else if (!intMag.getText().toString().equals("")) {
                    MainActivity.intMagic = Integer.parseInt(intMag.getText().toString());
                } else {
                    MainActivity.intMagic = 0;
                }

                intTot.setText(Integer.toString(sum(MainActivity.intBase, MainActivity.intLevel, MainActivity.intMagic)));
                MainActivity.intModify = calculationMod(sum(MainActivity.intBase, MainActivity.intLevel, MainActivity.intMagic));
                intMod.setText(Integer.toString(MainActivity.intModify));
            }
        };

        // Insert saved values before adding Listener.
        intBas.setText(Integer.toString(MainActivity.intBase));
        intLev.setText(Integer.toString(MainActivity.intLevel));

        // Add Listener.
        intBas.addTextChangedListener(intWatcher);
        intLev.addTextChangedListener(intWatcher);
        intMag.addTextChangedListener(intWatcher);

        // Insert saved value to trigger TextWatcher.
        intMag.setText(Integer.toString(MainActivity.intMagic));

        /// ### FIFTH LINE(WIS) ### \\\
        // Set TextView in code from View.
        final TextView wisTot = (TextView) statsFragment.findViewById(R.id.wisTotal);
        final TextView wisMod = (TextView) statsFragment.findViewById(R.id.wisMod);
        final TextView wisBas = (TextView) statsFragment.findViewById(R.id.wisBase);
        final TextView wisLev = (TextView) statsFragment.findViewById(R.id.wisLevel);
        final TextView wisMag = (TextView) statsFragment.findViewById(R.id.wisMagic);

        // Create TextWatcher
        final TextWatcher wisWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (wisBas.getText().toString().equals("-")) {
                    MainActivity.wisBase = 0;
                } else if (!wisBas.getText().toString().equals("")) {
                    MainActivity.wisBase = Integer.parseInt(wisBas.getText().toString());
                } else {
                    MainActivity.wisBase = 0;
                }
                if (wisLev.getText().toString().equals("-")) {
                    MainActivity.wisLevel = 0;
                } else if (!wisLev.getText().toString().equals("")) {
                    MainActivity.wisLevel = Integer.parseInt(wisLev.getText().toString());
                } else {
                    MainActivity.wisLevel = 0;
                }
                if (wisMag.getText().toString().equals("-")) {
                    MainActivity.wisMagic = 0;
                } else if (!wisMag.getText().toString().equals("")) {
                    MainActivity.wisMagic = Integer.parseInt(wisMag.getText().toString());
                } else {
                    MainActivity.wisMagic = 0;
                }

                wisTot.setText(Integer.toString(sum(MainActivity.wisBase, MainActivity.wisLevel, MainActivity.wisMagic)));
                MainActivity.wisModify = calculationMod(sum(MainActivity.wisBase, MainActivity.wisLevel, MainActivity.wisMagic));
                wisMod.setText(Integer.toString(MainActivity.wisModify));
            }
        };

        // Insert saved values before adding Listener.
        wisBas.setText(Integer.toString(MainActivity.wisBase));
        wisLev.setText(Integer.toString(MainActivity.wisLevel));

        // Add Listener.
        wisBas.addTextChangedListener(wisWatcher);
        wisLev.addTextChangedListener(wisWatcher);
        wisMag.addTextChangedListener(wisWatcher);

        // Insert saved value to trigger TextWatcher.
        wisMag.setText(Integer.toString(MainActivity.wisMagic));

        /// ### SIXTH LINE(CHA) ### \\\
        // Set TextView in code from View.
        final TextView chaTot = (TextView) statsFragment.findViewById(R.id.chaTotal);
        final TextView chaMod = (TextView) statsFragment.findViewById(R.id.chaMod);
        final TextView chaBas = (TextView) statsFragment.findViewById(R.id.chaBase);
        final TextView chaLev = (TextView) statsFragment.findViewById(R.id.chaLevel);
        final TextView chaMag = (TextView) statsFragment.findViewById(R.id.chaMagic);

        // Create TextWatcher
        final TextWatcher chaWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (chaBas.getText().toString().equals("-")) {
                    MainActivity.chaBase = 0;
                } else if (!chaBas.getText().toString().equals("")) {
                    MainActivity.chaBase = Integer.parseInt(chaBas.getText().toString());
                } else {
                    MainActivity.chaBase = 0;
                }
                if (chaLev.getText().toString().equals("-")) {
                    MainActivity.chaLevel = 0;
                } else if (!chaLev.getText().toString().equals("")) {
                    MainActivity.chaLevel = Integer.parseInt(chaLev.getText().toString());
                } else {
                    MainActivity.chaLevel = 0;
                }
                if (chaMag.getText().toString().equals("-")) {
                    MainActivity.chaMagic = 0;
                } else if (!chaMag.getText().toString().equals("")) {
                    MainActivity.chaMagic = Integer.parseInt(chaMag.getText().toString());
                } else {
                    MainActivity.chaMagic = 0;
                }

                chaTot.setText(Integer.toString(sum(MainActivity.chaBase, MainActivity.chaLevel, MainActivity.chaMagic)));
                MainActivity.chaModify = calculationMod(sum(MainActivity.chaBase, MainActivity.chaLevel, MainActivity.chaMagic));
                chaMod.setText(Integer.toString(MainActivity.chaModify));
            }
        };

        // Insert saved values before adding Listener.
        chaBas.setText(Integer.toString(MainActivity.chaBase));
        chaLev.setText(Integer.toString(MainActivity.chaLevel));

        // Add Listener.
        chaBas.addTextChangedListener(chaWatcher);
        chaLev.addTextChangedListener(chaWatcher);
        chaMag.addTextChangedListener(chaWatcher);

        // Insert saved value to trigger TextWatcher.
        chaMag.setText(Integer.toString(MainActivity.chaMagic));

        return statsFragment;
    }


}
