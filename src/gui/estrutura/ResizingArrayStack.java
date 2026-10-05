package gui.estrutura;

/**
 *
 * @author Júlio César Dias Garcia
 */

public class ResizingArrayStack<T> implements Stack<T> {

    private T[] values;
    private int top;
    private int tamanho;

    public ResizingArrayStack() {
        values = (T[]) new Object[10];
        top = 0;
        tamanho = 0;
    }

    @Override
    public void push(T value) {
        if (tamanho == values.length) {
            resize(2 * values.length);
        }
        values[top] = value;
        top++;
        tamanho++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        top--;
        tamanho--;
        T item = values[top];
        values[top] = null;

        if (tamanho > 0 && tamanho == values.length / 4) {
            resize(values.length / 2);
        }

        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return values[top - 1];
    }

    @Override
    public void clear() {
        values = (T[]) new Object[10];
        top = 0;
        tamanho = 0;
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < tamanho; i++) {
            temp[i] = values[i];
        }
        values = temp;
    }

    public T get(int index) {
        if (index < 0 || index >= tamanho) {
            return null;
        }
        return values[index];
    }
}