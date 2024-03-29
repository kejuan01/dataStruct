//DO NOT REMOVE PACKAGE LINE
//Without this line authograder will not run correctly
//You can comment it while you work on the problem
//When everything works - uncomment and submit!
//package com.gradescope.hw3;

//Due to authograder and junit limitation this class will have to be a separate public class
//However, the best practice is to make it private class inside the List object
public class DoubleIntNode {
    //add instance variables/fields to match picture in directions
    public int data;
    public DoubleIntNode prev;
    public DoubleIntNode next;

    //add constructor
    public DoubleIntNode(int data){
        //initialize all fields
        this.data = data;
        this.prev = null ;
        this.next = null;
    }
    //add secong constructor
    public DoubleIntNode(DoubleIntNode prev, int data, DoubleIntNode next){
        //initialize all fields use this key word
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}