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

    public BigDecimal getKosztyUzyskania()
    {
        return null;
    }

    public BigDecimal getPodstawaOpodatkowania()
    {
        return null;
    }

    public BigDecimal getPodstawaOpodatkowania_zaokraglone()
    {
        return null;
    }

    public BigDecimal getKwotaZmiejszajacaPodatek()
    {
        return null;
    }

}
