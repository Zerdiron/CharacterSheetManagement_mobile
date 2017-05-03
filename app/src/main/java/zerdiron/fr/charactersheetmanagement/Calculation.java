package zerdiron.fr.charactersheetmanagement;


import android.widget.TextView;

import org.w3c.dom.Text;

public class Calculation {



    /**
     * Mod the number in param.
     * @param mod number to turn in mod
     * @return the mod from param's number
     */
    static int calculationMod(int mod)
    {
        if (mod == 9) mod = -1;
        else if (mod == 7) mod = -2;
        else if (mod == 5) mod = -3;
        else if (mod == 3) mod = -4;
        else if (mod == 1) mod = -5;
        else mod = (mod - 10) / 2;

        return mod;
    }

    /**
     * Sum all numbers in param.
     * @param numbers numbers to adds together
     * @return return the total of all params
     */
    static int sum(int... numbers) {
        int result = 0;
        for(int number : numbers) {
            result += number;
        }
        return result;
    }

    /*
    static void checkCreation()
    {
        int somme = 0;

        somme += calculationCreation(int.Parse(BaseFor.Text));
        somme += calculationCreation(int.Parse(BaseDex.Text));
        somme += calculationCreation(int.Parse(BaseCon.Text));
        somme += calculationCreation(int.Parse(BaseInt.Text));
        somme += calculationCreation(int.Parse(BaseSag.Text));
        somme += calculationCreation(int.Parse(BaseCha.Text));

        Creation.Text = (27 - somme).ToString();
    }
    */

    /**
     * .
     * @param stat the stat to calculate
     * @return return the creation's value
     */
    private int calculationCreation(int stat)
    {
        int value = 0;

        if (stat == 9) value = 1;
        else if (stat == 10) value = 2;
        else if (stat == 11) value = 3;
        else if (stat == 12) value = 4;
        else if (stat == 13) value = 5;
        else if (stat == 14) value = 7;
        else if (stat >= 15) value = 9;

        return value;
    }
}

