/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomCreator;
import clases_dominio.*;
import java.util.Random;
/**
 *
 * @author estre
 */
public class RandomCreator {
    
    
    
    
    
    
    private Lectura[] createLecturas(){
        int cantLecturas = randomInt(3,50);
        return null;
        
    }
    
    private int randomInt(int minimum,int maximum){
        Random random = new Random();
        return minimum + random.nextInt(maximum);
    }
}
