import java.util.Scanner;
class Node
{
    int n, p;
    Node next;
}
class PolyAdd
{
    Node first, last;
    PolyAdd()
    {
        first=last=null;
    }
    void insertElement(int n, int p)
    {
        Node newrec=new Node();
        newrec.n=n;
        newrec.p=p;
        newrec.next=null;
        
        if(first==null)
            first=last=newrec;
        else
        {
            last.next=newrec;
            last=newrec;
        }
    }
    void display()
    {
        Node q=first;
        while(q!=null)
        {
            if(q==first && q.next!=null)
            {    if(q.n>0)
                    System.out.print(" "+q.n+"x^"+q.p);
                else if(q.n<0)
                    System.out.print(q.n+"x^"+q.p);
            }
            else if(q.n>0 && q.p!=0)
            System.out.print(" +"+q.n+"x^"+q.p);
            else if(q.n<0 && q.p!=0)
                    System.out.print(" "+q.n+"x^"+q.p);
            
            if(q.p==0)
            {
                if(q.n>0)
                    System.out.print(" +"+q.n);
                else if(q.n<0)
                    System.out.print(" "+q.n);
                else
                    System.out.print(" +0");
            }    
            q=q.next;
        }
        System.out.println();
    }
    void addPoly(PolyAdd a, PolyAdd b)
    {
        Node na,nb;
        na=a.first;
        nb=b.first;
        
        while(na!=null && nb!=null)
        {
            if(na.p>nb.p)
            {
                insertElement(na.n,na.p);
                na=na.next;
            }
            else if(na.p<nb.p)
            {
                insertElement(nb.n,nb.p);
                nb=nb.next;
            }
            else
            {
                insertElement(na.n+nb.n,na.p);
                na=na.next;
                nb=nb.next;
            }
        }
        
        if(na==null && nb!=null)
        {
            while(nb!=null)
            {
                insertElement(nb.n,nb.p);
                nb=nb.next;
            }
        }
        else if(na!=null && nb==null)
        {
            while(na!=null)
            {
                insertElement(na.n,na.p);
                na=na.next;
            }
        }
    }
}
class Poly
{
    public static void main(String args[])
    {
        Scanner input=new Scanner(System.in);
        PolyAdd a=new PolyAdd();
        PolyAdd b=new PolyAdd();
        PolyAdd c=new PolyAdd();
        int i,da,db,n;
        
        System.out.print("Enter degree of Polynimial 1: ");
        da=input.nextInt();
        System.out.print("Enter Coefficients in descending order: \n");
        for(i=da;i>0;i--)
        {
            System.out.print("Coefficient of x^"+i+" : ");
            n=input.nextInt();
            a.insertElement(n,i);
        }
        System.out.print("Constant: ");
        n=input.nextInt();
        a.insertElement(n,0);
        
        System.out.print("Enter degree of Polynimial 2: ");
        db=input.nextInt();
        System.out.print("Enter Coefficients in descending order: \n");
        for(i=db;i>0;i--)
        {
            System.out.print("Coefficient of x^"+i+" : ");
            n=input.nextInt();
            b.insertElement(n,i);
        }
        System.out.print("Constant: ");
        n=input.nextInt();
        b.insertElement(n,0);
        
        c.addPoly(a,b);
        System.out.print("Polynomial 1:                ");
        a.display();
        System.out.print("Polynomial 2:                ");
        b.display();
        System.out.print("Polynomial 1+Polynomial 2:   ");
        c.display();
    }    
}