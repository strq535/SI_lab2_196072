import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SILab2Test {
    private final SILab2 labor = new SILab2();
    private List<Time> List = new ArrayList<>();
    private List<Integer> rezultat = new ArrayList<>();

    @Test
    public void MultipleCondition() {
        List<Time> lista1 = new ArrayList<>();
        lista1.add(new Time(-1,30,30));
        List<Time> lista2 = new ArrayList<>();
        lista2.add(new Time(25,30,30));
        List<Time> lista3 = new ArrayList<>();
        lista3.add(new Time(12,30,30));
        List<Time> lista4 = new ArrayList<>();
        lista4.add(new Time(12,-1,30));
        List<Time> lista5 = new ArrayList<>();
        lista5.add(new Time(12,61,30));
        List<Time> lista6 = new ArrayList<>();
        lista6.add(new Time(12,30,-1));
        List<Time> lista7 = new ArrayList<>();
        lista7.add(new Time(12,30,61));
        List<Time> lista8 = new ArrayList<>();
        lista8.add(new Time(24,0,0));
        List<Time> lista9 = new ArrayList<>();
        lista9.add(new Time(24,0,1));
        List<Time> lista10 = new ArrayList<>();
        lista10.add(new Time(24,1,1));

        RuntimeException exception = null;

        try{
            labor.function(lista1);
        }
        catch (RuntimeException ex){
            exception=ex;
        }
        assertEquals("The hours are smaller than the minimum", exception.getMessage());

        try{
            labor.function(lista2);
        }
        catch (RuntimeException ex){
            exception=ex;
        }
        assertEquals("The hours are greater than the maximum", exception.getMessage());

        rezultat.add(14706);
        assertEquals(rezultat, labor.function(lista3));

        try{
            labor.function(lista4);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The minutes are not valid", exception.getMessage());

        try{
            labor.function(lista5);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The minutes are not valid", exception.getMessage());

        try{
            labor.function(lista6);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The seconds are not valid", exception.getMessage());

        try{
            labor.function(lista7);
        }catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The seconds are not valid", exception.getMessage());

        rezultat.remove(0);
        rezultat.add(86400);
        assertEquals(rezultat, labor.function(lista8));

        try{
            labor.function(lista9);
        }catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The time is greater than the maximum", exception.getMessage());

        try{
            labor.function(lista10);
        }catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The time is greater than the maximum", exception.getMessage());
    }

    @Test
    public void EveryBranch() {
        List<Time> lista1 = new ArrayList<>();
        List<Time> lista2 = new ArrayList<>();
        lista2.add(new Time(-1,45,45));
        List<Time> lista3 = new ArrayList<>();
        lista3.add(new Time(25,45,45));
        List<Time> lista4 = new ArrayList<>();
        lista4.add(new Time(22,-2,2));
        List<Time> lista5 = new ArrayList<>();
        lista5.add(new Time(22,2,-2));
        List<Time> lista6 = new ArrayList<>();
        lista6.add(new Time(22,2,2));
        List<Time> lista7 = new ArrayList<>();
        lista7.add(new Time(24,0,0));
        List<Time> lista8 = new ArrayList<>();
        lista8.add(new Time(24,2,2));


        rezultat = labor.function(lista1);
        assertTrue(rezultat.isEmpty());

        RuntimeException exception = null;

        try{
            labor.function(lista2);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The hours are smaller than the minimum", exception.getMessage());

        try{
            labor.function(lista3);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The hours are greater than the maximum", exception.getMessage());

        try{
            labor.function(lista4);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The minutes are not valid", exception.getMessage());

        try{
            labor.function(lista5);
        }
        catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The seconds are not valid", exception.getMessage());

        rezultat.add(79322);
        assertEquals(rezultat, labor.function(lista6));

        rezultat.remove(0);
        rezultat.add(86400);
        assertEquals(rezultat, labor.function(lista7));

        try{
            labor.function(lista8);
        }catch (RuntimeException ex){
            exception =ex;
        }
        assertEquals("The time is greater than the maximum", exception.getMessage());
    }

}