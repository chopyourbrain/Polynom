public class linkedlist {
xsinx startptr;
public linkedlist() {
	startptr=null;
}
public void addelem(int k1, int x1, int sinx1)
{
	xsinx z=new xsinx();
	z.k=k1;
	z.x=x1;
	z.sinx=sinx1;
	z.next=startptr;
	startptr=z;
}
public void outlist()
{
  uproshen();
	xsinx z=startptr;
	System.out.print("P(x,sinx)=");
	if (startptr==null) System.out.print("0");
	else
	while (z!=null){
		if (z!=startptr){
			
		if (z.k>=0) {
			System.out.print("+");	
		}
		}
		if (z.k!=1) {
			System.out.print(z.k);
			if ((z.x!=0) & (z.sinx!=0)) System.out.print("*");
		}
		if (z.x!=0)	{
			System.out.print("x^"+z.x);
		    if (z.sinx!=0) System.out.print("*");
		}
		if (z.sinx!=0) System.out.print("sin^"+z.sinx+"(x)");
		z=z.next;
	}
	System.out.println();
}

public void nachislo(int g)
{
	xsinx z=startptr;
	while (z!=null)
	{
		z.k=z.k*g;
		z=z.next;
	}
}

public void sum(linkedlist lst)
{

	xsinx z1=lst.startptr;
	while (z1!=null){
		xsinx z=startptr;
		boolean p=true;
		while (z!=null) {
			if ((z.x == z1.x) & (z.sinx == z1.sinx))
			{
				z.k+=z1.k;
				p=false;
			}
		    z=z.next;          }
	
		if (p==true) {
			addelem(z1.k,z1.x,z1.sinx); 
		}
		z1=z1.next;	
	}
	uproshen();
}

public void razn(linkedlist lst)
{

	xsinx z1=lst.startptr;
	while (z1!=null){
		xsinx z=startptr;
		boolean p=true;
		while ((z!=null) & (p==true)) {
			if ((z.x == z1.x) & (z.sinx == z1.sinx))
			{
				z.k-=z1.k;
				p=false;
			}
		    z=z.next;          }
	
		if (p==true) {
			addelem(-z1.k,z1.x,z1.sinx); 
		}
		z1=z1.next;	
	}
	uproshen();
}

public boolean sravn(linkedlist lst)
{
	xsinx z1=lst.startptr;
	boolean p=true;
	while (z1!=null){
		xsinx z=startptr;
		boolean l=true;
		while (z!=null) {
			if ((z.x == z1.x) && (z.sinx == z1.sinx) && (z.k == z1.k))
			{
				l=false;
			}
		    z=z.next;          }
	if (l==true) p=false;
		z1=z1.next;	
	}
	return p;
}

public void deleteElmnt(xsinx z)
{
	if (z==startptr) startptr=z.next;
	else 
	{
		xsinx m=startptr;
		while (m.next!=z) 
			m=m.next;
		m.next=z.next;
		z=m;
	}
}

public void swap(xsinx a1, xsinx a2)
{
  int k=a1.k;
  int x=a1.x;
  int sinx=a1.sinx;
  a1.k=a2.k;
  a1.x=a2.x;
  a1.sinx=a2.sinx;
  a2.k=k;
  a2.x=x;
  a2.sinx=sinx;
}

public void uproshen()
{
	xsinx z=startptr;
	while (z!=null) {
		if (z.k==0) deleteElmnt(z);
		z=z.next;
	}
	
	
	z=startptr;
	while (z!=null){
		xsinx z1=startptr;
		while (z1!=null) {
			if ((z.x==z1.x) & (z.sinx==z1.sinx) & (z.next!=z1.next))
			{
				z.k+=z1.k;
				deleteElmnt(z1);
			}
		    z1=z1.next;          }
		z=z.next;	
	}

if (startptr!=null) {
boolean flag = true;
while (flag)
{
z=startptr;
  flag=false;
 while (z.next!=null)
  {
    if ((z.next.x>=z.x) & (z.next.sinx>=z.sinx))
    {
    swap(z,z.next);
      flag=true;
    }
   z=z.next;
  }
}
}
}


public void proizv(linkedlist lst1,linkedlist lstotv)
{
	xsinx z=lst1.startptr;
	while (z!=null){
		xsinx z1=startptr;
		while (z1!=null) {
			int k=z.k*z1.k;
			int sinx=z.sinx+z1.sinx;
			int x=z.x+z1.x;
			lstotv.addelem(k, x, sinx);
		    z1=z1.next;          }
		z=z.next;	
	}
	lstotv.uproshen();
}

public void deleniye(linkedlist lst1,linkedlist lstotv)
{
  int k,x,sinx;
  xsinx z1,z2;
  boolean fl=true;
	while ((startptr!=null) & (fl==true))
	{
		if ((startptr.x>=lst1.startptr.x) & (startptr.sinx>=lst1.startptr.sinx)) {
	  linkedlist lst3=new linkedlist();
	  z1=startptr;
	  z2=lst1.startptr;
	  k=z1.k/z2.k;
	  x=z1.x-z2.x;
	  sinx=z1.sinx-z2.sinx;
	  lstotv.addelem(k,x,sinx);
	  while (z2!=null)
	  {
	 lst3.addelem(k*z2.k,x+z2.x,sinx+z2.sinx);
	 z2=z2.next;
	 }
	 razn(lst3);
	 uproshen(); 
		}
		else fl=false;
}
	
}

}
