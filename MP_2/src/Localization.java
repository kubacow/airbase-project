import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Localization implements Serializable {

    private List<Localization> extent = new ArrayList<>();
    private String region;
    private double XCoordinate;
    private double YCoordinate;
    private double localeCode;
    private Base base;

    public Localization(String region, double XCoordinate, double YCoordinate) {
        this.region = region;
        this.XCoordinate = XCoordinate;
        this.YCoordinate = YCoordinate;
        setLocaleCode(XCoordinate, YCoordinate);

        extent.add(this);
    }

    public void setLocaleCode(double x, double y) {
        localeCode = x + y;
    }
    public void setBase(Base base) {
        if (this.base == null) {
            this.base = base;
            base.addLocalization(this);
        }
    }

    public void removeBase() {
        if (base != null) {
            base.removeLocalization(this);
            base = null;
        }
    }

    @Override
    public String toString() {
        return "Region: " + getRegion() + " || X: " + getXCoordinate() + " || Y: " + getYCoordinate() + " || Locale Code: " + getLocaleCode();
    }
}
