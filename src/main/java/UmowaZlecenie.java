import java.math.BigDecimal;

/**
 * Created by Paulina Sadowska on 25.05.2016.
 */
public class UmowaZlecenie implements TypUmowyStrategia
{

    private final TypUmowy typUmowy = TypUmowy.umowaZlecenie;
    private static final BigDecimal kosztyUzyskania_procent = new BigDecimal(0.2);

    public TypUmowy getTypUmowy()
    {
        return typUmowy;
    }

    public BigDecimal getKosztyUzyskania(BigDecimal podstawaSkladkiZdrowotnej)
    {
        return podstawaSkladkiZdrowotnej.multiply(kosztyUzyskania_procent);
    }

    public BigDecimal getKwotaZmiejszajacaPodatek()
    {
        return new BigDecimal(0);
    }

}
