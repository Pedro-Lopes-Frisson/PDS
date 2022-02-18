package ex3;

public class Available implements State {
    @Override
    public void register(Book wBook) {
        throw new UnsupportedOperationException("Operation not available.");
    }

    @Override
    public void reserve(Book wBook) {
        wBook.setState(new Reserved());
    }

    @Override
    public void cancelReserve(Book wBook) {
        throw new UnsupportedOperationException("Operation not available.");
    }

    @Override
    public void giveBack(Book wBook) {
        throw new UnsupportedOperationException("Operation not available.");
    }

    @Override
    public void take(Book wBook) {
        wBook.setState(new Borrowed());
    }
}
