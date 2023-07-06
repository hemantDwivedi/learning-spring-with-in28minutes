package com.example.mockitodemo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplSubTest {

    @Test
    void test(){
        DataServiceStub dataServiceStub = new DataServiceStub();
        SomeBusinessImpl business = new SomeBusinessImpl(dataServiceStub);
        int result = business.findTheGreatestFromAllData();
        assertEquals(30, result);
    }

}

class DataServiceStub implements DataService{
    @Override
    public int[] retrieveAllData() {
        return new int[] {10,20,30};
    }
}