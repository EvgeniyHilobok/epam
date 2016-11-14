package by.epam.airline.comparators;

import by.epam.airline.entity.Plane;

import java.util.Comparator;

public class PlaneRangeOfFlightComparator implements Comparator<Plane> {
    private boolean sortFlag;

    public PlaneRangeOfFlightComparator(boolean sortFlag) {
        this.sortFlag = sortFlag;
    }

    public int compare(Plane a, Plane b) {
        int compareFlag = 0;
        if (isSortFlag()) {
            compareFlag = ascendingCompare(a, b);
        } else if (!isSortFlag()) {
            compareFlag = descendingCompare(a, b);
        }
        return compareFlag;
    }

    public int ascendingCompare(Plane a, Plane b) {
        int ascendingCompareFlag;
        if (a.getRangeOfFlight() > b.getRangeOfFlight()) {
            ascendingCompareFlag = 1;
        } else if (a.getRangeOfFlight() < b.getRangeOfFlight()) {
            ascendingCompareFlag = -1;
        } else {
            ascendingCompareFlag = 0;
        }
        return ascendingCompareFlag;
    }

    public int descendingCompare(Plane a, Plane b) {
        int descendingCompareFlag;
        if (a.getRangeOfFlight() < b.getRangeOfFlight())
            descendingCompareFlag = 1;
        else if (a.getRangeOfFlight() > b.getRangeOfFlight())
            descendingCompareFlag = -1;
        else
            descendingCompareFlag = 0;
        return descendingCompareFlag;
    }

    public boolean isSortFlag() {
        return sortFlag;
    }
}
