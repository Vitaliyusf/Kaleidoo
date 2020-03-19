
//Written by Vitali Yusufov
public class calculator{
    double a;
    double b;
    double c;
    int t;
    double x1;
    double x2;

    public static void addPol(final Polynom first, final Polynom second) {// Adds second to first
        if (second == null) {
            return;
        }
        if (first.getHead() == null) {
            first.setHead(second.getHead());
            return;
        }
        PolyNode curr = second.getHead();
        while (curr != null) {
            first.addNode(new PolyNode(curr));
            curr = curr.getNext();
        }
        return;
    }

    public static void subPol(final Polynom first, final Polynom second) {// Substructes second from first
        if (second == null) {
            return;
        }
        if (first.getHead() == null) {
            second.getHead().setCoefficient(-second.getHead().getCoefficient());
            first.setHead(second.getHead());
            return;
        }
        PolyNode curr = second.getHead();
        while (curr != null) {
            first.subNode(new PolyNode(curr));
            curr = curr.getNext();
        }
        return;
    }

    public static void multPol(final Polynom first, final Polynom second) {//Multiplies polynoms and changes the first
        if (first.getHead() == null || second == null) {
            return;
        } else if (second.getHead() == null) {
            return;
        }
        final Polynom temp = new Polynom();
        PolyNode curr = first.getHead();
        PolyNode currO = second.getHead();
        while (curr != null) {
            while (currO != null) {
                temp.addNode(new PolyNode(curr.getPower() + currO.getPower(),
                        curr.getCoefficient() * currO.getCoefficient()));
                currO = currO.getNext();
            }
            currO = second.getHead();
            curr = curr.getNext();
        }
        first.setHead(temp.getHead());
        return;
    }

    public static void divPol(final Polynom first, final Polynom second) {//Multiplies polynoms and changes the first
        if (first.getHead() == null || second == null) {
            return;
        } else if (second.getHead() == null) {
            return;
        }
        final Polynom temp = new Polynom();
        PolyNode curr = first.getHead();
        PolyNode currO = second.getHead();
        while (curr != null) {
            while (currO != null && curr.getPower() == currO.getPower()) {
                if(currO.getPower() > 0){
                    temp.addNode(new PolyNode(curr.getPower() / currO.getPower(),
                        curr.getCoefficient() / currO.getCoefficient()));
                }else{
                    temp.addNode(new PolyNode(curr.getPower(),
                        curr.getCoefficient() / currO.getCoefficient()));
                }
                currO = currO.getNext();
            }
            currO = second.getHead();
            curr = curr.getNext();
        }
        first.setHead(temp.getHead());
        return;
    }

    public static double squareRoot(final double number) {//Finds the squre root of a number
    {
        double t;
        double squareRoot = number / 2.0;
        if (squareRoot >= 0) {
            do {
                t = squareRoot;
                squareRoot = (t + (number / t)) / 2.0;
            } while ((t - squareRoot) != 0);
        }else{
               
        }
        return squareRoot;
    }

    }

    private static double power(final double b){//Preforms power function
        return b*b;
    }

    private static double first(final double b){//Calculates the first calculation of the quadratic equation
        return -1*b;
    }

    private static double second(final double a, final double b, final double c){//Preforms the second calculation of the quadratic equation (the delta)
        double temp;
        temp = power(b)-4*a*c;
        return squareRoot(temp);
    }

    private static double third(final double a){//Preforms the third calculation of the quadratic equation
        //System.out.println("third " + 2*a);
        return 2*a;
    }

    /*private static void calculate(final double a, final double b, final double c){//Full calculation of the quadratic equation
        double delta, real, imaginary, neg, pos;
        delta = power(b)-4*a*c;
        pos = (first(b)+(second(a, b, c)))/third(a);
        neg = (first(b)-(second(a, b, c)))/third(a);     
        if(delta<0){//When the squre root is negative prints the answer with imaginary numbers
            real = -b / (2 *a);
            imaginary = squareRoot(-delta) / (2 * a);
            System.out.format("X1 = %.2f+%.2fi and X2 = %.2f-%.2fi", real, imaginary, real, imaginary);
        }
        if(delta >= 0){//Normal answers when the delta is positive
            System.out.println("X1 = " + pos + " X2 = " + neg);
        }
    }*/


    private static void calculate1(Polynom x){//Full calculation of the quadratic equation
        
        double delta, real, imaginary, neg, pos;
        double a = x.getHead().getCoefficient();
        double b = x.getHead().getNext().getCoefficient();
        double c = x.getHead().getNext().getNext().getCoefficient();
        delta = power(b)-4*a*c;
        pos = (first(b)+(second(a, b, c)))/third(a);
        neg = (first(b)-(second(a, b, c)))/third(a);     
        if(delta<0){//When the squre root is negative prints the answer with imaginary numbers
            real = -b / (2 *a);
            imaginary = squareRoot(-delta) / (2 * a);
            System.out.format("X1 = %.2f+%.2fi and X2 = %.2f-%.2fi", real, imaginary, real, imaginary);
        }
        if(delta >= 0){//Normal answers when the delta is positive
            System.out.println("X1 = " + pos + " X2 = " + neg);
        }
    }

    public static void main(final String [] args){
        final Polynom a = new Polynom(new PolyNode(3, 4, new PolyNode(2,-2,new PolyNode(1,3,new PolyNode(0, -1)))));//4x^3-2x^2+3x-1
        final Polynom b = new Polynom(new PolyNode(3, 2, new PolyNode(2, 3, new PolyNode(1, 5,new PolyNode(0, -5)))));//2x^3+3x^2+5x-5
        final Polynom c = new Polynom(new PolyNode(2, 2, new PolyNode(1, 3,new PolyNode(0,5 ))));//
        final Polynom d = new Polynom(new PolyNode(2, 2, new PolyNode(1, -3,new PolyNode(0,1 ))));//
        
        System.out.println("poly a + poly b\n"+a+"\n+\n"+b);
        addPol(a,b);
        System.out.println(a);
        System.out.println("poly a * poly b\n"+a+"\n*\n"+b);
        multPol(a, b);
        System.out.println(a);
        System.out.println("poly a - poly b\n"+a+"\n-\n"+b);
        subPol(a, b);
        System.out.println(a + "\n");
        System.out.println("poly a / poly b\n"+a+"\n/\n"+b);
        divPol(a, b);
        System.out.println(a + "\n");

        System.out.println("\nFor the equation: " + c + " The solution is:\n");
        calculate1(c);

        System.out.println("\nFor the equation: " + d + " The solution is:\n");
        calculate1(d);
        System.out.println("\n*********************");
    }

}




 