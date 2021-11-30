import java.io.*;
import java.util.*;

public class HuffmanCompressor
{
	/**
	 * reads a file and stores each character and their respective frequency. Creates a huffman tree and a .code file to 
	 * add a list of character codes used. Then it writes an encoding tree and encodes it into .short
	 * @param fileName - the file to compress
	 */
    public static void compress(String fileName)
    {
    	
        Scanner scan = null;
        try 
        {
        	scan = new Scanner(new File(fileName)); 
        } catch (FileNotFoundException e){}
        
        scan.useDelimiter("");
        
        int[] ascii = new int[256];
        while (scan.hasNext())
        {
        	ascii[scan.next().charAt(0)] += 1;
        }

        String codeFile = "" + fileName.substring(fileName.lastIndexOf("/") + 1, fileName.lastIndexOf('.')) + ".code";
        HuffmanTree tree = new HuffmanTree(ascii);
        tree.write(codeFile);
        tree.encode(fileName, codeFile);
        tree.display();
    }
    /**
     * Takes in the compressed file and decodes it which expands the file
     * into the new file name given
     * @param cFile - codeFile name
     * @param comFile - compressedFile name
     * @param nFile - new file name
     */
    public static void expand(String cFile, String comFile, String nFile)
    {
        HuffmanTree tree = new HuffmanTree(cFile);
        tree.decode(new BitInputStream(comFile), nFile);
    }
}
