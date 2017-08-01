/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dllist.Dllist;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Education Unlimited
 */
public class DllistTest {
    
    @Test
    public void deleteTestFirst() {
    Dllist d = new Dllist();
    d.insert("word", Dllist.position.FIRST);
    d.insert("by", Dllist.position.LAST);
    d.setPosition(Dllist.position.LAST);
    d.insert("god", Dllist.position.PREVIOUS);
    d.insert("hi", Dllist.position.FOLLOWING);
    d.setPosition(Dllist.position.FIRST);
    d.delete();
    d.setPosition(Dllist.position.FIRST);
    assertEquals("god", d.getItem());
    
    }
     @Test
    public void deleteTestMid() {
    Dllist d = new Dllist();
    d.insert("word", Dllist.position.FIRST);
    d.insert("by", Dllist.position.LAST);
    d.setPosition(Dllist.position.LAST);
    d.insert("god", Dllist.position.PREVIOUS);
    d.insert("hi", Dllist.position.FOLLOWING);
    d.delete();
    d.setPosition(Dllist.position.FIRST);
    assertEquals("god" , d.getItem());
}
}
