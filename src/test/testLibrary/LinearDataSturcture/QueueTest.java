package LinearDataSturcture;

import Queue.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueueTest {
    private final int CAPACITY_1 = 1;
    private final int CAPACITY_10 = 10;

    private Queue<Integer> stack = null;

    @Test(expected = RuntimeException.class)
    public void linkedListOverflow(){
        stack = new QueueLinkedListImplementation<Integer>(CAPACITY_1);
        stack.offer(1);
        stack.offer(2);
    }

    @Test(expected = RuntimeException.class)
    public void arrayListOverflow(){
        stack = new QueueArrayImplementation<Integer>(CAPACITY_1);
        stack.offer(1);
        stack.offer(2);
    }

    @Test(expected = RuntimeException.class)
    public void linkedListUnderflow(){
        stack = new QueueLinkedListImplementation<Integer>(CAPACITY_1);
        stack.offer(1);
        stack.poll();
        stack.poll();
    }

    @Test(expected = RuntimeException.class)
    public void arrayListUnderflow(){
        stack = new QueueArrayImplementation<Integer>(CAPACITY_1);
        stack.offer(1);
        stack.poll();
        stack.poll();
    }

    @Test(expected = RuntimeException.class)
    public void linkedListPeekUnderflow(){
        stack = new QueueLinkedListImplementation<Integer>(CAPACITY_1);
        stack.offer(1);
        stack.poll();
        stack.peek();
    }

    @Test(expected = RuntimeException.class)
    public void arrayPeekUnderflow(){
        stack = new QueueArrayImplementation<Integer>(CAPACITY_1);
        stack.offer(1);
        stack.poll();
        stack.peek();
    }

    @Test
    public void linkedListSize(){
        stack = new QueueLinkedListImplementation<Integer>(CAPACITY_10);
        stack.offer(1);
        stack.offer(2);
        stack.poll();

        assertThat(stack.getSize(), is(1));
    }

    @Test
    public void arraySize(){
        stack = new QueueArrayImplementation<Integer>(CAPACITY_10);
        stack.offer(1);
        stack.offer(2);
        stack.poll();

        assertThat(stack.getSize(), is(1));
    }

    @Test
    public void linkedListIsEmptyTrue(){
        stack = new QueueLinkedListImplementation<Integer>(CAPACITY_1);
        stack.offer(1);
        stack.poll();

        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void arrayIsEmptyTrue(){
        stack = new QueueArrayImplementation<Integer>(CAPACITY_1);
        stack.offer(1);
        stack.poll();

        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void linkedListIsEmptyFalse(){
        stack = new QueueLinkedListImplementation<Integer>(CAPACITY_1);
        stack.offer(1);

        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void arrayIsEmptyFalse(){
        stack = new QueueArrayImplementation<Integer>(CAPACITY_1);
        stack.offer(1);

        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void linkedListIsFullTrue(){
        stack = new QueueLinkedListImplementation<Integer>(CAPACITY_1);
        stack.offer(1);

        assertThat(stack.isFull(), is(true));
    }

    @Test
    public void arrayIsFullTrue(){
        stack = new QueueArrayImplementation<Integer>(CAPACITY_1);
        stack.offer(1);

        assertThat(stack.isFull(), is(true));
    }

    @Test
    public void linkedListIsFullFalse(){
        stack = new QueueLinkedListImplementation<Integer>(CAPACITY_1);
        stack.offer(1);
        stack.poll();

        assertThat(stack.isFull(), is(false));
    }

    @Test
    public void arrayIsFullFalse(){
        stack = new QueueArrayImplementation<Integer>(CAPACITY_1);
        stack.offer(1);
        stack.poll();

        assertThat(stack.isFull(), is(false));
    }

    @Test
    public void linkedListPeek(){
        stack = new QueueLinkedListImplementation<Integer>(CAPACITY_10);
        stack.offer(1);
        stack.offer(2);
        stack.poll();
        stack.offer(3);
        stack.offer(4);
        stack.poll();

        assertThat(stack.peek(), is(3));
    }

    @Test
    public void arrayPeek(){
        stack = new QueueArrayImplementation<Integer>(CAPACITY_10);
        stack.offer(1);
        stack.offer(2);
        stack.poll();
        stack.offer(3);
        stack.offer(4);
        stack.poll();

        assertThat(stack.peek(), is(3));
    }

    @Test
    public void linkedListAcceptance(){
        stack = new QueueLinkedListImplementation<Integer>(CAPACITY_10);
        stack.offer(1);
        stack.offer(2);
        stack.poll();
        stack.offer(3);
        stack.offer(4);
        stack.poll();
        stack.offer(5);

        assertThat(stack.getAllElements(), is(getAllElementsResultExpected()));
    }

    @Test
    public void arrayAcceptance(){
        stack = new QueueArrayImplementation<Integer>(CAPACITY_10);
        stack.offer(1);
        stack.offer(2);
        stack.poll();
        stack.offer(3);
        stack.offer(4);
        stack.poll();
        stack.offer(5);

        assertThat(stack.getAllElements(), is(getAllElementsResultExpected()));
    }

    private List<Integer> getAllElementsResultExpected() {
        return new ArrayList<>(Arrays.asList(3, 4, 5));
    }
}
