//Written By Vitali Yusufov
//*****************Creates the List
public class PolyNode {

    private int _power;
    private double _coefficient;
    private PolyNode _next;

//Constructor that initiates a Node with the power and coefficient provided and sets the _next to null.

    public PolyNode(int power, double coefficient){
        if (power>=0){
            _power = power;
            _coefficient = coefficient;
        }else{
            _coefficient = _power = 0;
        }
        if(coefficient==0){
            _power = 0;
        }
        _next = null;
    }
//Constructor that initiates a Node with the power coefficient and next Provided.
    public PolyNode(int power, double coefficient, PolyNode next){
        this(power, coefficient);
        _next = next;
    }
//Copy constructor
    public PolyNode(PolyNode p){
        _power = p._power;
        _coefficient = p._coefficient;
        _next = p._next;
    }

//Retrieves to Power of Node.
    public int getPower(){
        return _power;
    }
//Retrieves the Coefficient of Node.
    public double getCoefficient(){
        return _coefficient;
    }
//Retrieves the Next PolyNode of Node.
    public PolyNode getNext(){
        return _next;
    }
//Method that sets power as the _power of Node.
    public void setPower(int power){
        if (power >= 0){
            _power = power;
        }
    }
//Method that sets coefficient as the _coefficient of Node
    public void setCoefficient(double coefficient){
        _coefficient = coefficient;
    }
//Method that sets the next as the _next of Node.
    public void setNext(PolyNode next){
        _next = next;
    }
//Method that transaltes the Power and Coefficient to a String
    public String toString(){
        String string = "";
        if(_coefficient == 0)
            return"";
        if(_power == 0)
            return "" + _coefficient;      
        if(_coefficient < 0)
            string += "-";
        if(Math.abs(_coefficient) > 1)
            string +=Math.abs(_coefficient);
        string += "x";
        if(_power > 1)
            string += "^" + _power;
        return string;
    }
}