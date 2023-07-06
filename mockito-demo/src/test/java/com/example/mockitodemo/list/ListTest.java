package com.example.mockitodemo.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    public void simpleTest(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(3);
        Assertions.assertEquals(3, listMock.size());
    }
    @Test
    public void multipleReturns(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(3).thenReturn(2);
        Assertions.assertEquals(3, listMock.size());
        Assertions.assertEquals(2, listMock.size());
        Assertions.assertEquals(2, listMock.size());
        Assertions.assertEquals(2, listMock.size());
    }
    @Test
    public void specificParameters(){
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("some string");
        Assertions.assertEquals("some string", listMock.get(0));
        Assertions.assertEquals(null, listMock.get(2));
    }

    @Test
    public void genericParameters(){
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("some other string");
        Assertions.assertEquals("some other string", listMock.get(0));
        Assertions.assertEquals("some other string", listMock.get(2));
    }
}
