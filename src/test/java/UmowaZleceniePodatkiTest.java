import org.junit.Before;
import org.junit.Test;
import original.TaxCalculator;

import static org.junit.Assert.assertEquals;

/**
 * Created by Paulina Sadowska on 20.05.2016.
 */
public class UmowaZleceniePodatkiTest
{
    private final double bias = 0.02;

    private final char typUmowy = 'Z';
    private final double podstawaWymiaruSkladek = 3000;

    //INNE
    private final double kosztyUzyskaniaPrzychodu_oczekiwane = 517.74;
    private final double podstawaOpodatkowania_oczekiwane = 2070.96;
    private final double podstawaOpodatkowaniaZaokraglona_oczekiwane = 2071;
    private final double zaliczkaPodatekDochodowy_oczekiwane = 372.78;
    private final double podatekPotracony_oczekiwane = 372.78;
    private final double zaliczkaDoUrzeduSkarbowego_oczekiwane = 172.16;
    private final double zaliczkaDoUrzeduSkarbowegoZaokraglony_oczekiwane = 172;
    private final double wynagrodzenieNetto_oczekiwane = 2183.72;

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
        assertEquals(podstawaWymiaruSkladek, taxCalculator1.podstawaWymiaruSkladek, bias);
        assertEquals(typUmowy, taxCalculator1.typUmowy);
    }

    @Test
    public void wynagrodzenieNetto()
    {
        assertEquals(wynagrodzenieNetto_oczekiwane, taxCalculator.wynagrodzenie, bias);
    }

    @Test
    public void kosztyUzyskaniaPrzychodu()
    {
        assertEquals(kosztyUzyskaniaPrzychodu_oczekiwane, taxCalculator.kosztyUzyskania, bias);
    }

    @Test
    public void podstawaOpodatkowania()
    {
        assertEquals(podstawaOpodatkowania_oczekiwane, taxCalculator.podstawaOpodatkowania, bias);
        assertEquals(podstawaOpodatkowaniaZaokraglona_oczekiwane, taxCalculator.podstawaOpodatkowania_zaokraglone, bias);
    }

    @Test
    public void podatekDochodowy()
    {
        assertEquals(zaliczkaPodatekDochodowy_oczekiwane, taxCalculator.zaliczkaNaPodatekDochodowy, bias);
        assertEquals(podatekPotracony_oczekiwane, taxCalculator.podatekPotracony, bias);
    }

    @Test
    public void urzadSkarbowy()
    {
        assertEquals(zaliczkaDoUrzeduSkarbowego_oczekiwane, taxCalculator.zaliczkaDoUrzeduSkarbowego, bias);
        assertEquals(zaliczkaDoUrzeduSkarbowegoZaokraglony_oczekiwane, taxCalculator.zaliczkaDoUrzeduSkarbowegoFormatted, bias);
    }
}