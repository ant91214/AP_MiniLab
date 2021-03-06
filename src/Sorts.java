
/**
 2. Add 'Selection Sort' to Sorts
* Do an assessment/report on best Sort in Sorts and cite reasons. 5pts

insertion>selection>bubble in general (from Wikipedia)
selection>insertion>bubble here
“selection sort must always scan all remaining elements to find the absolute smallest unsorted element”, insertion does not
Both sorts work similarly but on average insertion is more efficient since it performs better in scenarios where the list is already in order. However, in the scenario presented in Sorts, selection sort was more efficient because it had the lowest number of operations.

 */
public class Sorts
{
    enum ListType {Standard, Bubble, Insert, Select};
    ListType listType = ListType.Standard;
    
    private int[] list;
    private int[] blist; int bcompares = 0; int bswaps = 0;
    private int[] ilist; int icompares = 0; int iswaps = 0;
    private int[] slist; int scompares = 0; int sswaps = 0;

    /**
     * Constructor for objects of class isort
     */
    public Sorts()
    {
        int size = 50;
        list = new int[size];
        for (int i = 0; i < list.length; i++)
            list[i] = (int)(Math.random() * size) + 1;
            
        blist = list.clone();
        this.BubbleSort();
        ilist = list.clone();
        this.InsertionSort();
        slist = list.clone();
        this.SelectionSort();
    }
    
    public String toString() {
        int[] list;
        
        switch(listType) {
            case Standard:
                System.out.println("Original List");
                list = this.list;
                break;
            case Bubble:
                System.out.println("Bubble Sort -- "
                  + " Operations: " + (this.bcompares + this.bswaps)
                  + " Compares: " + this.bcompares
                  + " Swaps: " + this.bswaps);
                list = this.blist;
                break;
            case Insert:
                System.out.println("Insertions Sort -- "
                  + " Operations: " + (this.icompares + this.iswaps)
                  + " Compares: " + this.icompares
                  + " Swaps: " + this.iswaps);
                list = this.ilist;
                break;
            case Select:
            	System.out.println("Selection Sort -- "
            	  + " Operations: " + (this.scompares + this.sswaps)
            	  + " Compares: " + this.scompares
            	  + " Swaps: " + this.sswaps);
            	list = this.slist;
            	break;
            default:
            	System.out.println("Insertions Sort -- "
                  + " Operations: " + (this.icompares + this.iswaps)
                  + " Compares: " + this.icompares
                  + " Swaps: " + this.iswaps);
                list = this.ilist;
            	
        }
                
        String output = "[";
        for (int i = 0; i < list.length; i++)
            output += " " + list[i];
        return output +" ]";    
    }
    
    private int[] BubbleSort() { 
        
        // iterate list, one less than length
        for (int i = 0; i < blist.length - 1; i++) {
            
            // bubble sort key logic
            for (int k = 1; k < blist.length - i; k++) {
                
                // analytics
                this.bcompares++; // compare counter
                
                // bubble sort swap logic
                if (blist[k-1] > blist[k]) {
                    int swap = blist[k];
                    blist[k] = blist[k-1];
                    blist[k-1] = swap;
               
                    // analytics
                    this.bswaps++; // swap counter
                }
            
            }
            
        }
        return blist;
    }

    
    private int[] InsertionSort() {

        // iterate list, one less than length
        for (int i = 0; i < ilist.length - 1; i++) {
            
            // insertion sort key logic
            int k = i + 1;
            int swap = ilist[k];            
            while( k > 0 && swap < ilist[k-1]) {
                ilist[k] = ilist[k-1];
                k--;
                
                // analytics
                this.icompares++; // compare counter
                this.iswaps++; // shift counter
            }
            ilist[k] = swap;
            
            this.iswaps++;  // increment swap counter
            
        }
        
        return ilist;
    }
    
    private int[] SelectionSort() {
    	int i; int k;
    	
    	for(i = 0; i < slist.length - 1; i++) {
    		int min_id = i;
    		
    		for(k = i + 1; k < slist.length; k++) {
    			if(slist[k] < slist[min_id]) {
    				min_id = k;
    			}
    			scompares++;
    		}
    		
    		if(i != min_id) {
        		int temp = slist[i];
        		slist[i] = slist[min_id];
        		slist[min_id] = temp;
        		sswaps++;
    		}
    	}
    	
    	return slist;
    }

  
    /**
     *
     */
    public static void main(String[] args)
    {
        // Original List
        Sorts is = new Sorts();
        System.out.println(is);
        
        // Bubble Sort
        is.listType = ListType.Bubble;
        System.out.println(is);
        
        // Insertion Sort
        is.listType = ListType.Insert;
        System.out.println(is);
        
        is.listType = ListType.Select;
        System.out.println(is);
       
    }
}
