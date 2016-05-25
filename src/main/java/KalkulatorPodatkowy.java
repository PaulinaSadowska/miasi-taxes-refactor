/**
 * Created by Paulina Sadowska on 25.05.2016.
 */
public class KalkulatorPodatkowy
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
    private double zaliczkaDoUrzeduSkarbowegoFormatted = 0;
    private double zaliczkaDoUrzeduSkarbowego = 0;

    private double wynagrodzenie;
    private double podstawaSkladkiZdrowotnej;
}
