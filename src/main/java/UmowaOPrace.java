import java.math.BigDecimal;

/**
 * Created by Paulina Sadowska on 25.05.2016.
 */
public class UmowaOPrace implements TypUmowyStrategia
{
    private final TypUmowy typUmowy = TypUmowy.umowaOPrace;

    public TypUmowy getTypUmowy()
    {
        return typUmowy;
    }

    public BigDecimal getKosztyUzyskania(BigDecimal podstawaSkladkiZdrowotnej)
    {
        return new BigDecimal(111.25);
    }


    public BigDecimal getKwotaZmiejszajacaPodatek()
    {
        return new BigDecimal(46.33);
    }

}
