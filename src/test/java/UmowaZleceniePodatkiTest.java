import org.junit.Before;
import org.junit.Test;
import original.TaxCalculator;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by Paulina Sadowska on 20.05.2016.
 */
public class UmowaZleceniePodatkiTest
{
    private final double bias = 0.02;


    private final TypUmowy typUmowy = TypUmowy.umowaZlecenie;
    private final BigDecimal podstawaWymiaruSkladek = new BigDecimal(3000);
    //INNE
    private final double kosztyUzyskaniaPrzychodu_oczekiwane = 517.74;
    private final double podstawaOpodatkowania_oczekiwane = 2070.96;
    private final double podstawaOpodatkowaniaZaokraglona_oczekiwane = 2071;
    private final double zaliczkaPodatekDochodowy_oczekiwane = 372.78;
    private final double podatekPotracony_oczekiwane = 372.78;
    private final double zaliczkaDoUrzeduSkarbowego_oczekiwane = 172.16;
    private final double wynagrodzenieNetto_oczekiwane = 2183.72;

    private KalkulatorPodatkowy taxCalculator;


    @Before
    public void setUp()
    {
        taxCalculator = new KalkulatorPodatkowy(podstawaWymiaruSkladek, typUmowy);
    }

    @Test
    public void inicjalizacjaKalkulatora_ustawionoDobryTypUmowyIPodstaweWymiaruSkladek()
    {
        KalkulatorPodatkowy taxCalculator1 = new KalkulatorPodatkowy(podstawaWymiaruSkladek, typUmowy);
        assertEquals(podstawaWymiaruSkladek, taxCalculator1.getPodstawaWymiaruSkladek());
        assertEquals(typUmowy, taxCalculator1.getTypUmowy());
    }

    @Test
    public void wynagrodzenieNetto()
    {
        assertEquals(wynagrodzenieNetto_oczekiwane, taxCalculator.getWynagrodzenie().doubleValue(), bias);
    }

    @Test
    public void kosztyUzyskaniaPrzychodu()
    {
        assertEquals(kosztyUzyskaniaPrzychodu_oczekiwane, taxCalculator.getKosztyUzyskania().doubleValue(), bias);
    }

    @Test
    public void podstawaOpodatkowania()
    {
        assertEquals(podstawaOpodatkowania_oczekiwane, taxCalculator.getPodstawaOpodatkowania().doubleValue(), bias);
        assertEquals(podstawaOpodatkowaniaZaokraglona_oczekiwane, taxCalculator.getPodstawaOpodatkowania_zaokraglone().doubleValue(), bias);
    }

    @Test
    public void podatekDochodowy()
    {
        assertEquals(zaliczkaPodatekDochodowy_oczekiwane, taxCalculator.getZaliczkaNaPodatekDochodowy().doubleValue(), bias);
        assertEquals(podatekPotracony_oczekiwane, taxCalculator.getPodatekPotracony().doubleValue(), bias);
    }

    @Test
    public void urzadSkarbowy()
    {
        assertEquals(zaliczkaDoUrzeduSkarbowego_oczekiwane, taxCalculator.getZaliczkaDoUrzeduSkarbowego().doubleValue(), bias);
    }
}
