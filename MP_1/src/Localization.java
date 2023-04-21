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
    private int XCoordinate;
    private int YCoordinate;

    public Localization(String region, int XCoordinate, int YCoordinate) {
        this.region = region;
        this.XCoordinate = XCoordinate;
        this.YCoordinate = YCoordinate;

        extent.add(this);
    }

    @Override
    public String toString() {
        return "\tRegion: " + getRegion() + " || X: " + getXCoordinate() + " || Y: " + getYCoordinate();
    }
}
