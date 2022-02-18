package ex3;

public class Borrowed implements State {
    @Override
    public void register(Book wBook) {
        throw new UnsupportedOperationException("Operation not available.");
    }

    @Override
    public void reserve(Book wBook) {
        throw new UnsupportedOperationException("Operation not available.");
    }

    @Override
    public void cancelReserve(Book wBook) {
        throw new UnsupportedOperationException("Operation not available.");
    }

    @Override
    public void giveBack(Book wBook) {
        wBook.setState(new Available());
    }

    @Override
    public void take(Book wBook) {
        throw new UnsupportedOperationException("Operation not available.");
    }
}
