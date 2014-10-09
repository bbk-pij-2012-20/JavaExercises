// McCarthy's 91 function.
// Purpose of exercise: we are provided this code and
// we must work out the output "on paper".
// my attempt is below the code
public class McCarthy91 {

	public static void main(String[] args) {
	
		McCarthy91 mc91 = new McCarthy91();
		System.out.println(mc91.doMcCarthy91(50));
		
	}
	
	public int doMcCarthy91(int n) {
	 
		System.out.print(n+" ");
	
		if (n > 100) {
			
			return n-10;
        
        } else {
      		
      		System.out.print(n + " ");
			return doMcCarthy91(doMcCarthy91(n + 11)); 
		
		}
	
	}

}
/*
mC91(50)
print "50"
print "50"
mc91(mc91(50+11))--> mc91(61)
.					 print "61"
.					 print "61"
.					 mc91(mc91(61+11))--> mc91(72)
.					 .					  print "72"
.					 .					  print "72"
.					 .					  mc91(mc91(72+11))--> mc91(mc91(94))
.					 .					  .  				   print "94"
.					 .					  .					   print "94"
.					 .					  .					   mc91(mc91(94+11))--> mc91(mc91(105))
.					 .					  .					   .					print "105"
.					 .					  .					   mc91(95)	<---------- return 105-10
.					 .					  .					   print "95"
.					 .					  .					   print "95"
.					 .					  .					   mc91(mc91(95+11))--> mc91(mc91(106))
.					 .					  .					   .					print "106"
.					 .					  .					   mc91(mc91(96)) <---- return 106-10
.					 .					  .					   print "96"
.					 .					  .					   print "96"
.					 .					  .					   mc91(mc91(96+11)---> mc91(mc91(107))
.					 .					  .					   .					print "107"
.					 .					  .					   mc91(mc91(97)) <---- return 107-10
.					 .					  .					   print "97"
.					 .					  .					   print "97"
.					 .					  .					   mc91(mc91(97+11)---> mc91(mc91(108))
.					 .					  .					   .					print "108"
.					 .					  .					   mc91(mc91(98)) <---- return 108-10
.					 .					  .					   print "98"
.					 .					  .					   print "98"
.					 .					  .					   mc91(mc91(98+11)---> mc91(mc91(109))
.					 .					  .					   .					print "109"
.					 .					  .					   mc91(mc91(99)) <---- return 109-10
.					 .					  .					   print "99"
.					 .					  .					   print "99"
.					 .					  .					   mc91(mc91(99+11)---> mc91(mc91(110))
.					 .					  .					   .					print "110"
.					 .					  .					   mc91(mc91(100)) <--- return 110-10
.					 .					  .					   print "100"
.					 .					  .					   print "100"
.					 .					  .					   mc91(mc91(100+11)--> mc91(mc91(111))
.					 .					  .					   .					print "111"
.					 .					  .					   mc91(mc91(91)) <---- return 111-10
.					 .					  .					   print "91"
.					 .					  .					   print "91"

and so on and on.. and on.. 

Running the program gives the following - about 150 printed numbers before terminating at 91:

50 50 61 61 72 72 83 83 94 94 105 95 95 106 96 96 107 97 97 108 98 98 109 99 99 110 100 100 111 101 
91 91 102 92 92 103 93 93 104 94 94 105 95 95 106 96 96 107 97 97 108 98 98 109 99 99 110 100 100 111 
101 91 91 102 92 92 103 93 93 104 94 94 105 95 95 106 96 96 107 97 97 108 98 98 109 99 99 110 100 100 
111 101 91 91 102 92 92 103 93 93 104 94 94 105 95 95 106 96 96 107 97 97 108 98 98 109 99 99 110 100 
100 111 101 91 91 102 92 92 103 93 93 104 94 94 105 95 95 106 96 96 107 97 97 108 98 98 109 99 99 110 
100 100 111 101 91
*/