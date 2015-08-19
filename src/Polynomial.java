import java.util.LinkedList;
import java.util.Scanner;

public class Polynomial {
    private Node first = new Node(0, 0);  
    private Node last  = first;

    private static class Node {
        int coef;
        int exp;
        Node next;
        Node(int coef, int exp) {
            this.coef = coef;
            this.exp  = exp;
        }
    }

     
    private Polynomial() { }

    
    public Polynomial(int coef, int exp) {
        last.next = new Node(coef, exp);
        last = last.next;
    }

    // return c = a + b
    public Polynomial plus(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial();
        Node x = a.first.next;
        Node y = b.first.next;
        while (x != null || y != null) {
            Node t = null;
            if      (x == null)     { t = new Node(y.coef, y.exp);  y = y.next; }
            else if (y == null)     { t = new Node(x.coef, x.exp);  x = x.next; }
            else if (x.exp > y.exp) { t = new Node(x.coef, x.exp);  x = x.next; } 
            else if (x.exp < y.exp) { t = new Node(y.coef, y.exp);  y = y.next; } 

            else {
                int coef = x.coef + y.coef;
                int exp  = x.exp;
                x = x.next;
                y = y.next;
                if (coef == 0) continue;
                t = new Node(coef, exp);
            }
        
            c.last.next = t;
            c.last = c.last.next;
        }
        return c;
    }


    // return c = a + b
    public Polynomial times(Polynomial b) {
        Polynomial a = this;
        Polynomial c = new Polynomial();
        for (Node x = a.first.next; x!= null; x = x.next) {
            Polynomial temp = new Polynomial();
            for (Node y = b.first.next; y!= null; y = y.next) {
                temp.last.next = new Node(x.coef * y.coef, x.exp + y.exp);
                temp.last = temp.last.next;
            }
            c = c.plus(temp);
        }
        return c;
    }


    // convert to string 
    public String toString() {
        String s = "";
        for (Node x = first.next; x != null; x = x.next) {
            if      (x.coef > 0) s = s + " + " +   x.coef  + "x^" + x.exp;
            else if (x.coef < 0) s = s + " - " + (-x.coef) + "x^" + x.exp;
        }
        return s;
    }

    
    public static void main(String[] args) { 
    	
    	Scanner input = new Scanner(System.in);
    	int a,b,c,d,e,f,g,h,i,j,k,l;
    	
    	System.out.println("Input a power");
    	b = input.nextInt();
    	System.out.println("Input the coefficient for: " + "x^" + b);
    	a = input.nextInt();
    	
    	System.out.println("Input a power");
    	d = input.nextInt();
    	System.out.println("Input the coefficient for: " + "x^" + d);
    	c = input.nextInt();
    	
    	System.out.println("Input a power");
    	f = input.nextInt();
    	System.out.println("Input the coefficient for: " + "x^" + f);
    	e = input.nextInt();
    	
    	System.out.println("Input a power");
    	h = input.nextInt();
    	System.out.println("Input the coefficient for: " + "x^" + h);
    	g = input.nextInt();
    	
    	System.out.println("Input a power");
    	j = input.nextInt();
    	System.out.println("Input the coefficient for: " + "x^" + j);
    	i = input.nextInt();
    	
    	System.out.println("Input a power");
    	l = input.nextInt();
    	System.out.println("Input the coefficient for: " + "x^" + l);
    	k = input.nextInt();
    	
       
        Polynomial p1   = new Polynomial(a, b);
        Polynomial p2   = new Polynomial(c, d);
        Polynomial p3   = new Polynomial(e, f);
        Polynomial p4   = new Polynomial(g, h);
        Polynomial p    = p1.plus(p2).plus(p3).plus(p4);  

        Polynomial q1   = new Polynomial(i, j);
        Polynomial q2   = new Polynomial(k, l);
        Polynomial q    = q1.plus(q2);                     

        Polynomial r    = p.plus(q);
        Polynomial s    = p.times(q);
        
        System.out.println("p(x) =        " + p);
        System.out.println("q(x) =        " + q);
        System.out.println("p(x) + q(x) = " + r);
        System.out.println("p(x) * q(x) = " + s);
   }

}
