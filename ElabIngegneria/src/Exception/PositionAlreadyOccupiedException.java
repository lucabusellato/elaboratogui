/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import java.io.IOException;

/**
 *
 * @author nicolocarello
 */
public class PositionAlreadyOccupiedException extends IOException{
    public PositionAlreadyOccupiedException(String s){
        super(s);
    }
}
