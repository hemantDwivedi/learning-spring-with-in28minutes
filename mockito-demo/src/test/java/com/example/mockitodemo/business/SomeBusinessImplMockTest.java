package com.example.mockitodemo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {
    @Mock
    private DataService dataServiceMock;
    @InjectMocks
    private SomeBusinessImpl business;

    @Test
    void findTheGreatestFromAllData_WithFourValue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {10, 20, 40, 30});
        assertEquals(40, business.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_WithOneValue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {100});
        assertEquals(100, business.findTheGreatestFromAllData());
    }
    @Test
    void findTheGreatestFromAllData_WithZeroValue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, business.findTheGreatestFromAllData());
    }

}