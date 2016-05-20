package original;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
    public double ubezpieczenieChorobowe = 0; // 2,45% podstawy
    // składki na ubezpieczenia zdrowotne
    public double kosztyUzyskania = 111.25;
    public double skladkaZdrowotna1 = 0; // od podstawy wymiaru 9%
    public double skladkaZdrowotna2 = 0; // od podstawy wymiaru 7,75 %
    public double zaliczkaNaPodatekDochodowy = 0; // zaliczka na podatek dochodowy 18%
    public double kwotaZmiejszajacaPodatek = 46.33; // kwota zmienjszająca podatek 46,33 PLN
    public double zaliczkaDoUrzeduSkarbowego = 0;
    public double zaliczkaDoUrzeduSkarbowegoFormatted = 0;

    public TaxCalculator(double podstawa, char typUmowy)
    {
        try
        {
            System.out.print("Podaj kwotę dochodu: ");
            podstawaWymiaruSkladek = podstawa;

            System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
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
            System.out.println("UMOWA O PRACĘ");
            System.out.println("Podstawa wymiaru składek " + podstawaWymiaruSkladek);
            double oPodstawa = obliczonaPodstawa(podstawaWymiaruSkladek);
            System.out.println("Składka na ubezpieczenie emerytalne "
                    + df00.format(skladkaEmerytalna));
            System.out.println("Składka na ubezpieczenie rentowe    "
                    + df00.format(skladkaRentowa));
            System.out.println("Składka na ubezpieczenie chorobowe  "
                    + df00.format(ubezpieczenieChorobowe));
            System.out
                    .println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: "
                            + oPodstawa);
            obliczUbezpieczenia(oPodstawa);
            System.out.println("Składka na ubezpieczenie zdrowotne: 9% = "
                    + df00.format(skladkaZdrowotna1) + " 7,75% = " + df00.format(skladkaZdrowotna2));
            System.out.println("Koszty uzyskania przychodu w stałej wysokości "
                    + kosztyUzyskania);
            double podstawaOpodat = oPodstawa - kosztyUzyskania;
            double podstawaOpodat0 = Double
                    .parseDouble(df.format(podstawaOpodat));
            System.out.println("Podstawa opodatkowania " + podstawaOpodat
                    + " zaokrąglona " + df.format(podstawaOpodat0));
            obliczPodatek(podstawaOpodat0);
            System.out.println("Zaliczka na podatek dochodowy 18 % = "
                    + zaliczkaNaPodatekDochodowy);
            System.out.println("Kwota wolna od podatku = " + kwotaZmiejszajacaPodatek);
            double podatekPotracony = zaliczkaNaPodatekDochodowy - kwotaZmiejszajacaPodatek;
            System.out.println("Podatek potrącony = "
                    + df00.format(podatekPotracony));
            obliczZaliczke();
            zaliczkaDoUrzeduSkarbowegoFormatted = Double.parseDouble(df.format(zaliczkaDoUrzeduSkarbowego));
            System.out.println("Zaliczka do urzędu skarbowego = "
                    + df00.format(zaliczkaDoUrzeduSkarbowego) + " po zaokrągleniu = "
                    + df.format(zaliczkaDoUrzeduSkarbowegoFormatted));
            double wynagrodzenie = podstawaWymiaruSkladek
                    - ((skladkaEmerytalna + skladkaRentowa + ubezpieczenieChorobowe) + skladkaZdrowotna1 + zaliczkaDoUrzeduSkarbowegoFormatted);
            System.out.println();
            System.out
                    .println("Pracownik otrzyma wynagrodzenie netto w wysokości = "
                            + df00.format(wynagrodzenie));
        } else if (typUmowy == 'Z')
        {
            System.out.println("UMOWA-ZLECENIE");
            System.out.println("Podstawa wymiaru składek " + podstawaWymiaruSkladek);
            double oPodstawa = obliczonaPodstawa(podstawaWymiaruSkladek);
            System.out.println("Składka na ubezpieczenie emerytalne "
                    + df00.format(skladkaEmerytalna));
            System.out.println("Składka na ubezpieczenie rentowe    "
                    + df00.format(skladkaRentowa));
            System.out.println("Składka na ubezpieczenie chorobowe  "
                    + df00.format(ubezpieczenieChorobowe));
            System.out
                    .println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: "
                            + oPodstawa);
            obliczUbezpieczenia(oPodstawa);
            System.out.println("Składka na ubezpieczenie zdrowotne: 9% = "
                    + df00.format(skladkaZdrowotna1) + " 7,75% = " + df00.format(skladkaZdrowotna2));
            kwotaZmiejszajacaPodatek = 0;
            kosztyUzyskania = (oPodstawa * 20) / 100;
            System.out.println("Koszty uzyskania przychodu (stałe) "
                    + kosztyUzyskania);
            double podstawaOpodat = oPodstawa - kosztyUzyskania;
            double podstawaOpodat0 = Double.parseDouble(df.format(podstawaOpodat));
            System.out.println("Podstawa opodatkowania " + podstawaOpodat
                    + " zaokrąglona " + df.format(podstawaOpodat0));
            obliczPodatek(podstawaOpodat0);
            System.out.println("Zaliczka na podatek dochodowy 18 % = "
                    + zaliczkaNaPodatekDochodowy);
            double podatekPotracony = zaliczkaNaPodatekDochodowy;
            System.out.println("Podatek potrącony = "
                    + df00.format(podatekPotracony));
            obliczZaliczke();
            zaliczkaDoUrzeduSkarbowegoFormatted = Double.parseDouble(df.format(zaliczkaDoUrzeduSkarbowego));
            System.out.println("Zaliczka do urzędu skarbowego = "
                    + df00.format(zaliczkaDoUrzeduSkarbowego) + " po zaokrągleniu = "
                    + df.format(zaliczkaDoUrzeduSkarbowegoFormatted));
            double wynagrodzenie = podstawaWymiaruSkladek
                    - ((skladkaEmerytalna + skladkaRentowa + ubezpieczenieChorobowe) + skladkaZdrowotna1 + zaliczkaDoUrzeduSkarbowegoFormatted);
            System.out.println();
            System.out
                    .println("Pracownik otrzyma wynagrodzenie netto w wysokości = "
                            + df00.format(wynagrodzenie));
        } else
        {
            System.out.println("Nieznany typ umowy!");
        }
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
        ubezpieczenieChorobowe = (podstawa * 2.45) / 100;
        return (podstawa - skladkaEmerytalna - skladkaRentowa - ubezpieczenieChorobowe);
    }

    public void obliczUbezpieczenia(double podstawa)
    {
        skladkaZdrowotna1 = (podstawa * 9) / 100;
        skladkaZdrowotna2 = (podstawa * 7.75) / 100;
    }
}

