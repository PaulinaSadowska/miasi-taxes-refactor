import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIGlobalBinding;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static org.junit.Assert.*;

/**
 * Created by Paulina Sadowska on 25.05.2016.
 */
public class UbezpieczeniaTest
{

    private final double bias = 0.02;

    private final TypUmowy typUmowy = TypUmowy.umowaOPrace;
    private final BigDecimal podstawaWymiaruSkladek = new BigDecimal(3000);

    private final double skladkaUbezpieczenieEmerytalne_oczekiwane = 292.80;
    private final double skladkaUbezpieczenieRentowe_oczekiwane = 45;
    private final double skladkaUbezpieczenieChorobowe_oczekiwane = 73.50;
    private final double podstawaSkladkiZdrowotnej_oczekiwane = 2588.7;
    private final double skladkaUbezpieczenieZdrowotne_7_75procent_oczekiwane = 200.62;
    private final double skladkaUbezpieczenieZdrowotne_9procent_oczekiwane = 232.98;

    private KalkulatorPodatkowy taxCalculator;

    @Before
    public void setUp()
    {
        taxCalculator = new KalkulatorPodatkowy(podstawaWymiaruSkladek, typUmowy);
        Printer p = new Printer(taxCalculator);
        p.print();
    }


    @Test
    public void ubezpieczenieEmerytalne()
    {
        assertEquals(skladkaUbezpieczenieEmerytalne_oczekiwane, taxCalculator.getSkladkaEmerytalna().doubleValue(), bias);
    }

    @Test
    public void ubezpieczenieRentowe()
    {
        assertEquals(skladkaUbezpieczenieRentowe_oczekiwane, taxCalculator.getSkladkaRentowa().doubleValue(), bias);
    }

    @Test
    public void ubezpieczenieChorobowe()
    {
        assertEquals(skladkaUbezpieczenieChorobowe_oczekiwane, taxCalculator.getSkladkaChorobowa().doubleValue(), bias);
    }

    @Test
    public void podstawaWymiaruSkladkiUbezpieczenieZdrowotne()
    {
        assertEquals(podstawaSkladkiZdrowotnej_oczekiwane, taxCalculator.getPodstawaSkladkiZdrowotnej().doubleValue(), bias);
    }

    @Test
    public void skladkiUbezpieczenieZdrowotne()
    {
        assertEquals(skladkaUbezpieczenieZdrowotne_7_75procent_oczekiwane, taxCalculator.getSkladkaZdrowotna_7_75().doubleValue(), bias);
        assertEquals(skladkaUbezpieczenieZdrowotne_9procent_oczekiwane, taxCalculator.getSkladkaZdrowotna_9().doubleValue(), bias);
    }

}
