import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import original.TaxCalculator;

/**
 * Created by Paulina Sadowska on 20.05.2016.
 */
public class UmowaOPracePodatkiTest
{
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
        assertEquals(podstawaWymiaruSkladek, taxCalculator1.podstawaWymiaruSkladek, 0.01);
        assertEquals(typUmowy, taxCalculator1.typUmowy);
    }


    @Test
    public void wynagrodzenieNetto()
    {
        assertEquals(wynagrodzenieNetto_oczekiwane, taxCalculator.wynagrodzenie, 0.01);
    }

    @Test
    public void kosztyUzyskaniaPrzychodu()
    {
        assertEquals(kosztyUzyskaniaPrzychodu_oczekiwane, taxCalculator.kosztyUzyskania, 0.01);
    }

    @Test
    public void podstawaOpodatkowania()
    {
        assertEquals(podstawaOpodatkowania_oczekiwane, taxCalculator.podstawaOpodatkowania, 0.01);
        assertEquals(podstawaOpodatkowaniaZaokraglona_oczekiwane, taxCalculator.podstawaOpodatkowania_zaokraglone, 0.01);
    }

    @Test
    public void podatekDochodowy()
    {
        assertEquals(zaliczkaPodatekDochodowy_oczekiwane, taxCalculator.zaliczkaNaPodatekDochodowy, 0.01);
        assertEquals(kwotaWolnaOdPodatku_oczekiwane, taxCalculator.kwotaZmiejszajacaPodatek, 0.01);
        assertEquals(podatekPotracony_oczekiwane, taxCalculator.podatekPotracony, 0.01);
    }

    @Test
    public void urzadSkarbowy()
    {
        assertEquals(zaliczkaDoUrzeduSkarbowego_oczekiwane, taxCalculator.zaliczkaDoUrzeduSkarbowego, 0.01);
        assertEquals(zaliczkaDoUrzeduSkarbowegoZaokraglony_oczekiwane, taxCalculator.zaliczkaDoUrzeduSkarbowegoFormatted, 0.01);
    }


}
