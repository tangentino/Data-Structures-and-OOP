package histogram;

public interface Histogram<DT> extends Iterable<DT> {
    // Returns the total frequency count of all items in the domain combined.
    public int getTotalCount();

    // Returns the frequency count of a given domain item. If invalid domain
    // item is given, return 0.
    public int getCount(DT item);

    // Sets the frequecy count of a given domain item. If the  domain item
    // doesn't yet exist in the domain, this will also add it to the domain.
    public void setCount(DT item, int count);
}