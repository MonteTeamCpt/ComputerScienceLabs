import java.io.*;
import java.util.*;

class Node implements Comparable<Node>
{
    int val;
    int charVal;
    Node left, right;
 
    public Node(int val, int charVal) 
    {
        this.val = val;
        this.charVal = charVal;
    }
    public int compareTo(Node obj) 
    {
        return val - obj.val;
    }
    public String toString() 
    {
        if (charVal == -1) 
        	return val + "";
        return (char) charVal + "";
    }
}

public class HuffmanTree 
{

    private Node head;
    /**
     * Creates a Huffman tree with the frequency of each character and puts into in a 
     * priority queue so that they can be ordered properly
     * @param count - array of ints 
     */
    public HuffmanTree(int[] count)
    {
        PriorityQueue<Node> huffTree = new PriorityQueue<>();
        for (int i = 0; i < count.length; i++) 
        {
            if (count[i] == 0)
            	continue;
            
            huffTree.offer(new Node(count[i], i));
        }
        huffTree.offer(new Node(1, 256));
        
        while (huffTree.size() > 1)
        {
            Node left = huffTree.poll();
            Node right = huffTree.poll();
            
            Node nNode = new Node(left.val + right.val, -1); 
            
            nNode.left = left;
            nNode.right = right; 
            
            huffTree.offer(nNode); 
        }
        head = huffTree.remove();
    }
    
    /**
     * Secondary constructor that constructs the tree from the given file
     * @param codeFile - the file to read
     */
    public HuffmanTree(String codeFile) 
    {
        Scanner input = null;
        try 
        {
            input = new Scanner(new File(codeFile)); 
        } catch (FileNotFoundException e) {}

        head = new Node(0, -1);
        while (input.hasNextLine()) 
        {
            int val = Integer.parseInt(input.nextLine());
            String code = input.nextLine();
            Node node = head;
            
            for (char c : code.toCharArray()) 
            {
                if (c == '0') 
                {
                    if (node.left == null)
                        node.left = new Node(0, -1);
                    node = node.left; 
                } 
                else
                {
                    if (node.right == null)
                        node.right = new Node(0, -1); 
                    node = node.right; 
                }
            }
            node.charVal = val; 
        }
    }
    
    public void display()
    {
    	TreePrinter.printTree(head);
    }
    
    /**
     * Creates a new output to a file and and gets the decoded message into the passed file
     * to print to
     * @param in - the bitinputstream of the message
     * @param outFile - the file to print to
     */
    public void decode(BitInputStream in, String outFile) 
    {
        PrintWriter writer = null;
        try 
        {
            writer = new PrintWriter(new FileOutputStream(outFile)); //read the file
        } catch (FileNotFoundException e){e.printStackTrace();}
        
        LabelAscii256: while (true)
        {
            int first = in.readBit();
            Node node = first == 0 ? head.left : head.right;
            while (true)
            {
                if (node.left == null && node.right == null) 
                {
                    if (node.charVal == 256) 
                    	break LabelAscii256;
                    writer.print((char)node.charVal); 
                    break;
                }
                node = in.readBit() == 0 ? node.left : node.right;
            }
        }
        in.close(); 
        writer.close();
    }
    
    /**
     * Writes the encoded tree into a file recursively
     * @param fileName - the file to output to
     */
    public void write(String fileName) 
    {
        PrintWriter writer = null;
        try 
        {
            writer = new PrintWriter(new FileOutputStream(fileName));
        } catch (FileNotFoundException e) {e.printStackTrace();}

        write(writer, head, ""); 
        writer.close();
    }
    
    /**
     * Write helper method that recursively changes it to binary
     * @param writer - the file to write to
     * @param node - the node
     * @param binary - the binary string representation
     */
    public void write(PrintWriter writer, Node node, String binary) 
    {
        if (node.right == null && node.left == null)
        {
            writer.println(node.charVal);
            writer.println(binary);
        } 
        else 
        {
            write(writer, node.left, binary + "0"); 
            write(writer, node.right, binary + "1");
        }
    }
    
    /**
     * Encodes the actual file to a binary representation of the chars
     * assigns each char a binary and with the bitoutputstream. Also I use
     * a delimiter to split the file into chars
     * @param inputFile - file to encode
     * @param codeFile - file to output of the encoded version
     */
    public void encode(String inputFile, String codeFile)
    {
        HashMap<Integer, String> charToBinary = new HashMap<>();
        Scanner input = null;
        try 
        {
            input = new Scanner(new File(codeFile)); 
        } catch (FileNotFoundException e) {}

        while (input.hasNextLine()) 
        {
            int val = Integer.parseInt(input.nextLine());
            String code = input.nextLine();
            charToBinary.put(val, code);
        }
        
        BitOutputStream out = new BitOutputStream("" + inputFile.substring(inputFile.lastIndexOf("/") + 1, inputFile.lastIndexOf('.')) + ".short");
        
        try {
            input = new Scanner(new File(inputFile)); 
        } catch (FileNotFoundException e) {}
        
        input.useDelimiter(""); 
        
        while (input.hasNext()) 
        {
            for (char c : charToBinary.get((int) input.next().charAt(0)).toCharArray()) 
            {
                out.writeBit(Character.getNumericValue(c)); 
            }
        }
        
        for (char c : charToBinary.get(256).toCharArray())
        {
            out.writeBit(Character.getNumericValue(c));
        }
        out.close();
    }
}