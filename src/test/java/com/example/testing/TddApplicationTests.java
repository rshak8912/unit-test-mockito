package com.example.testing;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class TddApplicationTests {
    List<String> mock = mock(List.class);
    @Test
    public void contextLoads() {

        when(mock.size()).thenReturn(5);
        assertThat(mock.size()).isEqualTo(5);
    }
    @Test
    public void retrunDifferentValues() {

        when(mock.size()).thenReturn(5).thenReturn(10);
        assertThat(mock.size()).isEqualTo(5);
        assertThat(mock.size()).isEqualTo(10);
    }
    @Test
    public void retrunWith() {
        when(mock.get(0)).thenReturn("test");
        assertThat("test").isEqualTo(mock.get(0));
        assertThat(mock.get(1)).isNull();
    }
    @Test
    public void retrunWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("in");
        assertThat("in").isEqualTo(mock.get(0));
        assertThat("in").isEqualTo(mock.get(2));

    }

    @Test
    public void argument() throws Exception {
        mock.add("something");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertThat(captor.getValue()).isEqualTo("something");
    }
    @Test
    public void mocking() throws Exception {
        ArrayList arrayList = mock(ArrayList.class);
        arrayList.get(0);
        arrayList.size();
        arrayList.add("Test");
        arrayList.add("Test2");
        arrayList.size();
        when(arrayList.size()).thenReturn(5);
        System.out.println("arrayList = " + arrayList.size());

        System.out.println("arrayList.get(1) = " + arrayList.get(1));

    }
    @Test
    public void spying() throws Exception {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println("arrayListSpy.size() = " + arrayListSpy.size());
        arrayListSpy.add("Test1");

        when(arrayListSpy.size()).thenReturn(5);
        System.out.println("arrayListSpy.get(1) = " + arrayListSpy.get(1));
        
    }

}
