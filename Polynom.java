//Written By Vitali Yusufov

//********* Preforms the simple mathmatical functions********

public class Polynom {
    private PolyNode _head;
//Empty constructor.
    public Polynom() {
        _head = null;
    }
//Constructor accepts a PolyNode and sets its as head according to its coefficient.ynom(PolyNode p) 
    public Polynom(PolyNode p){
        if (p.getNext() != null && p.getCoefficient() == 0) {
            _head = p.getNext();
        } else if (p.getCoefficient() == 0) {
            _head = null;
        } else {
            _head = p;
        }
    }
// /Method that retrieves the Nodes in Polynom and return them as a string
    public String toString() {
        String str = "";
        PolyNode curr = _head;
        while (curr != null) {
            str += (curr.getCoefficient() > 0 && curr != _head ? "+" : "") + curr.toString();
            curr = curr.getNext();
        }
        return str;
    }
//Method that retrieves the address of _head.
    public PolyNode getHead() {
        return _head;
    }
//Method that sets p as the _head of the PolyNom.
    public void setHead(PolyNode p) {
        if (_head != null) {
            p.setNext(_head);
            _head = p;
        } else {
            _head = p;
        }
    }
//Method that adds p to the Polynom (Builds the Polynom in the list)
    public Polynom addNode(PolyNode p) {
        if (_head == null) {
            setHead(p);
            return this;
        } else {
            PolyNode curr = _head, prev = _head;
            while (curr != null) {
                if (curr == _head && p.getPower() > curr.getPower()) {
                    setHead(p);
                    return this;
                } else if (curr == _head && p.getPower() == curr.getPower()) {
                    curr.setCoefficient(curr.getCoefficient() + p.getCoefficient());
                    if (curr.getCoefficient() == 0) {
                        _head = _head.getNext();
                    }
                    return this;
                } else if (p.getPower() > curr.getPower()) {
                    p.setNext(curr);
                    prev.setNext(p);
                    return this;
                } else if (p.getPower() == curr.getPower()) {
                    curr.setCoefficient(curr.getCoefficient() + p.getCoefficient());
                    if (curr.getCoefficient() == 0) {
                        prev.setNext(curr.getNext());
                    }
                    return this;
                } else if (curr == _head) {
                    curr = curr.getNext();
                } else {
                    prev = curr;
                    curr = curr.getNext();
                }
            }
            if (curr == null) {
                prev.setNext(new PolyNode(p.getPower(), p.getCoefficient()));
            }
        }
        return this;
    }
//Method that subtracts a with b.
    public Polynom subNode(PolyNode p) {
        if (_head == null) {
            setHead(p);
            return this;
        } else {
            PolyNode curr = _head, prev = _head;
            while (curr != null) {
                if (curr == _head && p.getPower() > curr.getPower()) {
                    setHead(p);
                    return this;
                } else if (curr == _head && p.getPower() == curr.getPower()) {
                    curr.setCoefficient(curr.getCoefficient() - p.getCoefficient());
                    if (curr.getCoefficient() == 0) {
                        _head = _head.getNext();
                    }
                    return this;
                } else if (p.getPower() > curr.getPower()) {
                    p.setNext(curr);
                    prev.setNext(p);
                    return this;
                } else if (p.getPower() == curr.getPower()) {
                    curr.setCoefficient(curr.getCoefficient() - p.getCoefficient());
                    if (curr.getCoefficient() == 0) {
                        prev.setNext(curr.getNext());
                    }
                    return this;
                } else if (curr == _head) {
                    curr = curr.getNext();
                } else {
                    prev = curr;
                    curr = curr.getNext();
                }
            }
            if (curr == null) {
                prev.setNext(new PolyNode(p.getPower(), p.getCoefficient()));
            }
        }
        return this;
    }
//Method that adds a with b.
    public Polynom addPol(Polynom other) {
        if (other == null) {
            return this;
        }
        if (_head == null) {
            _head = other._head;
            return this;
        }
        PolyNode curr = other._head;
        while (curr != null) {
            this.addNode(new PolyNode(curr));
            curr = curr.getNext();
        }
        return this;
    }    
//Method that multiplies a with b.
    public Polynom multPol(Polynom other) {
        if (_head == null || other == null) {
            return this;
        } else if (other._head == null) {
            return this;
        }
        Polynom temp = new Polynom();
        PolyNode curr = _head;
        PolyNode currO = other.getHead();
        while (curr != null) {
            while (currO != null) {
                temp.addNode(new PolyNode(curr.getPower() + currO.getPower(),
                        curr.getCoefficient() * currO.getCoefficient()));
                currO = currO.getNext();
            }
            currO = other._head;
            curr = curr.getNext();
        }
        _head = temp._head;
        return this;
    }

    
}