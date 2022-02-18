package ex3;

public interface State {
    public void register(Book wBook);

    public void reserve(Book wBook);

    public void cancelReserve(Book wBook);

    public void giveBack(Book wBook);

    public void take(Book wBook);
}
