class MinStack {

    List<Integer> stack;
    int topPtr; //points at index of current top elem. -1 = empty.

    public MinStack() {
        stack = new ArrayList();
        topPtr = -1;
    }
    
    public void push(int val) {
        stack.add(val);
        topPtr++;
    }
    
    public void pop() {
        stack.remove(topPtr);
        topPtr--;
    }
    
    public int top() {
        return stack.get(topPtr);
    }
    
    public int getMin() {
        return Collections.min(stack);
    }
}
