import org.junit.Before;
import org.junit.Test;
import original.TaxCalculator;

import static org.junit.Assert.assertEquals;

/**
 * Created by Paulina Sadowska on 25.05.2016.
 */
public class UbezpieczeniaTest
{
    private final double bias = 0.02;

    private final char typUmowy = 'P';
    private final double podstawaWymiaruSkladek = 3000;
    private final double skladkaUbezpieczenieEmerytalne_oczekiwane = 292.80;
    private final double skladkaUbezpieczenieRentowe_oczekiwane = 45;
    private final double skladkaUbezpieczenieChorobowe_oczekiwane = 73.50;
    private final double podstawaSkladkiZdrowotnej_oczekiwane = 2588.7;
    private final double skladkaUbezpieczenieZdrowotne_7_75procent_oczekiwane = 200.62;
    private final double skladkaUbezpieczenieZdrowotne_9procent_oczekiwane = 232.98;

    private TaxCalculator taxCalculator;

    @Before
    public void setUp()
    {
        taxCalculator = new TaxCalculator(podstawaWymiaruSkladek, typUmowy);
    }


    @Test
    public void ubezpieczenieEmerytalne()
    {
        assertEquals(skladkaUbezpieczenieEmerytalne_oczekiwane, taxCalculator.skladkaEmerytalna, bias);
    }

    @Test
    public void ubezpieczenieRentowe()
    {
        assertEquals(skladkaUbezpieczenieRentowe_oczekiwane, taxCalculator.skladkaRentowa, bias);
    }

    @Test
    public void ubezpieczenieChorobowe()
    {
        assertEquals(skladkaUbezpieczenieChorobowe_oczekiwane, taxCalculator.skladkaChorobowa, bias);
    }

    @Test
    public void podstawaWymiaruSkladkiUbezpieczenieZdrowotne()
    {
        assertEquals(podstawaSkladkiZdrowotnej_oczekiwane, taxCalculator.podstawaSkladkiZdrowotnej, bias);
    }

    @Test
    public void skladkiUbezpieczenieZdrowotne()
    {
        assertEquals(skladkaUbezpieczenieZdrowotne_7_75procent_oczekiwane, taxCalculator.skladkaZdrowotna2, bias);
        assertEquals(skladkaUbezpieczenieZdrowotne_9procent_oczekiwane, taxCalculator.skladkaZdrowotna1, bias);
    }

}
