package structures.stack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayBasedStack<T> implements Stack<T> {

  private static final int DEFAULT_SIZE = 5;
  private static final int SIZE_MULTIPLIER = 2;

  private T[] nodes;
  private Integer index = 0;

  public ArrayBasedStack(Class<T> clazz) {
    nodes = (T[]) Array.newInstance(clazz, DEFAULT_SIZE);
  }

  public ArrayBasedStack(T[] nodes) {
    this.nodes = nodes;
  }

  @Override
  public void push(T node) {
    if (index == nodes.length - 1) {
      nodes = Arrays.copyOf(nodes, nodes.length * SIZE_MULTIPLIER);
    }
    index++;
    nodes[index] = node;
  }

  @Override
  public T pop() {

    if (index == 0) {
      return null;
    }

    T node = nodes[index];
    nodes[index] = null;
    index--;
    return node;
  }

  @Override
  public T peak() {
    return nodes[index - 1];
  }

  @Override
  public boolean isEmpty() {
    return index == 0;
  }

  @Override
  public Stack<T> reverse() {
    Stack<T> reverseStack = new MapBasedStack<>();

    for (int i = index - 1; i > 0; i--) {
      reverseStack.push(nodes[i]);
    }

    return reverseStack;
  }

  @Override
  public int size() {
    return index;
  }
}
