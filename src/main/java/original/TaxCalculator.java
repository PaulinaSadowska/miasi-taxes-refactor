package original;

import java.text.DecimalFormat;

/**
 * Created by Paulina Sadowska on 20.05.2016.
 */
public class TaxCalculator
{

    public double podstawaWymiaruSkladek = 0;
    public char typUmowy = ' ';
    // składki na ubezpieczenia społeczne
    public double skladkaEmerytalna = 0; // 9,76% podstawyy
    public double skladkaRentowa = 0; // 1,5% podstawy
    public double skladkaChorobowa = 0; // 2,45% podstawy
    // składki na ubezpieczenia zdrowotne
    public double kosztyUzyskania = 111.25;

    public double podstawaOpodatkowania;
    public double podstawaOpodatkowania_zaokraglone;

    public double skladkaZdrowotna1 = 0; // od podstawy wymiaru 9%
    public double skladkaZdrowotna2 = 0; // od podstawy wymiaru 7,75 %
    public double zaliczkaNaPodatekDochodowy = 0; // zaliczka na podatek dochodowy 18%
    public double kwotaZmiejszajacaPodatek = 46.33; // kwota zmienjszająca podatek 46,33 PLN
    public double podatekPotracony;
    public double zaliczkaDoUrzeduSkarbowego = 0;
    public double zaliczkaDoUrzeduSkarbowegoFormatted = 0;

    public double wynagrodzenie;
    public double podstawaSkladkiZdrowotnej;

    public TaxCalculator(double podstawa, char typUmowy)
    {
        try
        {
            podstawaWymiaruSkladek = podstawa;
            this.typUmowy = typUmowy;

        } catch (Exception ex)
        {
            System.out.println("Błędna kwota");
            System.err.println(ex);
            return;
        }

        DecimalFormat df00 = new DecimalFormat("#.00");
        DecimalFormat df = new DecimalFormat("#");

        if (typUmowy == 'P')
        {
            podstawaSkladkiZdrowotnej = obliczonaPodstawa(podstawaWymiaruSkladek);
            obliczUbezpieczenia(podstawaSkladkiZdrowotnej);
            podstawaOpodatkowania = podstawaSkladkiZdrowotnej - kosztyUzyskania;
            podstawaOpodatkowania_zaokraglone = Double
                    .parseDouble(df.format(podstawaOpodatkowania));
            obliczPodatek(podstawaOpodatkowania_zaokraglone);
        } else if (typUmowy == 'Z')
        {
            podstawaOpodatkowania = obliczonaPodstawa(podstawaWymiaruSkladek);
            obliczUbezpieczenia(podstawaOpodatkowania);
            kwotaZmiejszajacaPodatek = 0;
            kosztyUzyskania = (podstawaOpodatkowania * 20) / 100;
            podstawaOpodatkowania = podstawaOpodatkowania - kosztyUzyskania;
            podstawaOpodatkowania_zaokraglone = Double.parseDouble(df.format(podstawaOpodatkowania));
            obliczPodatek(podstawaOpodatkowania);
        } else
        {
            System.out.println("Nieznany typ umowy!");
        }
        podatekPotracony = zaliczkaNaPodatekDochodowy - kwotaZmiejszajacaPodatek;
        obliczZaliczke();
        zaliczkaDoUrzeduSkarbowegoFormatted = Double.parseDouble(df.format(zaliczkaDoUrzeduSkarbowego));
        wynagrodzenie = podstawaWymiaruSkladek
                - ((skladkaEmerytalna + skladkaRentowa + skladkaChorobowa) + skladkaZdrowotna1 + zaliczkaDoUrzeduSkarbowegoFormatted);
    }

    public void obliczZaliczke()
    {
        zaliczkaDoUrzeduSkarbowego = zaliczkaNaPodatekDochodowy - skladkaZdrowotna2 - kwotaZmiejszajacaPodatek;
    }

    public void obliczPodatek(double podstawa)
    {
        zaliczkaNaPodatekDochodowy = (podstawa * 18) / 100;
    }

    public double obliczonaPodstawa(double podstawa)
    {
        skladkaEmerytalna = (podstawa * 9.76) / 100;
        skladkaRentowa = (podstawa * 1.5) / 100;
        skladkaChorobowa = (podstawa * 2.45) / 100;
        return (podstawa - skladkaEmerytalna - skladkaRentowa - skladkaChorobowa);
    }

    public void obliczUbezpieczenia(double podstawa)
    {
        skladkaZdrowotna1 = (podstawa * 9) / 100;
        skladkaZdrowotna2 = (podstawa * 7.75) / 100;
    }
}

