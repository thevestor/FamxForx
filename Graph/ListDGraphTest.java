package Graph;

import java.io.*;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class ListDGraphTest {

    DGraph<String> mDG = new ListDGraph<String>();
    
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAll() throws IOException{
        Utils.log("===============add v=================");
        
        mDG.add("1");
        mDG.add("2");
        mDG.add("3");
        mDG.add("4");
        mDG.add("5");
        mDG.add("6");
        mDG.add("7");
        mDG.add("8");

        Utils.log("===============add edge=================");
        
        mDG.add(new Edge<String>("1", "2"));
        mDG.add(new Edge<String>("1", "3"));
        mDG.add(new Edge<String>("2", "4"));
        mDG.add(new Edge<String>("2", "5"));
        mDG.add(new Edge<String>("3", "6"));
        mDG.add(new Edge<String>("3", "7"));
        mDG.add(new Edge<String>("4", "8"));
        mDG.add(new Edge<String>("8", "5"));
        mDG.add(new Edge<String>("6", "7")); 
        
        Utils.log("=======================================================");
        
        
        //options insert,delete and travel
        while(true) {
        	System.out.println("Enter the first letter of");
        	System.out.println("travel,insert,get,remove:");
        	char choice = getChar();
        	switch(choice) {
        		case 't':
        			Utils.log("===============test travelling=================");
        	       
        	        Iterator<String> it = mDG.iterator(DGraph.ITERATOR_TYPE_BFS, "1");
        	        
        	        while(it.hasNext()) {
        	            String s = it.next();
        	            Utils.log("next : %s", s);
        	        }
        	        break;
        		case 'g':
        			Utils.log("choice options to getValue is:");
        			 char nextChoice = getChar();
        			 switch(nextChoice) {
        			 	case 'i':
        			 		Utils.log("=============== get first vertex is ============");
        			 		mDG.get(0);
        			 		break;
        			 	case 's':
        			 		Utils.log("================ get first and second vertex is =============");
        			 		mDG.get(0, 1);
        			 		break;
        			 	default:
        			 		Utils.log("Options Error");
        			 		break;
        			 }
        			 break;
        		case 'i':
        			Utils.log("choice options to remove:,options t is remove vertex,f is remove edge:");
        			char removeOptions = getChar();
        			switch(removeOptions){
        				case 't':
        					Utils.log("=========== remove vertex is: ===============");
        					mDG.remove("6");
        					break;
        				case 'j':
        					Utils.log("============== remove 3->7 edge is: ==============");
        					mDG.remove(new Edge<String>("3", "7"));
        					break;
        				default:
        					System.out.println("Options Error");
        					break;
        			}
        			break;
        		case 'q':
        			Utils.log("====================== Travel2 ================");
        			it = mDG.iterator(DGraph.ITERATOR_TYPE_BFS, "2");
        	        while(it.hasNext()) {
        	            String s = it.next();
        	            Utils.log("next : %s", s);
        	        }
        	        break;
        	    default:
        	    	System.out.println("Invalid Entry\n");
        	    	break;
        	}
        }
    }
    public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	public static char getChar() throws IOException{
		String s = getString();
		return s.charAt(0);
	}
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}
}