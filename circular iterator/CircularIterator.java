static class CircularIterator<T> implements Iterator<T> {
    private final List<T> list;
    private Iterator<T> iterator;

    CircularIterator(List<T> list) {
      this.list = list;
      this.iterator = list.iterator();
    }

    @Override
    public boolean hasNext() {
      return !list.isEmpty();
    }

    @Override
    public T next() {
      if (!iterator.hasNext()) {
        iterator = list.iterator();
      }
      return iterator.next();
    }
    
    public void skip(int n) {
      while (--n >= 0 && hasNext()) {
        next();
      }
    }

    @Override
    public void remove() {
      iterator.remove();
    }
}