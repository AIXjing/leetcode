import java.util.Stack;

/**
 * @source: https://leetcode.com/problems/implement-queue-using-stacks/
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class MyQueue {
    private Stack<Integer> queue;

    public MyQueue() {
        this.queue = new Stack<Integer>();
    }

    public void push(int x) {
        // prepare a new stack tmp
        Stack<Integer> tmp = new Stack<>();
        // pop out each of the element in queue and place them into tmp
        while (!queue.empty()) {
            tmp.push(queue.pop());
        }
        queue.push(x);
        // once push x to the original stack, then take element from tmp and place it to queue
        while(!tmp.empty()) {
            queue.push(tmp.pop());
        }
    }

    public int pop() {
        return queue.pop();
    }

    public int peek() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.empty();
    }
}
