/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gui.estrutura;

/**
 * @param <T> Tipo dos elementos armazenados na pilha.
 */
public interface Stack<T> {
    void push(T value);
    T pop();
    T peek();
    void clear();
    boolean isEmpty();
    int getTamanho();
}
