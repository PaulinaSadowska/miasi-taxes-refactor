import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import original.TaxCalculator;

import java.math.BigDecimal;

/**
 * Created by Paulina Sadowska on 20.05.2016.
 */
public class UmowaOPracePodatkiTest
{

    private final double bias = 0.02;

    private final TypUmowy typUmowy = TypUmowy.umowaOPrace;
    private final BigDecimal podstawaWymiaruSkladek = new BigDecimal(3000);

    private final double kosztyUzyskaniaPrzychodu_oczekiwane = 111.25;
    private final double podstawaOpodatkowania_oczekiwane = 2477.45;
    private final double podstawaOpodatkowaniaZaokraglona_oczekiwane = 2477;
    private final double zaliczkaPodatekDochodowy_oczekiwane = 445.86;
    private final double kwotaWolnaOdPodatku_oczekiwane = 46.33;
    private final double podatekPotracony_oczekiwane = 399.53;
    private final double zaliczkaDoUrzeduSkarbowego_oczekiwane = 198.91;
    private final double wynagrodzenieNetto_oczekiwane = 2156.72;

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
        assertEquals(kwotaWolnaOdPodatku_oczekiwane, taxCalculator.getKwotaZmiejszajacaPodatek().doubleValue(), bias);
        assertEquals(podatekPotracony_oczekiwane, taxCalculator.getPodatekPotracony().doubleValue(), bias);
    }

    @Test
    public void urzadSkarbowy()
    {
        assertEquals(zaliczkaDoUrzeduSkarbowego_oczekiwane, taxCalculator.getZaliczkaDoUrzeduSkarbowego().doubleValue(), bias);
    }


}
