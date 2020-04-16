public class BST<T>
{
    Node root;

    public boolean find(Comparable item)
    {
        return find(root, item);
    }

    private boolean find(Node node, Comparable item)
    {
        if (node == null)
        {
            return false;
        }
        if (item.compareTo(node.data) == 0)
        {
            return true;
        }
        if ( item.compareTo(node.data) > 0)
        {
            return find(node.right, item);
        }
        else
        {
           return find(node.left, item);
        }
    }  

    public void insert(Comparable item)
    {
        root = insertNode(item, root);
    }
    private Node insertNode(Comparable item, Node node)
    {
        if (node == null)
        {
            return new Node(item);
        }
        else if (item.compareTo(node.data) == 0)
        {
            node.count++;
        }
        else if (item.compareTo(node.data)>0)
        {
            node.right = insertNode(item, node.right);
        }
        else
        {
            node.left = insertNode(item, node.left);
        }
        return node;
    }

    private void print(Node node)
    {
        if (node != null){
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        }
    }

    public void print()
    {
        print(root);
    }

    public void delete(Comparable item)
    {

        root = delete(root, item);
    }

    private Node delete(Node node, Comparable item)
    {
        if (node == null) return null;
        if (node.data.compareTo(item) == 0)
        {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            if (node.right.left == null)
            {
                node.data = node.right.data;
                node.right = node.right.right;
                return node;
            }
            else node.data = removeMin(node.right);
        }
        else if (node.data.compareTo(item)> 0)
        {
            node.left = delete(node.left, item);
            return node;
        }
        else
        {
            node.right = delete(node.right, item);
        }
        return node;
    }

    private Comparable removeMin(Node node)
    {
        if (node.left.left == null)
        {
            Comparable min = node.left.data;
            node.left = node.left.right;
            return min;
        }
        else return removeMin(node.left);
    } 
}