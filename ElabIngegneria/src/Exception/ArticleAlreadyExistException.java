/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import java.rmi.AlreadyBoundException;

/**
 *
 * @author nicolocarello
 */
public class ArticleAlreadyExistException extends AlreadyBoundException{
    public ArticleAlreadyExistException(String s){
        super(s);
    }
}
