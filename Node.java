public class Node<T>
{
	Node left;
	Node right;
	int count = 0;
	Comparable data;
	Node(Comparable item)
	{
		data = item;
	}
}