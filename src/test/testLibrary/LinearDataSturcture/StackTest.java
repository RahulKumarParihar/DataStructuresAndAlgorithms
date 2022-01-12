package LinearDataSturcture;

import DataStructures.Stack.Stack;
import DataStructures.Stack.StackLinkedListImplementation;
import DataStructures.Stack.StackArrayImplementation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StackTest {
    private final int CAPACITY_1 = 1;
    private final int CAPACITY_10 = 10;

    private Stack<Integer> stack = null;

    @Test(expected = RuntimeException.class)
    public void linkedListOverflow(){
        stack = new StackLinkedListImplementation<Integer>(CAPACITY_1);
        stack.push(1);
        stack.push(2);
    }

    @Test(expected = RuntimeException.class)
    public void arrayListOverflow(){
        stack = new StackArrayImplementation<Integer>(CAPACITY_1);
        stack.push(1);
        stack.push(2);
    }

    @Test(expected = RuntimeException.class)
    public void linkedListUnderflow(){
        stack = new StackLinkedListImplementation<Integer>(CAPACITY_1);
        stack.push(1);
        stack.pop();
        stack.pop();
    }

    @Test(expected = RuntimeException.class)
    public void arrayListUnderflow(){
        stack = new StackArrayImplementation<Integer>(CAPACITY_1);
        stack.push(1);
        stack.pop();
        stack.pop();
    }

    @Test(expected = RuntimeException.class)
    public void linkedListSeekUnderflow(){
        stack = new StackLinkedListImplementation<Integer>(CAPACITY_1);
        stack.push(1);
        stack.pop();
        stack.seek();
    }

    @Test(expected = RuntimeException.class)
    public void arraySeekUnderflow(){
        stack = new StackArrayImplementation<Integer>(CAPACITY_1);
        stack.push(1);
        stack.pop();
        stack.seek();
    }

    @Test
    public void linkedListSize(){
        stack = new StackLinkedListImplementation<Integer>(CAPACITY_10);
        stack.push(1);
        stack.push(2);
        stack.pop();

        assertThat(stack.getSize(), is(1));
    }

    @Test
    public void arraySize(){
        stack = new StackArrayImplementation<Integer>(CAPACITY_10);
        stack.push(1);
        stack.push(2);
        stack.pop();

        assertThat(stack.getSize(), is(1));
    }

    @Test
    public void linkedListIsEmptyTrue(){
        stack = new StackLinkedListImplementation<Integer>(CAPACITY_1);
        stack.push(1);
        stack.pop();

        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void arrayIsEmptyTrue(){
        stack = new StackArrayImplementation<Integer>(CAPACITY_1);
        stack.push(1);
        stack.pop();

        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void linkedListIsEmptyFalse(){
        stack = new StackLinkedListImplementation<Integer>(CAPACITY_1);
        stack.push(1);

        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void arrayIsEmptyFalse(){
        stack = new StackArrayImplementation<Integer>(CAPACITY_1);
        stack.push(1);

        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void linkedListIsFullTrue(){
        stack = new StackLinkedListImplementation<Integer>(CAPACITY_1);
        stack.push(1);

        assertThat(stack.isFull(), is(true));
    }

    @Test
    public void arrayIsFullTrue(){
        stack = new StackArrayImplementation<Integer>(CAPACITY_1);
        stack.push(1);

        assertThat(stack.isFull(), is(true));
    }

    @Test
    public void linkedListIsFullFalse(){
        stack = new StackLinkedListImplementation<Integer>(CAPACITY_1);
        stack.push(1);
        stack.pop();

        assertThat(stack.isFull(), is(false));
    }

    @Test
    public void arrayIsFullFalse(){
        stack = new StackArrayImplementation<Integer>(CAPACITY_1);
        stack.push(1);
        stack.pop();

        assertThat(stack.isFull(), is(false));
    }

    @Test
    public void linkedListSeek(){
        stack = new StackLinkedListImplementation<Integer>(CAPACITY_10);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.push(4);
        stack.pop();

        assertThat(stack.seek(), is(3));
    }

    @Test
    public void arraySeek(){
        stack = new StackArrayImplementation<Integer>(CAPACITY_10);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.push(4);
        stack.pop();

        assertThat(stack.seek(), is(3));
    }

    @Test
    public void linkedListAcceptance(){
        stack = new StackLinkedListImplementation<Integer>(CAPACITY_10);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.push(5);

        assertThat(stack.getAllElements(), is(getAllElementsResultExpected()));
    }

    @Test
    public void arrayAcceptance(){
        stack = new StackArrayImplementation<Integer>(CAPACITY_10);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.push(5);

        assertThat(stack.getAllElements(), is(getAllElementsResultExpected()));
    }

    private List<Integer> getAllElementsResultExpected() {
        return new ArrayList<>(Arrays.asList(1, 3, 5));
    }
}
