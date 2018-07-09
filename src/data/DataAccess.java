/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;
import java.util.ArrayList;
/**
 *
 * @author icbt
 */
public interface DataAccess {
     int add(Object ob);
     int delete(int id);
     int update(Object ob);
     Object get(int id);
     ArrayList<Object> getAll();
}
