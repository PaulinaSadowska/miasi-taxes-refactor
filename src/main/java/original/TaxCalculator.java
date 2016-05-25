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
}

