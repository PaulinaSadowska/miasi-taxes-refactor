package original;

import java.text.DecimalFormat;

/**
 * Created by Paulina Sadowska on 20.05.2016.
 */
public class TaxCalculator
{

    private double podstawaWymiaruSkladek = 0;
    private char typUmowy = ' ';
    // składki na ubezpieczenia społeczne
    private double skladkaEmerytalna = 0; // 9,76% podstawyy
    private double skladkaRentowa = 0; // 1,5% podstawy
    private double skladkaChorobowa = 0; // 2,45% podstawy
    // składki na ubezpieczenia zdrowotne
    private double kosztyUzyskania = 111.25;

    private double podstawaOpodatkowania;
    private double podstawaOpodatkowania_zaokraglone;

    private double skladkaZdrowotna1 = 0; // od podstawy wymiaru 9%
    private double skladkaZdrowotna2 = 0; // od podstawy wymiaru 7,75 %
    private double zaliczkaNaPodatekDochodowy = 0; // zaliczka na podatek dochodowy 18%
    private double kwotaZmiejszajacaPodatek = 46.33; // kwota zmienjszająca podatek 46,33 PLN
    private double podatekPotracony;
    private double zaliczkaDoUrzeduSkarbowego = 0;
    private double zaliczkaDoUrzeduSkarbowegoFormatted = 0;

    private double wynagrodzenie;
    private double podstawaSkladkiZdrowotnej;

    public TaxCalculator(double podstawa, char typUmowy)
    {
        podstawaWymiaruSkladek = podstawa;
        this.typUmowy = typUmowy;

        DecimalFormat df00 = new DecimalFormat("#.00");
        DecimalFormat df = new DecimalFormat("#");

        skladkaEmerytalna = (podstawa * 9.76) / 100;
        skladkaRentowa = (podstawa * 1.5) / 100;
        skladkaChorobowa = (podstawa * 2.45) / 100;
        podstawaSkladkiZdrowotnej = (podstawa - skladkaEmerytalna - skladkaRentowa - skladkaChorobowa);
        skladkaZdrowotna1 = (podstawaSkladkiZdrowotnej * 9) / 100;
        skladkaZdrowotna2 = (podstawaSkladkiZdrowotnej * 7.75) / 100;
        if (typUmowy == 'P')
        {
            podstawaOpodatkowania = podstawaSkladkiZdrowotnej - kosztyUzyskania;
        } else if (typUmowy == 'Z')
        {
            kwotaZmiejszajacaPodatek = 0;
            podstawaOpodatkowania = podstawaSkladkiZdrowotnej;
            kosztyUzyskania = (podstawaOpodatkowania * 20) / 100;
            podstawaOpodatkowania = podstawaOpodatkowania - kosztyUzyskania;
        }
        podstawaOpodatkowania_zaokraglone = Double.parseDouble(df.format(podstawaOpodatkowania));
        zaliczkaNaPodatekDochodowy = (podstawaOpodatkowania_zaokraglone * 18) / 100;
        podatekPotracony = zaliczkaNaPodatekDochodowy - kwotaZmiejszajacaPodatek;
        zaliczkaDoUrzeduSkarbowego = zaliczkaNaPodatekDochodowy - skladkaZdrowotna2 - kwotaZmiejszajacaPodatek;
        zaliczkaDoUrzeduSkarbowegoFormatted = Double.parseDouble(df.format(zaliczkaDoUrzeduSkarbowego));
        wynagrodzenie = podstawaWymiaruSkladek
                - ((skladkaEmerytalna + skladkaRentowa + skladkaChorobowa) + skladkaZdrowotna1 + zaliczkaDoUrzeduSkarbowegoFormatted);
    }

    public double getPodstawaWymiaruSkladek()
    {
        return podstawaWymiaruSkladek;
    }

    public char getTypUmowy()
    {
        return typUmowy;
    }

    public double getSkladkaEmerytalna()
    {
        return skladkaEmerytalna;
    }

    public double getSkladkaRentowa()
    {
        return skladkaRentowa;
    }

    public double getSkladkaChorobowa()
    {
        return skladkaChorobowa;
    }

    public double getKosztyUzyskania()
    {
        return kosztyUzyskania;
    }

    public double getPodstawaOpodatkowania()
    {
        return podstawaOpodatkowania;
    }

    public double getPodstawaOpodatkowania_zaokraglone()
    {
        return podstawaOpodatkowania_zaokraglone;
    }

    public double getSkladkaZdrowotna1()
    {
        return skladkaZdrowotna1;
    }

    public double getSkladkaZdrowotna2()
    {
        return skladkaZdrowotna2;
    }

    public double getZaliczkaNaPodatekDochodowy()
    {
        return zaliczkaNaPodatekDochodowy;
    }

    public double getKwotaZmiejszajacaPodatek()
    {
        return kwotaZmiejszajacaPodatek;
    }

    public double getPodatekPotracony()
    {
        return podatekPotracony;
    }

    public double getZaliczkaDoUrzeduSkarbowego()
    {
        return zaliczkaDoUrzeduSkarbowego;
    }

    public double getZaliczkaDoUrzeduSkarbowegoFormatted()
    {
        return zaliczkaDoUrzeduSkarbowegoFormatted;
    }

    public double getWynagrodzenie()
    {
        return wynagrodzenie;
    }

    public double getPodstawaSkladkiZdrowotnej()
    {
        return podstawaSkladkiZdrowotnej;
    }
}

