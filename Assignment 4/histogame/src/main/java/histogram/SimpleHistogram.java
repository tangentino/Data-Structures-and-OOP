package histogram;

import java.util.*;

public class SimpleHistogram<DT> implements Histogram<DT>, Iterable<DT> {
    private HashMap<DT,Integer> histMap;

    public SimpleHistogram() {
        histMap = new HashMap<DT,Integer>();
    }

    public SimpleHistogram(DT items[]) {
        histMap = new HashMap<DT,Integer>();
        int occurrences = 0;
        for (DT i : items) {
            for (DT j : items) {
                if (i.equals(j) || i == j) {
                    occurrences += 1;
                }
            }
            histMap.put(i,occurrences);
            occurrences = 0;
        }
    }
    public SimpleHistogram(Histogram hist) {
        histMap = new HashMap<DT,Integer>();
        Iterator<DT> it = hist.iterator();
        while (it.hasNext()) {
            DT current = it.next();
            histMap.put(current,hist.getCount(current));
        }
    }

    public int getTotalCount() {
        int total = 0;
        for (Integer value : histMap.values() ) {
            total += value;
        }
        return total;
    }
    public int getCount(DT item) {
        return histMap.get(item);
    }
    public void setCount(DT item, int count) {
        histMap.put(item,count);
    }

    public String toString() {
        return histMap.toString();
    }
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Histogram) {
            if  (((Histogram) o).getTotalCount() != this.getTotalCount()) {
                return false;
            }
            Iterator<DT> itThis = this.iterator();
            Iterator<DT> itO = ((Histogram) o).iterator();
            while (itThis.hasNext() || itO.hasNext()) {
                DT current = itThis.next();
                DT oCurrent = itO.next();
                if (!current.equals(oCurrent) || this.getCount(current) != ((Histogram) o).getCount(current)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Iterator<DT> iterator() {
        Iterator it = histMap.keySet().iterator();
        return it;
    }
}

