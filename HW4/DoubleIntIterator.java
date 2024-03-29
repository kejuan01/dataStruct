//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
//package com.gradescope.hw4;

/*Header
/HW4
/Names:
*/
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleIntIterator implements Iterator<Integer>{
    //Create instance variable/fields  as needed (suggested a list and node)
    public DoubleIntList list;
    public DoubleIntNode node;
    private int index;

    public DoubleIntIterator(DoubleIntList list){
        //initialize fields
        this.list = list;
        this.node = list.getFront();
        this.index = 0;

    }

    @Override
    public boolean hasNext() {
        return node != null;
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();

        int value = node.data;
        node = node.next;
        index++;
        return value;
    }

    public void remove() {
        //use remove method for DoubleIntList
        if (index == 0) return;
        list.remove(--index);
    }
}