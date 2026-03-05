interface PolynomialADT {
    void addPolyNodeFirst(int coeff, int exp);
    void addPolyNodeLast(int coeff, int exp);
    PolynomialADT addPoly(PolynomialADT p);
    boolean isEmpty();
    String toString();
}

class PolyNodeClass {
    private int coefficient;
    private int exponent;
    private PolyNodeClass next;

    public PolyNodeClass() {
        coefficient = 0;
        exponent = 0;
        next = null;
    }

    public PolyNodeClass(int c, int e) {
        coefficient = c;
        exponent = e;
        next = null;
    }

    public PolyNodeClass(PolyNodeClass copied) {
        coefficient = copied.coefficient;
        exponent = copied.exponent;
        next = null;
    }

    public void setCoefficient(int c) {
        coefficient = c;
    }

    public void setExponent(int e) {
        exponent = e;
    }

    public void setNext(PolyNodeClass n) {
        next = n;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public PolyNodeClass getNext() {
        return next;
    }
}

class PolynomialDataStrucClass implements PolynomialADT {
    private PolyNodeClass firstNode;

    public PolynomialDataStrucClass() {
        firstNode = null;
    }

    public PolynomialDataStrucClass(PolynomialDataStrucClass copied) {
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public PolyNodeClass getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(PolyNodeClass node) {
        firstNode = node;
    }

    public void addPolyNodeFirst(int coeff, int exp) {
        PolyNodeClass newNode = new PolyNodeClass(coeff, exp);
        newNode.setNext(firstNode);
        firstNode = newNode;
    }

    public void addPolyNodeLast(int coeff, int exp) {
        PolyNodeClass newNode = new PolyNodeClass(coeff, exp);
        if(isEmpty()) {
            firstNode = newNode;
        }
        else {
            PolyNodeClass current = firstNode;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public PolynomialADT addPoly(PolynomialADT other) {
        PolynomialDataStrucClass result = new PolynomialDataStrucClass();
        PolynomialDataStrucClass otherPoly = (PolynomialDataStrucClass) other;

        PolyNodeClass thisCurrent = this.firstNode;
        PolyNodeClass otherCurrent = otherPoly.getFirstNode();

        while (thisCurrent != null && otherCurrent != null) {
            if (thisCurrent.getExponent() == otherCurrent.getExponent()) {
                result.addPolyNodeLast(thisCurrent.getCoefficient() + otherCurrent.getCoefficient(), thisCurrent.getExponent());
                thisCurrent = thisCurrent.getNext();
                otherCurrent = otherCurrent.getNext();
            } else if (thisCurrent.getExponent() > otherCurrent.getExponent()) {
                result.addPolyNodeLast(thisCurrent.getCoefficient(), thisCurrent.getExponent());
                thisCurrent = thisCurrent.getNext();
            } else {
                result.addPolyNodeLast(otherCurrent.getCoefficient(), otherCurrent.getExponent());
                otherCurrent = otherCurrent.getNext();
            }
        }

        while (thisCurrent != null) {
            result.addPolyNodeLast(thisCurrent.getCoefficient(), thisCurrent.getExponent());
            thisCurrent = thisCurrent.getNext();
        }

        while (otherCurrent != null) {
            result.addPolyNodeLast(otherCurrent.getCoefficient(), otherCurrent.getExponent());
            otherCurrent = otherCurrent.getNext();
        }

        return result;
    }

    public String toString() {
        String result = "";
        PolyNodeClass current = firstNode;
        while(current != null) {
            result += current.getCoefficient() + "x^" + current.getExponent();
            if(current.getNext() != null)
                result += " + ";
            current = current.getNext();
        }
        return result;
    }
}

public class PolynomialDemo {
    public static void main(String[] args) {
        PolynomialDataStrucClass p1 = new PolynomialDataStrucClass();
        PolynomialDataStrucClass p2 = new PolynomialDataStrucClass();
        PolynomialDataStrucClass p3 = new PolynomialDataStrucClass();
        PolynomialDataStrucClass p4 = new PolynomialDataStrucClass();

        p1.addPolyNodeLast(4,3);
        p1.addPolyNodeLast(3,2);
        p1.addPolyNodeLast(-5,0);

        p2.addPolyNodeLast(3,5);
        p2.addPolyNodeLast(4,4);
        p2.addPolyNodeLast(1,3);
        p2.addPolyNodeLast(-4,2);
        p2.addPolyNodeLast(4,1);
        p2.addPolyNodeLast(2,0);

        p3.addPolyNodeLast(-5,0);
        p3.addPolyNodeLast(3,2);
        p3.addPolyNodeLast(4,3);

        p4.addPolyNodeLast(-4,0);
        p4.addPolyNodeLast(4,3);
        p4.addPolyNodeLast(5,4);

        System.out.println("P1: " + p1);
        System.out.println("P2: " + p2);

        PolynomialADT result1 = p1.addPoly(p2);
        System.out.println("P1 + P2: " + result1);

        System.out.println();

        System.out.println("P3: " + p3);
        System.out.println("P4: " + p4);

        PolynomialADT result2 = p3.addPoly(p4);
        System.out.println("P3 + P4: " + result2);
    }
}
