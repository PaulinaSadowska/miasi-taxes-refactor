package original;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Paulina Sadowska on 20.05.2016.
 */
public class OriginalUmowaOPracePodatkiTest
{

    private final double bias = 0.02;

    private final char typUmowy = 'P';
    private final double podstawaWymiaruSkladek = 3000;

    private final double kosztyUzyskaniaPrzychodu_oczekiwane = 111.25;
    private final double podstawaOpodatkowania_oczekiwane = 2477.45;
    private final double podstawaOpodatkowaniaZaokraglona_oczekiwane = 2477;
    private final double zaliczkaPodatekDochodowy_oczekiwane = 445.86;
    private final double kwotaWolnaOdPodatku_oczekiwane = 46.33;
    private final double podatekPotracony_oczekiwane = 399.53;
    private final double zaliczkaDoUrzeduSkarbowego_oczekiwane = 198.91;
    private final double zaliczkaDoUrzeduSkarbowegoZaokraglony_oczekiwane = 199;
    private final double wynagrodzenieNetto_oczekiwane = 2156.72;

    private TaxCalculator taxCalculator;


    @Before
    public void setUp()
    {
        taxCalculator = new TaxCalculator(podstawaWymiaruSkladek, typUmowy);
    }

    @Test
    public void inicjalizacjaKalkulatora_ustawionoDobryTypUmowyIPodstaweWymiaruSkladek()
    {
        TaxCalculator taxCalculator1 = new TaxCalculator(podstawaWymiaruSkladek, typUmowy);
        assertEquals(podstawaWymiaruSkladek, taxCalculator1.getPodstawaWymiaruSkladek(), bias);
        assertEquals(typUmowy, taxCalculator1.getTypUmowy());
    }


    @Test
    public void wynagrodzenieNetto()
    {
        assertEquals(wynagrodzenieNetto_oczekiwane, taxCalculator.getWynagrodzenie(), bias);
    }

    @Test
    public void kosztyUzyskaniaPrzychodu()
    {
        assertEquals(kosztyUzyskaniaPrzychodu_oczekiwane, taxCalculator.getKosztyUzyskania(), bias);
    }

    @Test
    public void podstawaOpodatkowania()
    {
        assertEquals(podstawaOpodatkowania_oczekiwane, taxCalculator.getPodstawaOpodatkowania(), bias);
        assertEquals(podstawaOpodatkowaniaZaokraglona_oczekiwane, taxCalculator.getPodstawaOpodatkowania_zaokraglone(), bias);
    }

    @Test
    public void podatekDochodowy()
    {
        assertEquals(zaliczkaPodatekDochodowy_oczekiwane, taxCalculator.getZaliczkaNaPodatekDochodowy(), bias);
        assertEquals(kwotaWolnaOdPodatku_oczekiwane, taxCalculator.getKwotaZmiejszajacaPodatek(), bias);
        assertEquals(podatekPotracony_oczekiwane, taxCalculator.getPodatekPotracony(), bias);
    }

    @Test
    public void urzadSkarbowy()
    {
        assertEquals(zaliczkaDoUrzeduSkarbowego_oczekiwane, taxCalculator.getZaliczkaDoUrzeduSkarbowego(), bias);
        assertEquals(zaliczkaDoUrzeduSkarbowegoZaokraglony_oczekiwane, taxCalculator.getZaliczkaDoUrzeduSkarbowegoFormatted(), bias);
    }


}