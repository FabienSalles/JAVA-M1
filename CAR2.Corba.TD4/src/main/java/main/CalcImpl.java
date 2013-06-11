/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import calculatrice.CalculatricePOA;
import calculatrice.badParam;
import calculatrice.divZero;
import org.omg.CORBA.Any;
import org.omg.CORBA.TCKind;
import org.omg.CORBA.TypeCode;

/**
 *
 * @author keberne
 */
public class CalcImpl extends CalculatricePOA {
    
    @Override
    public Any sub(Any a, Any b) throws badParam {
        TypeCode typeA = a.type();
        TypeCode typeB = b.type();
        Any sous = this._orb().create_any();
        if(typeA.kind().value()==TCKind._tk_char || typeA.kind().value()==TCKind._tk_string ||
           typeB.kind().value()==TCKind._tk_char || typeB.kind().value()==TCKind._tk_string) {
            throw new badParam("Charactère !");
        }
        else{
            switch(typeA.kind().value()){
                case TCKind._tk_float :
                    switch(typeB.kind().value()){
                        case TCKind._tk_float : sous.insert_float(a.extract_float()-b.extract_float());
                            break;
                        case TCKind._tk_long : sous.insert_float(a.extract_float()-b.extract_long());
                    } 
                    break;
                case TCKind._tk_long :
                    switch(typeB.kind().value()){
                        case TCKind._tk_float : sous.insert_float(a.extract_long()-b.extract_float());
                            break;
                        case TCKind._tk_long : sous.insert_long(a.extract_long()-b.extract_long());
                    } 
                    break;      
            }
        }
        return sous;
    }

    @Override
    public Any mult(Any a, Any b) throws badParam {
        TypeCode typeA = a.type();
        TypeCode typeB = b.type();
        Any mul = this._orb().create_any();
        if(typeA.kind().value()==TCKind._tk_char || typeA.kind().value()==TCKind._tk_string ||
           typeB.kind().value()==TCKind._tk_char || typeB.kind().value()==TCKind._tk_string) {
            throw new badParam("Charactère !");
        }
        else{
            switch(typeA.kind().value()){
                case TCKind._tk_float :
                    switch(typeB.kind().value()){
                        case TCKind._tk_float : mul.insert_float(a.extract_float()*b.extract_float());
                            break;
                        case TCKind._tk_long : mul.insert_float(a.extract_float()*b.extract_long());
                    } 
                    break;
                case TCKind._tk_long :
                    switch(typeB.kind().value()){
                        case TCKind._tk_float : mul.insert_float(a.extract_long()*b.extract_float());
                            break;
                        case TCKind._tk_long : mul.insert_long(a.extract_long()*b.extract_long());
                    } 
                    break;      
            }
        }
        return mul;
    }

    @Override
    public Any div(Any a, Any b) throws badParam, divZero {
        TypeCode typeA = a.type();
        TypeCode typeB = b.type();
        Any divi = this._orb().create_any();
        if(typeA.kind().value()==TCKind._tk_char || typeA.kind().value()==TCKind._tk_string ||
           typeB.kind().value()==TCKind._tk_char || typeB.kind().value()==TCKind._tk_string)
            throw new badParam("Charactère !");
        else{
            switch(typeA.kind().value()){
                case TCKind._tk_float :
                    switch(typeB.kind().value()){
                        case TCKind._tk_float : if(b.extract_float()==0) throw new divZero("Division par zero");
                            divi.insert_float(a.extract_float()/b.extract_float());
                            break;
                        case TCKind._tk_long : if(b.extract_float()==0) throw new divZero("Division par zero");
                            divi.insert_float(a.extract_float()+b.extract_long());
                    } 
                    break;
                case TCKind._tk_long :
                    switch(typeB.kind().value()){
                        case TCKind._tk_float : if(b.extract_float()==0) throw new divZero("Division par zero");
                            divi.insert_float(a.extract_long()/b.extract_float());
                            break;
                        case TCKind._tk_long : if(b.extract_float()==0) throw new divZero("Division par zero");
                            divi.insert_long(a.extract_long()/b.extract_long());
                    } 
                    break;      
            }
        }
        return divi;
    }

    public Any addition(Any nb1, Any nb2) throws badParam {
        TypeCode typeA = nb1.type();
        TypeCode typeB = nb2.type();
        Any somme = this._orb().create_any();
        if(typeA.kind().value()==TCKind._tk_char || typeA.kind().value()==TCKind._tk_string ||
           typeB.kind().value()==TCKind._tk_char || typeB.kind().value()==TCKind._tk_string)
            throw new badParam("Charactère !");
        else{
            switch(typeA.kind().value()){
                case TCKind._tk_double :
                   somme.insert_double(nb1.extract_double()+nb2.extract_double());
                   break;
                    //...
                case TCKind._tk_float :
                    switch(typeB.kind().value()){
                        case TCKind._tk_float : somme.insert_float(nb1.extract_float()+nb2.extract_float());
                            break;
                        case TCKind._tk_long : somme.insert_float(nb1.extract_float()+nb2.extract_long());
                            break;
                    } 
                    break;
                case TCKind._tk_long :
                    switch(typeB.kind().value()){
                        case TCKind._tk_float : somme.insert_float(nb1.extract_long()+nb2.extract_float());
                            break;
                        case TCKind._tk_long : somme.insert_long(nb1.extract_long()+nb2.extract_long());
                    } 
                    break;      
            }
        }
        return somme;
    }
}
