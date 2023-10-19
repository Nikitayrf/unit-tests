package lectures.lecture4;


import java.util.List;

import static org.mockito.Mockito.*;

public class Mockito {
    public static void main(String[] args) {
        List mockedList = mock( List.class ); // List.class - тип создаваемой заглушки

        mockedList.add( "one" );
        System.out.println( mockedList.get( 0 ) );
        mockedList.clear();

    }

}
