package interviews.tekion;

/**
 * Flat out the link list, which should be in sorted order.

Node {
	Node next;
  Node down;
  int value;
}
2 -> 5 -> 12 -> 30
|	|	  |		|
4	6	 13		32
|		 |		|
8		31		34

 2 -> 5 -> 12 -> 30
|	|	  |		|
4	15	 13		32
|		 |		|
8		31		34

 2, 4, 5, 8, 12
expected: 2 -> 4 -> 5 -> 6 -> 8 -> 12 -> 13 -> 30 -> 31 -> 32 -> 34

 */
public class Test2 {
}
