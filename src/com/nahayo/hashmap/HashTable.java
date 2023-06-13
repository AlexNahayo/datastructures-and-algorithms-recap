package com.nahayo.hashmap;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {
    LinkedList [] hashTableArray;
    LinkedList chaining;
    //Todo -> Put, Get remove methods
    //put(k,v)
    //get(k) returns v
    //remove(k)
    // Key -> int
    // Value -> String
    // Collision -> chaining methods

    public void put(int key, String value){
        LinkedList<String> linkedList;
        if(key > hashTableArray.length) {
            key = hash(key);
        }
        if(hashTableArray[key] != null){
            hashTableArray[key].add(value);
        }
        else {
            linkedList = new LinkedList();
            linkedList.add(value);
            hashTableArray[key] = linkedList;
        }
    }

    public LinkedList get (int key){
        if (keyOutOfBounds(key)){
            throw new IndexOutOfBoundsException();
        }
        return hashTableArray[key];
    }

    public void remove(int key){
        if (keyOutOfBounds(key)){
            throw new IndexOutOfBoundsException();
        }
        hashTableArray[key].removeLast();
    }

    public HashTable(int size) {
        hashTableArray = new LinkedList[size];
    }

    private int hash(int number){
        return number % hashTableArray.length;
    }

    private boolean keyOutOfBounds(int key){
        return key > hashTableArray.length || key < 0;
    }

    @Override
    public String toString() {
        return  Arrays.toString(hashTableArray);
    }
}
