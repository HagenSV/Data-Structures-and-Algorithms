package edu.dsa.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @Test
    void testSizeAdd(){
        List<Integer> list = new ArrayList<>();
        assertEquals(0,list.size());
        list.add(10);
        assertEquals(1,list.size());
        list.add(0,20);
        assertEquals(2,list.size());
    }

    @Test
    void testAdd(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        assertEquals(50,list.size());
    }

    @Test
    void testInsert(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(0,i);
        }
        assertEquals(9,list.get(0));
    }

    @Test
    void testInsertNegative(){
        List<Integer> list = new ArrayList<>();
        try {
            list.add(-1, 10);
            fail();
        } catch (ArrayIndexOutOfBoundsException ignored){}
    }

    @Test
    void testInsertOutOfBounds(){
        List<Integer> list = new ArrayList<>();
        try {
            list.add(10,10);
            fail();
        } catch (ArrayIndexOutOfBoundsException ignored){

        }
    }

    @Test
    void testEmpty(){
        List<Integer> list = new ArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    void testClear(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(0,i);
        }
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void testContains(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        assertTrue(list.contains(10));
    }

    @Test
    void testNotContains(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        assertFalse(list.contains(-1));
    }

    @Test
    void testIndexOf(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        assertEquals(35,list.indexOf(35));
    }

    @Test
    void testLastIndexOf(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i%10);
        }
        assertEquals(40,list.lastIndexOf(0));
    }

    @Test
    void testIndexNotFound(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        assertEquals(-1,list.indexOf(100));
    }

    @Test
    void testRemoveIndex(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        assertEquals(15,list.remove(15));
    }

    @Test
    void testRemoveNegativeIndex(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        try {
            list.remove(-1);
            fail();
        } catch (ArrayIndexOutOfBoundsException ignored){}
    }

    @Test
    void testRemoveLargeIndex(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        try {
            list.remove(100);
            fail();
        } catch (ArrayIndexOutOfBoundsException ignored){}
    }

    @Test
    void testRemoveIndexReduceSize(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        list.remove(20);
        assertEquals(49,list.size());
    }

    @Test
    void testRemoveValue(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        assertTrue(list.remove(Integer.valueOf(10)));
        assertFalse(list.contains(10));
    }

    @Test
    void testRemoveMissingValue(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        assertFalse(list.remove(Integer.valueOf(-1)));
    }

    @Test
    void testRemoveValueReduceSize(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        list.remove(Integer.valueOf(8));
        assertEquals(49,list.size());
    }

    @Test
    void testRemoveMissingValueRetainSize(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        list.remove(Integer.valueOf(-1));
        assertEquals(50,list.size());
    }

    @Test
    void testSet(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        int old = list.set(10,35);
        assertEquals(10,old);
        assertEquals(35,list.get(10));
    }

    @Test
    void testSetNegative(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        try {
            list.set(-1,20);
            fail();
        } catch (ArrayIndexOutOfBoundsException ignored){}
    }

    @Test
    void testSetOutOfBounds(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++){
            list.add(i);
        }
        try {
            list.set(51, 100);
            fail();
        } catch (ArrayIndexOutOfBoundsException ignored){}
    }
}