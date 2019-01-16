public class lab1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int[]k2=   {-8,1};
int[]x2=   {0,3};
int[]sinx2={0,3};
linkedlist lst1=new linkedlist();
for (int i=0;i<2;i++)
	lst1.addelem(k2[i], x2[i], sinx2[i]);
lst1.outlist();

//int[]k3=   {1,-2};
//int[]x3=   {1,0};
//int[]sinx3={1,0};\
int[]k3=   {-2,1};
int[]x3=   {0,1};
int[]sinx3={0,1};
linkedlist lst2=new linkedlist();
for (int i=0;i<2;i++)
	lst2.addelem(k3[i], x3[i], sinx3[i]);
lst2.outlist();

linkedlist lstproizv=new linkedlist();
lst1.deleniye(lst2, lstproizv);
lstproizv.outlist();
lst1.outlist();


	}

}
